package contas;

public class Conta {

	// atributos encapsulados

	private double saldo;
	private String cliente;

	// criar m�todo p�blico especificos para "usar" as variaveis
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	// construtor
	public Conta() {
		System.out.println("---------------------------");
		System.out.println("Ag�ncia 267");
	}

	/* M�todos */

	/**
	 * M�todo Simples para exibir o saldo
	 */
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

	/**
	 * M�todo com par�metros (vari�vel)
	 * 
	 * @param valor
	 */
	void sacar(double valor) {
		saldo -= valor;
		System.out.println("D�bito: R$ " + valor);
	}

	void depositar(double valor) {
		saldo += valor;
		System.out.println("Credito: R$ " + valor);
	}

	/**
	 * M�todo com par�metros (objeto e vari�vel)
	 * 
	 * @param destino = transferir = Pessoa (objeto)
	 * @param valor   (variavel)
	 */
	void transferir(Conta destino, double valor) {

		this.sacar(valor); // this se refere a ele mesmo
		destino.depositar(valor);
		System.out.println("Transfer�ncia: R$ " + valor);

	}

	/**
	 * M�todo com 2 par�metros (variaveis) e um retorno obrigat�rio
	 * 
	 * @param cc1
	 * @param cc2
	 * @return total
	 */
	double soma(double cc1, double cc2) {

		double total = cc1 + cc2;
		return total;
	}

}
