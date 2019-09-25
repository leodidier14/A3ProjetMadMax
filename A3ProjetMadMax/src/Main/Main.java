package Main;

import Controller.FilesController;
import Model.FilesModel;
import View.FilesView;
import View.MainFrame;

import java.sql.Connection;

import Model.CADopen;
import View.AuthForm;

public class Main {

	public static void main(String[] args) {
		
		FilesView filesView =  new FilesView();
		FilesModel filesModel = new FilesModel();
        FilesController controllerModel = new FilesController(filesView, filesModel);
        filesView.setController(controllerModel);
        //filesModel.setController(controllerModel);
        
        AuthForm authView = new AuthForm();
		//MainFrame view = new MainFrame();
		
				
		
        CADopen bdd = new CADopen();
        Connection con = null;
	}

}

