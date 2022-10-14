/**
 * Estudo das variáveis
 */
package fundamentos;

/**
 * @author Allan Gomes
 *
 */
public class Variaveis {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Criando (declarando) uma variavel no Java

		String nome;
		nome = "Allan Gomes";
		System.out.println("Nome: " + nome);

		// Declarando a Idade (Variavel)

		int idade = 20;
		System.out.println("Idade: " + idade);

		// É possivel criar em uma única linha 2 ou mais variáveis do memo tipo

		double peso, altura;
		peso = 62;
		altura = 1.85;
		System.out.println("Peso: " + peso);
		System.out.println("Altura: " + altura);
		char sexo;
		sexo = 'M';
		System.out.println("Sexo: " + sexo);
		boolean vip;
		vip = true;
		System.out.println("Aluno VIP? " + vip);
	}

}
