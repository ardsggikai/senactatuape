package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
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
	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/icosobre.png")));
		setModal(true);
		setTitle("Sobre");
		setBounds(100, 100, 550, 380);
		getContentPane().setLayout(null);

		JTextPane txtpnEmDesenvolvimento = new JTextPane();
		txtpnEmDesenvolvimento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnEmDesenvolvimento.setBackground(Color.LIGHT_GRAY);
		txtpnEmDesenvolvimento.setEditable(false);
		txtpnEmDesenvolvimento.setBounds(0, 0, 286, 342);
		txtpnEmDesenvolvimento
				.setText("Prazer Meu Nome \u00E9 Allan e eu estou estudando no senac tatuape Turma TI/Senac");
		getContentPane().add(txtpnEmDesenvolvimento);
		
		JLabel lblGithub = new JLabel("");
		lblGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/GitIco.png")));
		lblGithub.setBounds(363, 0, 100, 100);
		getContentPane().add(lblGithub);
		
		JTextPane txtpnSigaEuNo = new JTextPane();
		txtpnSigaEuNo.setText("Siga Eu No Github  https://github.com/ardsggikai");
		txtpnSigaEuNo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnSigaEuNo.setBounds(296, 111, 228, 40);
		getContentPane().add(txtpnSigaEuNo);
		
		JLabel lblMit = new JLabel("");
		lblMit.setIcon(new ImageIcon(Sobre.class.getResource("/img/MIT-License-transparent.png")));
		lblMit.setBounds(284, 162, 250, 180);
		getContentPane().add(lblMit);

	}
}
