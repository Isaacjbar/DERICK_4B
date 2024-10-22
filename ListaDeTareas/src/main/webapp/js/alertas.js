document.addEventListener('DOMContentLoaded', function () {
    const errorElement = document.getElementById('error');
    const typeElement = document.getElementById('tipo');
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