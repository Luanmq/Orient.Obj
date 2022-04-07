package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.ControleDados;
import control.ControleUsuario;

/**
 * Tela respons�vel pelo Login ou Cadastro de um Usu�rio
 * @author Lucas
 * @param janela JFrame que representa a Tela a ser executada
 * @param email JLabel usado para mostrar "Email" na tela
 * @param valorEmail JTextField usado para receber o email digitado
 * @param senha JLabel usado para mostrar "Senha" na tela
 * @param valorSenha JTextField usado para receber a senha digitada
 * 
 * @param logarUsuario JButton que quando apertado procura algum Usu�rio no programa com o mesmo email digitado
 * @param cadastrarUsuario JButton que chama o m�todo cadastrarEditarUsuario na forma de Cadastrar na Tela Detalhe Usuario
 * 
 * @param dados Inst�ncia de Controle de Dados utilizada para o acesso das mesmas informa��es em todo sistema. A inst�ncia tem o seu valor substitu�do por de outra inst�ncia j� utilizada no c�digo
 */
public class TelaLoginCadastroUsuario implements ActionListener{

	private JFrame janela = new JFrame("Login e Cadastro");
	private JLabel email = new JLabel("Email");
	private JTextField valorEmail = new JTextField(20);
	private JLabel senha = new JLabel("Senha");
	private JPasswordField valorSenha = new JPasswordField(20);
	private JButton logarUsuario  = new JButton ("Logar");
	private JButton cadastrarUsuario = new JButton("Cadastrar");
	
	public static ControleDados dados = new ControleDados();

	public TelaLoginCadastroUsuario() {
		email.setFont(new Font("Arial", Font.BOLD, 15));
		email.setBounds(10, 10, 80, 25);
		valorEmail.setBounds(100, 10, 160, 25);
		
		senha.setFont(new Font("Arial", Font.BOLD, 15));
		senha.setBounds(10, 40, 80, 25);
		valorSenha.setBounds(100, 40, 160, 25);
		
		logarUsuario.setBounds(95, 80, 80, 25);		
		cadastrarUsuario.setBounds(180, 80, 90, 25);
		
		janela.setLayout(null);
		janela.add(email);
		janela.add(valorEmail);
		janela.add(senha);
		janela.add(valorSenha);
		janela.add(logarUsuario);
		janela.add(cadastrarUsuario);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		janela.setBounds(600, 300, 300, 150);
		janela.setVisible(true);
		
		cadastrarUsuario.addActionListener(this);
		logarUsuario.addActionListener(this);
	}
	
	/**
	 * Fun��o main que inicializa a Tela de Login e Cadastro de Usuario
	 */
	public static void main(String[] args) {
		TelaLoginCadastroUsuario telaInicial = new TelaLoginCadastroUsuario();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo usuario
		if(src == cadastrarUsuario) {
			new TelaDetalheUsuario().cadastrarEditarUsuario(dados, 1);
		}
			
		int UsuarioSelecionado = -1;

		//Loga com um usuario
		if(src == logarUsuario) {
			//Procuro pelo usuario de email digitado
			for(int i = 0; i < dados.getUsuarios().size(); i++) {
				if( dados.getUsuarios().get(i).getEmail().equals(valorEmail.getText())) {
					UsuarioSelecionado = i;	
				}
			}
			
			if(UsuarioSelecionado != -1 && dados.getUsuarios().get(UsuarioSelecionado).getSenha().equals(valorSenha.getText())) {
				new ControleUsuario(dados).selecionaUsuarioPrincipal(dados.getUsuarios().get(UsuarioSelecionado));
				mensagemSucessoLogar();
				janela.dispose();
				TelaMenu menu = new TelaMenu(dados);
			}else {
				mensagemErroLogar();
			 }
		}
	}
	
	public void mensagemSucessoLogar() {
		JOptionPane.showMessageDialog(null, "O login foi feito com sucesso!\n Seja bem-vindo, " + dados.getUsuarioPrincipal().getNome(), null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemErroLogar() {
		JOptionPane.showMessageDialog(null, "O usuario ou senha esta incorreto", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
}
