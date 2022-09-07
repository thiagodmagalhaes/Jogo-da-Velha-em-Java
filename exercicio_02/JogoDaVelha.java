package exercicio_02;

/*
 * A CLASSE JOGO DA VELHA POSSUI UMA MATRIZ INTEIRO QUADRADA 3x3 REPRESENTANDO O JOGO, A GRADE DO JOGO
 * ELA POSSUI UMA VARIAVEL INTEIRO QUE GUARDA QUAL JOGADOR ESTA JOGANDO
 * POSSUI OUTRA VARIAVEL INTEIRO QUE CONTA TODAS JOGADAS DO JOGO
 * POSSUI UMA VARIAVEL EM BOOLEAN QUE VERIFICA SE A POSICAO QUE DESEJA JOGAR ESTA LIVRE
 * DUAS STRINGS PARA ARMAZENAR OS NOMES DOS 2 JOGADORES
 */
public class JogoDaVelha {
	
	private int [][]grade = new int[3][3];
	private int jogador;
	private int jogada=1;
	private boolean verificaCasa;
	private String jogador_um;
	private String jogador_dois;
	
	// METODO CONSTRUTOR DO JOGO DA VELHA QUE REALIZA A CHAMADA PARA OUTRO METODO INICIAR O JOGO
	public JogoDaVelha(String jogador_um, String jogador_dois) {
		iniciaJogo(jogador_um, jogador_dois);
	}
	//ESTE METODODO INCIA O JOGO, ZERANDO TODAS AS CASAS DA MATRIZ grade[][] E GUARDANDO O NOME DOS JOGADORES
	public void iniciaJogo(String jogador_um, String jogador_dois)
	{
		setJogador_um(jogador_um);
		setJogador_dois(jogador_dois);
		int i;
		// LAÇO DE REPETIÇAO RESPONSAVEL POR ZERAR CADA CASA DA MATRIZ QUE REPRESENTA O JOGO
		for(i=1; i<=9; i++) {
			setGrade(i,0);
		}
		// DEPOIS DE ZERAR A MATRIZ SERA IMPRESSO A GRADE DO JOGO ATRAVES DO METODO getGrade()
		System.out.println(getGrade(0));
	}
	
	// METODO setGrade() RESPONSAVEL POR INSERIR O JOGADOR NA POSICAO DESEJADA, PARA MATRIZ QUE REPRESENTA O JOGO
	public void setGrade(int posicao, int jogador)
	{
		if(posicao==9) {
			this.grade[0][2] = jogador;
		}
		else if(posicao==8)
			this.grade[0][1] = jogador;
		else if(posicao==7)
			this.grade[0][0] = jogador;
		else if(posicao==6)
			this.grade[1][2] = jogador;
		else if(posicao==5)
			this.grade[1][1] = jogador;
		else if(posicao==4)
			this.grade[1][0] = jogador;
		else if(posicao==3)
			this.grade[2][2] = jogador;
		else if(posicao==2)
			this.grade[2][1] = jogador;
		else if(posicao==1)
			this.grade[2][0] = jogador;
	}
	
