// Toggle the visibility of the menu on mobile devices
const menuIcon = document.getElementById('menu-icon');
const menu = document.getElementById('menu');

menuIcon.addEventListener('click', () => {
    menu.classList.toggle('show');
});

// Start quiz function for the Java button
function startQuiz(quiztype) {
    alert(`Starting ${quiztype.charAt(0).toUpperCase() + quiztype.slice(1)} Quiz!`);
    window.location.href = `${quiztype}-quiz.html`;
}

document.addEventListener("DOMContentLoaded", () => {
    
    const getStartedButton = document.querySelector(".button a");
    const logoutButton = document.querySelector(".logout a");

    // Function to check login status
    async function checkLoginStatus() {
        try {
            const response = await fetch('http://localhost:8086/api/auth/check-login', {
                method: 'GET',
                credentials: 'include', // Include cookies for session management
            });
            const data = await response.json();
            return data.isLoggedIn; // Backend should return a key `isLoggedIn: true/false`
        } catch (error) {
            console.error("Error checking login status:", error);
            return false;
        }
    }

    // Redirect based on login status when "Let's Get Started" is clicked
    getStartedButton.addEventListener("click", async (event) => {
        event.preventDefault();
        const isLoggedIn = await checkLoginStatus();
        if (isLoggedIn) {
            window.location.href = "GetStarted.html"; // Redirect to Get Started page
        } else {
            window.location.href = "login.html"; // Redirect to Login page
        }
    });

    // Logout functionality
    logoutButton.addEventListener("click", async (event) => {
        event.preventDefault();
        try {
            const response = await fetch('http://localhost:8086/api/auth/logout', {
                method: 'POST',
                credentials: 'include',
            });
            if (response.ok) {
                alert("Logged out successfully!");
                window.location.href = "login.html"; // Redirect to login page
            } else {
                alert("Logout failed. Please try again.");
            }
        } catch (error) {
            console.error("Error logging out:", error);
            alert("An error occurred while logging out. Please try again.");
        }
    });
});

