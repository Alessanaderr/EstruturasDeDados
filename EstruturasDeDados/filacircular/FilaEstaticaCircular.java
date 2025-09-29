package filacircular;


public class FilaEstaticaCircular  implements Enfileiravel{

	private int ponteiroInicio;	//cabeca = head
	private int ponteiroFim;	//cauda  = tail
	private int quantidade;
	private Object[] dados;
	
	public FilaEstaticaCircular(int tamanho) {
		ponteiroInicio = 0;
		ponteiroFim = -1;
		quantidade = 0;		
		dados = new Object[tamanho];
	}

	public FilaEstaticaCircular() {
		this(10);
	}	

	public void enfileirar(Object dado){
		if (!estaCheia()){
			ponteiroFim = avancar(ponteiroFim);
			dados[ponteiroFim] = dado;
			quantidade++;
		} else {
			System.err.println("Queue is full!");
		}
	}
	
	public Object desenfileirar(){
		Object dadoInicio = null;
		if (!estaVazia()){
			dadoInicio = dados[ponteiroInicio];
			ponteiroInicio = avancar(ponteiroInicio);
			quantidade--;
		} else {
			System.err.println("Queue is empty!");
		}
		return dadoInicio;	
	}
	
	public Object frente() {
		Object dadoInicio = null;
		if (!estaVazia())
			dadoInicio = dados[ponteiroInicio];
		else
			System.err.println("Fila Vazia!");		

		return dadoInicio;
	}

	public void atualizarInicio(Object dado) {
		if (!estaVazia()){
			dados[ponteiroInicio] = dado;
		} else {
			System.err.println("Queue is empty!");
		}
	}	
	
	public void atualizarFim(Object dado) {
  		if (!estaVazia()){
			dados[ponteiroFim] = dado;
		} else {
			System.err.println("Queue is empty!");
		}
	}
	
	public boolean estaCheia(){
		return (quantidade == dados.length);
	}
	
	public boolean estaVazia(){
		return (quantidade == 0);
	}
	
	public String imprimir(){
		String retorno = "[";
		int ponteiroAux = ponteiroInicio;
		for (int i = 0; i < quantidade; i++) {			
			retorno += dados[ponteiroAux];
			if (i != quantidade - 1) 
				retorno += ",";
							
			ponteiroAux = avancar(ponteiroAux); 
		}
		return retorno + "]";
	}
	
	private int avancar(int ponteiro) {
		return (ponteiro+1)%dados.length;
	}	
}