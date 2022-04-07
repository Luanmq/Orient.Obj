package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.ControleAcessorio;
import control.ControleDados;
import control.ControleRoupa;
import control.ControleUsuario;

import model.Acessorio;
import model.Roupa;
import model.Usuario;
/**
 * Tela respons�vel por mostrar os detalhes dos Produtos
 * @author Luan Melo
 * @author Lucas
 * @param janela JFrame que representa a Tela a ser executada
 * @param labelNome JLabel usado para mostrar o nome de algum produto
 * @param valorNome JTextField usado para mostrar o nome cadastrado
 * @param labelDepartamento JLabel usado para mostrar o departamento de algum produto
 * @param departamentos String com os tipos de departamentos poss�veis no sistema
 * @param comboboxDepartamento Combobox com os tipos de departamentos
 * @param labelDescricao JLabel usado para mostrar a descri��o de algum produto
 * @param valorDescricao JTextField usado para mostrar a descri��o cadastrada
 * @param labelMarca JLabel usado para mostrar a marca de algum produto
 * @param valorMarca JTextField usado para mostrar a marca cadastrada
 * @param labelPreco JLabel usado para mostrar o pre�o de algum produto
 * @param valorPreco JTextField usado para mostrar o pre�o cadastrado
 * @param labelCondicao JLabel usado para mostrar a condi��o de algum produto
 * @param condicao String com os tipos de condi��es poss�veis no sistema
 * @param comboboxCondicao Combobox com os tipos de condi��es
 * @param labelCor JLabel usado para mostrar a cor de algum produto
 * @param valorCor JTextField usado para mostrar a cor cadastrada
 * @param labelMaterial JLabel usado para mostrar o material de algum Acess�rio
 * @param valorMaterial JTextField usado para mostrar o material cadastrado
 * @param labelPeso JLabel usado para mostrar o peso de algum Acess�rio
 * @param valorPeso JTextField usado para mostrar o peso cadastrado
 * @param labelMedida JLabel usado para mostrar a medida de algum Acess�rio
 * @param valorMedidaLargura JTextField usado para mostrar a largura de alguma Acess�rio
 * @param labelTamanho JLabel usado para mostrar o tamanho de alguma Roupa
 * @param tamanhos String com os tipos de tamanhos poss�veis de Roupa no sistema
 * @param comboboxTamanho Combobox com os diferentes tamanhos
 * @param labelTecido JLabel usado para mostrar a tecido de alguma Roupa
 * @param valorTecido JTextField usado para mostrar o tecido de alguma Roupa
 * @param labelEstampa JLabel usado para mostrar a estampa de alguma Roupa
 * @param valorEstampa JTextField usado para mostrar a estampa de alguma Roupa
 * 
 * @param novoDado Array de String para armazenar os valores dos Produtos e utilizar no Cadastro e valida��es
 * @param dados Inst�ncia de Controle de Dados utilizada para o acesso das mesmas informa��es em todo sistema. A inst�ncia tem o seu valor substitu�do por de outra inst�ncia j� utilizada no c�digo
 * @param imagem JLabel que representa a imagem dos produtos no sistema
 * 
 * @param botaoComprarAcessorio JButton respons�vel por chamar o m�todo adicionarAcessorioNaSacola passando a posi��o do 
 * 		Acess�rio no Array de Acess�rios � Venda.
 * @param botaoComprarRoupa As a��es realizadas por esse bot�o s�o as mesmas de botaoComprarAcessorio,
 * 		por�m as a��es s�o feitas com uma Roupa.
 * @param botaoExcluirAcessorio JButton respons�vel por chamar o m�todo excluirAcessorio passando a posi��o do
 * 		Acess�rio no Array de Acess�rios � Venda.
 * @param botaoExcluirRoupa As a��es realizadas por esse bot�o s�o as mesmas de botaoExcluirAcessorio,
 * 		por�m as a��es s�o feitas com uma Roupa.
 * @param botaoSalvarAcessorio JButton respons�vel pela edi��o dos dados. Ao apertar esse bot�o os valores dos JTextFields s�o passados para as posi��es
 * 		do Array novoDados.Com o Array cheio, � chamado o m�todo salvarAcessorio, que � respons�vel pela
 * 		mudan�a de dados de um Acess�rio, passando novoDados como par�metro e o Usu�rio que cadastrou o produto. O m�todo salvarAcessorio retorna true ou false informando se os valores inseridos foram v�lidos ou n�o.
 * @param botaoSalvarRoupa As a��es realizadas por esse bot�o s�o as mesmas de botaoSalvarAcessorio,
 * 		por�m as a��es s�o feitas com uma Roupa.
 * @param botaoCadastrarAcessorio JButton respons�vel pelo cadastro dos dados. Ao apertar esse bot�o os valores dos JTextFields s�o passados para as 
 * 		posi��es do Array novoDados. Com o Array cheio, � chamado o m�todo cadastrarAcessorio,
 * 		que � respons�vel pelo cadastro de um Acess�rio, passando novoDados como par�metro.
 * @param botaoCadastrarRoupa As a��es realizadas por esse bot�o s�o as mesmas de botaoCadastrarAcessorio,
 * 		por�m as a��es s�o feitas com uma Roupa.
 */
