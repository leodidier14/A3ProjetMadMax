package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {
		   JFrame window = new JFrame();
		   window.setVisible(true);
		   window.setSize(500, 500);
		   window.setLocationRelativeTo(null);
		   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
		   
		   JPanel panel = new JPanel();
		   panel.setLayout(null);
		   window.setContentPane(panel);
		   JButton buttonSource = new JButton("Source File");
		   buttonSource.setBounds(190, 180, 120, 25);
		   panel.add(buttonSource);
		   JButton buttonDestination = new JButton("Destination File");
		   buttonDestination.setBounds(190, 225, 120, 25);
		   panel.add(buttonDestination);

	}

}
