package views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Usuarios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JTextField txtId;
	private JLabel lblId;
	private JTextField txtUsuario;
	private JButton btnCreate;
	private JButton btnSearch;
	private JButton btnDelete;
	private JTextField txtLog;
	private JButton btnUpdate;
	private JPasswordField txtPassword;
	@SuppressWarnings("rawtypes")
	private JComboBox cboPerfil;
	private JCheckBox chckbxSenha;
	private JLabel lblFone;
	private JTextField txtFone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios dialog = new Usuarios();
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/iconinfo.png")));
		setModal(true);
		getContentPane().setBackground(SystemColor.window);
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		getContentPane().setLayout(null);

		lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLogin.setBounds(23, 14, 57, 14);
		getContentPane().add(lblLogin);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		lblSenha.setBounds(23, 46, 57, 14);
		getContentPane().add(lblSenha);

		lblId = new JLabel("ID");
		lblId.setBounds(280, 69, 46, 14);
		getContentPane().add(lblId);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Arial", Font.PLAIN, 11));
		txtId.setBounds(297, 67, 57, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsuario.setBounds(23, 73, 46, 14);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Arial", Font.PLAIN, 11));
		txtUsuario.setBounds(80, 67, 190, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		setResizable(false);
		setTitle("Usuarios");
		setBounds(100, 100, 384, 300);
		setLocationRelativeTo(null);

		btnCreate = new JButton("");
		btnCreate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/create.png")));
		btnCreate.setToolTipText("Adicionar Usuario");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnCreate.setFocusPainted(false);
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setBounds(52, 136, 64, 64);
		getContentPane().add(btnCreate);

		btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(Usuarios.class.getResource("/img/delete.png")));
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByID();
			}
		});
		btnDelete.setToolTipText("Deletar Usuario");
		btnDelete.setFocusPainted(false);
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setBounds(252, 136, 64, 64);
		getContentPane().add(btnDelete);

		btnSearch = new JButton("");
		btnSearch.setBorderPainted(false);
		btnSearch.setBackground(SystemColor.window);
		btnSearch.setIcon(new ImageIcon(Usuarios.class.getResource("/img/btnSeach.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
			}
		});
		btnSearch.setToolTipText("Pesquisar Pelo Login");
		btnSearch.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSearch.setBounds(272, 5, 32, 32);
		getContentPane().add(btnSearch);

		txtLog = new JTextField();
		txtLog.setFont(new Font("Arial", Font.PLAIN, 11));
		txtLog.setBounds(80, 11, 190, 20);
		getContentPane().add(txtLog);
		txtLog.setColumns(10);

		getRootPane().setDefaultButton(btnSearch);

		RestrictedTextField usuario = new RestrictedTextField(txtUsuario);
		usuario.setOnlyText(true);
		usuario.setAcceptSpace(true);
		usuario.setLimit(50);

		RestrictedTextField login = new RestrictedTextField(txtLog);
		login.setLimit(40);

		btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(Usuarios.class.getResource("/img/update.png")));
		btnUpdate.setEnabled(false);
		btnUpdate.setToolTipText("Alterar Dados");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxSenha.isSelected()) {
					alterarUsuarioSenha();
				} else {
					alterarUsuario();
				}
			}
		});
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnUpdate.setBounds(152, 136, 64, 64);
		getContentPane().add(btnUpdate);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 211, 368, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblHoras = new JLabel("");
		lblHoras.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoras.setFont(new Font("Arial", Font.PLAIN, 11));
		lblHoras.setBounds(80, 11, 204, 28);
		panel.add(lblHoras);

		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPassword.setForeground(SystemColor.textInactiveText);
		txtPassword.setBounds(80, 40, 190, 20);
		getContentPane().add(txtPassword);

		cboPerfil = new JComboBox();
		cboPerfil.setModel(new DefaultComboBoxModel(new String[] { "", "admin", "user" }));
		cboPerfil.setFont(new Font("Arial", Font.PLAIN, 11));
		cboPerfil.setBounds(290, 93, 64, 22);
		getContentPane().add(cboPerfil);

		JLabel lblPerfil = new JLabel("Perfil :");
		lblPerfil.setBounds(236, 94, 46, 14);
		getContentPane().add(lblPerfil);

		chckbxSenha = new JCheckBox("Alterar Senha");
		chckbxSenha.setBackground(SystemColor.window);
		chckbxSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtPassword.setEditable(true);
				txtPassword.setText(null);
				txtPassword.requestFocus();
				txtPassword.setBackground(Color.BLACK);
			}
		});
		chckbxSenha.setVisible(false);
		chckbxSenha.setFont(new Font("Arial", Font.PLAIN, 11));
		chckbxSenha.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxSenha.setBounds(268, 39, 97, 23);
		getContentPane().add(chckbxSenha);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				Date data = new Date();
				DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				lblHoras.setText(formatador.format(data));

			}
		});

		lblFone = new JLabel("Fone:");
		lblFone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFone.setBounds(23, 97, 46, 14);
		getContentPane().add(lblFone);

		txtFone = new JTextField();
		txtFone.setToolTipText("Apenas Numeros");
		txtFone.setFont(new Font("Arial", Font.PLAIN, 11));
		txtFone.setBounds(80, 91, 97, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Usuarios.class.getResource("/img/eraser.png")));
		btnLimpar.setBounds(338, 187, 20, 20);
		getContentPane().add(btnLimpar);

		RestrictedTextField log1 = new RestrictedTextField(txtLog);
		log1.setLimit(20);

		RestrictedTextField senha = new RestrictedTextField(txtPassword);
		senha.setOnlyAlphaNumeric(true);
		senha.setLimit(250);

		RestrictedTextField usuario1 = new RestrictedTextField(txtUsuario);
		usuario1.setOnlyText(true);
		usuario1.setAcceptSpace(true);
		usuario1.setLimit(50);

		RestrictedTextField fone = new RestrictedTextField(txtFone);
		fone.setOnlyNums(true);
		fone.setLimit(13);

	}

	DAO dao = new DAO();

	private void pesquisarUsuario() {

		if (txtLog.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o seu login");
			txtLog.requestFocus();
		} else {

			String read = "select * from tbusuarios where login = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(read);

				pst.setString(1, txtLog.getText());

				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					txtId.setText(rs.getString(1));
					txtUsuario.setText(rs.getString(2));
					txtFone.setText(rs.getString(3));
					txtLog.setText(rs.getString(4));
					txtPassword.setText(rs.getString(5));
					cboPerfil.setSelectedItem(rs.getString(6));
					chckbxSenha.setVisible(true);
					txtPassword.setEditable(false);
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

					
					btnCreate.setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(null, "Usuario inexistente");
					limpar();
					txtLog.requestFocus();

					btnCreate.setEnabled(true);
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					txtUsuario.setText(null);
					txtPassword.setText(null);
					btnSearch.setEnabled(false);
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@SuppressWarnings("deprecation")
	void adicionarUsuario() {

		if (txtLog.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Login");
			txtLog.requestFocus();
		} else if (txtPassword.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Senha");
			txtPassword.requestFocus();	
		
		} else if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Usuario");
			txtUsuario.requestFocus();
		} else if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Campo Usuario");
			txtUsuario.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Numero");
			txtFone.requestFocus();
		} else if (cboPerfil.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Preencha o Perfil");
			cboPerfil.requestFocus();
			
		} else {

			String create = "insert into tbusuarios (Usuario, Login, fone,Senha, perfil) values (?,?,?,md5(?),?)";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(create);

				pst.setString(1, txtUsuario.getText());

				pst.setString(2, txtLog.getText());

				
				pst.setString(3, txtFone.getText());

				pst.setString(4, cboPerfil.getSelectedItem().toString());

				String capturaSenha = new String(txtPassword.getPassword());
				pst.setString(5, capturaSenha);

				
				btnCreate.setEnabled(true);
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);

				
				btnCreate.setEnabled(false);

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Usuario adicionado.");
					limpar();
				} else {

					JOptionPane.showMessageDialog(null, "Usuario Não Adicionado");
					limpar();

				}
				con.close();
			}

			catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showConfirmDialog(null, "Usuario não adicionado - Login Existente");
				txtLog.setText(null);
				txtLog.requestFocus();
			}

			catch (Exception e2) {
				System.out.println(e2);

				limpar();
			}
		}
	}

	private void alterarUsuario() {


			String update = "update tbusuarios set usuario = ?, fone = ?, login = ?, senha = md5(?), perfil = ? where iduser = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtLog.getText());
				String capturaSenha = new String(txtPassword.getPassword());
				pst.setString(4, capturaSenha);

				pst.setString(5, cboPerfil.getSelectedItem().toString());

				pst.setString(6, txtId.getText());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Informaçoes do Usuario Atualizados com Sucesso.");
					limpar();
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Usuario Não Atualizado");
				limpar();
			}
		}
	

	private void alterarUsuarioSenha() {

		if (txtUsuario.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Usuario");
			txtUsuario.requestFocus();
		} else if (txtLog.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Numero do Login");
			txtLog.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Telefone");
			txtFone.requestFocus();
		} else if (txtPassword.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Digite a Senha");
			txtPassword.requestFocus();
		} else {

			String update = "update tbusuarios set usuario = ?, fone = ?, login = ?, senha = md5(?), perfil = ? where iduser = ?";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtUsuario.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtLog.getText());
				String capturaSenha = new String(txtPassword.getPassword());
				pst.setString(4, capturaSenha);

				pst.setString(5, cboPerfil.getSelectedItem().toString());
				pst.setString(6, txtId.getText());

				int confirma = pst.executeUpdate();

				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Informaçoes do Usuario Atualizados com Sucesso.");
					limpar();
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Usuario Não Atualizado");
				limpar();
			}
		}
	}

	private void deleteByID() {

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão deste Usuario?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {

			String delete = "delete from tbusuarios where iduser = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtId.getText());

				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso");
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Usuario Não Foi Excluido");
				limpar();
			}

		}

	}

	private void limpar() {
		
		txtId.setText(null);
		txtUsuario.setText(null);
		txtLog.setText(null);
		txtFone.setText(null);
		txtPassword.setEditable(true);
		txtPassword.setText(null);
		txtPassword.setBackground(null);
		cboPerfil.setSelectedItem("");
		chckbxSenha.setSelected(false);
		chckbxSenha.setVisible(false);
		txtUsuario.requestFocus();
		btnCreate.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnSearch.setEnabled(true);
	}
}
