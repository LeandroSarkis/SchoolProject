package application;

import java.awt.Color;
//import java.awt.BorderLayout;
//import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
//import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.UIManager;
//import javax.swing.JLayeredPane;
//import javax.swing.JDesktopPane;
//import javax.swing.JMenuBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import entities.Course;
import entities.Director;
import entities.School;
import entities.Student;
import entities.Teacher;
import util.AddStudentCourse;
import util.CourseReport;
import util.CreateObjects;
//import javax.swing.JTextField;
//import javax.swing.OverlayLayout;

public class AppWindow {

	private JFrame frame;
	private JTabbedPane tabbedPanel;
	private JTextField txtNomeEscola;
	private JTextField txtEnderecoEscola;
	private JTextField txtIDEscola;
	private JTextField txtAnoFundacaoEsc;
	private JTextField txtNomeDoProf;
	private JTextField txtIDProf;
	private JTextField txtDataContratacaoProf;
	private JTextField txtDisciplinaLecionada;
	private JTextField txtNomeAluno;
	private JTextField txtNumeroMatricula;
	private JTextField txtSerie;
	private JTextField txtDataInscricaoAluno;
	private JTextField txtNomeCurso;
	private JTextField txtCodigoCurso;
	private JTextField txtDescricaoCurso;
	private JTextField txtAnoDeInicio;
	private JTextField txtIDDiretor;
	private JTextField txtDataContratacaoDiretor;
	private JTextField txtNotas1;
	private JTextField txtNotas2;
	private JTextField txtNomeDiretor;
	private JComboBox cbxAlunoEscola;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppWindow window = new AppWindow();
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
	public AppWindow() {
		initialize();
	}

