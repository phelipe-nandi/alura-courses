package br.com.alura.loja;

import br.com.alura.loja.orcamento.pedido.GeraPedido;
import br.com.alura.loja.orcamento.pedido.GeraPedidoHandler;
import br.com.alura.loja.orcamento.pedido.acao.EnviarEmailPedido;
import br.com.alura.loja.orcamento.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {

    public static void main(String[] args) {

        String cliente = "Phelipe";
        BigDecimal valorOrcamento = new BigDecimal("300");
        int quantidadeItens = Integer.parseInt("2");

        GeraPedido gerador = new GeraPedido(cliente, valorOrcamento, quantidadeItens);
        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(new SalvarPedidoNoBancoDeDados(), new EnviarEmailPedido())
        );
        handler.execute(gerador);
    }
}
