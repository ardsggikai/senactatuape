/**
 * 
 */
package main;

import javax.swing.JFrame;

/**
 * @author allan.gomes
 *
 */
public class Stage {

	public static void main(String[] args) {
		JFrame janela = new JFrame("Space Invaders");
		// janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
		janela.setSize(1280, 720);
		// janela.setUndecorated(true);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setResizable(false);
		janela.setLocationRelativeTo(null); // centralizar a janela

		// Criar um objeto para acessar a Engine
		Engine assets = new Engine();
		assets.setBounds(0, 0, 1280, 720);
		janela.add(assets);
		// adicionar "escuta" de teclado
		janela.addKeyListener(assets);
	}

}
