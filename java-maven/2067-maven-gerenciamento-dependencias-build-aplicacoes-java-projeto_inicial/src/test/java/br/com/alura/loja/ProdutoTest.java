package br.com.alura.loja;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ProdutoTest {

	@Test
	public void test() {
		Produto produto = new Produto("teste", BigDecimal.TEN);
		Assert.assertEquals("teste", produto.getNome());
		Assert.assertEquals(BigDecimal.TEN, produto.getPreco());
	}

}
