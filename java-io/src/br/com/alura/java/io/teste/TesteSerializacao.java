package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacao {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        String nome = "Phelipe Nandi";

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objeto.bin"));
//        oos.writeObject(nome);
//        oos.close();

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
//        String nome = (String) ois.readObject();
//        ois.close();
//
//        System.out.println(nome);

//        Cliente cliente = new Cliente();
//        cliente.setNome("Phelipe");
//        cliente.setProfissao("Desenvolvedor");
//        cliente.setCpf("54154511");

//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//        oos.writeObject(cliente);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cliente.bin"));
        Cliente cliente = (Cliente) ois.readObject();
        ois.close();

        System.out.println(cliente.getNome());

    }
}
