package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtCliente;
	private JTextField txtNomeCliente;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtFone;
	private JButton btnCreate;
	private JButton btnUpdate_1;
	private JButton btnDelete;
	private JButton btnLimpar;
	private JButton btnBuscar;
	private JButton btnCep;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox<Object> cboUf;
	private JTextField txtIDC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/iconinfo.png")));
		setModal(true);
		setTitle("VIA Motors - Clientes");
		setBounds(100, 100, 900, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.window);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 62, 793, 111);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, ""},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Cliente", "Endere\u00E7o", "Telefone", "E-mail", "CPF", "ID"
			}
		));
		scrollPane.setViewportView(table);

		JLabel lblCliente = new JLabel("Cliente ");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 15));
		lblCliente.setBounds(39, 22, 61, 14);
		contentPanel.add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890 ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarCliente();

			}
		});
		txtCliente.setBounds(110, 21, 322, 20);
		contentPanel.add(txtCliente);
		txtCliente.setColumns(10);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Clientes.class.getResource("/img/btnSeach.png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnBuscar.setToolTipText("Buscar Cliente");
		btnBuscar.setContentAreaFilled(false);
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBounds(442, 180, 32, 32);
		contentPanel.add(btnBuscar);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNome.setBounds(39, 198, 46, 14);
		contentPanel.add(lblNome);

		txtNomeCliente = new JTextField();
		txtNomeCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890 ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtNomeCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(79, 196, 304, 20);
		contentPanel.add(txtNomeCliente);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCpf.setBounds(494, 195, 33, 14);
		contentPanel.add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCpf.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCpf.setColumns(10);
		txtCpf.setBounds(516, 192, 147, 20);
		contentPanel.add(txtCpf);

		JLabel lblCep = new JLabel("Cep");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCep.setBounds(673, 194, 46, 14);
		contentPanel.add(lblCep);

		txtCep = new JTextField();
		txtCep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCep.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCep.setColumns(10);
		txtCep.setBounds(698, 191, 86, 20);
		contentPanel.add(txtCep);

		btnCep = new JButton("");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarCep();
			}
		});
		btnCep.setIcon(new ImageIcon(Clientes.class.getResource("/img/btnSeach.png")));
		btnCep.setContentAreaFilled(false);
		btnCep.setBorderPainted(false);
		btnCep.setBounds(789, 180, 32, 32);
		contentPanel.add(btnCep);

		JLabel lblEndereco = new JLabel("Endereço");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEndereco.setBounds(39, 239, 46, 14);
		contentPanel.add(lblEndereco);

		txtEndereco = new JTextField();
		txtEndereco.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890@._ ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(98, 236, 240, 20);
		contentPanel.add(txtEndereco);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEmail.setBounds(39, 269, 46, 14);
		contentPanel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890@._";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEmail.setColumns(10);
		txtEmail.setBounds(98, 267, 210, 20);
		contentPanel.add(txtEmail);

		JLabel lblFone = new JLabel("Telefone");
		lblFone.setFont(new Font("Arial", Font.PLAIN, 11));
		lblFone.setBounds(395, 273, 46, 14);
		contentPanel.add(lblFone);

		txtFone = new JTextField();
		txtFone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtFone.setFont(new Font("Arial", Font.PLAIN, 11));
		txtFone.setColumns(10);
		txtFone.setBounds(453, 270, 108, 20);
		contentPanel.add(txtFone);

		btnCreate = new JButton("");
		btnCreate.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCreate.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarCliente();
			}
		});
		btnCreate.setToolTipText("Adicionar Cliente");
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.setBounds(579, 285, 64, 64);
		contentPanel.add(btnCreate);

		btnUpdate_1 = new JButton("");
		btnUpdate_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnUpdate_1.setIcon(new ImageIcon(Clientes.class.getResource("/img/update.png")));
		btnUpdate_1.setEnabled(false);
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnUpdate_1.setToolTipText("Atualizar Cliente");
		btnUpdate_1.setContentAreaFilled(false);
		btnUpdate_1.setBorderPainted(false);
		btnUpdate_1.setBounds(658, 285, 64, 64);
		contentPanel.add(btnUpdate_1);

		btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnDelete.setEnabled(false);
		btnDelete.setToolTipText("Remover Cliente");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(735, 285, 64, 64);
		contentPanel.add(btnDelete);

		btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Clientes.class.getResource("/img/eraser.png")));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setToolTipText("Botão Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setBounds(810, 286, 64, 64);
		contentPanel.add(btnLimpar);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBairro.setBounds(395, 243, 46, 14);
		contentPanel.add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		txtBairro.setColumns(10);
		txtBairro.setBounds(453, 241, 147, 20);
		contentPanel.add(txtBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCidade.setBounds(610, 243, 46, 14);
		contentPanel.add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCidade.setColumns(10);
		txtCidade.setBounds(658, 240, 72, 20);
		contentPanel.add(txtCidade);

		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUf.setBounds(740, 240, 20, 14);
		contentPanel.add(lblUf);

		cboUf = new JComboBox<Object>();
		cboUf.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setToolTipText("Coloque o Estado");
		cboUf.setFont(new Font("Arial", Font.PLAIN, 11));
		cboUf.setBounds(761, 235, 60, 22);
		contentPanel.add(cboUf);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		RestrictedTextField Nome = new RestrictedTextField(txtCliente);
		Nome.setAcceptSpace(true);
		Nome.setLimit(50);

		RestrictedTextField NomeCliente = new RestrictedTextField(txtNomeCliente);
		NomeCliente.setLimit(50);

		RestrictedTextField Endereco = new RestrictedTextField(txtEndereco);
		Endereco.setLimit(50);

		RestrictedTextField CEP = new RestrictedTextField(txtCep);
		CEP.setLimit(10);

		RestrictedTextField Bairro = new RestrictedTextField(txtBairro);
		Bairro.setLimit(50);

		RestrictedTextField Cidade = new RestrictedTextField(txtCidade);
		Cidade.setLimit(50);

		RestrictedTextField Whatsapp = new RestrictedTextField(txtFone);
		Whatsapp.setLimit(15);

		RestrictedTextField Email = new RestrictedTextField(txtEmail);
		Email.setLimit(50);

		RestrictedTextField CPF = new RestrictedTextField(txtCpf);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Arial", Font.PLAIN, 11));
		lblID.setBounds(386, 198, 20, 14);
		contentPanel.add(lblID);
		
		txtIDC = new JTextField();
		txtIDC.setBounds(400, 192, 32, 20);
		contentPanel.add(txtIDC);
		txtIDC.setColumns(10);
		CPF.setLimit(12);

	}

	DAO dao = new DAO();

	private void pesquisarCliente() {

		String read2 = "select nomecli as Cliente, endcli as Endereço, fonecli as Telefone, emailcli as Email, cpfcli as CPF, idcli as ID from tbclientes where nomecli like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtCliente.getText() + "%");
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	

	private void pesquisar() {

		if (txtIDC.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o ID");
			txtIDC.requestFocus();
		} else {
			String read = "select * from tbclientes where idcli = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtIDC.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					txtNomeCliente.setText(rs.getString(3));
					txtEndereco.setText(rs.getString(4));
					txtCep.setText(rs.getString(5));
					txtBairro.setText(rs.getString(6));
					txtCidade.setText(rs.getString(7));
					cboUf.setSelectedItem(rs.getString(8));
					txtFone.setText(rs.getString(9));
					txtEmail.setText(rs.getString(10));
					txtCpf.setText(rs.getString(11));
					txtIDC.setText(rs.getString(1));

					
					btnUpdate_1.setEnabled(true);
					btnDelete.setEnabled(true);
					btnBuscar.setEnabled(false);
					btnCep.setEnabled(true);
					btnLimpar.setEnabled(true);

					
					btnCreate.setEnabled(false);

					
					txtNomeCliente.setEnabled(true);
					txtCpf.setEnabled(true);
					txtNomeCliente.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setEnabled(true);
					txtFone.setEnabled(true);
					txtEmail.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
					
					btnCreate.setEnabled(true);
					btnBuscar.setEnabled(false);
					btnCep.setEnabled(true);
					txtCpf.setEnabled(true);
					txtNomeCliente.setEnabled(true);
					txtCep.setEnabled(true);
					txtEndereco.setEnabled(true);
					txtBairro.setEnabled(true);
					txtCidade.setEnabled(true);
					cboUf.setEnabled(true);
					txtFone.setEnabled(true);
					txtEmail.setEnabled(true);
					txtNomeCliente.requestFocus();
					btnCep.setEnabled(true);

				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} 

	public void adicionarCliente() {

		if (txtNomeCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do Cliente");
			txtNomeCliente.requestFocus();
		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CPF");
			txtCpf.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o CEP");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o endereco");
			txtEndereco.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a cidade");
			txtCidade.requestFocus();
		} else if (cboUf.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Selecione o estado");
			cboUf.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o e-mail do cliente");
			txtEmail.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o numero");
			txtFone.requestFocus();
		} else {

			String create = "insert into tbclientes (nomecli, endcli, cepcli, bairrocli, cidadecli, ufcli, fonecli,cpfcli,emailcli) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtNomeCliente.getText());
				pst.setString(2, txtEndereco.getText());
				pst.setString(3, txtCep.getText());
				pst.setString(4, txtBairro.getText());
				pst.setString(5, txtCidade.getText());
				pst.setString(6, cboUf.getSelectedItem().toString());
				pst.setString(7, txtFone.getText());
				pst.setString(8, txtCpf.getText());
				pst.setString(9, txtEmail.getText());

				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
					limpar();
					con.close();
				}

			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null,
						"CPF Ou Nome duplicado.\n " + "Email o já Exista.\nEscolha outro email.");
				limpar();

			} catch (Exception e2) {
				System.out.println(e2);

			}
		}
	}

	public void atualizar() {

	
		if (txtNomeCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira O Nome Ou CPF");
			txtNomeCliente.requestFocus();
		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira O CPF Ou Nome");
			txtCpf.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Cep");
			txtCep.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Endereço");
			txtEndereco.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Bairro");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira A Cidade");
			txtCidade.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Telefone");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Email");
			txtEmail.requestFocus();
		} else {

			
			String update = "update tbclientes set nomecli = ?, endcli = ?, cepcli = ?, bairrocli = ?, cidadecli = ?, ufcli = ?, fonecli = ?, cpfcli = ?, emailcli  = ? where idcli = ?";

			try {
				
				Connection con = dao.conectar();
				
				PreparedStatement pst = con.prepareStatement(update);

				pst.setString(1, txtNomeCliente.getText());
				pst.setString(2, txtEndereco.getText());
				pst.setString(3, txtCep.getText());
				pst.setString(4, txtBairro.getText());
				pst.setString(5, txtCidade.getText());
				pst.setString(6, cboUf.getSelectedItem().toString());
				pst.setString(7, txtFone.getText());
				pst.setString(8, txtCpf.getText());
				pst.setString(9, txtEmail.getText());
				pst.setString(10, txtIDC.getText());

				
				int confirma = pst.executeUpdate();
			
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente Atualizado.");
					limpar();
					btnCreate.setEnabled(false);
					btnUpdate_1.setEnabled(false);
					btnDelete.setEnabled(false);
				} else {
					
					JOptionPane.showMessageDialog(null, "Cliente Não Atualizado");
					limpar();
				}

				
				con.close();
			} catch (java.sql.SQLIntegrityConstraintViolationException e1) {
				JOptionPane.showMessageDialog(null,
						"CPF Ou Nome duplicado.\n " + "Email o já Exista.\nEscolha outro email.");
				limpar();

			} catch (Exception e2) {
				System.out.println(e2);

			}
		}
	}

	public void delete() {

	
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a Exclusao deste Cliente?", "Atençao",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {

			String delete = "delete from tbclientes where nomecli = ?";
			try {
			
				Connection con = dao.conectar();
			
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtNomeCliente.getText());
				
				int confirmaExcluir = pst.executeUpdate();
				if (confirmaExcluir == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso");
					btnUpdate_1.setEnabled(false);
					btnDelete.setEnabled(false);
				}
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
				JOptionPane.showMessageDialog(null, "Cliente Nao Foi Excluido");
				limpar();
			}

		}

	}

	private void buscarCep() {
		String logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					txtBairro.setText(element.getText());
				}
				if (element.getQualifiedName().equals("uf")) {
					cboUf.setSelectedItem(element.getText());
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tipoLogradouro = element.getText();
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
					} else {
						JOptionPane.showMessageDialog(null, "CEP não encontrado");
					}
				}
			}
			txtEndereco.setText(tipoLogradouro + " " + logradouro);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void limpar() {
		txtCliente.setText(null);
		txtNomeCliente.setText(null);
		txtCpf.setText(null);
		txtCep.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem("");
		txtFone.setText(null);
		txtEmail.setText(null);
		txtIDC.setText(null);
		btnBuscar.setEnabled(true);
		btnCreate.setEnabled(true);
		
		((DefaultTableModel) table.getModel()).setRowCount(0);

	}
}
