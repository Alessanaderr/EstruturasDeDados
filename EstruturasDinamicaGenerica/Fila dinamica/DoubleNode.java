// Arquivo: DoubleNode.java
public class DoubleNode<T> {
    private T info;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    public DoubleNode(T info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    // Getter e Setter do conteúdo
    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    // Getter e Setter dos ponteiros
    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
