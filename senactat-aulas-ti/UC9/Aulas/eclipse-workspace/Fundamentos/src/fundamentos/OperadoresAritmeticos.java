/**
 * Fundamentos do Java
 * Operadores Aritmeticos 
 */
package fundamentos;

/**
 * @author Allan Gomes
 *
 */
public class OperadoresAritmeticos {

	/**
	 * Método Principal
	 * @param args
	 */
	public static void main(String[] args) {
		double x = 5;
		System.out.println("Operadores Aritméticos");
		System.out.println("-----------------------------------");
		System.out.println("| Operador | Exemplo  | Resultado |");
		System.out.println("|    =     | x = 5    |  "+ x +      "      |"); 
        System.out.println("|    +     | x = 5 + 5|  " + (x + 5) +"     |");
        System.out.println("|    -     | x = 5 - 5|  " + (x - 4)  +"      |");
        System.out.println("|    *     | x = 5 * 3|  " + (x * 3)  +"     |");
        System.out.println("|    /     | x = 5 / 2|  " + (x / 2)  +"      |");
        System.out.println("|    %     | x = 5 % 2|  " + (x % 2)  +"      |");
        System.out.println("-----------------------------------");
	}

}
