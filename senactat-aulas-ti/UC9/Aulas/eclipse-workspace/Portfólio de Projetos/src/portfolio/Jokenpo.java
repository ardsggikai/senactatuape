package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Jokenpo extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblPedra;
	private JRadioButton rdbtnPedra;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnPapel;
	private JRadioButton rdbtnTesoura;
	private JLabel lblPapel;
	private JLabel lblTesoura;
	private JLabel lblPC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jokenpo dialog = new Jokenpo();
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
	public Jokenpo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Jokenpo.class.getResource("/img/IcoJokenpo.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setTitle("Jogando JoKenPo");
		setBounds(100, 100, 450, 450);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblPedra = new JLabel("");
		lblPedra.setBackground(Color.WHITE);
		lblPedra.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pedra.png")));
		lblPedra.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPedra.setBounds(60, 22, 64, 64);
		getContentPane().add(lblPedra);

		lblPapel = new JLabel("");
		lblPapel.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/papel.png")));
		lblPapel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPapel.setBounds(184, 22, 64, 64);
		getContentPane().add(lblPapel);

		lblTesoura = new JLabel("");
		lblTesoura.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/tesoura.png")));
		lblTesoura.setFont(new Font("Arial", Font.PLAIN, 11));
		lblTesoura.setBounds(308, 22, 64, 64);
		getContentPane().add(lblTesoura);

		rdbtnPedra = new JRadioButton("");
		rdbtnPedra.setBackground(Color.LIGHT_GRAY);
		rdbtnPedra.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnPedra);
		rdbtnPedra.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnPedra.setBounds(83, 93, 22, 23);
		getContentPane().add(rdbtnPedra);

		rdbtnPapel = new JRadioButton("");
		rdbtnPapel.setBackground(Color.LIGHT_GRAY);
		rdbtnPapel.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnPapel);
		rdbtnPapel.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnPapel.setBounds(204, 93, 22, 23);
		getContentPane().add(rdbtnPapel);

		rdbtnTesoura = new JRadioButton("");
		rdbtnTesoura.setBackground(Color.LIGHT_GRAY);
		rdbtnTesoura.setForeground(Color.WHITE);
		buttonGroup.add(rdbtnTesoura);
		rdbtnTesoura.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnTesoura.setBounds(329, 93, 22, 23);
		getContentPane().add(rdbtnTesoura);

		JButton btnPow = new JButton("");
		btnPow.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/btnLançar.png")));
		btnPow.setToolTipText("JoKenPo");
		btnPow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pow();
			}
		});
		btnPow.setBounds(184, 142, 64, 64);
		getContentPane().add(btnPow);

		lblPC = new JLabel("");
		lblPC.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPC.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pc.png")));
		lblPC.setBounds(133, 241, 171, 139);
		getContentPane().add(lblPC);

	}// Fim do Construtor

	// Metodo responsavel pelo pow
	void pow() {

		// Validacao (atencao ao uso do NOT)
		if (!rdbtnPedra.isSelected() && !rdbtnPapel.isSelected() && !rdbtnTesoura.isSelected()) {
			JOptionPane.showMessageDialog(null, "Escolha Uma Opcao");
		} else {
			// Logica Principal
			Random random = new Random();
			int pc = random.nextInt(3);
			// Dica Para verificar o numero sorteado
			// System.out.println(pc);
			// Associar o numero a imagem
			switch (pc) {
			case 0:
				lblPC.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pcpedra.png")));
				break;
			case 1:
				lblPC.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pcpapel.png")));
				break;
			case 2:
				lblPC.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pctesoura.png")));
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
			lblPC.setIcon(new ImageIcon(Jokenpo.class.getResource("/img/pc.png")));
			buttonGroup.clearSelection();
		}

	}

}// Fim Do Codigo