public class TelaDetalheProduto implements ActionListener {
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelDepartamento = new JLabel("Departamento: ");
	String departamentos[] = {"Masculino", "Feminino", "Infantil", "Unissex"};
	private JComboBox comboboxDepartamento;
	private JLabel labelDescricao = new JLabel("Descricao: ");
	private JTextField valorDescricao;
	private JLabel labelMarca = new JLabel("Marca: ");
	private JTextField valorMarca;
	private JLabel labelPreco = new JLabel("Preco(R$): ");
	private JTextField valorPreco;//
	private JLabel labelCondicao = new JLabel("Condicao: ");
	private String condicao[] = {"Ruim", "Neutra", "Boa", "Otima"};
	private JComboBox comboboxCondicao;
	private JLabel labelCor = new JLabel("Cor: ");
	private JTextField valorCor;
	private JLabel labelMaterial = new JLabel("Material: ");
	private JTextField valorMaterial;
	private JLabel labelPeso = new JLabel("Peso(g): ");
	private JTextField valorPeso;
	private JLabel labelMedida = new JLabel("Medida(largura/altura): ");
	private JTextField valorMedidaLargura;
	private JTextField valorMedidaAltura;
	private JLabel labelTamanho = new JLabel("Tamanho(P/M/G): ");
	private String tamanhos[] = {"PP", "P", "M", "G", "GG"};
	private JComboBox comboboxTamanho;
	private JLabel labelTecido = new JLabel("Tecido: ");
	private JTextField valorTecido;
	private JLabel labelEstampa = new JLabel("Estampa: ");
	private JTextField valorEstampa;
	
	private JButton botaoComprarAcessorio = new JButton("Comprar");
	private JButton botaoExcluirAcessorio = new JButton("Excluir");
	private JButton botaoSalvarAcessorio = new JButton("Salvar");
	private JButton botaoCadastrarAcessorio = new JButton("Cadastrar");
	
	private JButton botaoComprarRoupa= new JButton("Comprar");
	private JButton botaoExcluirRoupa = new JButton("Excluir");
	private JButton botaoSalvarRoupa = new JButton("Salvar");
	private JButton botaoCadastrarRoupa = new JButton("Cadastrar");

	private String[] novoDado = new String[9];
	private ControleDados dados;
	
	private JLabel imagem = new JLabel();

	int pos;
	
