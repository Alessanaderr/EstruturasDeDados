public class PilhaInvertida {

    private int topo; // índice do topo
    private Object[] dados; // array da pilha

    // Construtor com parâmetro (define o tamanho da pilha)
    public PilhaInvertida(int size) {
        dados = new Object[size];
        topo = size; // topo começa "após o fim" do array
    }

    // Construtor sem parâmetro (tamanho padrão = 5)
    public PilhaInvertida() {
        this(5); 
    }

    // EMPILHAR DADO (PUSH)
    public void push(Object value) {
        if (!isFull()) {
            topo--; // decrementa o topo
            dados[topo] = value;
        } else {
            System.out.println("Pilha lotada!");
        }
    }

    // ATUALIZAR DADO (UPDATE)
    public void update(Object value) {
        if (!isEmpty()) {
            dados[topo] = value;
        } else {
            System.err.println("Pilha Vazia!");
        }
    }

    // DESEMPILHAR DADO (POP)
    public Object pop() {
        Object remove = null;
        if (!isEmpty()) {
            remove = dados[topo];
            topo++; // incrementa topo (removendo)
        } else {
            System.err.println("Pilha vazia!");
        }
        return remove;
    }

    // ESPIAR DADO (PEEK)
    public Object peek() {
        if (!isEmpty()) {
            return dados[topo];
        } else {
            System.err.println("Pilha Vazia!");
            return null;
        }
    }

    // VERIFICAR SE ESTÁ CHEIA
    public boolean isFull() {
        return topo == 0;
    }

    // VERIFICAR SE ESTÁ VAZIA
    public boolean isEmpty() {
        return topo == dados.length;
    }

    // MOSTRAR PILHA
    public String printStack() {
        String result = "[";
        for (int i = topo; i < dados.length; i++) {
            result += dados[i];
            if (i < dados.length - 1) result += ",";
        }
        return result + "]";
    }
}
