import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text1 = scanner.nextLine();

        System.out.println(Encryption.encryption(text1, 2));

        String text2 = scanner.nextLine();

        System.out.println(Decryption.decryption(text2, 2));
    }
}
