package emp;

final class Clerk extends Employee {
    Clerk(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 20000, designation, id);
    }

    void raiseSalary() {
        salary += 2000;
    }
}
