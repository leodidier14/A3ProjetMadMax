package Controller;

import Model.FilesModel;
import View.FilesView;
import View.MainFrame;

public class FilesController {
	
	private MainFrame filesView;
	private FilesModel filesModel;
	
	public FilesController(MainFrame filesView, FilesModel filesModel) {
		 this.filesView = filesView;
		 this.filesModel = filesModel;
		
	}

	public void chooseFile() {
		filesModel.mooveFile(filesModel.browseFiles());
	}
	
	public String chooseDirectory() {
		String path = filesModel.browseDirectory();
		return path;	
	}
	 
	
	public boolean readFiles(String path) {
		boolean check = true;
		try {
			System.out.println(filesModel.readFile(path));
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		 
		return check;	
	}

}