	// METODO RESPONSAVEL POR VERIFICAR SE A POSICAO SE ENCONTRA VAZIA (0), RETORNA TRUE SE ESTIVER E FALSE SE NAO ESTIVER VAZIA
	public boolean verifica_Jogada(int posicao) {
		if(posicao==9) {
			if(this.grade[0][2]==0)
				return true;
			else
				return false;
		}
	
		else if(posicao==8) {
			if(this.grade[0][1]==0)
				return true;
			else
				return false;
		}
		
		else if(posicao==7) {
			if(this.grade[0][0] == 0)
				return true;
			else
				return false;
		
		}
		else if(posicao==6) {
			if(this.grade[1][2] == 0)
				return true;
			else
				return false;
			
		}
		else if(posicao==5) {
			if(this.grade[1][1] == 0)
				return true;
			else
				return false;
			
		}
		else if(posicao==4) {
			if(this.grade[1][0] == 0)
				return true;
			else
				return false;
			
		}
		else if(posicao==3) {
			if(this.grade[2][2] == 0)
				return true;
			else
				return false;
			
		}
		else if(posicao==2) {
			if(this.grade[2][1] == 0)
				return true;
			else
				return false;
			
		}
		else if(posicao==1) {
			if(this.grade[2][0] == 0)
				return true;
			else
				return false;
			
		}
		else {
			getGrade(posicao);
		}
		return verificaCasa;
	}
	
	
	//METODO getGrade() QUE EXIBE A GRADE E O JOGO EM SI
	public int [][] getGrade(int posicao){
		int i,j;
		//O FOR ABAIXO SERVER COMO UM CLEAR
		for(i = 0; i<100; ++i)  
			System.out.println();  
		
		System.out.println("******       JOGO DA VELHA       ******");
		System.out.println("***************************************");
		System.out.println("JOGADOR(1): " + getJogador_um() + "  JOGADOR(2): " + getJogador_dois());
		System.out.println("****************************************");
		System.out.println();
		for(i=0; i<3; i++) {
			for(j=0; j<3; j++) {
				System.out.print("       "+ grade[i][j]);
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("****************************************");
		return grade;
		
	}
	
	
	public void setJogador(int jogada) {
		if(jogador%2==0)
			this.jogador = 1;
		else
			this.jogador = 2;
	}
	
	public int getJogador() {
		return this.jogador;
	}
	
	public void setJogada(int jogada) {
		this.jogada = jogada;
	}

	public int getJogada() {
		return this.jogada;
	}
	public String getJogador_um() {
		return this.jogador_um;
		
	}
	
	public void setJogador_um(String jogador_um) {
		this.jogador_um = jogador_um;
	}
	
	public String getJogador_dois() {
		return this.jogador_dois;
	}
	
	public void setJogador_dois(String jogador_dois) {
		this.jogador_dois = jogador_dois;
	}
	
	//METODO VERIFICA_CAMPEAO VERIFICA TODAS AS POSSIBILIDADES QUE O JOGADOR TEM DE GANHAR, SE ELE ALGUEM TIVER GANHADO 
	// ELE RETORNA O NUMERO DO JOGADOR, 1 ou 2, OU SE NAO HOUVER CAMPEAO ELE RETORNA 0
	public int verifica_campeao(int [][]grade) {
		int aux = 0;
		
		if(grade[0][0]==1 && grade[0][1]==1 && grade[0][2]==1)
			aux = 1;
		else if(grade[0][0]==2 && grade[0][1]==2 && grade[0][2]==2)
			aux = 2;
		else if(grade[0][0]==1 && grade[1][0]==1 && grade[2][0]==1)
			aux = 1;
		else if(grade[0][0]==2 && grade[1][0]==2 && grade[2][0]==2)
			aux = 2;
		else if(grade[0][0]==1 && grade[1][1]==1 && grade[2][2]==1)
			aux = 1;
		else if(grade[0][0]==2 && grade[1][1]==2 && grade[2][2]==2)
			aux = 2;
		else if(grade[0][1]==1 && grade[1][1]==1 && grade[2][1]==1)
			aux = 1;
		else if(grade[0][1]==2 && grade[1][1]==2 && grade[2][1]==2)
			aux = 2;
		else if(grade[0][2]==1 && grade[1][2]==1 && grade[2][2]==1)
			aux = 1;
		else if(grade[0][2]==2 && grade[1][2]==2 && grade[2][2]==2)
			aux = 2;
		else if(grade[0][2]==1 && grade[1][1]==1 && grade[2][0]==1)
			aux = 1;
		else if(grade[0][2]==2 && grade[1][1]==2 && grade[2][0]==2)
			aux = 2;
		else if(grade[1][0]==1 && grade[1][1]==1 && grade[1][2]==1)
			aux = 1;
		else if(grade[1][0]==2 && grade[1][1]==2 && grade[1][2]==2)
			aux = 2;
		else if(grade[1][1]==1 && grade[0][1]==1 && grade[2][1]==1)
			aux = 1;
		else if(grade[1][1]==2 && grade[0][1]==2 && grade[2][1]==2)
			aux = 2;
		else if(grade[1][2]==1 && grade[1][1]==1 && grade[1][0]==1)
			aux = 1;
		else if(grade[1][2]==2 && grade[1][1]==2 && grade[1][0]==2)
			aux = 2;
		else if(grade[2][2]==1 && grade[2][1]==1 && grade[2][0]==1)
			aux = 1;
		else if(grade[2][2]==2 && grade[2][1]==2 && grade[2][0]==2)
			aux = 2;
		return aux;
	}
	
}
