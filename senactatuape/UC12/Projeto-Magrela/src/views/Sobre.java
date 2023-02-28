package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtVersion;

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
		getContentPane().setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/iconinfo.png")));
		setTitle("VIA Motors - Sobre Nos");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 358, 246);
		getContentPane().setLayout(null);

		JLabel lblLicencaMit = new JLabel("");
		lblLicencaMit.setBackground(SystemColor.window);
		lblLicencaMit.setIcon(new ImageIcon(Sobre.class.getResource("/img/MIT-License-transparent.png")));
		lblLicencaMit.setHorizontalAlignment(SwingConstants.CENTER);
		lblLicencaMit.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLicencaMit.setBounds(105, 91, 128, 92);
		getContentPane().add(lblLicencaMit);

		JTextPane txtpnDesenvolvidoPor = new JTextPane();
		txtpnDesenvolvidoPor.setText("\r\nDesenvolvido por\r\n   Allan Gomes\r\n    Igor Oliveira");
		txtpnDesenvolvidoPor.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnDesenvolvidoPor.setEditable(false);
		txtpnDesenvolvidoPor.setBackground(SystemColor.window);
		txtpnDesenvolvidoPor.setBounds(126, 11, 91, 69);
		getContentPane().add(txtpnDesenvolvidoPor);

		txtVersion = new JTextField();
		txtVersion.setBackground(SystemColor.window);
		txtVersion.setText("Version 1.0");
		txtVersion.setHorizontalAlignment(SwingConstants.CENTER);
		txtVersion.setFont(new Font("Arial", Font.PLAIN, 11));
		txtVersion.setEditable(false);
		txtVersion.setColumns(10);
		txtVersion.setBounds(246, 176, 86, 20);
		getContentPane().add(txtVersion);

	}
}
