public interface EmpilhavelInvertida {
    // Métodos principais (CRUD)
    void push(Object value);       // C (Create)
    Object peek();                 // R (Read)
    void update(Object value);     // U (Update)
    Object pop();                  // D (Delete)
    
    // Métodos auxiliares
    boolean isFull();
    boolean isEmpty();
    String printStack();
}