/**
 * Fundamentos  do Java
 * N�meros aleat�rios
 */
package fundamentos;

import java.util.Random;

/**
 * @author Allan Gomes
 *
 */
public class NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// As linhas abaixo geram n�meros aleat�rios
		// O zero sempre � considerado

		Random random = new Random();
		int face = random.nextInt(6) + 1;
		System.out.println("Face do dado: " + face);

	}
	
	

}//Fim do Codigo
