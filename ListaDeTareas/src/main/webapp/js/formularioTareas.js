document.addEventListener('DOMContentLoaded', function () {
    const nombre = document.getElementById('nombre');
    const descripcion = document.getElementById('descripcion');
    const fecha = document.getElementById('fecha');
    const registrar = document.getElementById('registrar');

    registrar.addEventListener('click', function (event) {
        event.preventDefault();
        let form = document.getElementById("registroTarea");
        if (
            nombre.value.trim() === "" ||
            descripcion.value.trim() === "" ||
            fecha.value === ""
        ) {
            Swal.fire({
                icon: "warning",
                title: "Oops...",
                text: "Por favor, complete todos los campos obligatorios."
            });
        } else {
            Swal.fire({
                title: "¿Desea guardar los cambios?",
                showDenyButton: true,
                showCancelButton: false,
                confirmButtonText: "Guardar",
                denyButtonText: `No guardar`
            }).then((result) => {
                if (result.isConfirmed) {
                        form.submit();
                } else if (result.isDenied) {
                    Swal.fire("Los cambios no se han guardado", "", "error").then(() => {
                    });
                }
            });
        }
    });
});
/*
const errorElement = document.getElementById('error');
const rutaElement = document.getElementById('ruta');
if (errorElement && rutaElement) {
    const errorMessage = errorElement.value;
    const ruta = rutaElement.value;
    if (errorMessage && ruta) {
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: errorMessage
        }).then(() => {
            window.location.href = ruta;
        });
    }
}*/