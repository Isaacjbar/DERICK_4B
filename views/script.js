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

    // Obtener el valor de "size" y asegurarse de que esté en el formato correcto (dos decimales)
    const size = parseFloat(document.getElementById('size').value).toFixed(2); // Redondear a dos decimales

    // Obtener los valores de las propiedades binarias (0 o 1)
    const hasFur = document.querySelector('input[name="hasFur"]:checked').value;
    const isAquatic = document.querySelector('input[name="isAquatic"]:checked').value;
    const isCarnivore = document.querySelector('input[name="isCarnivore"]:checked').value;
    const isNocturnal = document.querySelector('input[name="isNocturnal"]:checked').value;
    const hasWings = document.querySelector('input[name="hasWings"]:checked').value;
    const isDomesticated = document.querySelector('input[name="isDomesticated"]:checked').value;
    const isEndangered = document.querySelector('input[name="isEndangered"]:checked').value;
    const hasClaws = document.querySelector('input[name="hasClaws"]:checked').value;
    const canFly = document.querySelector('input[name="canFly"]:checked').value;

    // Crear el objeto JSON para enviar
    const criaturaData = {
      size,
      hasFur: parseInt(hasFur), // Convertir los valores a números enteros (1 o 0)
      isAquatic: parseInt(isAquatic),
      isCarnivore: parseInt(isCarnivore),
      isNocturnal: parseInt(isNocturnal),
      hasWings: parseInt(hasWings),
      isDomesticated: parseInt(isDomesticated),
      isEndangered: parseInt(isEndangered),
      hasClaws: parseInt(hasClaws),
      canFly: parseInt(canFly),
      specie: 0 // El backend lo completará con el número de especie
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
      console.log(result);

      // Definir el objeto SPECIES para la clasificación
      const SPECIES = {
        1: "Mammal",
        2: "Bird",
        3: "Reptile",
        4: "Fish",
        5: "Amphibian",
        6: "Insect"
        // Puedes seguir añadiendo más especies según sea necesario.
      };

      // Crear la tarjeta de la criatura con la especie clasificada
      const card = document.createElement('div');
      card.className = 'creatura-card';

      // Obtener la especie desde el objeto SPECIES, o "Especie desconocida" si no existe
      const especie = SPECIES[result.specie] || "Especie desconocida";  // Uso de SPECIES para obtener el nombre

      // Mostrar las propiedades adicionales según el nuevo objeto
      card.innerHTML = `
        <h3>Criatura ${especie}</h3>
        <p><strong>Tamaño:</strong> ${result.size} metros</p>
        <p><strong>Tipo de piel:</strong> ${result.hasFur ? "Peluda" : "Sin pelaje"}</p>
        <p><strong>Habilidad de volar:</strong> ${result.canFly ? "Sí" : "No"}</p>
        <p><strong>Posee garras:</strong> ${result.hasClaws ? "Sí" : "No"}</p>
        <p><strong>Tiene alas:</strong> ${result.hasWings ? "Sí" : "No"}</p>
        <p><strong>Es acuática:</strong> ${result.isAquatic ? "Sí" : "No"}</p>
        <p><strong>Es carnívora:</strong> ${result.isCarnivore ? "Sí" : "No"}</p>
        <p><strong>Es domesticada:</strong> ${result.isDomesticated ? "Sí" : "No"}</p>
        <p><strong>Especie en peligro:</strong> ${result.isEndangered ? "Sí" : "No"}</p>
        <p><strong>Es nocturna:</strong> ${result.isNocturnal ? "Sí" : "No"}</p>
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
