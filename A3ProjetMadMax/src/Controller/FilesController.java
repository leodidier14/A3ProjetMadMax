package Controller;

import Model.DecryptModel;
import Model.FilesModel;
import Model.Model;

public class FilesController {

    public static void chooseFile() {
        FilesModel fm = new FilesModel();
        fm.mooveFile(fm.browseFiles());
    }

    public static String chooseDirectory() {
        FilesModel fm = new FilesModel();
        return fm.browseDirectory();
    }


    public static boolean readFiles(String path) {
    	System.out.println("Path : " + path);
        FilesModel fm = new FilesModel();
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

}
