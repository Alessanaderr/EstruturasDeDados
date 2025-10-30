

package pilhadinamicaencadeada.execercise;

public interface DEQueable<T> {
    void enfileirarInicio(T dado);
    void enfileirarFim(T dado);
    T desenfileirarInicio();
    T desenfileirarFim();
    boolean vazia();
    int tamanho();
}
