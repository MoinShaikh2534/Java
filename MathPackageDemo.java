import java.util.Scanner;

class MathOperations {
    // Arithmetic Operations
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
    }

    // Statistical Operations
    public static double mean(double[] numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    public static double variance(double[] numbers) {
        double mean = mean(numbers);
        double sum = 0;
        for (double num : numbers) {
            sum += Math.pow(num - mean, 2);
        }
        return sum / numbers.length;
    }

    public static double standardDeviation(double[] numbers) {
        return Math.sqrt(variance(numbers));
    }

    // Trigonometric Operations
    public static double sine(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public static double cosine(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public static double tangent(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}

public class MathPackageDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Mathematical Operations ---");
            System.out.println("1. Arithmetic Operations");
            System.out.println("2. Statistical Operations");
            System.out.println("3. Trigonometric Operations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Arithmetic Operations ---");
                    System.out.print("Enter first number: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    double b = scanner.nextDouble();
                    System.out.println("Addition: " + MathOperations.add(a, b));
                    System.out.println("Subtraction: " + MathOperations.subtract(a, b));
                    System.out.println("Multiplication: " + MathOperations.multiply(a, b));
                    try {
                        System.out.println("Division: " + MathOperations.divide(a, b));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("\n--- Statistical Operations ---");
                    System.out.print("Enter the number of elements: ");
                    int n = scanner.nextInt();
                    double[] numbers = new double[n];
                    System.out.println("Enter the numbers:");
                    for (int i = 0; i < n; i++) {
                        numbers[i] = scanner.nextDouble();
                    }
                    System.out.println("Mean: " + MathOperations.mean(numbers));
                    System.out.println("Variance: " + MathOperations.variance(numbers));
                    System.out.println("Standard Deviation: " + MathOperations.standardDeviation(numbers));
                    break;

                case 3:
                    System.out.println("\n--- Trigonometric Operations ---");
                    System.out.print("Enter the angle in degrees: ");
                    double angle = scanner.nextDouble();
                    System.out.println("Sine: " + MathOperations.sine(angle));
                    System.out.println("Cosine: " + MathOperations.cosine(angle));
                    System.out.println("Tangent: " + MathOperations.tangent(angle));
                    break;

                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
