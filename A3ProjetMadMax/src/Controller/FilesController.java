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
        fm.setPath(browseFiles().replace("\\", "\\\\"));
        Path path = Paths.get(fm.getPath());
        System.out.println("Nom du fichier : " + path.getFileName().toString());
        fm.setName(path.getFileName().toString());
        if (!fm.getPath().equals("") || fm.getPath() != null) {
            cad.m_actionRows(fm.addFile());
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Le chemin specifie est incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

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

    public static void mooveFile(int id) {

        FilesModel fm = getFileByID(id);
        Path source = Paths.get(fm.getPath());
        Path destination = Paths.get(destinationPath + "\\" + fm.getName());
        System.out.println(source);
        System.out.println(destination);
        try {
            Files.move(source, destination, StandardCopyOption.REPLACE_EXISTING);
            removeFile(fm.getID());
        } catch (NoSuchFileException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Le chemin specifie est incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(new JFrame(), "IOException", "Erreur", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }


    }

    //Selection de fichiers

    public static String browseFiles() {
        String path = "";
        JFileChooser sourceChoice = new JFileChooser();
        int retour = sourceChoice.showOpenDialog(sourceChoice);

        if (retour == JFileChooser.APPROVE_OPTION) {
            sourceChoice.getSelectedFile().getName();
            path = sourceChoice.getSelectedFile().getAbsolutePath();
        }
        return path;
    }

    //Selection du dossier

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


    public static boolean readFiles(String path) {
        FilesModel fm = new FilesModel();
        fm.setPath(path);
        System.out.println("Path : " + fm.getPath());
        Model model = new Model();
        DecryptController decryptController = new DecryptController(model);
        boolean check = true;
        try {
            System.out.println(fm.readFile(path));
            System.out.println(decryptController.decrypt(fm.readFile(path)));
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

                FilesModel file = new FilesModel(rs.getInt("ID_File"), rs.getInt("User_ID"), rs.getString("name"), rs.getString("Path_File"));
                System.out.println("ID :" + file.getID() + "\nOwnerID :" + file.getOwnerID() + "Name : " + file.getName() + "\nPath :" + file.getPath());
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

    public static FilesModel getFileByID(int id) {
        FilesModel res = null;
        for (FilesModel fm : StateController.getCurrentUser().getFiles()) {
            if (fm.getID() == id) {
                res = fm;
                break;
            }
        }
        return res;
    }

    public static void removeFile(int id) {
        FilesModel fm = getFileByID(id);
        if (fm != null && StateController.getCurrentUser().getID() == fm.getOwnerID()) {
            cad.m_actionRows(fm.removeFile());
            StateController.getCurrentUser().getFiles().remove(fm);
            StateController.updateFrame();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Vous n'etes pas autorisé a supprimer ce fichier", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

}
