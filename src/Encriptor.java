public class Encriptor {

    public static void main(String[] args) {
        System.out.println("Encoded text:\n" + cript("We've accepted your return request. " +
                "Once we receive the item below, we'll issue your refund.", 65214525));
    }

    public static String cript(String input, int key) {
        String addCript = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String alf;
        alf = KeyGenerator.alfCreator(key);
        System.out.println("New alphabet:\n" + alf + "\n");
        System.out.println("Your digit key:\n" + key + "\n");
        System.out.println("Decoded text:\n" + input);
        input = input.replaceAll("a", "!@" + key / (key % 100) + "@!");
        String output = "";
        String strKey = Integer.toString(key);
        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            key = Character.getNumericValue(strKey.charAt(j));
            j++;
            if (j == strKey.length()) j = 0;
            output += symbol(input.charAt(i), key, alf);
        }
        return output;
    }

    public static char symbol(char sim, int key, String alf) {
        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i + key < alf.length()) keyPlus = i + key;
            else keyPlus = i + key - alf.length();
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }
}