package model;

import javax.swing.JFileChooser;

import controller.FilesController;

public class FilesModel {
	
	private FilesController filesController;
	
	public void browseFiles() {
		JFileChooser ChoixSource = new JFileChooser();
        int retour=ChoixSource.showOpenDialog(ChoixSource);
           if(retour==JFileChooser.APPROVE_OPTION){
               ChoixSource.getSelectedFile().getName();
               ChoixSource.getSelectedFile().
                     getAbsolutePath();
           }
    }
	
	/*public void setController(FilesController filesController) {
		this.filesController = filesController;
	}*/

}
