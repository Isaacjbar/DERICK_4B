// Obtener elementos
const crearCriaturaBtn = document.getElementById('crear-criatura-btn');
const formularioCriatura = document.getElementById('formulario-criatura');
const cancelarBtn = document.getElementById('cancelar-btn');
const entrenarModeloBtn = document.getElementById('entrenar-modelo-btn');
const descargarCsvBtn = document.getElementById('descargar-csv-btn');
const criaturasList = document.getElementById('creaturas-list');

// Mostrar el formulario
crearCriaturaBtn.addEventListener('click', () => {
  formularioCriatura.classList.remove('hidden');
});

// Ocultar el formulario
cancelarBtn.addEventListener('click', () => {
  formularioCriatura.classList.add('hidden');
});

// Agregar criatura al hacer clic en "Crear"
formularioCriatura.querySelector('.btn-primary').addEventListener('click', () => {
  const size = document.getElementById('size').value;
  const skinType = document.getElementById('skin-type').value;
  const habitat = document.getElementById('habitat').value;
  const diet = document.getElementById('diet').value;
  const behavior = document.getElementById('behavior').value;

  // Crear la tarjeta de la criatura
  const card = document.createElement('div');
  card.className = 'creatura-card';
  card.innerHTML = `
    <h3>Criatura ${size}</h3>
    <p><strong>Tamaño:</strong> ${size}</p>
    <p><strong>Tipo de piel:</strong> ${skinType}</p>
    <p><strong>Hábitat:</strong> ${habitat}</p>
    <p><strong>Dieta:</strong> ${diet}</p>
    <p><strong>Comportamiento:</strong> ${behavior}</p>
  `;

  // Añadir la tarjeta a la lista
  criaturasList.appendChild(card);

  // Ocultar el formulario
  formularioCriatura.classList.add('hidden');
});
