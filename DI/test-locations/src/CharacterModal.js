function CharacterModal({ character, onClose }) {
  if (!character) return null;

  return (
    <div
      onClick={onClose} // Cerrar al clicar el fondo oscuro
      
    >
      <div
        onClick={(e) => e.stopPropagation()} // Evitar que el clic dentro cierre el modal
    
      >
        <img src={character.image} alt={character.name} />
        <h2>{character.name}</h2>
        <p><strong>Estado:</strong> {character.status}</p>
        <p><strong>Especie:</strong> {character.species}</p>
        <button onClick={onClose}>Cerrar</button>
      </div>
    </div>
  );
}

export default CharacterModal;