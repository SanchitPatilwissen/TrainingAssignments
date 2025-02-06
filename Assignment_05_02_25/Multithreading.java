package Assignment_05_02_25;

public class Multithreading {
    public static void main(String[] args) {
        // Runnable r1 = ()->{
        //     A a = new A();
        //     a.print1to10();
        // };
        // Runnable r2 = ()->{
        //     B b = new B();
        //     b.evenTill50();
        // };
        // Runnable r3 = ()->{
        //     C c = new C();
        //     c.fibonacciFrom1to1000();
        // };
       
        // new Thread(r1).start();
        // new Thread(r2).start();
        // new Thread(r3).start();

        new Thread(new A()::print1to10).start();
        new Thread(new B()::evenTill50).start();
        new Thread(new C()::fibonacciFrom1to1000).start();
    }
}
