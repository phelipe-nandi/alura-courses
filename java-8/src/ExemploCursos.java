import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}

public class ExemploCursos {

    public static void main(String[] args) {

        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));
        cursos.forEach(curso -> System.out.println(curso.getNome()));

//        System.out.println("---------------");

//        cursos.sort(Comparator.comparing(Curso::getAlunos));
//        cursos.stream().filter(curso -> curso.getAlunos() >= 100).forEach(curso -> System.out.println(curso.getNome()));
//        cursos.stream().filter(curso -> curso.getAlunos() >= 100).map(Curso::getAlunos).forEach(System.out::println);
//
//        int sumAlunos = cursos.stream().filter(curso -> curso.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();
//        System.out.println(sumAlunos);

//        System.out.println("---------------");

//        Stream<String> nomes = cursos.stream().map(Curso::getNome);
//        nomes.forEach(System.out::println);

//        System.out.println("---------------");

//        Optional<Curso> optionalCurso = cursos.stream().filter(curso -> curso.getAlunos() >= 100).findAny();
//        Curso cursoAny = optionalCurso.orElse(null);
//        System.out.println(cursoAny.getNome());
//        //ou
//        optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
//        //ou
//        cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(curso -> System.out.println(curso.getNome()));

//        System.out.println("---------------");
//
//        List<Curso> resultado = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());
//        resultado.forEach(curso -> System.out.println(curso.getNome()));

//        System.out.println("---------------");
//
//        Map<String, Integer> map = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toMap(curso -> curso.getNome(), curso -> curso.getAlunos()));
//        System.out.println(map);
//        //ou
//        cursos.stream().filter(c -> c.getAlunos() >= 100).
//                collect(Collectors.toMap(curso -> curso.getNome(), curso -> curso.getAlunos())).
//                forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));

        System.out.println("---------------");

        OptionalDouble mediaAlunos = cursos.stream().mapToInt(curso -> curso.getAlunos()).average();
        System.out.println(mediaAlunos);
    }
}