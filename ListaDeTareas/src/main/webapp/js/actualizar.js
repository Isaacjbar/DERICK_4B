document.addEventListener('DOMContentLoaded', function () {
    const cambiarButton = document.getElementById('cambiarButton');

    cambiarButton.addEventListener('click', function (event) {
        event.preventDefault();
        let form = document.getElementById("cambiarForm");
        Swal.fire({
            title: "¿Desea marcar como hecha la tarea?",
            showDenyButton: true,
            showCancelButton: false,
            confirmButtonText: "Sí",
            denyButtonText: `No`
        }).then((result) => {
            if (result.isConfirmed) {
                form.submit();
            } else if (result.isDenied) {
                Swal.fire("No se completó la tarea", "", "error").then(() => {
                });
            }
        });
    });
});