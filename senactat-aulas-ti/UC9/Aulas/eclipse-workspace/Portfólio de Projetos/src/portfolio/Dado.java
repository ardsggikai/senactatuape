package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;

public class Dado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLan�ar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dado dialog = new Dado();
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
	public Dado() {
		setTitle("Lan\u00E7ar o dado");
		setModal(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		txtLan�ar = new JTextField();
		txtLan�ar.setText("Lan\u00E7ar");
		txtLan�ar.setFont(new Font("Arial", Font.PLAIN, 11));
		txtLan�ar.setHorizontalAlignment(SwingConstants.CENTER);
		txtLan�ar.setBounds(176, 230, 86, 20);
		getContentPane().add(txtLan�ar);
		txtLan�ar.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(162, 53, 115, 119);
		getContentPane().add(panel);
		setBounds(100, 100, 450, 300);

	}
}
