import java.io.IOException;
import java.util.Scanner;

public class Main {
    /* Declaring default fields and constants */
    private static final String INVALID_COMMAND = "Invalid command, please try again";
    private static final String ORIGINAL_FILE = "OriginalText.txt";
    private static final String FILE_SOURCE = ".txt";
    public static String key;
    public static int counter = 1;

    public static void main(String[] args) throws IOException {
        /* Create new object of class Scanner and FileReader&FileWriter**/
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        Scanner scanner = new Scanner(System.in);

        /* Cipher Caesar Title **/
        System.out.println("  ______  __  .______    __    __   _______ .______           ______     ___       _______     _______.     ___      .______      \n" +
                " /      ||  | |   _  \\  |  |  |  | |   ____||   _  \\         /      |   /   \\     |   ____|   /       |    /   \\     |   _  \\     \n" +
                "|  ,----'|  | |  |_)  | |  |__|  | |  |__   |  |_)  |       |  ,----'  /  ^  \\    |  |__     |   (----`   /  ^  \\    |  |_)  |    \n" +
                "|  |     |  | |   ___/  |   __   | |   __|  |      /        |  |      /  /_\\  \\   |   __|     \\   \\      /  /_\\  \\   |      /     \n" +
                "|  `----.|  | |  |      |  |  |  | |  |____ |  |\\  \\----.   |  `----./  _____  \\  |  |____.----)   |    /  _____  \\  |  |\\  \\----.\n" +
                " \\______||__| | _|      |__|  |__| |_______|| _| `._____|    \\______/__/     \\__\\ |_______|_______/    /__/     \\__\\ | _| `._____|");

        while (true) {
            /* Suggested options for the user */
            System.out.println("\nEnter the command (Encryption/Decryption/Break-in/Exit)");
            /* Enter the encryption key and write path in to the variable "path"**/
            String command = scanner.nextLine();
            String pathFile = null;
            /* Encryption command */
            if (command.equalsIgnoreCase("encryption")) {
                System.out.print("Enter encryption key: ");
                key = scanner.nextLine();

                /* Save text from the text.txt file in to the "text" variable**/
                String text = fileReader.readText(ORIGINAL_FILE);

                /* Save encryption text to the "encryptionText" variable*/
                String encryptionText = Encryption.encryption(text, Integer.parseInt(key));

                /* Create new document and write encryption text in to the new file, using "writeText" method of the FileWriter class**/
                fileWriter.writeText(encryptionText, writeFileName(FILE_SOURCE, counter));
            }
            /* Decryption command */
            if (command.equalsIgnoreCase("decryption")) {
                System.out.print("Enter path to original file: ");
                pathFile = scanner.nextLine();
                if (key == null) {
                    System.out.print("Enter encryption key: ");
                    key = scanner.nextLine();
                }

                /* Save text from the text.txt file in to the "text" variable*/
                String text = fileReader.readText(pathFile);

                /* Save encryption text to the "encryptionText" variable*/
                String encryptionText = Decryption.decryption(text, Integer.parseInt(key));

                /* Create new document and write encryption text in to the new file, using "writeText" method of the FileWriter class*/
                fileWriter.writeText(encryptionText, writeFileName(FILE_SOURCE, counter));
            }
            /* Break-in command */
            if (command.equalsIgnoreCase("break-in")) {
                System.out.print("Enter path to original file: ");
                pathFile = scanner.nextLine();

                /* Iterating over text using the brute force method*/
                BrutForce.brutForce(pathFile);
            }
            /* Exit program command */
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            /* Command validator */
            if (command.isEmpty() || command.matches("[0-9]+")){
                System.out.println(INVALID_COMMAND);
            }
            /* Counter increment */
            counter++;
        }
    }

    /* File naming method */
    public static String writeFileName(String source, int counter) {
        String result = "result№" + counter + source;
        return result;
    }
}