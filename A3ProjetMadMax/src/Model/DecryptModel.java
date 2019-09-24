package Model;

public class DecryptModel {
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
