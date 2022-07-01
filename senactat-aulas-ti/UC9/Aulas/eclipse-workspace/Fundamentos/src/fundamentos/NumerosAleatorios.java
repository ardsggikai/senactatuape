/**
 * Fundamentos  do Java
 * Números aleatórios
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
		// As linhas abaixo geram números aleatórios
		// O zero sempre é considerado

		Random random = new Random();
		int face = random.nextInt(6) + 1;
		System.out.println("Face do dado: " + face);

	}
	
	

}//Fim do Codigo
