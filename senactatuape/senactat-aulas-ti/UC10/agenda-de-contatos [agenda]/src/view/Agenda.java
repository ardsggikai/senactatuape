package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Agenda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
		setResizable(false);
		setTitle("Agenda de Contatos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Agenda.class.getResource("/img/favicon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 290);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalTextPosition(SwingConstants.CENTER);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblId.setBounds(339, 56, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(32, 53, 57, 14);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 11));
		textField.setBounds(375, 54, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 11));
		textField_1.setBounds(91, 51, 180, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFone = new JLabel("Fone");
		lblFone.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFone.setHorizontalAlignment(SwingConstants.CENTER);
		lblFone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFone.setBounds(32, 94, 46, 14);
		contentPane.add(lblFone);
		
		textField_2 = new JTextField();
		textField_2.setBounds(91, 91, 110, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(36, 125, 46, 14);
		contentPane.add(lblEmail);
		
		textField_3 = new JTextField();
		textField_3.setBounds(91, 121, 212, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("");
		btnAdd.setToolTipText("Adicionar Contato");
		btnAdd.setIcon(new ImageIcon(Agenda.class.getResource("/img/create.png")));
		btnAdd.setBorderPainted(false);
		btnAdd.setContentAreaFilled(false);
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAdd.setBounds(69, 176, 64, 64);
		contentPane.add(btnAdd);
		
		JButton btnDelete = new JButton("");
		btnDelete.setToolTipText("Deletar Contato");
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setIcon(new ImageIcon(Agenda.class.getResource("/img/delete.png")));
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(164, 175, 64, 64);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setToolTipText("Atualizar Lista de Contato");
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setIcon(new ImageIcon(Agenda.class.getResource("/img/update.png")));
		btnUpdate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(271, 176, 64, 64);
		contentPane.add(btnUpdate);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar.setToolTipText("Pesquisar Contatos");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setIcon(new ImageIcon(Agenda.class.getResource("/img/pesquisar.png")));
		btnPesquisar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.setBorderPainted(false);
		btnPesquisar.setBounds(266, 33, 64, 64);
		contentPane.add(btnPesquisar);
	}
}
