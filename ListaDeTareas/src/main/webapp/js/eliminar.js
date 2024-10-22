document.addEventListener('DOMContentLoaded', function () {
    const eliminarButton = document.getElementById('eliminarButton');

    eliminarButton.addEventListener('click', function (event) {
        event.preventDefault();
        let form = document.getElementById("eliminarForm");
            Swal.fire({
                title: "¿Desea eliminar la tarea?",
                showDenyButton: true,
                showCancelButton: false,
                confirmButtonText: "Eliminar",
                denyButtonText: `No eliminar`
            }).then((result) => {
                if (result.isConfirmed) {
                    form.submit();
                } else if (result.isDenied) {
                    Swal.fire("No se eliminó la tarea", "", "error").then(() => {
                    });
                }
            });
    });
});