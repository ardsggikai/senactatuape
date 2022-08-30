/**
 * Fundamentos do Java
 * 
 * Estruturas de repetiçoes
 */
package fundamentos;

/**
 * @author Allan Gomes
 *
 */
public class EstruturasRepeticoes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Estrutura for
		System.out.println("---------------------------");
		System.out.println("Exemplo 1 - 0 ao 10 - for");
		System.out.println("---------------------------");
		System.out.println("");
		for (int i = 1; i < 11; i++) {
			System.out.println(i);
		}

		System.out.println("---------------------------");
		System.out.println("Exemplo 2 - 10 ao 0 - for");
		System.out.println("---------------------------");
		System.out.println("");
		for (int j = 10; j >= 0; j--) {
			System.out.println(j);
		}
		System.out.println("---------------------------");
		System.out.println("Exemplo 3 - Tabuada do 7");
		System.out.println("---------------------------");
		System.out.println("");
		int valor = 7;
		for (int x = 1; x < 11; x++)
			System.out.println(valor + " x " + x + "=" + (valor * x));
		System.out.println("---------------------------");
		System.out.println("Exemplo 4 - Tabuadas");
		for (int tabuada = 1; tabuada < 11; tabuada++) {
			System.out.println("---------------------------");
			System.out.println("Tabuada do " + tabuada);
			System.out.println("");
			for (int calcular = 1; calcular < 11; calcular++) {
				System.out.println(tabuada + " x " + calcular + " = " + (tabuada * calcular));
			}
		}
		System.out.println("---------------------------");
		System.out.println("Exemplo 5 - while");
		System.out.println("---------------------------");
		System.out.println("");
		int z = 0;
		while (z < 10) {
			System.out.println(z);
			z++;
		}
		System.out.println("---------------------------");
		System.out.println("Exemplo 6 - do while");
		System.out.println("---------------------------");
		System.out.println("");
		int y = 10;
		do {
			System.out.println("Teste");
		} while (y > 20);
		System.out.println("---------------------------");

		System.out.println("---------------------------");
		System.out.println("Exemplo 7 - tabuada while");
		System.out.println("---------------------------");
		System.out.println("");
		int tabuada = 7;
		int i = 1;
		while (i < 11) {
			System.out.println(tabuada + " x " + i + " = " + (tabuada * i));
			i++;
		}
		System.out.println("---------------------------");

		System.out.println("----------------------------");
		System.out.println("Exemplo 8 -tabuada do while");
		System.out.println("----------------------------");
		int tabuada8 = 8;
		int v = 1;
		do {
			System.out.println(tabuada8 + " x " + v + " = " + (tabuada8 * v));
			v++;
		} while (v < 11);
		System.out.println("----------------------------");

	}

}
