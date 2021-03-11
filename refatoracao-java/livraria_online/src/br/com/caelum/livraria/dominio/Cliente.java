package br.com.caelum.livraria.dominio;

public class Cliente {

	private final String id;
	private String cep;
	private String ddd;
	private String numero;

	public Cliente(String id, String ddd, String numero, String cep) {
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.cep = cep;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			iguais = id.equals(outra.id);
		}
		return iguais;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getTelefone() {
		return getTelefoneFormatado();
	}

	public String getCep() {
		return cep;
	}

	public String getTelefoneFormatado() {
		return String.format("(%s) %s", ddd, numero);
	}
}
