package portfolio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;

public class Gsenhas extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtDigitos;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gsenhas dialog = new Gsenhas();
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
	public Gsenhas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gsenhas.class.getResource("/img/icoSenha.png")));
		getContentPane().setBackground(SystemColor.activeCaptionBorder);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		setTitle("Gerador De senhas");
		setBounds(100, 100, 500, 240);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblGerarSenha = new JLabel("Digite a Quantidade de Digitos da sua Senha :");
		lblGerarSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		lblGerarSenha.setBounds(30, 49, 251, 14);
		getContentPane().add(lblGerarSenha);

		JButton btnGerar = new JButton("");
		btnGerar.setIcon(new ImageIcon(Gsenhas.class.getResource("/img/btnGerar.png")));
		btnGerar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gerarsenhas();
			}
		});
		btnGerar.setToolTipText("Gerar Senha");
		btnGerar.setBounds(368, 23, 64, 64);
		getContentPane().add(btnGerar);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 168, 484, 33);
		getContentPane().add(panel);
		
				JLabel lblAviso = new JLabel("Limite de 44 Digitos!");
				panel.add(lblAviso);
				lblAviso.setBackground(SystemColor.text);
				lblAviso.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));

		txtDigitos = new JTextField();
		txtDigitos.setHorizontalAlignment(SwingConstants.CENTER);
		txtDigitos.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDigitos.setBounds(260, 46, 64, 20);
		getContentPane().add(txtDigitos);
		txtDigitos.setColumns(10);
		
		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(30, 86, 294, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);
		
		// Uso da Biblioteca Atxy2k
		RestrictedTextField digitos = new RestrictedTextField(txtDigitos, "0123456789");
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar ();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Gsenhas.class.getResource("/img/eraser.png")));
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(368, 98, 64, 64);
		getContentPane().add(btnLimpar);
		digitos.setLimit(2);

	}// Fim do construtor

	// Metodo responsavel pelo Gerador de senhas
	void Gerarsenhas() {

		// Validacao
		if (txtDigitos.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, " Digite o numero de caracteres para sua senha: ");
			txtDigitos.requestFocus();
		} else {
			Random random = new Random();

			String[] letras = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
					"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
					"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
					"Y", "Z" };
			String b = "";
			int digitos;
			digitos = Integer.parseInt(txtDigitos.getText());
			
			//int num = extracted().nextInt();

			for (int i = 0; i < digitos; i++) {
				int a = random.nextInt(letras.length);
				b += letras[a];
			}
			txtResultado.setText(String.valueOf(b));

			// System.out.print("Senha gerada: " + b);
		}
	}
	// metodo limpar
		void limpar() {
			txtDigitos.setText(null);
			txtResultado.setText(null);
			txtDigitos.requestFocus();
		}
}
