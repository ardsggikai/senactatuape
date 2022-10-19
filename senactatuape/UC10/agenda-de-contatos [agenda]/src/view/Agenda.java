package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

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

		JButton btnCreate = new JButton("");
		btnCreate.setToolTipText("Adicionar Contato");
		btnCreate.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnCreate.png")));
		btnCreate.setBorderPainted(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCreate.setBounds(69, 176, 64, 64);
		contentPane.add(btnCreate);

		JButton btnDelete = new JButton("");
		btnDelete.setToolTipText("Deletar Contato");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnDelete.png")));
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(164, 175, 64, 64);
		contentPane.add(btnDelete);

		JButton btnUpdate = new JButton("");
		btnUpdate.setToolTipText("Atualizar Lista de Contato");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/btnUpdate.png")));
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(271, 176, 64, 64);
		contentPane.add(btnUpdate);

		JButton btnRead = new JButton("");
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
	}// Fim Do Construtor

	// Criar um objeto para acessar o método conectar() da classe DAO
	DAO dao = new DAO();
	private JLabel lblStatus;

	/**
	 * Método responsavel por verificar o status da conexão com o banco
	 */
	private void status() {
		// System.out.println("Teste - Janela Ativada");
		// uso da classe connection (JDBC) para estabelecer a conexão
		try {
			Connection con = dao.conectar();
			if (con == null) {
				System.out.println("Erro de Conexão");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dboff.png")));
			} else {
				System.out.println("Banco Conectado!");
				lblStatus.setIcon(new ImageIcon(Agenda.class.getResource("/img/dbon.png")));
			}
			// Nunca esquecer de encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	} // Fim do Status

	/**
	 * Método responsável pela pesquisa (select)
	 */

	private void pesquisarContato() {
		// System.out.println("Teste Pesquisar"); (pra testar)
		// ? é um parâmetro a ser substituido
		String read = "select * from contatos where nome = ?";
		try {

			// Estabelecer a conexão ("abrir a porta da geladeira")
			Connection con = dao.conectar();
			// Preparar o código sql para execução
			PreparedStatement pst = con.prepareStatement(read);
			// A Linha abaixo substituir o ? pelo conteúdo da caixa de texto txtNome, o 1
			// faz referência a interrogação
			pst.setString(1, txtNome.getText());
			// Obter os dados do contato (resultado)
			ResultSet rs = pst.executeQuery();
			// Verificar se existe um contato cadastrado
			// rs.next() significa ter um contato correspondente ao nome pesquisado
			if (rs.next()) {
               //setar as caixas de texto com o resultado da pesquisa
				txtId.setText(rs.getString(1));
				txtFone.setText(rs.getString(3));
				txtEmail.setText(rs.getString(4));
				
				
			} else {
				JOptionPane.showMessageDialog(null, "Contato inexistente");

			}
			//fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}// Fim do codigo
