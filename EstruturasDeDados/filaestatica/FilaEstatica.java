package filaestatica;

public class FilaEstatica implements EnfileiravelEstatica {

	private int ponteiroInicio; // (primeiro da fila) → marca de onde vou remover (desenfileirar).

	private int ponteiroFim; // (último da fila) ponteiroFim → marca onde vou inserir (enfileirar).

	private Object[] dados; // um array de objetos onde os elementos ficam guardados

	public FilaEstatica(int tamanho) { // construtor
		ponteiroInicio = 0; // guarda o indice da primeira posição 
		ponteiroFim = -1; // guarda a posição o fim. serve para a entrada de dados

		// Estado inicial (fila vazia):
		// [ - ] [ - ] [ - ] [ - ] [ - ]
		// Início=0 // guarda sempre o primeiro indice Fim=-1 // sem dados

		// Inserindo 10:
		// [10 ][ - ][ - ][ - ][ - ]
		// Início=0 Fim=0

		// Inserindo 30:
		// [10 ][20 ][30 ][ - ][ - ]
		// Início=0 Fim=2

		// Remove o 10:
		// Início=1 Fim=2
		// Fila atual → [20, 30]

		dados = new Object[tamanho]; // guarda o dado propriamente dito
	}

	public FilaEstatica() {
		this(10); // define o tamanho da fila
	}

	@Override
	public void enfileirar(Object dado) {
		if (!estaCheia()) { // se n estiver cheia
			ponteiroFim++; // adiciona mais 1 no contador
			dados[ponteiroFim] = dado; // coloca o dado que a variavel dado recebeu e coloco no fim
		} else {
			System.err.println("Fila Cheia!"); // fila cheia
		}
	}

	@Override
	public Object desenfileirar() { // retorna um objeto
		Object dadoInicio = null; // declara o objeto como nulo e dá o nome de dado incio
		if (!estaVazia()) { // se a pilha estiver vazia
			dadoInicio = dados[ponteiroInicio]; // coloca o dado do inicio (por onde a fila remove) dentro do objeto
			ponteiroInicio++; // joga o inicio pro indice seguinte
		} else {
			System.err.println("Fila Vazia!"); // se pilha vazia
		}
		return dadoInicio; // retorna o dado que foi removido, ou seja, o do inicio
	}

	@Override
	public Object frente() { // retorna o primento elemento da frente
		Object dadoInicio = null; // cria a variavel pra retornar o elemento do inicio
		if (!estaVazia()) { // se nao estiver vazia
			dadoInicio = dados[ponteiroInicio]; // coloca o dado na variavel
		} else {
			System.err.println("Fila Vazia!"); // se tiver vazia aponta pra vazia
		}
		return dadoInicio; // retorna o dado do inicio
	}

	@Override
	public void atualizarInicio(Object dado) { // atualizar o inicio da fila, recebe um dado como parâmetro
		if (!estaVazia()) { // se n tiver vazia
			dados[ponteiroInicio] = dado; // coloca o dado no ponteiro do inicio
		} else {
			System.err.println("Fila vazia!"); // avisa que a fila ta vazia
		}
	}

	@Override
	public void atualizarFim(Object dado) {   // atualizar o final da fila e receber um object chamado dado
		if (!estaVazia()) {                    // se n estiver vazia
			dados[ponteiroFim] = dado;           // coloca o dado recebido no ponteiro fim
		} else {
			System.err.println("pilha esta vazia!");  // aviso da pilha vazia 
		}
	}

	// métodos auxiliares
	@Override
	public boolean estaCheia() {                  // esta cheia         
		return (ponteiroFim == dados.length - 1);   // se o ponteiro fim tiver o tamanho do array - 1 ele da true
	}                                              // - 1 pois começa em zero

	@Override
	public boolean estaVazia() {
		return (ponteiroInicio == ponteiroFim + 1);   // se o ponteiro do inicio for 0 ela ta vazia e da
	}

	@Override
	public String imprimir() {   // método pra imprimir
		String resultado = "[";   // coloca uma chave dentro da variável resultado 
		for (int i = ponteiroInicio; i <= ponteiroFim; i++) {    // associa um i ao 
																														//  ponteiro inicio, e equanto 
																														//ele for menor q o fim (sempre) vai
			if (i == ponteiroFim)
				resultado += dados[i];    // resultado = "[10" 
			else
				resultado += dados[i] + ",";  // resultado = "[10," 
		}
		return resultado + "]";  // resultado + a chave
	}

}







