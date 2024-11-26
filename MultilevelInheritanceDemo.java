// Base class
class Person {
    String name;
    String birthDate;

    // Constructor for Person
    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    // Method to display Person details
    public void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Birth Date: " + birthDate);
    }
}

// Derived class Employee (inherits from Person)
class Employee extends Person {
    String empId;
    double salary;

    // Constructor for Employee
    public Employee(String name, String birthDate, String empId, double salary) {
        super(name, birthDate); // Calling the base class constructor
        this.empId = empId;
        this.salary = salary;
    }

    // Method to display Employee details
    public void displayEmployeeDetails() {
        displayPersonDetails(); // Display Person details
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
}

// Derived class CEO (inherits from Employee)
class CEO extends Employee {
    String companyName;

    // Constructor for CEO
    public CEO(String name, String birthDate, String empId, double salary, String companyName) {
        super(name, birthDate, empId, salary); // Calling the Employee constructor
        this.companyName = companyName;
    }

    // Method to display CEO details
    public void displayCEODetails() {
        displayEmployeeDetails(); // Display Employee details
        System.out.println("Company Name: " + companyName);
    }
}

// Main class to demonstrate multilevel inheritance
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        // Creating a CEO object
        CEO ceo = new CEO("Alice Johnson", "1980-07-15", "CEO123", 150000, "TechCorp");
        System.out.println("CEO Details:");
        ceo.displayCEODetails();
    }
}
