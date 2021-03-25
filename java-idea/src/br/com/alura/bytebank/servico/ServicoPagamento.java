package br.com.alura.bytebank.servico;

import br.com.alura.bytebank.model.Pagamento;
import br.com.alura.bytebank.registrador.RegistroDePagamento;
import br.com.alura.bytebank.validador.ValidaPagamento;

import java.util.List;

public class ServicoPagamento {

    RegistroDePagamento registroDePagamento = new RegistroDePagamento();

    public void registra(List<Pagamento> pagamentos) {
        ValidaPagamento validaPagamento = new ValidaPagamento();
        validaPagamento.verificaTipo(pagamentos);
        registroDePagamento.registra(pagamentos);
    }

    public void exibeEfetuados() {
        registroDePagamento.exibeEfetuados();
    }
}
