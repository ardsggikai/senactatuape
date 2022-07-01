package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class IMC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Inicie o aplicativo.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC dialog = new IMC();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crie o dialogo.
	 */
	public IMC() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IMC.class.getResource("/img/pesoimc.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		setTitle("Calculo do IMC");
		setModal(true);
		setBounds(100, 100, 500, 136);
		getContentPane().setLayout(null);

		JButton cmdiniciar = new JButton("Clique Aki Para Iniciar");
		cmdiniciar.setFont(new Font("Arial", Font.PLAIN, 11));
		cmdiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		cmdiniciar.setBounds(138, 36, 167, 20);
		getContentPane().add(cmdiniciar);

	}// Fim do Construtor

	// Metodo responsavel pelo calculo do IMC
	void calcular() {

		String nome1, nome2;
		float peso1, peso2, altura1, altura2;
		float imc1, imc2;
		String classifica1, classifica2;

		nome1 = JOptionPane.showInputDialog("Nome da Pessoa 1:");
		peso1 = Float.parseFloat(JOptionPane.showInputDialog("Peso da Pessoa 1 (kg):"));
		altura1 = Float.parseFloat(JOptionPane.showInputDialog("Altura da Pessoa 1 (m):"));
		nome2 = JOptionPane.showInputDialog("Nome da Pessoa 2:");
		peso2 = Float.parseFloat(JOptionPane.showInputDialog("Peso da Pessoa 2 (kg):"));
		altura2 = Float.parseFloat(JOptionPane.showInputDialog("Altura da Pessoa 2 (m):"));

		imc1 = (float) (peso1 / Math.pow(altura1, 2));
		imc2 = (float) (peso2 / Math.pow(altura2, 2));

		if (imc1 <= 18.5)
			classifica1 = "Abaixo do Peso";
		else if (imc1 <= 24.9)
			classifica1 = "Peso ideal";
		else if (imc1 <= 29.9)
			classifica1 = "Acima do Peso";
		else if (imc1 <= 39.9)
			classifica1 = "Obesidade Leve";
		else
			classifica1 = "Obesidade";

		if (imc2 <= 18.5)
			classifica2 = "Abaixo do Peso";
		else if (imc2 <= 24.9)
			classifica2 = "Peso ideal";
		else if (imc2 <= 29.9)
			classifica2 = "Acima do Peso";
		else if (imc2 <= 39.9)
			classifica2 = "Obesidade Leve";
		else
			classifica2 = "Obesidade";

		JOptionPane.showMessageDialog(null, "IMC da Pessoa 1 = " + imc1 + " - " + classifica1);
		JOptionPane.showMessageDialog(null, "IMC da Pessoa 2 = " + imc2 + " - " + classifica2);

		if (imc1 > imc2)
			JOptionPane.showMessageDialog(null, "A Pessoa \"" + nome1 + "\" tem Maior IMC");
		else
			JOptionPane.showMessageDialog(null, "A Pessoa \"" + nome2 + "\" tem Maior IMC");

	}

}// Fim do Construtor
