package View;
import Controller.FilesController;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FilesView extends MainFrame {

 private FilesController filesController;
 private JPanel panel = new JPanel();
 private List l1 = new List(4, false);
 public FilesView() {
	 
	 this.panel.setLayout(null);
	 this.window.setContentPane(panel);
	  
  JLabel title = new JLabel("MadMaxDecrypt");
  Font font = new Font("Arial", Font.BOLD, 18);
  title.setFont(font);
  this.panel.add(title);
  title.setBounds(120, 30, 200, 25);
  
  
  
  JButton buttonSource = new JButton(new AbstractAction("Charger un fichier") {
   private static final long serialVersionUID = 1L;
   public void actionPerformed(ActionEvent e) {
    filesController.chooseFile();
    refresh();
   }
  });
  buttonSource.setBounds(110, 80, 170, 25);
  this.panel.add(buttonSource);

  
  JButton buttonDestination = new JButton(new AbstractAction("Dossier de destination") {
   private static final long serialVersionUID = 1L;
   @Override
   public void actionPerformed(ActionEvent e) {
     
     JLabel loaded = new JLabel(filesController.chooseDirectory());
     panel.add(loaded);
     loaded.setBounds(110, 150,270, 25);
     
   }
  });
  buttonDestination.setBounds(110, 120, 170, 25);
  this.panel.add(buttonDestination);

  JLabel label = new JLabel();
  label.setBounds(110, 270, 170, 70);

  JButton b = new JButton("Fichier � decrypter");
  b.setBounds(110, 190, 170, 25);
 
  l1.setBounds(110, 220, 170, 70);
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
	    String data = l1.getItem(l1.getSelectedIndex()) + " decrypt�";
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

 public void refresh() {
	 l1.removeAll();
	 System.out.println("bouton");
	  File repertoire = new File("D:\\Users\\leodi\\Bureau\\test");
	  String liste[] = repertoire.list();
	  if (liste != null) {
	   for (int i = 0; i < liste.length; i++) {  
	    l1.add(liste[i]);
	   }
	  }
 }


}