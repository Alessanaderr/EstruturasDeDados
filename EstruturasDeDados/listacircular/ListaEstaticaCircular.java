package listacircular; // declara o pacote onde a classe está

/**
 * ListaEstaticaCircular - implementação de lista usando array circular.
 * Cada linha/trecho foi comentado para facilitar o entendimento.
 */
public class ListaEstaticaCircular implements Listavel {

	// índice físico no array do primeiro elemento lógico da lista
	private int ponteiroInicio; 
	// índice físico no array do último elemento lógico da lista
	private int ponteiroFim;
	// array que armazena os dados (capacidade fixa)
	private Object[] dados;
	// contador lógico de quantos elementos a lista contém
	private int quantidade;
	
	// construtor padrão: cria lista com capacidade 10
	public ListaEstaticaCircular() {
		this(10); // chama o outro construtor com tamanho 10
	}
	
	// construtor que permite definir o tamanho do array
	public ListaEstaticaCircular(int tamanho) {
		ponteiroInicio = 0; // começo lógico aponta inicialmente para índice 0
		ponteiroFim = -1;   // -1 indica que não há elemento no fim (lista vazia)
		quantidade = 0;    // nenhum elemento ainda
		dados = new Object[tamanho]; // aloca o array físico com o tamanho solicitado
	}

	// DE (endereçamento lógico, 0..quantidade-1)
	// PARA (endereçamento físico no array) — faz o mapeamento considerando o ponteiroInicio
	private int mapeamento(int logica) {
		return (logica + ponteiroInicio) % dados.length; // soma e usa módulo para circular
	}
	
	// Avança um índice físico no array de modo circular
	private int avancar(int ponteiro) {
		return (ponteiro + 1) % dados.length; // ex.: avancar(4) com length=5 retorna 0
	}
	
	// Retrocede um índice físico no array de modo circular
	private int retroceder(int ponteiro) {
		return ((ponteiro - 1) + dados.length) % dados.length; // evita índice negativo
	}		

	// retorna true se a lista estiver preenchida até a capacidade do array
	@Override
	public boolean estaCheia() {
		return (quantidade == dados.length);
	}
	
	// retorna true se não houver elementos na lista
	@Override
	public boolean estaVazia() {
		return (quantidade == 0);
	}
	
	// retorna uma string com os elementos na ordem lógica (do primeiro ao último)
	@Override
	public String imprimir(){
		StringBuilder retorno = new StringBuilder("["); // usa StringBuilder por eficiência
		int ponteiroAux = ponteiroInicio; // começa pelo índice físico do primeiro elemento
		for (int i = 0; i < quantidade; i++) { 
			retorno.append(dados[ponteiroAux]); // adiciona o elemento atual
			if (i != quantidade - 1) 
				retorno.append(","); // separa com vírgula, exceto após o último
			
			ponteiroAux = avancar(ponteiroAux); // avança circularmente para o próximo índice físico
		}
		retorno.append("]");
		return retorno.toString(); // retorna a representação final
	}
	
	// adiciona um elemento ao final da lista (posição lógica = quantidade)
	@Override
	public void anexar(Object dado) {
		if (!estaCheia()) { // só adiciona se houver espaço
			ponteiroFim = avancar(ponteiroFim); // move ponteiroFim para a próxima posição física disponível
			dados[ponteiroFim] = dado; // armazena o dado no índice físico calculado
			quantidade++; // incrementa o contador lógico de elementos
		} else {
			System.err.println("Lista Cheia!"); // mensagem de erro, se estiver cheia
		} 
	}

	// retorna todos os elementos em um array na ordem lógica
	@Override
	public Object[] selecionarTodos() {
		Object[] dadosAux = null; // inicia com null para o caso de lista vazia
		if (!estaVazia()) {
			dadosAux = new Object[quantidade]; // aloca array com exatamente a quantidade de elementos
			int ponteiroAux = ponteiroInicio; // inicia do primeiro elemento lógico
			for(int i = 0; i < quantidade; i++) {
				dadosAux[i] = dados[ponteiroAux]; // copia do array físico para o array de retorno
				ponteiroAux = avancar(ponteiroAux); // avança circularmente
			}
		} else {
			System.err.println("Lista Vazia!"); // avisa se a lista estiver vazia
		}
		return dadosAux; // retorna o array (ou null se vazia, conforme implementação original)
	}

