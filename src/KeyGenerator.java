public class KeyGenerator {

    public static void main(String[] args) {

  //      System.out.println(alfCreator(953475));
    }

    public static String alfCreator(int key) {
        String alf = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String resAlf = "";
        String strKey= Integer.toString(key);
        int keySum = 0;
        for (int i = 0; i < strKey.length(); i++) {
            keySum += Character.getNumericValue(strKey.charAt(i));
        }
        alf = alf.substring(keySum) + alf.substring(0, keySum );
        int i = 0;
        int x = strKey.length();
        int y;
        if (alf.length() % strKey.length() == 0) y = alf.length() / strKey.length();
        else y = alf.length() / strKey.length() + 1;
        String[][] arr = new String[x][y];
        for (int j = 0; j < x; j++) {
            for (int k = 0; k < y; k++) {
                if (i < alf.length()) arr[j][k] = String. valueOf(alf.charAt(i));
                else arr[j][k] = "";
                i++;
            }
        }
        for (int j = 0; j < y; j++) {
            for (int k = 0; k < x; k++) {
                resAlf += arr[k][j];
            }
        }

        return resAlf;
    }
}