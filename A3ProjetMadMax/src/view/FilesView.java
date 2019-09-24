package view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class FilesView extends MainFrame {
	
		public FilesView() {
			//super();	
			JPanel panel = new JPanel();
		   panel.setLayout(null);
		   this.window.setContentPane(panel);
		   JButton buttonSource = new JButton("Source File");
		   buttonSource.setBounds(190, 180, 120, 25);
		   panel.add(buttonSource);
		   JButton buttonDestination = new JButton("Destination File");
		   buttonDestination.setBounds(190, 225, 120, 25);
		   panel.add(buttonDestination);

}
}
