public class Decoder {
//    public static void main(String[] args) {
//        String message = "@B?#6\\9|zrHDetI|i@{qAQ}AhV(\"C\\+B]R+zPO}N^B,!^\\gKLB8$6\\+BLB\"#6\\-EN\\\"!6J8?NI($\\\\0BoI%,:P,RN\\2{FO8ONC.z5j\n";
//        int key = 65214525;
//        System.out.println(decod(message, key));
//    }

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
            decodeMessage = decodeMessage.replaceAll("!@" + key / (key % 100)+ "@!", "a");

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
