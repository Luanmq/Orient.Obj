package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import control.ControleDados;

/**
 * Tela Menu usada para se acessar as diversas partes do sistema
 * @author Luan Melo
 * @author Lucas
 */
public class TelaMenu implements ActionListener{
	private static JFrame janela = new JFrame("Menu");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton verProdutosAVenda = new JButton("Comprar");
	private static JButton verMinhaConta = new JButton("Minha Conta");
	private static JButton verMeusProdutos = new JButton("Meus Produtos");
	private static JButton verMinhaSacola = new JButton("Sacola");
	private static JButton sair = new JButton("Sair");
	
	private ControleDados dados;
	
	/**
	 * Construtor da Tela Menu
	 * @param d Inst�ncia de Controle de Dados j� usada em outra parte do c�digo
	 */
	public TelaMenu(ControleDados d) {
		dados = d;
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(130, 10, 150, 30);
		verProdutosAVenda.setBounds(100, 50, 200, 30);
		verMinhaConta.setBounds(100, 100, 200, 30);
		verMeusProdutos.setBounds(100, 150, 200, 30);
		verMinhaSacola.setBounds(100, 200, 200, 30);
		sair.setBounds(100, 250, 200, 30);

		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(verProdutosAVenda);
		janela.add(verMinhaConta);
		janela.add(verMeusProdutos);
		janela.add(verMinhaSacola);
		janela.add(sair);
		
		verProdutosAVenda.addActionListener(this);
		verMinhaConta.addActionListener(this);
		verMeusProdutos.addActionListener(this);
		verMinhaSacola.addActionListener(this);
		sair.addActionListener(this);
		
		janela.setBounds(550, 250, 400, 350);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}	

	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == verProdutosAVenda)
			new TelaProdutosAVenda().produtosAVenda(dados);
		
		if(src == verMinhaConta)
			new TelaDetalheUsuario().cadastrarEditarUsuario(dados, 2);
		
		if(src == verMeusProdutos)
			new TelaMeusProdutos(dados);
		
		if(src == verMinhaSacola)
			new TelaMinhaSacola(dados);
		
		if(src == sair) {
			janela.dispose();
		}	
	}
	
	public static void dispose() {
		janela.dispose();
	}
}