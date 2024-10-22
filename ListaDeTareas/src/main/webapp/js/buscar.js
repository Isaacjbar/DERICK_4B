document.addEventListener('DOMContentLoaded', function () {

    const tarea = document.getElementById('tarea');
    const buscarButton = document.getElementById('buscarButton');
    const errorElement = document.getElementById('error');
    const typeElement = document.getElementById('tipo');

    buscarButton.addEventListener('click', function (event) {
        event.preventDefault();
        let form = document.getElementById("buscarForm");
        if (tarea.value.trim() === "") {
            Swal.fire({
                icon: "warning",
                title: "Oops...",
                text: "Por favor, complete todos los campos obligatorios."
            });
        } else {
            form.submit();
        }
    });

    if (errorElement && typeElement) {
        const errorMessage = errorElement.value;
        const typeMessage = typeElement.value;
        if (typeMessage === "Éxito" && errorMessage) {
            Swal.fire({
                icon: 'success',
                title: typeMessage,
                text: errorMessage
            });
        } else {
            Swal.fire({
                icon: 'error',
                title: typeMessage,
                text: errorMessage
            });
        }
    }
});