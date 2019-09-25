package View;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	
	 protected JFrame window = new JFrame();
	 
	 
	public MainFrame() {
		this.window.setTitle("MadMaxDecrpyt");
		this.window.setVisible(true);
		this.window.setSize(400, 400);
		this.window.setLocationRelativeTo(null);
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setResizable(false); 
	}
}
