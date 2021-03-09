package br.com.alura.java.io.teste;

import java.io.FileWriter;
import java.util.Properties;

public class TesteProperties {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.setProperty("login", "alura");
        props.setProperty("senha", "alurapass");
        props.setProperty("endereco", "www.alura.com.br");

        props.store(new FileWriter("conf.properties"), "Teste de Escrita em arquivo Properties");

        System.out.println(props.getProperty("login") + ", " + props.getProperty("senha")  + ", " +  props.getProperty("endereco"));
    }
}