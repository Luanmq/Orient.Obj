package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ControleDados;
import control.ControleUsuario;

/**
 * Tela respons�vel por mostrar os Produtos na Sacola de Compras do Usu�rio
 * @author Luan Melo
 * @param janela JFrame que representa a Tela a ser executada
 * @param titulo JLabel usado para mostrar "Minha Sacola" na tela
 * @param listaNomesAcessoriosSacola Array de String respons�vel por guardar o nome dos Acess�rios na Sacola do Usu�rio
 * @param listaAcessoriosSacola JList respons�vel por receber o Array listaNomesAcessoriosSacola e mostrar na Tela
 * @param listaNomesRoupasSacola Array de String respons�vel por guardar o nome das Roupas na Sacola do Usu�rio
 * @param listaRoupasSacola JList respons�vel por receber o Array listaNomesRoupasSacola e mostrar na Tela
 * @param textoValorTotal usado para mostrar "Valor Total R$:" na tela
 * @param valorTotalSacola JTextField usado para mostrar a soma do pre�o de todos os Produtos na Sacola
 * 
 * @param retirarProduto JButton que quando apertado chama o m�todo retirarRoupaNaSacola e retirarAcessorioNaSacola,
 * 		passando como par�metro a posi��o do Acess�rio e da Roupa no Array de Sacola para Roupa e de Sacola para Acess�rio
 * @param esvaziarSacola JButton que quando apertado chama o m�todo esvaziarSacola
 * @param finalizarCompra JButton que quando apertado chama o m�todo finalizarCompra
 * @param dados Inst�ncia de Controle de Dados utilizada para o acesso das mesmas informa��es em todo sistema. A inst�ncia tem o seu valor substitu�do por de outra inst�ncia j� utilizada no c�digo
 */
public class TelaMinhaSacola implements ListSelectionListener, ActionListener{
	private JFrame janela = new JFrame("Minha Sacola");;
	private JLabel titulo = new JLabel("Minha Sacola");

	private JList<String> listaAcessoriosSacola = new JList<String>();
	private String[] listaNomesAcessoriosSacola = new String[1000];
	
	private JList<String> listaRoupasSacola = new JList<String>();
	private String[] listaNomesRoupasSacola = new String[1000];
	
	private JLabel textoValorTotal = new JLabel("Valor Total R$: ");
	private JTextField valorTotalSacola;
	private JButton retirarProduto = new JButton("Retirar Produto");
	private JButton esvaziarSacola = new JButton("Esvaziar Sacola");
	private JButton finalizarCompra = new JButton("Finalizar Compra");

	private ControleDados dados;
	
	/**
	 * Construtor da Tela Minha Sacola
	 * @param d Inst�ncia de Controle de Dados j� usada em outra parte do c�digo
	 */
	public TelaMinhaSacola(ControleDados d) {
		dados = d;
		int k = 0;
	    int l = 0;
	    
	    //Coloca todos os acessorios selecionados pelo usuario na sacola
    	for(int i = 0; i < dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().size(); i++){
    		listaNomesAcessoriosSacola[k] =  dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(i).getNome();
    		k++;
    	}
    	
    	//Coloca todos as roupas na selecionados pelo usuario sacola
    	for(int i = 0; i < dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().size(); i++){
    		listaNomesRoupasSacola[l] =  dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(i).getNome();
    		l++;
    	}
    	
    	listaAcessoriosSacola = new JList<String>(listaNomesAcessoriosSacola);
    	listaRoupasSacola = new JList<String>(listaNomesRoupasSacola);
		String valorTotal = Double.toString(dados.getUsuarioPrincipal().getSacolausuario().getValorTotal());
    	valorTotalSacola = new JTextField(valorTotal);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(130, 10, 250, 30);
				
		listaAcessoriosSacola.setBounds(20, 50, 350, 120);
		listaAcessoriosSacola.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaAcessoriosSacola.setVisibleRowCount(10);
	    
		listaRoupasSacola.setBounds(20, 180, 350, 120);
		listaRoupasSacola.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		listaRoupasSacola.setVisibleRowCount(10);
		
		retirarProduto.setBounds(20, 305, 170, 30);
		esvaziarSacola.setBounds(200, 305, 170, 30);
		
		textoValorTotal.setBounds(20, 340, 80, 30);
		valorTotalSacola.setBounds(110, 340, 80, 30);
		finalizarCompra.setBounds(200, 340, 170, 30);

	    janela.setLayout(null);
	    janela.add(titulo);
	    janela.add(listaAcessoriosSacola);
	    janela.add(listaRoupasSacola);
	    janela.add(retirarProduto);
	    janela.add(esvaziarSacola);
	    janela.add(textoValorTotal);
	    janela.add(valorTotalSacola);
	    janela.add(finalizarCompra);

		janela.setSize(400, 420);
		janela.setVisible(true);
		
		retirarProduto.addActionListener(this);
		esvaziarSacola.addActionListener(this);
		finalizarCompra.addActionListener(this);
		listaAcessoriosSacola.addListSelectionListener(this);
		listaRoupasSacola.addListSelectionListener(this);
	}
	
	//Detalhes dos produtos
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaAcessoriosSacola) {
			for(int i = 0; i < dados.getAcessoriosAVenda().size(); i++) {
				if(dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios()
				.get(listaAcessoriosSacola.getSelectedIndex()) == dados.getAcessoriosAVenda().get(i)) {
					new TelaDetalheProduto().cadastrarEditarProduto(dados, 1, 3, i);
					break;
				}
			}
		}
		
		if(e.getValueIsAdjusting() && src == listaRoupasSacola) {
			for(int j = 0; j < dados.getRoupasAVenda().size(); j++) {
				if(dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas()
				.get(listaRoupasSacola.getSelectedIndex()) == dados.getRoupasAVenda().get(j)) {
					new TelaDetalheProduto().cadastrarEditarProduto(dados, 2, 3, j);
					break;
				}
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == retirarProduto) {
			if(listaRoupasSacola.getSelectedIndex() != -1) {
				new ControleUsuario(dados).retirarRoupaNaSacola(dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaRoupas().get(listaRoupasSacola.getSelectedIndex()));
				mensagemSucessoRetirarAcessorio();
			}
			
			if(listaAcessoriosSacola.getSelectedIndex() != -1) {
				new ControleUsuario(dados).retirarAcessorioNaSacola(dados.getUsuarioPrincipal().getSacolausuario().getSacolaParaAcessorios().get(listaAcessoriosSacola.getSelectedIndex()));
				mensagemSucessoRetirarRoupa();
			}
		}
		
		if(src == esvaziarSacola) {
			new ControleUsuario(dados).esvaziarSacola();
			mensagemSucessoEsvaziar();
		}
		
		if(src == finalizarCompra) {
			new ControleUsuario(dados).finalizarCompra();
			mensagemSucessoFinalizarCompra();
		}
	}
	
	public void mensagemSucessoEsvaziar() {
		JOptionPane.showMessageDialog(null, "A Sacola foi esvaziada com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoRetirarAcessorio() {
		JOptionPane.showMessageDialog(null, "O Acessorio foi retirado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoRetirarRoupa() {
		JOptionPane.showMessageDialog(null, "A Roupa foi retirada com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoFinalizarCompra() {
		JOptionPane.showMessageDialog(null, "A Compra foi finalizada com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
}