package exercicio_02;
import exercicio_02.JogoDaVelha;
import java.util.Scanner;
/* 
 * CLASSE Main e´ responsavel por fazer o jogo da velha rodar
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//FOI CRIADO DUAS STRINGS REPRESENTANDO OS DOIS JOGADOS
		String jogador_um, jogador_dois;
		// CRIEI UM TECLADO(tecladoString) ATRAVES DO SCANNER PARA COLETAR OS NOMES
		Scanner tecladoString = new Scanner(System.in);
		// CRIEI UM TECLADO(tecladoInt) ATRAVES DO SCANNER PARA COLETAR A POSICAO
		Scanner tecladoInt = new Scanner(System.in);
		// CRIEI AS VARIAVEIS QUE IRAO GUARDAR A POSICAO, AS JOGADAS, E O CAMPEAO
		int posicao=1 , jogada=1, campeao = 0;
		System.out.println("DIGITE O NOME DO PRIMEIRO JOGADOR: ");
		jogador_um = tecladoString.nextLine();
		System.out.println();
		System.out.println("DIGITE O NOME DO SEGUNDO JOGADOR: ");
		jogador_dois = tecladoString.nextLine();
		
		//INSTANCIANDO O OBJETO JOGO DA VELHA
		JogoDaVelha novo = new JogoDaVelha(jogador_um,jogador_dois);
		
		
		//LAÇO DE REPETIÇAO QUE CONTROLA TODO O JOGO
		for(int i=1; i<=9; i++) {
			//A COMPARAÇAO ABAIXO VERIFICA SE HA ALGUM CAMPEAO, SE TIVER ELE FAZ SAIR DO LAÇO DE REPETIÇAO
			// O JOGO PODE TER NO MAXIMO 9 JOGADAS
			if(novo.verifica_campeao(novo.getGrade(i))==1 || novo.verifica_campeao(novo.getGrade(i))==2) {
				campeao = novo.verifica_campeao(novo.getGrade(i));
				i=10;
			}
			else {
				// SE NAO TIVER CAMPEAO, ELE ENTRA NO OUTRO LAÇO ONDE SERAO EXTRAIDO AS JOGADAS
				do {
					//VERIFICA SE A POSICAO DESEJADA E´ VALIDA
					if(posicao<1 || posicao>10)
						System.out.println("*** POSICAO INVALIDA!!! ***");
					System.out.println("DIGITE O LOCAL QUE DESEJA: ");
					posicao = tecladoInt.nextInt();
				}while(posicao<1 || posicao>10);
				
			//A COMPARAÇAO ABAIXO VERIFICA SE A POSICAO DESEJADA JA ESTA VAZIA, ATRAVES DO METODO verifica_Jogada()
				if(novo.verifica_Jogada(posicao)==true) {
					novo.setJogador(i);
					novo.setJogada(i);
					novo.setGrade(posicao, novo.getJogador());
				}
				else {
				//SE A CASA NAO ESTIVER VAZIA, NAO SERA CONTADO A JOGADA, POIS O i-- FARA COM QUE O JOGO CONTINUE NA MESMA JOGADA
					novo.setJogada(i);
					i--;
				}
				// IMPRIMINDO A GRADE DO JOGO
				novo.getGrade(posicao);			
			}
		}
		// VERIFICANDO E EXIBINDO OS CAMPEOES, ATRAVES DO METODO getJogador QUE E´ RESPONSAVEL POR RETORNAR OS NOMES DOS JOGADORES ARMAZENADOS
		if(campeao==1)
			System.out.println("O JOGADOR: ("+ novo.getJogador_um() +") FOI CAMPEAO");
		else if(campeao==2)
			System.out.println("O JOGADOR: ("+ novo.getJogador_dois() +") FOI CAMPEAO");
		else
			System.out.println("****    DEU VELHA   *****");
		
	}
	

}
