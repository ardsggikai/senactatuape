package portfolio;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Cep extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtBairro;
	private JTextField txtCidade;
	@SuppressWarnings("rawtypes")
	private JComboBox cboUf;
	private JLabel lblStatus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cep frame = new Cep();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Cep() {
		setResizable(false);
		setTitle("Qual o seu CEP?");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cep.class.getResource("/img/IcoCep.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCep.setBounds(23, 37, 34, 14);
		contentPane.add(lblCep);

		txtCep = new JTextField();
		txtCep.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCep.setBounds(56, 35, 104, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEndereco.setBounds(10, 90, 59, 14);
		contentPane.add(lblEndereco);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBairro.setBounds(23, 123, 46, 14);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		lblCidade.setBounds(23, 154, 51, 14);
		contentPane.add(lblCidade);

		txtEndereco = new JTextField();
		txtEndereco.setFont(new Font("Arial", Font.PLAIN, 11));
		txtEndereco.setBounds(66, 88, 325, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 11));
		txtBairro.setBounds(66, 121, 270, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 11));
		txtCidade.setBounds(76, 152, 218, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblUf = new JLabel("UF");
		lblUf.setBounds(304, 154, 39, 14);
		contentPane.add(lblUf);

		cboUf = new JComboBox();
		cboUf.setFont(new Font("Arial", Font.PLAIN, 11));
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(329, 150, 59, 22);
		contentPane.add(cboUf);

		JButton btnLimpar = new JButton("");
		btnLimpar.setIcon(new ImageIcon(Cep.class.getResource("/img/eraser.png")));
		btnLimpar.setToolTipText("Limpar");
		btnLimpar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnLimpar.setBounds(167, 179, 64, 64);
		contentPane.add(btnLimpar);

		JButton btnCep = new JButton("");
		btnCep.setIcon(new ImageIcon(Cep.class.getResource("/img/btnBuscar.png")));
		btnCep.setToolTipText("Buscar");
		btnCep.setFont(new Font("Arial", Font.PLAIN, 11));
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
				} else {
					buscarCep();
				}
			}
		});
		btnCep.setBounds(200, 11, 64, 64);
		contentPane.add(btnCep);

		lblStatus = new JLabel("");
		lblStatus.setBounds(170, 35, 20, 20);
		contentPane.add(lblStatus);

		RestrictedTextField validar = new RestrictedTextField(txtCep);
		validar.setOnlyNums(true);
		validar.setLimit(8);
		
		RestrictedTextField validar1 = new RestrictedTextField(txtEndereco);
		validar1.setOnlyText(true);
		validar1.setAcceptSpace(true);
		
		RestrictedTextField validar2 = new RestrictedTextField(txtBairro);
		validar2.setOnlyText(true);
		validar2.setAcceptSpace(true);
		
		RestrictedTextField validar3 = new RestrictedTextField(txtCidade);
		validar3.setOnlyText(true);
		validar3.setAcceptSpace(true);
	}

	/**
	 * buscarCep
	 */
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
						lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check.png")));
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

	/**
	 * limpar
	 */
	private void limpar() {
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtBairro.setText(null);
		txtCidade.setText(null);
		cboUf.setSelectedItem(null);
		txtCep.requestFocus();
		lblStatus.setIcon(null);
	}
}