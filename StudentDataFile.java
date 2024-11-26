import java.io.*;
import java.util.Scanner;

public class StudentDataFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // File to store student data
        String fileName = "StudentData.dat";

        try {
            // Taking student details from the user
            System.out.print("Enter Roll No: ");
            int rollNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Class: ");
            String studentClass = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            System.out.print("Enter Weight (in kg): ");
            double weight = scanner.nextDouble();

            System.out.print("Enter Height (in cm): ");
            double height = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            // Writing data to the file
            try (FileOutputStream fos = new FileOutputStream(fileName);
                 DataOutputStream dos = new DataOutputStream(fos)) {

                dos.writeInt(rollNo);
                dos.writeUTF(studentClass);
                dos.writeInt(age);
                dos.writeDouble(weight);
                dos.writeDouble(height);
                dos.writeUTF(city);
                dos.writeUTF(phone);

                System.out.println("Student data saved successfully!");
            }

            // Reading and displaying data from the file
            try (FileInputStream fis = new FileInputStream(fileName);
                 DataInputStream dis = new DataInputStream(fis)) {

                System.out.println("\nRetrieving Student Data...");
                int retrievedRollNo = dis.readInt();
                String retrievedClass = dis.readUTF();
                int retrievedAge = dis.readInt();
                double retrievedWeight = dis.readDouble();
                double retrievedHeight = dis.readDouble();
                String retrievedCity = dis.readUTF();
                String retrievedPhone = dis.readUTF();

                System.out.println("Roll No: " + retrievedRollNo);
                System.out.println("Class: " + retrievedClass);
                System.out.println("Age: " + retrievedAge);
                System.out.println("Weight: " + retrievedWeight + " kg");
                System.out.println("Height: " + retrievedHeight + " cm");
                System.out.println("City: " + retrievedCity);
                System.out.println("Phone: " + retrievedPhone);
            }

        } catch (IOException e) {
            System.err.println("File error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
