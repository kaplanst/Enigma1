public class Decoder {
    public static void main(String[] args) {
        String message = "1B%x@h84XO%pQ\\`])rM>apMn}|9|AV8+NT8&6]Xr}nI@enM|iO9";
        int key = 65214525;
        System.out.println(decod(message, key));
    }

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
            decodeMessage = decodeMessage.replaceAll("!@" + key + "@!", "a");

        }
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
