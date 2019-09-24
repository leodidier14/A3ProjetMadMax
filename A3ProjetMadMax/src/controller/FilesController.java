package controller;

import model.FilesModel;
import view.FilesView;

public class FilesController {
	
	private FilesView filesView;
	private FilesModel filesModel;
	
	public FilesController(FilesView filesView, FilesModel filesModel) {
		 this.filesView = filesView;
		 this.filesModel = filesModel;
		
	}

	
	
	public void getMessage() {
		filesModel.browseFiles();
		
		
	}

}
