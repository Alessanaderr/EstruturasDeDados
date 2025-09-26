// implementa (push, pop, peek, update, isFull, isEmpty, print).
 
public class PilhaDinamicaGenerica<T> implements EmpilhavelDinamica<T> {

	private int quantidade;
	private int tamanho;
	private NoDuplo<T> ponteiroTopo;

	public PilhaDinamicaGenerica() {
		this(10);
	}

	public PilhaDinamicaGenerica(int tamanho) {  // construtor 
		ponteiroTopo = null;
		quantidade = 0;
		this.tamanho = tamanho;
	}








	

	@Override
	public void push(T dado) {
		if (isFull()) {
			throw new IllegalStateException("Pilha Cheia!");
		}
		NoDuplo<T> noTemporario = new NoDuplo<T>();			//Criando o novo nó
// noTemporario -> [ ]
// ponteiroTopo -> [A]

		noTemporario.setDado(dado);             //Adicionando o dado ao novo nó
// noTemporario -> [B]
// ponteiroTopo -> [A]


		noTemporario.setAnterior(ponteiroTopo);  // A.proximo -> B

		
		
// noTemporario -> [B] -> [A]
// ponteiroTopo -> [A]
		
		
		if (!isEmpty()) {      // se a pilha não estiver vazia. ou seja se o proximo nn for null, faça:
	
			ponteiroTopo.setProximo(noTemporario);   //B.anterior -> A
// noTemporario -> [B] <-> [A]
// ponteiroTopo -> [A]
		}


		ponteiroTopo = noTemporario;  //Atualizando o ponteiro do topo para o novo nó	
// ponteiroTopo -> [B] <-> [A]


		quantidade++;		
	}
	











	@Override
	public T pop() {
		if (isEmpty()) {     // se  estiver vazia
			
			throw new IllegalStateException("Pilha Vazia!");   // lança uma exceção
		}
		T dadoTopo = ponteiroTopo.getDado(); //armazena o dado do topo em uma variável 
// 		dadoTopo = "B"
// ponteiroTopo -> [B] <-> [A]

		ponteiroTopo = ponteiroTopo.getAnterior();  // faz o anterior assumir o topo e seu anterior vira 0

// 		ponteiroTopo -> [A] -> anterior
// [B] (removido do topo, ainda referenciado por dadoTopo)

		quantidade--;    // decrementa a quantidade de elementos na pilha

		 
		if (!isEmpty()) {
			ponteiroTopo.setProximo(null); //faz o proximo do topo ser pois ainda é a que era
		}
		return dadoTopo;  // retorna pois o pop é assim
	}














	@Override
	public T peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Pilha Vazia!");
		}
		return ponteiroTopo.getDado();
	}

	@Override
	public void update(T novoDado) {
		if (isEmpty()) {
			throw new IllegalStateException("Pilha Vazia!");
		}
		ponteiroTopo.setDado(novoDado);
	}

	@Override
	public boolean isFull() {
		return (quantidade == tamanho);
	}

	@Override
	public boolean isEmpty() {
		return (quantidade == 0);
	}

	@Override
	public String print() {
		String resultado = "[";
		NoDuplo<T> ponteiroAuxiliar = ponteiroTopo;
		for (int i = 0; i < quantidade; i++) {
			resultado += ponteiroAuxiliar.getDado();
			if (i != quantidade - 1) {
				resultado += ",";
			}
			ponteiroAuxiliar = ponteiroAuxiliar.getAnterior();
		}
		return resultado + "]";
	}
}
