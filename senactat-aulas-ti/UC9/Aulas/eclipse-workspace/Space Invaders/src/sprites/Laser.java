package sprites;

import java.awt.Color;
import java.awt.Graphics;

public class Laser {
	// Variaveis
	int posXL;
	int posYL;

	// Construtor que recebe como parametro a posicao da nave
	public Laser(int posXLinicial, int posYLInicial) {
		posXL = posXLinicial;
		posYL = posYLInicial;
	}

	// metodo responsavel para exibir(desenhar) o tiro da nave
	public void exibirLaser(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(posXL, posYL, 5, 25); // x,y,width, height
	}

	// metodo responsavel pelo movimento do laser
	public void moverLaser() {
		posYL -= 5; // ajuste da velocidade do tiro de laser
		// apoio ao entendimento da logica do tiro
		// System.out.println(posYL);

	}

	// metodo responsavel pela "remocao" do laser
	public boolean removerLaser() {
		if (posYL < 0) {
			return true;
		} else {
			return false;
		}
	}
}
