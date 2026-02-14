document.addEventListener("DOMContentLoaded", () => {
    const loginBtn = document.getElementById("loginBtn");
    if (!loginBtn) return;

    fetch("/users/me")
        .then(res => {
            if (!res.ok) throw new Error("Not logged in");
            return res.json();
        })
        .then(user => {
            localStorage.setItem("loggedUser", JSON.stringify(user));
            if (user.username) {
                loginBtn.textContent = user.username;
                loginBtn.onclick = () => {
                    window.location.href = "profile.html";
                };
            }
        })
        .catch(() => {
            localStorage.removeItem("loggedUser");
            window.location.href = "../login/login.html";
        });
});
