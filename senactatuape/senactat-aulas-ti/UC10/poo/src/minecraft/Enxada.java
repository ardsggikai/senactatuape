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

	// Novo m�todo
	void arar() {
		System.out.println("Terra preparada para o plantio");
		conquista = true;
	}
	// Polimorfismo (modifica��o de um metodo existente. "Importante: Mesmo nome do m�todo e somente em caso de heran�a)
	void minerar() {
		System.out.println("Atacar..");
		
	}
}
