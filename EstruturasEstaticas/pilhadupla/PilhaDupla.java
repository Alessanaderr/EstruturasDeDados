

package pilhadupla;
public class PilhaDupla {

    private int top1;          // Índice do topo da Pilha 1 (lado esquerdo)
    private int top2;          // Índice do topo da Pilha 2 (lado direito)
    private Object[] data;     // Vetor compartilhado entre as duas pilhas

    // Construtor com tamanho personalizado
    public PilhaDupla(int size) {
        data = new Object[size]; // Cria o vetor
        top1 = -1;               // Pilha 1 começa antes do índice 0
        top2 = size;             // Pilha 2 começa após o último índice
    }

    // Construtor padrão com tamanho 10
    public PilhaDupla() {
        this(10);
    }

    // ========== MÉTODOS PARA PILHA 1 ==========

    // Adiciona um valor na Pilha 1
    public void push1(Object value) {
        if (!isFull1()) {
            top1++;            // Avança o topo
            data[top1] = value; // Armazena o valor
        } else {
            System.err.println("Stack 1 is full!");
        }
    }

    // Remove e retorna o valor do topo da Pilha 1
    public Object pop1() {
        if (!isEmpty1()) {
            Object value = data[top1]; // Pega o valor do topo
            top1--;                    // Desce o topo
            return value;
        } else {
            System.err.println("Stack 1 is empty!");
            return null;
        }
    }

    // Retorna o valor do topo da Pilha 1 sem remover
    public Object peek1() {
        if (!isEmpty1()) {
            return data[top1]; // Apenas visualiza o topo
        } else {
            System.err.println("Stack 1 is empty!");
            return null;
        }
    }

    // Atualiza o valor no topo da Pilha 1
    public void update1(Object value) {
        if (!isEmpty1()) {
            data[top1] = value; // Substitui o valor
        } else {
            System.err.println("Stack 1 is empty!");
        }
    }

    // Verifica se a Pilha 1 está vazia
    public boolean isEmpty1() {
        return top1 == -1;
    }

    // Verifica se a Pilha 1 está cheia
    public boolean isFull1() {
        return top1 + 1 == top2; // Cheia se os topos se encontram
    }

    // Retorna os elementos da Pilha 1 como string
    public String print1() {
        String result = "[";
        for (int i = top1; i >= 0; i--) {
            result += data[i];
            if (i > 0) result += ",";
        }
        return result + "]";
    }

    // ========== MÉTODOS PARA PILHA 2 ==========

    // Adiciona um valor na Pilha 2
    public void push2(Object value) {
        if (!isFull2()) {
            top2--;            // Move o topo para a esquerda
            data[top2] = value;
        } else {
            System.err.println("Stack 2 is full!");
        }
    }

    // Remove e retorna o valor do topo da Pilha 2
    public Object pop2() {
        if (!isEmpty2()) {
            Object value = data[top2];
            top2++;            // Move o topo para a direita
            return value;
        } else {
            System.err.println("Stack 2 is empty!");
            return null;
        }
    }

    // Retorna o valor do topo da Pilha 2 sem remover
    public Object peek2() {
        if (!isEmpty2()) {
            return data[top2];
        } else {
            System.err.println("Stack 2 is empty!");
            return null;
        }
    }

    // Atualiza o valor no topo da Pilha 2
    public void update2(Object value) {
        if (!isEmpty2()) {
            data[top2] = value;
        } else {
            System.err.println("Stack 2 is empty!");
        }
    }

    // Verifica se a Pilha 2 está vazia
    public boolean isEmpty2() {
        return top2 == data.length;
    }

    // Verifica se a Pilha 2 está cheia
    public boolean isFull2() {
        return isFull1(); // Ambas compartilham o mesmo limite
    }

    // Retorna os elementos da Pilha 2 como string
    public String print2() {
        String result = "[";
        for (int i = top2; i < data.length; i++) {
            result += data[i];
            if (i < data.length - 1) result += ",";
        }
        return result + "]";
    }
}
