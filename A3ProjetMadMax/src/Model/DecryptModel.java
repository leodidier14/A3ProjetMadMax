package Model;

public class DecryptModel {

    public DecryptModel(){}

    public StringBuilder StringToBinary(String s){
        byte[] tabBytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : tabBytes){
            int val = b;
            for (int i = 0; i < 8; i++){
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        return binary;
    }

    public String BinaryToString(StringBuilder sb){
        String res = "";
        for (int i = 1; i < sb.length(); i++){
            if (i % 8 == 0){
                char a = (char)Integer.parseInt(sb.substring(i - 8, 1), 2);
                res = res + a;
            }
        }
        res = res + (char)Integer.parseInt(sb.substring(sb.length() - 8, sb.length()), 2);
        return res;
    }

    public String decrypt(String inputString, String key) {
        StringBuilder sb;
        char c1;
        char c2;
        char c3;
        sb = new StringBuilder();
        for (int i = 0, j=0; i < inputString.length(); i++) {
            c1 = inputString.charAt(i);
            c2 = key.charAt(j);
            c3 = (char)(c1^c2);
            sb.append(c3);
            j++;
            if (j == key.length()) {
                j = 0;
            }
        }
        return sb.toString();
    }
}
