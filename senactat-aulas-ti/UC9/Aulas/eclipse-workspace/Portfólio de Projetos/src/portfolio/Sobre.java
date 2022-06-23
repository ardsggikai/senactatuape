package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

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
		setModal(true);
		setTitle("Sobre");
		setBounds(100, 100, 419, 300);
		getContentPane().setLayout(null);

		JTextPane txtpnEmDesenvolvimento = new JTextPane();
		txtpnEmDesenvolvimento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnEmDesenvolvimento.setBackground(Color.LIGHT_GRAY);
		txtpnEmDesenvolvimento.setEditable(false);
		txtpnEmDesenvolvimento.setBounds(0, 0, 403, 261);
		txtpnEmDesenvolvimento
				.setText("Prazer Meu Nome \u00E9 Allan e eu estou estudando no senac tatuape Turma TI/Senac");
		getContentPane().add(txtpnEmDesenvolvimento);

	}
}
