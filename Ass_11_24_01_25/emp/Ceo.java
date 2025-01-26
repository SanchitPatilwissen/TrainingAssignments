package emp;

final class Ceo extends Employee{

    static private Ceo p1 = null;

    private Ceo(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 1000000, designation, id);
    }

    void raiseSalary() {
        salary += 50000;
    }

    static Ceo createCeo(String name, int age, Designation designation, int id) throws Exception {
        try {
            if (p1 == null) {
                p1 = new Ceo(name, age, designation, id);
                return p1;
            } else {
                throw new MultipleObjectException("Only 1 CEO can be there!");
            }
        } catch (MultipleObjectException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    static void findCeo(Database db){
        for (var id : db.employees.keySet()) {
            if(db.employees.get(id).getDesignation() == Designation.CEO){
                p1 = (Ceo) db.employees.get(id);
                return;
            }

        }
    }

    static boolean isCeoNotThere() {
        if (p1 == null)
            return true;
        return false;
    }
}