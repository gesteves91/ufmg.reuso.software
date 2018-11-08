/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.tabuleiro;

//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Modulo;

/**
 * @author Michael David
 *
 */
public interface SetupInteraction 
{
	int EASY = 1;
	int MODERATE = 2;
	int HARD = 3;
	int PROJETO_CONCLUIDO = 0;
	int PROJETO_NAO_CONCLUIDO = 1;
	int ARTEFATOS_AJUDA = 0;
	int ARTEFATOS_CODIGO = 1;
	int ARTEFATOS_DESENHO = 2;
	int ARTEFATOS_RASTROS = 3;
	int ARTEFATOS_REQUISITOS = 4;
	
	int exibirStart();  			  								//exibe GUI(tela) para iniciar o jogo. Retorna 1 caso há a necessidade de configurar o jogo. Retorna 0 caso contrário
	  
	int inserirDificuldadeJogo(); 								//valorDificuldade corresponde a: Fácil: 1 ; Moderado = 2  ; Díficil = 3

	String [] inserirNomesJogadores();  							//insere nome dos jogadores no vetor de string
	  
	void pedirRolarDadosInicial(String nomeJogador); 			//exibe GUI solicitando que o jogador lance os dados para definir ordem do jogo
	
	void mostrarPontosObtidosInicial(int pontosObtidos); 		//exibe GUI mostrando pontos obtidos;
	
	void mostrarEmpatePontosObtidosInicial(String nomeJogador); 	//exibe GUI mostrando que houve empate, solicita que o jogador lance dados novamente;
	
	void mostrarOrdemJogo(String[] nomeJogadoresOrdenados); 	//recebe vetor de strings já ordenados para exibir na GUI
	
	void exibirProjeto(CartaoProjeto projeto);					//exibe cartao de projeto na GUI
	
	void exibirDefault(Jogo jogoAtual, Jogador jogador);	/**exibe GUI Default com todas as informações do tabuleiro, cartas na mão do jogador, opções do jogo.*/

void mostrarNumberCardasDelivered(int numberCardsDelivered);	/**exibe a GUI mostrando o número de cartas recebidas respeito o limite de cartas na mao*/

void exibirNaoDemiteEngenheiro();									/**exibe GUI informando que engenheiro não pode ser demitido pois ele trabalhou naquela roodada*/

void exibirExcessoPessoal();									/**exibe GUI informandao que não pode haver contratação de engenheiro devido à excesso de pessoal*/

void exibirFaltaDinheiro(); 									/**exibe GUI informando que não há recursos para ação solicitada*/

int escolherMesa();											/**exibe GUI para jogador escolher mesa para alocar engenheiro contratado*/

int escolherMesaTransferencia();								/**exibe GUI para jogador escolher mesa para transferir módulo integrado*/

int escolherMesaNeutralizaComponente(); //TODO juntar essas função de mesa

	int escolherMesaSofrerProblema(); //TODO juntar essas função de mesa

	/**exibe GUI para jogador inserir quantidades de artefatos a serem produzidos*/
    Modulo[] exibirTabelaProducao(int habilidadeEngenheiro, int complexidadeProjeto);
	
	/**exibe GUI para jogador inserir quantidades de artefatos a serem inspecionados*/
    Modulo[] exibirTabelaInspecao(int habilidadeEngenheiro, Modulo[] artefatosNotInspecionados);
	
	/**exibe GUI para jogador inserir quantidades de artefatos a serem corrigidos*/
    Modulo[] exibirTabelaCorrecao(int habilidadeEngenheiro, Modulo[] artefatosInspecionadosBug);

	int escolherMesadeTrabalho();								/**exibe GUI para jogador escolher mesa na qual o engenheiro deve trabalhar
	 * @param modulos */

	public void exibirHabilidadeInsuficiente(); /**exibe GUI informaando que engenheiro deve ter habilidade >=1 para integrar módulo do projeto escolhido*/
	
	public void exibirModuloJaIntegrado(int mesa); 		/**exibe GUI informado que o modulo já foi integrado*/

	public void exibirModuloNaoSelecionado();	/**Exibe GUI informando que o módulo para integração não foi selecionado**/

	public void habilitarTrocarModuloIntegrado(int mesaTrabalho); /**habilita função do engenheiro da mesaTrabalho para trocar modulo integrado de mesa*/

void exibirMesaModulo();				/**exibe GUI informando que a mesa já contém módulo integrado*/

void exibirVencedor(Jogador jogador);			/**exibe GUI informando que o jogador venceu*/
	
	
	/**  O array multidimensional de inteiros retornado tem 5 posições sendo:
	*  moduloCandidato[0] -> o vetor com posições escolhidas de artefatos de ajuda
	*  moduloCandidato[1] -> o vetor com posições escolhidas de artefatos de codigo
	*  moduloCandidato[2] -> o vetor com posições escolhidas de artefatos de desenho
	*  moduloCandidato[3] -> o vetor com posições escolhidas de artefatos de rastro
	*  moduloCandidato[4] -> o vetor com posições escolhidas de artefatos de requisitos
	*  método recebe o índice da mesa do jogador para limitar escolha de artefatos*/
    int [][] escolherArtefatos(int mesaTrabalho);
	
	String[] escolherEngenheiro(Jogador jogadorAtual, int quantitdadeEngenheiro);	/**escolhe uma quantidade de engenheiros de qualquer mesa do jogador, retornando os nomes do engenheiros*/
	
	//#ifdef ConceptCard
void exibirQuantidadeBeneficio(int quantidade);			/**exibe GUI informando a quantidade de efeito a receber*/
	//#endif

	//#ifdef ConceptCard
void exibirEfeitoinserido(Jogador jogadorAtual, CartaBonificacao cartaUtilizada); /**exibe GUI informando que houve a inserção de conceito*/
	//#endif

void exibirEfeitoinserido(Jogador jogadorAtual, Jogador jogadorAlvo, CartaPenalizacao cartaUtilizada, boolean condicaoSatisfeita); /**exibe GUI informando que houve a inserção de problema*/

	
	//#ifdef ConceptCard
int[] inserirCartasConceitoSelecionadas();
	//#endif

	int[] inserirCartasProblemaSelecionadas();

	
	/** Mostra janela com informação contida em mensagem para o usuário com o título contido em titulo.
	 * 	
	 * @param mensagem Mensagem mostrada na caixa de mensagem
	 */
    void exibirMensagem(String mensagem, String titulo) ;

	int escolherModuloProjeto(Modulo[] modulos, int Mesa);
	
	/**Escolhe artefatos do tabuleiro
	 * @return um inteiro que terá:
	 * na linha 0 do vetor há artefatos de ajuda
	 * na linha 1 do vetor há artefatos de código
	 * na linha 2 do vetor há artefatos de desenho
	 * na linha 3 do vetor há artefatos de rastro
	 * na linha 4 do vetor há artefatos de requisitos
	 * O número de colunas é igual ao número de artefatos que o jogador contém em cada linha
	 * as colunas dos vetores terão valores iguais a:
	 * -1 para artefatos não selecionados pelo jogador
	 * 0 para artefatos selecionados pelo jogador
	 */
    int[][] artefatosEscolhidos();
	
}
