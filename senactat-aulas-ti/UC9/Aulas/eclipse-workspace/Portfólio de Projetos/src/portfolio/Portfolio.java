package portfolio;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setTitle("portfolio do projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 410);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBotaodoimc = new JButton("Calculo do IMC");
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

	}// fim do construtor
}
