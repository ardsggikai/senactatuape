package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Tabuada extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTabuada;
	private JTextArea txtArea;
	private JButton btnCalcular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuada dialog = new Tabuada();
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
	public Tabuada() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Tabuada.class.getResource("/img/IcoTabuada.png")));
		setTitle("Calculando a Tabuada");
		setBounds(100, 100, 310, 340);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		txtArea = new JTextArea();
		txtArea.setEditable(false);
		txtArea.setBounds(50, 120, 185, 170);
		getContentPane().add(txtArea);

		JLabel lblTabuada = new JLabel("Tabuada:");
		lblTabuada.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTabuada.setBounds(68, 15, 46, 14);
		getContentPane().add(lblTabuada);

		txtTabuada = new JTextField();
		txtTabuada.setHorizontalAlignment(SwingConstants.CENTER);
		txtTabuada.setBounds(171, 12, 64, 20);
		getContentPane().add(txtTabuada);
		txtTabuada.setColumns(10);

		btnCalcular = new JButton("");
		btnCalcular.setIcon(new ImageIcon(Tabuada.class.getResource("/img/btnCalcular.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.setBounds(50, 45, 64, 64);
		getContentPane().add(btnCalcular);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(Tabuada.class.getResource("/img/eraser.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(171, 43, 64, 64);
		getContentPane().add(btnLimpar);

		// Uso da biblioteca Atxy2k
		RestrictedTextField validar = new RestrictedTextField(txtTabuada, "0123456789.");
		validar.setLimit(7);

	}// Fim do Construtor

	void calcular() {

		// Validacao
		if (txtTabuada.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a tabuada");
			txtTabuada.requestFocus();
		} else {

		}

		// Variaveis + Entrada
		int valor = Integer.parseInt(txtTabuada.getText());
		// Processamento + saida
		for (int i = 1; i < 11; i++) {
			txtArea.append(" " + String.valueOf(valor) + " x " + String.valueOf(i) + " = " + (valor * i) + "\n");
		}
		// desabilitar o botao
		btnCalcular.setEnabled(false);
	}

	void limpar() {
		txtTabuada.setText(null);
		txtArea.setText(null);
		// habilitar o botao
		btnCalcular.setEnabled(true);
	}
}// Fim do Codigo
