package br.com.alura;

import java.util.Map;
import java.util.Objects;

public class Aluno {

    private String nome;
    private int numeroMatricula;

    public Aluno(String nome, int numeroMatricula) {
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public String toString() {
        return "[Aluno: " + this.getNome() + ", matricula: " + this.getNumeroMatricula() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Aluno outro = (Aluno) obj;
        return this.nome.equals(outro.getNome());
    }

    @Override
    public int hashCode() {
        return this.nome.hashCode();
    }
}
