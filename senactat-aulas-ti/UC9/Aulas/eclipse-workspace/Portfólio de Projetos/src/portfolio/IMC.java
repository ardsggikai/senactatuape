package portfolio;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IMC extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;

	/**
	 * Inicie o aplicativo.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IMC dialog = new IMC();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Crie o diálogo.
	 */
	public IMC() {
		setResizable(false);
		setTitle("IMC");
		setModal(true);
		setBounds(100, 100, 500, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 40, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(50, 37, 330, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Calculo do IMC
				String nome1, nome2;
			      float peso1, peso2, altura1, altura2;
			      float imc1, imc2;
			      String classifica1, classifica2;
			 
			      nome1 = JOptionPane.showInputDialog("Nome da Pessoa 1:");
			      peso1 = Float.parseFloat(JOptionPane.showInputDialog("Peso da Pessoa 1 (kg):"));
			      altura1 = Float.parseFloat(JOptionPane.showInputDialog("Altura da Pessoa 1 (m):") );
			      nome2 = JOptionPane.showInputDialog("Nome da Pessoa 2:");
			      peso2 = Float.parseFloat(JOptionPane.showInputDialog("Peso da Pessoa 2 (kg):"));
			      altura2 = Float.parseFloat(JOptionPane.showInputDialog("Altura da Pessoa 2 (m):") );
			 
			      imc1 = (float) (peso1/Math.pow(altura1, 2));
			      imc2 = (float) (peso2/Math.pow(altura2, 2));
			 
			      if (imc1 <= 19)
			         classifica1 = "Abaixo do Peso";
			      else
			         if (imc1 <= 25)
			            classifica1 = "Peso ideal";
			         else
			            if (imc1 <= 30)
			               classifica1 = "Acima do Peso";
			            else
			               if (imc1 <= 35)
			                  classifica1 = "Obesidade Leve";
			               else
			                  classifica1 = "Obesidade";
			 
			      if (imc2 <= 19)
			         classifica2 = "Abaixo do Peso";
			      else
			         if (imc2 <= 25)
			            classifica2 = "Peso ideal";
			         else
			            if (imc2 <= 30)
			               classifica2 = "Acima do Peso";
			            else
			               if (imc2 <= 35)
			                  classifica2 = "Obesidade Leve";
			               else
			                  classifica2 = "Obesidade";
			 
			      JOptionPane.showMessageDialog(null, "IMC da Pessoa 1 = "+imc1+" - "+classifica1);
			      JOptionPane.showMessageDialog(null, "IMC da Pessoa 2 = "+imc2+" - "+classifica2);
			 
			      if (imc1 > imc2)
			         JOptionPane.showMessageDialog(null, "A Pessoa \""+nome1+"\" tem Maior IMC");
			      else
			         JOptionPane.showMessageDialog(null, "A Pessoa \""+nome2+"\" tem Maior IMC");
			}
		});
		btnNewButton.setBounds(385, 36, 89, 20);
		getContentPane().add(btnNewButton);

	}

}
