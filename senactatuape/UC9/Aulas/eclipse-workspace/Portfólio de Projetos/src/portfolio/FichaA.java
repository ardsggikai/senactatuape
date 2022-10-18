package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class FichaA extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaA dialog = new FichaA();
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
	public FichaA() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FichaA.class.getResource("/img/icofichaaluno.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setResizable(false);
		setModal(true);
		setTitle("Ficha Aluno");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(46, 42, 46, 14);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNome.setBounds(97, 39, 176, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(FichaA.class.getResource("/img/btnSave.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnSalvar.setBounds(81, 181, 64, 64);
		getContentPane().add(btnSalvar);

		JLabel lblNewLabel2 = new JLabel("Idade:");
		lblNewLabel2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel2.setBounds(46, 80, 46, 14);
		getContentPane().add(lblNewLabel2);

		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Arial", Font.PLAIN, 11));
		txtIdade.setBounds(97, 77, 61, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPeso.setColumns(10);
		txtPeso.setBounds(97, 108, 61, 20);
		getContentPane().add(txtPeso);

		txtAltura = new JTextField();
		txtAltura.setFont(new Font("Arial", Font.PLAIN, 11));
		txtAltura.setColumns(10);
		txtAltura.setBounds(97, 139, 61, 20);
		getContentPane().add(txtAltura);

		JLabel lblNewLabel3 = new JLabel("Peso:");
		lblNewLabel3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel3.setBounds(46, 111, 46, 14);
		getContentPane().add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel("Altura:");
		lblNewLabel4.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel4.setBounds(46, 142, 46, 14);
		getContentPane().add(lblNewLabel4);

		JButton btnLimpar = new JButton("");
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(FichaA.class.getResource("/img/eraser.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(270, 181, 64, 64);
		getContentPane().add(btnLimpar);

		// Uso da biblioteca Atxy2k

		RestrictedTextField validar = new RestrictedTextField(txtNome);
		validar.setOnlyText(true);
		validar.setAcceptSpace(true);
		validar.setLimit(40);

		RestrictedTextField validar2 = new RestrictedTextField(txtIdade, "1234567890.");
		validar2.setLimit(3);

		RestrictedTextField validar3 = new RestrictedTextField(txtPeso, "1234567890.");
		validar3.setLimit(7);

		RestrictedTextField validar4 = new RestrictedTextField(txtAltura, "1234567890.");
		validar4.setLimit(4);

	}// fim do construtor

	// Metodo responsavel pela Ficha

	void calcular() {
		// Validacao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Nome");
			txtNome.requestFocus();
		} else if (txtIdade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Idade");
			txtIdade.requestFocus();
		} else if (txtPeso.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Peso");
			txtPeso.requestFocus();
		} else if (txtAltura.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Altura");
			txtAltura.requestFocus();
		} else {
			// Calculo do IMC

			String nome;
			int idade;
			double peso, altura;
			// Armazenando o conteudo da caixa de texto na variavel

			nome = txtNome.getText();

			// Integer.parseInt (converter o conteúdo da caixa de texto para número
			// inteiro)

			idade = Integer.parseInt(txtIdade.getText());

			// Double.parseDouble (converter o conteúdo da caixa de texto para números
			// inteiros e não inteiros)

			peso = Double.parseDouble(txtPeso.getText());

			altura = Double.parseDouble(txtAltura.getText());

			// A linha abaixo exibe o nome armazenado na variavel em uma caixa de mensagem.

			// Para personalizar a caixa de mensagem devemos adicionar um texto para o

			// titulo e um icone personalizado

			JOptionPane.showMessageDialog(null,
					"Nome: " + nome + "\nIdade: " + idade + "\nPeso: " + peso + "\nAltura: " + altura, "Ficha do aluno",
					JOptionPane.DEFAULT_OPTION);

		} // Fim do Metodo Responsavel pela ficha
	}// metodo limpar

	void limpar() {
		txtNome.setText(null);
		txtIdade.setText(null);
		txtPeso.setText(null);
		txtAltura.setText(null);
		txtNome.requestFocus();
	}
}// Fim do Codigo