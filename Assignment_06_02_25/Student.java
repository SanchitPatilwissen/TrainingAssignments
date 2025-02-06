package Assignment_06_02_25;

enum Gender{
    MALE, FEMALE
}

class Student {
    private int rollno;
    private String name;
    private int age;
    private int standard;
    private String school;
    private Gender gender;
    private double percentage;
    private Fees fees;

    Student(int rollno, String name, int age, int standard, String school, Gender gender, double percentage, int feesPaid, int feesPending){
        this.rollno = rollno;
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.school = school;
        this.gender = gender;
        this.percentage = percentage;
        this.fees = new Fees().setFeesPaid(feesPaid).setFeesPending(feesPending).setTotalFees(feesPaid+feesPending);
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStandard() {
        return standard;
    }

    public String getSchool() {
        return school;
    }

    public Gender getGender() {
        return gender;
    }

    public double getPercentage() {
        return percentage;
    }

    public Fees getFees() {
        return fees;
    }

    @Override
    public String toString() {
        String val = "Roll No. : "+rollno+", Name : "+name+", Age : "+age+", Standard : "+standard+", Percentage : "+percentage+", School : "+school+", Gender : "+gender+"\n";
        return val;
    }
}


// Student
// --------
// rollNo
// name
// age
// standard
// school
// gender
// percentage
 
// Fees
// ------
// totalFees
// feesPaid
// feesPending
 
 
// * How many students in each standard
// * How many students male & female
// * How many students have failed and pass (40%)
// 	- Whole university
// 	- School wise
// * Top 3 students (Whole university)
// * Top scorer school wise
// * Average age of male & female students
// * Total fees collected school wise
// * Total fees pending school wise
// * Total number of students (University)