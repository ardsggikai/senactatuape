package views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextField txtLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/icoLogin.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setTitle("VIA Motors - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 355);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(Login.class.getResource("/img/logo-boa.png")));
		lblImagem.setBounds(44, 11, 200, 180);
		contentPane.add(lblImagem);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Arial", Font.BOLD, 11));
		lblLogin.setBounds(44, 202, 38, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.BOLD, 11));
		lblSenha.setBounds(43, 226, 46, 14);
		contentPane.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		txtLogin.setBounds(88, 198, 114, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStatus.setBounds(248, 252, 32, 32);
		contentPane.add(lblStatus);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		txtSenha.setBounds(88, 223, 114, 20);
		contentPane.add(txtSenha);

		JButton btnAcessar = new JButton("Logar");
		btnAcessar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnAcessar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAcessar.setBounds(110, 252, 67, 23);
		contentPane.add(btnAcessar);

		getRootPane().setDefaultButton(btnAcessar);

		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setOnlyAlphaNumeric(true);
		login.setLimit(15);

		RestrictedTextField senha = new RestrictedTextField(txtSenha);
		senha.setLimit(250);

	}// fim do Construtor

	DAO dao = new DAO();

	private JLabel lblStatus;
	private JPasswordField txtSenha;

	private void status() {

		try {
			Connection con = dao.conectar();
			if (con == null) {
				System.out.println("Erro de Conexão");
				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dboff - 32.png")));
			} else {
				System.out.println("Banco Conectado!");
				lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/dbon - 32.png")));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void logar() {

		String capturaSenha = new String(txtSenha.getPassword());
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu login");
			txtLogin.requestFocus();
		} else if (capturaSenha.length() == 0) {
			JOptionPane.showMessageDialog(null, "Informe a sua senha");
			txtSenha.requestFocus();
		} else {
			String read = "select * from tbusuarios where login = ? and senha = md5(?)";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);

				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					MainOS main = new MainOS();

					
					String perfil = rs.getString(6);

					
					if (perfil.equals("admin")) {

						main.setVisible(true);
						
						main.lblUsuarios.setText(rs.getString(2));

						
						main.btnRelatorios.setEnabled(true);
						main.btnUsuarios_1.setEnabled(true);
						main.btnRelatorioOS.setEnabled(true);

						this.dispose();

					} else {

						main.setVisible(true);
						
						main.btnRelatorios.setEnabled(false);
						main.btnUsuarios_1.setEnabled(false);
						main.lblUsuarios.setText(rs.getString(2));

						this.dispose();

					}

				} else {
					JOptionPane.showMessageDialog(null, "Login ou Senha Incorreto");
				}

				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	} 

}
