// Arquivo: LinkedQueue.java
public class FilaEncadeada<T> implements Queueable<T> {

  private DoubleNode<T> front; // primeiro elemento
  private DoubleNode<T> rear; // último elemento
  private int size;

  public FilaEncadeada() {
    front = null;
    rear = null;
    size = 0;
  }

  @Override
  public void enqueue(T element) throws OverflowException {
    DoubleNode<T> newNode = new DoubleNode<>(element);

    if (isEmpty()) {
      front = newNode;
    } else {
      rear.setNext(newNode);
      newNode.setPrevious(rear);
    }

    rear = newNode;
    size++;
  }

  @Override
  public T dequeue() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException("Fila vazia!");
    }

    T info = front.getInfo();
    front = front.getNext();

    if (front == null) {
      rear = null;
    } else {
      front.setPrevious(null);
    }

    size--;
    return info;
  }

  @Override
  public T peek() throws UnderflowException {
    if (isEmpty()) {
      throw new UnderflowException("Fila vazia!");
    }
    return front.getInfo();
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  // Método extra para depuração
  public void printQueue() {
    DoubleNode<T> current = front;
    System.out.print("Fila: ");
    while (current != null) {
      System.out.print(current.getInfo() + " ");
      current = current.getNext();
    }
    System.out.println();
  }
}
