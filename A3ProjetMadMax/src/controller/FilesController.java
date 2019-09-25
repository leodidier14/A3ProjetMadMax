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

	public void chooseFile() {
		filesModel.mooveFile(filesModel.browseFiles());
	}
	
	public String chooseDirectory() {
		String path = filesModel.browseDirectory();
		return path;	
	}
	 
	/*public boolean loadFiles() {
		boolean check = true;
		try {
			System.out.println(filesModel.lireFicher(filesModel.browseFiles()));
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		
		return check;	
	}*/
	
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
