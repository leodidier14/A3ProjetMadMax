package view;

import javax.swing.JFrame;

public class MainFrame {
	
	 protected JFrame window = new JFrame();
	 
	public MainFrame() {
		this.window.setTitle("MadMaxDecrpyt");
		this.window.setVisible(true);
		this.window.setSize(500, 500);
		this.window.setLocationRelativeTo(null);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setResizable(false); 
	}
}
