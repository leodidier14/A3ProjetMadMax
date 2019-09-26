package Model;

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
}
