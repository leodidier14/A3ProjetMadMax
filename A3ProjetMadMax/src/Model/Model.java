package Model;

import java.io.IOException;

public class Model {

    DecryptModel decryptModel;
    FilesModel filesModel;
    Map_Dic dictionnaire;

    public Model() {
        decryptModel = new DecryptModel();
        filesModel = new FilesModel();
        try {
            this.dictionnaire = new Map_Dic("C:\\Users\\Mirohac\\Desktop\\Lexique3832.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String decrypt(String inputString, String key) {
        return decryptModel.decrypt(inputString, key);
    }

    public boolean findWord(String message) {
        boolean wordFind = false;
        try {
            wordFind = dictionnaire.findWord(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFind;
    }

    public String readFile(String path) {
        String res = "";
        try {
            res = filesModel.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }
}
