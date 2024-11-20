document.addEventListener('DOMContentLoaded', () => {
  // Selección de elementos
  const formularioCriatura = document.getElementById('formulario-criatura');
  const crearCriaturaBtn = document.getElementById('crear-criatura-btn');
  const entrenarModeloBtn = document.getElementById('entrenar-modelo-btn');
  const criaturasList = document.getElementById('creaturas-list');
  const cancelarBtn = document.getElementById('cancelar-btn');
  const descargarCsvBtn = document.getElementById('descargar-csv-btn');

  // Mostrar formulario al hacer clic en "Crear criatura"
  crearCriaturaBtn.addEventListener('click', () => {
    formularioCriatura.classList.remove('hidden');
  });

  // Ocultar formulario al hacer clic en "Cancelar"
  cancelarBtn.addEventListener('click', () => {
    formularioCriatura.classList.add('hidden');
  });

  // Enviar datos al endpoint "classify"
  formularioCriatura.querySelector('.btn-primary').addEventListener('click', async (event) => {
    event.preventDefault(); // Prevenir recarga de la página

    const size = document.getElementById('size').value;
    const skinType = document.getElementById('skin-type').value;
    const habitat = document.getElementById('habitat').value;
    const diet = document.getElementById('diet').value;
    const behavior = document.getElementById('behavior').value;

    // Crear el objeto JSON para enviar
    const criaturaData = {
      size,
      skinType,
      habitat,
      diet,
      behavior,
      specie: "" // El backend lo completará
    };

    try {
      // Realizar la petición al endpoint /classify
      const response = await fetch('http://localhost:8080/animals/classify', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(criaturaData)
      });

      if (!response.ok) {
        throw new Error('Error al clasificar la criatura');
      }

      const result = await response.json();

      // Crear la tarjeta de la criatura con la especie clasificada
      const card = document.createElement('div');
      card.className = 'creatura-card';
      card.innerHTML = `
        <h3>Criatura ${result.specie || "Desconocida"}</h3>
        <p><strong>Tamaño:</strong> ${result.size}</p>
        <p><strong>Tipo de piel:</strong> ${result.skinType}</p>
        <p><strong>Hábitat:</strong> ${result.habitat}</p>
        <p><strong>Dieta:</strong> ${result.diet}</p>
        <p><strong>Comportamiento:</strong> ${result.behavior}</p>
        <p><strong>Especie:</strong> ${result.specie}</p>
      `;

      // Añadir la tarjeta a la lista
      criaturasList.appendChild(card);

      // Ocultar el formulario
      formularioCriatura.classList.add('hidden');
    } catch (error) {
      console.error('Error:', error.message);
      alert('Hubo un error al clasificar la criatura.');
    }
  });

  // Botón para subir un archivo CSV al backend
  entrenarModeloBtn.addEventListener('click', async () => {
    const fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.accept = '.csv';
    fileInput.style.display = 'none';
    document.body.appendChild(fileInput);
  
    // Simular clic para abrir el selector de archivos
    fileInput.click();
  
    fileInput.addEventListener('change', async () => {
      const file = fileInput.files[0];
  
      if (!file) {
        alert('Por favor selecciona un archivo.');
        return;
      }
  
      const formData = new FormData();
      formData.append('file', file); // La clave debe coincidir con el backend
  
      try {
        const response = await fetch('http://localhost:8080/animals/upload', {
          method: 'POST',
          body: formData // No necesitas headers manuales aquí
        });
  
        if (!response.ok) {
          throw new Error('Error al subir el archivo CSV');
        }
  
        const result = await response.json();
        alert(`Archivo subido exitosamente: ${JSON.stringify(result)}`);
      } catch (error) {
        console.error('Error:', error.message);
        alert('Hubo un error al subir el archivo.');
      } finally {
        fileInput.remove(); // Limpiar el input del DOM
      }
    });
  });
  

  // Descargar datos como CSV
  descargarCsvBtn.addEventListener('click', () => {
    window.location.href = 'http://localhost:8080/animals/download'; // Ajusta este endpoint según tu backend
  });
});
