package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Boletim extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtDisciplina;
	private JTextField txtBimestre3;
	private JTextField txtBimestre1;
	private JTextField txtBimestre2;
	private JTextField txtBimestre4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Boletim frame = new Boletim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Boletim() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Boletim.class.getResource("/img/boletim.png")));
		setTitle("Calculando a Media do Boletim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(10, 71, 46, 14);
		contentPane.add(lblIdade);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setBounds(10, 96, 70, 14);
		contentPane.add(lblDisciplina);

		JLabel lbl1bimestre = new JLabel("1\u00BA Bimestre");
		lbl1bimestre.setBounds(20, 140, 78, 14);
		contentPane.add(lbl1bimestre);

		JLabel lbl3bimestre = new JLabel("3\u00BA Bimestre");
		lbl3bimestre.setBounds(214, 140, 78, 14);
		contentPane.add(lbl3bimestre);

		JLabel lbl2bimestre = new JLabel("2\u00BA Bimestre");
		lbl2bimestre.setBounds(20, 190, 78, 14);
		contentPane.add(lbl2bimestre);

		JLabel lbl4bimestre = new JLabel("4\u00BA Bimestre");
		lbl4bimestre.setBounds(214, 190, 78, 14);
		contentPane.add(lbl4bimestre);

		txtNome = new JTextField();
		txtNome.setBounds(60, 43, 240, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtIdade = new JTextField();
		txtIdade.setBounds(90, 71, 86, 20);
		contentPane.add(txtIdade);
		txtIdade.setColumns(10);

		txtDisciplina = new JTextField();
		txtDisciplina.setBounds(90, 93, 86, 20);
		contentPane.add(txtDisciplina);
		txtDisciplina.setColumns(10);

		txtBimestre3 = new JTextField();
		txtBimestre3.setBounds(301, 137, 62, 20);
		contentPane.add(txtBimestre3);
		txtBimestre3.setColumns(10);

		txtBimestre1 = new JTextField();
		txtBimestre1.setColumns(10);
		txtBimestre1.setBounds(101, 137, 62, 20);
		contentPane.add(txtBimestre1);

		txtBimestre2 = new JTextField();
		txtBimestre2.setColumns(10);
		txtBimestre2.setBounds(101, 190, 62, 20);
		contentPane.add(txtBimestre2);

		txtBimestre4 = new JTextField();
		txtBimestre4.setColumns(10);
		txtBimestre4.setBounds(301, 190, 62, 20);
		contentPane.add(txtBimestre4);

		JButton media = new JButton("Media");
		media.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				media();
			}

		});
		media.setBounds(320, 227, 89, 23);
		contentPane.add(media);

	}

	// Fim do Construtor
	void media() {
		// Declara��o de vari�veis
		String nome, disciplina;
		double nota1, nota2, nota3, nota4, media;
		int idade;

		// Entrada
		nome = txtNome.getText();
		idade = Integer.parseInt(txtIdade.getText());
		disciplina = txtDisciplina.getText();
		nota1 = Double.parseDouble(txtBimestre1.getText());
		nota2 = Double.parseDouble(txtBimestre2.getText());
		nota3 = Double.parseDouble(txtBimestre3.getText());
		nota4 = Double.parseDouble(txtBimestre4.getText());

		// Processamento
		media = (nota1 + nota2 + nota3 + nota4) / 4;
		media = Math.round(media * 100.0) / 100.0;

		// Sa�da
		JOptionPane.showMessageDialog(null, nome + ",\nA sua idade � " + idade + " anos! \nA sua m�dia na disciplina "
				+ disciplina + " � " + media + "!", "M�dia", JOptionPane.DEFAULT_OPTION);
	}
}
