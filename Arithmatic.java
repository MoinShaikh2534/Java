package MyMath;

 public class Arithmatic {

    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int sub(int n1, int n2) {
        return n1 - n2;

    public int mul(int n1, int n2) {
        return n1 * n2;
    }

    public int div(int n1, int n2) {
        if (n2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return n1 / n2;
    }
};
