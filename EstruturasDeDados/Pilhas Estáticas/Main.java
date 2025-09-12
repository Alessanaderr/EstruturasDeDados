public class Main {
    public static void main(String[] args) {
        // Criar uma pilha com tamanho padrão (5)
        PilhaEstaticas pilha = new PilhaEstaticas();

        // Empilhando elementos
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");

        // Mostrar a pilha
        System.out.println("Pilha: " + pilha.printStack()); // [C,B,A]

        // Espiar o topo
        System.out.println("Topo da pilha (peek): " + pilha.peek()); // C

        // Atualizar o topo
        pilha.atualizar("D");
        System.out.println("Pilha depois de atualizar o topo: " + pilha.printStack()); // [D,B,A]

        // Desempilhar um elemento
        System.out.println("Elemento desempilhado (pop): " + pilha.pop()); // D

        // Mostrar pilha depois do pop
        System.out.println("Pilha depois do pop: " + pilha.printStack()); // [B,A]

        // Testar se a pilha está vazia
        System.out.println("Está vazia? " + pilha.isEmpty()); // false

        // Testar se a pilha está cheia
        System.out.println("Está cheia? " + pilha.isFull()); // false

        // Empilhando mais elementos
        pilha.push("E");
        pilha.push("F");
        pilha.push("G"); // Esse deve mostrar "Pilha lotada!" pois o tamanho padrão é 5

        // Mostrar pilha final
        System.out.println("Pilha final: " + pilha.printStack()); // [F,E,B,A] (dependendo da capacidade)
    }
}