	/**
	 * M�todo respons�vel por selecionar qual tipo de Tela abrir
	 * @param d Inst�ncia de Controle de Dados j� usada em outra parte do c�digo
	 * @param opcaoAcessorioRoupa Inteiro que define se ser� uma tela de Acess�rio ou Roupa.
	 * (1) opcaoAcessorioRoupa = 1: Tela relacionada a Acess�rio.
	 * (2) opcaoAcessorioRoupa = 2: Tela relacionada a Roupa
	 * @param opcao Inteiro que define qual tipo de Tela ser� aberta.
	 * (1) opcao = 1: Cadastrar uma Roupa ou Acess�rio.
	 * (2) opcao = 2: Ver uma Roupa ou Acess�rio e adicionar na Sacola de Compras.
	 * (3) opcao = 3: Apenas ver uma Roupa ou Acess�rio.
	 * (4) opcao = 4: Editar ou excluir uma Roupa ou Acess�rio.
	 * (5) opcao = 5: Apenas ver uma Roupa comprada ou Acess�rio comprado
	 * @param posicaoProduto Posi��o de um Acess�rio no ArrayList de Acess�rios � Venda ou de uma Roupa no ArrayList de Roupas � Venda 
	 */
	public void cadastrarEditarProduto(ControleDados d, int opcaoAcessorioRoupa, int opcao, int posicaoProduto){
		dados = d;
		int opAcessorioRoupa = opcaoAcessorioRoupa;
		int op = opcao;
		pos = posicaoProduto;
		
		janela = new JFrame();
		
		//Acessorio
		if(opAcessorioRoupa == 1) {
			//Cadastrar acessorio
			if(op == 1) {
				String arquivo = ("img/Placeholder.png");
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				janela = new JFrame("Cadastro de Acessorio");

				valorNome = new JTextField(200);
				comboboxDepartamento = new JComboBox(departamentos);
				valorDescricao = new JTextField(200);
				valorMarca = new JTextField(200);
				valorPreco = new JTextField(10);
				comboboxCondicao = new JComboBox(condicao);
				valorCor = new JTextField(200);
				valorMaterial = new JTextField(200);
				valorPeso = new JTextField(10);
				valorMedidaLargura = new JTextField(10);
				valorMedidaAltura = new JTextField(10);

				botaoCadastrarAcessorio.setBounds(520, 320, 180, 25);
				this.janela.add(botaoCadastrarAcessorio);
			}
			
			//Ver acessorio a venda e Colocar na sacola
			if(op == 2) {
				String arquivo = dados.getAcessoriosAVenda().get(pos).getImagem();
				System.out.println(arquivo);
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
						        
				String nome_acessorio = dados.getAcessoriosAVenda().get(pos).getNome();
				janela = new JFrame(nome_acessorio);

				valorNome = new JTextField(dados.getAcessoriosAVenda().get(pos).getNome(),200);
				String departamento_cadastrado[] = {dados.getAcessoriosAVenda().get(pos).getDepartamento()};
				comboboxDepartamento =  new JComboBox(departamento_cadastrado);
				valorDescricao = new JTextField(dados.getAcessoriosAVenda().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getAcessoriosAVenda().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getAcessoriosAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				String condicao_cadastrada[] = {dados.getAcessoriosAVenda().get(pos).getCondicao()};
				comboboxCondicao =  new JComboBox(condicao_cadastrada);
				valorCor = new JTextField(dados.getAcessoriosAVenda().get(pos).getCor(),200);
				valorMaterial = new JTextField(dados.getAcessoriosAVenda().get(pos).getMaterial(),200);
				valorPeso = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getPeso()),10);
				valorMedidaLargura = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getMedidaLargura()),10);
				valorMedidaAltura = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getMedidaAltura()),10);

				botaoComprarAcessorio.setBounds(520, 320, 180, 25);
				this.janela.add(botaoComprarAcessorio);
			}
			
			//Ver acessorio
			if(op == 3) {
				String arquivo = dados.getAcessoriosAVenda().get(pos).getImagem();
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_acessorio = dados.getAcessoriosAVenda().get(pos).getNome();
				janela = new JFrame(nome_acessorio);

				valorNome = new JTextField(dados.getAcessoriosAVenda().get(pos).getNome(),200);
				String departamento_cadastrado[] = {dados.getAcessoriosAVenda().get(pos).getDepartamento()};
				comboboxDepartamento =  new JComboBox(departamento_cadastrado);
				valorDescricao = new JTextField(dados.getAcessoriosAVenda().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getAcessoriosAVenda().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getAcessoriosAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				String condicao_cadastrada[] = {dados.getAcessoriosAVenda().get(pos).getCondicao()};
				comboboxCondicao =  new JComboBox(condicao_cadastrada);
				valorCor = new JTextField(dados.getAcessoriosAVenda().get(pos).getCor(),200);
				valorMaterial = new JTextField(dados.getAcessoriosAVenda().get(pos).getMaterial(),200);
				valorPeso = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getPeso()),10);
				valorMedidaLargura = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getMedidaLargura()),10);
				valorMedidaAltura = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getMedidaAltura()),10);
			}
			
			//Editar ou excluir acessorio
			if(op == 4) {
				String arquivo = dados.getAcessoriosAVenda().get(pos).getImagem();
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_acessorio = dados.getAcessoriosAVenda().get(pos).getNome();
				janela = new JFrame(nome_acessorio);
				
				valorNome = new JTextField(dados.getAcessoriosAVenda().get(pos).getNome(),200);
				comboboxDepartamento = new JComboBox(departamentos);
				valorDescricao = new JTextField(dados.getAcessoriosAVenda().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getAcessoriosAVenda().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getAcessoriosAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				comboboxCondicao = new JComboBox(condicao);
				valorCor = new JTextField(dados.getAcessoriosAVenda().get(pos).getCor(),200);
				valorMaterial = new JTextField(dados.getAcessoriosAVenda().get(pos).getMaterial(),200);
				valorPeso = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getPeso()),10);
				valorMedidaLargura = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getMedidaLargura()),10);
				valorMedidaAltura = new JTextField(String.valueOf(dados.getAcessoriosAVenda().get(pos).getMedidaAltura()),10);
				
				botaoSalvarAcessorio.setBounds(520, 320, 90, 25);
				botaoExcluirAcessorio.setBounds(610, 320, 90, 25);
				this.janela.add(botaoSalvarAcessorio);
				this.janela.add(botaoExcluirAcessorio);
			}
			
			//Ver acessorio comprado
			if(op == 5) {
				String arquivo = dados.getAcessoriosComprados().get(pos).getImagem();
				System.out.println(arquivo);
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_acessorio = dados.getAcessoriosComprados().get(pos).getNome();
				janela = new JFrame(nome_acessorio);

				valorNome = new JTextField(dados.getAcessoriosComprados().get(pos).getNome(),200);
				String departamento_cadastrado[] = {dados.getAcessoriosComprados().get(pos).getDepartamento()};
				comboboxDepartamento =  new JComboBox(departamento_cadastrado);
				valorDescricao = new JTextField(dados.getAcessoriosComprados().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getAcessoriosComprados().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getAcessoriosAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				String condicao_cadastrada[] = {dados.getAcessoriosComprados().get(pos).getCondicao()};
				comboboxCondicao =  new JComboBox(condicao_cadastrada);
				valorCor = new JTextField(dados.getAcessoriosComprados().get(pos).getCor(),200);
				valorMaterial = new JTextField(dados.getAcessoriosComprados().get(pos).getMaterial(),200);
				valorPeso = new JTextField(String.valueOf(dados.getAcessoriosComprados().get(pos).getPeso()),10);
				valorMedidaLargura = new JTextField(String.valueOf(dados.getAcessoriosComprados().get(pos).getMedidaLargura()),10);
				valorMedidaAltura = new JTextField(String.valueOf(dados.getAcessoriosComprados().get(pos).getMedidaAltura()),10);
			}
			
			imagem.setBounds(20, 20, 330, 300);
			
			labelNome.setBounds(370, 20, 150, 25);
			valorNome.setBounds(520, 20, 180, 25);
			
			labelDepartamento.setBounds(370, 50, 150, 25);
			comboboxDepartamento.setBounds(520, 50, 180, 25);
			
			labelDescricao.setBounds(370, 80, 150, 25);
			valorDescricao.setBounds(520, 80, 180, 25);
			
			labelMarca.setBounds(370, 110, 150, 25);
			valorMarca.setBounds(520, 110, 180, 25);
			
			labelPreco.setBounds(370, 140, 150, 25);
			valorPreco.setBounds(520, 140, 180, 25);
			
			labelCondicao.setBounds(370, 170, 150, 25);
			comboboxCondicao.setBounds(520, 170, 180, 25);
			
			labelCor.setBounds(370, 200, 150, 25);
			valorCor.setBounds(520, 200, 180, 25);
			
			labelMaterial.setBounds(370, 230, 150, 25);
			valorMaterial.setBounds(520, 230, 180, 25);
			
			labelPeso.setBounds(370, 260, 150, 25);
			valorPeso.setBounds(520, 260, 180, 25);
			
			labelMedida.setBounds(370, 290, 150, 25);
			valorMedidaLargura.setBounds(520, 290, 90, 25);
			valorMedidaAltura.setBounds(610, 290, 90, 25);
			
			this.janela.add(imagem);
			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelDepartamento);
			this.janela.add(comboboxDepartamento);
			this.janela.add(labelDescricao);
			this.janela.add(valorDescricao);
			this.janela.add(labelMarca);
			this.janela.add(valorMarca);
			this.janela.add(labelPreco);
			this.janela.add(valorPreco);
			this.janela.add(labelCondicao);
			this.janela.add(comboboxCondicao);
			this.janela.add(labelCor);
			this.janela.add(valorCor);
			this.janela.add(labelMaterial);
			this.janela.add(valorMaterial);
			this.janela.add(labelPeso);
			this.janela.add(valorPeso);
			this.janela.add(labelMedida);
			this.janela.add(valorMedidaLargura);
			this.janela.add(valorMedidaAltura);
			
			this.janela.setLayout(null);
			
			this.janela.setSize(750, 400);
			this.janela.setVisible(true);
			
			botaoCadastrarAcessorio.addActionListener(this);
			botaoSalvarAcessorio.addActionListener(this);
			botaoExcluirAcessorio.addActionListener(this);
			botaoComprarAcessorio.addActionListener(this);
		
		//Roupa	
		}else if(opAcessorioRoupa == 2) {
			//Cadastrar roupa
			if(op == 1) {
				String arquivo = ("img/Placeholder.png");
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				janela = new JFrame("Cadastro de Roupa");

				valorNome = new JTextField(200);
				comboboxDepartamento = new JComboBox(departamentos);
				valorDescricao = new JTextField(200);
				valorMarca = new JTextField(200);
				valorPreco = new JTextField(10);
				comboboxCondicao = new JComboBox(condicao);
				valorCor = new JTextField(200);
				valorTecido = new JTextField(200);
				valorEstampa = new JTextField(200);
				comboboxTamanho = new JComboBox(tamanhos);

				botaoCadastrarRoupa.setBounds(520, 320, 180, 25);
				this.janela.add(botaoCadastrarRoupa);
			}
			
			//Ver roupa a venda e Comprar
			if(op == 2) {
				String arquivo = dados.getRoupasAVenda().get(pos).getImagem();
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_roupa = dados.getRoupasAVenda().get(pos).getNome();
				janela = new JFrame(nome_roupa);

				valorNome = new JTextField(dados.getRoupasAVenda().get(pos).getNome(),200);
				String departamento_cadastrado[] = {dados.getRoupasAVenda().get(pos).getDepartamento()};
				comboboxDepartamento =  new JComboBox(departamento_cadastrado);
				valorDescricao = new JTextField(dados.getRoupasAVenda().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getRoupasAVenda().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getRoupasAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				String condicao_cadastrada[] = {dados.getRoupasAVenda().get(pos).getCondicao()};
				comboboxCondicao =  new JComboBox(condicao_cadastrada);
				valorCor = new JTextField(dados.getRoupasAVenda().get(pos).getCor(),200);
				valorTecido = new JTextField(dados.getRoupasAVenda().get(pos).getTecido(),200);
				valorEstampa = new JTextField(dados.getRoupasAVenda().get(pos).getEstampa(),10);
				String tamanho_cadastrado[] = {dados.getRoupasAVenda().get(pos).getTamanho()};
				comboboxTamanho =  new JComboBox(tamanho_cadastrado);
				
				botaoComprarRoupa.setBounds(520, 320, 180, 25);
				this.janela.add(botaoComprarRoupa);
			}
			
			//Ver roupa
			if(op == 3) {
				String arquivo = dados.getRoupasAVenda().get(pos).getImagem();
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_roupa = dados.getRoupasAVenda().get(pos).getNome();
				janela = new JFrame(nome_roupa);

				valorNome = new JTextField(dados.getRoupasAVenda().get(pos).getNome(),200);
				String departamento_cadastrado[] = {dados.getRoupasAVenda().get(pos).getDepartamento()};
				comboboxDepartamento =  new JComboBox(departamento_cadastrado);
				valorDescricao = new JTextField(dados.getRoupasAVenda().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getRoupasAVenda().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getRoupasAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				String condicao_cadastrada[] = {dados.getRoupasAVenda().get(pos).getCondicao()};
				comboboxCondicao =  new JComboBox(condicao_cadastrada);
				valorCor = new JTextField(dados.getRoupasAVenda().get(pos).getCor(),200);
				valorTecido = new JTextField(dados.getRoupasAVenda().get(pos).getTecido(),200);
				valorEstampa = new JTextField(dados.getRoupasAVenda().get(pos).getEstampa(),10);
				String tamanho_cadastrado[] = {dados.getRoupasAVenda().get(pos).getTamanho()};
				comboboxTamanho =  new JComboBox(tamanho_cadastrado);
			}
			
			//Editar ou excluir roupa
			if(op == 4) {
				String arquivo = dados.getRoupasAVenda().get(pos).getImagem();
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_roupa = dados.getRoupasAVenda().get(pos).getNome();
				janela = new JFrame(nome_roupa);
				
				valorNome = new JTextField(dados.getRoupasAVenda().get(pos).getNome(),200);
				comboboxDepartamento = new JComboBox(departamentos);
				valorDescricao = new JTextField(dados.getRoupasAVenda().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getRoupasAVenda().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getRoupasAVenda().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				comboboxCondicao = new JComboBox(condicao);
				valorCor = new JTextField(dados.getRoupasAVenda().get(pos).getCor(),200);
				valorTecido = new JTextField(dados.getRoupasAVenda().get(pos).getTecido(),200);
				valorEstampa = new JTextField(dados.getRoupasAVenda().get(pos).getEstampa(),10);
				String tamanho_cadastrado[] = {dados.getRoupasAVenda().get(pos).getTamanho()};
				comboboxTamanho =  new JComboBox(tamanho_cadastrado);

				botaoSalvarRoupa.setBounds(520, 320, 90, 25);
				botaoExcluirRoupa.setBounds(610, 320, 90, 25);
				this.janela.add(botaoSalvarRoupa);
				this.janela.add(botaoExcluirRoupa);
			}
			
			//Ver roupa comprada
			if(op == 5) {
				String arquivo = dados.getRoupasCompradas().get(pos).getImagem();
				ImageIcon icon = new ImageIcon(arquivo);
				imagem = new JLabel(icon);
				
				String nome_roupa = dados.getRoupasCompradas().get(pos).getNome();
				janela = new JFrame(nome_roupa);

				valorNome = new JTextField(dados.getRoupasCompradas().get(pos).getNome(),200);
				String departamento_cadastrado[] = {dados.getRoupasCompradas().get(pos).getDepartamento()};
				comboboxDepartamento =  new JComboBox(departamento_cadastrado);
				valorDescricao = new JTextField(dados.getRoupasCompradas().get(pos).getDescricao(),200);
				valorMarca = new JTextField(dados.getRoupasCompradas().get(pos).getMarca(),200);
				String preco_cadastrado = Double.toString(dados.getRoupasCompradas().get(pos).getPreco());
				valorPreco = new JTextField(preco_cadastrado);
				String condicao_cadastrada[] = {dados.getRoupasCompradas().get(pos).getCondicao()};
				comboboxCondicao =  new JComboBox(condicao_cadastrada);
				valorCor = new JTextField(dados.getRoupasCompradas().get(pos).getCor(),200);
				valorTecido = new JTextField(dados.getRoupasCompradas().get(pos).getTecido(),200);
				valorEstampa = new JTextField(dados.getRoupasCompradas().get(pos).getEstampa(),10);
				String tamanho_cadastrado[] = {dados.getRoupasCompradas().get(pos).getTamanho()};
				comboboxTamanho =  new JComboBox(tamanho_cadastrado);
			}
			
			imagem.setBounds(20, 20, 330, 300);
			labelNome.setBounds(370, 20, 150, 25);
			valorNome.setBounds(520, 20, 180, 25);
			
			labelDepartamento.setBounds(370, 50, 150, 25);
			comboboxDepartamento.setBounds(520, 50, 180, 25);
			
			labelDescricao.setBounds(370, 80, 150, 25);
			valorDescricao.setBounds(520, 80, 180, 25);
			
			labelMarca.setBounds(370, 110, 150, 25);
			valorMarca.setBounds(520, 110, 180, 25);
			
			labelPreco.setBounds(370, 140, 150, 25);
			valorPreco.setBounds(520, 140, 180, 25);
			
			labelCondicao.setBounds(370, 170, 150, 25);
			comboboxCondicao.setBounds(520, 170, 180, 25);
			
			labelCor.setBounds(370, 200, 150, 25);
			valorCor.setBounds(520, 200, 180, 25);
			
			labelTecido.setBounds(370, 230, 150, 25);
			valorTecido.setBounds(520, 230, 180, 25);
			
			labelEstampa.setBounds(370, 260, 150, 25);
			valorEstampa.setBounds(520, 260, 180, 25);
			
			labelTamanho.setBounds(370, 290, 150, 25);
			comboboxTamanho.setBounds(520, 290, 180, 25);
			
			this.janela.add(imagem);
			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelDepartamento);
			this.janela.add(comboboxDepartamento);
			this.janela.add(labelDescricao);
			this.janela.add(valorDescricao);
			this.janela.add(labelMarca);
			this.janela.add(valorMarca);
			this.janela.add(labelPreco);
			this.janela.add(valorPreco);
			this.janela.add(labelCondicao);
			this.janela.add(comboboxCondicao);
			this.janela.add(labelCor);
			this.janela.add(valorCor);
			this.janela.add(labelTecido);
			this.janela.add(valorTecido);
			this.janela.add(labelEstampa);
			this.janela.add(valorEstampa);
			this.janela.add(labelTamanho);
			this.janela.add(comboboxTamanho);
			
			this.janela.setLayout(null);
			
			this.janela.setSize(750, 400);
			this.janela.setVisible(true);
			
			botaoCadastrarRoupa.addActionListener(this);
			botaoSalvarRoupa.addActionListener(this);
			botaoExcluirRoupa.addActionListener(this);
			botaoComprarRoupa.addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoCadastrarAcessorio) {
			novoDado[0] = valorNome.getText();
			novoDado[1] = comboboxDepartamento.getSelectedItem().toString();
			novoDado[2] = valorDescricao.getText();
			novoDado[3] = valorMarca.getText();
			novoDado[4] = valorPreco.getText();
			novoDado[5] = comboboxCondicao.getSelectedItem().toString();
			novoDado[6] = valorCor.getText();
			novoDado[7] = valorMaterial.getText();
			novoDado[8] = valorPeso.getText();
			novoDado[9] = valorMedidaLargura.getText();
			novoDado[10] = valorMedidaAltura.getText();
			Usuario user = dados.getUsuarioPrincipal();
	
			boolean auxiliar = new ControleAcessorio(dados).cadastrarAcessorio(novoDado, user);
			
			if(auxiliar == true) {
				mensagemSucessoCadastrar();	
				
			}else {
				mensagemErroSalvarAcessorio();
			}
		}
		
		if(src == botaoSalvarAcessorio) {
			novoDado[0] = valorNome.getText();
			novoDado[1] = comboboxDepartamento.getSelectedItem().toString();
			novoDado[2] = valorDescricao.getText();
			novoDado[3] = valorMarca.getText();
			novoDado[4] = valorPreco.getText();
			novoDado[5] = comboboxCondicao.getSelectedItem().toString();
			novoDado[6] = valorCor.getText();
			novoDado[7] = valorMaterial.getText();
			novoDado[8] = valorPeso.getText();
			novoDado[9] = valorMedidaLargura.getText();
			novoDado[10] = valorMedidaAltura.getText();
			Usuario user = dados.getUsuarioPrincipal();
	
			boolean auxiliar = new ControleAcessorio(dados).salvarAcessorio(novoDado, user, pos);
			
			if(auxiliar == true) {
				mensagemSucessoSalvar();	
				
			}else {
				mensagemErroSalvarAcessorio();
			}
		}
		
		if(src == botaoCadastrarRoupa) {			
				novoDado[0] = valorNome.getText();
				novoDado[1] = comboboxDepartamento.getSelectedItem().toString();
				novoDado[2] = valorDescricao.getText();
				novoDado[3] = valorMarca.getText();
				novoDado[4] = valorPreco.getText();
				novoDado[5] = comboboxCondicao.getSelectedItem().toString();
				novoDado[6] = valorCor.getText();
				novoDado[7] = comboboxTamanho.getSelectedItem().toString();
				novoDado[8] = (valorTecido.getText());
				novoDado[9] = (valorEstampa.getText());
				Usuario user = dados.getUsuarioPrincipal();
				
			boolean auxiliar = new ControleRoupa(dados).cadastrarRoupa(novoDado , user);
			
			if(auxiliar == true) {
				mensagemSucessoCadastrar();	
				
			}else {
				mensagemErroSalvarRoupa();
			}
		}
		
		if(src == botaoSalvarRoupa) {			
			novoDado[0] = valorNome.getText();
			novoDado[1] = comboboxDepartamento.getSelectedItem().toString();
			novoDado[2] = valorDescricao.getText();
			novoDado[3] = valorMarca.getText();
			novoDado[4] = valorPreco.getText();
			novoDado[5] = comboboxCondicao.getSelectedItem().toString();
			novoDado[6] = valorCor.getText();
			novoDado[7] = comboboxTamanho.getSelectedItem().toString();
			novoDado[8] = (valorTecido.getText());
			novoDado[9] = (valorEstampa.getText());
			Usuario user = dados.getUsuarioPrincipal();
			
			boolean auxiliar = new ControleRoupa(dados).salvarRoupa(novoDado , user, pos);
			
			if(auxiliar == true) {
				mensagemSucessoSalvar();	
				
			}else {
				mensagemErroSalvarRoupa();
			}
		}
		
		if(src == botaoExcluirAcessorio) {
			new ControleAcessorio(dados).excluirAcessorio(pos);
			mensagemSucessoExcluir();
		}
		
		if(src == botaoExcluirRoupa) {
			new ControleRoupa(dados).excluirRoupa(pos);
			mensagemSucessoExcluir();
		}
		
		if(src == botaoComprarAcessorio) {
			new ControleUsuario(dados).adicionarAcessorioNaSacola(dados.getAcessoriosAVenda().get(pos));
			mensagemSucessoSacola();
		}
		
		if(src == botaoComprarRoupa) {
			new ControleUsuario(dados).adicionarRoupaNaSacola(dados.getRoupasAVenda().get(pos));
			mensagemSucessoSacola();
		}
	}
	
	public void mensagemSucessoSacola() {
		JOptionPane.showMessageDialog(null, "O Produto foi adicionado na Sacola com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoCadastrar() {
		JOptionPane.showMessageDialog(null, "O Produto foi cadastrado com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoSalvar() {
		JOptionPane.showMessageDialog(null, "O Produto foi salvo com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoExcluir() {
		JOptionPane.showMessageDialog(null, "O Produto foi excluido com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroSalvarAcessorio() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Pode ter ocorrido um dos tres erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Preco, peso, medida da largura e a medida da altura nao contem apenas numeros \n"
				+ "3. Nome e cor nao contem apenas letras", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroSalvarRoupa() {
		JOptionPane.showMessageDialog(null,"Erro ao salvar os dados!\n "
				+ "Pode ter ocorrido um dos dois erros a seguir:  \n"
				+ "1. Nem todos os campos foram preenchidos \n"
				+ "2. Preco e peso devem conter apenas numeros", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
}