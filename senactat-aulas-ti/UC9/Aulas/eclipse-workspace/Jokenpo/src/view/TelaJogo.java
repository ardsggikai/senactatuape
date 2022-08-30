package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TelaJogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPedra;
	private JRadioButton rdbtnPapel;
	private JRadioButton rdbtnTesoura;
	private JLabel lblPC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaJogo frame = new TelaJogo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaJogo() {
		setResizable(false);
		setTitle("Jogando o Jogo JoKenPo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 475);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPedra = new JLabel("");
		lblPedra.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pedra.png")));
		lblPedra.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPedra.setHorizontalAlignment(SwingConstants.CENTER);
		lblPedra.setBounds(34, 55, 64, 64);
		contentPane.add(lblPedra);

		JLabel lblTesoura = new JLabel("");
		lblTesoura.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/tesoura.png")));
		lblTesoura.setHorizontalAlignment(SwingConstants.CENTER);
		lblTesoura.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTesoura.setBounds(400, 55, 64, 64);
		contentPane.add(lblTesoura);

		JLabel lblPapel = new JLabel("");
		lblPapel.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/papel.png")));
		lblPapel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPapel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPapel.setBounds(204, 55, 64, 64);
		contentPane.add(lblPapel);

		lblPC = new JLabel("");
		lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pc.png")));
		lblPC.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPC.setBounds(152, 252, 171, 139);
		contentPane.add(lblPC);

		rdbtnPedra = new JRadioButton("");
		buttonGroup.add(rdbtnPedra);
		rdbtnPedra.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnPedra.setBackground(Color.WHITE);
		rdbtnPedra.setBounds(55, 126, 23, 23);
		contentPane.add(rdbtnPedra);

		rdbtnPapel = new JRadioButton("");
		buttonGroup.add(rdbtnPapel);
		rdbtnPapel.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnPapel.setBackground(Color.WHITE);
		rdbtnPapel.setBounds(224, 126, 23, 23);
		contentPane.add(rdbtnPapel);

		rdbtnTesoura = new JRadioButton("");
		buttonGroup.add(rdbtnTesoura);
		rdbtnTesoura.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnTesoura.setBackground(Color.WHITE);
		rdbtnTesoura.setBounds(420, 126, 23, 23);
		contentPane.add(rdbtnTesoura);

		JButton btnPow = new JButton("POW");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pow();
			}
		});
		btnPow.setFont(new Font("Arial", Font.PLAIN, 11));
		btnPow.setBounds(193, 182, 89, 23);
		contentPane.add(btnPow);
	}// Fim do Construtor

	// Metodo responsavel pelo pow
	void pow() {

		// Validacao (atencao ao uso do NOT)
		if (!rdbtnPedra.isSelected() && !rdbtnPapel.isSelected() && !rdbtnTesoura.isSelected()) {
			JOptionPane.showMessageDialog(null, "Escolha Uma Op��o");
		} else {
			// Logica Principal
			Random random = new Random();
			int pc = random.nextInt(3);
			// Dica Para verificar o numero sorteado
			// System.out.println(pc);
			// Associar o numero a imagem
			switch (pc) {
			case 0:
				lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcpedra.png")));
				break;
			case 1:
				lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pcpapel.png")));
				break;
			case 2:
				lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pctesoura.png")));
				break;
			}
			// Compacoes para determinar o vencedor ou empate

			if (rdbtnPedra.isSelected() && (pc == 0) || rdbtnPapel.isSelected() && (pc == 1)
					|| rdbtnTesoura.isSelected() && (pc == 2)) {
				JOptionPane.showMessageDialog(null, "Empate");
			} else if (rdbtnPedra.isSelected() && (pc == 2) || rdbtnPapel.isSelected() && (pc == 0)
					|| rdbtnTesoura.isSelected() && (pc == 1)) {
				JOptionPane.showMessageDialog(null, "Jogador Venceu");
			} else

			{
				JOptionPane.showMessageDialog(null, "PC VENCEU");
			}
			// Limpar os Campos
			lblPC.setIcon(new ImageIcon(TelaJogo.class.getResource("/img/pc.png")));
			buttonGroup.clearSelection();
		}

	}

}
// Fim do Codigo
