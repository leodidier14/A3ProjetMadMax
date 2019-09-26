package Model;

public class DecryptModel {

    public DecryptModel(){}

    public String decrypt(String inputString, String key) {
        String chaineDecryptee = "";
        for (int i = 0; i < inputString.length(); i++) {
            chaineDecryptee += (char) ((int) inputString.charAt(i) ^ (int) key.charAt(i % key.length()));
        }
        return chaineDecryptee;
    }

}
