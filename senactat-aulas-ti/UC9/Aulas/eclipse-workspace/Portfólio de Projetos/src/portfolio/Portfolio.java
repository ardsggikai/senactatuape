package portfolio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Portfolio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portfolio frame = new Portfolio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Portfolio() {
		setBackground(Color.WHITE);
		setTitle("Portfolio Do Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 410);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBotaodoimc = new JButton("Calculo do IMC");
		btnBotaodoimc.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBotaodoimc.setForeground(Color.BLACK);
		btnBotaodoimc.setBackground(Color.WHITE);
		btnBotaodoimc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// as linhas abaixo fazem o link com o formulario IMC
				IMC imc = new IMC();
				imc.setVisible(true);
				;
			}
		});
		btnBotaodoimc.setBounds(573, 85, 160, 23);
		contentPane.add(btnBotaodoimc);

		JButton btnSobre = new JButton("Sobre");
		btnSobre.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSobre.setForeground(Color.BLACK);
		btnSobre.setBackground(Color.WHITE);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// as linhas abaixo fazem o link com o formulario Sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setBounds(360, 29, 89, 23);
		contentPane.add(btnSobre);

		JButton btnFichaAluno = new JButton("Ficha aluno");
		btnFichaAluno.setFont(new Font("Arial", Font.PLAIN, 11));
		btnFichaAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FichaA fichaa = new FichaA();
				fichaa.setVisible(true);
				;
			}
		});
		btnFichaAluno.setForeground(Color.BLACK);
		btnFichaAluno.setBackground(Color.WHITE);
		btnFichaAluno.setBounds(59, 85, 160, 23);
		contentPane.add(btnFichaAluno);

		JButton btnBoletim = new JButton("Boletim");
		btnBoletim.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boletim boletim = new Boletim();
				boletim.setVisible(true);
				;
			}
		});
		btnBoletim.setForeground(Color.BLACK);
		btnBoletim.setBackground(Color.WHITE);
		btnBoletim.setBounds(59, 129, 160, 23);
		contentPane.add(btnBoletim);

		JButton btnCalculoDoTemperatura = new JButton("Calculo do Temperatura");
		btnCalculoDoTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura temperatura = new Temperatura();
				temperatura.setVisible(true);
			}
		});
		btnCalculoDoTemperatura.setForeground(Color.BLACK);
		btnCalculoDoTemperatura.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculoDoTemperatura.setBackground(Color.WHITE);
		btnCalculoDoTemperatura.setBounds(573, 129, 160, 23);
		contentPane.add(btnCalculoDoTemperatura);

		JButton btnCalculoDePorcentagem = new JButton("Calculo de Porcentagem");
		btnCalculoDePorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Porcentagem porcentagem = new Porcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnCalculoDePorcentagem.setForeground(Color.BLACK);
		btnCalculoDePorcentagem.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculoDePorcentagem.setBackground(Color.WHITE);
		btnCalculoDePorcentagem.setBounds(573, 173, 160, 23);
		contentPane.add(btnCalculoDePorcentagem);

	}
	// fim do construtor

}
