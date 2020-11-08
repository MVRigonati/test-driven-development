package br.com.caelum.leilao.dominio;

import org.junit.Before;
import org.junit.Test;

public class LanceTest {
	
	private Usuario usuario;

	@Before
	public void before() {
		this.usuario = new Usuario("User");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoCriarLanceComValorZero() {
		new Lance(this.usuario, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoAoCriarLanceComValorMenorQueZero() {
		new Lance(this.usuario, -1);
	}

}
