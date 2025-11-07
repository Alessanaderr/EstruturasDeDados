// Arquivo: Queueable.java
public interface Queueable<T> {
    void enqueue(T element) throws OverflowException; // insere no fim
    T dequeue() throws UnderflowException;            // remove do início
    T peek() throws UnderflowException;               // consulta o primeiro
    boolean isEmpty();
    int size();
}
