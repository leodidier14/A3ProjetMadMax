package Controller;

import Model.CADopen;
import Model.FilesModel;
import Model.Model;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FilesController {


    private static String destinationPath;
    private static CADopen cad = new CADopen();


    public static String getDestinationPath() {
        return destinationPath;
    }

    public static void setDestinationPath(String destinationPath) {
        FilesController.destinationPath = destinationPath;
    }

    public static void chooseFile() {
        FilesModel fm = new FilesModel(StateController.getCurrentUser().getID());
        fm.setPath(fm.browseFiles());
        System.out.println("Path choose : " + fm.getPath() );
        cad.m_actionRows(fm.addFile());
        //fm.mooveFile(fm.browseFiles(), destinationPath);
    }

    public static String chooseDirectory() {
        String path = "";
        JFileChooser destinationChoice = new JFileChooser();
        destinationChoice.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int retour = destinationChoice.showOpenDialog(destinationChoice);

        if (retour == JFileChooser.APPROVE_OPTION) {
            destinationChoice.getSelectedFile().getName();
            path = destinationChoice.getSelectedFile().getAbsolutePath();
        }
        destinationPath = path;
        return path;
    }

    public static void mooveFile() {
        FilesModel fm = new FilesModel(StateController.getCurrentUser().getID());
        String sourceParam = fm.browseFiles();
        Path source = Paths.get(sourceParam);
        Path destination = Paths.get(destinationPath + "\\" + source.getFileName());
        System.out.println(source);
        System.out.println(destination);
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
        } catch (NoSuchFileException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Le chemin specifie est incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), "IOException", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }


    public static boolean readFiles(String path) {
        System.out.println("Path : " + path);
        FilesModel fm = new FilesModel(path);
        Model model = new Model();
        DecryptController decryptController = new DecryptController(model);
        boolean check = true;
        try {
            System.out.println(fm.readFile());
            System.out.println(decryptController.decrypt(fm.readFile()));
        } catch (Exception e) {
            e.printStackTrace();
            check = false;
        }

        return check;
    }

    public static void getFilesbyOwnerID(int ID) {
        FilesModel fm = new FilesModel(ID);
        ArrayList<FilesModel> fileList = new ArrayList<>();
        ResultSet rs = cad.m_getRows(fm.getFile());
        while (true) {
            try {
                if (!rs.next()) break;

                FilesModel file = new FilesModel(rs.getInt("ID_File"), rs.getInt("User_ID"), rs.getString("Path_File"));
                System.out.println("ID :" + file.getID() + "\nOwnerID :" + file.getOwnerID() + "\nPath :" + file.getPath());
                fileList.add(file);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(new JFrame(), "Erreur SQL", "Erreur", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        }
        if (!fileList.isEmpty()) {
            StateController.getCurrentUser().setFiles(fileList);
        }
    }

    public static void getFileByID(int id) {
    }

    public static void removeFile(int id) {
        FilesModel fm = new FilesModel(StateController.getCurrentUser().getID());
        cad.m_getRows(fm.removeFile());
    }

}
