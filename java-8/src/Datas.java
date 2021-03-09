import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {

        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate dataDeNascimento = LocalDate.of(1999, Month.SEPTEMBER, 6);
        int idade = hoje.getYear() - dataDeNascimento.getYear();
        System.out.println(idade);

        Period periodo = Period.between(dataDeNascimento, hoje);
        System.out.println(periodo.getYears());

        LocalDate primeiroAniversario = dataDeNascimento.plusYears(1);
        System.out.println(primeiroAniversario);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String valorFormatado = primeiroAniversario.format(formatador);
        System.out.println(valorFormatado);

        DateTimeFormatter formatadorComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatadorComHoras));

        System.out.println(agora.toLocalDate().format(formatador));

        LocalTime horaEspecifica = LocalTime.of(20, 30, 50);
        System.out.println(horaEspecifica);
    }
}
