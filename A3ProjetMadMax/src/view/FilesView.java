package view;

import controller.*;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilesView extends MainFrame implements ActionListener {

 private FilesController filesController;
 private JPanel panel = new JPanel();

 public FilesView() {

  JLabel title = new JLabel("MadMaxDecrypt");
  Font font = new Font("Arial", Font.BOLD, 18);
  title.setFont(font);
  this.panel.add(title);
  title.setBounds(170, 30, 200, 25);
  this.panel.setLayout(null);
  this.window.setContentPane(panel);
  
  JButton buttonSource = new JButton(new AbstractAction("Charger un fichier") {
   private static final long serialVersionUID = 1L;
   public void actionPerformed(ActionEvent e) {
    filesController.chooseFile();
    window.repaint();
    window.revalidate();
   }
  });
  buttonSource.setBounds(160, 80, 170, 25);
  this.panel.add(buttonSource);
  
  JButton buttonDestination = new JButton(new AbstractAction("Dossier de destination") {
   private static final long serialVersionUID = 1L;
   @Override
   public void actionPerformed(ActionEvent e) {
    if (filesController.chooseDirectory()) {
     JLabel loaded = new JLabel("Destination choisie");
     panel.add(loaded);
     loaded.setBounds(160, 150, 170, 25);
    } 
   }
  });
  buttonDestination.setBounds(160, 120, 170, 25);
  this.panel.add(buttonDestination);

  JLabel label = new JLabel();
  label.setBounds(160, 270, 170, 70);

  JButton b = new JButton("Fichier à decrypter");
  b.setBounds(160, 190, 170, 25);
  List l1 = new List(4, false);
  l1.setBounds(160, 220, 170, 70);
  this.panel.add(l1);
  this.panel.add(b);
  this.panel.add(label);

  
  File repertoire = new File("D:\\Users\\leodi\\Bureau\\test");
  String liste[] = repertoire.list();
  if (liste != null) {
   for (int i = 0; i < liste.length; i++) {
    l1.add(liste[i]);
   }
  }
  
  b.addActionListener(new ActionListener() {
	   public void actionPerformed(ActionEvent e) {
	    String data = l1.getItem(l1.getSelectedIndex()) + " decrypté";
	    String path = repertoire + "\\" + l1.getItem(l1.getSelectedIndex());
	    System.out.println(path);
	    filesController.readFiles(path);
	    label.setText(data);
	   }
	  });

 }
 
 
 
 public void setController(FilesController filesController) {
  this.filesController = filesController;
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub

 }



}