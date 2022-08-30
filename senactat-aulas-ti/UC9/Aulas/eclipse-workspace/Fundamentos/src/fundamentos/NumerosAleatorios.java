/**
 * Fundamentos  do Java
 * N�meros aleat�rios
 */
package fundamentos;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Allan Gomes
 *
 */
public class NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		    char novoJogo = 'n';
		    //a linha de baixo cria um objeto para capturar dados
		    Scanner teclado = new Scanner(System.in);
			do {
			// As linhas abaixo geram numeros aleatorios
			// O zero sempre considerado

			Random random = new Random();
			int face = random.nextInt(6) + 1;
			System.out.println("======= JOGO DO DADO =======");
			System.out.println("       Face do dado: " + face);
			System.out.println("Deseja jogar novamente(s/n)? ");
			System.out.println("");
			novoJogo = teclado.next().charAt(0);
		} while(novoJogo == 's');
        teclado.close();  
	}

}// Fim do Codigo
