// NoDuplo<T> = nó da pilha.


//         ┌─────────────┐
// NoDuplo<T> -> │ dado = "A"  │
//         │ anterior -->│────────────┐
//         │ proximo -->│            │
//         └────────────┘            │
//                                   │
//         ┌─────────────┐           │
//         │ dado = "B"  │           │
//         │ anterior -->│───────────┘
//         │ proximo -->│
//         └────────────┘
//                                   ^
//         ┌─────────────┐           │
//         │ dado = "C"  │
//         │ anterior -->│ null
//         │ proximo -->│
//         └─────────────┘


// T dado = valor que o nó está armazenando.

// NoDuplo<T> anterior / NoDuplo<T> proximo = ponteiros para outros nós.



public interface EmpilhavelDinamica<T> {

  // Recebe um valor (dado) a ser empilhado
void push(T dado); // Adiciona um elemento ao topo da pilha

// Remove 
T pop(); // Remove e retorna o elemento do topo da pilha

// espia
T peek(); // Retorna o elemento do topo sem removê-lo

// Recebe um valor para substituir o topo
void update(T dado); // Atualiza o elemento que está no topo da pilha

// Retorna true se a pilha estiver cheia, false caso contrário
boolean isFull(); // Verifica se a pilha está cheia

// Retorna true se a pilha estiver vazia, false caso contrário
boolean isEmpty(); // Verifica se a pilha está vazia

// Retorna uma string representando a pilha
String print(); // Retorna uma representação em string da pilha

}
