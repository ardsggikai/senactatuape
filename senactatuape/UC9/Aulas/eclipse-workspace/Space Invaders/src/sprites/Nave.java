package sprites;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Nave {
	// criar um sprite com uma imagem existente (upload)
	BufferedImage sprite1;

	// variaveis
	int posX = 600;
	int posY = 550;
	int velocidade = 3;

	// Construtor
	public Nave() {
		// tratamento de excecoes
		try {
			// carregar a imagem (upload)
			sprite1 = ImageIO.read(new File("img/nave2.png"));
		} catch (Exception e) {
			System.out.println("Nao foi possivel carregar a imagem");
			System.out.println(e);
		}
	}

	// metodo responsavel por "desenhar" a nave
	public void exibirNave(Graphics g) {
		g.drawImage(sprite1, posX, posY, null); // 600 -> posicao x | 550 -> pos y

	}

	// Metodo que ao ser executado recebe um valor para a variavel sentido X
	public void moverNave(int sentido) {

		// Sentido x positivo >>> (1)
		// Sentido x negativo <<< (-1)

		if (sentido == 1) {
			posX += velocidade;

		} else if (sentido == -1) {
			posX -= velocidade;

		} else if (sentido == 2) {
			posY -= velocidade;
		} else if (sentido == -2) {
			posY += velocidade;
		}

		if (posX >= 1175) {
			posX = 1175;
		}

		if (posX <= 0) {
			posX = 0;
		}

		if (posY >= 560) {
			posY = 560;
		}

		if (posY <= 0) {
			posY = 0;
		}
	}// fim do metodo

	// Criar o tiro passando a posicao X da nave para a Classe Laser

	public Laser atirar() {

		Laser tiro = new Laser(posX + 42, posY);
		return tiro;
	}
}