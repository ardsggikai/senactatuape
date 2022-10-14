/**
 * 
 */
package minecraft;

/**
 * @author Allan Gomes
 *
 */
public class Mundo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Criando um objeto
		Bloco blocoTerra = new Bloco();
		blocoTerra.resistencia = 1;
		blocoTerra.textura = "Terra";
		System.out.println("Bloco: " + blocoTerra.textura);
		System.out.println("Resist�ncia: " + blocoTerra.resistencia);
		blocoTerra.construir();
		blocoTerra.minerar();

		// Bloco Madeira
		Bloco blocoMadeira = new Bloco();
		blocoMadeira.resistencia = 2;
		blocoMadeira.textura = "Madeira";
		System.out.println("Bloco: " + blocoMadeira.textura);
		System.out.println("Resist�ncia: " + blocoMadeira.resistencia);
		blocoMadeira.minerar();
		blocoMadeira.craftar();
	}

}
