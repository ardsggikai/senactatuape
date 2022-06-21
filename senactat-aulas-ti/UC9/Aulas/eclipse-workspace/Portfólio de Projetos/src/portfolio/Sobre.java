package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;

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
		setTitle("Sobre");
		setModal(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(null);

		JTextPane txtpnEmDesenvolvimento = new JTextPane();
		txtpnEmDesenvolvimento.setText("EM DESENVOLVIMENTO");
		txtpnEmDesenvolvimento.setBounds(20, 11, 418, 225);
		getContentPane().add(txtpnEmDesenvolvimento);

	}
}
