package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = "ç";
        System.out.println(s.codePointAt(0));

        Charset charset = Charset.defaultCharset();
        System.out.println(charset.displayName());

        byte[] bytes = s.getBytes("UTF-8");
        System.out.println(bytes.length + ", UTF-8");

        bytes = s.getBytes("UTF-16");
        System.out.print(bytes.length + ", UTF-16, ");
        String s16 = new String(bytes, "UTF-16");
        System.out.println(s16);

        bytes = s.getBytes("windows-1252");
        System.out.println(bytes.length + ", windows-1252");

        bytes = s.getBytes(StandardCharsets.US_ASCII);
        System.out.print(bytes.length + ", US_ASCII, ");
        //String sAsc = new String(bytes); //volta para o charset padrão
        String sAsc = new String(bytes, StandardCharsets.US_ASCII); //força um charset
        System.out.println(sAsc);
    }
}
