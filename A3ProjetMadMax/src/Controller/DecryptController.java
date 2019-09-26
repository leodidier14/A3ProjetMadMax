package Controller;

import Model.Model;

public class DecryptController {

    Model model;
    String cle = "awqpaaaaaaaa";
    int id = 0;
    char[] keyTab = cle.toCharArray();
    String messageDecrypte = "";

    public DecryptController(Model model) {
        this.model = model;
    }

    public String decrypt(String inputString) {
        boolean isDecrypt = false;
        while(!isDecrypt){
            messageDecrypte = model.decrypt(inputString, this.generateKey());
            isDecrypt = this.findWord(messageDecrypte);
        }
        System.out.println(this.generateKey());
        return messageDecrypte;
    }

    public String generateKey() {
        keyTab[11] = (char) (97 + id % 26);
        for (int i = 1; i < 8; i++) {
            keyTab[11 - i] = (char) (97 + ((int) (id / Math.pow(26, i)) % 26));
        }
        id++;
        String s = new String(keyTab);
        System.out.println(s);
        return s;
    }

    public boolean findWord(String message) {
        return model.findWord(message);
    }

    public void writeFile(String path, String texte) {
        model.writeFile(path, texte);
    }

    public String readFile(String path) {
        return model.readFile(path);
    }
}
