package portfolio;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Portfolio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblStatus;

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
		setResizable(false);

		// Ativar Janela inferior
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblStatus.setText(formatador.format(data));
			}
		});

		setFont(new Font("Arial", Font.PLAIN, 12));
		setForeground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Portfolio.class.getResource("/img/pc.png")));
		setBackground(Color.WHITE);
		setTitle("Portfolio Do Projeto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 240, 350, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.GRAY);
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
		btnBotaodoimc.setBounds(65, 311, 64, 64);
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
		btnSobre.setBounds(260, 11, 64, 64);
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
		btnFichaAluno.setBounds(25, 11, 64, 64);
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
		btnBoletim.setBounds(175, 86, 64, 64);
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
		btnCalculoDoTemperatura.setBounds(199, 236, 64, 64);
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
		btnCalculoDePorcentagem.setBounds(105, 86, 64, 64);
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
		btnCalculoDeHora.setBounds(115, 161, 64, 64);
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
		btnEtanolGasolina.setBounds(125, 236, 64, 64);
		contentPane.add(btnEtanolGasolina);

		JButton btnEleitor = new JButton("");
		btnEleitor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEleitor.setIcon(new ImageIcon(Portfolio.class.getResource("/img/Eleitor.png")));
		btnEleitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eleitor eleitor = new Eleitor();
				eleitor.setVisible(true);
			}
		});
		btnEleitor.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEleitor.setToolTipText("Verificador de Idade Minima do Eleitor");
		btnEleitor.setBounds(95, 11, 64, 64);
		contentPane.add(btnEleitor);

		JButton btnDado = new JButton("");
		btnDado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDado.setIcon(new ImageIcon(Portfolio.class.getResource("/img/Dado.png")));
		btnDado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dado dado = new Dado();
				dado.setVisible(true);
			}
		});
		btnDado.setToolTipText("Lançar Dados");
		btnDado.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDado.setBounds(165, 11, 64, 64);
		contentPane.add(btnDado);

		JButton btnCep = new JButton("");
		btnCep.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCep.setIcon(new ImageIcon(Portfolio.class.getResource("/img/Cep.png")));
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cep cep = new Cep();
				cep.setVisible(true);
			}
		});
		btnCep.setToolTipText("Verificar Cep");
		btnCep.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCep.setBounds(45, 161, 64, 64);
		contentPane.add(btnCep);

		JButton btnTabuada = new JButton("");
		btnTabuada.setIcon(new ImageIcon(Portfolio.class.getResource("/img/Tabuada.png")));
		btnTabuada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tabuada tabuada = new Tabuada();
				tabuada.setVisible(true);
			}
		});
		btnTabuada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTabuada.setToolTipText("Calculo da Tabuada");
		btnTabuada.setFont(new Font("Arial", Font.PLAIN, 11));
		btnTabuada.setBounds(55, 236, 64, 64);
		contentPane.add(btnTabuada);

		JButton btnJoKenPo = new JButton("");
		btnJoKenPo.setIcon(new ImageIcon(Portfolio.class.getResource("/img/JokenpoP.png")));
		btnJoKenPo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Jokenpo jokenpo = new Jokenpo();
				jokenpo.setVisible(true);
			}
		});
		btnJoKenPo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnJoKenPo.setToolTipText("Botão Do JoKenPo");
		btnJoKenPo.setFont(new Font("Arial", Font.PLAIN, 11));
		btnJoKenPo.setBounds(139, 311, 64, 64);
		contentPane.add(btnJoKenPo);

		JButton btnGerarSenhas = new JButton("");
		btnGerarSenhas.setIcon(new ImageIcon(Portfolio.class.getResource("/img/btnSenha.png")));
		btnGerarSenhas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gsenhas gsenhas = new Gsenhas();
				gsenhas.setVisible(true);
			}
		});
		btnGerarSenhas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGerarSenhas.setToolTipText("Gerar Senhas");
		btnGerarSenhas.setFont(new Font("Arial", Font.PLAIN, 11));
		btnGerarSenhas.setBounds(209, 311, 64, 64);
		contentPane.add(btnGerarSenhas);

		JButton btnCarta = new JButton("");
		btnCarta.setIcon(new ImageIcon(Portfolio.class.getResource("/img/btnCartas.png")));
		btnCarta.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carta carta = new Carta();
				carta.setVisible(true);

			}
		});
		btnCarta.setToolTipText("Jogo de Cartas");
		btnCarta.setBounds(35, 86, 64, 64);
		contentPane.add(btnCarta);

		panel = new JPanel();
		panel.setBounds(0, 400, 334, 31);
		contentPane.add(panel);

		lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Arial", Font.BOLD, 16));
		lblStatus.setBounds(0, 0, 334, 46);
		panel.add(lblStatus);
		
		JButton btnConverter = new JButton("");
		btnConverter.setIcon(new ImageIcon(Portfolio.class.getResource("/img/BtnMoeda.png")));
		btnConverter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Moeda moeda = new Moeda();
				moeda.setVisible(true);
			}
		});
		btnConverter.setToolTipText("Converter moedas");
		btnConverter.setFont(new Font("Arial", Font.PLAIN, 11));
		btnConverter.setBounds(185, 161, 64, 64);
		contentPane.add(btnConverter);

	}//

}// Fim do Codigo
