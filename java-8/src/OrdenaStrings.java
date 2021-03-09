import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStrings {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<String>();
        palavras.add("Alura Online");
        palavras.add("Casa do Codigo");
        palavras.add("Caelum");
        palavras.add("Abelha");

        //Comparator<String> comparador = new ComparadorPorTamanho();
        //Collections.sort(palavras, comparador);
        //palavras.sort(comparador);

//        palavras.sort(new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                if(s1.length() < s2.length()) {
//                    return -1;
//                }
//                if(s1.length() > s2.length()) {
//                    return 1;
//                }
//                return 0;
//            }
//        });

//        palavras.sort((s1, s2) -> {
//            if(s1.length() < s2.length()) {
//                return -1;
//            }
//            if(s1.length() > s2.length()) {
//                return 1;
//            }
//            return 0;
//        });

        //palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

//        Function<String, Integer> funcao = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length();
//            }
//        }
//        Function<String, Integer> funcao = s -> s.length();
//        Function<String, Integer> funcao = String::length;
//        Comparator<String> comparador = Comparator.comparing(funcao);
//        palavras.sort(comparador);

//        palavras.sort(Comparator.comparing(s -> s.length()));

        //palavras.sort(Comparator.comparing(String::length));
        palavras.sort(Comparator.comparing(s -> s.charAt(0)));

        System.out.println(palavras);

        System.out.println("-------");

        for (String p: palavras) {
            System.out.println(p);
        }

        System.out.println("-------");

        //Consumer<String> consumidor = new ImprimeNaLinha();

//        Consumer<String> consumidor = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        //palavras.forEach(consumidor);

//        palavras.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        });

//        Consumer<String> impressor = s -> System.out.println(s);
//        Consumer<String> impressor = System.out::println;
//        palavras.forEach(impressor);

//        palavras.forEach(s -> System.out.println(s));
        palavras.forEach(System.out::println);
    }
}

class ImprimeNaLinha implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) {
            return -1;
        }
        if(s1.length() > s2.length()) {
            return 1;
        }
        return 0;
    }
}