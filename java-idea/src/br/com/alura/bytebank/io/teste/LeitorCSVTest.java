package br.com.alura.bytebank.io.teste;

import br.com.alura.bytebank.io.LeitorCSV;
import br.com.alura.bytebank.model.Pagamento;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class LeitorCSVTest {

    @Test
    public void pagamentosDeAbril() throws IOException {
        LeitorCSV leitor = new LeitorCSV();
        List<Pagamento> pagamentos = leitor.ler(2);
        assertEquals(5, pagamentos.size());
    }

    @Test
    public void pagamentosDeJunho() throws IOException {
        LeitorCSV leitor = new LeitorCSV();
        List<Pagamento> pagamentos = leitor.ler(1);
        assertEquals(5, pagamentos.size());
    }

    @Test
    public void pagamentosDeMaio() throws IOException {
        LeitorCSV leitor = new LeitorCSV();
        List<Pagamento> pagamentos = leitor.ler(3);
        assertEquals(5, pagamentos.size());
    }
}