package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class Hora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCustoOperacional;
	private JTextField txtCargaHora;
	private JTextField txtRendimento;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Hora.class.getResource("/img/icohora.png")));
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().setLayout(null);
		
		JLabel lblRemuneracao = new JLabel("Remunera\u00E7\u00E3o:");
		lblRemuneracao.setFont(new Font("Arial", Font.PLAIN, 11));
		lblRemuneracao.setBounds(10, 28, 77, 14);
		getContentPane().add(lblRemuneracao);
		
		JLabel lblCustoOperacional = new JLabel("Custo Operacional:");
		lblCustoOperacional.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCustoOperacional.setBounds(10, 53, 102, 14);
		getContentPane().add(lblCustoOperacional);
		
		JLabel lblCargaHorariaMensal = new JLabel("Carga Hor\u00E1ria Mensal:");
		lblCargaHorariaMensal.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCargaHorariaMensal.setBounds(10, 78, 120, 14);
		getContentPane().add(lblCargaHorariaMensal);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salvar();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSalvar.setBounds(10, 115, 89, 23);
		getContentPane().add(btnSalvar);
		
		JLabel lblValorHora = new JLabel("Valor da Hora de Servi\u00E7o:");
		lblValorHora.setFont(new Font("Arial", Font.PLAIN, 11));
		lblValorHora.setBounds(10, 149, 146, 14);
		getContentPane().add(lblValorHora);
		
		JLabel lblEstimaHoras = new JLabel("Estimativa de Horas do Servi\u00E7o:");
		lblEstimaHoras.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEstimaHoras.setBounds(10, 200, 170, 14);
		getContentPane().add(lblEstimaHoras);
		
		txtRemuneracao = new JTextField();
		txtRemuneracao.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRemuneracao.setBounds(120, 25, 86, 20);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);
		
		txtCustoOperacional = new JTextField();
		txtCustoOperacional.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCustoOperacional.setColumns(10);
		txtCustoOperacional.setBounds(120, 50, 86, 20);
		getContentPane().add(txtCustoOperacional);
		
		txtCargaHora = new JTextField();
		txtCargaHora.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCargaHora.setColumns(10);
		txtCargaHora.setBounds(120, 75, 86, 20);
		getContentPane().add(txtCargaHora);
		
		txtRendimento = new JTextField();
		txtRendimento.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRendimento.setEditable(false);
		txtRendimento.setColumns(10);
		txtRendimento.setBounds(167, 146, 86, 20);
		getContentPane().add(txtRendimento);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_4.setColumns(10);
		textField_4.setBounds(167, 197, 86, 20);
		getContentPane().add(textField_4);
		setResizable(false);
		setModal(true);
		setTitle("Calculando do Valor De Hora de Servi\u00E7o");
		setBounds(100, 100, 310, 270);

	}// Fim do Construtor
	
	void Salvar() {
		// Declarando as variáveis
		double remuneracao, reserva, custoOperacional, investimentos, horas, rendimento;
		
		// Entrada
		remuneracao = Double.parseDouble(txtRemuneracao.getText());
		custoOperacional = Double.parseDouble(txtCustoOperacional.getText());
		horas = Double.parseDouble(txtCargaHora.getText());
		
		// Processamento
		reserva = 0.3 * remuneracao;
		investimentos = 0.2 * remuneracao;
		rendimento = (remuneracao + custoOperacional + reserva + investimentos) / horas;
		rendimento = Math.round(rendimento * 100.0) / 100.0;
		
		// Saída
		txtRendimento.setText(String.valueOf(rendimento));
	}
}//Fim do Codigo
