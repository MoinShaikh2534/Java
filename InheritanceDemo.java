// Base class
class Person {
    String name;
    String birthDate;
    double height;

    // Constructor for Person
    public Person(String name, String birthDate, double height) {
        this.name = name;
        this.birthDate = birthDate;
        this.height = height;
    }

    // Method to display Person details
    public void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Birth Date: " + birthDate);
        System.out.println("Height: " + height + " cm");
    }
}

// Derived class Student
class Student extends Person {
    String studentId;
    String course;

    // Constructor for Student
    public Student(String name, String birthDate, double height, String studentId, String course) {
        super(name, birthDate, height); // Calling base class constructor
        this.studentId = studentId;
        this.course = course;
    }

    // Method to display Student details
    public void displayStudentDetails() {
        displayPersonDetails();
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
    }
}

// Derived class Employee
class Employee extends Person {
    String empId;
    double salary;

    // Constructor for Employee
    public Employee(String name, String birthDate, double height, String empId, double salary) {
        super(name, birthDate, height); // Calling base class constructor
        this.empId = empId;
        this.salary = salary;
    }

    // Method to calculate tax based on salary
    public double calculateTax() {
        return salary * 0.2; // Assuming 20% tax rate
    }

    // Method to display Employee details
    public void displayEmployeeDetails() {
        displayPersonDetails();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
        System.out.println("Tax: $" + calculateTax());
    }
}

// Main class to demonstrate functionality
public class InheritanceDemo {
    public static void main(String[] args) {
        // Creating a Student object
        Student student = new Student("Alice", "2000-05-15", 165, "S123", "Computer Science");
        System.out.println("Student Details:");
        student.displayStudentDetails();

        System.out.println();

        // Creating an Employee object
        Employee employee = new Employee("Bob", "1990-08-20", 175, "E456", 75000);
        System.out.println("Employee Details:");
        employee.displayEmployeeDetails();
    }
}