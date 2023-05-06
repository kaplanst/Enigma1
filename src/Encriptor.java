public class Encriptor {

    public static void main(String[] args) {
        System.out.println("Encoded text:\n" + cript("Hello, World! Happy New year!", 486923, true));
    }

    public static String cript(String input, int key, boolean newAlf) {
        String alf = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        if (newAlf) alf = alfCreator();
        System.out.println("New alphabet:\n" + alf + "\n");
        System.out.println("Your digit key:\n" + key + "\n");
        System.out.println("Decoded text:\n" + input);
        input = input.replaceAll("a", "***" + key + "***");
        String output = "";
        String strKey = Integer.toString(key);
        int j = 0;
        for (int i = 0; i < input.length(); i++) {
            key =  Character.getNumericValue(strKey.charAt(j));
            j++;
            if (j == strKey.length()) j = 0;
            output += symbol(input.charAt(i), key, alf);
        }

        return output;
    }
    public static char symbol(char sim, int key,String alf){
        int keyPlus;
        for (int i = 0; i < alf.length(); i++) {
            if (i + key < alf.length()) keyPlus = i + key;
            else keyPlus = i + key -alf.length();
            if (sim == alf.charAt(i)) return alf.charAt(keyPlus);
        }
        return sim;
    }
    public static String alfCreator() {
        String alf = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String resAlf = "";
        for (int i = 0; i < 95; i++) {
            int x = (int)(Math.random() * alf.length());
            resAlf += alf.charAt(x);
            alf = alf.replace(Character.toString(alf.charAt(x)), "");
        }
        return resAlf;
    }

}
//  !"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\]^_`abcdefghijklmnopqrstuvwxyz{|}~

