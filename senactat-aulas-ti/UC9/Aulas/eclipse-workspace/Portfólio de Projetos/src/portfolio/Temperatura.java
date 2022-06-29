package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Temperatura extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtF;
	private JTextField txtC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Temperatura dialog = new Temperatura();
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
	public Temperatura() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Temperatura.class.getResource("/img/fahrenheit.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setModal(true);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Grau Fahrenheit:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 40, 99, 14);
		getContentPane().add(lblNewLabel);

		txtF = new JTextField();
		txtF.setFont(new Font("Arial", Font.PLAIN, 11));
		txtF.setBounds(102, 40, 80, 20);
		getContentPane().add(txtF);
		txtF.setColumns(10);

		JLabel lblGrauCelsius = new JLabel("Grau Celsius:");
		lblGrauCelsius.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGrauCelsius.setBounds(10, 89, 99, 14);
		getContentPane().add(lblGrauCelsius);

		txtC = new JTextField();
		txtC.setEditable(false);
		txtC.setFont(new Font("Arial", Font.PLAIN, 11));
		txtC.setColumns(10);
		txtC.setBounds(102, 89, 120, 20);
		getContentPane().add(txtC);

		JButton btnConverter = new JButton("Converter");
		btnConverter.setFont(new Font("Arial", Font.PLAIN, 11));
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Converter();
			}
		});
		btnConverter.setBounds(192, 40, 99, 18);
		getContentPane().add(btnConverter);
		setTitle("Convers\u00E3o de Temperatura");
		setBounds(100, 100, 330, 180);

	}
	// Fim do Construtor

	void Converter() {

		// Declara��o de vari�veis

		double c,f;

		// Entrada

		f = Double.parseDouble(txtF.getText());

		// Processamento

		c = (5 * (f - 32)) / 9;

		// Sa�da
		// a linha abaixo exibe o conte�do da vari�vel c na caixa de texto (� necess�rio
		// converter para String)
        txtC.setText(String.valueOf(c));
	}
}
