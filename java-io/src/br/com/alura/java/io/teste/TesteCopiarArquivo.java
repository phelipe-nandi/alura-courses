package br.com.alura.java.io.teste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TesteCopiarArquivo {

    public static void main(String[] args) throws IOException {

        //Leitura
        InputStream fis = new FileInputStream("lorem.txt"); //System.in
        Reader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        //Escrita
        OutputStream fos = new FileOutputStream("lorem2.txt"); //System.out
        Writer osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        //Primeira linha do arquivo lorem.txt
        String linha = br.readLine();

        //Enquanto possuir linhas, o cod ira pegar a linha atual e ira escrever no lorem2.txt
        while(linha != null && !linha.isEmpty()) {
            bw.write(linha);
            bw.newLine();
            bw.flush();
            linha = br.readLine();
        }

        //Fecha conexao de leitura e escrita
        br.close();
        bw.close();
    }
}
