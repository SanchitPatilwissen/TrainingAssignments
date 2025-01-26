package emp;

class ChoiceException extends RuntimeException {
    ChoiceException() {
        super();
    }

    ChoiceException(String s) {
        super(s);
    }

    void display(int lower, int upper) {
        System.out.print("Please enter in range " + lower + " - " + upper + " : ");
    }
}
