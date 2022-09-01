package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Porcentagem extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPorcentagem1;
	private JTextField txtValor1;
	private JTextField txtResultado1;
	private JTextField txtCusto1;
	private JTextField txtSubTotal1;
	private JTextField txtLucro1;
	private JTextField txtDesconto1;
	private JTextField txtResultado2;
	private JTextField txtResultado3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Porcentagem dialog = new Porcentagem();
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
	public Porcentagem() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Porcentagem.class.getResource("/img/icoporcentagem.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		txtPorcentagem1 = new JTextField();
		txtPorcentagem1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPorcentagem1.setBounds(84, 29, 70, 20);
		getContentPane().add(txtPorcentagem1);
		txtPorcentagem1.setColumns(10);

		JLabel lblPorcentagem = new JLabel(" de");
		lblPorcentagem.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPorcentagem.setBounds(158, 32, 46, 14);
		getContentPane().add(lblPorcentagem);

		txtValor1 = new JTextField();
		txtValor1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtValor1.setBounds(213, 29, 70, 20);
		getContentPane().add(txtValor1);
		txtValor1.setColumns(10);

		JButton btnCalcular1 = new JButton("");
		btnCalcular1.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/btnCalcular.png")));
		btnCalcular1.setToolTipText("Calcular");
		btnCalcular1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular1();
			}
		});
		btnCalcular1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular1.setBounds(319, 6, 64, 64);
		getContentPane().add(btnCalcular1);

		txtResultado1 = new JTextField();
		txtResultado1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado1.setEditable(false);
		txtResultado1.setBounds(406, 29, 100, 20);
		getContentPane().add(txtResultado1);
		txtResultado1.setColumns(10);

		txtCusto1 = new JTextField();
		txtCusto1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCusto1.setColumns(10);
		txtCusto1.setBounds(84, 104, 70, 20);
		getContentPane().add(txtCusto1);

		txtSubTotal1 = new JTextField();
		txtSubTotal1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtSubTotal1.setColumns(10);
		txtSubTotal1.setBounds(84, 175, 70, 20);
		getContentPane().add(txtSubTotal1);

		txtLucro1 = new JTextField();
		txtLucro1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtLucro1.setColumns(10);
		txtLucro1.setBounds(213, 104, 70, 20);
		getContentPane().add(txtLucro1);

		txtDesconto1 = new JTextField();
		txtDesconto1.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDesconto1.setColumns(10);
		txtDesconto1.setBounds(213, 175, 70, 20);
		getContentPane().add(txtDesconto1);

		txtResultado2 = new JTextField();
		txtResultado2.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado2.setEditable(false);
		txtResultado2.setColumns(10);
		txtResultado2.setBounds(406, 104, 100, 20);
		getContentPane().add(txtResultado2);

		txtResultado3 = new JTextField();
		txtResultado3.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado3.setEditable(false);
		txtResultado3.setColumns(10);
		txtResultado3.setBounds(406, 175, 100, 20);
		getContentPane().add(txtResultado3);

		JButton btnCalcular2 = new JButton("");
		btnCalcular2.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/btnCalcular.png")));
		btnCalcular2.setToolTipText("Calcular");
		btnCalcular2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular2();
			}
		});
		btnCalcular2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular2.setBounds(319, 81, 64, 64);
		getContentPane().add(btnCalcular2);

		JButton btnCalcular3 = new JButton("");
		btnCalcular3.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/btnCalcular.png")));
		btnCalcular3.setToolTipText("Calcular");
		btnCalcular3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular3();
			}

		});
		btnCalcular3.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular3.setBounds(319, 152, 64, 64);
		getContentPane().add(btnCalcular3);

		JLabel lblRegra3 = new JLabel("Regra 3");
		lblRegra3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRegra3.setBounds(10, 11, 46, 14);
		getContentPane().add(lblRegra3);

		JLabel lblCustoXVenda = new JLabel("Custo x Venda");
		lblCustoXVenda.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCustoXVenda.setBounds(10, 91, 86, 14);
		getContentPane().add(lblCustoXVenda);

		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDesconto.setBounds(10, 165, 86, 14);
		getContentPane().add(lblDesconto);

		JLabel lblSubtotal = new JLabel("Sub-Total:");
		lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSubtotal.setBounds(10, 177, 96, 14);
		getContentPane().add(lblSubtotal);

		JLabel lblCusto = new JLabel("Custo:");
		lblCusto.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCusto.setBounds(10, 110, 96, 14);
		getContentPane().add(lblCusto);

		JLabel lblPorcentagem_1 = new JLabel("Porcentagem:");
		lblPorcentagem_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPorcentagem_1.setBounds(10, 32, 96, 14);
		getContentPane().add(lblPorcentagem_1);

		JLabel lblLucro = new JLabel("Lucro:");
		lblLucro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLucro.setBounds(158, 106, 96, 14);
		getContentPane().add(lblLucro);

		JLabel lblDesconto_1 = new JLabel("Desconto:");
		lblDesconto_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDesconto_1.setBounds(158, 177, 96, 14);
		getContentPane().add(lblDesconto_1);

		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Porcentagem.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(213, 206, 64, 64);
		getContentPane().add(btnLimpar);
		setTitle("C\u00E1lculo da Porcentagem");
		setModal(true);
		setBounds(100, 100, 540, 320);
		setLocationRelativeTo(null);

		// Uso da biblioteca Atxy2k

		RestrictedTextField validar1 = new RestrictedTextField(txtPorcentagem1, "1234567890.");
		validar1.setLimit(3);

		RestrictedTextField validar2 = new RestrictedTextField(txtValor1, "1234567890.");
		validar2.setLimit(8);

		RestrictedTextField validar3 = new RestrictedTextField(txtCusto1, "1234567890.");
		validar3.setLimit(6);

		RestrictedTextField validar4 = new RestrictedTextField(txtLucro1, "1234567890.");
		validar4.setLimit(6);

		RestrictedTextField validar5 = new RestrictedTextField(txtSubTotal1, "1234567890.");
		validar5.setLimit(5);

		RestrictedTextField validar6 = new RestrictedTextField(txtDesconto1, "1234567890.");
		validar6.setLimit(6);

	}// Fim do Construtor

	// Metodo responsavel do Calculo1

	void Calcular1() {
		// Valida��o
		if (txtPorcentagem1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Porcentagem");
			txtPorcentagem1.requestFocus();
		} else if (txtValor1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Valor");
			txtValor1.requestFocus();
		} else {

			// Declara��o das variaveis

			double porcentagem1, valor1, resultado1;

			// Entrada

			porcentagem1 = Double.parseDouble(txtPorcentagem1.getText());
			valor1 = Double.parseDouble(txtValor1.getText());

			// Processamento

			resultado1 = (porcentagem1 * valor1) / 100;
			resultado1 = Math.round(resultado1 * 100.0) / 100.0;

			// Saida

			txtResultado1.setText(String.valueOf(resultado1));
		}
	}

	// Anota��es do Calculo2
	// Metodo responsavel do Calculo2
	void Calcular2() {
		// Valida��o2
		if (txtCusto1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Custo");
			txtCusto1.requestFocus();
		} else if (txtLucro1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Lucro");
			txtLucro1.requestFocus();
		} else {

			// Declara��o das variaveis

			double custo1, lucro1, resultado2;

			// Entrada

			custo1 = Double.parseDouble(txtCusto1.getText());
			lucro1 = Double.parseDouble(txtLucro1.getText());

			// Processamento

			resultado2 = custo1 + (custo1 * lucro1) / 100;

			// Saida

			txtResultado2.setText(String.valueOf(resultado2));
		}

	}

	// Anota��es do Calculo3
	// Metodo responsavel do Calculo3
	void Calcular3() {
		// Valida��o
		if (txtSubTotal1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Sub Total");
			txtSubTotal1.requestFocus();
		} else if (txtDesconto1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Desconto");
			txtDesconto1.requestFocus();
		} else {

			// Declara��o das variaveis

			double subtotal1, desconto1, resultado3;

			// Entrada

			subtotal1 = Double.parseDouble(txtSubTotal1.getText());
			desconto1 = Double.parseDouble(txtDesconto1.getText());

			// Processamento

			resultado3 = subtotal1 - (subtotal1 * desconto1) / 100;

			// Saida

			txtResultado3.setText(String.valueOf(resultado3));

		}
	}// metodo limpar

	void limpar() {
		txtPorcentagem1.setText(null);
		txtValor1.setText(null);
		txtResultado1.setText(null);
		txtCusto1.setText(null);
		txtLucro1.setText(null);
		txtResultado2.setText(null);
		txtSubTotal1.setText(null);
		txtDesconto1.setText(null);
		txtResultado3.setText(null);
		txtPorcentagem1.requestFocus();
	}

}// Fim do Codigo
