# Rick and Morty — Buscador (React + Vite)

Proyecto mínimo que realiza llamadas a la API pública de Rick and Morty y muestra un buscador de personajes.

Requisitos
- Node.js (>=16) y npm

Instalación
```bash
cd /home/remi/GITHUB/DAM2A/DI/apiRickAndMorty
npm install
```

Ejecución en desarrollo
```bash
npm run dev
# Abrir la URL que muestre Vite (por defecto http://localhost:5173)
```

Construir para producción
```bash
npm run build
npm run preview
```

Archivos relevantes
- `index.html` — entrada HTML
- `src/main.jsx` — bootstrap React
- `src/App.jsx` — componente principal con buscador y llamadas a la API
- `src/styles.css` — estilos simples

Notas
- La app usa la API pública en `https://rickandmortyapi.com/`.
- Si quieres, puedo añadir debounce al input o paginación.
