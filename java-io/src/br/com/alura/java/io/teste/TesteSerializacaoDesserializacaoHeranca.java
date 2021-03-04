package br.com.alura.java.io.teste;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoDesserializacaoHeranca {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Cliente cliente = new Cliente();
//        cliente.setNome("Phelipe");
//        cliente.setProfissao("Desenvolvedor");
//        cliente.setCpf("54154511");
//
//        ContaCorrente cc = new ContaCorrente(111, 222);
//        cc.setTitular(cliente);
//        cc.setSaldo(100);
//
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
//        oos.writeObject(cc);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cc.bin"));
        ContaCorrente cc = (ContaCorrente) ois.readObject();
        ois.close();
        System.out.println(cc.getSaldo());
        System.out.println(cc.getTitular());
    }
}
