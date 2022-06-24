package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Hora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hora dialog = new Hora();
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
	public Hora() {
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().setLayout(null);
		
		JLabel lblRemuneracao = new JLabel("Remunera\u00E7\u00E3o:");
		lblRemuneracao.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRemuneracao.setBounds(10, 28, 77, 14);
		getContentPane().add(lblRemuneracao);
		
		JLabel lblCustoOperacional = new JLabel("Custo Operacional:");
		lblCustoOperacional.setBounds(10, 53, 102, 14);
		getContentPane().add(lblCustoOperacional);
		
		JLabel lblCargaHorariaMensal = new JLabel("Carga Hor\u00E1ria Mensal:");
		lblCargaHorariaMensal.setBounds(10, 78, 120, 14);
		getContentPane().add(lblCargaHorariaMensal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 115, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblValorHora = new JLabel("Valor da Hora de Servi\u00E7o:");
		lblValorHora.setBounds(10, 149, 146, 14);
		getContentPane().add(lblValorHora);
		
		JLabel lblEstimaHoras = new JLabel("Estimativa de Horas do Servi\u00E7o:");
		lblEstimaHoras.setBounds(10, 200, 170, 14);
		getContentPane().add(lblEstimaHoras);
		
		textField = new JTextField();
		textField.setBounds(120, 25, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 50, 86, 20);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 75, 86, 20);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(167, 146, 86, 20);
		getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(167, 197, 86, 20);
		getContentPane().add(textField_4);
		setResizable(false);
		setModal(true);
		setTitle("Calculando do Valor De Hora de Servi\u00E7o");
		setBounds(100, 100, 310, 270);

	}// Fim do Construtor
}//Fim do Codigo