	// retorna o elemento que está na posição lógica informada (0..quantidade-1)
	@Override
	public Object selecionar (int posicao) {
		Object dadoAux = null; // valor que será retornado
		if (!estaVazia()) { // se a lista não está vazia
			// verifica se a posição lógica solicitada é válida
			if ((posicao >= 0) && (posicao < quantidade)) {
				int posicaoFisica = mapeamento(posicao); // converte lógica -> física
				dadoAux = dados[posicaoFisica]; // obtém o valor no índice físico
			} else {
				System.err.println("Indice Invalido!"); // posição fora dos limites
			}
		} else {
			System.err.println("Lista Vazia!"); // não há elementos para selecionar
		}
		return dadoAux; // retorna o valor (ou null se erro)
	}

	// substitui o elemento que está na posição lógica por novoDado
	@Override
	public void atualizar(int posicao, Object novoDado) {
		if (!estaVazia()) { // só atualiza se houver elementos
			// verifica se a posição lógica é válida
			if ((posicao >= 0) && (posicao < quantidade)) {
				int posicaoFisica = mapeamento(posicao); // converte para índice físico
				dados[posicaoFisica] = novoDado; // sobrescreve o valor antigo
			} else {
				System.err.println("Indice Invalido!");
			}
		} else {
			System.err.println("Lista Vazia!");
		}
	}

	// insere um elemento em uma posição lógica qualquer (0..quantidade)
	@Override
	public void inserir(int posicao, Object dado) {
		if (!estaCheia()) { // só insere se houver espaço
			if (posicao >= 0 && posicao <= quantidade) { // posição válida (inclusive no fim)
				int posicaoFisica = mapeamento(posicao); // converte posição lógica -> física
				int x = ponteiroFim; // x começa no índice físico do último elemento atual
				int y = avancar(x); // y será o próximo índice (posição livre que ficará após o shift)
				// desloca os elementos (a partir do fim) para abrir espaço na posição desejada
				for (int i = 0; i < quantidade - posicao; i++) {
					dados[x] = dados[y]; // move o elemento de y para x (deslocamento para trás)
					x = retroceder(x); // retrocede x no array físico
					y = retroceder(y); // retrocede y no array físico
				}
				// após deslocar, posicaoFisica está livre para receber o novo dado
				dados[posicaoFisica] = dado; // insere o novo elemento
				quantidade++; // atualiza o número lógico de elementos
				// corrige o ponteiroFim avançando-o para refletir o novo último elemento
				ponteiroFim = avancar(ponteiroFim); // **lembre-se: é necessário atribuir o resultado**
			} else {
				System.err.println("Invalid Index!"); // índice lógico inválido
			}
		} else {
			System.err.println("Lista Cheia!"); // não há espaço para inserir
		}
	}
	
	// remove e retorna o elemento da posição lógica informada
	@Override
	public Object apagar(int posicao) {
		Object dadoAux = null; // valor que será retornado
		if (!estaVazia()) { // só remove se houver elementos
			if (posicao >= 0 && posicao < quantidade) { // verifica posição válida
				int posicaoFisica = mapeamento(posicao); // converte lógica -> física
				dadoAux = dados[posicaoFisica]; // guarda o dado que será removido
				int x = posicaoFisica; // começa no índice físico onde será feito o shift
				int y = avancar(x); // y aponta para o próximo índice físico
				// move os elementos à frente da posição uma casa para trás para preencher o vazio
				for (int i = 0; i < quantidade - posicao - 1; i++) {
					dados[x] = dados[y]; // copia elemento de y para x
					x = avancar(x); // avança x
					y = avancar(y); // avança y
				}
				quantidade--; // diminui o contador lógico
				ponteiroFim = retroceder(ponteiroFim); // atualiza o ponteiroFim (último elemento mudou)
			} else {
				System.err.println("Invalid Index!");
			}
		} else {
			System.err.println("Lista Vazia!");
		}
		return dadoAux; // retorna o elemento removido (ou null em caso de erro)
	}
}
