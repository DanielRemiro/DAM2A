function SearchBar({ query, setQuery }) {
  return (
    <div >
      <input
        type="text"
        placeholder="Busca una localización (ej: Earth)..."
        value={query}
        onChange={(e) => setQuery(e.target.value)}
      />
    </div>
  );
}

export default SearchBar;