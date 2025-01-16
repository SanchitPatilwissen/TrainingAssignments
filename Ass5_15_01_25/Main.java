
class MultipleObjectException extends RuntimeException{
    MultipleObjectException(){
        super();
    }
    MultipleObjectException(String s){
        super(s);
    }
}

class A{
    static private A p1 = null; // Object is already created.

    A() throws MultipleObjectException{
        if(this instanceof B && this instanceof A){
            System.out.println("Instance of B Created !");
        }
        else if(p1 == null){
            p1 = this;
            System.out.println("A instance is created!");
        }
        else
            throw new MultipleObjectException("1 object can be created!");
    }

    public static A getA(){
        try{
            if(p1==null){
                p1 = new A();
                return p1;
            }
            else{
                throw new MultipleObjectException("Only 1 object can be created");
            }
        }
        catch(MultipleObjectException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}

final class B extends A{
    static private B p1 = null; // Object is already created.

    private B(){
        
    }

    public static B getB(){
        try{
            if(p1==null){
                p1 = new B();
                return p1;
            }
            else{
                throw new MultipleObjectException("Only 1 object can be created");
            }
        }
        catch(MultipleObjectException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        A p = new A();
        A p2 = new A();

        B p3 = B.getB();

        A p1 = A.getA();

        System.out.println(p1);
        System.out.println(p3);
        System.out.println(p);
        System.out.println(p2);

    }    
}
