package br.com.caelum.leilao.servico;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {

	private Usuario joao;
	private Usuario jose;
	private Usuario maria;
	private Leilao leilao; 
	
	@Before
	public void before() {
		this.joao = new Usuario("Joao");
		this.jose = new Usuario("José");
		this.maria = new Usuario("Maria");
		
		this.leilao = new Leilao("Playstation 3 Novo");
	}
	
	@Test
	public void deveCalcularMaiorEMenorLance() {
        this.leilao.propoe(new Lance(this.maria, 258.63));
        this.leilao.propoe(new Lance(this.joao, 569.22));
        this.leilao.propoe(new Lance(this.jose, 137.46));

        final Avaliador leiloeiro = new Avaliador(this.leilao);
        leiloeiro.avalia();

        final double maiorEsperado = 569.22;
        final double menorEsperado = 137.46;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorValorLance(), 0.0001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorValorLance(), 0.0001);
	}
	
	@Test
	public void deveCalcularMediaDoValorDosLances() {
        this.leilao.propoe(new Lance(this.maria, 258.63));
        this.leilao.propoe(new Lance(this.joao, 569.22));
        this.leilao.propoe(new Lance(this.jose, 137.46));

        final Avaliador leiloeiro = new Avaliador(this.leilao);
        leiloeiro.avalia();

        final double mediaEsperada = 321.77;

        Assert.assertEquals(mediaEsperada, leiloeiro.getValorMedioLances(), 0.0001);
	}
	
}
