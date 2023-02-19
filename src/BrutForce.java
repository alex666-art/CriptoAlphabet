import java.io.IOException;
import java.util.Scanner;

public class BrutForce {

    public static String brutForce(String path) {
        String result = "";
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        String originalText = fileReader.readText(path);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 33; i++) {
            result = Decryption.decryption(originalText, i);
            System.out.println(result);
            System.out.println("Right text?");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("no")) {
                continue;
            }
            if (answer.equalsIgnoreCase("yes")){
                try {
                    fileWriter.writeText(result, path);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Decryption was successful on %d iteration", i+1);
                break;
            }
        }
        return result;
    }
}