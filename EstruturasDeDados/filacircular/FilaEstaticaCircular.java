package filacircular; // Define o pacote onde a classe está localizada

// Classe que implementa uma fila circular estática
public class FilaEstaticaCircular implements Enfileiravel {

    private int ponteiroInicio; // Índice do início da fila (cabeça)
    private int ponteiroFim;    // Índice do fim da fila (cauda)
    private int quantidade;     // Quantidade de elementos na fila
    private Object[] dados;     // Array que armazena os elementos da fila

    // Construtor que recebe o tamanho da fila
    public FilaEstaticaCircular(int tamanho) {
        ponteiroInicio = 0;         // Inicializa o início da fila
        ponteiroFim = -1;           // Inicializa o fim como -1 (fila vazia)
        quantidade = 0;             // Inicializa a quantidade como 0
        dados = new Object[tamanho]; // Cria o array com o tamanho especificado
    }

    // Construtor padrão que cria uma fila com tamanho 10
    public FilaEstaticaCircular() {
        this(10); // Chama o construtor acima com tamanho 10
    }

    // Método para adicionar um elemento à fila
    public void enfileirar(Object dado){
        if (!estaCheia()){ // Verifica se a fila não está cheia
            ponteiroFim = avancar(ponteiroFim); // Avança o ponteiro do fim
            dados[ponteiroFim] = dado;          // Insere o dado na posição correta
            quantidade++;                       // Incrementa a quantidade de elementos
        } else {
            System.err.println("Queue is full!"); // Mensagem de erro se a fila estiver cheia
        }
    }

    // Método para remover e retornar o elemento do início da fila
    public Object desenfileirar(){
        Object dadoInicio = null;
        if (!estaVazia()){ // Verifica se a fila não está vazia
            dadoInicio = dados[ponteiroInicio]; // Obtém o dado do início
            ponteiroInicio = avancar(ponteiroInicio); // Avança o ponteiro do início
            quantidade--; // Decrementa a quantidade de elementos
        } else {
            System.err.println("Queue is empty!"); // Mensagem de erro se a fila estiver vazia
        }
        return dadoInicio; // Retorna o dado removido
    }

    // Método para consultar o elemento do início da fila sem removê-lo
    public Object frente() {
        Object dadoInicio = null;
        if (!estaVazia()) // Verifica se a fila não está vazia
            dadoInicio = dados[ponteiroInicio]; // Obtém o dado do início
        else
            System.err.println("Fila Vazia!"); // Mensagem de erro se estiver vazia

        return dadoInicio; // Retorna o dado consultado
    }

    // Atualiza o valor do elemento no início da fila
    public void atualizarInicio(Object dado) {
        if (!estaVazia()){ // Verifica se a fila não está vazia
            dados[ponteiroInicio] = dado; // Atualiza o dado no início
        } else {
            System.err.println("Queue is empty!"); // Mensagem de erro se estiver vazia
        }
    }

    // Atualiza o valor do elemento no fim da fila
    public void atualizarFim(Object dado) {
        if (!estaVazia()){ // Verifica se a fila não está vazia
            dados[ponteiroFim] = dado; // Atualiza o dado no fim
        } else {
            System.err.println("Queue is empty!"); // Mensagem de erro se estiver vazia
        }
    }

    // Verifica se a fila está cheia
    public boolean estaCheia(){
        return (quantidade == dados.length); // Retorna true se a quantidade for igual ao tamanho do array
    }

    // Verifica se a fila está vazia
    public boolean estaVazia(){
        return (quantidade == 0); // Retorna true se não houver elementos
    }

    // Retorna uma representação em string da fila
    public String imprimir(){
        String retorno = "["; // Inicia a string com colchete
        int ponteiroAux = ponteiroInicio; // Ponteiro auxiliar para percorrer a fila
        for (int i = 0; i < quantidade; i++) {
            retorno += dados[ponteiroAux]; // Adiciona o elemento à string
            if (i != quantidade - 1)
                retorno += ","; // Adiciona vírgula entre os elementos

            ponteiroAux = avancar(ponteiroAux); // Avança o ponteiro auxiliar
        }
        return retorno + "]"; // Fecha a string com colchete e retorna
    }

    // Método auxiliar para avançar o ponteiro circularmente
    private int avancar(int ponteiro) {
        return (ponteiro + 1) % dados.length; // Retorna o próximo índice circular
    }
}
