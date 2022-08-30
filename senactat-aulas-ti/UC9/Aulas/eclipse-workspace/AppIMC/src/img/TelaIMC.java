package img;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

public class TelaIMC extends JFrame {

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
					TelaIMC frame = new TelaIMC();
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
	public TelaIMC() {
		setMaximumSize(new Dimension(1920, 1080));
		setResizable(false);
		setTitle("Calculo do IMC");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaIMC.class.getResource("/img/imcfavicon.png")));
		setBounds(100, 100, 500, 510);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc.png")));
		lblStatus.setBounds(0, 0, 213, 425);
		getContentPane().add(lblStatus);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Arial", Font.BOLD, 11));
		lblPeso.setBounds(289, 11, 46, 14);
		getContentPane().add(lblPeso);

		txtPeso = new JTextField();
		txtPeso.setHorizontalAlignment(SwingConstants.CENTER);
		txtPeso.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPeso.setBounds(269, 30, 86, 20);
		getContentPane().add(txtPeso);
		txtPeso.setColumns(10);

		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Arial", Font.BOLD, 11));
		lblAltura.setBounds(289, 79, 46, 14);
		getContentPane().add(lblAltura);

		txtAltura = new JTextField();
		txtAltura.setHorizontalAlignment(SwingConstants.CENTER);
		txtAltura.setFont(new Font("Arial", Font.PLAIN, 11));
		txtAltura.setBounds(269, 104, 86, 20);
		getContentPane().add(txtAltura);
		txtAltura.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.setToolTipText("Calcular IMC");
		btnCalcular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalcular.setContentAreaFilled(false);
		btnCalcular.setBorderPainted(false);
		btnCalcular.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/balance.png")));
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular();
			}
		});
		btnCalcular.setBounds(233, 300, 64, 64);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar();
			}
		});
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.setToolTipText("Limpar ");
		btnLimpar.setBorderPainted(false);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/eraser.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(340, 300, 64, 64);
		getContentPane().add(btnLimpar);

		JLabel lblResultado = new JLabel("Seu IMC \u00C9:");
		lblResultado.setFont(new Font("Arial", Font.BOLD, 18));
		lblResultado.setBounds(255, 179, 115, 34);
		getContentPane().add(lblResultado);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(269, 223, 86, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

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
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc1.png")));
			} else if (imc >= 17.0 && imc < 18.5) {
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc2.png")));
			} else if (imc >= 18.5 && imc < 25.0) {
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc3.png")));
			} else if (imc >= 25 && imc < 30.0) {
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc4.png")));
			} else if (imc >= 30 && imc < 35.0) {
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc5.png")));
			} else if (imc >= 35 && imc < 40.0) {
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc6.png")));
			} else {
				lblStatus.setIcon(new ImageIcon(TelaIMC.class.getResource("/img/imc7.png")));
			}
		}
	}

	// Metodo Limpar

	void Limpar() {

		txtAltura.setText(null);
		txtPeso.setText(null);
		txtResultado.setText(null);
		txtPeso.requestFocus();
	}

}// Fim do Codigo
