package br.com.caelum.leilao.dominio;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		if (valor <= 0)
			throw new IllegalArgumentException("Valor do lance deve ser um numero positivo.");
			
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public double getValor() {
		return this.valor;
	}
	
}
