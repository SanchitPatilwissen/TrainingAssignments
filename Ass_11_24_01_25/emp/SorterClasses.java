package emp;

import java.util.*;

class NameSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return s1.getName().compareTo(s2.getName());
    }
}

class IDSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Integer(s1.getId()).compareTo(s2.getId());
    }
}

class SalarySorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Double(s1.getSalary()).compareTo(s2.getSalary()) * -1;
    }
}

class AgeSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Integer(s1.getAge()).compareTo(s2.getAge());
    }
}

class DesignationSorter implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getDesignation().compareTo(e2.getDesignation());
    }
}

public class SorterClasses {
    
}
