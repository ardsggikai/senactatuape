package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

import javax.swing.ImageIcon;

public class EtanolGasolina extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtEtanol;
	private JTextField txtGasolina;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EtanolGasolina dialog = new EtanolGasolina();
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
	public EtanolGasolina() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(EtanolGasolina.class.getResource("/img/icoEtanolGasolina.png")));
		setModal(true);
		setTitle("Etanol x Gasolina");
		setBounds(100, 100, 360, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblEtanol = new JLabel("Etanol:");
		lblEtanol.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEtanol.setBounds(67, 27, 46, 14);
		getContentPane().add(lblEtanol);

		txtEtanol = new JTextField();
		txtEtanol.setHorizontalAlignment(SwingConstants.CENTER);
		txtEtanol.setBounds(123, 24, 86, 20);
		getContentPane().add(txtEtanol);
		txtEtanol.setColumns(10);

		JLabel lblGasolina = new JLabel("Gasolina:");
		lblGasolina.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGasolina.setBounds(67, 65, 46, 14);
		getContentPane().add(lblGasolina);

		txtGasolina = new JTextField();
		txtGasolina.setHorizontalAlignment(SwingConstants.CENTER);
		txtGasolina.setBounds(123, 62, 86, 20);
		getContentPane().add(txtGasolina);
		txtGasolina.setColumns(10);

		JButton btnCalcular = new JButton("");
		btnCalcular.setIcon(new ImageIcon(EtanolGasolina.class.getResource("/img/btnCalcular.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calcular();
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.setBounds(67, 106, 64, 64);
		getContentPane().add(btnCalcular);

		JLabel lblR$_1 = new JLabel("R$");
		lblR$_1.setBounds(217, 65, 46, 14);
		getContentPane().add(lblR$_1);

		JLabel lblR$ = new JLabel("R$");
		lblR$.setBounds(217, 27, 46, 14);
		getContentPane().add(lblR$);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(EtanolGasolina.class.getResource("/img/neutro.png")));
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStatus.setBounds(10, 190, 320, 160);
		getContentPane().add(lblStatus);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(EtanolGasolina.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar ();
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(199, 106, 64, 64);
		getContentPane().add(btnLimpar);
		
		// Uso da biblioteca Atxy2k
		
		RestrictedTextField validar1 = new RestrictedTextField(txtEtanol, "1234567890.");
		validar1.setLimit(8);
		
		RestrictedTextField validar2 = new RestrictedTextField(txtGasolina, "1234567890.");
		validar2.setLimit(8);
		
	}// Fim do Construtor
		// Metodo responsavel pelo Etanol

	void Calcular() {
		// Valida��o
		if (txtEtanol.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Etanol");
			txtEtanol.requestFocus();
		} else if (txtGasolina.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Gasolina");
			txtGasolina.requestFocus();
		} else {

			// Declaracao de variaveis

			double etanol, gasolina;

			// Entrada

			etanol = Double.parseDouble(txtEtanol.getText());
			gasolina = Double.parseDouble(txtGasolina.getText());

			// Processamento

			// if (etanol < 0.7 * gasolina) {
			// System.out.println("Abastecer com Gasolina");
			// }else {
			// System.out.println("Abastecer com Etanol");
			// }

			// Saida (Processamento e Saida)

			if (etanol < 0.7 * gasolina) {
				lblStatus.setIcon(new ImageIcon(EtanolGasolina.class.getResource("/img/etanol.png")));
				// JOptionPane.showMessageDialog(null, "Abastecer com Etanol ", "Etanol x
				// Gasolina",
				// JOptionPane.INFORMATION_MESSAGE);
			} else {
				lblStatus.setIcon(new ImageIcon(EtanolGasolina.class.getResource("/img/gasolina.png")));
				// JOptionPane.showMessageDialog(null, "Abastecer com Gasolina ", "Etanol x
				// Gasolina",
				// JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
	
	// metodo limpar
			void limpar() {
			txtEtanol.setText(null);
			txtGasolina.setText(null);
			lblStatus.setIcon(new ImageIcon(EtanolGasolina.class.getResource("/img/neutro.png")));
			txtEtanol.requestFocus();
				
		}
	
}// Fim do Codigo
