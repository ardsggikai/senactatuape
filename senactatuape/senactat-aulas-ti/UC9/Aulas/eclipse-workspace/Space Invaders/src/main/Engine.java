package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import sprites.Laser;
import sprites.Nave;

@SuppressWarnings("serial")
public class Engine extends JPanel implements Runnable, KeyListener {

	// Vincular a nave
	Nave nave = new Nave();
	public int sentido;

	// Vincular o background
	Backdrop background = new Backdrop();
	public int movimento;

	// Vincular o laser usando um vetor dinamico para guardar os tiros
	public ArrayList<Laser> laser = new ArrayList<Laser>();
	
	// Vincular o audio (som laser)
	Sound somLaser = new Sound();
	

	// construtor
	public Engine() {
		// criar uma thread (processamento em paralelo do jogo)
		Thread game = new Thread(this);
		game.start(); // iniciar processamento do jogo (run())
	}

	@Override
	public void run() {
		while (true) {
			// System.out.println("teste");
			// Mecanica do jogo
			refresh(); // atualizar o JPanel -> JFrame
			repaint(); // redesenhar os assets
			delay(); // tempo antes do refresh (ajustes UX)
		}
	}

	public void refresh() {
		// nave
		nave.moverNave(sentido);
		// laser
		for (int i = 0; i < laser.size(); i++) {
			laser.get(i).moverLaser();
			// se o laser chegar ao fim da tela (posYL < 0)
			if (laser.get(i).removerLaser() == true) {
				laser.remove(i);

			}
		}
		// apoio ao entendimento da logica do tiro
		//System.out.println(laser.size());
	}

	public void paintComponent(Graphics g) {
		// limpar a tela (evitar o rastro do sprite)
		super.paintComponent(g);
		background.exibirbackground(g);
		// camada 2
		// laser
		for (int i = 0; i < laser.size(); i++) {
			laser.get(i).exibirLaser(g);
		}
		// super.paintComponent(g);
		nave.exibirNave(g);
		// camada 3

	}

	public void delay() {
		// tratamento de excecoes
		try {
			Thread.sleep(15); // mili segundos (1000 ms = 1s)
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	// Pressionar uma tecla
	@Override
	public void keyPressed(KeyEvent e) {
		// se seta direita pressionada
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			sentido = 1;
		}

		// se seta esquerda pressionada
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			sentido = -1;
		}

		// se seta acima pressionada
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			sentido = 2;
		}

		// se seta a baixo pressionada
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			sentido = -2;
		}

		// }

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// atirar
			laser.add(nave.atirar());
			// Sair som
			somLaser.play();
		}
	}

	// Soltar a tecla que esta pressionada
	@Override
	public void keyReleased(KeyEvent e) {
		// se soltar a tecla seta direita
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			sentido = 0;
		}

		// se soltar a tecla seta esquerda
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			sentido = 0;
		}

		// se soltar acima pressionada
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			sentido = 0;
		}

		// se soltar a tecla seta abaixo
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			sentido = 0;
		}
	}

}// fim do codigo