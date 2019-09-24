package view;

import controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilesView extends MainFrame implements ActionListener {
	
		private FilesController filesController;
		private JPanel panel = new JPanel();
	
		public FilesView() {
			//super();	
		   
		   this.panel.setLayout(null);
		   this.window.setContentPane(panel);
		   //JButton buttonSource = new JButton("Source File");
		   JButton buttonSource = new JButton( new AbstractAction("Source File") {
			private static final long serialVersionUID = 1L;
				@Override
		        public void actionPerformed( ActionEvent e ) {
		        	if(filesController.loadFiles()) {
						 JLabel loaded = new JLabel("Loaded");
							panel.add(loaded);
							loaded.setBounds(320, 180, 120, 25);
					}
		        }
		    });
		   buttonSource.setBounds(190, 180, 120, 25);
		   this.panel.add(buttonSource);
		   JButton buttonDestination = new JButton( new AbstractAction("Destination File") {
			private static final long serialVersionUID = 1L;
				@Override
		        public void actionPerformed( ActionEvent e ) {
		        	if(filesController.loadFiles()) {
						 JLabel loaded = new JLabel("Gogogo");
							panel.add(loaded);
							loaded.setBounds(320, 230, 120, 25);
					}
		        }
		    });

		   buttonDestination.setBounds(190, 230, 120, 25);
		   this.panel.add(buttonDestination);	 		  
} 

		public void setController(FilesController filesController) {
			this.filesController = filesController;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}


}
