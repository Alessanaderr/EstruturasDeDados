public class Main {
    public static void main(String[] args) {
        // Criando uma Pilha Invertida com capacidade para 3 elementos
        PilhaInvertida pilha = new PilhaInvertida(3);
        
        System.out.println("Pilha inicial: " + pilha.printStack());
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
        System.out.println("A pilha está cheia? " + pilha.isFull());
        System.out.println("------------------------------------");

        // Empilhando elementos
        System.out.println("Empilhando elementos...");
        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        
        System.out.println("Pilha após empilhar: " + pilha.printStack());
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
        System.out.println("A pilha está cheia? " + pilha.isFull());
        System.out.println("------------------------------------");

        // Tentando empilhar em uma pilha cheia
        System.out.println("Tentando empilhar novamente...");
        pilha.push("D");

        // Espiando o topo da pilha
        System.out.println("Elemento no topo (peek): " + pilha.peek());
        System.out.println("Pilha após peek: " + pilha.printStack());
        System.out.println("------------------------------------");

        // Desempilhando elementos
        System.out.println("Desempilhando elementos...");
        System.out.println("Removido: " + pilha.pop());
        System.out.println("Removido: " + pilha.pop());
        
        System.out.println("Pilha após desempilhar: " + pilha.printStack());
        System.out.println("------------------------------------");

        // Desempilhando o último elemento e verificando se está vazia
        System.out.println("Desempilhando o último elemento...");
        System.out.println("Removido: " + pilha.pop());
        
        System.out.println("Pilha após desempilhar tudo: " + pilha.printStack());
        System.out.println("A pilha está vazia? " + pilha.isEmpty());
        System.out.println("------------------------------------");

        // Tentando desempilhar de uma pilha vazia
        System.out.println("Tentando desempilhar de uma pilha vazia...");
        pilha.pop();
    }
}
