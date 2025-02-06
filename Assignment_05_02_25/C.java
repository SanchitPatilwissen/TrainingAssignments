package Assignment_05_02_25;

public class C {

    public void fibonacciFrom1to1000()
	{
        int a = 0, b = 1;

		System.out.println("Fib : "+a);
		System.out.println("Fib : "+b);

        while(b<=1000){
            int val = a+b;
    		System.out.println("Fib : "+b);
            a = b;
            b = val;
        }
	}
}
