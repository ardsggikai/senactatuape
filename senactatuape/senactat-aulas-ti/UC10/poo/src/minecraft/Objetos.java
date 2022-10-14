package minecraft;

/**
 * @author Allan Gomes
 *
 */

public class Objetos {

	public static void main(String[] args) {
		System.out.println("Objeto 1");
		Enxada enxadaPedra = new Enxada();
		enxadaPedra.textura = "Pedra";
		enxadaPedra.resistencia = 5;
		System.out.println("Enxada: " + enxadaPedra.textura);
		System.out.println("Resistência: " + enxadaPedra.resistencia);
		enxadaPedra.arar();
		if (enxadaPedra.conquista == true) {
			System.out.println("Conquista Desbloqueada!");
		}
		//Objeto 2
		Enxada enxadaDiamante = new Enxada();
		enxadaDiamante.textura = "Diamante";
		enxadaDiamante.resistencia = 10;
		System.out.println("Enxada: " + enxadaDiamante.textura);
		System.out.println("Resistência: " + enxadaDiamante.resistencia);
		enxadaDiamante.minerar();
		

	}

}
