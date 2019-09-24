package model;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFileChooser;
//import controller.FilesController;

public class FilesModel {
	
	//private FilesController filesController;
	
	public String browseFiles() {
		String path = "";
		JFileChooser sourceChoice = new JFileChooser();
        int retour=sourceChoice.showOpenDialog(sourceChoice);
           if(retour==JFileChooser.APPROVE_OPTION){
        	   sourceChoice.getSelectedFile().getName();
               path = sourceChoice.getSelectedFile().getAbsolutePath();
           }
		return path;
    }
	
	public String lireFicher(String path) throws Exception
	{   
		InputStream stream;
		stream = new FileInputStream(path);
        StringBuilder reponse;
        reponse = new StringBuilder();
        for(int a = stream.read();a!=-1;a=stream.read())
        {
        	reponse.append((char)a);
        	}
        stream.close();
        
        return reponse.toString();
		 
    }
	
	/*public void setController(FilesController filesController) {
		this.filesController = filesController;
	}*/

}
