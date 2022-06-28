package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class Hora extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRemuneracao;
	private JTextField txtCustoOperacional;
	private JTextField txtCargaHora;
	private JTextField txtRendimento;
	private JTextField txtTempoEstimado;

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
		btnSalvar.setBounds(10, 126, 89, 23);
		getContentPane().add(btnSalvar);

		JLabel lblValorHora = new JLabel("Valor da Hora de Servi\u00E7o:");
		lblValorHora.setFont(new Font("Arial", Font.PLAIN, 11));
		lblValorHora.setBounds(10, 105, 146, 14);
		getContentPane().add(lblValorHora);

		JLabel lblEstimaHoras = new JLabel("Estimativa de Horas do Servi\u00E7o:");
		lblEstimaHoras.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEstimaHoras.setBounds(10, 174, 164, 14);
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
		txtRendimento.setBounds(166, 103, 86, 20);
		getContentPane().add(txtRendimento);

		txtTempoEstimado = new JTextField();
		txtTempoEstimado.setFont(new Font("Arial", Font.PLAIN, 11));
		txtTempoEstimado.setColumns(10);
		txtTempoEstimado.setBounds(166, 172, 86, 20);
		getContentPane().add(txtTempoEstimado);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularServico();
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.setBounds(10, 197, 89, 23);
		getContentPane().add(btnCalcular);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 160, 274, 2);
		getContentPane().add(panel);
		setResizable(false);
		setModal(true);
		setTitle("Calculando do Valor De Hora de Servi\u00E7o");
		setBounds(100, 100, 310, 270);

	}// Fim do Construtor

	// variaveis globais
	double rendimento;

	// Valor da Hora de Serviço:
	// Método usado para calcular o valor do serviço
	void Salvar() {
		// Declarando as variáveis
		double remuneracao, reserva, custoOperacional, investimentos, horas;

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

	// Estimativa de Horas do Serviço:
	// Método usado para calcular o valor do serviço
	void calcularServico() {
		// Declarando as variáveis
		double tempoEstimado, valor;

		// Entrada
		tempoEstimado = Double.parseDouble(txtTempoEstimado.getText());

		// Processamento
		valor = (tempoEstimado * rendimento);

		// Saída
       JOptionPane.showMessageDialog(null,"Valor do Serviço é $ " + valor,"Relatório",JOptionPane.DEFAULT_OPTION);
	}
}// Fim do Codigo
