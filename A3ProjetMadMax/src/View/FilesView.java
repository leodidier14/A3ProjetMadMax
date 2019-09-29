package View;

import Controller.FilesController;
import Controller.StateController;
import Model.FilesModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FilesView extends JPanel {

    private String destDirectory = "C:\\Users\\Lafarge Dylan\\Documents\\aaa2";
    private static JPanel pan;

    public FilesView() {

        pan = this;
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

        JButton b = new JButton("Fichier a decrypter");
        b.setBounds(110, 190, 170, 25);

        JList l1 = new JList();

        l1.setBounds(110, 220, 170, 70);
        this.add(l1);
        this.add(b);
        this.add(label);

        if (StateController.getCurrentUser() != null) {
            l1.setListData(StateController.getCurrentUser().getFiles().toArray());
        }
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (l1.getSelectedValue() != null) {
                    FilesModel fm = (FilesModel) l1.getSelectedValue();
                    String path = fm.getPath();
                    FilesController.readFiles(path);
                    FilesController.mooveFile(fm.getID());
                    label.setText(path);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Veuillez selectionner un fichier", "Erreur", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


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
        StateController.updateFrame();
    }


}