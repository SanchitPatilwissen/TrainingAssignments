package com.example.demo;

import java.util.Comparator;

class AgeSorter implements Comparator<Employee> {
    public int compare(Employee s1, Employee s2) {
        return new Integer(s1.getAge()).compareTo(s2.getAge());
    }
}
