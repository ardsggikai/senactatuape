package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
		txtPorcentagem1.setBounds(84, 29, 70, 20);
		getContentPane().add(txtPorcentagem1);
		txtPorcentagem1.setColumns(10);

		JLabel lblPorcentagem = new JLabel(" de");
		lblPorcentagem.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPorcentagem.setBounds(158, 32, 46, 14);
		getContentPane().add(lblPorcentagem);

		txtValor1 = new JTextField();
		txtValor1.setBounds(213, 29, 70, 20);
		getContentPane().add(txtValor1);
		txtValor1.setColumns(10);

		JButton btnCalcular1 = new JButton("=");
		btnCalcular1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular1();
			}
		});
		btnCalcular1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular1.setBounds(309, 28, 89, 23);
		getContentPane().add(btnCalcular1);

		txtResultado1 = new JTextField();
		txtResultado1.setEditable(false);
		txtResultado1.setBounds(408, 29, 70, 20);
		getContentPane().add(txtResultado1);
		txtResultado1.setColumns(10);

		txtCusto1 = new JTextField();
		txtCusto1.setColumns(10);
		txtCusto1.setBounds(84, 87, 70, 20);
		getContentPane().add(txtCusto1);

		txtSubTotal1 = new JTextField();
		txtSubTotal1.setColumns(10);
		txtSubTotal1.setBounds(84, 145, 70, 20);
		getContentPane().add(txtSubTotal1);

		txtLucro1 = new JTextField();
		txtLucro1.setColumns(10);
		txtLucro1.setBounds(213, 87, 70, 20);
		getContentPane().add(txtLucro1);

		txtDesconto1 = new JTextField();
		txtDesconto1.setColumns(10);
		txtDesconto1.setBounds(213, 145, 70, 20);
		getContentPane().add(txtDesconto1);

		txtResultado2 = new JTextField();
		txtResultado2.setEditable(false);
		txtResultado2.setColumns(10);
		txtResultado2.setBounds(408, 87, 70, 20);
		getContentPane().add(txtResultado2);

		txtResultado3 = new JTextField();
		txtResultado3.setEditable(false);
		txtResultado3.setColumns(10);
		txtResultado3.setBounds(408, 145, 70, 20);
		getContentPane().add(txtResultado3);

		JButton btnCalcular2 = new JButton("Calcular");
		btnCalcular2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular2();
			}
		});
		btnCalcular2.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular2.setBounds(309, 86, 89, 23);
		getContentPane().add(btnCalcular2);

		JButton btnCalcular3 = new JButton("Calcular");
		btnCalcular3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular3();
			}

		});
		btnCalcular3.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular3.setBounds(309, 144, 89, 23);
		getContentPane().add(btnCalcular3);

		JLabel lblRegra3 = new JLabel("Regra 3");
		lblRegra3.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRegra3.setBounds(10, 11, 46, 14);
		getContentPane().add(lblRegra3);

		JLabel lblCustoXVenda = new JLabel("Custo x Venda");
		lblCustoXVenda.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCustoXVenda.setBounds(10, 71, 86, 14);
		getContentPane().add(lblCustoXVenda);

		JLabel lblDesconto = new JLabel("Desconto");
		lblDesconto.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDesconto.setBounds(10, 131, 86, 14);
		getContentPane().add(lblDesconto);

		JLabel lblSubtotal = new JLabel("Sub-Total:");
		lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSubtotal.setBounds(10, 148, 96, 14);
		getContentPane().add(lblSubtotal);

		JLabel lblCusto = new JLabel("Custo:");
		lblCusto.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCusto.setBounds(10, 90, 96, 14);
		getContentPane().add(lblCusto);

		JLabel lblPorcentagem_1 = new JLabel("Porcentagem:");
		lblPorcentagem_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPorcentagem_1.setBounds(10, 32, 96, 14);
		getContentPane().add(lblPorcentagem_1);

		JLabel lblLucro = new JLabel("Lucro:");
		lblLucro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLucro.setBounds(158, 90, 96, 14);
		getContentPane().add(lblLucro);

		JLabel lblDesconto_1 = new JLabel("Desconto:");
		lblDesconto_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDesconto_1.setBounds(158, 148, 96, 14);
		getContentPane().add(lblDesconto_1);
		setTitle("C\u00E1lculo da Porcentagem");
		setModal(true);
		setBounds(100, 100, 510, 230);

	}// Fim do Construtor

	
	// Anota��es do Calculo1
	void Calcular1() {
		// Declara��o das vari�veis

		double porcentagem1, valor1, resultado1;

		// Entrada

		porcentagem1 = Double.parseDouble(txtPorcentagem1.getText());
		valor1 = Double.parseDouble(txtValor1.getText());

		// Processamento

		resultado1 = (porcentagem1 * valor1) / 100;
		resultado1 = Math.round(resultado1 * 100.0) / 100.0;

		// Sa�da

		txtResultado1.setText(String.valueOf(resultado1));

	}
	// a linha abaixo exibe o conte�do da vari�vel c na caixa de texto (� necess�rio
	// converter para String)

	// Anota��es do Calculo2
	void Calcular2() {
		// Declara��o das vari�veis

		double custo1, lucro1, resultado2;

		// Entrada

		custo1 = Double.parseDouble(txtCusto1.getText());
		lucro1 = Double.parseDouble(txtLucro1.getText());

		// Processamento

		resultado2 = custo1 + (custo1 * lucro1) / 100;

		// Sa�da

		txtResultado2.setText(String.valueOf(resultado2));

	}

	// Anota��es do Calculo3
	void Calcular3() {
		// Declara��o das vari�veis

		double subtotal1, desconto1, resultado3;

		// Entrada

		subtotal1 = Double.parseDouble(txtSubTotal1.getText());
		desconto1 = Double.parseDouble(txtDesconto1.getText());

		// Processamento

		resultado3 = subtotal1 - (subtotal1 * desconto1) / 100;

		// Sa�da

		txtResultado3.setText(String.valueOf(resultado3));

	}
}// Fim do Codigo
