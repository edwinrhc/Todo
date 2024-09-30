async function fetchProtectedData() {
    const token = localStorage.getItem("jwtToken");

    if (token) {
        const response = await fetch("/get", {
            method: "GET",
            headers: {
                "Authorization": "Bearer " + token, // Incluir el token en la cabecera
                "Content-Type": "application/json"
            }
        });

        if (response.ok) {
            const data = await response.json();
            console.log("Datos protegidos:", data);
            // Mostrar los datos en el dashboard
        } else {
            console.error("No autorizado o error en la solicitud");
            // Redirigir a la página de login si no está autorizado
            window.location.href = "/login";
        }
    } else {
        // Si no hay token, redirigir al login
        window.location.href = "/login";
    }
}

document.addEventListener("DOMContentLoaded", function() {
    fetchProtectedData(); // Llamar a la función al cargar el dashboard
});




function toggleMenu() {
    var menu = document.getElementById('userMenu');
    menu.classList.toggle('hidden');
}