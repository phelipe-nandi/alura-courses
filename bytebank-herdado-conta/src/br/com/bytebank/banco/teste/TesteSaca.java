package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteSaca {

	public static void main(String[] args) {
		
		Conta c = new ContaCorrente(111, 222);
		c.deposita(100);
		try{
			c.saca(200);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(c.getSaldo());
	}
}
