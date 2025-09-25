// Main.java
public class MainGenerica {
  public static void main(String[] args) {
    // Criação de uma pilha de Inteiros
    PilhaEstaticaGenerica<Integer> pilhaInt = new PilhaEstaticaGenerica<>(5);

    pilhaInt.empilhar(10);
    pilhaInt.empilhar(20);
    pilhaInt.empilhar(30);

    System.out.println("Pilha de Inteiros: " + pilhaInt.imprimir());

    System.out.println("Desempilhando: " + pilhaInt.desempilhar());
    System.out.println("Pilha após desempilhar: " + pilhaInt.imprimir());

    pilhaInt.empilhar(40);
    System.out.println("Pilha após empilhar 40: " + pilhaInt.imprimir());

    // Atualizando o topo da pilha
    pilhaInt.atualizar(50);
    System.out.println("Pilha após atualizar o topo para 50: " + pilhaInt.imprimir());

    System.out.println("Topo da pilha (espiar): " + pilhaInt.espiar());
  }
}
