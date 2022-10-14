package portfolio;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private void link (String site) {
		Desktop desktop = Desktop.getDesktop();
		try {
			URI uri = new URI (site);
			desktop.browse(uri);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public Sobre() {
		getContentPane().setBackground(Color.GRAY);
		setBackground(Color.WHITE);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/icosobre.png")));
		setModal(true);
		setTitle("Sobre");
		setBounds(100, 100, 550, 380);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JTextPane txtpnEmDesenvolvimento = new JTextPane();
		txtpnEmDesenvolvimento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnEmDesenvolvimento.setBackground(Color.LIGHT_GRAY);
		txtpnEmDesenvolvimento.setEditable(false);
		txtpnEmDesenvolvimento.setBounds(10, 11, 286, 40);
		txtpnEmDesenvolvimento
				.setText("Prazer Meu Nome \u00E9 Allan e eu estou estudando no senac tatuape Turma TI/Senac");
		getContentPane().add(txtpnEmDesenvolvimento);
		
		JLabel lblGithub = new JLabel("");
		lblGithub.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGithub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				link("https://github.com/ardsggikai/senactatuape/tree/master/senactat-aulas-ti/UC9/Aulas/eclipse-workspace/Portf%C3%B3lio%20de%20Projetos/bin");
			}
		});
		lblGithub.setToolTipText("GitHub");
		lblGithub.setIcon(new ImageIcon(Sobre.class.getResource("/img/GitIco.png")));
		lblGithub.setBounds(354, 0, 100, 100);
		getContentPane().add(lblGithub);
		
		JTextPane txtpnSigaEuNo = new JTextPane();
		txtpnSigaEuNo.setBackground(Color.LIGHT_GRAY);
		txtpnSigaEuNo.setText("Clique Na Logo do Github Para Ir Pro Projeto");
		txtpnSigaEuNo.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnSigaEuNo.setBounds(296, 99, 228, 28);
		getContentPane().add(txtpnSigaEuNo);
		
		JLabel lblMit = new JLabel("");
		lblMit.setIcon(new ImageIcon(Sobre.class.getResource("/img/MIT-License-transparent.png")));
		lblMit.setBounds(274, 150, 250, 180);
		getContentPane().add(lblMit);
		
		JTextPane txtpnVersion = new JTextPane();
		txtpnVersion.setText("Version 2.5");
		txtpnVersion.setFont(new Font("Arial", Font.PLAIN, 11));
		txtpnVersion.setEditable(false);
		txtpnVersion.setBackground(Color.LIGHT_GRAY);
		txtpnVersion.setBounds(98, 302, 71, 28);
		getContentPane().add(txtpnVersion);

	}//Fim do Construtor
}//Fim do codigo
