import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        fileProgram();
    }

    public static void fileProgram() {
        boolean isValid = false;

        while (!isValid) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("1: Create File\n2: Write to file\n3: Read file\n4: Exit");
                System.out.print("Enter menu option number: ");
                int input;

                try {
                    input = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number\n");
                    continue;
                }

                if (input == 1) {
                    System.out.print("File path name: ");
                    String filePath = scanner.nextLine();
                    createFile(filePath);
                } else if (input == 2) {
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    System.out.print("Enter text: ");
                    String userText = scanner.nextLine(); // Read the whole line
                    writeToFile(filePath, userText);
                } else if (input == 3) {
                    System.out.print("Enter file path: ");
                    String filePath = scanner.nextLine();
                    readFile(filePath);
                } else if (input == 4) {
                    isValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input mismatch exception, try again\n");
            }
        }
    }

    public static void createFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.out.println("File created successfully\n");
            } else {
                System.out.println("File not created");
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void writeToFile(String filePath, String input) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(input);
            writer.write("\n");
            writer.close();
            System.out.println("File successfully written to\n");

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readFile(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
