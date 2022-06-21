package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FichaA extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtPeso;
	private JTextField txtAltura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaA dialog = new FichaA();
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
	public FichaA() {
		setResizable(false);
		setModal(true);
		setTitle("Ficha aluno");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(46, 42, 46, 14);
		getContentPane().add(lblNewLabel);

		txtNome = new JTextField();
		txtNome.setBounds(97, 39, 272, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnNewButton.setBounds(52, 202, 89, 23);
		getContentPane().add(btnNewButton);

		JLabel lblNewLabel2 = new JLabel("Idade");
		lblNewLabel2.setBounds(46, 80, 46, 14);
		getContentPane().add(lblNewLabel2);

		txtIdade = new JTextField();
		txtIdade.setBounds(97, 77, 61, 20);
		getContentPane().add(txtIdade);
		txtIdade.setColumns(10);

		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(97, 108, 61, 20);
		getContentPane().add(txtPeso);

		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(97, 139, 61, 20);
		getContentPane().add(txtAltura);

		JLabel lblNewLabel3 = new JLabel("Peso");
		lblNewLabel3.setBounds(46, 111, 46, 14);
		getContentPane().add(lblNewLabel3);

		JLabel lblNewLabel4 = new JLabel("Altura");
		lblNewLabel4.setBounds(46, 142, 46, 14);
		getContentPane().add(lblNewLabel4);

	}// fim do construtor

	// Metodo responsavel pelo calculo do IMC

	void calcular() {

		// Calculo do IMC

		String nome;
		int idade;
		double peso, altura;
		// Armazenando o conteudo da caixa de texto na variavel

		nome = txtNome.getText();

		// Integer.parseInt (converter o conteúdo da caixa de texto para número inteiro)

		idade = Integer.parseInt(txtIdade.getText());

		// Double.parseDouble (converter o conteúdo da caixa de texto para números
		// inteiros e não inteiros)

		peso = Double.parseDouble(txtPeso.getText());

		altura = Double.parseDouble(txtAltura.getText());

		// A linha abaixo exibe o nome armazenado na variavel em uma caixa de mensagem.

		// Para personalizar a caixa de mensagem devemos adicionar um texto para o

		// titulo e um icone personalizado

		JOptionPane.showMessageDialog(null, "Nome: " + nome
				+"\nIdade: " + idade + "\nPeso: " + peso + "\nAltura: " + altura, "Ficha do aluno",
				JOptionPane.DEFAULT_OPTION);
	}
}