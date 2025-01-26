package emp;

final class Programmer extends Employee {
    Programmer(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 30000, designation, id);
    }

    void raiseSalary() {
        salary += 5000;
    }
}
