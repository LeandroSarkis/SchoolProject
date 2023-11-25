package application;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import java.awt.Color;

public class MyFrame extends JFrame {
	
	MyFrame(){
		
		
		this.setTitle("PORTAL ACADÊMICO");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(700, 500);
		this.setVisible(true);
		
		ImageIcon image = new ImageIcon("logo.jpeg");
		this.setIconImage(image.getImage());
		//this.getContentPane().setBackground(new Color(218, 222, 227));
		
	}

}
