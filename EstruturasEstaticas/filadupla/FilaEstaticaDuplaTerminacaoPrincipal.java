
package filadupla;


public class FilaEstaticaDuplaTerminacaoPrincipal {
    public static void main(String[] args) {
        DuplaeEnfileiravel fila = new FilaEstaticaDuplaTerminacao();

        // Adiciona "A" no início
        fila.enfileirarInicio("A");
        System.out.println("Fila: " + fila.imprimirDeFrentePraTras()); // [A]
        System.out.println("Frente: " + fila.frente()); // A
        System.out.println("Trás: " + fila.tras()); // A

        // Adiciona "B" no início e remove do fim
        fila.enfileirarInicio("B");
        fila.desenfileirarFim();
        System.out.println("Fila após inserir B e remover do fim: " + fila.imprimirDeFrentePraTras());

        // Adiciona "C" no fim e atualiza início para "Y"
        fila.enfileirarFim("C");
        fila.atualizarInicio("Y");
        System.out.println("Fila após inserir C no fim e atualizar início: " + fila.imprimirDeFrentePraTras());

        // Remove do início e adiciona "D" no início
        fila.desenfileirarInicio();
        fila.enfileirarInicio("D");
        System.out.println("Fila: " + fila.imprimirDeFrentePraTras()); 

        // Operações variadas
        fila.desenfileirarFim();
        System.out.println("Trás: " + fila.tras()); // D
        fila.enfileirarInicio("E");
        fila.atualizarFim("R");
        System.out.println("Fila: " + fila.imprimirDeFrentePraTras()); // Estado atualizado

        // Novas inserções e remoções
        fila.enfileirarFim("F");
        fila.desenfileirarInicio();
        fila.enfileirarFim("G");
        System.out.println("Trás: " + fila.tras()); // G

        fila.enfileirarInicio("H");
        fila.desenfileirarFim();
        fila.enfileirarFim("I");
        System.out.println("Fila: " + fila.imprimirDeFrentePraTras()); // Estado final parcial

        // Últimas operações
        fila.enfileirarInicio("J");
        fila.enfileirarFim("K");
        fila.enfileirarFim("L");
        System.out.println("Frente: " + fila.frente()); // J
        fila.desenfileirarInicio();
        System.out.println("Fila final: " + fila.imprimirDeFrentePraTras()); 
    }
}
