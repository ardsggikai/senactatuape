package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IMC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPeso;
	private JTextField txtAltura;
	private JTextField txtResultado;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC dialog = new IMC();
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
	public IMC() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IMC.class.getResource("/img/imcfavicon.png")));
		setTitle("Calculo do IMC");
		setResizable(false);
		setBounds(100, 100, 499, 485);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.BOLD, 11));
		lblPeso.setBounds(278, 11, 46, 14);
		getContentPane().add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeso.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPeso.setColumns(10);
		txtPeso.setBounds(258, 30, 86, 20);
		getContentPane().add(txtPeso);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Arial", Font.BOLD, 11));
		lblAltura.setBounds(278, 79, 46, 14);
		getContentPane().add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setHorizontalAlignment(SwingConstants.CENTER);
		txtAltura.setFont(new Font("Arial", Font.PLAIN, 11));
		txtAltura.setColumns(10);
		txtAltura.setBounds(258, 104, 86, 20);
		getContentPane().add(txtAltura);

		JLabel lblResultado = new JLabel("Seu IMC É:");
		lblResultado.setFont(new Font("Arial", Font.BOLD, 18));
		lblResultado.setBounds(244, 179, 115, 34);
		getContentPane().add(lblResultado);

		txtResultado = new JTextField();
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado.setEditable(false);
		txtResultado.setColumns(10);
		txtResultado.setBounds(258, 223, 86, 20);
		getContentPane().add(txtResultado);

		JButton btnCalcular = new JButton("");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular ();
			}
		});
		btnCalcular.setIcon(new ImageIcon(IMC.class.getResource("/img/balance.png")));
		btnCalcular.setToolTipText("Calcular IMC");
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setBorderPainted(false);
		btnCalcular.setBounds(222, 300, 64, 64);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar ();
			}
		});
		btnLimpar.setIcon(new ImageIcon(IMC.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar ");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setBounds(329, 300, 64, 64);
		getContentPane().add(btnLimpar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc0.png")));
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStatus.setBounds(0, 0, 223, 425);
		getContentPane().add(lblStatus);

		// Uso da biblioteca Atxy2k
		RestrictedTextField validar = new RestrictedTextField(txtPeso, "0123456789.");
		validar.setLimit(7);

		RestrictedTextField validar2 = new RestrictedTextField(txtAltura, "0123456789.");
		validar2.setLimit(4);

	}// Fim do Construtor

	// Método responsável pelo cálculo do IMC
	void Calcular() {
		// Validacao
		if (txtPeso.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Peso");
			txtPeso.requestFocus();
		} else if (txtAltura.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Altura");
			txtAltura.requestFocus();

		} else {
			// Logica Principal

			// variaveis
			double peso, altura, imc;

			// Formatador de casas decimais
			DecimalFormat formatador = new DecimalFormat("#0.00");

			// Entrada

			peso = Double.parseDouble(txtPeso.getText());
			altura = Double.parseDouble(txtAltura.getText());

			// Processamento

			imc = peso / (altura * altura);

			// Resultado

			txtResultado.setText(String.valueOf(formatador.format(imc)));

			// Status

			if (imc < 17) {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc1.png")));
			} else if (imc >= 17.0 && imc < 18.5) {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc2.png")));
			} else if (imc >= 18.5 && imc < 25.0) {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc3.png")));
			} else if (imc >= 25 && imc < 30.0) {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc4.png")));
			} else if (imc >= 30 && imc < 35.0) {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc5.png")));
			} else if (imc >= 35 && imc < 40.0) {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc6.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc7.png")));
			}
		}
	}

	// Metodo Limpar

	void Limpar() {

		txtAltura.setText(null);
		txtPeso.setText(null);
		txtResultado.setText(null);
		txtPeso.requestFocus();
		lblStatus.setIcon(new ImageIcon(IMC.class.getResource("/img/imc0.png")));

	}

}// Fim do Codigo
