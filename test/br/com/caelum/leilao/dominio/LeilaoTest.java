package br.com.caelum.leilao.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

	private Leilao leilao;
	private Usuario usuario1;
	private Usuario usuario2;
	
	@Before
	public void before() {
		this.leilao = new Leilao("Primeiro Leilao");
		this.usuario1 = new Usuario("Marcus Vinicius");
		this.usuario2 = new Usuario("Vinicius Marcus");
	}
	
	@Test
	public void deveReceberUmLance() {
		this.leilao.propoe(new Lance(this.usuario1, 10));
		
		assertEquals(1, this.leilao.getLances().size());
		assertEquals(10, this.leilao.getUltimoLance().getValor());
	}
	
	@Test
	public void deveReceberMaisDeUmLance() {
		this.leilao.propoe(new Lance(this.usuario1, 10));
		this.leilao.propoe(new Lance(this.usuario2, 20));
		this.leilao.propoe(new Lance(this.usuario1, 30));
		
		assertEquals(3, this.leilao.getLances().size());
		assertEquals(10, this.leilao.getLances().get(0).getValor());
		assertEquals(20, this.leilao.getLances().get(1).getValor());
		assertEquals(30, this.leilao.getLances().get(2).getValor());
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		this.leilao.propoe(new Lance(this.usuario1, 10));
		this.leilao.propoe(new Lance(this.usuario1, 30));
		
		assertEquals(1, this.leilao.getLances().size());
		assertEquals(10, this.leilao.getUltimoLance().getValor());
	}
	
	@Test
	public void naoDeveAceitarMaisQueCincoLancesDoMesmoUsuario() {
		this.leilao.propoe(new Lance(this.usuario1, 10));
		this.leilao.propoe(new Lance(this.usuario2, 20));
		this.leilao.propoe(new Lance(this.usuario1, 30));
		this.leilao.propoe(new Lance(this.usuario2, 40));
		this.leilao.propoe(new Lance(this.usuario1, 50));
		this.leilao.propoe(new Lance(this.usuario2, 60));
		this.leilao.propoe(new Lance(this.usuario1, 70));
		this.leilao.propoe(new Lance(this.usuario2, 80));
		this.leilao.propoe(new Lance(this.usuario1, 90));
		this.leilao.propoe(new Lance(this.usuario2, 100));
		
		this.leilao.propoe(new Lance(this.usuario1, 110));
		
		assertEquals(10, this.leilao.getLances().size());
		assertEquals(100, this.leilao.getUltimoLance().getValor());
	}
	
	@Test
	public void deveFazerNovoLanceComODobroDoValorDoUltimoLanceDeUmUsuario() {
		this.leilao.propoe(new Lance(this.usuario1, 20));
		this.leilao.propoe(new Lance(this.usuario2, 30));
		this.leilao.propoe(new Lance(this.usuario1, 40));
		this.leilao.propoe(new Lance(this.usuario2, 50));
		
		this.leilao.dobraLance(this.usuario1);
		
		assertEquals(5, this.leilao.getLances().size());
		assertEquals(80, this.leilao.getUltimoLance().getValor());
	}
	
	@Test
	public void naoDeveDobrarLanceQuandoNaoHouverLanceDoUsuario() {
		this.leilao.propoe(new Lance(this.usuario2, 30));
		
		this.leilao.dobraLance(this.usuario1);
		
		assertEquals(1, this.leilao.getLances().size());
		assertEquals(30, this.leilao.getUltimoLance().getValor());
	}
	
}
