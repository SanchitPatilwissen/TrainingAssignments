package com.example.demo;

import java.util.Comparator;

class SalarySorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Double(s1.getSalary()).compareTo(s2.getSalary()) * -1;
    }
}