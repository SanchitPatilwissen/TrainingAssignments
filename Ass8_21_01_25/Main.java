
import java.lang.reflect.Method;
import java.util.Scanner;

class Calculator{
    public int add(int a, int b)
	{
		return a+b;
	}
	public int sub(int a, int b)
	{
		return a-b;
	}
	public int mul(int a, int b)
	{
		return a*b;
	}
	public int div(int a, int b)
	{
		return a/b;
	}
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Java Calculation!");

        Calculator obj = new Calculator(); 
        Class<?> c1 = obj.getClass();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the operation method you want to perform : ");
        String op = sc.nextLine();
        
        Method calculation = c1.getDeclaredMethod(op, int.class, int.class);
        int a, b;
        
        System.out.print("Enter operand 1 : ");
        a = sc.nextInt();
        System.out.print("Enter operand 2 : ");
        b = sc.nextInt();
        
        int result = 0;
        
        try{
            result=(int) calculation.invoke(obj, a, b); 
        }
        catch(Exception e){
            System.out.println(e);
            return;
        }
        System.out.println("Result of "+op+" is : "+result);
        sc.close();
    }
}
