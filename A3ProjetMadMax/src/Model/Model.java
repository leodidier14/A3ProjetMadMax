package Model;

import java.io.IOException;

public class Model {

    DecryptModel decryptModel;
    FilesModel filesModel;

    public Model() {
        decryptModel = new DecryptModel();
        filesModel = new FilesModel();
    }

    public String decrypt(String inputString, String key) {
        return decryptModel.decrypt(inputString, key);
    }

    public boolean findWord(String message) {
        Map_Dic dictionnaire = new Map_Dic();
        return dictionnaire.findWord(message);
    }

    public void writeFile(String path, String texte) {
        filesModel.writeFile(path, texte);
    }

    public String readFile(String path){
        String res = "";
        try {
            res = filesModel.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
