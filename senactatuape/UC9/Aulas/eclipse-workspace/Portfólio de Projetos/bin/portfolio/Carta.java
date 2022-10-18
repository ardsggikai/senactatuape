package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Carta extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblFace;
	private JLabel lblNipe;
	private JLabel lblNipeCentro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carta dialog = new Carta();
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
	public Carta() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		setTitle("Jogo de Cartas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Carta.class.getResource("/img/icoCartas.png")));
		setBounds(100, 100, 370, 480);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.text);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(91, 32, 220, 323);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblFace = new JLabel("");
		lblFace.setHorizontalAlignment(SwingConstants.LEFT);
		lblFace.setFont(new Font("Arial", Font.BOLD, 22));
		lblFace.setBounds(10, 11, 59, 25);
		panel.add(lblFace);

		lblNipe = new JLabel("");
		lblNipe.setHorizontalAlignment(SwingConstants.LEFT);
		lblNipe.setFont(new Font("Arial", Font.BOLD, 32));
		lblNipe.setBounds(10, 36, 45, 37);
		panel.add(lblNipe);

		lblNipeCentro = new JLabel("");
		lblNipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/CartaT.png")));
		lblNipeCentro.setFont(new Font("Arial", Font.BOLD, 90));
		lblNipeCentro.setBounds(31, 36, 160, 250);
		panel.add(lblNipeCentro);

		JButton btnEmbaralhar = new JButton("");
		btnEmbaralhar.setIcon(new ImageIcon(Carta.class.getResource("/img/btnEmbaralhar.png")));
		btnEmbaralhar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEmbaralhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sortearCarta();
			}
		});
		btnEmbaralhar.setBounds(101, 366, 64, 64);
		getContentPane().add(btnEmbaralhar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Carta.class.getResource("/img/eraser.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setBounds(237, 366, 64, 64);
		getContentPane().add(btnLimpar);

	}// fim do construtor

	void sortearCarta() {
		String[] nipes = { "♥", "♦", "♣", "♠" };
		String[] faces = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Joker" };
		Random carta = new Random();
		int indiceFace = carta.nextInt(faces.length);
		int indiceNipe = carta.nextInt(nipes.length);
		// exibir carta
		lblFace.setText(faces[indiceFace]);
		lblNipe.setText(nipes[indiceNipe]);

		// trocar a cor
		if (indiceNipe == 0 || indiceNipe == 1) {
			lblFace.setForeground(Color.RED);
			lblNipe.setForeground(Color.RED);
			lblNipeCentro.setForeground(Color.RED);
		} else {
			lblFace.setForeground(Color.BLACK);
			lblNipe.setForeground(Color.BLACK);
			lblNipeCentro.setForeground(Color.BLACK);
		}

		// Exibir imagens Valete, Dama e Rei
		if (indiceFace == 10) {
			lblNipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/valete.png")));
		} else if (indiceFace == 11) {
			lblNipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/dama.png")));
		} else if (indiceFace == 12) {
			lblNipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/rei.png")));
		} else if (indiceFace == 13) {
			lblNipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/coringa.png")));
			lblNipe.setText(null);
		} else {
			lblNipeCentro.setIcon(null);
			lblNipeCentro.setText("  " + nipes[indiceNipe]);
		}
	}

// metodo limpar

	void limpar() {
		lblFace.setText(null);
		lblNipe.setText(null);
		lblNipeCentro.setText(null);
		lblNipeCentro.setIcon(new ImageIcon(Carta.class.getResource("/img/CartaT.png")));
	}

}// fim do codigo
