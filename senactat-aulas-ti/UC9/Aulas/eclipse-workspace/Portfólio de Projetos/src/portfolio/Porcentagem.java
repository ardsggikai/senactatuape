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

public class Porcentagem extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPorcentagem;
	private JTextField txtValor;
	private JTextField txtResultado;

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
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		txtPorcentagem = new JTextField();
		txtPorcentagem.setBounds(21, 33, 86, 20);
		getContentPane().add(txtPorcentagem);
		txtPorcentagem.setColumns(10);

		JLabel lblNewLabel = new JLabel("% de");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(117, 36, 46, 14);
		getContentPane().add(lblNewLabel);

		txtValor = new JTextField();
		txtValor.setBounds(150, 33, 86, 20);
		getContentPane().add(txtValor);
		txtValor.setColumns(10);

		JButton btnCalcular = new JButton("=");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.setBounds(246, 32, 89, 23);
		getContentPane().add(btnCalcular);

		txtResultado = new JTextField();
		txtResultado.setBounds(345, 33, 86, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		setTitle("C\u00E1lculo da Porcentagem");
		setModal(true);
		setBounds(100, 100, 470, 160);

	}

	// Fim do Construtor
	void calcular() {
		// Declaração das variáveis
		double porcentagem, valor, resultado;

		// Entrada

		porcentagem = Double.parseDouble(txtPorcentagem.getText());
		valor = Double.parseDouble(txtValor.getText());

		// Processamento

		resultado = (porcentagem * valor) / 100;
		resultado = Math.round(resultado * 100.0) / 100.0;

		// Saída

		txtResultado.setText(String.valueOf(resultado));

		// a linha abaixo exibe o conteúdo da variável c na caixa de texto (é necessário
		// converter para String)

	}

}
