package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Boletim extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
					Boletim dialog = new Boletim();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Boletim() {
		setResizable(false);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Boletim.class.getResource("/img/boletim.png")));
		setTitle("Calculando a Media do Boletim");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBounds(0, 0, 434, 261);
		getContentPane().add(contentPane);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(10, 30, 46, 14);
		contentPane.add(lblNome);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 11));
		lblIdade.setBounds(10, 55, 46, 14);
		contentPane.add(lblIdade);

		JLabel lblDisciplina = new JLabel("Disciplina");
		lblDisciplina.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDisciplina.setBounds(10, 80, 70, 14);
		contentPane.add(lblDisciplina);

		JLabel lbl1bimestre = new JLabel("1º Bimestre");
		lbl1bimestre.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl1bimestre.setBounds(10, 108, 78, 14);
		contentPane.add(lbl1bimestre);

		JLabel lbl3bimestre = new JLabel("3º Bimestre");
		lbl3bimestre.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl3bimestre.setBounds(204, 108, 78, 14);
		contentPane.add(lbl3bimestre);

		JLabel lbl2bimestre = new JLabel("2º Bimestre");
		lbl2bimestre.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl2bimestre.setBounds(10, 158, 78, 14);
		contentPane.add(lbl2bimestre);

		JLabel lbl4bimestre = new JLabel("4º Bimestre");
		lbl4bimestre.setFont(new Font("Arial", Font.PLAIN, 11));
		lbl4bimestre.setBounds(204, 158, 78, 14);
		contentPane.add(lbl4bimestre);

		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(70, 27, 240, 20);
		contentPane.add(txtNome);

		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(70, 52, 86, 20);
		contentPane.add(txtIdade);

		txtDisciplina = new JTextField();
		txtDisciplina.setColumns(10);
		txtDisciplina.setBounds(70, 77, 86, 20);
		contentPane.add(txtDisciplina);

		txtBimestre3 = new JTextField();
		txtBimestre3.setColumns(10);
		txtBimestre3.setBounds(291, 105, 62, 20);
		contentPane.add(txtBimestre3);

		txtBimestre1 = new JTextField();
		txtBimestre1.setColumns(10);
		txtBimestre1.setBounds(94, 105, 62, 20);
		contentPane.add(txtBimestre1);

		txtBimestre2 = new JTextField();
		txtBimestre2.setColumns(10);
		txtBimestre2.setBounds(94, 155, 62, 20);
		contentPane.add(txtBimestre2);

		txtBimestre4 = new JTextField();
		txtBimestre4.setColumns(10);
		txtBimestre4.setBounds(291, 158, 62, 20);
		contentPane.add(txtBimestre4);

		JButton btnMedia = new JButton("");
		btnMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				media();
			}
		});
		btnMedia.setIcon(new ImageIcon(Boletim.class.getResource("/img/btnMedia.png")));
		btnMedia.setToolTipText("Calcular Media");
		btnMedia.setBounds(153, 190, 64, 64);
		contentPane.add(btnMedia);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Boletim.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(360, 190, 64, 64);
		contentPane.add(btnLimpar);

		// Uso da biblioteca Atxy2k

		RestrictedTextField validar = new RestrictedTextField(txtNome, "abcdefghijklmnopqrstuwxyz");
		validar.isOnlyText();
		validar.setAcceptSpace(true);

		RestrictedTextField validar1 = new RestrictedTextField(txtDisciplina, "abcdefghijklmnopqrstuwxyz");
		validar1.isOnlyText();
		validar1.setAcceptSpace(true);

		RestrictedTextField validar2 = new RestrictedTextField(txtIdade, "1234567890.");
		validar2.setLimit(3);

		RestrictedTextField validar3 = new RestrictedTextField(txtBimestre1, "1234567890.");
		validar3.setLimit(3);

		RestrictedTextField validar4 = new RestrictedTextField(txtBimestre2, "1234567890.");
		validar4.setLimit(3);

		RestrictedTextField validar5 = new RestrictedTextField(txtBimestre3, "1234567890.");
		validar5.setLimit(3);

		RestrictedTextField validar6 = new RestrictedTextField(txtBimestre4, "1234567890.");
		validar6.setLimit(3);

	}// Fim do Construtor

	// Metodo responsavel pelo calculo do IMC
	void media() {
		// Validacao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome");
			txtNome.requestFocus();
		} else if (txtIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Idade");
			txtIdade.requestFocus();
		} else if (txtDisciplina.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Disciplina");
			txtDisciplina.requestFocus();
		} else if (txtBimestre1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bimestre 1");
			txtBimestre1.requestFocus();
		} else if (txtBimestre2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bimestre 2");
			txtBimestre2.requestFocus();
		} else if (txtBimestre3.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bimestre 3");
			txtBimestre3.requestFocus();
		} else if (txtBimestre4.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bimestre 4");
			txtBimestre4.requestFocus();
		} else {
			// Declaração de variaveis
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

			// Saida
			if (media < 5) {
				JOptionPane.showMessageDialog(null,
						nome + ",\nA sua idade: " + idade + " anos! \nA sua media na disciplina " + disciplina + " e "
								+ media + "\n REPROVADO",
						"                          Media Do Boletim", JOptionPane.DEFAULT_OPTION);
			} else {
				JOptionPane
						.showMessageDialog(
								null, nome + ",\nA sua idade: " + idade + " anos! \nA sua media na disciplina "
										+ disciplina + " e " + media + "\n APROVADO",
								"Media", JOptionPane.INFORMATION_MESSAGE);

			}
		}
	}

	// metodo limpar
	void limpar() {
		txtNome.setText(null);
		txtIdade.setText(null);
		txtDisciplina.setText(null);
		txtBimestre1.setText(null);
		txtBimestre2.setText(null);
		txtBimestre3.setText(null);
		txtBimestre4.setText(null);
		txtNome.requestFocus();
	}

}// Fim do Codigo
