package Model;

import Controller.StateController;

import java.io.IOException;

public class Model {

    DecryptModel decryptModel;
    FilesModel filesModel;

    public Model() {
        decryptModel = new DecryptModel();
        filesModel = new FilesModel(StateController.getCurrentUser().getID());
    }

    public String decrypt(String inputString, String key) {
        return decryptModel.decrypt(inputString, key);
    }

    public boolean findWord(String message) {
        Map_Dic dictionnaire = new Map_Dic();
        return dictionnaire.findWord(message);
    }

    public void writeFile(String path, String texte) {
        FilesModel fm  = new FilesModel(path);
        filesModel.writeFile(texte);
    }

    public String readFile(String path){
        FilesModel fm = new FilesModel(path);
        String res = "";
        try {
            res = filesModel.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
