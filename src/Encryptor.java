public class Encryptor {

    public static String crypt(String input, int key) {

        String alf;
        alf = KeyGenerator.alfCreator(key);
        String addCrypt = KeyGenerator.addCrypt();
        String cryptLetter = "" + addCrypt.charAt(key%10);
        input = input.replaceAll(cryptLetter, "!@" + key / (key % 100) + "@!");
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