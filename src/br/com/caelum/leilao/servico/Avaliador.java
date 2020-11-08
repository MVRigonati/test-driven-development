package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

public class Avaliador {
	
	private double maiorValorLance;
	private double menorValorLance;
	private double valorMedioLances;
	private Leilao leilao;
	
	public Avaliador(final Leilao leilao) {
		this.leilao = leilao;
	}
	
	public void avalia() {
		
		if (this.leilao.getLances().size() == 0) {
			throw new RuntimeException("Leilao nao possui lances");
		}
		
		final int quantidadeLances = this.leilao.getLances().size();
		final Lance primeiroLeilao = this.leilao.getLances().get(0);
		this.maiorValorLance = primeiroLeilao.getValor();
		this.menorValorLance = primeiroLeilao.getValor();
		
		for (final Lance novoLance : this.leilao.getLances()) {
			double novoValorLance = novoLance.getValor(); 
			this.valorMedioLances += novoValorLance;
			
			if (this.maiorValorLance < novoValorLance)
				this.maiorValorLance = novoValorLance;
			if (this.menorValorLance > novoValorLance)
				this.menorValorLance = novoValorLance;
		}
		this.valorMedioLances = (this.valorMedioLances / quantidadeLances);

	}
	
	public double getMaiorValorLance() {
		return this.maiorValorLance;
	}
	
	public double getMenorValorLance() {
		return this.menorValorLance;
	}
	
	public double getValorMedioLances() {
		return this.valorMedioLances;
	}

}
