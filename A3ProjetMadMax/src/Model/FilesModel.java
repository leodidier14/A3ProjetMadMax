package Model;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
//import controller.FilesController;


import java.io.*;

public class FilesModel {
    public String readFile(String path) throws IOException {
        BufferedReader br = null;
        String ligne;
        String res = "";

        try {
            br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        while ((ligne = br.readLine()) != null)
            res = res + ligne;
        try {
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public void writeFile(String path, String texte) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(path, "UTF-8");
            writer.println(texte);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    


    
    
    

    //private FilesController filesController;

    public String browseFiles() {
        String path = "";
        JFileChooser sourceChoice = new JFileChooser();
        int retour = sourceChoice.showOpenDialog(sourceChoice);

        if (retour == JFileChooser.APPROVE_OPTION) {
            sourceChoice.getSelectedFile().getName();
            path = sourceChoice.getSelectedFile().getAbsolutePath();
        }
        return path;
    }

    public String browseDirectory() {
        String path = "";
        JFileChooser destinationChoice = new JFileChooser();
        destinationChoice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retour = destinationChoice.showOpenDialog(destinationChoice);

        if (retour == JFileChooser.APPROVE_OPTION) {
            destinationChoice.getSelectedFile().getName();
            path = destinationChoice.getSelectedFile().getAbsolutePath();
        }
        return path;
    }

   /* public String readFile(String path) throws Exception {
        InputStream stream;
        stream = new FileInputStream(path);
        StringBuilder reponse;
        reponse = new StringBuilder();
        for (int a = stream.read(); a != -1; a = stream.read()) {
            reponse.append((char) a);
        }
        stream.close();

        return reponse.toString();
    }*/

    public void mooveFile(String sourceParam) {
        Path source = Paths.get(sourceParam);
        Path destination = Paths.get("C:\\Users\\Lafarge Dylan\\Documents\\aaa\\" + source.getFileName());
        System.out.println(source);
        System.out.println(destination);
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/*public void setController(FilesController filesController) {
		this.filesController = filesController;
	}*/
}

