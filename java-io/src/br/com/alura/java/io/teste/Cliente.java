package br.com.alura.java.io.teste;

import java.io.Serializable;

/**
 * Classe representa a moldura de um Cliente no Banco do Bytebank.
 * 
 * @author Phelipe
 * @version 1.0
 *
 */

public class Cliente implements Serializable {

	private static final long serialVersionUID = 9205117266306915548L;

	private String nome;
	private String cpf;
	private String profissao;

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getProfissao() {
		return this.profissao;
	}
	
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}