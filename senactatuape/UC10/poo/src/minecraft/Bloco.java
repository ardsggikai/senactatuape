/**
 * 
 */
package minecraft;

/**
 * @author Allan Gomes
 *
 */
public class Bloco {
	// atributos
	int resistencia;
	String textura;

	// construtor
	public Bloco() {
		System.out.println("-----------------");

	}

	// métodos
	void construir() {
		System.out.println("Bloco colocado.");
	}

	void minerar() {
		System.out.println("Recursos obtidos.");
	}

	void craftar() {
		System.out.println("Item criado!");
	}

}
