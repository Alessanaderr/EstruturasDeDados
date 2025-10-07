package filaestatica;
// PILHA : 

// Topo ↓ 
// [3]  ← último que entrou   ←  REMOVE

// [2]
// [1]  ← primeiro que entrou (vai sair por último)
// Base ↑

// FILA: 
//         REMOVE
//           ↓     empilha no fim
//                     ↓
// Frente → [1]   [2] [3] ← Fim

public interface EnfileiravelEstatica {
  void enfileirar(Object dado); // coloca o dado na fila          ->      INSERIR DADO

  Object frente(); // retorna o primeiro elemento da pilha         ->     VER O DA FRENTE

  void atualizarInicio(Object dado); // Atualiza o valor do primeiro elemento da fila (sem remover).  -> ATUALIZAR INICIO

  void atualizarFim(Object dado); // Atualiza o valor do ultimo elemento da fila (sem remover).      -> ATUALIZAR FIM

  Object desenfileirar(); // Remove e retorna o elemento da frente da fila.                             -> REMOVER DADO (INICIO)

  boolean estaCheia(); // fila cheia                                              -> VERIFICA SE ESTA CHEIA 

  boolean estaVazia(); // fila vazia                                              -> VERIFICA SE ESTÁ VAZIA 

  String imprimir(); // imprimir o array                                       
}
