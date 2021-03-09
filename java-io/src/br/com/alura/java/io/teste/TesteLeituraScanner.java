package br.com.alura.java.io.teste;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraScanner {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(new File("contas.csv"), StandardCharsets.UTF_8.name());

        while(scanner.hasNextLine()) {
            String linha = scanner.nextLine();
//            System.out.println(linha);

//            String[] valores = linha.split(",");
//            System.out.println(Arrays.toString(valores));

            Scanner linhaScanner = new Scanner(linha);
            linhaScanner.useLocale(Locale.US);
            linhaScanner.useDelimiter(",");

            String tipoDaConta = linhaScanner.next();
            int agencia = linhaScanner.nextInt();
            int numero = linhaScanner.nextInt();
            String titular = linhaScanner.next();
            double saldo = linhaScanner.nextDouble();

            System.out.println(String.format(new Locale("pt", "br"),"%s - %04d-%08d, %20s: %08.2f", tipoDaConta, agencia, numero, titular, saldo));

            linhaScanner.close();
        }

        scanner.close();
    }
}
