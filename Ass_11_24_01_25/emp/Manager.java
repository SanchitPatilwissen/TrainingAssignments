package emp;

final class Manager extends Employee {
    Manager(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 100000, designation, id);
    }

    void raiseSalary() {
        salary += 15000;

    }
}