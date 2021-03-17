package br.com.alura.loja.orcamento.pedido.acao;

import br.com.alura.loja.orcamento.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {

    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando e-mail com dados do pedido");
    }
}
