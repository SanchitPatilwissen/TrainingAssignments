package com.example.demo;

import java.util.Comparator;

class IDSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Integer(s1.getId()).compareTo(s2.getId());
    }
}
