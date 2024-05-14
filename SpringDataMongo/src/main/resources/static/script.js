document.addEventListener("DOMContentLoaded", function() {
    const employeeForm = document.getElementById("employeeForm");
    const employeeList = document.getElementById("employees");

    employeeForm.addEventListener("submit", function(event) {
        event.preventDefault();
        
        const id = document.getElementById("id").value;
        const name = document.getElementById("name").value;
        const email = document.getElementById("email").value;
        const location = document.getElementById("location").value;

        const employee = {
            id: id,
            name: name,
            email: email,
            location: location
        };

        fetch('/saveEmployee', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(employee),
        })
        .then(response => response.text())
        .then(data => {
            alert(data);
            employeeForm.reset();
            displayEmployees();
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    });

    function displayEmployees() {
        fetch('/displayAll')
        .then(response => response.json())
        .then(data => {
            employeeList.innerHTML = "";
            data.forEach(employee => {
                const li = document.createElement("li");
        
                employeeList.appendChild(li);
            });
        })
        .catch((error) => {
            console.error('Error:', error);
        });
    }

    displayEmployees();
});