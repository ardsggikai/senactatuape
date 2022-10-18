/**
 *  Fundamentos do Java 
 *  Estudo do array = Array List (dinâmico)
 */
package array;

import java.util.ArrayList;

public class Array3 {

	public static void main(String[] args) {
		// a Linha abaixo cria um vetor dinanimco
		System.out.println("-----------------------------------------");
		// O ArrayList aceita o tipo string ou uma classe
		ArrayList<String> contatos = new ArrayList<>();
		contatos.add("Allan Gomes");
		contatos.add("99999-1234");
		contatos.add("allan@email.com");
		contatos.add("Elon Musk");
		contatos.add("97651-1234");
		contatos.add("Elon.Musk@email.com");
		// a linha abaixo exibe o conteudo do vetor
		System.out.println(contatos);
		System.out.println("-----------------------------------------");

		// a linha abaixo exibe o tamanho do vetor
		System.out.println("tamanho do array: " + contatos.size());
		System.out.println("-----------------------------------------");

		// a linha abaixo recupera um valor do vetor
		System.out.println("Indice 3 : " + contatos.get(3));
		System.out.println("-----------------------------------------");

		// a linha abaixo remove um valor da lista
		System.out.println("Removendo um valor do array (indice 3)");
		contatos.remove(2);
		System.out.println(contatos);
		System.out.println("Tamanho do vetor" + contatos.size());
		System.out.println("-----------------------------------------");
		// Usando um laço for para percorrer o array
		System.out.println("Agenda de contatos");
		for (int i = 0; i < contatos.size(); i++)

		{
			System.out.println(contatos.get(i));
		}
	}
}
