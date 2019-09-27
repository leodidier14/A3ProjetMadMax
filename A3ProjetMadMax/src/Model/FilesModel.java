package Model;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;

//import controller.FilesController;

public class FilesModel {

    private int ID;
    private String name;
    private String path;
    private int ownerID;

    public FilesModel(int ID)
    {
        this.ownerID = ID;
    }

    public FilesModel(String path)
    {
        this.path = path;
    }


    public FilesModel(int ID, int userID, String path)
    {
        this.ID = ID;
        this.ownerID = userID;
        this.path = path;
    }

    public FilesModel(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String readFile() throws IOException {
        BufferedReader br = null;
        String ligne;
        String res = "";

        try {
            br = new BufferedReader(new FileReader(this.path));
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

    public void writeFile(String text) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(this.path, "UTF-8");
            writer.println(text);
            writer.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Fichier introuvable", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            JOptionPane.showMessageDialog(new JFrame(), "L'encodage du fichier n'est pas supporte", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public String addFile() {
        return "INSERT INTO `file` (`User_ID`,`Path_File`) VALUES ('" + this.ownerID + "',\"" + this.path + "\");";
    }

    public String removeFile()
    {
        return "DELETE FROM `file` WHERE ID_File='"+ this.getID() +"';";
    }

    public String getFile()
    {
        return "SELECT * FROM file WHERE User_ID='"+ this.getOwnerID() +"';";
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

   // CHANGE
    public void mooveFile(String sourceParam,String destinationPath) {
        Path source = Paths.get(sourceParam);
        Path destination = Paths.get(destinationPath + "\\" + source.getFileName());
        System.out.println(source);
        System.out.println(destination);
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (NoSuchFileException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Le chemin specifie est incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "IOException", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }
	
	/*public void setController(FilesController filesController) {
		this.filesController = filesController;
	}*/
}

