// Load module pages dynamically
const menuItems = document.querySelectorAll('.sidebar-menu li');
const contentArea = document.getElementById('content-area');

menuItems.forEach(item => {
    item.addEventListener('click', () => {
        const page = item.getAttribute('data-page');
        fetch(page)
            .then(res => res.text())
            .then(html => contentArea.innerHTML = html)
            .catch(err => contentArea.innerHTML = '<p>Error loading page.</p>');
    });
});

// Buttons
function goToWebsite() {
    window.open('https://www.nsbm.ac.lk/', '_blank');
}

function logout() {
    alert("Logged out successfully!");
}
