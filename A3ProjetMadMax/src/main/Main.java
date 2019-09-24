package main;

import controller.FilesController;
import model.FilesModel;
import view.FilesView;

public class Main {

	public static void main(String[] args) {
		
		FilesView filesView =  new FilesView();
		FilesModel filesModel = new FilesModel();
        FilesController controllerModel = new FilesController(filesView, filesModel);
        
        filesView.setController(controllerModel);
        //filesModel.setController(controllerModel);
	}

}
