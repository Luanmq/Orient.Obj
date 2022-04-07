package model;
/**
 * Classe que representa o Endere�o do Usu�rio
 * @author Luan Melo
 * @param pais Pa�s do Usu�rio
 * @param estado Estado do Usu�rio
 * @param cidade Cidade do Usu�rio
 * @param numeroResidencia N�mero da Resid�ncia do Usu�rio
 * @param cep CEP do Usu�rio
 * @param referencia Refer�ncia para encontrar a resid�ncia do Usu�rio
 * @param usuario Usu�rio que possui o Endere�o
 */
public class Endereco {

	 private String pais;
	 private String estado;
	 private String cidade;
	 private long numeroResidencia;
	 private long cep;
	 private String referencia;
	 private Usuario usuario;
	
	public Endereco(Usuario usuario) {
		this.usuario = usuario;
	}

	public Endereco(String p, String e, String c, long l, long m, String r) {
		this.pais = p;
		this.estado = e;
		this.cidade = c;
		this.numeroResidencia = l;
		this.cep = m;
		this.referencia = r;
	}
	
	//Gets e sets
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public long getNumeroResidencia() {
		return numeroResidencia;
	}

	public void setNumeroResidencia(long numeroResidencia) {
		this.numeroResidencia = numeroResidencia;
	}

	public long getCep() {
		return cep;
	}

	public void setCep(long cep) {
		this.cep = cep;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	//Sobreescrita do toString para o print dos enderecos
	@Override
	public String toString() {
		return "Pais: " + pais + " | Estado: " + estado + " | Cidade: " + cidade + " | Numero da Residencia: " + 
	numeroResidencia + " | CEP: " + cep + " | Referencia: " + referencia;
	}	
	
}