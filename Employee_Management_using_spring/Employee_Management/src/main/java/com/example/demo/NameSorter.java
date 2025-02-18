package com.example.demo;

import java.util.Comparator;

class NameSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return s1.getName().compareTo(s2.getName());
    }
}