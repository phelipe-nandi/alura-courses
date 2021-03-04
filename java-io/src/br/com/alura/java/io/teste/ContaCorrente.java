package br.com.alura.java.io.teste;

import java.io.Serializable;

public class ContaCorrente extends Conta {

	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public String toString() {
		return "Conta Corrente: " + super.toString();
	}
}