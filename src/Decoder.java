public class Decoder {

    public static String decod(String message, int key) {
        String alf = KeyGenerator.alfCreator(key);
        String decodeMessage = "";
        String strKey = Integer.toString(key);
        int j = 0;
        for (int i = 0; i < message.length(); i++) {
            int keyElement = Character.getNumericValue(strKey.charAt(j));
            j++;
            if (j == strKey.length()) j = 0;
            decodeMessage += symbolDec(message.charAt(i), keyElement, alf);
        }
        String addCrypt = KeyGenerator.addCrypt();
        String cryptLetter = "" + addCrypt.charAt(key%10);
        decodeMessage = decodeMessage.replaceAll("!@" + key / (key % 100)+ "@!", cryptLetter);
        return decodeMessage;
    }
    public static char symbolDec(char sim, int key, String alf) {
            int keyPlus;
            for (int i = 0; i < alf.length(); i++) {
                if (i - key < 0) keyPlus = i - key + alf.length();
                else keyPlus = i - key;
                if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
            }
            return sim;
        }

}
