package model;
/**
 * Classe que representa o Endere�o do Usu�rio
 * @author Luan Melo
 * @author Lucas
 */
public class Endereco {

	 private String pais;
	 private String estado;
	 private String cidade;
	 private long numeroResidencia;
	 private long cep;
	 private String referencia;
	 private Usuario usuario;
	
	 /**
	 * Construtor de Endereco
	 * @param usuario Usu�rio no qual ser� cadastrado
	 */
	public Endereco(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Construtor de Endereco, passando o dados para cadastro
	 * @param p pa�s 
	 * @param e estado
	 * @param c cidade
	 * @param l n�mero da resid�ncia
	 * @param m cep
	 * @param r refer�ncia
	 * @param user usu�rio
	 */
	public Endereco(String p, String e, String c, long l, long m, String r, Usuario user) {
		this.pais = p;
		this.estado = e;
		this.cidade = c;
		this.numeroResidencia = l;
		this.cep = m;
		this.referencia = r;
		this.usuario = user;
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