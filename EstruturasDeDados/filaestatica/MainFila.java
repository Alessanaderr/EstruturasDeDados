
package filaestatica;

public class MainFila {
    public static void main(String[] args) {
        // Criação do objeto fila usando a interface Enfileiravel
        EnfileiravelEstatica fila = new FilaEstatica();
        // 'EnfileiravelEstatica' é uma interface que define os métodos que a fila deve ter
        // 'FilaEstatica' é a implementação concreta da fila (vetor fixo, sequencial)

        fila.enfileirar("A"); 
        // Insere o elemento "A" no fim da fila
        // Como a fila estava vazia, ponteiroInicio = 0, ponteiroFim = 0

        System.out.println(fila.frente());
        // Mostra o elemento que está no início da fila (primeiro elemento)
        // Aqui imprime "A"

        fila.enfileirar("B");
        // Insere "B" no fim da fila
        // ponteiroFim avança para a próxima posição

        fila.enfileirar("C");
        // Insere "C" no fim da fila
        // ponteiroFim avança novamente

        fila.atualizarInicio("H");
        // Atualiza o elemento na posição do ponteiroInicio para "H"
        // Substitui o primeiro elemento ("A") por "H"

        fila.enfileirar("D");
        // Insere "D" no fim da fila
        // ponteiroFim avança

        fila.desenfileirar();
        // Remove o elemento do início da fila (H)
        // ponteiroInicio avança, próximo elemento passa a ser "B"

        fila.enfileirar("E");
        // Insere "E" no fim da fila
        // ponteiroFim avança

        Object conteudo = fila.desenfileirar();
        // Remove o elemento do início da fila (B)
        // Guarda o elemento removido na variável 'conteudo'
        // ponteiroInicio avança, agora o início é "C"

        fila.enfileirar("F");
        // Insere "F" no fim da fila
        // ponteiroFim avança

        fila.atualizarFim("J");
        // Atualiza o último elemento da fila (fim) para "J"
        // Substitui o elemento que estava na posição do ponteiroFim

        System.out.println(fila.frente());
        // Imprime o elemento do início da fila (C)

        System.out.println(fila.frente());
        // Imprime novamente o elemento do início da fila (C)
        // O início não mudou, então imprime o mesmo valor

        fila.enfileirar("G");
        // Insere "G" no fim da fila

        fila.enfileirar(conteudo);
        // Insere o elemento removido anteriormente (B) no fim da fila

        fila.enfileirar("I");
        // Insere "I" no fim da fila

        fila.atualizarInicio("K");
        // Atualiza o primeiro elemento da fila (início) para "K"

        fila.enfileirar("J");
        // Insere "J" no fim da fila

        fila.enfileirar("K");
        // Insere "K" no fim da fila

        System.out.println("Fila: " + fila.imprimir());
        // Imprime a fila inteira em formato de string
        // Exemplo de saída: [K,C,D,E,F,J,G,B,I,J,K] dependendo das operações anteriores
    }
}
