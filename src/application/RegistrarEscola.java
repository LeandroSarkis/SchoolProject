package application;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class RegistrarEscola {

	 JFrame registrarEscola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarEscola regEsc = new RegistrarEscola();
					regEsc.registrarEscola.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistrarEscola() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		registrarEscola = new JFrame();
		registrarEscola.setBounds(100, 100, 450, 300);
		registrarEscola.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
}
