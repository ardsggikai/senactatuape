package seguros;

import contas.Conta;

public class SeguroPessoaFisica extends Conta {

	public static void main(String[] args) {
		// objeto 3
		SeguroPessoaFisica cc3 = new SeguroPessoaFisica();
		cc3.setCliente("Robson Vaamonde");
		cc3.setSaldo(15000);
		System.out.println("Cliente: " + cc3.getCliente());
		cc3.exibirSaldo();
	}

}
