package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Moeda extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDolar;
	private JTextField txtCotacao;
	private JTextField txtReal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Moeda dialog = new Moeda();
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
	public Moeda() {
		setTitle("Converte D\u00F3lar para Real");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 262, 244);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblDolar = new JLabel("D\u00F3lar");
		lblDolar.setBounds(10, 17, 86, 14);
		getContentPane().add(lblDolar);

		txtDolar = new JTextField();
		txtDolar.setHorizontalAlignment(SwingConstants.CENTER);
		txtDolar.setBounds(125, 11, 86, 20);
		getContentPane().add(txtDolar);
		txtDolar.setColumns(10);

		JLabel lblCotacao = new JLabel("Cota\u00E7\u00E3o");
		lblCotacao.setBounds(10, 48, 86, 14);
		getContentPane().add(lblCotacao);

		txtCotacao = new JTextField();
		txtCotacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtCotacao.setBounds(125, 42, 86, 20);
		getContentPane().add(txtCotacao);
		txtCotacao.setColumns(10);

		JLabel lblReal = new JLabel("Real");
		lblReal.setBounds(10, 79, 86, 14);
		getContentPane().add(lblReal);

		txtReal = new JTextField();
		txtReal.setHorizontalAlignment(SwingConstants.CENTER);
		txtReal.setEditable(false);
		txtReal.setBounds(125, 73, 86, 20);
		getContentPane().add(txtReal);
		txtReal.setColumns(10);

		JButton btnCalcular = new JButton("CALC");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setBounds(15, 115, 100, 64);
		getContentPane().add(btnCalcular);

		// Uso da Biblioteca Atxy2k
		RestrictedTextField dolar = new RestrictedTextField(txtDolar, "0123456789.");
		dolar.setLimit(6);

		RestrictedTextField cotacao = new RestrictedTextField(txtCotacao, "0123456789.");
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(130, 115, 100, 64);
		getContentPane().add(btnLimpar);
		cotacao.setLimit(6);

	}// Fim do Construtor

	// formatador de casas decimais
	DecimalFormat formatador = new DecimalFormat("R$ 0.00");

	void calcular() {
		// Validação
		if (txtDolar.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor em D�lar");
			txtDolar.requestFocus();
		} else if (txtCotacao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o valor da cota��o");
			txtCotacao.requestFocus();
		} else {

			// Declaração de variaveis
			double dolar, real, cotacao;

			// Entrada
			dolar = Double.parseDouble(txtDolar.getText());
			cotacao = Double.parseDouble(txtCotacao.getText());

			// Processamento
			real = dolar * cotacao;

			// Sa�da
			txtReal.setText(String.valueOf(formatador.format(real)));

		}

	}// fim do metodo calcular

	/** metodo para Limpar **/
	void limpar() {
		txtDolar.setText(null);
		txtCotacao.setText(null);
		txtReal.setText(null);
		txtDolar.requestFocus();
	} // Fim do metodo limpar

} // Fim do Codigo
