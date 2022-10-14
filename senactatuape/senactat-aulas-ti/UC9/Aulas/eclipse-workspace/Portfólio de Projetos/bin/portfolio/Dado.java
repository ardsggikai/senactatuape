package portfolio;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Random;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Dado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblDado1;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dado.class.getResource("/img/icoDado.png")));
		setTitle("Lançar o dado");
		setModal(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);

		lblDado1 = new JLabel("");
		lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face.png")));
		lblDado1.setBackground(Color.WHITE);
		lblDado1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDado1.setBounds(157, 31, 115, 119);
		setLocationRelativeTo(null);
		getContentPane().add(lblDado1);

		JButton btnlancar = new JButton("");
		btnlancar.setIcon(new ImageIcon(Dado.class.getResource("/img/btnLançar.png")));
		btnlancar.setToolTipText("Lançar Dados");
		btnlancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lancar();
			}
		});
		btnlancar.setBounds(177, 176, 64, 64);
		getContentPane().add(btnlancar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setIcon(new ImageIcon(Dado.class.getResource("/img/eraser.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar ();
			}
		});
		btnLimpar.setBounds(177, 265, 64, 64);
		getContentPane().add(btnLimpar);
		setBounds(100, 100, 450, 400);
		setLocationRelativeTo(null);

	}// Fim do Construtor

	void lancar() {
		Random random = new Random();
		int face = random.nextInt(6) + 1;
		switch (face) {
		case 1:
			lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face1.png")));
			break;
		case 2:
			lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face2.png")));
			break;
		case 3:
			lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face3.png")));
			break;
		case 4:
			lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face4.png")));
			break;
		case 5:
			lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face5.png")));
			break;
		case 6:
			lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face6.png")));
			break;
		}
		lblDado1.setText(String.valueOf(face));

	} // Fim do método lancar

// metodo limpar

	void limpar() {
		lblDado1.setIcon(new ImageIcon(Dado.class.getResource("/img/face.png")));
		lblDado1.requestFocus();
	}

}// Fim do Codigo
