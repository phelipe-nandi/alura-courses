package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;

public class TesteSobrecarga {

	public static void main(String[] args) {

		System.out.println("X");
		System.out.println(1);
		System.out.println(1.5);
		System.out.println(false);

		println();
		println(1);
		println(1.5);
		println(false);
		
		Object cc = new ContaCorrente(111, 222);
		Object cp = new ContaPoupanca(111, 222);
		Object c = new Cliente();
		
		System.out.println(cc);
		System.out.println(cp);
		System.out.println(c);
		
		println(cc);
		println(cp);
		println(c);
		
		System.out.println(cc.toString());
		System.out.println(cp.toString());
	}

	static void println() {}

	static void println(int i) {}

	static void println(double i) {}

	static void println(boolean i) {}
	
	static void println(Object i) {}
}