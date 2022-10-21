package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;
import Atxy2k.CustomTextField.RestrictedTextField;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.SystemColor;

public class Agenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Agenda frame = new Agenda();
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
	public Agenda() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setResizable(false);
		setTitle("Agenda de Contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 290);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setForeground(SystemColor.text);
		lblId.setHorizontalTextPosition(SwingConstants.CENTER);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblId.setBounds(339, 56, 46, 14);
		contentPane.add(lblId);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(SystemColor.text);
		lblNome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(32, 53, 57, 14);
		contentPane.add(lblNome);

		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Arial", Font.PLAIN, 11));
		txtId.setBounds(375, 54, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNome.setBounds(91, 51, 180, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblFone = new JLabel("Fone");
		lblFone.setForeground(SystemColor.text);
		lblFone.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFone.setHorizontalAlignment(SwingConstants.CENTER);
		lblFone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFone.setBounds(32, 94, 46, 14);
		contentPane.add(lblFone);

		txtFone = new JTextField();
		txtFone.setBounds(91, 91, 110, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);

		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(36, 125, 46, 14);
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(91, 121, 212, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		btnCreate = new JButton("");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarContato();
			}
		});
		btnCreate.setEnabled(false);
		btnCreate.setToolTipText("Adicionar Contato");
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnCreate.png")));
		btnCreate.setBorderPainted(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCreate.setBounds(69, 176, 64, 64);
		contentPane.add(btnCreate);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByID();
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setToolTipText("Deletar Contato");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnDelete.png")));
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(271, 175, 64, 64);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarContato();
			}
		});
		btnUpdate.setEnabled(false);
		btnUpdate.setToolTipText("Atualizar Lista de Contato");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnUpdate.png")));
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(164, 176, 64, 64);
		contentPane.add(btnUpdate);

		btnRead = new JButton("");
		btnRead.setFocusPainted(false);
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarContato();
			}
		});
		btnRead.setToolTipText("Pesquisar Contatos");
		btnRead.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRead.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnRead.png")));
		btnRead.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRead.setContentAreaFilled(false);
		btnRead.setBorderPainted(false);
		btnRead.setBounds(257, 29, 64, 64);
		contentPane.add(btnRead);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		lblStatus.setBounds(395, 85, 48, 48);
		contentPane.add(lblStatus);

		// Uso da tecla <Enter> junto com um botao
		getRootPane().setDefaultButton(btnRead);

		// Uso da biblioteca atxy2k para restringir o maximo de caracteres
		// txtNome
		RestrictedTextField nome = new RestrictedTextField(txtNome);
		nome.setOnlyText(true);
		nome.setAcceptSpace(true);
		nome.setLimit(50);
		// txtFone
		RestrictedTextField fone = new RestrictedTextField(txtFone);
		fone.setOnlyNums(true);
		fone.setLimit(10);
		// txtEmail
		RestrictedTextField email = new RestrictedTextField(txtEmail);
		email.setAcceptSpace(true);
		email.setLimit(50);

	}// Fim Do Construtor

	// Criar um objeto para acessar o metodo conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnRead;

	/**
	 * Metodo responsavel por verificar o status da conexÃ£o com o banco
	 */
	private void status() {
		// System.out.println("Teste - Janela Ativada");
		// uso da classe connection (JDBC) para estabelecer a conexÃ£o
		try {
			Connection con = dao.conectar();
			if (con == null) {
				System.out.println("Erro de ConexÃ£o");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				System.out.println("Banco Conectado!");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
			}
			// Nunca esquecer de encerrar a conexÃ£o
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	} // Fim do Status

	/**
	 * Metodo responsavel pela pesquisa (select)
	 */

	private void pesquisarContato() {
		// Validaçao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Contato");
			txtNome.requestFocus();
		} else {

			// System.out.println("Teste Pesquisar"); (pra testar)
			// ? Ã© um parÃ¢metro a ser substituido
			String read = "select * from contatos where nome = ?";
			try {

				// Estabelecer a conexÃ£o ("abrir a porta da geladeira")
				Connection con = dao.conectar();
				// Preparar o codigo sql para execução
				PreparedStatement pst = con.prepareStatement(read);
				// A Linha abaixo substituir o ? pelo conteÃºdo da caixa de texto txtNome, o 1
				// faz referÃªncia a interrogaÃ§Ã£o
				pst.setString(1, txtNome.getText());
				// Obter os dados do contato (resultado)
				ResultSet rs = pst.executeQuery();
				// Verificar se existe um contato cadastrado
				// rs.next() significa ter um contato correspondente ao nome pesquisado
				if (rs.next()) {
					// setar as caixas de texto com o resultado da pesquisa
					txtId.setText(rs.getString(1));
					txtFone.setText(rs.getString(3));
					txtEmail.setText(rs.getString(4));
					// habilitar botoes (alterar e excluir)
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Contato inexistente");
					txtFone.requestFocus();
					// setar campos e botoes (UX)
					txtFone.setText(null);
					txtEmail.setText(null);
					btnCreate.setEnabled(true);
					btnRead.setEnabled(false);

				}
				// fechar a conexÃ£o
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Metodo responsavel pelo cadastro de um novo contato
	 */
	void adicionarContato() {
		// validaÃ§Ã£o de campos obrigatorios
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o fone");
			txtFone.requestFocus();
		} else {
			// System.out.println("teste adicionar");
			String create = "insert into contatos (nome,fone,email) values (?,?,?)";
			try {
				// Abrir a conexao
				Connection con = dao.conectar();
				// Preparar a query (substituição de parametros)
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				// Executar a query e confirmar a inserção no banco
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Contato adicionado.");
					limpar();
				}

				// Encerrar a conexÃ£o
				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	/**
	 * Método Responsavel por alterar informaçoes do contato
	 */

	private void alterarContato() {

		// Validaçao
		if (txtNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Nome do Contato");
			txtNome.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite o Numero do Telefone");
			txtFone.requestFocus();
		} else {

			// Lógica Principal
			String update = "update contatos set nome = ?, fone = ?, email = ? where id = ?";

			try {
				// Abrir a conexao
				Connection con = dao.conectar();
				// Preparar a query (substituição de parametros)
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtNome.getText());
				pst.setString(2, txtFone.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtId.getText());
				// Executar a query e atualizar as informaçoes no banco
				int confirma = pst.executeUpdate();
				// System.out.println(confirma);
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Informações do Contato Atualizados com Sucesso.");
					limpar();
				}

				// Encerrar a conexão
				con.close();
			} catch (Exception e) {

			}
		}
	}

	/**
	 * Método Responsavel por deletar informaçoes do contato
	 */

	private void deleteByID() {

		// Validação
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Exclusão deste contato?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION)
			;
		String delete = "delete from contatos where id = ?";
		try {
			// abrir a conexão
			Connection con = dao.conectar();
			// preparar a query
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, txtId.getText());
			// executar o comando sql e confirmar a exclusão
			int confirmaExcluir = pst.executeUpdate();
			if (confirmaExcluir == 1) {
				limpar();
				JOptionPane.showMessageDialog(null, "Contato excluido com sucesso");
			}
			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * Metodo usado para limpar os campos
	 */
	private void limpar() {
		txtId.setText(null);
		txtNome.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtNome.requestFocus();
		btnCreate.setEnabled(false);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnRead.setEnabled(true);
	}

}// Fim do codigo
