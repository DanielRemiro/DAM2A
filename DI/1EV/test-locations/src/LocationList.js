function LocationList({ locations, onSelectLocation, selectedLocation }) {
  if (locations.length === 0) return <p>No hay resultados.</p>;

  return (
    <div>
      <h3>Resultados</h3>
      <ul>
        {locations.map((loc) => (
          <li
            key={loc.id}
            onClick={() => onSelectLocation(loc)}
          >
            <strong>{loc.name}</strong>
            <br />
            <small>{loc.type}</small>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default LocationList;