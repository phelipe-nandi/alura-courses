package br.com.alura;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<Aula>();
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaAluno = new HashMap<>();

    public Curso(String nome, String instrutor) {
        if(nome == null){
            throw new NullPointerException("Nome não pode ser null");
        }
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public void adiciona(Aula aula) {
        this.aulas.add(aula);
    }

    public void matricula(Aluno aluno) {
        this.alunos.add(aluno);
        this.matriculaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public int getTempoTotal() {
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "[Curso: " + this.getNome() + ", tempo total: " + this.getTempoTotal() + ", aulas: " + this.aulas + "]";
    }

    public boolean estaMatriculado(Aluno a1) {
        return this.alunos.contains(a1);
    }

    public Aluno buscaMatricula(int i) {
        if (!matriculaAluno.containsKey(i)) {
            throw new NoSuchElementException("Não encontrei esse aluno!");
        } else {
            return matriculaAluno.get(i);
        }
    }
}
