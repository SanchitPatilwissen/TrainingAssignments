var employees = [];

class Employee {
    constructor(name, age, salary, designation) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
    }
}

document.querySelector(".add-form").addEventListener("submit", function(event) {
    event.preventDefault();
    employees.push(new Employee(
            document.forms["add-form"]["name"].value, 
            parseInt(document.forms["add-form"]["age"].value),
            parseInt(document.forms["add-form"]["salary"].value),
            document.forms["add-form"]["designation"].value, 
        )
    );
    console.log(employees);
});

export function display() {
    let text = "";
    for(var i=0;i<employees.size();i++){
        text = text + "<li>";
        text = text + `${employees[i].name}, ${employees[i].age}, ${employees[i].salary}, ${employees[i].designation}`;
        text = text + "<li>";
    }
    document.querySelector('.display_employees').innerHTML = text;
}
