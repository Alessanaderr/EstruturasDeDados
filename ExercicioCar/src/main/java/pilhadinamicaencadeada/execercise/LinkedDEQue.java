package pilhadinamicaencadeada.execercise;

import java.util.LinkedList;

public class LinkedDEQue<T> implements DEQueable<T>, Iterable<T> {

    private LinkedList<T> lista = new LinkedList<>();
    private int capacidade;

    public LinkedDEQue(int capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public void enfileirarInicio(T dado) {
        if (lista.size() < capacidade)
            lista.addFirst(dado);
    }

    @Override
    public void enfileirarFim(T dado) {
        if (lista.size() < capacidade)
            lista.addLast(dado);
    }

    @Override
    public T desenfileirarInicio() {
        return lista.isEmpty() ? null : lista.removeFirst();
    }

    @Override
    public T desenfileirarFim() {
        return lista.isEmpty() ? null : lista.removeLast();
    }

    @Override
    public boolean vazia() {
        return lista.isEmpty();
    }

    @Override
    public int tamanho() {
        return lista.size();
    }

    public void retirarElemento(T dado) {
        lista.remove(dado);
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return lista.iterator();
    }
}
