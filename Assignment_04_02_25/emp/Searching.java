package emp;

public class Searching<T> extends Database {
    final void search(T val, String parameter) {
        try {
            String query;
            if(val.getClass() == String.class)
                query = "select * from EMPLOYEE where UPPER(" + parameter + ") like '" + val + "%';";
            else 
                query = "select * from EMPLOYEE where " + parameter + " = " + val + ";";
            rs.setCommand(query);
            // rs = stmt.executeQuery(query);
            rs.execute();
            while (rs.next()) {
                System.out.println("The following are the details of this Employee : \nID : " + rs.getString(1)
                        + " \nName : " + rs.getString(2) + "\nAge : "
                        + rs.getString(3) + "\nSalary : " + rs.getString(4) + "\nDesignation : " + rs.getString(5)
                        + "\nDepartment : "
                        + rs.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
