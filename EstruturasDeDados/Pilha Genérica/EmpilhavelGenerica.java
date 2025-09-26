// MetodosPilha.java
public interface EmpilhavelGenerica<T> {
    void empilhar(T dado);
    T desempilhar();
    T espiar();
    void atualizar(T dado); 
    boolean estaCheia();
    boolean estaVazia();
    String imprimir();
}
