/**
 * 
 */
package minecraft;

/**
 * @author Allan Gomes
 *
 */
public class Enxada extends Bloco{
	// Atributos
	boolean conquista = false;

	// Novo método
	void arar() {
		System.out.println("Terra preparada para o plantio");
		conquista = true;
	}
	// Polimorfismo (modificação de um metodo existente. "Importante: Mesmo nome do método e somente em caso de herança)
	void minerar() {
		System.out.println("Atacar..");
		
	}
}
