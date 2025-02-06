package Assignment_06_02_25;

import java.util.*;
import java.util.stream.*;

public class Main {
    static List<Student> list = new ArrayList<Student>();

    static void addStudents(){
        list.add(new Student(1, "Rishabh", 10, 5, "DPS", Gender.MALE, 89, 10000, 90000));
        list.add(new Student(2, "Sania", 8, 3, "BSS", Gender.FEMALE, 78, 10000, 190000));
        list.add(new Student(3, "Harry", 6, 1, "KV", Gender.MALE, 23, 0, 10000));
        list.add(new Student(4, "Ron", 7, 2, "KV", Gender.MALE, 33, 10000, 0));
        list.add(new Student(5, "Hemangi", 15, 10, "DPS", Gender.FEMALE, 98, 100000, 0));
        list.add(new Student(6, "Shaan", 13, 8, "GSW", Gender.MALE, 71, 10000, 40000));
        list.add(new Student(7, "Shreya", 14, 5, "Ryan", Gender.FEMALE, 42, 0, 30000));
        list.add(new Student(8, "Aakash", 16, 12, "DPS", Gender.MALE, 67, 50000, 20000));
        list.add(new Student(9, "Priya", 9, 4, "BSS", Gender.FEMALE, 85, 20000, 15000));
        list.add(new Student(10, "Karan", 11, 6, "GSW", Gender.MALE, 92, 30000, 10000));
        list.add(new Student(11, "Nisha", 13, 7, "Ryan", Gender.FEMALE, 77, 15000, 20000));
        list.add(new Student(12, "Vikram", 12, 6, "KV", Gender.MALE, 54, 0, 25000));
        list.add(new Student(13, "Neha", 10, 5, "DPS", Gender.FEMALE, 81, 10000, 12000));
        list.add(new Student(14, "Manish", 14, 9, "Sapphire", Gender.MALE, 60, 20000, 30000));
        list.add(new Student(15, "Reena", 15, 10, "Ryan", Gender.FEMALE, 95, 25000, 0));
        list.add(new Student(16, "Sam", 17, 12, "DPS", Gender.MALE, 65, 50000, 15000));
        list.add(new Student(17, "Sanya", 11, 5, "BSS", Gender.FEMALE, 73, 5000, 20000));
        list.add(new Student(18, "Arjun", 14, 8, "Sapphire", Gender.MALE, 83, 20000, 30000));
        list.add(new Student(19, "Mansi", 9, 3, "KV", Gender.FEMALE, 74, 15000, 8000));
        list.add(new Student(20, "Kritika", 16, 11, "Ryan", Gender.FEMALE, 88, 40000, 20000));
        list.add(new Student(21, "Siddharth", 12, 6, "DPS", Gender.MALE, 90, 30000, 5000));
        list.add(new Student(22, "Amit", 13, 7, "GSW", Gender.MALE, 79, 25000, 12000));
        list.add(new Student(23, "Tanvi", 8, 4, "Sapphire", Gender.FEMALE, 69, 12000, 10000));
        list.add(new Student(24, "Ravi", 10, 5, "Ryan", Gender.MALE, 77, 8000, 22000));
        list.add(new Student(25, "Neeraj", 14, 9, "KV", Gender.MALE, 72, 10000, 40000));
        list.add(new Student(26, "Anjali", 13, 7, "DPS", Gender.FEMALE, 65, 15000, 15000));
        list.add(new Student(27, "Vishal", 16, 11, "Sapphire", Gender.MALE, 58, 20000, 22000));
        list.add(new Student(28, "Pooja", 9, 4, "Ryan", Gender.FEMALE, 62, 0, 15000));
        list.add(new Student(29, "Raj", 12, 6, "BSS", Gender.MALE, 80, 25000, 5000));
        list.add(new Student(30, "Shivani", 11, 5, "DPS", Gender.FEMALE, 93, 15000, 7000));
        list.add(new Student(31, "Sohail", 14, 8, "GSW", Gender.MALE, 67, 30000, 25000));
        list.add(new Student(32, "Ritika", 13, 7, "Sapphire", Gender.FEMALE, 75, 20000, 10000));
        list.add(new Student(33, "Aditya", 12, 6, "Ryan", Gender.MALE, 81, 35000, 15000));
        list.add(new Student(34, "Madhavi", 15, 10, "DPS", Gender.FEMALE, 96, 50000, 0));
        list.add(new Student(35, "Tarun", 11, 5, "Sapphire", Gender.MALE, 79, 7000, 12000));
        list.add(new Student(36, "Neelam", 13, 7, "KV", Gender.FEMALE, 87, 30000, 5000));
        list.add(new Student(37, "Kunal", 14, 8, "BSS", Gender.MALE, 88, 20000, 20000));
        list.add(new Student(38, "Pranjal", 16, 11, "GSW", Gender.MALE, 61, 45000, 25000));
        list.add(new Student(39, "Tanya", 9, 4, "Ryan", Gender.FEMALE, 66, 10000, 8000));
        list.add(new Student(40, "Rajesh", 14, 9, "Sapphire", Gender.MALE, 74, 40000, 10000));
    }
    public static void main(String[] args) {
        addStudents();

        System.out.println("---------------------------------------------------------------------------");
        
        System.out.println("1) Number of students in each standard?");
        Map<Integer, Long> m4 = list.stream().collect(Collectors.groupingBy(e->e.getStandard(), Collectors.counting()));
        System.out.println(m4);
        
        System.out.println("---------------------------------------------------------------------------");

        System.out.println("2) Number of students Male and Female?");
        Map<Boolean, Long> m1 = list.stream().collect(Collectors.partitioningBy(e->e.getGender()==Gender.MALE, Collectors.counting()));
        System.out.println("****FEMALE STUDENTS****");
        System.out.println(m1.get(false));
        System.out.println("****MALE STUDENTS****");
        System.out.println(m1.get(true));

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("3) Number of students Failed and Passed (Whole University)");
        Map<Boolean, List<Student>> m2 = list.stream().collect(Collectors.partitioningBy(e->e.getPercentage()>40));
        System.out.println("****FAILED STUDENTS****");
        System.out.println(m2.get(false));
        System.out.println("****PASSED STUDENTS****");
        System.out.println(m2.get(true));

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("4) Top 3 students in whole university");

        System.out.println(list.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).collect(Collectors.toList()));

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("5) Top Scorer school wise");
        Map<String, List<Student>> SchoolWise = list.stream().collect(Collectors.groupingBy(e->e.getSchool()));
        for (String school : SchoolWise.keySet()) {
            System.out.print("School Name: " + school+" ---->  ");
            System.out.println(SchoolWise.get(school).stream().max(Comparator.comparingDouble(Student::getPercentage)).get());
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("5) Average age of male and female students!");
        Map<Boolean, Double> average = list.stream().collect(Collectors.partitioningBy(e->e.getGender()==Gender.MALE, Collectors.averagingInt(Student::getAge)));
        System.out.println("Average age of male students : "+average.get(true));
        System.out.println("Average age of female students : "+average.get(false));


        System.out.println("---------------------------------------------------------------------------");
        System.out.println("6) Total fees collected school wise : ");
        
        for (String school : SchoolWise.keySet()) {
            System.out.print("School Name: " + school+" ---->  ");
            System.out.println(SchoolWise.get(school).stream().map((x)->x.getFees().getTotalFees()).reduce((a,b)->a+b).get());
        }

        System.out.println("---------------------------------------------------------------------------");

        System.out.println("7) Total fees Pending school wise : ");
        
        for (String school : SchoolWise.keySet()) {
            System.out.print("School Name: " + school+" ---->  ");
            System.out.println(SchoolWise.get(school).stream().map((x)->x.getFees().getFeesPending()).reduce((a,b)->a+b).get());
        }

        System.out.println("\n8) Total number of Students : "+list.size());

        System.out.println("\n---------------------------------------------------------------------------");

        System.out.println("\n9) Number of students Failed and Passed (School wise)");

        for (String school : SchoolWise.keySet()) {
            Map<Boolean, Long> schoolWisePassed = SchoolWise.get(school).stream().collect(Collectors.partitioningBy(e->e.getPercentage()>40, Collectors.counting()));;
            System.out.print("School Name: " + school+" ---->  ");
            System.out.println("Passed : "+schoolWisePassed.get(true)+", Fail : "+schoolWisePassed.get(false));
        }

    }
}