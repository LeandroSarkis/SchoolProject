package application;

//import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.Dimension;
import java.awt.Font;
//import java.awt.GridBagConstraints;
//import java.awt.GridBagLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//import javax.swing.OverlayLayout;

public class Main {

    public static void main(String[] args) {

        //Color powderBlue = new Color(182, 208, 226);
        Color offWhite = new Color(250, 249, 246);
        
        MyFrame myFrame = new MyFrame();
        myFrame.getContentPane().setBackground(new Color(250, 249, 246));
        myFrame.setBackground(offWhite);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myFrame.getContentPane().setLayout(null);
                
                JLabel cadastroLabel = new JLabel("Portal Acadêmico");
                cadastroLabel.setBounds(0, 46, 786, 231);
                cadastroLabel.setBackground(new Color(250, 249, 246));
                cadastroLabel.setHorizontalAlignment(SwingConstants.CENTER);
                cadastroLabel.setForeground(new Color(0, 71, 171));
                cadastroLabel.setFont(new Font("Courier New", Font.BOLD, 50));
                myFrame.getContentPane().add(cadastroLabel);
                
                JPanel initialPanel = new JPanel();
                initialPanel.setBounds(0, 231, 786, 231);
                initialPanel.setBackground(new Color(250, 249, 246));
                myFrame.getContentPane().add(initialPanel);
                initialPanel.setLayout(null);
                
                JButton registrarButton = new JButton("Registrar Escola");
                registrarButton.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                		RegistrarEscola regEsc = new RegistrarEscola();
                		regEsc.registrarEscola.setVisible(true);
                		JFrame jFrame = new JFrame();
						jFrame.dispose();
                		
                	}
                });
                registrarButton.setBounds(130, 54, 187, 27);
                registrarButton.setForeground(new Color(250, 249, 246));
                registrarButton.setFont(new Font("Courier New", Font.PLAIN, 16));
                registrarButton.setBackground(new Color(0, 71, 171));
                initialPanel.add(registrarButton);
                
                JButton gerenciarButton = new JButton("Gerenciar Cadastros");
                gerenciarButton.setBounds(440, 54, 215, 27);
                gerenciarButton.setForeground(new Color(250, 249, 246));
                gerenciarButton.setFont(new Font("Courier New", Font.PLAIN, 16));
                gerenciarButton.setBackground(new Color(0, 71, 171));
                initialPanel.add(gerenciarButton);

        myFrame.setSize(800, 500);
        myFrame.setVisible(true);
    }
}