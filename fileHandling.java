import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.util.Scanner;

public class fileHandling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File f = new File("file.txt");

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Create a file");
            System.out.println("2. Write to the file");
            System.out.println("3. Append to the file");
            System.out.println("4. Read the file");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    try {
                        if (f.createNewFile()) {
                            System.out.println("File created: " + f.getName());
                        } else {
                            System.out.println("File already exists.");
                        }
                    } catch (IOException e) {
                        System.err.println("An IOException occurred: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (OutputStream o = new FileOutputStream(f)) {
                        System.out.println("Enter content to write to the file:");
                        String content = sc.nextLine();
                        o.write(content.getBytes());
                        o.write(System.lineSeparator().getBytes()); // Add a new line
                        System.out.println("Content written to the file.");
                    } catch (IOException e) {
                        System.err.println("An IOException occurred: " + e.getMessage());
                    }
                    break;

                case 3:
                    try (OutputStream o = new FileOutputStream(f, true)) { // Append mode
                        System.out.println("Enter content to append to the file:");
                        String content1 = sc.nextLine();
                        o.write(content1.getBytes());
                        o.write(System.lineSeparator().getBytes()); // Add a new line
                        System.out.println("Content appended to the file.");
                    } catch (IOException e) {
                        System.err.println("An IOException occurred: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Current content of the file:");
                    try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        System.err.println("An IOException occurred: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
