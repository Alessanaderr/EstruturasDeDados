public interface EmpilhavelEstatica {
    // main methods
    void push(Object value);       // C (Create)
    Object peek();                 // R (Read)
    void update(Object value);     // U (Update)
    Object pop();                  // D (Delete)
    
    // helper methods
    boolean isFull();
    boolean isEmpty();
    String printStack(); 
}





