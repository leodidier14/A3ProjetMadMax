package Main;

import Controller.Controller;
import Model.DecryptModel;
import Model.FilesModel;
import Model.Model;

import java.io.Console;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        DecryptModel decryptModel = new DecryptModel();

        String chaine = "ceci test encore autre";
        String key = "awqpaaafqsbf";
        //String res = "";
        System.out.println(chaine);
        chaine = decryptModel.decrypt(chaine, key);
        System.out.println(chaine);

        System.out.println(controller.decrypt(chaine));

    }
}
