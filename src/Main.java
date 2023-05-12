import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Encrypt(E) or Decrypt (D)");
        String acting = "";
        int key;
        while (!acting.equals("E") && !acting.equals("D")) {
            acting = scan.nextLine();
            if (!acting.equals("E") && !acting.equals("D")) System.out.println("Please, try again");

        }

        if (acting.equals("E")) {
            System.out.println("Input your text");
            String text = scan.nextLine();
            System.out.println("Input your digit key");

            key = scan.nextInt();
            if (key == 0) System.out.println("Encoded text:\n" + text);
                else System.out.println("Encoded text:\n" + Encryptor.crypt(text, key));
        } else {
            System.out.println("Input encrypted text");
            String text = scan.nextLine();
            System.out.println("Input your digit key");
            key = scan.nextInt();
            if (key == 0) System.out.println("Encoded text:\n" + text);
                else System.out.println("Decoded text:\n" + Decoder.decod(text, key));
        }
    }
}