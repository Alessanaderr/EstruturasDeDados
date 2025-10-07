// PilhaEstaticaGenerica.java
public class PilhaEstaticaGenerica<T> {
    private int topo;
    private T[] dados;

    @SuppressWarnings("unchecked")
    public PilhaEstaticaGenerica(int tamanho) {
        topo = -1;
        dados = (T[]) new Object[tamanho]; // Criação do array de tipo genérico
    }

    public void empilhar(T dado) {
        if (!estaCheia()) {
            dados[++topo] = dado;
        } else {
            System.err.println("Pilha cheia!");
        }
    }

    public T desempilhar() {
        if (!estaVazia()) {
            return dados[topo--];
        } else {
            System.err.println("Pilha vazia!");
            return null; // Retorna null se a pilha estiver vazia
        }
    }

    public T espiar() {
        if (!estaVazia()) {
            return dados[topo];
        } else {
            System.err.println("Pilha vazia!");
            return null; // Retorna null se a pilha estiver vazia
        }
    }

    // Método que permite atualizar o topo da pilha
    public void atualizar(T dado) {
        if (!estaVazia()) {
            dados[topo] = dado;
        } else {
            System.err.println("Pilha vazia! Não é possível atualizar.");
        }
    }

    public boolean estaCheia() {
        return topo == dados.length - 1;
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public String imprimir() {
        StringBuilder resultado = new StringBuilder("[");
        for (int i = topo; i >= 0; i--) {
            resultado.append(dados[i]);
            if (i != 0) resultado.append(", ");
        }
        return resultado.append("]").toString();
    }
}
