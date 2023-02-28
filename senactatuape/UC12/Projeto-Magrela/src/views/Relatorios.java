package views;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JDialog;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import models.DAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;

public class Relatorios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios dialog = new Relatorios();
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
	public Relatorios() {
		setTitle("VIA Motors - Relatorios");
		getContentPane().setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/img/iconrelatorios.png")));
		setModal(true);
		setBounds(100, 100, 360, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JButton btnRelatorioClientes = new JButton("");
		btnRelatorioClientes.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRelatorioClientes.setBorderPainted(false);
		btnRelatorioClientes.setFocusPainted(false);
		btnRelatorioClientes.setBackground(SystemColor.window);
		btnRelatorioClientes.setIcon(new ImageIcon(Relatorios.class.getResource("/img/btnUsuarios.png")));
		btnRelatorioClientes.setToolTipText("Clientes");
		btnRelatorioClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnRelatorioClientes.setBounds(24, 31, 128, 128);
		getContentPane().add(btnRelatorioClientes);

		JButton btnRelatorioOS = new JButton("");
		btnRelatorioOS.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRelatorioOS.setBorderPainted(false);
		btnRelatorioOS.setIcon(new ImageIcon(Relatorios.class.getResource("/img/btnOS.png")));
		btnRelatorioOS.setBackground(SystemColor.window);
		btnRelatorioOS.setToolTipText("Servicos");
		btnRelatorioOS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioOS();
			}
		});
		btnRelatorioOS.setFocusPainted(false);
		btnRelatorioOS.setBounds(101, 322, 128, 128);
		getContentPane().add(btnRelatorioOS);

		JButton btnRelatorioUsuarios = new JButton("");
		btnRelatorioUsuarios.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRelatorioUsuarios.setBorderPainted(false);
		btnRelatorioUsuarios.setIcon(new ImageIcon(Relatorios.class.getResource("/img/btnRelatorios.png")));
		btnRelatorioUsuarios.setBackground(SystemColor.window);
		btnRelatorioUsuarios.setToolTipText("Usuarios");
		btnRelatorioUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioUsuarios();
			}
		});
		btnRelatorioUsuarios.setFocusPainted(false);
		btnRelatorioUsuarios.setBounds(186, 31, 128, 128);
		getContentPane().add(btnRelatorioUsuarios);

		JButton btnServicoP = new JButton("");
		btnServicoP.setFocusPainted(false);
		btnServicoP.setIcon(new ImageIcon(Relatorios.class.getResource("/img/btnServicosPendentes.png")));
		btnServicoP.setBorderPainted(false);
		btnServicoP.setFont(new Font("Arial", Font.PLAIN, 11));
		btnServicoP.setToolTipText("Servicos Pendentes");
		btnServicoP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioPendente();
			}
		});
		btnServicoP.setBounds(24, 184, 128, 128);
		getContentPane().add(btnServicoP);

		JButton btnServicoE = new JButton("");
		btnServicoE.setFocusPainted(false);
		btnServicoE.setIcon(new ImageIcon(Relatorios.class.getResource("/img/btnServicosEntregues.png")));
		btnServicoE.setBorderPainted(false);
		btnServicoE.setFont(new Font("Arial", Font.PLAIN, 11));
		btnServicoE.setToolTipText("Servicos Entregue");
		btnServicoE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioEntregue();
			}
		});
		btnServicoE.setBounds(186, 184, 128, 128);
		getContentPane().add(btnServicoE);

	}

	DAO dao = new DAO();

	private void relatorioClientes() {

		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		try {

			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Clientes cadastrados"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(9);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Endereço"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CEP"));
			PdfPCell col4 = new PdfPCell(new Paragraph("BAIRRO"));
			PdfPCell col5 = new PdfPCell(new Paragraph("CIDADE"));
			PdfPCell col6 = new PdfPCell(new Paragraph("UF"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col8 = new PdfPCell(new Paragraph("Email"));
			PdfPCell col9 = new PdfPCell(new Paragraph("CPF"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			tabela.addCell(col8);
			tabela.addCell(col9);

			String relClientes = "select nomecli,endcli,cepcli,bairrocli,cidadecli,ufcli,fonecli,emailcli,cpfcli from tbclientes";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relClientes);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
					tabela.addCell(rs.getString(7));
					tabela.addCell(rs.getString(8));
					tabela.addCell(rs.getString(9));
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
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioUsuarios() {

		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		try {

			PdfWriter.getInstance(document, new FileOutputStream("usuarios.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Relatório de Usuários"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("ID"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Usuario"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Login"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Perfil"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			String usuarios = "select iduser, usuario, fone, login,perfil from tbusuarios;";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(usuarios);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
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
			Desktop.getDesktop().open(new File("usuarios.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioPendente() {

		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		try {

			PdfWriter.getInstance(document, new FileOutputStream("Relatorios_Pendentes.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Relatório de OS Pendentes"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome_Cliente"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data_Entrada"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Veiculo"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Situacao"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			String usuarios = "select os, cliente, dataent, veiculo,situacao from tbos where situacao = 'Servico Pendente';";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(usuarios);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
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
			Desktop.getDesktop().open(new File("Relatorios_Pendentes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioEntregue() {

		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		try {

			PdfWriter.getInstance(document, new FileOutputStream("Relatorios_Entregues.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Relatório de OS Entregues"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(5);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome_Cliente"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data_Entrada"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Veiculo"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Situacao"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			String usuarios = "select os, cliente, dataent, veiculo,situacao from tbos where situacao = 'Servico Entregue';";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(usuarios);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
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
			Desktop.getDesktop().open(new File("Relatorios_Entregues.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void relatorioOS() {

		Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);

		try {

			PdfWriter.getInstance(document, new FileOutputStream("OS.pdf"));
			document.open();

			Date data = new Date();
			DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);

			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("OS cadastradas"));
			document.add(new Paragraph(" "));

			PdfPTable tabela = new PdfPTable(10);
			PdfPCell col1 = new PdfPCell(new Paragraph("OS"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data Entrada"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Data Estimativa"));
			PdfPCell col6 = new PdfPCell(new Paragraph("Veiculo"));
			PdfPCell col7 = new PdfPCell(new Paragraph("Problema"));
			PdfPCell col8 = new PdfPCell(new Paragraph("Situacao"));
			PdfPCell col9 = new PdfPCell(new Paragraph("Mecanico"));
			PdfPCell col10 = new PdfPCell(new Paragraph("Valor"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			tabela.addCell(col8);
			tabela.addCell(col9);
			tabela.addCell(col10);

			String relatorioOS = "select os,cliente,telefone,dataent,datafin,veiculo,problema,situacao,mecanico, tpagamento from tbos";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relatorioOS);
				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
					tabela.addCell(rs.getString(5));
					tabela.addCell(rs.getString(6));
					tabela.addCell(rs.getString(7));
					tabela.addCell(rs.getString(8));
					tabela.addCell(rs.getString(9));
					tabela.addCell(rs.getString(10));
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

}
