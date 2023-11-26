package application;

//import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
//import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.UIManager;
//import javax.swing.JLayeredPane;
//import javax.swing.JDesktopPane;
//import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
//import javax.swing.JTextField;
//import javax.swing.OverlayLayout;

public class GUI {

	private JFrame frame;
	private JTabbedPane tabbedPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		
		ImageIcon image = new ImageIcon("logo.jpeg");
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(image.getImage());
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblPortalAcadmico = new JLabel("Portal Acadêmico");
		lblPortalAcadmico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortalAcadmico.setBounds(220, 21, 363, 44);
		lblPortalAcadmico.setFont(new Font("Consolas", Font.BOLD, 40));
		frame.getContentPane().add(lblPortalAcadmico);
		
		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.setBounds(0, 87, 796, 376);
		frame.getContentPane().add(tabbedPanel);
		
		JPanel schoolPanel = new JPanel();
		tabbedPanel.addTab("Escola", null, schoolPanel, null);
		schoolPanel.setLayout(null);
		
		JLabel lblRegistrarEscola = new JLabel(" Registrar Escola");
		lblRegistrarEscola.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrarEscola.setFont(new Font("Consolas", Font.BOLD, 20));
		lblRegistrarEscola.setBounds(0, 10, 781, 24);
		schoolPanel.add(lblRegistrarEscola);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(1);
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton.setBounds(620, 290, 132, 32);
		schoolPanel.add(btnNewButton);
		
		JPanel teacherPanel = new JPanel();
		tabbedPanel.addTab("Professores", null, teacherPanel, null);
		tabbedPanel.setEnabledAt(1, false);
		teacherPanel.setLayout(null);
		
		JLabel lblCadastrarProfessores = new JLabel(" Cadastrar Professores");
		lblCadastrarProfessores.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarProfessores.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCadastrarProfessores.setBounds(0, 10, 781, 24);
		teacherPanel.add(lblCadastrarProfessores);
		
		JButton btnNewButton_1 = new JButton("Continuar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(2);
				tabbedPanel.setEnabledAt(1, true);
			}
		});
		btnNewButton_1.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton_1.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_1.setBounds(620, 290, 132, 32);
		teacherPanel.add(btnNewButton_1);
		
		JButton btnVoltar_1_5 = new JButton("Voltar");
		btnVoltar_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(0);
			}
		});
		btnVoltar_1_5.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar_1_5.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar_1_5.setBounds(32, 290, 132, 32);
		teacherPanel.add(btnVoltar_1_5);
		
		JPanel studentPanel = new JPanel();
		tabbedPanel.addTab("Alunos", null, studentPanel, null);
		tabbedPanel.setEnabledAt(2, false);
		studentPanel.setLayout(null);
		
		JLabel lblCadastrarAlunos = new JLabel(" Cadastrar Alunos");
		lblCadastrarAlunos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarAlunos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCadastrarAlunos.setBounds(0, 10, 781, 24);
		studentPanel.add(lblCadastrarAlunos);
		
		JButton btnNewButton_2 = new JButton("Continuar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(3);
			}
		});
		btnNewButton_2.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton_2.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_2.setBounds(620, 290, 132, 32);
		studentPanel.add(btnNewButton_2);
		
		JButton btnVoltar_1_4 = new JButton("Voltar");
		btnVoltar_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(1);
			}
		});
		btnVoltar_1_4.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar_1_4.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar_1_4.setBounds(32, 290, 132, 32);
		studentPanel.add(btnVoltar_1_4);
		
		JPanel coursePanel = new JPanel();
		tabbedPanel.addTab("Cursos", null, coursePanel, null);
		tabbedPanel.setEnabledAt(3, false);
		coursePanel.setLayout(null);
		
		JLabel lblCriarCursos = new JLabel(" Criar Cursos");
		lblCriarCursos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCriarCursos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCriarCursos.setBounds(0, 10, 781, 24);
		coursePanel.add(lblCriarCursos);
		
		JButton btnVoltar_1_2 = new JButton("Voltar");
		btnVoltar_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(2);
			}
		});
		btnVoltar_1_2.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar_1_2.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar_1_2.setBounds(32, 290, 132, 32);
		coursePanel.add(btnVoltar_1_2);
		
		JButton btnVoltar_1_3 = new JButton("Continuar");
		btnVoltar_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(4);
			}
		});
		btnVoltar_1_3.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVoltar_1_3.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar_1_3.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar_1_3.setBounds(620, 290, 132, 32);
		coursePanel.add(btnVoltar_1_3);
		
		JPanel directorPanel = new JPanel();
		tabbedPanel.addTab("Diretor", null, directorPanel, null);
		tabbedPanel.setEnabledAt(4, false);
		directorPanel.setLayout(null);
		
		JLabel lblRegistrarDiretor = new JLabel(" Registrar Diretor");
		lblRegistrarDiretor.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrarDiretor.setFont(new Font("Consolas", Font.BOLD, 20));
		lblRegistrarDiretor.setBounds(0, 10, 781, 24);
		directorPanel.add(lblRegistrarDiretor);
		
		JButton btnNewButton_3 = new JButton("Continuar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(5);
			}
		});
		btnNewButton_3.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton_3.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_3.setBounds(620, 290, 132, 32);
		directorPanel.add(btnNewButton_3);
		
		JButton btnVoltar_1_1 = new JButton("Voltar");
		btnVoltar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(3);
			}
		});
		btnVoltar_1_1.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar_1_1.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar_1_1.setBounds(32, 290, 132, 32);
		directorPanel.add(btnVoltar_1_1);
		
		JPanel enrollPanel = new JPanel();
		tabbedPanel.addTab("Matrícula", null, enrollPanel, null);
		tabbedPanel.setEnabledAt(5, false);
		enrollPanel.setLayout(null);
		
		JLabel lblMatricularAlunos = new JLabel(" Matricular Alunos");
		lblMatricularAlunos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatricularAlunos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblMatricularAlunos.setBounds(0, 10, 781, 24);
		enrollPanel.add(lblMatricularAlunos);
		
		JButton btnNewButton_4 = new JButton("Continuar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(6);
			}
		});
		btnNewButton_4.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton_4.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_4.setBounds(620, 290, 132, 32);
		enrollPanel.add(btnNewButton_4);
		
		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(4);
			}
		});
		btnVoltar_1.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar_1.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar_1.setBounds(32, 290, 132, 32);
		enrollPanel.add(btnVoltar_1);
		
		JPanel reportPanel = new JPanel();
		tabbedPanel.addTab("Relatório", null, reportPanel, null);
		tabbedPanel.setEnabledAt(6, false);
		reportPanel.setLayout(null);
		
		JLabel lblGerarRelatrioDe = new JLabel(" Gerar Relatório de Notas");
		lblGerarRelatrioDe.setHorizontalAlignment(SwingConstants.LEFT);
		lblGerarRelatrioDe.setFont(new Font("Consolas", Font.BOLD, 20));
		lblGerarRelatrioDe.setBounds(0, 10, 781, 24);
		reportPanel.add(lblGerarRelatrioDe);
		
		JButton btnNewButton_5 = new JButton("Salvar");
		btnNewButton_5.setFont(new Font("Consolas", Font.BOLD, 15));
		btnNewButton_5.setBackground(UIManager.getColor("Button.shadow"));
		btnNewButton_5.setBounds(620, 290, 132, 32);
		reportPanel.add(btnNewButton_5);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(5);
			}
		});
		btnVoltar.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar.setBounds(32, 290, 132, 32);
		reportPanel.add(btnVoltar);
		    
	}
}
