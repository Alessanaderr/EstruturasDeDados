// Arquivo: Main.java
public class Main {
    public static void main(String[] args) {
        try {
            FilaEncadeada<Integer> fila = new FilaEncadeada<>();

            fila.enqueue(10);
            fila.enqueue(20);
            fila.enqueue(30);

            fila.printQueue();

            System.out.println("Removido: " + fila.dequeue());
            fila.printQueue();

            System.out.println("Frente da fila: " + fila.peek());
            System.out.println("Tamanho: " + fila.size());

        } catch (UnderflowException | OverflowException e) {
            System.err.println(e.getMessage());
        }
    }
}
