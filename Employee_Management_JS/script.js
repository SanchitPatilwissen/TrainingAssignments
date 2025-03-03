addComponent = document.getElementById("add");
displayComponent = document.getElementById("display");
searchComponent = document.getElementById("search");
updateComponent = document.getElementById("update");
removeComponent = document.getElementById("remove");

class Employee {
    constructor(name, age, salary, designation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }
}

var employees = [];

document.getElementById("add").addEventListener("click", function () {
    let text = `
        <div class="login-container">
                <h2>Add Employee</h2>
                <form class="add-form" name="add-form" id="add-form">
                    <div class="form-group">
                        <label for="Name">Name</label>
                        <input type="text" id="name" name="name" required>
                    </div>
                    <div class="form-group">
                        <label for="Age">Age</label>
                        <input type="number" id="age" name="age" min="21" max="60" required>
                    </div>
                    <div class="form-group">
                        <label for="Salary">Salary</label>
                        <input type="number" id="salary" name="salary" min="0" required>
                    </div>
                    <div class="form-group">
                        <label for="Designation">Designation</label>
                        <select id="Designation" class="designation" name="designation" required>
                            <option value="" disabled selected>Select Designation</option>
                            <option value="programmar">Programmar</option>
                            <option value="tester">Tester</option>
                            <option value="manager">Manager</option>
                            <option value="clerk">Clerk</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <button type="submit">Add</button>
                    </div>
                </form>
            </div>
    `;

    document.getElementById("main-content").innerHTML = text;

    document.getElementById("add-form").addEventListener("submit", formSubmit);
});

displayComponent.addEventListener("click", function () {
    display();
});

function formSubmit(event) {
    event.preventDefault();
    employees.push(new Employee(
        document.forms["add-form"]["name"].value,
        parseInt(document.forms["add-form"]["age"].value),
        parseInt(document.forms["add-form"]["salary"].value),
        document.forms["add-form"]["designation"].value,
    )
    );
    console.log(employees);
    document.forms["add-form"].reset();
    alert("Employee Added successfully");
};

function display() {
    let text = `
        <h2>EMPLOYEES</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Designation</th>
                </tr>
            </thead>
            <tbody>`;

    for (var i = 0; i < employees.length; i++) {
        text += `
            <tr>
                <td>${i + 1}</td>
                <td>${employees[i].name}</td>
                <td>${employees[i].age}</td>
                <td>${employees[i].salary}</td>
                <td>${employees[i].designation}</td>
            </tr>`;
    }

    text += `</tbody></table>`;

    document.getElementById('main-content').innerHTML = text;
}

searchComponent.addEventListener("click", function () {
    if (employees.length == 0) {
        let text = `
            <div class="login-container">
                    <h2>Search Employee</h2>
                    <h4>There are no employees present</h4>
                </div>
        `;
        document.getElementById("main-content").innerHTML = text;
    }
    else {
        let text = `
            <div class="login-container">
                    <h2>Search Employee</h2>
                    <form class="add-form" name="add-form" id="add-form">
                        <div class="form-group">
                            <label for="Name">Enter ID</label>
                            <input type="number" id="id" name="id" min="1" max="${employees.length}" placeholder="Value must be from 1 - ${employees.length}" required>
                        </div>
                        <div class="form-group">
                            <button type="submit">Search</button>
                        </div>
                    </form>
                </div>
        `;

        document.getElementById("main-content").innerHTML = text;

        document.getElementById("add-form").addEventListener("submit", searchEmployee);
    }
})

function searchEmployee(event) {
    event.preventDefault();
    let id = parseInt(document.forms["add-form"]["id"].value);
    let text = `
        <br><br>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Salary</th>
                    <th>Designation</th>
                </tr>
            </thead>
            <tbody>`;
    text += `
            <tr>
                <td>${id}</td>
                <td>${employees[id-1].name}</td>
                <td>${employees[id-1].age}</td>
                <td>${employees[id-1].salary}</td>
                <td>${employees[id-1].designation}</td>
            </tr>`;

    text += `</tbody></table>`;

    document.getElementById("main-content").innerHTML = text;
}