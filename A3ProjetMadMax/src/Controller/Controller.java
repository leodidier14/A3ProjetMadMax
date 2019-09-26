package Controller;

import Model.Model;

public class Controller {

    DecryptController decryptController;

    public Controller(Model model) {
        decryptController = new DecryptController(model);
    }

    public String decrypt(String inputString) {
        return decryptController.decrypt(inputString);
    }

    public boolean findWord(String message) {
        return decryptController.findWord(message);
    }

    public void writeFile(String path, String texte) {
        decryptController.writeFile(path, texte);
    }

    public String readFile(String path){
        return decryptController.readFile(path);
    }
}
