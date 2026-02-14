document.addEventListener("DOMContentLoaded", () => {
    const loginBtn = document.getElementById("loginBtn");
    if (!loginBtn) return;

    loginBtn.textContent = "Login";
    loginBtn.onclick = () => {
        window.location.href = "login.html";
    };
});
