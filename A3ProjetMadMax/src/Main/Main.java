package Main;

import Controller.FilesController;
import Controller.StateController;
import Model.CADopen;
import Model.FilesModel;
import View.AuthForm;
import View.FilesView;
import View.MainFrame;

import java.sql.Connection;


import Controller.Controller;
import Model.DecryptModel;
import Model.FilesModel;
import Model.Model;

import java.io.Console;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*/Model model = new Model();
        Controller controller = new Controller(model);
        DecryptModel decryptModel = new DecryptModel();

        String chaine = "ceci test encore autre";
        String key = "awqpaaafqsbf";
        //String res = "";
        System.out.println(chaine);
        chaine = decryptModel.decrypt(chaine, key);
        System.out.println(chaine);

        System.out.println(controller.decrypt(chaine));*/
        
        
        StateController stateController = new StateController();
        MainFrame mainFrame = new MainFrame(stateController);
        StateController.setFrame(mainFrame);

        //FilesView filesView = new FilesView();
        //FilesModel filesModel = new FilesModel(StateController.getCurrentUser().getID());
        //FilesController controllerModel = new FilesController();
        //filesModel.setController(controllerModel);

       // AuthForm authView = new AuthForm();
        //MainFrame view = new MainFrame();



    }
}
