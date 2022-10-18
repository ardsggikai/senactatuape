package contas;

public class Conta {

	// atributos encapsulados

	private double saldo;
	private String cliente;

	// criar método público especificos para "usar" as variaveis
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
		System.out.println("Agência 267");
	}

	/* Métodos */

	/**
	 * Método Simples para exibir o saldo
	 */
	protected void exibirSaldo() {
		System.out.println("Saldo: R$ " + saldo);
	}

	/**
	 * Método com parâmetros (variável)
	 * 
	 * @param valor
	 */
	void sacar(double valor) {
		saldo -= valor;
		System.out.println("Débito: R$ " + valor);
	}

	void depositar(double valor) {
		saldo += valor;
		System.out.println("Credito: R$ " + valor);
	}

	/**
	 * Método com parâmetros (objeto e variável)
	 * 
	 * @param destino = transferir = Pessoa (objeto)
	 * @param valor   (variavel)
	 */
	void transferir(Conta destino, double valor) {

		this.sacar(valor); // this se refere a ele mesmo
		destino.depositar(valor);
		System.out.println("Transferência: R$ " + valor);

	}

	/**
	 * Método com 2 parâmetros (variaveis) e um retorno obrigatório
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
