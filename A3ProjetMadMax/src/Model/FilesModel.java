package Model;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FilesModel {

    private int ID;
    private String name;
    private String path;
    private int ownerID;

    public FilesModel()
    {

    }

    public FilesModel(int ID)
    {
        this.ownerID = ID;
    }

    public FilesModel(int ID, int OID)
    {
        this.ID = ID;
        this.ownerID = OID;
    }

    public FilesModel(String path)
    {
        this.path = path;
    }


    public FilesModel(int ID, int userID,String name, String path)
    {
        this.ID = ID;
        this.name = name;
        this.ownerID = userID;
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

    public String readFile(String path) throws IOException {
        byte[] data = Files.readAllBytes(Paths.get(path));
        return new String(data);
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
        return "INSERT INTO `file` (`User_ID`,`name`,`Path_File`) VALUES ('" + this.ownerID + "','"+this.getName()+"',\"" + this.path + "\");";
    }

    public String removeFile()
    {
        return "DELETE FROM `file` WHERE ID_File='"+ this.getID() +"';";
    }

    public String getFile()
    {
        return "SELECT * FROM file WHERE User_ID='"+ this.getOwnerID() +"';";
    }

    @Override
    public String toString()
    {
        return "" +this.getName() +" (" + this.getPath() + ")";
    }

}

