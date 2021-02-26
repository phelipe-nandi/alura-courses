package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		
		Object[] referencias = new Object[5];
		
		ContaCorrente cc1 = new ContaCorrente(111, 222);
		referencias[0] = cc1;
		
		ContaCorrente cc2 = new ContaCorrente(222, 111);
		referencias[1] = cc2;
		
		ContaPoupanca cp1 = new ContaPoupanca(333, 444);
		referencias[2] = cp1;
		
		Cliente cliente = new Cliente();
		referencias[3] = cliente;
		
		ContaCorrente ref = (ContaCorrente) referencias[1]; //typeCast
		System.out.println(ref.getNumero());
	}
}
