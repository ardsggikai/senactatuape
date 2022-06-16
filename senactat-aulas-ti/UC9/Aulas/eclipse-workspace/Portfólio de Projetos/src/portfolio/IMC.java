package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IMC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;

	/**
	 * Launch the application.
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
	 * Create the dialog.
	 */
	public IMC() {
		setTitle("IMC");
		setModal(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(21, 40, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(60, 37, 160, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Cálculo do IMC
			String nome;
			// Armazenando o conteúdo da caixa de texto na variável
			nome = txtNome.getText();
			// A linha  abaixo exibe o nome armazenado na variável em uma caixa de mensagem.
			// titulo e um icone personalizado 
			JOptionPane.showMessageDialog(null, "Nome: " + nome, "Aluno", JOptionPane.DEFAULT_OPTION);
			}
		});
		btnNewButton.setBounds(10, 80, 89, 23);
		getContentPane().add(btnNewButton);

	}

}
