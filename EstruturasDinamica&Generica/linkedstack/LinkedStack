import java.util.NoSuchElementException;

/**
 * Implementação de uma Pilha Dinâmica
 *
 * @param <T> o tipo de elementos armazenados na Pilha
 *
 * @author Carlos Daniel
 * @version 1.0
 * @since 06/10/2025
 */

public class LinkedStack<T> implements Stackable{
    /** Aponta para o topo da pilha*/
    private DoubleNode<T> topPointer;
    /**Indica o número atual de dados da pilha*/
    private int numberElements;
    /**Indica o número máximo de elementos que a pilha pode ter*/
    private int maxElements;


    public LinkedStack(){
        this(10);
    }

    public LinkedStack(int maxElements){
        this.topPointer = null;
        this.numberElements = 0;
        this.maxElements = maxElements;
    }

    /**
     * Retorna o elemento do topo da pilha
     *
     * @return retorna o elemento que está no topo
     * @throws NoSuchElementException, quando a pilha está vazia
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return topPointer.getData();
    }

    /**
     * Empilha o elemento do topo da pilha
     *
     * @param data, dado a ser empilhado
     * @throws NoSuchElementException, quando a pilha está cheia
     */
    @Override
    public void push(T data) {
        if(isFull()){
            throw new NoSuchElementException("Stack is full");
        }
        DoubleNode<T> newNode = new DoubleNode<T>();
        newNode.setData(data);
        newNode.setPrior(topPointer);
        topPointer.setNext(newNode);
        topPointer = newNode;
        numberElements++;
    }


    /**
     * DEsempilha o elemento do topo da pilha
     *
     * @return desempilha o elemento do topo da pilha
     * @throws NoSuchElementException, quando a pilha está vazia
     */
    @Override
    public T pop() {
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        T auxData = topPointer.getData();
        numberElements--;
        topPointer = topPointer.getPrior();
        topPointer.setNext(null);
        return auxData;
    }

    /**
     * Atualizar na pilha
     *
     * @param newData, novo dado a ser inserido
     * @throws NoSuchElementException, quando a pilha está vazia
     */
    @Override
    public void update(Object newData) {
        pop();
        push(newData);
    }

    /**
     * Verifica se a Pilha está cheia
     *
     * @return retorna True se a pilha estiver cheia
     */
    @Override
    public boolean isFull() {
        return numberElements == maxElements;
    }

    /**
     * Verifica se a Pilha está vazia
     *
     * @return retorna True se a pilha estiver vazia
     */
    @Override
    public boolean isEmpty() {
        return numberElements == 0;
    }

    /**
     * Imprime os elementos da pilha
     *
     * @return String com os dados entre colchetes separeados por vírgula
     */
    @Override
    public String print() {

        String result = "";
        DoubleNode<T> auxPointer = topPointer;
        for(int i = 0; i < numberElements; i++){
            result += auxPointer.getData();
            auxPointer = auxPointer.getPrior();

            if(i != numberElements - 1){
                result += ", ";
            }
        }

        return "[" + result + "]";
    }
}
