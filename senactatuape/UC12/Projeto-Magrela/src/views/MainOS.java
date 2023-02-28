package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class MainOS extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblHoras;
	JPanel panelUsuario;
	JLabel lblUsuarios;
	JButton btnRelatorios;
	JButton btnUsuarios_1;
	JButton btnRelatorioOS;
	private JButton btnAbout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainOS frame = new MainOS();
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
	public MainOS() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainOS.class.getResource("/img/iconOS.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblHoras.setText(formatador.format(data));

			}
		});
		setTitle("VIA Motors - MainOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 520);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(MainOS.class.getResource("/img/btnClientes.png")));
		btnClientes.setToolTipText("Abrir Clientes");
		btnClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientes.setFocusPainted(false);
		btnClientes.setDefaultCapable(false);
		btnClientes.setBorderPainted(false);
		btnClientes.setBackground(SystemColor.window);
		btnClientes.setBounds(210, 42, 128, 128);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clientes clientes = new Clientes();
				clientes.setVisible(true);
			}
		});
		btnClientes.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnClientes);

		btnUsuarios_1 = new JButton("");
		btnUsuarios_1.setEnabled(false);
		btnUsuarios_1.setIcon(new ImageIcon(MainOS.class.getResource("/img/btnUsuarios.png")));
		btnUsuarios_1.setToolTipText("Abrir Usuarios");
		btnUsuarios_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios_1.setFocusPainted(false);
		btnUsuarios_1.setDefaultCapable(false);
		btnUsuarios_1.setBorderPainted(false);
		btnUsuarios_1.setBackground(SystemColor.window);
		btnUsuarios_1.setBounds(10, 42, 128, 128);
		btnUsuarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios_1.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnUsuarios_1);

		JButton btnOS = new JButton("");
		btnOS.setIcon(new ImageIcon(MainOS.class.getResource("/img/btnOS.png")));
		btnOS.setToolTipText("Abrir OS");
		btnOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOS.setFocusPainted(false);
		btnOS.setDefaultCapable(false);
		btnOS.setBorderPainted(false);
		btnOS.setBackground(SystemColor.window);
		btnOS.setBounds(10, 204, 128, 128);
		btnOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Telaos telaos = new Telaos();
				telaos.setVisible(true);
			}
		});
		btnOS.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnOS);

		btnRelatorios = new JButton("");
		btnRelatorios.setEnabled(false);
		btnRelatorios.setIcon(new ImageIcon(MainOS.class.getResource("/img/btnRelatorios.png")));
		btnRelatorios.setToolTipText("Abrir Relatorios");
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setFocusPainted(false);
		btnRelatorios.setDefaultCapable(false);
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.setBackground(SystemColor.window);
		btnRelatorios.setBounds(210, 204, 128, 128);
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setFont(new Font("Arial", Font.PLAIN, 11));
		contentPane.add(btnRelatorios);

		lblHoras = new JLabel("");
		lblHoras.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblHoras.setBounds(10, 11, 320, 20);
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setFont(new Font("Arial Black", Font.PLAIN, 11));
		contentPane.add(lblHoras);

		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.window);
		panelUsuario.setBounds(0, 434, 348, 47);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);

		lblUsuarios = new JLabel("");
		lblUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblUsuarios.setBounds(33, 11, 275, 25);
		panelUsuario.add(lblUsuarios);
		
		btnRelatorioOS = new JButton("");
		btnRelatorioOS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorioOS.setBorderPainted(false);
		btnRelatorioOS.setContentAreaFilled(false);
		btnRelatorioOS.setEnabled(false);
		btnRelatorioOS.setToolTipText("Abra para Ver Todas as OS");
		btnRelatorioOS.setIcon(new ImageIcon(MainOS.class.getResource("/img/btnPesquisaOS.png")));
		btnRelatorioOS.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRelatorioOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PesquisaOS pesquisaos = new PesquisaOS();
				pesquisaos.setVisible(true);
			}
		});
		btnRelatorioOS.setBounds(136, 359, 64, 64);
		contentPane.add(btnRelatorioOS);
		
		btnAbout = new JButton("");
		btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnAbout.setContentAreaFilled(false);
		btnAbout.setIcon(new ImageIcon(MainOS.class.getResource("/img/btnAbout.png")));
		btnAbout.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAbout.setToolTipText("Sobre Nos");
		btnAbout.setBounds(306, 400, 24, 24);
		contentPane.add(btnAbout);

	}
}
