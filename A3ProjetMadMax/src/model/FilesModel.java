package model;

import java.io.InputStream;
import javax.swing.JFileChooser;
import controller.FilesController;

public class FilesModel {
	
	//private FilesController filesController;
	
	public void browseFiles() {
		JFileChooser ChoixSource = new JFileChooser();
        int retour=ChoixSource.showOpenDialog(ChoixSource);
           if(retour==JFileChooser.APPROVE_OPTION){
               ChoixSource.getSelectedFile().getName();
               ChoixSource.getSelectedFile().
                     getAbsolutePath();
           }
    }
	
	public String lireFicher(String path) throws Exception
	{   
		InputStream stream;
		stream = new InputStream(path);
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
