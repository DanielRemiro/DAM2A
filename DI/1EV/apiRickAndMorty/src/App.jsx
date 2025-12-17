import React, { useState } from 'react'

function App() {
  const [query, setQuery] = useState('')
  const [results, setResults] = useState([])
  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(null)

  async function search(e) {
    e && e.preventDefault()
    const name = query.trim()
    if (!name) {
      setResults([])
      setError(null)
      return
    }

    setLoading(true)
    setError(null)
    setResults([])

    try {
      const res = await fetch(`https://rickandmortyapi.com/api/character/?name=${encodeURIComponent(name)}`)
      if (!res.ok) {
        if (res.status === 404) {
          setResults([])
          setError('No se encontraron personajes')
        } else {
          throw new Error('Error en la petición')
        }
        setLoading(false)
        return
      }

      const data = await res.json()
      setResults(data.results || [])
    } catch (err) {
      setError(err.message || 'Error desconocido')
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="app-container">
      <header>
        <h1>Rick and Morty — Buscador</h1>
      </header>

      <main>
        <form className="search-form" onSubmit={search}>
          <input
            aria-label="Buscar personaje"
            placeholder="Escribe el nombre de un personaje (ej: Rick)"
            value={query}
            onChange={(e) => setQuery(e.target.value)}
          />
          <button type="submit">Buscar</button>
        </form>

        {loading && <p className="info">Buscando...</p>}
        {error && <p className="error">{error}</p>}

        <section className="results">
          {results.map((char) => (
            <article key={char.id} className="card">
              <img src={char.image} alt={char.name} />
              <div className="card-body">
                <h3>{char.name}</h3>
                <p><strong>Estado:</strong> {char.status}</p>
                <p><strong>Especie:</strong> {char.species}</p>
                <p><strong>Origen:</strong> {char.origin?.name}</p>
              </div>
            </article>
          ))}
        </section>

        {!loading && !error && results.length === 0 && query.trim().length > 0 && (
          <p className="info">No hay resultados para "{query}"</p>
        )}
      </main>

      <footer>
        <p>Datos desde <a href="https://rickandmortyapi.com/">rickandmortyapi.com</a></p>
      </footer>
    </div>
  )
}

export default App