	private boolean validateAndSubmit(JPanel panel, JTextField textField) {
		String nome = textField.getText();

		if (nome.isEmpty()) {
			displayErrorMessage(panel, "Campo de nome não pode estar vazio.");
			return false;
		} else if (nome.matches(".*\\d.*")) {
			displayErrorMessage(panel, "O nome não pode conter números.");
			return false;
		} else if (nome.matches(".*[^a-zA-Z].*")) {
			displayErrorMessage(panel, "O nome não pode conter caracteres especiais.");
			return false;
		} else {
			JOptionPane.showMessageDialog(panel, "Nome válido: " + nome, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}

	private static void displayErrorMessage(JPanel panel, String message) {
		JOptionPane.showMessageDialog(panel, message, "Erro", JOptionPane.ERROR_MESSAGE);
	}

	private static void clearErrorMessage(JPanel panel) {
		JOptionPane.getRootFrame().dispose();
	}

	public void atualizarComboBoxEscola(JComboBox comboBOX, List<School> lista) {

		comboBOX.removeAllItems();

		for (int i = 0; i < lista.size(); i++) {
			comboBOX.addItem(lista.get((i)));
		}
	}

	public void atualizarComboBoxProfessor(JComboBox comboBOX, List<Teacher> lista) {

		comboBOX.removeAllItems();

		for (int i = 0; i < lista.size(); i++) {
			comboBOX.addItem(lista.get((i)));
		}
	}

	public void atualizarComboBoxAluno(JComboBox comboBOX, List<Student> lista) {

		comboBOX.removeAllItems();

		for (int i = 0; i < lista.size(); i++) {
			comboBOX.addItem(lista.get((i)));
		}
	}

	public void atualizarComboBoxDiretor(JComboBox comboBOX, List<Director> lista) {

		comboBOX.removeAllItems();

		for (int i = 0; i < lista.size(); i++) {
			comboBOX.addItem(lista.get((i)));
		}
	}

	public void atualizarComboBoxCurso(JComboBox comboBOX, List<Course> lista) {

		comboBOX.removeAllItems();

		for (int i = 0; i < lista.size(); i++) {
			comboBOX.addItem(lista.get((i)));
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {

		List<School> schools = new ArrayList<>();
		List<Course> courses = new ArrayList<>();
		List<Director> directors = new ArrayList<>();
		List<Student> students = new ArrayList<>();
		List<Teacher> teachers = new ArrayList<>();

		ImageIcon image = new ImageIcon("logo.jpeg");
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(image.getImage());
		frame.getContentPane().setLayout(null);

		JLabel lblPortalAcademico = new JLabel("Portal Acadêmico");
		lblPortalAcademico.setHorizontalAlignment(SwingConstants.CENTER);
		lblPortalAcademico.setBounds(220, 21, 363, 44);
		lblPortalAcademico.setFont(new Font("Consolas", Font.BOLD, 40));
		frame.getContentPane().add(lblPortalAcademico);

		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.setBounds(0, 87, 796, 376);
		frame.getContentPane().add(tabbedPanel);

		JPanel schoolPanel = new JPanel();
		tabbedPanel.addTab("Escola", null, schoolPanel, null);
		tabbedPanel.setEnabledAt(0, true);
		schoolPanel.setLayout(null);

		JPanel studentPanel = new JPanel();
		tabbedPanel.addTab("Aluno", null, studentPanel, null);
		studentPanel.setLayout(null);

		JPanel enrollPanel = new JPanel();
		tabbedPanel.addTab("Matrícula", null, enrollPanel, null);
		enrollPanel.setLayout(null);

		JPanel teacherPanel = new JPanel();
		tabbedPanel.addTab("Professores", null, teacherPanel, null);
		teacherPanel.setLayout(null);

		JLabel lblRegistrarEscola = new JLabel(" Registrar Escola");
		lblRegistrarEscola.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrarEscola.setFont(new Font("Consolas", Font.BOLD, 20));
		lblRegistrarEscola.setBounds(0, 10, 781, 24);
		schoolPanel.add(lblRegistrarEscola);

		JPanel coursePanel = new JPanel();
		tabbedPanel.addTab("Cursos", null, coursePanel, null);
		coursePanel.setLayout(null);

		JComboBox cbxCursoEscola = new JComboBox(new Object[] {});
		cbxCursoEscola.setEditable(true);
		cbxCursoEscola.setBounds(519, 178, 171, 21);
		coursePanel.add(cbxCursoEscola);

		@SuppressWarnings("unchecked")
		JComboBox cbxDiretorEscola = new JComboBox(directors.toArray());
		cbxDiretorEscola.setEditable(true);
		cbxDiretorEscola.setBounds(540, 111, 160, 21);
		schoolPanel.add(cbxDiretorEscola);

		@SuppressWarnings("unchecked")
		JComboBox cbxEscolaProfessor = new JComboBox(schools.toArray());
		cbxEscolaProfessor.setEditable(true);
		cbxEscolaProfessor.setBounds(190, 178, 171, 21);
		teacherPanel.add(cbxEscolaProfessor);

		JComboBox cbxAlunoEscola = new JComboBox();
		cbxAlunoEscola.setEditable(true);
		cbxAlunoEscola.setBounds(165, 177, 171, 21);
		studentPanel.add(cbxAlunoEscola);

		JButton btnCriarEscola = new JButton("Criar");
		btnCriarEscola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CreateObjects.createSchool(txtNomeEscola.getText(), txtEnderecoEscola.getText(),
						Integer.parseInt(txtIDEscola.getText()), txtAnoFundacaoEsc.getText(),
						(Director) cbxDiretorEscola.getSelectedItem(), schools);
				atualizarComboBoxEscola(cbxEscolaProfessor, schools);
				atualizarComboBoxEscola(cbxCursoEscola, schools);
				atualizarComboBoxEscola(cbxAlunoEscola, schools);

			}
		});
		btnCriarEscola.setBackground(UIManager.getColor("Button.shadow"));
		btnCriarEscola.setFont(new Font("Consolas", Font.BOLD, 15));
		btnCriarEscola.setBounds(620, 290, 132, 32);
		schoolPanel.add(btnCriarEscola);

		JLabel lblNomeEscola = new JLabel("Nome da Instituição:");
		lblNomeEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeEscola.setBounds(40, 63, 140, 18);
		schoolPanel.add(lblNomeEscola);

		txtNomeEscola = new JTextField();
		txtNomeEscola.setBounds(188, 62, 160, 19);
		schoolPanel.add(txtNomeEscola);
		txtNomeEscola.setColumns(10);

		JLabel lblEnderecoEscola = new JLabel("Endereço:");
		lblEnderecoEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnderecoEscola.setBounds(40, 113, 126, 18);
		schoolPanel.add(lblEnderecoEscola);

		txtEnderecoEscola = new JTextField();
		txtEnderecoEscola.setColumns(10);
		txtEnderecoEscola.setBounds(174, 112, 174, 19);
		schoolPanel.add(txtEnderecoEscola);

		JLabel lblIDEscola = new JLabel("Nº de Identificação:");
		lblIDEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIDEscola.setBounds(40, 159, 155, 18);
		schoolPanel.add(lblIDEscola);

		txtIDEscola = new JTextField();
		txtIDEscola.setColumns(10);
		txtIDEscola.setBounds(216, 158, 132, 19);
		schoolPanel.add(txtIDEscola);

		JLabel lblAnoFundacaoEsc = new JLabel("Ano de Fundação:");
		lblAnoFundacaoEsc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnoFundacaoEsc.setBounds(404, 65, 126, 16);
		schoolPanel.add(lblAnoFundacaoEsc);

		txtAnoFundacaoEsc = new JTextField();
		txtAnoFundacaoEsc.setColumns(10);
		txtAnoFundacaoEsc.setBounds(540, 62, 160, 19);
		schoolPanel.add(txtAnoFundacaoEsc);

		JLabel lblDiretorEscola = new JLabel("Diretor(a):");
		lblDiretorEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiretorEscola.setBounds(404, 115, 126, 16);
		schoolPanel.add(lblDiretorEscola);

		JComboBox cbxCursoProfessor = new JComboBox(new Object[] {});
		cbxCursoProfessor.setEditable(true);
		cbxCursoProfessor.setBounds(164, 178, 171, 21);
		coursePanel.add(cbxCursoProfessor);

		JLabel lblCadastrarProfessores = new JLabel(" Cadastrar Professores");
		lblCadastrarProfessores.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarProfessores.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCadastrarProfessores.setBounds(0, 10, 781, 24);
		teacherPanel.add(lblCadastrarProfessores);

		JButton btnCriarProf = new JButton("Criar");
		btnCriarProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				tabbedPanel.setEnabledAt(1, true);
				CreateObjects.createTeacher(txtNomeDoProf.getText(), Integer.parseInt(txtIDProf.getText()),
						txtDataContratacaoProf.getText(), txtDisciplinaLecionada.getText(),
						(School) cbxEscolaProfessor.getSelectedItem(), teachers);
				System.out.println("criado!");
				atualizarComboBoxProfessor(cbxCursoProfessor, teachers);

			}
		});
		btnCriarProf.setFont(new Font("Consolas", Font.BOLD, 15));
		btnCriarProf.setBackground(UIManager.getColor("Button.shadow"));
		btnCriarProf.setBounds(620, 290, 132, 32);
		teacherPanel.add(btnCriarProf);

		JButton btnVoltar1 = new JButton("Voltar");
		btnVoltar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(0);
			}
		});
		btnVoltar1.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar1.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar1.setBounds(32, 290, 132, 32);
		teacherPanel.add(btnVoltar1);

		JLabel lblNomeDoProf = new JLabel("Nome do Educador:");
		lblNomeDoProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeDoProf.setBounds(40, 63, 140, 18);
		teacherPanel.add(lblNomeDoProf);

		txtNomeDoProf = new JTextField();
		txtNomeDoProf.setColumns(10);
		txtNomeDoProf.setBounds(190, 62, 171, 19);
		teacherPanel.add(txtNomeDoProf);

		JLabel lblIDProf = new JLabel("Nº de Identificação:");
		lblIDProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIDProf.setBounds(40, 120, 140, 18);
		teacherPanel.add(lblIDProf);

		txtIDProf = new JTextField();
		txtIDProf.setColumns(10);
		txtIDProf.setBounds(190, 119, 171, 19);
		teacherPanel.add(txtIDProf);

		JLabel lblDataContrataoProf = new JLabel("Data de Contratação:");
		lblDataContrataoProf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataContrataoProf.setBounds(416, 64, 151, 17);
		teacherPanel.add(lblDataContrataoProf);

		txtDataContratacaoProf = new JTextField();
		txtDataContratacaoProf.setColumns(10);
		txtDataContratacaoProf.setBounds(577, 63, 160, 19);
		teacherPanel.add(txtDataContratacaoProf);

		JLabel lblDisciplinaLecionada = new JLabel("Disciplina Lecionada:");
		lblDisciplinaLecionada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDisciplinaLecionada.setBounds(421, 123, 140, 13);
		teacherPanel.add(lblDisciplinaLecionada);

		txtDisciplinaLecionada = new JTextField();
		txtDisciplinaLecionada.setColumns(10);
		txtDisciplinaLecionada.setBounds(577, 120, 160, 19);
		teacherPanel.add(txtDisciplinaLecionada);

		JLabel lblEscola_1 = new JLabel("Escola:");
		lblEscola_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscola_1.setBounds(126, 177, 54, 18);
		teacherPanel.add(lblEscola_1);

		JPanel directorPanel = new JPanel();
		tabbedPanel.addTab("Diretor", null, directorPanel, null);
		tabbedPanel.setEnabledAt(2, true);
		directorPanel.setLayout(null);

		JLabel lblRegistrarDiretor = new JLabel(" Registrar Diretor Associado");
		lblRegistrarDiretor.setHorizontalAlignment(SwingConstants.LEFT);
		lblRegistrarDiretor.setFont(new Font("Consolas", Font.BOLD, 20));
		lblRegistrarDiretor.setBounds(0, 10, 781, 24);
		directorPanel.add(lblRegistrarDiretor);

		JButton btnCriarDiretor = new JButton("Criar");
		btnCriarDiretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validateAndSubmit(directorPanel, txtNomeDiretor);
				if (validateAndSubmit(directorPanel, txtNomeDiretor) == true) {
					CreateObjects.createDirector(txtNomeDiretor.getText(), Integer.parseInt(txtIDDiretor.getText()),
							txtDataContratacaoDiretor.getText(), directors);
					System.out.println("criado");
					atualizarComboBoxDiretor(cbxDiretorEscola, directors);
				}
			}
		});
		btnCriarDiretor.setFont(new Font("Consolas", Font.BOLD, 15));
		btnCriarDiretor.setBackground(UIManager.getColor("Button.shadow"));
		btnCriarDiretor.setBounds(620, 290, 132, 32);
		directorPanel.add(btnCriarDiretor);

		JButton btnVoltar4 = new JButton("Voltar");
		btnVoltar4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(3);
			}
		});
		btnVoltar4.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar4.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar4.setBounds(32, 290, 132, 32);
		directorPanel.add(btnVoltar4);

		JLabel lblNomeDiretor = new JLabel("Nome:");
		lblNomeDiretor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeDiretor.setBounds(120, 63, 44, 18);
		directorPanel.add(lblNomeDiretor);

		JLabel lblIDDiretor = new JLabel("Nº de Identificação:");
		lblIDDiretor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIDDiretor.setBounds(40, 127, 140, 18);
		directorPanel.add(lblIDDiretor);

		txtIDDiretor = new JTextField();
		txtIDDiretor.setColumns(10);
		txtIDDiretor.setBounds(190, 126, 171, 19);
		directorPanel.add(txtIDDiretor);

		JLabel lblDataContratacaoDiretor = new JLabel("Data de Contratação:");
		lblDataContratacaoDiretor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataContratacaoDiretor.setBounds(431, 64, 151, 17);
		directorPanel.add(lblDataContratacaoDiretor);

		txtDataContratacaoDiretor = new JTextField();
		txtDataContratacaoDiretor.setColumns(10);
		txtDataContratacaoDiretor.setBounds(592, 63, 160, 19);
		directorPanel.add(txtDataContratacaoDiretor);

		txtNomeDiretor = new JTextField();
		txtNomeDiretor.setColumns(10);
		txtNomeDiretor.setBounds(190, 64, 171, 19);
		directorPanel.add(txtNomeDiretor);

		JLabel lblCadastrarAlunos = new JLabel(" Cadastrar Alunos");
		lblCadastrarAlunos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastrarAlunos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCadastrarAlunos.setBounds(0, 10, 781, 24);
		studentPanel.add(lblCadastrarAlunos);

		@SuppressWarnings("unchecked")
		JComboBox cbxMatricularAluno = new JComboBox(students.toArray());
		cbxMatricularAluno.setEditable(true);
		cbxMatricularAluno.setBounds(348, 58, 160, 21);
		enrollPanel.add(cbxMatricularAluno);

		JButton btnCriarAluno = new JButton("Criar");
		btnCriarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateObjects.createStudent(txtNomeAluno.getText(), Integer.parseInt(txtNumeroMatricula.getText()),
						txtSerie.getText(), txtDataInscricaoAluno.getText(), (School) cbxAlunoEscola.getSelectedItem(),
						students);

				atualizarComboBoxAluno(cbxMatricularAluno, students);
				
				System.out.println(students);

			}
		});
		btnCriarAluno.setFont(new Font("Consolas", Font.BOLD, 15));
		btnCriarAluno.setBackground(UIManager.getColor("Button.shadow"));
		btnCriarAluno.setBounds(620, 290, 132, 32);
		studentPanel.add(btnCriarAluno);

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

		JLabel lblNomeDoAluno = new JLabel("Nome do Aluno:");
		lblNomeDoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeDoAluno.setBounds(40, 63, 124, 18);
		studentPanel.add(lblNomeDoAluno);

		txtNomeAluno = new JTextField();
		txtNomeAluno.setColumns(10);
		txtNomeAluno.setBounds(165, 62, 171, 19);
		studentPanel.add(txtNomeAluno);

		JLabel lblNumeroMatrcula = new JLabel("Nº da Matrícula:");
		lblNumeroMatrcula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroMatrcula.setBounds(40, 122, 124, 16);
		studentPanel.add(lblNumeroMatrcula);

		txtNumeroMatricula = new JTextField();
		txtNumeroMatricula.setColumns(10);
		txtNumeroMatricula.setBounds(165, 122, 171, 19);
		studentPanel.add(txtNumeroMatricula);

		JLabel lblSerie = new JLabel("Série:");
		lblSerie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSerie.setBounds(414, 64, 88, 16);
		studentPanel.add(lblSerie);

		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(511, 65, 171, 19);
		studentPanel.add(txtSerie);

		JLabel lblDataInscricaoAluno = new JLabel("Data de Inscrição:");
		lblDataInscricaoAluno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDataInscricaoAluno.setBounds(414, 125, 124, 16);
		studentPanel.add(lblDataInscricaoAluno);

		txtDataInscricaoAluno = new JTextField();
		txtDataInscricaoAluno.setColumns(10);
		txtDataInscricaoAluno.setBounds(558, 123, 124, 19);
		studentPanel.add(txtDataInscricaoAluno);

		JLabel lblEscola = new JLabel("Escola:");
		lblEscola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscola.setBounds(104, 177, 60, 21);
		studentPanel.add(lblEscola);

		JLabel lblMatricularAlunos = new JLabel(" Matricular Alunos");
		lblMatricularAlunos.setHorizontalAlignment(SwingConstants.LEFT);
		lblMatricularAlunos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblMatricularAlunos.setBounds(0, 10, 781, 24);
		enrollPanel.add(lblMatricularAlunos);

		JComboBox cbxCursoMatricula = new JComboBox();
		cbxCursoMatricula.setEditable(true);
		cbxCursoMatricula.setBounds(348, 112, 160, 21);
		enrollPanel.add(cbxCursoMatricula);

		JButton btnCriarMatricula = new JButton("Criar");
		btnCriarMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentCourse.addStudentCourse((Student) cbxMatricularAluno.getSelectedItem(),
						(Course) cbxCursoMatricula.getSelectedItem(), Double.valueOf(txtNotas1.getText()),
						Double.valueOf(txtNotas2.getText()));
			}
		});
		btnCriarMatricula.setFont(new Font("Consolas", Font.BOLD, 15));
		btnCriarMatricula.setBackground(UIManager.getColor("Button.shadow"));
		btnCriarMatricula.setBounds(620, 290, 132, 32);
		enrollPanel.add(btnCriarMatricula);

		JButton btnVoltar5 = new JButton("Voltar");
		btnVoltar5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(4);
			}
		});
		btnVoltar5.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar5.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar5.setBounds(32, 290, 132, 32);
		enrollPanel.add(btnVoltar5);

		JLabel lblNomeAlunoMatricula = new JLabel("Aluno:");
		lblNomeAlunoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeAlunoMatricula.setBounds(274, 57, 64, 18);
		enrollPanel.add(lblNomeAlunoMatricula);

		JLabel lblCursoMatricula = new JLabel("Curso:");
		lblCursoMatricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCursoMatricula.setBounds(274, 111, 64, 18);
		enrollPanel.add(lblCursoMatricula);

		JLabel lblNotas1 = new JLabel("Notas do 1º Bimestre:");
		lblNotas1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotas1.setBounds(226, 169, 160, 18);
		enrollPanel.add(lblNotas1);

		txtNotas1 = new JTextField();
		txtNotas1.setBounds(411, 171, 112, 19);
		enrollPanel.add(txtNotas1);
		txtNotas1.setColumns(10);

		JLabel lblNotas2 = new JLabel("Notas do 2º Bimestre:");
		lblNotas2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotas2.setBounds(226, 219, 160, 18);
		enrollPanel.add(lblNotas2);

		txtNotas2 = new JTextField();
		txtNotas2.setColumns(10);
		txtNotas2.setBounds(411, 221, 112, 19);
		enrollPanel.add(txtNotas2);

		JPanel reportPanel = new JPanel();
		tabbedPanel.addTab("Relatório", null, reportPanel, null);
		tabbedPanel.setEnabledAt(5, true);
		reportPanel.setLayout(null);

		JLabel lblGerarRelatrio = new JLabel(" Gerar Relatório de Notas");
		lblGerarRelatrio.setHorizontalAlignment(SwingConstants.LEFT);
		lblGerarRelatrio.setFont(new Font("Consolas", Font.BOLD, 20));
		lblGerarRelatrio.setBounds(0, 10, 781, 24);
		reportPanel.add(lblGerarRelatrio);

		JComboBox cbxSelecionarCurso = new JComboBox();
		cbxSelecionarCurso.setEditable(true);
		cbxSelecionarCurso.setBounds(160, 45, 125, 18);
		reportPanel.add(cbxSelecionarCurso);

		JTextArea textAreaRelatorio = new JTextArea();
		textAreaRelatorio.setBounds(174, 143, 448, 179);
		reportPanel.add(textAreaRelatorio);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(174, 143, 448, 179);
		scrollPane.getViewport().setBackground(Color.white);
		scrollPane.getViewport().add(textAreaRelatorio);
		
		reportPanel.add(scrollPane);

		JButton btnGerarRelatorio = new JButton("Gerar");
		btnGerarRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaRelatorio.setText(CourseReport.generateReport((Course) cbxSelecionarCurso.getSelectedItem()));
			}
		});
		btnGerarRelatorio.setFont(new Font("Consolas", Font.BOLD, 15));
		btnGerarRelatorio.setBackground(UIManager.getColor("Button.shadow"));
		btnGerarRelatorio.setBounds(632, 290, 132, 32);
		reportPanel.add(btnGerarRelatorio);

		JButton btnVoltar6 = new JButton("Voltar");
		btnVoltar6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(5);
			}
		});
		btnVoltar6.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar6.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar6.setBounds(32, 290, 132, 32);
		reportPanel.add(btnVoltar6);

		JLabel lblSelecionarCurso = new JLabel("Selecionar Curso:");
		lblSelecionarCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSelecionarCurso.setBounds(10, 45, 140, 18);
		reportPanel.add(lblSelecionarCurso);

		JLabel lblCursoSelecionado = new JLabel("Curso Selecionado:");
		lblCursoSelecionado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCursoSelecionado.setBounds(10, 95, 140, 18);
		reportPanel.add(lblCursoSelecionado);

		JLabel lblCursoResultado = new JLabel("...........................................");
		lblCursoResultado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCursoResultado.setBounds(163, 95, 122, 18);
		reportPanel.add(lblCursoResultado);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCursoResultado.setText(cbxSelecionarCurso.getSelectedItem().toString());
			}
		});
		btnOK.setFont(new Font("Consolas", Font.PLAIN, 15));
		btnOK.setBackground(UIManager.getColor("Button.shadow"));
		btnOK.setBounds(295, 45, 92, 20);
		reportPanel.add(btnOK);

		JLabel lblRelatrioDeNotas = new JLabel("Relatório de Notas:");
		lblRelatrioDeNotas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRelatrioDeNotas.setBounds(10, 144, 140, 18);
		reportPanel.add(lblRelatrioDeNotas);

		JLabel lblCriarCursos = new JLabel(" Criar Cursos");
		lblCriarCursos.setHorizontalAlignment(SwingConstants.LEFT);
		lblCriarCursos.setFont(new Font("Consolas", Font.BOLD, 20));
		lblCriarCursos.setBounds(0, 10, 781, 24);
		coursePanel.add(lblCriarCursos);

		JButton btnVoltar3 = new JButton("Voltar");
		btnVoltar3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPanel.setSelectedIndex(2);
			}
		});
		btnVoltar3.setFont(new Font("Consolas", Font.BOLD, 15));
		btnVoltar3.setBackground(UIManager.getColor("Button.shadow"));
		btnVoltar3.setBounds(32, 290, 132, 32);
		coursePanel.add(btnVoltar3);

		JButton btnCriarCurso = new JButton("Criar");
		btnCriarCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateObjects.createCourse(txtNomeCurso.getText(), Integer.parseInt(txtCodigoCurso.getText()),
						txtDescricaoCurso.getText(), txtAnoDeInicio.getText(),
						(Teacher) cbxCursoProfessor.getSelectedItem(), (School) cbxCursoEscola.getSelectedItem(),
						courses);
				atualizarComboBoxCurso(cbxCursoMatricula, courses);
				atualizarComboBoxCurso(cbxSelecionarCurso, courses);

			};
		});
		btnCriarCurso.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCriarCurso.setFont(new Font("Consolas", Font.BOLD, 15));
		btnCriarCurso.setBackground(UIManager.getColor("Button.shadow"));
		btnCriarCurso.setBounds(620, 290, 132, 32);
		coursePanel.add(btnCriarCurso);

		JLabel lblNomeDoCurso = new JLabel("Nome do Curso:");
		lblNomeDoCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomeDoCurso.setBounds(40, 63, 124, 24);
		coursePanel.add(lblNomeDoCurso);

		txtNomeCurso = new JTextField();
		txtNomeCurso.setColumns(10);
		txtNomeCurso.setBounds(164, 68, 171, 19);
		coursePanel.add(txtNomeCurso);

		JLabel lblCodigoCurso = new JLabel("Código do Curso:");
		lblCodigoCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodigoCurso.setBounds(40, 121, 124, 18);
		coursePanel.add(lblCodigoCurso);

		txtCodigoCurso = new JTextField();
		txtCodigoCurso.setColumns(10);
		txtCodigoCurso.setBounds(164, 123, 171, 19);
		coursePanel.add(txtCodigoCurso);

		JLabel lblDescricaoCurso = new JLabel("Descrição:");
		lblDescricaoCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricaoCurso.setBounds(419, 66, 105, 18);
		coursePanel.add(lblDescricaoCurso);

		txtDescricaoCurso = new JTextField();
		txtDescricaoCurso.setColumns(10);
		txtDescricaoCurso.setBounds(519, 67, 171, 19);
		coursePanel.add(txtDescricaoCurso);

		JLabel lblAnoDeInicio = new JLabel("Ano de Ínicio:");
		lblAnoDeInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnoDeInicio.setBounds(419, 121, 105, 18);
		coursePanel.add(lblAnoDeInicio);

		txtAnoDeInicio = new JTextField();
		txtAnoDeInicio.setColumns(10);
		txtAnoDeInicio.setBounds(519, 122, 171, 19);
		coursePanel.add(txtAnoDeInicio);

		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProfessor.setBounds(88, 181, 66, 18);
		coursePanel.add(lblProfessor);

		JLabel lblEscola_2 = new JLabel("Escola:");
		lblEscola_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEscola_2.setBounds(464, 181, 45, 18);
		coursePanel.add(lblEscola_2);

	}
}
