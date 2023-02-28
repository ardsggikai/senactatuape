package views;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;

public class Telaos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOsNumero;
	private JTextField txtNomeCliente;
	private JTextField txtFone;
	private JTextField txtEmail;
	private JTextField txtVeiculo;
	private JTextField txtKm;
	private JComboBox<Object> cboStatus;
	private JTextField txtProblema;
	private JDateChooser dateEntrada;
	private JDateChooser dateFinalizada;
	private JButton btnCadastrarV;
	private JButton btnBuscarVeiculo;
	private JComboBox<Object> cboMecanico;
	private JTextField txtID;
	private JButton btnAlterar;
	private JTextField txtTotalProdutos;
	private JTextField txtTotalServicos;
	private JTextField txtDescontoR;
	private JTextField txtAdiantamento;
	private JTextField txtTotalPagar;
	private JButton btnAlterar_1;
	private JComboBox<Object> cboModoP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Telaos dialog = new Telaos();
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
	public Telaos() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(Telaos.class.getResource("/img/iconOS.png")));
		getContentPane().setBackground(Color.WHITE);
		setTitle("VIA Motors - Ordem de Serviço");
		setBounds(100, 100, 823, 610);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblOSNumero = new JLabel("O.S Número:");
		lblOSNumero.setFont(new Font("Arial", Font.BOLD, 12));
		lblOSNumero.setBounds(63, 19, 93, 14);
		getContentPane().add(lblOSNumero);

		JLabel lblDataEntrada = new JLabel("Data Entrada:");
		lblDataEntrada.setFont(new Font("Arial", Font.BOLD, 12));
		lblDataEntrada.setBounds(329, 25, 97, 14);
		getContentPane().add(lblDataEntrada);

		JLabel lblDataFinalizao = new JLabel("Data Finalização:");
		lblDataFinalizao.setFont(new Font("Arial", Font.BOLD, 12));
		lblDataFinalizao.setBounds(612, 25, 108, 14);
		getContentPane().add(lblDataFinalizao);

		txtOsNumero = new JTextField();
		txtOsNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtOsNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtOsNumero.setFont(new Font("Arial", Font.PLAIN, 15));
		txtOsNumero.setBounds(34, 37, 150, 26);
		getContentPane().add(txtOsNumero);
		txtOsNumero.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(473, 104, 324, 421);
		getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 11, 324, 399);
		panel.add(panel_1);

		JLabel lblTotalOs = new JLabel("TOTAL O.S.");
		lblTotalOs.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalOs.setFont(new Font("Myanmar Text", Font.BOLD, 25));
		lblTotalOs.setBounds(87, 11, 178, 48);
		panel_1.add(lblTotalOs);

		JLabel lblTotalProdutos = new JLabel("Total Produtos:");
		lblTotalProdutos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalProdutos.setBounds(102, 58, 133, 14);
		panel_1.add(lblTotalProdutos);

		txtTotalProdutos = new JTextField();
		txtTotalProdutos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalProdutos.setFont(new Font("Arial", Font.ITALIC, 14));
		txtTotalProdutos.setColumns(10);
		txtTotalProdutos.setAlignmentX(1.0f);
		txtTotalProdutos.setBounds(71, 79, 194, 20);
		panel_1.add(txtTotalProdutos);

		JLabel lblTotalServicos = new JLabel("Total Serviços:");
		lblTotalServicos.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalServicos.setBounds(102, 110, 133, 14);
		panel_1.add(lblTotalServicos);

		txtTotalServicos = new JTextField();
		txtTotalServicos.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalServicos.setFont(new Font("Arial", Font.ITALIC, 14));
		txtTotalServicos.setColumns(10);
		txtTotalServicos.setBounds(71, 131, 194, 20);
		panel_1.add(txtTotalServicos);

		JLabel lblDescontoR = new JLabel("Desconto R$");
		lblDescontoR.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescontoR.setBounds(116, 161, 133, 14);
		panel_1.add(lblDescontoR);

		txtDescontoR = new JTextField();
		txtDescontoR.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescontoR.setFont(new Font("Arial", Font.ITALIC, 14));
		txtDescontoR.setColumns(10);
		txtDescontoR.setBounds(102, 186, 133, 20);
		panel_1.add(txtDescontoR);

		JLabel lblAdiantamento = new JLabel("Adiantamento:");
		lblAdiantamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdiantamento.setBounds(102, 217, 133, 14);
		panel_1.add(lblAdiantamento);

		txtAdiantamento = new JTextField();
		txtAdiantamento.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdiantamento.setFont(new Font("Arial", Font.ITALIC, 14));
		txtAdiantamento.setColumns(10);
		txtAdiantamento.setBounds(71, 238, 194, 20);
		panel_1.add(txtAdiantamento);

		JLabel lblTotalPagar = new JLabel("Total Pagar:");
		lblTotalPagar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTotalPagar.setBounds(107, 269, 123, 20);
		panel_1.add(lblTotalPagar);

		txtTotalPagar = new JTextField();
		txtTotalPagar.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalPagar.setFont(new Font("Arial", Font.ITALIC, 18));
		txtTotalPagar.setColumns(10);
		txtTotalPagar.setBounds(71, 289, 194, 28);
		panel_1.add(txtTotalPagar);

		cboModoP = new JComboBox<Object>();
		cboModoP.setModel(new DefaultComboBoxModel<Object>(
				new String[] { "", "Dinheiro", "Cartão Credito", "Cartão Debito", "PIX" }));
		cboModoP.setBounds(116, 328, 110, 22);
		panel_1.add(cboModoP);

		btnAlterar_1 = new JButton("Alterar Dados");
		btnAlterar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarOrcamento();
			}
		});
		btnAlterar_1.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAlterar_1.setEnabled(false);
		btnAlterar_1.setBounds(102, 365, 133, 23);
		panel_1.add(btnAlterar_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 104, 453, 421);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

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
		txtNomeCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(10, 40, 324, 20);
		panel_2.add(txtNomeCliente);

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
		txtFone.setFont(new Font("Arial", Font.PLAIN, 14));
		txtFone.setColumns(10);
		txtFone.setBounds(10, 91, 103, 20);
		panel_2.add(txtFone);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefone.setBounds(10, 71, 88, 14);
		panel_2.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(123, 71, 88, 14);
		panel_2.add(lblEmail);

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
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(123, 91, 211, 20);
		panel_2.add(txtEmail);

		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Myanmar Text", Font.BOLD, 23));
		lblCliente.setBounds(24, 11, 178, 35);
		panel_2.add(lblCliente);

		JLabel lblVeculo = new JLabel("Veículo:");
		lblVeculo.setFont(new Font("Myanmar Text", Font.BOLD, 23));
		lblVeculo.setBounds(24, 161, 178, 35);
		panel_2.add(lblVeculo);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblModelo.setBounds(10, 189, 88, 14);
		panel_2.add(lblModelo);

		txtVeiculo = new JTextField();
		txtVeiculo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890 ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtVeiculo.setFont(new Font("Arial", Font.PLAIN, 14));
		txtVeiculo.setColumns(10);
		txtVeiculo.setBounds(10, 214, 324, 20);
		panel_2.add(txtVeiculo);

		txtKm = new JTextField();
		txtKm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0987654321-";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtKm.setFont(new Font("Arial", Font.PLAIN, 14));
		txtKm.setColumns(10);
		txtKm.setBounds(355, 214, 88, 20);
		panel_2.add(txtKm);

		JLabel lblKm = new JLabel("KM:");
		lblKm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKm.setBounds(355, 189, 88, 14);
		panel_2.add(lblKm);

		btnCadastrarV = new JButton("Cadastrar Veículo");
		btnCadastrarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadVeiculo();
			}
		});
		btnCadastrarV.setBorder(new CompoundBorder());
		btnCadastrarV.setFont(new Font("Arial", Font.BOLD, 11));
		btnCadastrarV.setBounds(10, 289, 140, 23);
		panel_2.add(btnCadastrarV);

		btnBuscarVeiculo = new JButton("Buscar Veículo");
		btnBuscarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarVeiculo();
			}
		});
		btnBuscarVeiculo.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscarVeiculo.setBorder(new CompoundBorder());
		btnBuscarVeiculo.setBounds(303, 289, 140, 23);
		panel_2.add(btnBuscarVeiculo);

		JButton btnBuscarCliente = new JButton("Buscar Cliente:");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
		});
		btnBuscarCliente.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscarCliente.setBorder(new CompoundBorder());
		btnBuscarCliente.setBounds(10, 122, 133, 23);
		panel_2.add(btnBuscarCliente);

		cboStatus = new JComboBox<Object>();
		cboStatus.setToolTipText("Escolha o Status Atual\r\n");
		cboStatus.setFont(new Font("Arial", Font.PLAIN, 11));
		cboStatus.setModel(new DefaultComboBoxModel<Object>(new String[] { "", "Servico Pendente", "Servico Entregue",
				"Esperando Resposta Do Cliente", "Orçamento Recusado", "Orçamento Aprovado" }));
		cboStatus.setBounds(10, 351, 433, 22);
		panel_2.add(cboStatus);

		JLabel lblStatus = new JLabel("Status Atual:");
		lblStatus.setFont(new Font("Myanmar Text", Font.BOLD, 23));
		lblStatus.setBounds(10, 323, 178, 29);
		panel_2.add(lblStatus);

		JLabel lblProblema = new JLabel("Problema");
		lblProblema.setBounds(10, 238, 75, 14);
		panel_2.add(lblProblema);

		txtProblema = new JTextField();
		txtProblema.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "AaBbcCdDEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz1234567890 ";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtProblema.setFont(new Font("Arial", Font.PLAIN, 11));
		txtProblema.setBounds(10, 258, 433, 20);
		panel_2.add(txtProblema);
		txtProblema.setColumns(10);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setIcon(new ImageIcon(Telaos.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Botão Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.setBounds(379, 373, 64, 64);
		panel_2.add(btnLimpar);

		cboMecanico = new JComboBox<Object>();
		cboMecanico.setToolTipText("Escolha o Mecanico");
		cboMecanico.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "", "TINHAO", "FULANO", "PEREIRAO", "JOAQUIM" }));
		cboMecanico.setFont(new Font("Arial", Font.PLAIN, 11));
		cboMecanico.setBounds(10, 384, 140, 22);
		panel_2.add(cboMecanico);

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Arial", Font.PLAIN, 11));
		lblId.setBounds(339, 44, 28, 14);
		panel_2.add(lblId);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(355, 41, 86, 20);
		panel_2.add(txtID);
		txtID.setColumns(10);

		btnAlterar = new JButton("Alterar Dados");
		btnAlterar.setEnabled(false);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarOs();
			}
		});
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAlterar.setBounds(160, 289, 133, 23);
		panel_2.add(btnAlterar);

		dateEntrada = new JDateChooser();
		dateEntrada.setEnabled(false);
		dateEntrada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		dateEntrada.setBounds(302, 43, 150, 20);
		getContentPane().add(dateEntrada);

		dateFinalizada = new JDateChooser();
		dateFinalizada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String caracteres = "0987654321.";
				if (!caracteres.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		dateFinalizada.setBounds(591, 43, 150, 20);
		getContentPane().add(dateFinalizada);

		RestrictedTextField os = new RestrictedTextField(txtOsNumero);
		os.setLimit(250);

		RestrictedTextField NomeCliente = new RestrictedTextField(txtNomeCliente);
		NomeCliente.setLimit(45);

		RestrictedTextField fone = new RestrictedTextField(txtFone);
		fone.setLimit(14);

		RestrictedTextField Email = new RestrictedTextField(txtEmail);
		Email.setLimit(40);

		RestrictedTextField Modelo = new RestrictedTextField(txtVeiculo);
		Modelo.setLimit(30);

		RestrictedTextField km = new RestrictedTextField(txtKm);
		km.setLimit(5);

		RestrictedTextField problema = new RestrictedTextField(txtProblema);
		problema.setLimit(40);

		getRootPane().setDefaultButton(btnBuscarCliente);

		JButton btnImprimirOS = new JButton("Imprimir OS");
		btnImprimirOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imprimirOS();
			}
		});
		btnImprimirOS.setFont(new Font("Arial", Font.PLAIN, 11));
		btnImprimirOS.setBounds(171, 375, 116, 41);
		panel_2.add(btnImprimirOS);

	}

	DAO dao = new DAO();

	private void pesquisarCliente() {

		if (txtNomeCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o Nome do Cliente");
			txtNomeCliente.requestFocus();
		} else {
			String read = "select * from tbclientes where nomecli = ?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read);
				pst.setString(1, txtNomeCliente.getText());
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {

					txtNomeCliente.setText(rs.getString(3));
					txtFone.setText(rs.getString(9));
					txtEmail.setText(rs.getString(10));
					txtID.setText(rs.getString(1));

					txtNomeCliente.setEnabled(true);
					txtNomeCliente.setEnabled(true);
					txtFone.setEnabled(true);
					txtEmail.setEnabled(true);

				} else {
					JOptionPane.showMessageDialog(null, "Cliente não cadastrado");
				

					txtNomeCliente.setEnabled(true);
					txtFone.setEnabled(true);
					txtEmail.setEnabled(true);
					txtNomeCliente.requestFocus();

				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	} 

	private void cadVeiculo() {

		if (dateFinalizada.getDate() == null) {
			JOptionPane.showMessageDialog(null, "Preencha Data Estimativa para Finalizacao");
			dateFinalizada.requestFocus();
		} else if (txtNomeCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o nome do Cliente");
			txtNomeCliente.requestFocus();
		} else if (txtID.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone");
			txtID.requestFocus();
		} else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o telefone");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira seu e-mail");
			txtEmail.requestFocus();
		} else if (txtVeiculo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o modelo da moto");
			txtVeiculo.requestFocus();
		} else if (txtKm.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira a km da moto");
			txtKm.requestFocus();
		} else if (txtProblema.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Insira o problema da moto");
			txtProblema.requestFocus();
		} else if (cboStatus.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Insira o status");
			cboStatus.requestFocus();
		} else if (cboMecanico.getSelectedItem() == "") {
			JOptionPane.showMessageDialog(null, "Escolha o Mecanico");
			cboMecanico.requestFocus();
		} else {

			String insert = "insert into tbos (datafin,cliente,telefone,email,veiculo,km,problema,situacao,mecanico,idcli)"
					+ "values (?,?,?,?,?,?,?,?,?,?)";

			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(insert);

				SimpleDateFormat formatador = new SimpleDateFormat("yyyyMMdd");
				String dataFormatada = formatador.format(dateFinalizada.getDate());
				pst.setString(1, dataFormatada); // x -> parâmetro do componente dateChooser
				pst.setString(2, txtNomeCliente.getText());
				pst.setString(3, txtFone.getText());
				pst.setString(4, txtEmail.getText());
				pst.setString(5, txtVeiculo.getText());
				pst.setString(6, txtKm.getText());
				pst.setString(7, txtProblema.getText());
				pst.setString(8, cboStatus.getSelectedItem().toString());
				pst.setString(9, cboMecanico.getSelectedItem().toString());
				pst.setString(10, txtID.getText());

				int confirm = pst.executeUpdate();
				if (confirm == 1) {
					JOptionPane.showMessageDialog(null, "OS Cadastrada Com Sucesso");
					limpar();

				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar a OS");

				}
				con.close();
			}

			catch (Exception e2) {
				System.out.println(e2);
				limpar();
			}
		}
	}

	public void buscarVeiculo() {

		String read2 = "select * from tbos where os = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, txtOsNumero.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {

				String setarData = rs.getString(2);
				Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(setarData);
				dateEntrada.setDate(dataFormatada);
				String setarData2 = rs.getString(3);
				dateFinalizada.setDate(null);
				txtNomeCliente.setText(rs.getString(4));
				txtFone.setText(rs.getString(5));
				txtEmail.setText(rs.getString(6));
				txtVeiculo.setText(rs.getString(7));
				txtKm.setText(rs.getString(8));
				txtProblema.setText(rs.getString(9));
				cboStatus.setSelectedItem(rs.getString(10));
				cboMecanico.setSelectedItem(rs.getString(11));
				txtID.setText(rs.getString(12));
				Date dataFechamento = new SimpleDateFormat("yyyy-MM-dd").parse(setarData2);
				dateFinalizada.setDate(dataFechamento);
				txtID.setEnabled(false);

				// habilitar os botoes
				btnAlterar.setEnabled(true);
				btnAlterar_1.setEnabled(true);

			} else {
				JOptionPane.showMessageDialog(null, " Ordem de Serviço nao cadastrada");
				int confirma = JOptionPane.showConfirmDialog(null, "Usuario não encontrado: Deseja cadastrar um novo ?",
						"ATENÇÃO!", JOptionPane.YES_NO_OPTION);
				limpar();
				if (confirma == JOptionPane.YES_OPTION) {
					limpar();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void alterarOs() {

		String read3 = "update tbos set os = ?, datafin = ?, cliente = ?, telefone = ?, email = ?, veiculo = ?, km = ?, problema = ?, situacao = ?, mecanico = ?"
				+ "where os = ?";
		try {

			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setString(1, txtOsNumero.getText());
			SimpleDateFormat alterarDataFec = new SimpleDateFormat("yyyyMMdd");
			String dataFechamento = alterarDataFec.format(dateFinalizada.getDate());
			pst.setString(2, dataFechamento);
			pst.setString(3, txtNomeCliente.getText());
			pst.setString(4, txtFone.getText());
			pst.setString(5, txtEmail.getText());
			pst.setString(6, txtVeiculo.getText());
			pst.setString(7, txtKm.getText());
			pst.setString(8, txtProblema.getText());
			pst.setString(9, cboStatus.getSelectedItem().toString());
			pst.setString(10, cboMecanico.getSelectedItem().toString());
			pst.setString(11, txtOsNumero.getText());

			
			txtOsNumero.setEnabled(true);

			int confirma = pst.executeUpdate();
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Ordem de Serviço alterada com sucesso");
				limpar();
			} else {
				JOptionPane.showMessageDialog(null, "ERRO!!!");
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void alterarOrcamento() {

		String read3 = "update tbos set os = ?,situacao = ?, mecanico = ?, tprodutos = ?, tservicos = ?, desconto = ?, adiantamento = ?, tpagamento = ?, modop = ?"
				+ "where os = ?";
		try {

			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read3);
			pst.setString(1, txtOsNumero.getText());
			pst.setString(2, cboStatus.getSelectedItem().toString());
			pst.setString(3, cboMecanico.getSelectedItem().toString());
			pst.setString(4, txtTotalProdutos.getText());
			pst.setString(5, txtTotalServicos.getText());
			pst.setString(6, txtDescontoR.getText());
			pst.setString(7, txtAdiantamento.getText());
			pst.setString(8, txtTotalPagar.getText());
			pst.setString(9, cboModoP.getSelectedItem().toString());
			pst.setString(10, txtOsNumero.getText());

			int confirma = pst.executeUpdate();
			if (confirma == 1) {
				JOptionPane.showMessageDialog(null, "Ordem de Serviço alterada com sucesso");
				limpar();
			} else {
				JOptionPane.showMessageDialog(null, "ERRO!!!");
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void imprimirOS() {

		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		try {

			PdfWriter.getInstance(document, new FileOutputStream("OS.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("OS Atual"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(9);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data Entrada"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Data Estimativa"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Veiculo"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Problema"));
			PdfPCell col8 = new PdfPCell(new Paragraph("Situacao"));
			PdfPCell col9 = new PdfPCell(new Paragraph("Mecanico"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			tabela.addCell(col8);
			tabela.addCell(col9);

			String imprimirOS = "select * from tbos where os  = ?";

			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(imprimirOS);
				pst.setString(1, txtOsNumero.getText());
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {

					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(7));
					tabela.addCell(rs.getString(9));
					tabela.addCell(rs.getString(10));
					tabela.addCell(rs.getString(11));

				}

			} catch (Exception e) {
				System.out.println(e);
			}

			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			document.close();
		}

		try {
			Desktop.getDesktop().open(new File("OS.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public void limpar() {

		txtOsNumero.setText(null);
		txtID.setText(null);
		txtNomeCliente.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		txtVeiculo.setText(null);
		txtKm.setText(null);
		txtProblema.setText(null);
		txtTotalProdutos.setText(null);
		txtTotalServicos.setText(null);
		txtDescontoR.setText(null);
		txtAdiantamento.setText(null);
		txtTotalPagar.setText(null);
		txtFone.setText(null);
		txtEmail.setText(null);
		cboStatus.setSelectedItem("");
		cboMecanico.setSelectedItem("");
		cboModoP.setSelectedItem("");
		dateFinalizada.setToolTipText(null);
		btnBuscarVeiculo.setEnabled(true);
		btnCadastrarV.setEnabled(true);
		btnAlterar.setEnabled(false);
		dateFinalizada.setDate(null);
		dateEntrada.setDate(null);

	}
}
