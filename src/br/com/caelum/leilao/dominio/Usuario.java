package br.com.caelum.leilao.dominio;

public class Usuario {

	private int id;
	private String nome;
	
	public Usuario(String nome) {
		this(0, nome);
	}

	public Usuario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return this.id;
	}

	public String getNome() {
		return this.nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.id;
		result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (this.id != other.id)
			return false;
		if (this.nome == null) {
			if (other.nome != null)
				return false;
		} else if (!this.nome.equals(other.nome))
			return false;
		return true;
	}
	
}
