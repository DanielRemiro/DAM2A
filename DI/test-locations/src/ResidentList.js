function ResidentList({ residents, locationName, onSelectCharacter, loading }) {
  if (!locationName) return <p>Selecciona una localización para ver detalles.</p>;

  return (
    <div>
      <h3>Habitantes de: {locationName}</h3>
      
      {loading ? (
        <p>Cargando residentes...</p>
      ) : residents.length === 0 ? (
        <p>Nadie vive aquí 🦗</p>
      ) : (
        <div >
          {residents.map((char) => (
            <div
              key={char.id}
              onClick={() => onSelectCharacter(char)}
              
            >
              <img
                src={char.image}
                alt={char.name}
                
              />
              <p ></p>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default ResidentList;