import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
                        /* Create new object of class scanner and FileReader*/
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        Scanner scanner = new Scanner(System.in);
                         /* Enter the encryption key and write path in to the variable "path"*/
        System.out.print("Enter encryption key: ");
        String key = scanner.nextLine();
        System.out.print("Enter path file: ");
        String path = scanner.nextLine();
                         /* Save text from the text.txt file in to the "text" variable*/
        String text = fileReader.readText(path);
                        /* Encrypt the text using the method "encryption" of the class Encryption*/
        Encryption.encryption(text, Integer.parseInt(key));
                        /* Save encryption text to the "encryptionText" variable*/
        String encryptionText = Encryption.encryption(text, 2);
                        /* Create new document and write encryption text in to the new file, using "writeText" method of the FileWriter class*/
        fileWriter.writeText(encryptionText, "text1.txt");
    }
}
