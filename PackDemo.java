import MyMath.*;
import java.util.Scanner;

public class PackDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("Select an operation type:");
            System.out.println("1 - Arithmetic Operations");
            System.out.println("2 - Statistical Operations");
            System.out.println("3 - Trigonometric Operations");
            System.out.println("4 - Exit");

            int operationType = scanner.nextInt();

            switch (operationType) {
                case 1:
                    // Arithmetic Operations
                    boolean continueArithmetic = true;
                    Arithmatic arithmetic = new Arithmatic();

                    while (continueArithmetic) {
                        System.out.println("Select an arithmetic operation:");
                        System.out.println("1 - Addition");
                        System.out.println("2 - Subtraction");
                        System.out.println("3 - Multiplication");
                        System.out.println("4 - Division");
                        System.out.println("5 - Back to Main Menu");
                        int arithmeticOperation = scanner.nextInt();

                        if (arithmeticOperation == 5) {
                            continueArithmetic = false;
                            break;
                        }

                        System.out.println("Enter first number:");
                        int n1 = scanner.nextInt();
                        System.out.println("Enter second number:");
                        int n2 = scanner.nextInt();

                        switch (arithmeticOperation) {
                            case 1:
                                System.out.println("Sum: " + arithmetic.add(n1, n2));
                                break;
                            case 2:
                                System.out.println("Difference: " + arithmetic.sub(n1, n2));
                                break;
                            case 3:
                                System.out.println("Product: " + arithmetic.mul(n1, n2));
                                break;
                            case 4:
                                try {
                                    System.out.println("Quotient: " + arithmetic.div(n1, n2));
                                } catch (ArithmeticException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("Invalid arithmetic operation.");
                                break;
                        }
                    }
                    break;

                case 2:
                    // Statistical Operations
                    boolean continueStatistical = true;
                    Statistical statistical = new Statistical();

                    while (continueStatistical) {
                        System.out.println("Select a statistical operation:");
                        System.out.println("1 - Minimum");
                        System.out.println("2 - Maximum");
                        System.out.println("3 - Sum");
                        System.out.println("4 - Count");
                        System.out.println("5 - Average");
                        System.out.println("6 - Back to Main Menu");
                        int statisticalOperation = scanner.nextInt();

                        if (statisticalOperation == 6) {
                            continueStatistical = false;
                            break;
                        }

                        System.out.println("Enter the number of elements:");
                        int size = scanner.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Enter the elements:");
                        for (int i = 0; i < size; i++) {
                            arr[i] = scanner.nextInt();
                        }

                        switch (statisticalOperation) {
                            case 1:
                                System.out.println("Minimum value: " + statistical.min(arr));
                                break;
                            case 2:
                                System.out.println("Maximum value: " + statistical.max(arr));
                                break;
                            case 3:
                                System.out.println("Sum: " + statistical.sum(arr));
                                break;
                            case 4:
                                System.out.println("Count: " + statistical.count(arr));
                                break;
                            case 5:
                                try {
                                    System.out.println("Average: " + statistical.avg(arr));
                                } catch (ArithmeticException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("Invalid statistical operation.");
                                break;
                        }
                    }
                    break;

                case 3:
                    // Trigonometric Operations
                    boolean continueTrigonometric = true;

                    while (continueTrigonometric) {
                        System.out.println("Enter the angle in radians:");
                        double angle = scanner.nextDouble();
                        Trig trig = new Trig(angle);

                        System.out.println("Select a trigonometric operation:");
                        System.out.println("1.Sine");
                        System.out.println("2.Cosine");
                        System.out.println("3.Tangent");
                        System.out.println("4.Secant");
                        System.out.println("5.Cosecant");
                        System.out.println("6.Cotangent");
                        System.out.println("7.Back to Main Menu");
                        int trigOperation = scanner.nextInt();

                        if (trigOperation == 7) {
                            continueTrigonometric = false;
                            break;
                        }

                        switch (trigOperation) {
                            case 1:
                                System.out.println("Sin: " + trig.getSin());
                                break;
                            case 2:
                                System.out.println("Cos: " + trig.getCosin());
                                break;
                            case 3:
                                System.out.println("Tan: " + trig.getTan());
                                break;
                            case 4:
                                try {
                                    System.out.println("Sec: " + trig.getSec());
                                } catch (ArithmeticException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 5:
                                try {
                                    System.out.println("Cosec: " + trig.getCosec());
                                } catch (ArithmeticException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 6:
                                try {
                                    System.out.println("Cot: " + trig.getCotan());
                                } catch (ArithmeticException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            default:
                                System.out.println("Invalid trigonometric operation.");
                                break;
                        }
                    }
                    break;

                case 4:
                    // Exit
                    continueRunning = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid operation type.");
                    break;
            }
        }

        scanner.close();
    }
}
