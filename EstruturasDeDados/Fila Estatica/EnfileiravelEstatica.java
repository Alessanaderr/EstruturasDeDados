
// PILHA : 

// Topo ↓ 
// [3]  ← último que entrou   ←  REMOVE

// [2]
// [1]  ← primeiro que entrou (vai sair por último)
// Base ↑

// FILA: 
//         REMOVE
//           ↓
// Frente → [1]    [2] [3] ← Fim

public interface EnfileiravelEstatica {
  void enfileirar(Object dado); // coloca o dado na fila

  Object frente(); // retorna o primeiro elemento da pilha

  void atualizarInicio(Object dado); // Atualiza o valor do primeiro elemento da fila (sem remover).

  void atualizarFim(Object dado); // Atualiza o valor do ultimo elemento da fila (sem remover).

  Object desenfileirar(); // Remove e retorna o elemento da frente da fila.

  boolean estaCheia(); // fila cheia

  boolean estaVazia(); // fila vazia

  String imprimir(); // imprimir o array
}
