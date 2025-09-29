package filacircular;


public class FilaEstaticaCircularPrincipal {
    public static void main(String[] args) {
        Enfileiravel fila = new FilaEstaticaCircular();

        // Inserindo A
        fila.enfileirar("A");
        System.out.println("Frente: " + fila.frente()); // A

        // Inserindo mais elementos
        fila.enfileirar("B");
        fila.enfileirar("C");

        // Atualizando o início para H
        fila.atualizarInicio("H");
        System.out.println("Fila após atualizar início: " + fila.imprimir()); // [H,B,C]

        // Inserindo D e removendo o da frente
        fila.enfileirar("D");
        fila.desenfileirar();
        System.out.println("Fila após inserir D e remover da frente: " + fila.imprimir());

        // Inserindo E e guardando o removido
        fila.enfileirar("E");
        Object conteudo = fila.desenfileirar();
        System.out.println("Removido: " + conteudo);

        // Inserindo F e atualizando o fim para J
        fila.enfileirar("F");
        fila.atualizarFim("J");
        System.out.println("Fila após atualizar fim: " + fila.imprimir());

        // Conferindo frente duas vezes
        System.out.println("Frente atual: " + fila.frente());
        System.out.println("Frente ainda é: " + fila.frente());

        // Inserindo mais elementos
        fila.enfileirar("G");
        fila.enfileirar(conteudo); // Recoloca o que foi removido antes
        fila.enfileirar("I");

        // Atualizando início para K
        fila.atualizarInicio("K");
        System.out.println("Fila após atualizar início para K: " + fila.imprimir());

        // Tentando inserir mais elementos (testa a circularidade/cheio)
        fila.enfileirar("J");
        fila.enfileirar("K");                    

        // Estado final
        System.out.println("Fila final: " + fila.imprimir());
    }
}
