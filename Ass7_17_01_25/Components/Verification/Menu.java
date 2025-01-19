package Components.Verification;

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.*;

public class Menu{
    private static int lower;
    private static int upper;

    private static final Scanner sc = new Scanner(System.in);

    private static final InputStreamReader r=new InputStreamReader(System.in);    
    private static final BufferedReader br=new BufferedReader(r);


    public static int readChoice(int low, int up){
        lower = low;
        upper = up;

        int choice;
        
        while(true){
            try{
                choice = sc.nextInt();
                if(choice<lower || choice>upper)
                    throw new ChoiceException();
                break;
            }
            catch(ChoiceException e){
                e.display(lower, upper);
            }
            catch(Exception e){
                System.out.print("Please Enter in valid Integer format : ");
                sc.next();
            }
        }
        return choice;
    }

    public static String validateName(){
        String name;
        String regex_exp = "^[A-Z][a-z]* [A-Z][a-z]*$";

        while(true){
            try{
                name= br.readLine();
                Pattern p1 = Pattern.compile(regex_exp);
                Matcher m1 = p1.matcher(name);

                if(m1.matches())
                    break;
                else
                    throw new NameException("Please Enter the name in valid Format(1st letters caps, 2 words consisting of letters only) : ");
            }
            catch(NameException e){
                System.out.print(e.getMessage());
            }
            catch(Exception e){
                System.out.print("Please enter in valid format : ");
            }
        }
        return name;
    }

    static void scClose(){
        sc.close();
    }
}
