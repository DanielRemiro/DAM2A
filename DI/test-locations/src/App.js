import { useState, useEffect } from "react";
// Importamos nuestros nuevos componentes
import SearchBar from "./SearchBar";
import LocationList from "./LocationList";
import ResidentList from "./ResidentList";
import CharacterModal from "./CharacterModal";

function App() {
  // --- ESTADOS ---
  const [query, setQuery] = useState("");
  const [locations, setLocations] = useState([]);
  const [selectedLocation, setSelectedLocation] = useState(null);
  const [residents, setResidents] = useState([]);
  const [selectedChar, setSelectedChar] = useState(null);
  const [loadingResidents, setLoadingResidents] = useState(false); // Nuevo estado de carga

  // --- EFECTO: BUSCAR LOCALIZACIONES ---
  useEffect(() => {
    const fetchLocations = async () => {
      if (query.length < 3) {
        setLocations([]); // Limpiar si borran el texto
        return;
      }
      try {
        const res = await fetch(`https://rickandmortyapi.com/api/location/?name=${query}`);
        const data = await res.json();
        setLocations(data.results || []);
      } catch (error) {
        setLocations([]);
      }
    };

    const timeoutId = setTimeout(fetchLocations, 500);
    return () => clearTimeout(timeoutId);
  }, [query]);

  // --- LOGICA: CARGAR RESIDENTES ---
  const handleLocationSelect = async (location) => {
    setSelectedLocation(location);
    setResidents([]);
    setLoadingResidents(true); // Empieza a cargar

    // Extraemos las URLs y hacemos las peticiones
    const promises = location.residents.map((url) => fetch(url).then((res) => res.json()));
    const data = await Promise.all(promises);

    setResidents(data);
    setLoadingResidents(false); // Termina de cargar
  };

  return (
    <div>
      <h1>Rick & Morty Explorer 🛸</h1>
      
      {/* Componente Buscador */}
      <SearchBar query={query} setQuery={setQuery} />

      <div>
        
        {/* Componente Lista Izquierda */}
        <LocationList 
          locations={locations} 
          onSelectLocation={handleLocationSelect} 
          selectedLocation={selectedLocation} 
        />

        {/* Componente Lista Derecha */}
        <ResidentList 
          residents={residents} 
          locationName={selectedLocation?.name} 
          onSelectCharacter={setSelectedChar}
          loading={loadingResidents}
        />
        
      </div>

      {/* Componente Modal */}
      <CharacterModal 
        character={selectedChar} 
        onClose={() => setSelectedChar(null)} 
      />
    </div>
  );
}

export default App;