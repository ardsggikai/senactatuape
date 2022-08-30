package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Backdrop {
	BufferedImage background;

	// posicao inicial eixo y para desenhar o background
	// esta variavel precisar ser global
	int posBy = 0;

	// Construtor
	public Backdrop() {

		// tratamento de excecoes
		try {
			// carregar a imagem (upload)
			background = ImageIO.read(new File("img/background2.jpg")); // Tem que ser do mesmo tamanho da tela (exemplo
																		// 1920x1080)
		} catch (Exception e) {
			System.out.println("Nao foi possivel carregar a imagem");
			System.out.println(e);
		}

	}// Fim do constructor

	// metodo responsavel por "desenhar"
	public void exibirbackground(Graphics g) {
		g.drawImage(background, 0, posBy - 720, null);
		g.drawImage(background, 0, posBy, null);

		if (posBy > 720) {
			posBy = 0;

		} else {
			posBy += 2;
		}
	}

}// fim do codigo
