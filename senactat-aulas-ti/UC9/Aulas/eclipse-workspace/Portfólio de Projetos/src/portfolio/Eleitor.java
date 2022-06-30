package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Eleitor extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIdade;
	private JTextField txtResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eleitor dialog = new Eleitor();
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
	public Eleitor() {
		setModal(true);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eleitor.class.getResource("/img/icoEleitor.png")));
		setTitle("Teste Para verificar se voce pode votar");
		setBounds(100, 100, 330, 240);
		getContentPane().setLayout(null);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("Arial", Font.PLAIN, 11));
		lblIdade.setBounds(75, 52, 46, 14);
		getContentPane().add(lblIdade);

		txtIdade = new JTextField();
		txtIdade.setFont(new Font("Arial", Font.PLAIN, 11));
		txtIdade.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdade.setBounds(131, 49, 100, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		JButton btnVerifica = new JButton("Verifica");
		btnVerifica.setFont(new Font("Arial", Font.PLAIN, 11));
		btnVerifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verifica();
			}
		});
		btnVerifica.setBounds(141, 80, 82, 23);
		getContentPane().add(btnVerifica);

		txtResultado = new JTextField();
		txtResultado.setFont(new Font("Arial", Font.PLAIN, 11));
		txtResultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtResultado.setEditable(false);
		txtResultado.setBounds(131, 114, 100, 20);
		getContentPane().add(txtResultado);
		txtResultado.setColumns(10);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Arial", Font.PLAIN, 11));
		lblResultado.setBounds(65, 117, 62, 14);
		getContentPane().add(lblResultado);

	}// Fim do Construtor

	void verifica() {

		// Variáveis
		int idade;

		// Entrada
		idade = Integer.parseInt(txtIdade.getText());

		// Processamento e Saída
		if (idade < 16) {
			txtResultado.setText(String.valueOf("Voto proibido"));
			JOptionPane.showMessageDialog(null, "Voto proibido", "A sua hora vai chegar", JOptionPane.ERROR_MESSAGE);
		} else if (idade > 17 && idade < 71) {
			txtResultado.setText(String.valueOf("Voto obrigatório"));
			JOptionPane.showMessageDialog(null, "Voto obrigatório", "Cumpra com o seu dever cívico!",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			txtResultado.setText(String.valueOf("Voto facultativo"));
			JOptionPane.showMessageDialog(null, "Voto facultativo", "A decisão é sua!", JOptionPane.QUESTION_MESSAGE);
		}
	} // Fim do método verifica

}// Fim do Codigo
