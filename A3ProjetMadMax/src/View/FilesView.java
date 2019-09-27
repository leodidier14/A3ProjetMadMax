package View;

import Controller.FilesController;
import Controller.StateController;
import Model.FilesModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class FilesView extends JPanel {

    private List l1 = new List(5, false);
    private String destDirectory = "C:\\Users\\Lafarge Dylan\\Documents\\aaa2";
    private static JPanel pan;

    public FilesView() {

        pan= this;
        this.setLayout(null);
        JLabel title = new JLabel("MadMaxDecrypt");
        title.setBounds(120, 30, 200, 25);
        Font font = new Font("Arial", Font.BOLD, 18);
        title.setFont(font);
        this.add(title);

        JButton buttonSource = new JButton(new AbstractAction("Charger un fichier") {
            public void actionPerformed(ActionEvent e) {
                FilesController.chooseFile();
                refresh();
            }
        });
        buttonSource.setBounds(110, 80, 170, 25);
        this.add(buttonSource);


        JButton buttonDestination = new JButton(new AbstractAction("Dossier de destination") {
            //@Override
            public void actionPerformed(ActionEvent e) {
                destDirectory = FilesController.chooseDirectory();
                JLabel loaded = new JLabel(destDirectory);
                loaded.setBounds(110, 150, 270, 25);
                pan.add(loaded);
                StateController.updateFrame();

            }
        });
        buttonDestination.setBounds(110, 120, 170, 25);
        this.add(buttonDestination);

        JLabel label = new JLabel();
        label.setBounds(110, 270, 170, 70);

        JButton b = new JButton("Fichier � decrypter");
        b.setBounds(110, 190, 170, 25);

        l1.setBounds(110, 220, 170, 70);
        this.add(l1);
        this.add(b);
        this.add(label);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(l1.getSelectedItem() != null)
                {
                    String data = l1.getItem(l1.getSelectedIndex()) + " decrypt�";
                    String path = l1.getItem(l1.getSelectedIndex());
                    System.out.println(path);
                    FilesController.readFiles(path);
                    FilesController.mooveFile();
                    label.setText(data);
                }
                else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Veuillez selectionner un fichier", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        if(StateController.getCurrentUser() != null)
        {
            for(FilesModel file : StateController.getCurrentUser().getFiles())
            {
                System.out.println(file.getPath());
                l1.add(file.getPath());
            }
        }


        JButton btn_disconnect = new JButton("Deconnexion");
        btn_disconnect.setBounds(0, 0, 120, 30);
        btn_disconnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StateController.changeState();
                StateController.setCurrentUser(null);
            }
        });
        this.add(btn_disconnect);

    }

    public void refresh() {
        l1.removeAll();
        if(StateController.getCurrentUser() != null)
        {
           /* for(String path : StateController.getCurrentUser().getFiles())
            {
                l1.add(path);
            }*/
        }
        StateController.updateFrame();
    }


}