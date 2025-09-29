
package pilhadupla;
public class Main {
  public static void main(String[] args) {
    // Criando uma instância da pilha dupla com tamanho 10
    PilhaDupla pilha = new PilhaDupla(10);

    // =================== TESTANDO A PILHA 1 ===================
    // Empilhando na Pilha 1
    System.out.println("Empilhando na Pilha 1...");
    pilha.push1("A");
    pilha.push1("B");
    pilha.push1("C");

    // Imprimindo a Pilha 1
    System.out.println("\nConteúdo da Pilha 1: " + pilha.print1());

    // Espiando o topo da Pilha 1
    System.out.println("Espiando o topo da Pilha 1: " + pilha.peek1());

    // Desempilhando da Pilha 1
    System.out.println("Desempilhando da Pilha 1: " + pilha.pop1());

    // Atualizando o topo da Pilha 1
    pilha.update1("Novo Valor");
    System.out.println("\nConteúdo da Pilha 1 após atualizar o topo: " + pilha.print1());

    // =================== TESTANDO A PILHA 2 ===================
    // Empilhando na Pilha 2
    System.out.println("\nEmpilhando na Pilha 2...");
    pilha.push2("X");
    pilha.push2("Y");
    pilha.push2("Z");

    // Imprimindo a Pilha 2
    System.out.println("\nConteúdo da Pilha 2: " + pilha.print2());

    // Espiando o topo da Pilha 2
    System.out.println("Espiando o topo da Pilha 2: " + pilha.peek2());

    // Desempilhando da Pilha 2
    System.out.println("Desempilhando da Pilha 2: " + pilha.pop2());

    // Atualizando o topo da Pilha 2
    pilha.update2("Novo Valor na Pilha 2");
    System.out.println("\nConteúdo da Pilha 2 após atualizar o topo: " + pilha.print2());
  }
}
