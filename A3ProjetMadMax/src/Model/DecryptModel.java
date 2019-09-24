package Model;

public class DecryptModel {

    public DecryptModel(){}

    public String decrypt(String inputString, String key) {
        String chaineCryptee = "";
        for (int i = 0; i < inputString.length(); i++) {
            chaineCryptee += (char) ((int) inputString.charAt(i) ^ (int) key.charAt(i % key.length()));
        }
        return chaineCryptee;
    }
}
