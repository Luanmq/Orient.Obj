package model;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Classe que representa a Sacola De Compra do Usu�rio do sistema
 * @author Luan Melo
 * @author Lucas
 * @param valorTotal Soma de todos os pre�os dos produtos na Sacola
 * @param SacolaParaRoupas ArrayList que possui a divis�o da Sacola de Compras para Roupas
 * @param SacolaParaAcess�rios ArrayList que possui a divis�o da Sacola de Compras para Acess�rios
 * @param usuarioComprador Usu�rio que est� comprando no sistema e utilizando a Sacola
 */
public class SacolaDeCompra {
	 Scanner ler = new Scanner(System.in);
	 
	 private double valorTotal;
	 private ArrayList<Roupa> SacolaParaRoupas = new ArrayList<>();
	 private ArrayList<Acessorio> SacolaParaAcessorios = new ArrayList<>();
	 private Usuario usuarioComprador;
	 
	 public SacolaDeCompra(Usuario usuario) {
			this.usuarioComprador = usuario;
	 }
	 
	//Gets e sets
	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public ArrayList<Roupa> getSacolaParaRoupas() {
		return SacolaParaRoupas;
	}

	public void setSacolaParaRoupas(ArrayList<Roupa> sacolaParaRoupas) {
		SacolaParaRoupas = sacolaParaRoupas;
	}

	public ArrayList<Acessorio> getSacolaParaAcessorios() {
		return SacolaParaAcessorios;
	}

	public void setSacolaParaAcessorios(ArrayList<Acessorio> sacolaParaAcessorios) {
		SacolaParaAcessorios = sacolaParaAcessorios;
	}

	public Usuario getUsuarioComprador() {
		return usuarioComprador;
	}

	public void setUsuarioComprador(Usuario usuarioComprador) {
		this.usuarioComprador = usuarioComprador;
	}
	 
	 
}