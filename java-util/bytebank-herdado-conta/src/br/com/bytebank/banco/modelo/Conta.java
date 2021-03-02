package br.com.bytebank.banco.modelo;

/**
 * Classe representa a moldura de uma Conta no Banco do Bytebank.
 * 
 * @author Phelipe
 * @version 1.0
 *
 */

public abstract class Conta implements Comparable<Conta> {
	
	@DoublePositivo
	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	
	/**
	 * Construtor para inicializar o objeto Conta a partir da agencia e numero
	 * 
	 * @param agencia
	 * @param numero
	 */
	public Conta(int agencia, int numero) {
		Conta.total++;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	public abstract void deposita(double valor);
	
	/**
	 * Valor precisa ser maior que o saldo. 
	 * 
	 * @param valor
	 * @throws SaldoInsuficienteException
	 */
	public void saca(double valor) throws SaldoInsuficienteException {
		if (this.saldo < valor) {
			throw new SaldoInsuficienteException("Saldo insuficiente, seu saldo é: " + 
			this.saldo + " e você está tentando sacar: " + valor);
		}
		this.saldo -= valor;
	}
	
	public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
		this.saca(valor);
		destino.deposita(valor);
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Por favor insira um valor positivo!");
			return;
		}
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Por favor insira um valor positivo!");
			return;
		}
		this.agencia = agencia;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}

	@Override
	public boolean equals(Object object) {

		Conta conta = (Conta) object;

		if(this.agencia != conta.getAgencia() || this.numero != conta.getNumero()){
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Conta conta) {
		return Double.compare(this.saldo, conta.getSaldo());
	}

	@Override
	public String toString() {
		return "Numero: " + this.numero + ", Agencia:" + this.agencia + ", Saldo:" + this.saldo;
	}
}