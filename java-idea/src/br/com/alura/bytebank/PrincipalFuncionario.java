package br.com.alura.bytebank;

import br.com.alura.bytebank.model.Funcionario;

import java.time.LocalDate;

public class PrincipalFuncionario {

    public static void main(String[] args) {

        System.out.println("Bem vindo ao ByteBank!");

        Funcionario phelipe = new Funcionario("Phelipe", 1, LocalDate.of(1999, 9, 6));
        Funcionario pfluck = new Funcionario("Pfluck", 1, LocalDate.of(1999, 12, 11));

        System.out.println(phelipe);
        System.out.println(pfluck);
    }
}