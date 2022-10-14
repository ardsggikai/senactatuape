package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Atxy2k.CustomTextField.RestrictedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

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
		lblRemuneracao.setBounds(71, 28, 77, 14);
		getContentPane().add(lblRemuneracao);

		JLabel lblCustoOperacional = new JLabel("Custo Operacional:");
		lblCustoOperacional.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCustoOperacional.setBounds(47, 53, 102, 14);
		getContentPane().add(lblCustoOperacional);

		JLabel lblCargaHorariaMensal = new JLabel("Carga Hor\u00E1ria Mensal:");
		lblCargaHorariaMensal.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCargaHorariaMensal.setBounds(30, 78, 120, 14);
		getContentPane().add(lblCargaHorariaMensal);

		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(Hora.class.getResource("/img/btnSave.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salvar();
			}
		});
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSalvar.setBounds(176, 128, 64, 64);
		getContentPane().add(btnSalvar);

		JLabel lblValorHora = new JLabel("Valor da Hora de Servi\u00E7o:");
		lblValorHora.setFont(new Font("Arial", Font.PLAIN, 11));
		lblValorHora.setBounds(10, 103, 146, 14);
		getContentPane().add(lblValorHora);

		JLabel lblEstimaHoras = new JLabel("Estimativa de Horas do Servi\u00E7o:");
		lblEstimaHoras.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEstimaHoras.setBounds(10, 216, 164, 14);
		getContentPane().add(lblEstimaHoras);

		txtRemuneracao = new JTextField();
		txtRemuneracao.setFont(new Font("Arial", Font.PLAIN, 11));
		txtRemuneracao.setBounds(166, 26, 86, 20);
		getContentPane().add(txtRemuneracao);
		txtRemuneracao.setColumns(10);

		txtCustoOperacional = new JTextField();
		txtCustoOperacional.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCustoOperacional.setColumns(10);
		txtCustoOperacional.setBounds(166, 51, 86, 20);
		getContentPane().add(txtCustoOperacional);

		txtCargaHora = new JTextField();
		txtCargaHora.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCargaHora.setColumns(10);
		txtCargaHora.setBounds(166, 76, 86, 20);
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
		txtTempoEstimado.setBounds(166, 214, 86, 20);
		getContentPane().add(txtTempoEstimado);

		JButton btnCalcular = new JButton("");
		btnCalcular.setIcon(new ImageIcon(Hora.class.getResource("/img/btnCalcular.png")));
		btnCalcular.setToolTipText("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularServico();
			}
		});
		btnCalcular.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalcular.setBounds(176, 241, 64, 64);
		getContentPane().add(btnCalcular);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 203, 274, 2);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(10, 316, 274, 2);
		getContentPane().add(panel_1);

		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Hora.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setBounds(176, 329, 64, 64);
		getContentPane().add(btnLimpar);
		setResizable(false);
		setModal(true);
		setTitle("Calculando do Valor De Hora de Servi\u00E7o");
		setBounds(100, 100, 310, 442);
		setLocationRelativeTo(null);

		// Uso da biblioteca Atxy2k

		RestrictedTextField validar1 = new RestrictedTextField(txtRemuneracao, "1234567890.");
		validar1.setLimit(11);

		RestrictedTextField validar2 = new RestrictedTextField(txtCustoOperacional, "1234567890.");
		validar2.setLimit(8);

		RestrictedTextField validar3 = new RestrictedTextField(txtCargaHora, "1234567890.");
		validar3.setLimit(4);

		RestrictedTextField validar5 = new RestrictedTextField(txtTempoEstimado, "1234567890.");
		validar5.setLimit(5);

	}// Fim do Construtor

	// variaveis globais
	double rendimento;

	// Valor da Hora de Servico:
	// Metodo usado para calcular o valor do servico
	void Salvar() {
		// Validação
		if (txtRemuneracao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Rendimento");
			txtRemuneracao.requestFocus();
		} else if (txtCustoOperacional.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Custo Operacional");
			txtCustoOperacional.requestFocus();
		} else if (txtCargaHora.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Carga Horaria Mensal");
			txtCargaHora.requestFocus();
		} else {

			{
			}

			// Declarando as variaveis
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

			// Saida
			txtRendimento.setText(String.valueOf(rendimento));
		}
	}

	// Estimativa de Horas do Serviço:
	// Metodo usado para calcular o valor do serviço
	void calcularServico() {
		// Validação
		
		if (txtTempoEstimado.getText().isEmpty()) {
			JOptionPane.showMessageDialog(txtTempoEstimado, "Preencha o Rendimento");
			txtTempoEstimado.requestFocus();
		}
		
		// Declarando as variaveis
		double tempoEstimado, valor;

		// Entrada
		tempoEstimado = Double.parseDouble(txtTempoEstimado.getText());

		// Processamento
		valor = (tempoEstimado * rendimento);

		// Saida
		JOptionPane.showMessageDialog(null, "Valor do Serviço é $ " + valor, "Relatorio", JOptionPane.DEFAULT_OPTION);
	}

	// metodo limpar
	void limpar() {
		txtRemuneracao.setText(null);
		txtCustoOperacional.setText(null);
		txtCargaHora.setText(null);
		txtRendimento.setText(null);
		txtTempoEstimado.setText(null);
		txtRemuneracao.requestFocus();
	}

}// Fim do Codigo
