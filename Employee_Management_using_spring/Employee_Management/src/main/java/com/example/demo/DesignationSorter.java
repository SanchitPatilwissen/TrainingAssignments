package com.example.demo;

import java.util.Comparator;

class DesignationSorter implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getDesignation().compareTo(e2.getDesignation());
    }
}