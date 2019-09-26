package View;

import Controller.StateController;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame  extends JFrame{

	private JPanel current;
	private StateController stateController;

	public MainFrame(StateController state) {
		this.setTitle("MadMaxDecrpyt");
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new AuthForm());
		this.setVisible(true);
	}

	public void changeCurrentFrame(JPanel panel)
	{
		this.setContentPane(panel);
		this.repaint();
		this.revalidate();
	}
}
