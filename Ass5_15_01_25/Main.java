
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

    A(){
        if(p1 != null){

        }
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
    static private A p1 = null; // Object is already created.

    private B(){
        
    }

    public static A getB(){
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
        A p1 = A.getA();
        A p2 = A.getA();

        System.out.println(p1);
        System.out.println(p2);
    }    
}
