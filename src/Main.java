import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String INVALID_COMMAND = "Invalid command, please try again";
    public static String key;

    public static void main(String[] args) throws IOException, InterruptedException {
        /** Create new object of class scanner and FileReader**/
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        Scanner scanner = new Scanner(System.in);

        /** Cipher Caesar Title **/
        System.out.println("  ______  __  .______    __    __   _______ .______           ______     ___       _______     _______.     ___      .______      \n" +
                " /      ||  | |   _  \\  |  |  |  | |   ____||   _  \\         /      |   /   \\     |   ____|   /       |    /   \\     |   _  \\     \n" +
                "|  ,----'|  | |  |_)  | |  |__|  | |  |__   |  |_)  |       |  ,----'  /  ^  \\    |  |__     |   (----`   /  ^  \\    |  |_)  |    \n" +
                "|  |     |  | |   ___/  |   __   | |   __|  |      /        |  |      /  /_\\  \\   |   __|     \\   \\      /  /_\\  \\   |      /     \n" +
                "|  `----.|  | |  |      |  |  |  | |  |____ |  |\\  \\----.   |  `----./  _____  \\  |  |____.----)   |    /  _____  \\  |  |\\  \\----.\n" +
                " \\______||__| | _|      |__|  |__| |_______|| _| `._____|    \\______/__/     \\__\\ |_______|_______/    /__/     \\__\\ | _| `._____|");

        while (true) {
            System.out.println("\nEnter the command (Encryption/Decryption/Exit)");
            /** Enter the encryption key and write path in to the variable "path"**/
            String command = scanner.nextLine();

            if (command.toUpperCase().equals("encryption".toUpperCase())) {
                System.out.print("Enter encryption key: ");
                key = scanner.nextLine();
                System.out.print("Enter path to original file: ");
                String pathOriginal = scanner.nextLine();
                System.out.print("Enter path to copy file: ");
                String pathCopy = scanner.nextLine();

                /** Save text from the text.txt file in to the "text" variable**/
                String text = fileReader.readText(pathOriginal);

                /** Encrypt the text using the method "encryption" of the class Encryption**/
                Encryption.encryption(text, Integer.parseInt(key));
                /* Save encryption text to the "encryptionText" variable*/
                String encryptionText = Encryption.encryption(text, Integer.parseInt(key));

                /** Create new document and write encryption text in to the new file, using "writeText" method of the FileWriter class**/
                fileWriter.writeText(encryptionText, pathCopy);
            }
            if (command.toUpperCase().equals("decryption".toUpperCase())) {
                System.out.print("Enter path to original file: ");
                String pathOriginal = scanner.nextLine();
                System.out.print("Enter path to copy file: ");
                String pathCopy = scanner.nextLine();

                /** Save text from the text.txt file in to the "text" variable**/
                String text = fileReader.readText(pathOriginal);

                /** Encrypt the text using the method "encryption" of the class Encryption**/
                Encryption.encryption(text, Integer.parseInt(key));

                /** Save encryption text to the "encryptionText" variable**/
                String encryptionText = Decryption.decryption(text, Integer.parseInt(key));

                /** Create new document and write encryption text in to the new file, using "writeText" method of the FileWriter class**/
                fileWriter.writeText(encryptionText, pathCopy);
            }
            if (command.toUpperCase().equals("exit".toUpperCase())) {
                break;
            }
            if (command.isEmpty() || command.matches("[0-9]+") || !command.toUpperCase().contains("decryption".toUpperCase()) || !command.toUpperCase().contains("encryption".toUpperCase())){
                System.out.println(INVALID_COMMAND);
            }
        }
    }
}