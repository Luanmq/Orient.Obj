package control;

import java.util.ArrayList;
import model.*;

/**
 * Realiza a inst�ncia��o da classe Dados que ser� utiliada no programa e manupila��o de dados
 * @author Luan Melo
 * @author Lucas
 */

public class ControleDados {

    private static Dados dados = new Dados();

    /**
     * Construtor do ControleDados, inicializa o Dados d, com a fun��o precadastros 
     */
    public ControleDados() {
        dados.precadastros();
    }

    //Gets e sets
    public static Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        ControleDados.dados = dados;
    }

    public Usuario getUsuarioPrincipal() {
        return ControleDados.dados.getUsuarioPrincipal();
    }

    public ArrayList<Usuario> getUsuarios() {
        return ControleDados.dados.getUsuarios();
    }

    public ArrayList<Acessorio> getAcessoriosComprados() {
        return ControleDados.dados.getAcessoriosComprados();
    }

    public ArrayList<Roupa> getRoupasCompradas() {
        return ControleDados.dados.getRoupasCompradas();
    }

    public ArrayList<Acessorio> getAcessoriosAVenda() {
        return ControleDados.dados.getAcessoriosAVenda();
    }

    public ArrayList<Roupa> getRoupasAVenda() {
        return ControleDados.dados.getRoupasAVenda();
    }

}