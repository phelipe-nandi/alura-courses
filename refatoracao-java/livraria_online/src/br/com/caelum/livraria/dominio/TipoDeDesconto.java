package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;

public enum TipoDeDesconto {
	
	CUPOM_DE_DESCONTO {
		@Override
		public Money getValor(Money subtotal) {
			return subtotal.subtract(subtotal.with(quantia -> quantia.subtract(Money.of(5, Livraria.reais))));
		}
	}, FIDELIDADE {
		private BigDecimal porcentagem(BigDecimal fatorDeCalculo) {
			return fatorDeCalculo.divide(BigDecimal.valueOf(100));
		}

		@Override
		public Money getValor(Money subtotal) {
			return subtotal.subtract(subtotal.with(quantia -> quantia.multiply(BigDecimal.ONE.subtract(porcentagem(new BigDecimal(10))))));
		}
	}, NENHUM {
		@Override
		public Money getValor(Money subtotal) {
			return Money.of(0, Livraria.reais);
		}
	};

	public abstract Money getValor(Money subtotal);
}