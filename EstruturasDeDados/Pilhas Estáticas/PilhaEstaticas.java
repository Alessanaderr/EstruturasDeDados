public class PilhaEstaticas {

    private int topo; // índice do topo
    private Object[] dados; // array da pilha

    // Construtor com parâmetro (define o tamanho da pilha)
    public PilhaEstaticas(int size) {
        dados = new Object[size]; // cria o array com o parâmetro size
        topo = -1; // indica que a pilha começa vazia
    }

    // Construtor sem parâmetro (tamanho padrão = 5)
    public PilhaEstaticas() {
        this(5); // chama o construtor acima passando size = 5
    }

    // Verificar se está cheia
    public boolean isFull() {
        return topo == dados.length - 1; 
    }


// PILHA : 

// Topo ↓ 
// [3]  ← último que entrou   ←  REMOVE

// [2]
// [1]  ← primeiro que entrou (vai sair por último)
// Base ↑






    // Verificar se está vazia
    public boolean isEmpty() {
        return topo == -1;
    }

    // EMPILHAR DADO (PUSH)
    public void push(Object value) {
        if (!isFull()) { // se a pilha não estiver cheia
            topo++; // incrementa o topo
            dados[topo] = value; // coloca o valor no array
        } else {
            System.out.println("Pilha lotada!"); // se estiver cheia
        }
    }

    // ATUALIZAR DADO (UPDATE)
    public void atualizar(Object value) { // função atualizar que recebe o objeto do array (dado) como parâmetro
        if (!isEmpty()) { // se não estiver vazia
            dados[topo] = value; // atualiza o topo do array
        } else {
            System.err.println("Pilha Vazia!"); // se estiver vazia estiver vaiza não tem como atualizar
        }
    }

    // DESEMPILHAR DADO (POP)
    public Object pop() {
        Object remove = null; // cria um objeto pra guardar o valor removido
        if (!isEmpty()) { // se não estiver vazia
            remove = dados[topo]; // passa o valor do topo para o objeto remove
            topo--; // remove o topo
        } else {
            System.err.println("Pilha vazia!"); // se estiver vazia não tem como remover
        }
        return remove;
    }

    // ESPIAR DADO (PEEK)

    public Object peek() {
        Object peek = null;
        if (!isEmpty()) {
            peek = dados[topo];
        } else {
            System.err.println("Pilha Vazia!");
        }
        return peek;
    }

    // MOSTRAR PILHA(PRINTSTACK)

    public String printStack() {
        String result = "["; // cria uma string que começa com uma chave
        for (int i = topo; i >= 0; i--) { // declara um for para percorrer o array até o 0
            if (i == 0) { // se for o ultimo elemento (0), não coloca a virgula
                result += dados[i];
            } else {
                result += dados[i] + ","; // senão coloca a virgula
            }
        }
        return result + "]";
    }

}
