/**
 *  Fundamentos do Java 
 *  Estudo do array de duas dimensoes (MATRIZ)
 */

package array;

public class Array4 {

	public static void main(String[] args) {
		// [][] [linha][coluna]
		String[][] agenda = { { "Elon Musk", "9999-1234", "privacy@spacex.com" },
				{ "Allan Gomes", "9999-6543", "allan.gomes@gmail.com" },
				{ "Fagner Braga", "9999-4321", "fagner.braga@outlook.com" } };
		System.out.println("======================");
		// recuperar o nome do fagner
		System.out.println(agenda[2][0]);
		System.out.println("======================");
		// recuperar o numero do Elon Musk
		System.out.println(agenda[0][1]);
		// percorrendo a matriz com o laco for
		System.out.println("======================");
		System.out.println("==============================");
		System.out.println("===== Agenda de Contatos =====");
		System.out.println("==============================");
		System.out.println("");
		// 1o laco faz a varredura das linhas
		for (int i = 0; i < agenda.length; i++) {
			System.out.println("____________________________");
			// 2o laco faz a varredura das colunas
			for (int j = 0; j < agenda[i].length; j++) {
				System.out.println(agenda[i][j]);
				
			}
		}
	}

}
