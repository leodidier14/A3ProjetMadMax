package Model;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Map_Dic {

    BufferedReader br;
    String ligne;
    String res = "";
    int nbLigne = 0;

    public Map_Dic(String path) throws IOException {
        try {
            this.br = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try
        {
            while ((this.ligne = this.br.readLine()) != null) {
                res = res + ligne + ";";
                nbLigne++;
                System.out.println(nbLigne);
            }
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Erreur de lecture", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        try {
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean findWord(String message) throws IOException {

        //String dic[] = {"Bonjour", "a", "tous", "ceci", "est", "un", "test"};
        message = message.toLowerCase();
        message = message.replace("'", " ");
        message = message.replace(".", "");
        String split[] = message.split(" ");
        boolean isGood = false;
        //int i = 0;
        int goodWord = 0;

        for (int i = 0; i < split.length; i++) {
            if (res.contains(split[i])) {
                System.out.println(split[i]);
                goodWord++;
            }
            //i++;
        }
        if (goodWord == split.length) {
            isGood = true;
        }
        return isGood;
    }
}
