package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(final String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(final Lance lance) {
		if (this.lances.size() == 0 || usuarioPodeAdicionarLance(lance.getUsuario())) {
			this.lances.add(lance);
		}
	}

	private boolean usuarioPodeAdicionarLance(final Usuario usuario) {
		return !getUltimoLance().getUsuario().equals(usuario)
				&& totalLancesDoUsuario(usuario) < 5;
	}

	private int totalLancesDoUsuario(final Usuario usuario) {
		final Long total = this.lances.stream()
				.filter(l -> l.getUsuario().equals(usuario))
				.count();
		
		return total.intValue();
	}

	public String getDescricao() {
		return this.descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(this.lances);
	}
	
	public Lance getUltimoLance() {
		Lance resultado = null;
		if (this.lances.size() > 0) {
			final int lastIndex = this.lances.size() - 1;
			resultado = this.lances.get(lastIndex);
		}
		return resultado;
	}

	public void dobraLance(final Usuario usuario) {
		Double ultimoLanceDoUsuario = null;
		
		for (final Lance lance : this.lances) {
			if (lance.getUsuario().equals(usuario))
				ultimoLanceDoUsuario = lance.getValor();
		}
		
		if (ultimoLanceDoUsuario != null)
			propoe( new Lance(usuario, (ultimoLanceDoUsuario * 2)) );
	}
	
}
