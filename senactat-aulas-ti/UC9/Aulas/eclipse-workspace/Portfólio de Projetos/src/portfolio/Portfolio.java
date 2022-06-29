package portfolio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Cursor;

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
		setFont(new Font("Arial", Font.PLAIN, 12));
		setForeground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portfolio.class.getResource("/img/pc.png")));
		setBackground(Color.WHITE);
		setTitle("Portfolio Do Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 500);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBotaodoimc = new JButton("");
		btnBotaodoimc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBotaodoimc.setIcon(new ImageIcon(Portfolio.class.getResource("/img/imc.png")));
		btnBotaodoimc.setToolTipText("Calculo do IMC");
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
		btnBotaodoimc.setBounds(621, 60, 64, 64);
		contentPane.add(btnBotaodoimc);

		JButton btnSobre = new JButton("");
		btnSobre.setIcon(new ImageIcon(Portfolio.class.getResource("/img/sobre.png")));
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		btnSobre.setBounds(360, 11, 64, 64);
		contentPane.add(btnSobre);

		JButton btnFichaAluno = new JButton("");
		btnFichaAluno.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFichaAluno.setIcon(new ImageIcon(Portfolio.class.getResource("/img/fichaaluno.png")));
		btnFichaAluno.setToolTipText("Ficha aluno");
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
		btnFichaAluno.setBounds(113, 60, 64, 64);
		contentPane.add(btnFichaAluno);

		JButton btnBoletim = new JButton("");
		btnBoletim.setToolTipText("Calculo da Media do Boletim");
		btnBoletim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBoletim.setIcon(new ImageIcon(Portfolio.class.getResource("/img/media.png")));
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
		btnBoletim.setBounds(113, 135, 64, 64);
		contentPane.add(btnBoletim);

		JButton btnCalculoDoTemperatura = new JButton("");
		btnCalculoDoTemperatura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculoDoTemperatura.setIcon(new ImageIcon(Portfolio.class.getResource("/img/temperatura.png")));
		btnCalculoDoTemperatura.setToolTipText("Calculo do Temperatura");
		btnCalculoDoTemperatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Temperatura temperatura = new Temperatura();
				temperatura.setVisible(true);
			}
		});
		btnCalculoDoTemperatura.setForeground(Color.BLACK);
		btnCalculoDoTemperatura.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculoDoTemperatura.setBackground(Color.WHITE);
		btnCalculoDoTemperatura.setBounds(621, 135, 64, 64);
		contentPane.add(btnCalculoDoTemperatura);

		JButton btnCalculoDePorcentagem = new JButton("");
		btnCalculoDePorcentagem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculoDePorcentagem.setIcon(new ImageIcon(Portfolio.class.getResource("/img/porcentagem.png")));
		btnCalculoDePorcentagem.setToolTipText("Calculo de Porcentagem");
		btnCalculoDePorcentagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Porcentagem porcentagem = new Porcentagem();
				porcentagem.setVisible(true);
			}
		});
		btnCalculoDePorcentagem.setForeground(Color.BLACK);
		btnCalculoDePorcentagem.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculoDePorcentagem.setBackground(Color.WHITE);
		btnCalculoDePorcentagem.setBounds(621, 210, 64, 64);
		contentPane.add(btnCalculoDePorcentagem);

		JButton btnCalculoDeHora = new JButton("");
		btnCalculoDeHora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculoDeHora.setIcon(new ImageIcon(Portfolio.class.getResource("/img/hora.png")));
		btnCalculoDeHora.setToolTipText("Calculo de Hora");
		btnCalculoDeHora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hora hora = new Hora();
				hora.setVisible(true);
			}
		});
		btnCalculoDeHora.setForeground(Color.BLACK);
		btnCalculoDeHora.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCalculoDeHora.setBackground(Color.WHITE);
		btnCalculoDeHora.setBounds(621, 285, 64, 64);
		contentPane.add(btnCalculoDeHora);

		JButton btnEtanolGasolina = new JButton("");
		btnEtanolGasolina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEtanolGasolina.setIcon(new ImageIcon(Portfolio.class.getResource("/img/EtanolGasolina.png")));
		btnEtanolGasolina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EtanolGasolina etanolgasolina = new EtanolGasolina();
				etanolgasolina.setVisible(true);
			}
		});
		btnEtanolGasolina.setToolTipText("Calculo de Gasolina");
		btnEtanolGasolina.setForeground(Color.BLACK);
		btnEtanolGasolina.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEtanolGasolina.setBackground(Color.WHITE);
		btnEtanolGasolina.setBounds(621, 360, 64, 64);
		contentPane.add(btnEtanolGasolina);

	}// Fim do Construtor
}// Fim do Codigo
