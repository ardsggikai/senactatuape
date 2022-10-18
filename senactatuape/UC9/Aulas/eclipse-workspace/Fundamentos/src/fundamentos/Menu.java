/**
 *  Fundamentos da Logica de Progra��o com Java
 *  Exemplo de uso da estrutura switch case
 */
package fundamentos;

/**
 * @author allan.rsgomes
 *
 */
public class Menu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Menu de Op��es:");
		System.out.println("1.Windows");
		System.out.println("2.Linux");
		System.out.println("3.Mac OS");
		System.out.println("Digite a Op��o Desejada: ");
		int opcao = 1;
		System.out.println("Op��o escolhida: " + opcao);
		switch (opcao) {
		case 1:
			System.out.println("Carregando o Windows.......");
			break;
		case 2:
			System.out.println("Carregando o Linux.......");
			break;
		case 3:
			System.out.println("Carregando o Mac OS.......");
			break;
		default:
			System.out.println("Op��o Invalida.......");
			break;
		}

	}

}
