import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class FrameInternoImagem extends JInternalFrame implements ActionListener{

	//--------------------------------------------------------------------------------------
	//									ATRIBUTOS
	//--------------------------------------------------------------------------------------

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem mniSalvar,mniConvoluir,mniEscalar,mniEspelhar,mniRotacionar, mniEqualizar, mniMostrarElementosConexos, mniFechar, mniBinarizar, mniPimenta, mniSal, mniMedia, mniMediana, mniRestaurar;
	private JMenuBar mnbBarra;
	private JMenu mnuArquivo;
	private JPanel pnlDesenho, pnlOperacoes,pnlContainer;
	private ControlePrincipal controle;
	private MatrizImagem imagem;
	private MatrizImagem imagemOriginal;
	private Histograma pnlHistograma;
	private PainelInput pnlInput;
	private JPanel pnlAutoria;
	private String nomeDoArquivo;

	//--------------------------------------------------------------------------------------
	//									CONSTRUTOR
	//--------------------------------------------------------------------------------------
	public FrameInternoImagem(int linhas, int colunas){		
		/*
		super("Novo Arquivo",true,true,true,true);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
		arquivoImagem = new Arquivo();
		arquivoImagem.setNroLinhas(linhas);
		arquivoImagem.setNroColunas(colunas);
		montarBarra();

	    this.pnlContainer = new JPanel();
	    GridBagConstraints c = new GridBagConstraints();
	    pnlContainer.setLayout(new GridBagLayout());	    
	    montarPanelOperacoes(c);
	    montarMatriz(arquivoImagem, c);	    
	    this.add(pnlContainer);
	    this.setVisible(true);
	    controle = new ControlePrincipal(this);
	    this.controle = controle;
	    this.pnlContainer.setVisible(true);
		 */
	}

	public FrameInternoImagem(Arquivo arquivoImagem){
		/*
		super(arquivoImagem.getNomeDoArquivo(),true,true,true,true);	
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
		this.arquivoImagem = arquivoImagem;
		montarBarra();	

	    this.pnlContainer = new JPanel();
	    GridBagConstraints c = new GridBagConstraints();	    
	    pnlContainer.setLayout(new GridBagLayout());	    
	    montarPanelOperacoes(c);
	    montarMatriz(arquivoImagem,c);
	    this.add(pnlContainer);	    
	    this.setVisible(true);
	    controle = new ControlePrincipal(this);
	    this.controle = controle;
	    this.pnlContainer.setVisible(true);
		 */
	}

	public FrameInternoImagem(String nomeDoArquivo, MatrizImagem imagem){

		super(nomeDoArquivo,true,true,true,true);	

		this.nomeDoArquivo = nomeDoArquivo;

		//Armazena imagem
		this.imagem = imagem;
		
		this.imagemOriginal = new MatrizImagem(this.imagem.getLinhas(),this.imagem.getColunas(),this.imagem.getNomeDoArquivo());
		
		this.imagemOriginal.setLinhas(this.imagem.getLinhas());
		this.imagemOriginal.setColunas(this.imagem.getColunas());
		this.imagemOriginal.setNomeDoArquivo(this.imagem.getNomeDoArquivo());
		
		for (int i = 0; i < imagem.getLinhas(); i++) {
			for (int j = 0; j < imagem.getColunas(); j++) {
				this.imagemOriginal.getMatrizPixels()[i][j] = new Pixel(i,j,this.imagem.getMatrizPixels()[i][j].getCor(),0);
			}
		}
		
		//Define controle do InternalFrame
		controle = new ControlePrincipal(this);

		//Cria Menu
		montarBarra();	

		//---Prepara paineis
		//Prepara painel Container
		this.pnlContainer = new JPanel();
		pnlContainer.setLayout(new GridBagLayout());

		//Seta painel Desenho
		pnlDesenho = new JPanel();
		pnlDesenho.setBackground(Color.white);
		pnlDesenho.setLayout(new GridLayout(1,1));
		pnlDesenho.add(imagem);

		//Adiciona painel de Desenho
		GridBagConstraints c = new GridBagConstraints(); 

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 480;
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.pnlContainer.add(pnlDesenho,c);


		//---Seta painel Operacoes
		this.pnlInput = new PainelInput();

		this.pnlHistograma = new Histograma(7,controle.geraHistograma(imagem, 7));

		this.pnlAutoria = new JPanel(new GridLayout(3,1));
		this.pnlAutoria.setBackground(new Color(20,180,180));
		this.pnlAutoria.add(new JLabel("   Andr� Carvalho Silveira, 12616"));
		this.pnlAutoria.add(new JLabel("   Heron Yugo Inouye, 11877"));
		this.pnlAutoria.add(new JLabel("   CCO810 - Processamento Digital de Imagens"));

		this.pnlOperacoes = new JPanel();		
		this.pnlOperacoes.setBackground(Color.lightGray);
		this.pnlOperacoes.setLayout(new GridLayout(1,3));
		this.pnlOperacoes.add(pnlAutoria);
		this.pnlOperacoes.add(pnlInput);		
		this.pnlOperacoes.add(pnlHistograma);

		//Adiciona painel Operacoes
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 80;		
		c.anchor = GridBagConstraints.PAGE_END;		
		c.gridx = 0;
		c.gridy = 1;
		this.pnlContainer.add(this.pnlOperacoes,c);		

		//---Adiciona paineis no Frame
		this.setLayout(new GridLayout(1,1));
		this.add(pnlContainer);

		//Seta propriedades do IntenalFrame
		this.setVisible(true);
	}


	//--------------------------------------------------------------------------------------
	//									METODOS
	//--------------------------------------------------------------------------------------
	private void montarBarra(){
		//Criando a barra de menu para operacoes sobre a matriz
		mnbBarra = new JMenuBar();
		mnuArquivo = new JMenu("Arquivo");

		mniSalvar = new JMenuItem("Salvar");
		mniConvoluir = new JMenuItem("Convoluir");
		mniEscalar = new JMenuItem("Zoom");
		mniEspelhar = new JMenuItem("Espelhar");
		mniRotacionar = new JMenuItem("Rotacionar");
		mniEqualizar = new JMenuItem("Equalizar");
		mniPimenta = new JMenuItem("Pimenta");
		mniSal = new JMenuItem("Sal");
		mniMedia = new JMenuItem("Filtro M�dia");
		mniMediana = new JMenuItem("Filtro Mediana");
		mniRestaurar = new JMenuItem("Restaurar imagem original");
		mniMostrarElementosConexos = new JMenuItem("Mostrar Elementos Conexos");
		mniMostrarElementosConexos.setEnabled(false);
		mniFechar = new JMenuItem("Fechar");
		mniFechar.setEnabled(false);
		mniBinarizar = new JMenuItem("Binarizar");		


		mniSalvar.addActionListener(this);
		mniFechar.addActionListener(this);		
		mniConvoluir.addActionListener(this);
		mniEscalar.addActionListener(this);
		mniEspelhar.addActionListener(this);
		mniRotacionar.addActionListener(this);
		mniEqualizar.addActionListener(this);
		mniPimenta.addActionListener(this);
		mniSal.addActionListener(this);
		mniMedia.addActionListener(this);
		mniMediana.addActionListener(this);
		mniRestaurar.addActionListener(this);
		mniMostrarElementosConexos.addActionListener(this);
		mniBinarizar.addActionListener(this);

		mnuArquivo.add(mniBinarizar);
		mnuArquivo.add(mniConvoluir);
		mnuArquivo.add(mniEscalar);
		mnuArquivo.add(mniEspelhar);
		mnuArquivo.add(mniRotacionar);
		mnuArquivo.add(mniEqualizar);
		mnuArquivo.add(mniSal);
		mnuArquivo.add(mniPimenta);
		mnuArquivo.add(mniMedia);
		mnuArquivo.add(mniMediana);
		//mnuArquivo.add(mniMostrarElementosConexos);
		mnuArquivo.addSeparator();
		mnuArquivo.add(mniRestaurar);
		//mnuArquivo.addSeparator();
		//mnuArquivo.add(mniSalvar);		
		//mnuArquivo.add(mniFechar);

		mnbBarra.add(mnuArquivo);		
		this.setJMenuBar(mnbBarra);
	}


	/*
	===================================================
	N�O APAGAR : 		    at� o fechamento do projeto
	===================================================
	private void montarMatriz(Arquivo arquivoDeImagem,GridBagConstraints c){		
		pnlDesenho = new JPanel();
		pnlDesenho.setBackground(Color.WHITE);

		//pnlDesenho.setLayout(new GridLayout(0,0));
		//---Prepara paineis carregando dados do arquivo
		if(arquivoDeImagem.getNomeDoArquivo()!=null){			
			this.matrizBotoes = geraPainelMatriz(new int[arquivoDeImagem.getNroLinhas()][arquivoDeImagem.getNroColunas()],arquivoDeImagem.getNroLinhas() , arquivoDeImagem.getNroColunas());

		}
		//---Prepara paineis criando nova matriz
		else{
			int linhas = arquivoDeImagem.getNroLinhas();
			int colunas = arquivoDeImagem.getNroColunas();
			int[][] matrizImagem = new int[linhas][colunas];

			for (int i = 0; i < linhas; i++) {
				for (int j = 0; j < colunas; j++) {
					matrizImagem[i][j] = 0;
				}				
			}
			matrizBotoes = geraPainelMatriz(matrizImagem,linhas, colunas);
			//controle = new ControlePrincipal(matrizImagem,linhas,colunas);			
		}
		//pnlDesenho.add(this.matrizBotoes);
		JPanel pnlContainerDesenho = new JPanel();
		pnlContainerDesenho.setBackground(Color.lightGray);
		//pnlContainerDesenho.add(pnlDesenho);
		pnlContainerDesenho.add(this.matrizBotoes);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 1;

		c.ipadx = 750;  
		c.ipady = 600;
		this.pnlContainer.add(pnlContainerDesenho, c);
		//this.add(pnlDesenho,BorderLayout.EAST);		
	}
	 */


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==mniSalvar){
			/*
			//Se o nome do arquivo==null, ele � novo 
			if(this.nomeDoArquivo == ""){
				String nomeArquivo = JOptionPane.showInputDialog(null,"Digite o nome do arquivo:");				
				arquivoImagem = new Arquivo(nomeArquivo);
				arquivoImagem.gravarNoArquivo(matrizBotoes.getOrdemLinhas(),matrizBotoes.getOrdemColunas(),matrizBotoes,nomeArquivo);
				this.setName(nomeArquivo);
				this.setTitle(nomeArquivo);
			}
			 */
			if(this.nomeDoArquivo!="") {
				Date data = new Date();
				String strData = new String("_"+data.getYear()+"-"+data.getMonth()+"-"+data.getDay()+"-"+data.getHours()+"-"+data.getMinutes()+"-"+data.getSeconds());
				String nomeDoArquivoResultado = "resultado_"+this.nomeDoArquivo+strData+".txt";
				Arquivo gerenciadorDeArquivo = new Arquivo(nomeDoArquivoResultado);

				gerenciadorDeArquivo.gravarNoArquivo(this.imagem.getLinhas(),this.imagem.getColunas(),this.imagem,nomeDoArquivoResultado);
			}
		}

		else if(e.getSource()==mniConvoluir){
			this.imagem.setValorDaMatrizPixels(controle.convoluir(this.imagem,"mascara1.txt"));

			pnlHistograma.setNroDeFaixas(7);
			pnlHistograma.setFaixa(controle.geraHistograma(imagem, 7));
			pnlHistograma.repaint();

			this.imagem.repaint();
		}

		else if(e.getSource()==mniEscalar){
			String resposta = JOptionPane.showInputDialog("Insira um valor para o escalamento.\nAten��o, valores acima de 3 exigem v�rios segundos de processamento:");
			if(resposta!=null){
				try{
					int zoom = Integer.parseInt(resposta);

					if(zoom<0){
						JOptionPane.showMessageDialog(null, "O valor do zoom tem que ser positivo.");
					}
					else{
						this.imagem.setValorDaMatrizPixels(controle.escalar(this.imagem,zoom));
						this.imagem.repaint();
					}
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "O valor de zoom deve ser inteiro e positivo");
				}				
			}
		}

		else if(e.getSource()==mniEspelhar){			
			this.imagem.setValorDaMatrizPixels(controle.espelhar("imagem2.cab",this.imagem));
			this.imagem.repaint();
		}

		else if(e.getSource()==mniRotacionar){
			String resposta = JOptionPane.showInputDialog("Insira um valor para o escalamento.\nAten��o, valores acima de 3 exigem v�rios segundos de processamento:");
			if(resposta!=null){
				try{
					int angulo = Integer.parseInt(resposta);
					this.imagem.setValorDaMatrizPixels(controle.rotacionar(this.imagem,Math.toRadians((float)angulo)));

					pnlHistograma.setNroDeFaixas(7);
					pnlHistograma.setFaixa(controle.geraHistograma(imagem, 7));
					pnlHistograma.repaint();

					this.imagem.repaint();
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "O valor da rota��o deve ser dado em graus.");
				}
			}
		}

		else if(e.getSource()==mniBinarizar || e.getSource()==pnlInput.getSlider()){			
			this.imagem.setLimiar(pnlInput.getSlider().getValue());
			this.imagem.setValorDaMatrizPixels(controle.getImagemLimiarizada(this.imagem));

			pnlHistograma.setNroDeFaixas(7);
			pnlHistograma.setFaixa(controle.geraHistograma(imagem, 7));
			pnlHistograma.repaint();

			imagem.repaint();
		}

		else if(e.getSource()==mniEqualizar){
			pnlHistograma.setNroDeFaixas(7);
			pnlHistograma.setFaixa(controle.equalizar(imagem, 7, pnlHistograma.getFaixa()));
			pnlHistograma.repaint();
			imagem.repaint();
		}

		else if(e.getSource()==mniPimenta){
			String resposta = JOptionPane.showInputDialog("N�mero de pontos:");
			try{
				int numero = Integer.parseInt(resposta);
				this.imagem.setValorDaMatrizPixels(controle.pimenta(imagem, numero));

				pnlHistograma.setNroDeFaixas(7);
				pnlHistograma.setFaixa(controle.geraHistograma(imagem, 7));
				pnlHistograma.repaint();

				this.imagem.repaint();
			}
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "O valor do n�mero de pontos deve ser positivo e inteiro.");
			}
		}		

		else if(e.getSource()==mniSal){
			String resposta = JOptionPane.showInputDialog("N�mero de pontos:");
			try{
				int numero = Integer.parseInt(resposta);
				this.imagem.setValorDaMatrizPixels(controle.sal(imagem, numero));

				pnlHistograma.setNroDeFaixas(7);
				pnlHistograma.setFaixa(controle.geraHistograma(imagem, 7));
				pnlHistograma.repaint();

				this.imagem.repaint();
			}
			catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "O valor do n�mero de pontos deve ser positivo e inteiro.");
			}
		}		

		else if(e.getSource()==mniMedia){
			this.imagem.setValorDaMatrizPixels(controle.media(imagem, "media.txt"));

			pnlHistograma.setNroDeFaixas(7);
			pnlHistograma.setFaixa(controle.geraHistograma(this.imagem,7));
			pnlHistograma.repaint();

			this.imagem.repaint();
		}		

		else if(e.getSource()==mniMediana){
			this.imagem.setValorDaMatrizPixels(controle.mediana(imagem, "media.txt"));

			pnlHistograma.setNroDeFaixas(7);
			pnlHistograma.setFaixa(controle.geraHistograma(this.imagem,7));
			pnlHistograma.repaint();

			this.imagem.repaint();
		}		

		else if(e.getSource()==mniRestaurar){
			this.imagem.setValorDaMatrizPixels(this.imagemOriginal);

			pnlHistograma.setNroDeFaixas(7);
			pnlHistograma.setFaixa(controle.geraHistograma(this.imagem,7));
			pnlHistograma.repaint();

			this.imagem.repaint();
		}		

		else if(e.getSource()==mniMostrarElementosConexos){
			//controle.rotular("imagem1.txt"); 
		}

		else if(e.getSource()==mniFechar){
			//TODO 
		}	
	}
}
