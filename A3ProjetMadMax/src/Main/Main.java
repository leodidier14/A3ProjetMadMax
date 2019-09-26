package Main;

import Controller.FilesController;
import Controller.StateController;
import Model.CADopen;
import Model.FilesModel;
import View.AuthForm;
import View.FilesView;
import View.MainFrame;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {


        StateController stateController = new StateController();
        MainFrame mainFrame = new MainFrame(stateController);
        StateController.setFrame(mainFrame);

        FilesView filesView = new FilesView();
        FilesModel filesModel = new FilesModel();
        FilesController controllerModel = new FilesController();
        //filesModel.setController(controllerModel);

        AuthForm authView = new AuthForm();
        //MainFrame view = new MainFrame();


        CADopen bdd = new CADopen();
        Connection con = null;
    }

}

