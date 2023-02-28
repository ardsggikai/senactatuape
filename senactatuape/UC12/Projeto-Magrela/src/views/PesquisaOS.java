package views;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Atxy2k.CustomTextField.RestrictedTextField;
import models.DAO;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PesquisaOS extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtOS;
	private JTable table;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PesquisaOS dialog = new PesquisaOS();
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
	public PesquisaOS() {
		setTitle("VIA Motors - Pesquisas de OS");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PesquisaOS.class.getResource("/img/icoPesquisaOS.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 960, 240);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JLabel lblOS = new JLabel("OS:");
		lblOS.setHorizontalAlignment(SwingConstants.LEFT);
		lblOS.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblOS.setBounds(10, 13, 74, 14);
		getContentPane().add(lblOS);

		txtOS = new JTextField();
		txtOS.setHorizontalAlignment(SwingConstants.LEFT);
		txtOS.setFont(new Font("Arial", Font.PLAIN, 11));
		txtOS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pesquisarOS();
			}
		});
		txtOS.setToolTipText("Colocar Numero da OS");
		txtOS.setColumns(10);
		txtOS.setBounds(80, 11, 189, 20);
		getContentPane().add(txtOS);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setToolTipText("Informações Cruciais");
		scrollPane.setBounds(10, 53, 924, 137);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 11));
		scrollPane.setViewportView(table);

		btnDelete = new JButton("");
		btnDelete.setContentAreaFilled(false);
		btnDelete.setIcon(new ImageIcon(PesquisaOS.class.getResource("/img/btndeleteOS.png")));
		btnDelete.setToolTipText("Botao Para Excluir a OS");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteByOS();
			}
		});
		btnDelete.setFont(new Font("Arial", Font.PLAIN, 11));
		btnDelete.setBounds(902, 13, 32, 32);
		getContentPane().add(btnDelete);

		RestrictedTextField OS = new RestrictedTextField(txtOS);
		OS.setLimit(20);

	}

	DAO dao = new DAO();

	private void pesquisarOS() {

		String read = "select os as Numero_OS, dataent as Entrada, datafin as Prazo, veiculo as Moto, problema as Problema,situacao as Situacao,\r\n"
				+ "mecanico as Mecanico,cliente as Cliente from tbos where os like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtOS.getText() + "%");
			ResultSet rs = pst.executeQuery();

			table.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void deleteByOS() {

		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusao do Ordem De Servico ?", "ATENCAO",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from tbos where os = ?";
			try {

				Connection con = dao.conectar();

				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtOS.getText());

				int exclui = pst.executeUpdate();
				if (exclui == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "OS excluida com sucesso!");

				}

				con.close();

			} catch (java.sql.SQLIntegrityConstraintViolationException e2) {
				JOptionPane.showMessageDialog(null,
						"Fornecedor Nao Pode ser Excluido Pois Existem Produtos no Estoque");
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public void limpar() {

		txtOS.setText(null);
		((DefaultTableModel) table.getModel()).setRowCount(0);

	}
}
