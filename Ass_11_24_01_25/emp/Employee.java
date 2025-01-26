package emp;

import java.io.*;

abstract class Employee implements Serializable {
    private int emp_id;
    private String name;
    private int age;
    double salary;
    private Designation designation;

    Employee(String var1, int var2, double var3, Designation var4, int var5) throws Exception {
        if (!(this instanceof Ceo) && Ceo.isCeoNotThere()) {
            throw new Exception();
        }

        this.name = var1;
        this.age = var2;
        this.salary = var3;
        this.designation = var4;
        this.emp_id = var5;

    }

    final int getId() {
        return this.emp_id;
    }

    final String getName() {
        return this.name;
    }

    final double getSalary() {
        return this.salary;
    }

    final int getAge() {
        return this.age;
    }

    final Designation getDesignation() {
        return this.designation;
    }

    final void update(String name, int age){
        this.name = name;
        this.age = age;
    }

    final void display() {
        System.out.println("The following are the details of this Employee : \nName : " + this.name + "\nAge : "
                + this.age + "\nSalary : " + this.salary + "\nDesignation : " + this.designation);
    }

    void setSalary(){
        if(this instanceof Ceo) salary = 1000000;
    }

    abstract void raiseSalary();
}
