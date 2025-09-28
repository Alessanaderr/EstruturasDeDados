import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ListaQuestoes {

  public static void main(String[] args) {
    System.out.println("Esta é a classe principal que contém todas as questões.");
    System.out.println("Para executar uma questão específica, use o seguinte formato no terminal:");
    System.out.println("java ListaQuestoes$NomeDaClasseDoExercicio");
    System.out.println("\nExemplos:");
    System.out.println("java ListaQuestoes$Exercicio1");
    System.out.println("java ListaQuestoes$ExercicioLista2_15");
  }

  /**
   * 1. Faça um programa em Java que leia um vetor de 5 números inteiros e
   * mostre-os.
   */
  public static class Exercicio1 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] vetor = new int[5];

      System.out.println("Digite 5 números inteiros:");
      for (int i = 0; i < vetor.length; i++) {
        System.out.print("Número " + (i + 1) + ": ");
        vetor[i] = scanner.nextInt();
      }

      System.out.println("\nOs números digitados foram:");
      for (int numero : vetor) {
        System.out.print(numero + " ");
      }
      System.out.println();
      scanner.close();
    }
  }

  /**
   * 2. Faça um programa em Java que leia um vetor de 10 números reais e mostre-os
   * na ordem inversa.
   */
  public static class Exercicio2 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double[] vetor = new double[10];

      System.out.println("Digite 10 números reais:");
      for (int i = 0; i < vetor.length; i++) {
        System.out.print("Número " + (i + 1) + ": ");
        vetor[i] = scanner.nextDouble();
      }

      System.out.println("\nOs números na ordem inversa são:");
      for (int i = vetor.length - 1; i >= 0; i--) {
        System.out.println(vetor[i]);
      }
      scanner.close();
    }
  }

  /**
   * 3. Faça um programa em Java que leia 4 notas, mostre as notas e a média na
   * tela.
   */
  public static class Exercicio3 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double[] notas = new double[4];
      double soma = 0.0;

      System.out.println("Digite as 4 notas:");
      for (int i = 0; i < notas.length; i++) {
        System.out.print("Nota " + (i + 1) + ": ");
        notas[i] = scanner.nextDouble();
        soma += notas[i];
      }

      System.out.println("\nAs notas digitadas foram:");
      for (double nota : notas) {
        System.out.print(nota + " ");
      }

      double media = soma / notas.length;
      System.out.printf("\nA média das notas é: %.2f\n", media);
      scanner.close();
    }
  }

  /**
   * 4. Faça um programa em Java que leia um vetor de 10 caracteres, e diga
   * quantas consoantes foram lidas. Imprima as consoantes.
   */
  public static class Exercicio4 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      char[] caracteres = new char[10];
      int totalConsoantes = 0;
      StringBuilder consoantesLidas = new StringBuilder();

      System.out.println("Digite 10 caracteres:");
      for (int i = 0; i < caracteres.length; i++) {
        System.out.print("Caractere " + (i + 1) + ": ");
        caracteres[i] = scanner.next().charAt(0);
      }

      for (char c : caracteres) {
        char lowerC = Character.toLowerCase(c);
        if (Character.isLetter(lowerC) && "aeiou".indexOf(lowerC) == -1) {
          totalConsoantes++;
          consoantesLidas.append(c).append(" ");
        }
      }

      System.out.println("\nForam lidas " + totalConsoantes + " consoantes.");
      System.out.println("As consoantes são: " + consoantesLidas.toString());
      scanner.close();
    }
  }

  /**
   * 5. Faça um programa em Java que leia 20 números inteiros e armazene-os num
   * vetor. Armazene os números pares no vetor PAR e os números IMPARES no vetor
   * impar. Imprima os três vetores.
   */
  public static class Exercicio5 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] numeros = new int[20];
      List<Integer> pares = new ArrayList<>();
      List<Integer> impares = new ArrayList<>();

      System.out.println("Digite 20 números inteiros:");
      for (int i = 0; i < numeros.length; i++) {
        System.out.print("Número " + (i + 1) + ": ");
        numeros[i] = scanner.nextInt();
        if (numeros[i] % 2 == 0) {
          pares.add(numeros[i]);
        } else {
          impares.add(numeros[i]);
        }
      }

      System.out.println("\nVetor completo:");
      System.out.println(Arrays.toString(numeros));

      System.out.println("\nVetor de Pares:");
      System.out.println(pares);

      System.out.println("\nVetor de Ímpares:");
      System.out.println(impares);

      scanner.close();
    }
  }

  /**
   * 6. Faça um programa em Java que peça as quatro notas de 10 alunos, calcule e
   * armazene num vetor a média de cada aluno, imprima o número de alunos com
   * média maior ou igual a 7.0.
   */
  public static class Exercicio6 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      final int NUM_ALUNOS = 10;
      final int NUM_NOTAS = 4;
      double[] medias = new double[NUM_ALUNOS];
      int alunosAprovados = 0;

      for (int i = 0; i < NUM_ALUNOS; i++) {
        double soma = 0;
        System.out.println("\nDigite as 4 notas do Aluno " + (i + 1) + ":");
        for (int j = 0; j < NUM_NOTAS; j++) {
          System.out.print("Nota " + (j + 1) + ": ");
          soma += scanner.nextDouble();
        }
        medias[i] = soma / NUM_NOTAS;
        if (medias[i] >= 7.0) {
          alunosAprovados++;
        }
      }

      System.out.println("\nO número de alunos com média maior ou igual a 7.0 é: " + alunosAprovados);
      scanner.close();
    }
  }

  /**
   * 7. Faça um programa em Java que leia um vetor de 5 números inteiros, mostre a
   * soma, a multiplicação e os números.
   */
  public static class Exercicio7 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] numeros = new int[5];
      int soma = 0;
      long multiplicacao = 1; // Usar long para evitar overflow

      System.out.println("Digite 5 números inteiros:");
      for (int i = 0; i < numeros.length; i++) {
        System.out.print("Número " + (i + 1) + ": ");
        numeros[i] = scanner.nextInt();
        soma += numeros[i];
        multiplicacao *= numeros[i];
      }

      System.out.println("\nNúmeros digitados:");
      System.out.println(Arrays.toString(numeros));

      System.out.println("\nSoma: " + soma);
      System.out.println("Multiplicação: " + multiplicacao);
      scanner.close();
    }
  }

  /**
   * 8. Faça um programa em Java que peça a idade e a altura de 5 pessoas,
   * armazene cada informação no seu respectivo vetor. Imprima a idade e a altura
   * na ordem inversa a ordem lida.
   */
  public static class Exercicio8 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      final int QTD_PESSOAS = 5;
      int[] idades = new int[QTD_PESSOAS];
      double[] alturas = new double[QTD_PESSOAS];

      for (int i = 0; i < QTD_PESSOAS; i++) {
        System.out.println("\nDigite os dados da Pessoa " + (i + 1) + ":");
        System.out.print("Idade: ");
        idades[i] = scanner.nextInt();
        System.out.print("Altura (ex: 1.75): ");
        alturas[i] = scanner.nextDouble();
      }

      System.out.println("\nIdades e Alturas na ordem inversa:");
      for (int i = QTD_PESSOAS - 1; i >= 0; i--) {
        System.out.println("Pessoa " + (i + 1) + " -> Idade: " + idades[i] + ", Altura: " + alturas[i]);
      }
      scanner.close();
    }
  }

  /**
   * 9. Faça um programa em Java que leia um vetor A com 10 números inteiros,
   * calcule e mostre a soma dos quadrados dos elementos do vetor.
   */
  public static class Exercicio9 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] vetorA = new int[10];
      long somaDosQuadrados = 0;

      System.out.println("Digite 10 números inteiros para o vetor A:");
      for (int i = 0; i < vetorA.length; i++) {
        System.out.print("Número " + (i + 1) + ": ");
        vetorA[i] = scanner.nextInt();
        somaDosQuadrados += (long) vetorA[i] * vetorA[i];
      }

      System.out.println("\nA soma dos quadrados dos elementos do vetor é: " + somaDosQuadrados);
      scanner.close();
    }
  }

  /**
   * 10. Faça um programa em Java que leia dois vetores com 10 elementos cada.
   * Gere um terceiro vetor de 20 elementos, cujos valores deverão ser compostos
   * pelos elementos intercalados dos dois outros vetores.
   */
  public static class Exercicio10 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] vetor1 = new int[10];
      int[] vetor2 = new int[10];
      int[] vetor3 = new int[20];

      System.out.println("Digite os 10 elementos do primeiro vetor:");
      for (int i = 0; i < vetor1.length; i++) {
        vetor1[i] = scanner.nextInt();
      }

      System.out.println("Digite os 10 elementos do segundo vetor:");
      for (int i = 0; i < vetor2.length; i++) {
        vetor2[i] = scanner.nextInt();
      }

      for (int i = 0; i < 10; i++) {
        vetor3[2 * i] = vetor1[i]; // Posições pares
        vetor3[2 * i + 1] = vetor2[i]; // Posições ímpares
      }

      System.out.println("\nTerceiro vetor (intercalado):");
      System.out.println(Arrays.toString(vetor3));
      scanner.close();
    }
  }

  /**
   * 11. Altere o programa anterior, intercalando 3 vetores de 10 elementos cada.
   */
  public static class Exercicio11 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] vetor1 = new int[10];
      int[] vetor2 = new int[10];
      int[] vetor3 = new int[10];
      int[] vetor4 = new int[30];

      System.out.println("Digite os 10 elementos do primeiro vetor:");
      for (int i = 0; i < 10; i++)
        vetor1[i] = scanner.nextInt();

      System.out.println("Digite os 10 elementos do segundo vetor:");
      for (int i = 0; i < 10; i++)
        vetor2[i] = scanner.nextInt();

      System.out.println("Digite os 10 elementos do terceiro vetor:");
      for (int i = 0; i < 10; i++)
        vetor3[i] = scanner.nextInt();

      for (int i = 0; i < 10; i++) {
        vetor4[3 * i] = vetor1[i];
        vetor4[3 * i + 1] = vetor2[i];
        vetor4[3 * i + 2] = vetor3[i];
      }

      System.out.println("\nQuarto vetor (intercalado):");
      System.out.println(Arrays.toString(vetor4));
      scanner.close();
    }
  }

  /**
   * 12. Foram anotadas as idades e alturas de 30 alunos. Faça um programa em Java
   * que determine quantos alunos com mais de 13 anos possuem altura inferior à
   * média de altura desses alunos.
   */
  public static class Exercicio12 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      final int NUM_ALUNOS = 30; // Para teste, pode usar um valor menor como 5
      int[] idades = new int[NUM_ALUNOS];
      double[] alturas = new double[NUM_ALUNOS];
      double somaAlturas = 0;

      System.out.println("Digite a idade e altura dos " + NUM_ALUNOS + " alunos:");
      for (int i = 0; i < NUM_ALUNOS; i++) {
        System.out.println("--- Aluno " + (i + 1) + " ---");
        System.out.print("Idade: ");
        idades[i] = scanner.nextInt();
        System.out.print("Altura: ");
        alturas[i] = scanner.nextDouble();
        somaAlturas += alturas[i];
      }

      double mediaAlturas = somaAlturas / NUM_ALUNOS;
      int alunosContados = 0;

      for (int i = 0; i < NUM_ALUNOS; i++) {
        if (idades[i] > 13 && alturas[i] < mediaAlturas) {
          alunosContados++;
        }
      }

      System.out.printf("\nMédia de altura da turma: %.2f\n", mediaAlturas);
      System.out.println("Número de alunos com mais de 13 anos e altura inferior à média: " + alunosContados);
      scanner.close();
    }
  }

  /**
   * 13. Faça um programa em Java que receba a temperatura média de cada mês do
   * ano e armazene-as em um array. Após isto, calcule a média anual das
   * temperaturas e mostre todas as temperaturas acima da média anual, e em que
   * mês elas ocorreram.
   */
  public static class Exercicio13 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      double[] temperaturas = new double[12];
      String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
          "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
      double somaAnual = 0;

      for (int i = 0; i < 12; i++) {
        System.out.print("Digite a temperatura média de " + meses[i] + ": ");
        temperaturas[i] = scanner.nextDouble();
        somaAnual += temperaturas[i];
      }

      double mediaAnual = somaAnual / 12;
      System.out.printf("\nMédia anual de temperatura: %.2f°C\n", mediaAnual);

      System.out.println("\nTemperaturas acima da média anual:");
      for (int i = 0; i < 12; i++) {
        if (temperaturas[i] > mediaAnual) {
          System.out.printf("%d - %s: %.2f°C\n", (i + 1), meses[i], temperaturas[i]);
        }
      }
      scanner.close();
    }
  }

  /**
   * 14 & 15. Utilizando arrays, faça um programa em Java que faça 5 perguntas
   * para uma pessoa sobre um crime... e emita uma classificação.
   */
  public static class Exercicio14_15 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] perguntas = {
          "Telefonou para a vítima?",
          "Esteve no local do crime?",
          "Mora perto da vítima?",
          "Devia para a vítima?",
          "Já trabalhou com a vítima?"
      };
      int respostasPositivas = 0;

      System.out.println("--- INTERROGATÓRIO ---");
      System.out.println("Responda com 's' para sim ou 'n' para não.");

      for (String pergunta : perguntas) {
        System.out.print(pergunta + " ");
        String resposta = scanner.next().toLowerCase();
        if (resposta.equals("s")) {
          respostasPositivas++;
        }
      }

      System.out.println("\n--- CLASSIFICAÇÃO ---");
      if (respostasPositivas == 2) {
        System.out.println("Suspeita");
      } else if (respostasPositivas >= 3 && respostasPositivas <= 4) {
        System.out.println("Cúmplice");
      } else if (respostasPositivas == 5) {
        System.out.println("Assassino");
      } else {
        System.out.println("Inocente");
      }
      scanner.close();
    }
  }

  /**
   * 15 (Parte 2). Faça um programa em Java que leia um número indeterminado de
   * valores, correspondentes a notas...
   */
  public static class Exercicio15_Parte2 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      List<Double> notas = new ArrayList<>();
      double soma = 0;
      int acimaMedia = 0;
      int abaixoDeSete = 0;

      System.out.println("Digite as notas (ou -1 para encerrar):");
      while (true) {
        double nota = scanner.nextDouble();
        if (nota == -1) {
          break;
        }
        notas.add(nota);
        soma += nota;
      }

      System.out.println("\n--- RESULTADOS ---");

      System.out.println("1. Quantidade de valores lidos: " + notas.size());

      System.out.print("2. Valores na ordem informada: ");
      for (double nota : notas) {
        System.out.print(nota + " ");
      }
      System.out.println();

      System.out.println("3. Valores na ordem inversa:");
      for (int i = notas.size() - 1; i >= 0; i--) {
        System.out.println(notas.get(i));
      }

      System.out.println("4. Soma dos valores: " + soma);

      double media = notas.isEmpty() ? 0 : soma / notas.size();
      System.out.printf("5. Média dos valores: %.2f\n", media);

      for (double nota : notas) {
        if (nota > media) {
          acimaMedia++;
        }
        if (nota < 7) {
          abaixoDeSete++;
        }
      }

      System.out.println("6. Quantidade de valores acima da média: " + acimaMedia);
      System.out.println("7. Quantidade de valores abaixo de sete: " + abaixoDeSete);

      System.out.println("\nPrograma encerrado.");
      scanner.close();
    }
  }

  /**
   * 16. Uma empresa paga seus vendedores com base em comissões... determine
   * quantos vendedores receberam salários nos seguintes intervalos de valores.
   */
  public static class Exercicio16 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] contadores = new int[9]; // 0: $200-299, 1: $300-399, ..., 8: $1000+

      System.out.println("Digite o valor das vendas brutas de cada vendedor (-1 para encerrar):");

      while (true) {
        System.out.print("Vendas da semana: ");
        double vendas = scanner.nextDouble();
        if (vendas < 0) {
          break;
        }

        double salario = 200 + (0.09 * vendas);
        int indice = (int) (salario / 100) - 2;

        if (indice >= 0) {
          if (indice >= contadores.length - 1) { // Acima de $999
            contadores[8]++;
          } else {
            contadores[indice]++;
          }
        }
      }

      System.out.println("\n--- DISTRIBUIÇÃO DE SALÁRIOS ---");
      System.out.println("$200 - $299: " + contadores[0]);
      System.out.println("$300 - $399: " + contadores[1]);
      System.out.println("$400 - $499: " + contadores[2]);
      System.out.println("$500 - $599: " + contadores[3]);
      System.out.println("$600 - $699: " + contadores[4]);
      System.out.println("$700 - $799: " + contadores[5]);
      System.out.println("$800 - $899: " + contadores[6]);
      System.out.println("$900 - $999: " + contadores[7]);
      System.out.println("$1000 em diante: " + contadores[8]);

      scanner.close();
    }
  }

  /**
   * 17. Em uma competição de salto em distância cada atleta tem direito a cinco
   * saltos...
   */
  public static class Exercicio17 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      while (true) {
        System.out.print("\nAtleta (ou enter para sair): ");
        String nome = scanner.nextLine();

        if (nome.isEmpty()) {
          break;
        }

        double[] saltos = new double[5];
        double soma = 0;

        for (int i = 0; i < 5; i++) {
          System.out.print((i + 1) + "º Salto: ");
          saltos[i] = Double.parseDouble(scanner.nextLine());
          soma += saltos[i];
        }

        System.out.println("\nResultado final:");
        System.out.println("Atleta: " + nome);
        System.out.print("Saltos: ");
        for (int i = 0; i < 5; i++) {
          System.out.print(saltos[i] + (i < 4 ? " - " : ""));
        }

        double media = soma / 5;
        System.out.printf("\nMédia dos saltos: %.1f m\n", media);
      }

      System.out.println("\nPrograma encerrado.");
      scanner.close();
    }
  }

  /**
   * 18. Uma grande emissora de televisão quer fazer uma enquete...
   */
  public static class Exercicio18 {

    public static double calcularPercentual(int votosJogador, int totalVotos) {
      if (totalVotos == 0) {
        return 0.0;
      }
      return ((double) votosJogador / totalVotos) * 100.0;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] votos = new int[24]; // Posições 1 a 23 para os jogadores
      int totalVotos = 0;

      System.out.println("Enquete: Quem foi o melhor jogador?");
      while (true) {
        System.out.print("Número do jogador (0=fim): ");
        int voto = scanner.nextInt();

        if (voto == 0) {
          break;
        }

        if (voto < 1 || voto > 23) {
          System.out.println("Informe um valor entre 1 e 23 ou 0 para sair!");
          continue;
        }

        votos[voto]++;
        totalVotos++;
      }

      String resultado = gerarRelatorio(votos, totalVotos);
      System.out.println(resultado);
      salvarRelatorio(resultado, "resultado_votacao.txt");

      scanner.close();
    }

    public static String gerarRelatorio(int[] votos, int totalVotos) {
      StringBuilder sb = new StringBuilder();
      sb.append("\nResultado da votação:\n\n");
      sb.append("Foram computados ").append(totalVotos).append(" votos.\n");
      sb.append("Jogador   Votos     %\n");

      int melhorJogador = 0;
      int maxVotos = 0;

      for (int i = 1; i < votos.length; i++) {
        if (votos[i] > 0) {
          double percentual = calcularPercentual(votos[i], totalVotos);
          sb.append(String.format("%-10d%-10d%-8.1f%%\n", i, votos[i], percentual));
          if (votos[i] > maxVotos) {
            maxVotos = votos[i];
            melhorJogador = i;
          }
        }
      }

      double percentualMelhor = calcularPercentual(maxVotos, totalVotos);
      sb.append(
          String.format("\nO melhor jogador foi o número %d, com %d votos, correspondendo a %.1f%% do total de votos.",
              melhorJogador, maxVotos, percentualMelhor));

      return sb.toString();
    }

    public static void salvarRelatorio(String conteudo, String nomeArquivo) {
      try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
        writer.println(conteudo);
        System.out.println("\nRelatório salvo em " + nomeArquivo);
      } catch (IOException e) {
        System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
      }
    }
  }

  /**
   * 19. Uma empresa de pesquisas precisa tabular os resultados da seguinte
   * enquete...
   */
  public static class Exercicio19 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] sistemas = { "Windows Server", "Unix", "Linux", "Netware", "Mac OS", "Outro" };
      int[] votos = new int[6];
      int totalVotos = 0;

      System.out.println("Qual o melhor Sistema Operacional para uso em servidores?");
      System.out.println("1- Windows Server\n2- Unix\n3- Linux\n4- Netware\n5- Mac OS\n6- Outro\n0- Sair");

      while (true) {
        System.out.print("\nDigite seu voto: ");
        int voto = scanner.nextInt();
        if (voto == 0) {
          break;
        }
        if (voto < 1 || voto > 6) {
          System.out.println("Opção inválida. Digite um número entre 1 e 6 ou 0 para sair.");
          continue;
        }
        votos[voto - 1]++;
        totalVotos++;
      }

      System.out.println("\nSistema Operacional Votos           %");
      System.out.println("------------------- -----           ---");

      int maxVotos = 0;
      int indiceVencedor = 0;
      for (int i = 0; i < sistemas.length; i++) {
        double percentual = (totalVotos > 0) ? ((double) votos[i] / totalVotos * 100) : 0;
        System.out.printf("%-19s %-15d %.0f%%\n", sistemas[i], votos[i], percentual);
        if (votos[i] > maxVotos) {
          maxVotos = votos[i];
          indiceVencedor = i;
        }
      }
      System.out.println("------------------- -----");
      System.out.printf("Total               %d\n\n", totalVotos);

      double percentualVencedor = (totalVotos > 0) ? ((double) maxVotos / totalVotos * 100) : 0;
      System.out.printf(
          "O Sistema Operacional mais votado foi o %s, com %d votos, correspondendo a %.0f%% dos votos.\n",
          sistemas[indiceVencedor], maxVotos, percentualVencedor);

      scanner.close();
    }
  }

  /**
   * 20. As Organizações Tabajara resolveram dar um abono aos seus
   * colaboradores...
   */
  public static class Exercicio20 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      List<Double> salarios = new ArrayList<>();
      List<Double> abonos = new ArrayList<>();
      double totalAbono = 0;
      int contAbonoMinimo = 0;
      double maiorAbono = 0;

      System.out.println("Projeção de Gastos com Abono");
      System.out.println("============================");

      while (true) {
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        if (salario == 0) {
          break;
        }
        salarios.add(salario);

        double abono = salario * 0.20;
        if (abono < 100.0) {
          abono = 100.0;
          contAbonoMinimo++;
        }
        abonos.add(abono);

        totalAbono += abono;
        if (abono > maiorAbono) {
          maiorAbono = abono;
        }
      }

      System.out.println("\nSalário    - Abono");
      for (int i = 0; i < salarios.size(); i++) {
        System.out.printf("R$ %8.2f - R$ %.2f\n", salarios.get(i), abonos.get(i));
      }

      System.out.println("\nForam processados " + salarios.size() + " colaboradores");
      System.out.printf("Total gasto com abonos: R$ %.2f\n", totalAbono);
      System.out.println("Valor mínimo pago a " + contAbonoMinimo + " colaboradores");
      System.out.printf("Maior valor de abono pago: R$ %.2f\n", maiorAbono);

      scanner.close();
    }
  }

  /**
   * 21. Faça um programa em Java que carregue um array com os modelos de cinco
   * carros...
   */
  public static class Exercicio21 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String[] modelos = new String[5];
      double[] consumo = new double[5];

      System.out.println("Comparativo de Consumo de Combustível");
      for (int i = 0; i < 5; i++) {
        System.out.println("Veículo " + (i + 1));
        System.out.print("Nome: ");
        modelos[i] = scanner.nextLine();
        System.out.print("Km por litro: ");
        consumo[i] = Double.parseDouble(scanner.nextLine());
      }

      System.out.println("\nRelatório Final");
      int indiceMaisEconomico = 0;
      double maiorConsumoKmPorLitro = 0;

      for (int i = 0; i < 5; i++) {
        double litros1000km = 1000 / consumo[i];
        double custo1000km = litros1000km * 2.25;
        System.out.printf("%d - %-10s - %5.1f - %7.1f litros - R$ %.2f\n",
            i + 1, modelos[i], consumo[i], litros1000km, custo1000km);

        if (consumo[i] > maiorConsumoKmPorLitro) {
          maiorConsumoKmPorLitro = consumo[i];
          indiceMaisEconomico = i;
        }
      }

      System.out.println("\nO menor consumo é do " + modelos[indiceMaisEconomico] + ".");
      scanner.close();
    }
  }

  /**
   * 22. Sua organização acaba de contratar um estagiário para trabalhar no
   * Suporte de Informática...
   */
  public static class Exercicio22 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] defeitos = new int[4]; // Contadores para cada tipo de defeito
      int totalMouses = 0;

      System.out.println("Registro de Levantamento de Mouses");
      System.out.println("Tipos de defeito:");
      System.out.println("1- necessita da esfera");
      System.out.println("2- necessita de limpeza");
      System.out.println("3- necessita troca do cabo ou conector");
      System.out.println("4- quebrado ou inutilizado");

      while (true) {
        System.out.print("\nIdentificação do mouse (0 para encerrar): ");
        int id = scanner.nextInt();
        if (id == 0) {
          break;
        }

        System.out.print("Tipo de defeito (1-4): ");
        int tipo = scanner.nextInt();
        if (tipo >= 1 && tipo <= 4) {
          defeitos[tipo - 1]++;
          totalMouses++;
        } else {
          System.out.println("Tipo de defeito inválido.");
        }
      }

      System.out.println("\nQuantidade de mouses: " + totalMouses);
      System.out.println("\nSituação                                Quantidade    Percentual");
      String[] situacoes = { "necessita da esfera", "necessita de limpeza", "necessita troca do cabo ou conector",
          "quebrado ou inutilizado" };

      for (int i = 0; i < 4; i++) {
        double percentual = (totalMouses > 0) ? ((double) defeitos[i] / totalMouses) * 100 : 0;
        System.out.printf("%d- %-37s %-13d %.0f%%\n", i + 1, situacoes[i], defeitos[i], percentual);
      }

      scanner.close();
    }
  }

  /**
   * 23. A ACME Inc., uma empresa de 500 funcionários, está tendo problemas de
   * espaço em disco...
   */
  public static class Exercicio23 {
    public static double bytesParaMegabytes(long bytes) {
      return (double) bytes / (1024 * 1024);
    }

    public static double calcularPercentual(long espacoUsuario, long espacoTotal) {
      if (espacoTotal == 0)
        return 0;
      return ((double) espacoUsuario / espacoTotal) * 100;
    }

    public static void main(String[] args) {
      List<String> usuarios = new ArrayList<>();
      List<Long> espacoUtilizado = new ArrayList<>();
      long espacoTotal = 0;
      String arquivoEntrada = "usuarios.txt";
      String arquivoSaida = "relatorio.txt";

      try (BufferedReader br = new BufferedReader(new FileReader(arquivoEntrada))) {
        String linha;
        while ((linha = br.readLine()) != null) {
          if (linha.trim().length() < 16)
            continue;
          String nome = linha.substring(0, 15).trim();
          long bytes = Long.parseLong(linha.substring(15).trim());
          usuarios.add(nome);
          espacoUtilizado.add(bytes);
          espacoTotal += bytes;
        }
      } catch (IOException e) {
        System.err.println("Erro ao ler o arquivo de entrada '" + arquivoEntrada + "': " + e.getMessage());
        System.err.println("Verifique se o arquivo existe no mesmo diretório do programa.");
        return;
      }

      try (PrintWriter pw = new PrintWriter(new FileWriter(arquivoSaida))) {
        pw.println("ACME Inc.           Uso do espaço em disco pelos usuários");
        pw.println("------------------------------------------------------------------------");
        pw.println("Nr.  Usuário             Espaço utilizado    % do uso");

        for (int i = 0; i < usuarios.size(); i++) {
          double espacoMb = bytesParaMegabytes(espacoUtilizado.get(i));
          double percentual = calcularPercentual(espacoUtilizado.get(i), espacoTotal);
          pw.printf("%-5d%-20s%15.2f MB %10.2f%%\n",
              (i + 1), usuarios.get(i), espacoMb, percentual);
        }

        pw.println("------------------------------------------------------------------------");
        pw.printf("Espaço total ocupado: %.2f MB\n", bytesParaMegabytes(espacoTotal));
        if (!usuarios.isEmpty()) {
          pw.printf("Espaço médio ocupado: %.2f MB\n", bytesParaMegabytes(espacoTotal) / usuarios.size());
        }
        System.out.println("Relatório gerado com sucesso em '" + arquivoSaida + "'.");
      } catch (IOException e) {
        System.err.println("Erro ao escrever o arquivo de saída: " + e.getMessage());
      }
    }
  }

  /**
   * 24. Faça um programa em Java que simule um lançamento de dados...
   */
  public static class Exercicio24 {
    public static void main(String[] args) {
      Random random = new Random();
      int[] lancamentos = new int[100];
      int[] contadores = new int[6]; // Posições 0 a 5 para os lados 1 a 6

      for (int i = 0; i < 100; i++) {
        int resultado = random.nextInt(6) + 1;
        lancamentos[i] = resultado;
        contadores[resultado - 1]++;
      }

      System.out.println("--- Resultados dos 100 Lançamentos ---");
      for (int i = 0; i < 6; i++) {
        System.out.printf("O valor %d foi obtido %d vezes.\n", (i + 1), contadores[i]);
      }
    }
  }

  /**
   * 1. Crie um programa em Java que declare um array de inteiros e imprima seus
   * elementos.
   */
  public static class ExercicioLista2_1 {
    public static void main(String[] args) {
      int[] meuArray = { 10, 20, 30, 40, 50 };
      System.out.println("Elementos do array: " + Arrays.toString(meuArray));
    }
  }

  /**
   * 2. Crie um programa em Java que preencha um array com os quadrados dos
   * números de 1 a N.
   */
  public static class ExercicioLista2_2 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Informe o valor de N: ");
      int n = scanner.nextInt();

      int[] quadrados = new int[n];
      for (int i = 0; i < n; i++) {
        quadrados[i] = (i + 1) * (i + 1);
      }

      System.out.println("Array com os quadrados de 1 a " + n + ":");
      System.out.println(Arrays.toString(quadrados));
      scanner.close();
    }
  }

  /**
   * 3. Crie um programa em Java que preencha um array com os números em ordem
   * inversa.
   */
  public static class ExercicioLista2_3 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Informe o tamanho do array: ");
      int tamanho = scanner.nextInt();

      int[] array = new int[tamanho];
      for (int i = 0; i < tamanho; i++) {
        array[i] = tamanho - i;
      }

      System.out.println("Array preenchido em ordem inversa:");
      System.out.println(Arrays.toString(array));
      scanner.close();
    }
  }

  /**
   * 4. Crie um programa em Java que encontre o maior e o menor número em um
   * array.
   */
  public static class ExercicioLista2_4 {
    public static void main(String[] args) {
      int[] numeros = { 45, 12, 89, 2, 105, 33 };
      if (numeros.length == 0) {
        System.out.println("O array está vazio.");
        return;
      }
      int menor = numeros[0];
      int maior = numeros[0];
      for (int i = 1; i < numeros.length; i++) {
        if (numeros[i] < menor)
          menor = numeros[i];
        if (numeros[i] > maior)
          maior = numeros[i];
      }
      System.out.println("Maior número: " + maior);
      System.out.println("Menor número: " + menor);
    }
  }

  /**
   * 5. Crie um programa em Java que encontre o segundo maior elemento em um
   * array.
   */
  public static class ExercicioLista2_5 {
    public static void main(String[] args) {
      int[] numeros = { 45, 12, 89, 2, 105, 33, 105 };
      if (numeros.length < 2) {
        System.out.println("O array precisa ter pelo menos dois elementos.");
        return;
      }
      Arrays.sort(numeros);
      int maior = numeros[numeros.length - 1];
      int segundoMaior = Integer.MIN_VALUE;

      for (int i = numeros.length - 2; i >= 0; i--) {
        if (numeros[i] < maior) {
          segundoMaior = numeros[i];
          break;
        }
      }
      if (segundoMaior == Integer.MIN_VALUE) {
        System.out.println("Não há um segundo maior elemento (todos são iguais).");
      } else {
        System.out.println("O segundo maior elemento é: " + segundoMaior);
      }
    }
  }

  /**
   * 6. Crie um programa em Java que calcule e mostre a soma de todos os elementos
   * em um array.
   */
  public static class ExercicioLista2_6 {
    public static void main(String[] args) {
      int[] numeros = { 5, 10, 15, 20, 25 };
      int soma = 0;
      for (int numero : numeros) {
        soma += numero;
      }
      System.out.println("A soma de todos os elementos é: " + soma);
    }
  }

  /**
   * 7. Crie um programa em Java que calcule a soma dos elementos em posições
   * pares de um array.
   */
  public static class ExercicioLista2_7 {
    public static void main(String[] args) {
      int[] numeros = { 10, 20, 30, 40, 50, 60 };
      int somaIndicesPares = 0;
      for (int i = 0; i < numeros.length; i += 2) {
        somaIndicesPares += numeros[i];
      }
      System.out.println("A soma dos elementos em posições de ÍNDICE par (0, 2, 4...) é: " + somaIndicesPares);
    }
  }

  /**
   * 8. Crie um programa em Java que multiplique cada elemento de um array por um
   * valor específico.
   */
  public static class ExercicioLista2_8 {
    public static void main(String[] args) {
      int[] numeros = { 2, 4, 6, 8, 10 };
      int multiplicador = 3;
      System.out.println("Array antes: " + Arrays.toString(numeros));
      for (int i = 0; i < numeros.length; i++) {
        numeros[i] *= multiplicador;
      }
      System.out.println("Array depois: " + Arrays.toString(numeros));
    }
  }

  /**
   * 9. Crie um programa em Java que conte e imprima o número de elementos pares
   * em um array.
   */
  public static class ExercicioLista2_9 {
    public static void main(String[] args) {
      int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
      int contadorPares = 0;
      for (int numero : numeros) {
        if (numero % 2 == 0) {
          contadorPares++;
        }
      }
      System.out.println("O número de elementos pares no array é: " + contadorPares);
    }
  }

  /**
   * 10. Crie um programa em Java que substitua todos os elementos negativos em um
   * array por zero.
   */
  public static class ExercicioLista2_10 {
    public static void main(String[] args) {
      int[] numeros = { 10, -5, 20, -15, 30, -25 };
      System.out.println("Array antes: " + Arrays.toString(numeros));
      for (int i = 0; i < numeros.length; i++) {
        if (numeros[i] < 0) {
          numeros[i] = 0;
        }
      }
      System.out.println("Array depois: " + Arrays.toString(numeros));
    }
  }

  /**
   * 11. Crie um programa em Java que encontre e escreva a média dos elementos de
   * um array.
   */
  public static class ExercicioLista2_11 {
    public static void main(String[] args) {
      double[] numeros = { 10.5, 20.0, 15.5, 30.0 };
      if (numeros.length == 0) {
        System.out.println("Array vazio, média é 0.");
        return;
      }
      double soma = 0;
      for (double numero : numeros) {
        soma += numero;
      }
      double media = soma / numeros.length;
      System.out.printf("A média dos elementos é: %.2f\n", media);
    }
  }

  /**
   * 12. Crie um programa em Java que verifique e informe se um determinado valor
   * está presente em um array.
   */
  public static class ExercicioLista2_12 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] numeros = { 11, 22, 33, 44, 55 };
      System.out.print("Digite o valor a ser procurado: ");
      int valorProcurado = scanner.nextInt();
      boolean encontrado = false;
      for (int numero : numeros) {
        if (numero == valorProcurado) {
          encontrado = true;
          break;
        }
      }
      if (encontrado) {
        System.out.println("O valor " + valorProcurado + " está presente no array.");
      } else {
        System.out.println("O valor " + valorProcurado + " não foi encontrado no array.");
      }
      scanner.close();
    }
  }

  /**
   * 13. Crie um programa em Java que copie os elementos de um array para outro.
   */
  public static class ExercicioLista2_13 {
    public static void main(String[] args) {
      int[] original = { 1, 2, 3, 4, 5 };
      int[] copia = new int[original.length];
      System.arraycopy(original, 0, copia, 0, original.length);
      System.out.println("Array Original: " + Arrays.toString(original));
      System.out.println("Array Cópia:    " + Arrays.toString(copia));
    }
  }

  /**
   * 14. Crie um programa em Java que ordene os elementos de um array em ordem
   * crescente.
   */
  public static class ExercicioLista2_14 {
    public static void main(String[] args) {
      int[] numeros = { 64, 34, 25, 12, 22, 11, 90 };
      System.out.println("Array antes: " + Arrays.toString(numeros));
      Arrays.sort(numeros);
      System.out.println("Array depois (crescente): " + Arrays.toString(numeros));
    }
  }

  /**
   * 15. Crie um programa em Java que preencha um array com números aleatórios e,
   * em seguida, ordene esses números de forma decrescente.
   */
  public static class ExercicioLista2_15 {
    public static void main(String[] args) {
      Random random = new Random();
      Integer[] numeros = new Integer[10];
      for (int i = 0; i < numeros.length; i++) {
        numeros[i] = random.nextInt(100);
      }
      System.out.println("Array aleatório: " + Arrays.toString(numeros));
      Arrays.sort(numeros, Collections.reverseOrder());
      System.out.println("Array ordenado (decrescente): " + Arrays.toString(numeros));
    }
  }

  /**
   * 16. Crie um programa em Java que encontre e imprima o índice da primeira
   * ocorrência de um elemento específico em um array.
   */
  public static class ExercicioLista2_16 {
    public static void main(String[] args) {
      int[] numeros = { 10, 20, 30, 40, 20, 50 };
      int elementoProcurado = 20;
      int indice = -1;
      for (int i = 0; i < numeros.length; i++) {
        if (numeros[i] == elementoProcurado) {
          indice = i;
          break;
        }
      }
      System.out.println("O índice da primeira ocorrência de " + elementoProcurado + " é: " + indice);
    }
  }

  /**
   * 17. Crie um programa em Java que verifique se dois arrays são iguais.
   */
  public static class ExercicioLista2_17 {
    public static void main(String[] args) {
      int[] array1 = { 1, 2, 3, 4, 5 };
      int[] array2 = { 1, 2, 3, 4, 5 };
      int[] array3 = { 5, 4, 3, 2, 1 };
      System.out.println("Array 1 e 2 são iguais? " + Arrays.equals(array1, array2));
      System.out.println("Array 1 e 3 são iguais? " + Arrays.equals(array1, array3));
    }
  }

  /**
   * 18. Crie um programa em Java que multiplique os elementos de dois arrays e
   * armazene o resultado em um terceiro array.
   */
  public static class ExercicioLista2_18 {
    public static void main(String[] args) {
      int[] array1 = { 1, 2, 3, 4, 5 };
      int[] array2 = { 10, 20, 30, 40, 50 };
      if (array1.length != array2.length) {
        System.out.println("Os arrays precisam ter o mesmo tamanho.");
        return;
      }
      int[] resultado = new int[array1.length];
      for (int i = 0; i < array1.length; i++) {
        resultado[i] = array1[i] * array2[i];
      }
      System.out.println("Resultado: " + Arrays.toString(resultado));
    }
  }

  /**
   * 19. Crie um programa em Java que inicialize um array de strings e depois
   * inverta a ordem dos elementos do array.
   */
  public static class ExercicioLista2_19 {
    public static void main(String[] args) {
      String[] palavras = { "java", "é", "muito", "legal" };
      System.out.println("Antes: " + Arrays.toString(palavras));
      Collections.reverse(Arrays.asList(palavras));
      System.out.println("Depois: " + Arrays.toString(palavras));
    }
  }

  /**
   * 20. Crie um programa em Java que remova todas as ocorrências de um texto
   * específico em um array de strings.
   */
  public static class ExercicioLista2_20 {
    public static void main(String[] args) {
      String[] original = { "maçã", "banana", "laranja", "banana", "uva" };
      String textoParaRemover = "banana";
      System.out.println("Original: " + Arrays.toString(original));
      List<String> lista = new ArrayList<>(Arrays.asList(original));
      lista.removeAll(Collections.singleton(textoParaRemover));
      String[] resultado = lista.toArray(new String[0]);
      System.out.println("Resultado: " + Arrays.toString(resultado));
    }
  }

  /**
   * 21. Crie um programa em Java que substitua todas as vogais em um array de
   * caracteres por asteriscos.
   */
  public static class ExercicioLista2_21 {
    public static void main(String[] args) {
      char[] caracteres = { 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'a', 'c', 'a', 'o' };
      System.out.println("Antes: " + Arrays.toString(caracteres));
      for (int i = 0; i < caracteres.length; i++) {
        char c = Character.toLowerCase(caracteres[i]);
        if ("aeiou".indexOf(c) != -1) {
          caracteres[i] = '*';
        }
      }
      System.out.println("Depois: " + Arrays.toString(caracteres));
    }
  }

  /**
   * 22. Crie um programa em Java que conte e imprima o número de vogais em um
   * array de caracteres.
   */
  public static class ExercicioLista2_22 {
    public static void main(String[] args) {
      char[] caracteres = { 'p', 'r', 'o', 'g', 'r', 'a', 'm', 'a', 'c', 'a', 'o' };
      int contadorVogais = 0;
      for (char c : caracteres) {
        if ("aeiou".indexOf(Character.toLowerCase(c)) != -1) {
          contadorVogais++;
        }
      }
      System.out.println("O número de vogais no array é: " + contadorVogais);
    }
  }

  /**
   * 23. Crie um programa em Java que crie um novo array a partir de outros dois
   * arrays.
   */
  public static class ExercicioLista2_23 {
    public static void main(String[] args) {
      int[] array1 = { 1, 2, 3 };
      int[] array2 = { 4, 5, 6, 7 };
      int[] novoArray = new int[array1.length + array2.length];
      System.arraycopy(array1, 0, novoArray, 0, array1.length);
      System.arraycopy(array2, 0, novoArray, array1.length, array2.length);
      System.out.println("Novo array: " + Arrays.toString(novoArray));
    }
  }

  /**
   * 24. Crie um programa em Java que insira um novo elemento em uma posição
   * específica de um array.
   */
  public static class ExercicioLista2_24 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      int[] array = { 10, 20, 40, 50, 0 };
      System.out.println("Array atual: " + Arrays.toString(array));
      System.out.print("Informe a posição para inserir (0 a 4): ");
      int posicao = scanner.nextInt();
      System.out.print("Informe o elemento a ser inserido: ");
      int elemento = scanner.nextInt();

      if (posicao < 0 || posicao >= array.length) {
        System.out.println("Posição inválida.");
      } else {
        for (int i = array.length - 1; i > posicao; i--) {
          array[i] = array[i - 1];
        }
        array[posicao] = elemento;
        System.out.println("Array após inserção: " + Arrays.toString(array));
      }
      scanner.close();
    }
  }

  /**
   * 25. Crie um programa em Java que verifique se um array é um palíndromo.
   */
  public static class ExercicioLista2_25 {
    public static boolean ehPalindromo(int[] array) {
      for (int i = 0; i < array.length / 2; i++) {
        if (array[i] != array[array.length - 1 - i]) {
          return false;
        }
      }
      return true;
    }

    public static void main(String[] args) {
      int[] array1 = { 1, 2, 3, 2, 1 };
      int[] array2 = { 1, 2, 3, 4, 5 };
      System.out.println(Arrays.toString(array1) + " é palíndromo? " + ehPalindromo(array1));
      System.out.println(Arrays.toString(array2) + " é palíndromo? " + ehPalindromo(array2));
    }
  }

  /**
   * 26. Crie um programa em Java que gere um array com os N primeiros números
   * primos.
   */
  public static class ExercicioLista2_26 {
    public static boolean ehPrimo(int num) {
      if (num <= 1)
        return false;
      for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
          return false;
      }
      return true;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Quantos primos gerar? ");
      int n = scanner.nextInt();
      List<Integer> primos = new ArrayList<>();
      for (int num = 2; primos.size() < n; num++) {
        if (ehPrimo(num)) {
          primos.add(num);
        }
      }
      System.out.println("Os " + n + " primeiros primos: " + primos);
      scanner.close();
    }
  }

  /**
   * 27. Crie um programa em Java que preencha um array com os números perfeitos
   * menores que N.
   */
  public static class ExercicioLista2_27 {
    public static boolean ehPerfeito(int num) {
      if (num <= 1)
        return false;
      int somaDivisores = 1;
      for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
          somaDivisores += i;
          if (i * i != num)
            somaDivisores += num / i;
        }
      }
      return somaDivisores == num;
    }

    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Gerar perfeitos menores que: ");
      int n = scanner.nextInt();
      List<Integer> perfeitos = new ArrayList<>();
      for (int i = 2; i < n; i++) {
        if (ehPerfeito(i)) {
          perfeitos.add(i);
        }
      }
      System.out.println("Perfeitos menores que " + n + ": " + perfeitos);
      scanner.close();
    }
  }

  /**
   * 28. Crie um programa em Java que preencha um array com os primeiros N números
   * da sequência de Fibonacci.
   */
  public static class ExercicioLista2_28 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Quantos termos de Fibonacci? ");
      int n = scanner.nextInt();
      long[] fib = new long[n];
      if (n > 0)
        fib[0] = 0;
      if (n > 1)
        fib[1] = 1;
      for (int i = 2; i < n; i++) {
        fib[i] = fib[i - 1] + fib[i - 2];
      }
      System.out.println("Sequência: " + Arrays.toString(fib));
      scanner.close();
    }
  }

  /**
   * 29. Crie um programa em Java que preencha um array com os N primeiros termos
   * da sequência de Lucas.
   */
  public static class ExercicioLista2_29 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Quantos termos de Lucas? ");
      int n = scanner.nextInt();
      long[] lucas = new long[n];
      if (n > 0)
        lucas[0] = 2;
      if (n > 1)
        lucas[1] = 1;
      for (int i = 2; i < n; i++) {
        lucas[i] = lucas[i - 1] + lucas[i - 2];
      }
      System.out.println("Sequência: " + Arrays.toString(lucas));
      scanner.close();
    }
  }

  /**
   * 30. Crie um programa em Java que remova os elementos repetidos de um array.
   */
  public static class ExercicioLista2_30 {
    public static void main(String[] args) {
      int[] comRepetidos = { 1, 2, 2, 3, 4, 4, 4, 5, 6, 6 };
      List<Integer> semRepetidosLista = new ArrayList<>();
      for (int numero : comRepetidos) {
        if (!semRepetidosLista.contains(numero)) {
          semRepetidosLista.add(numero);
        }
      }
      System.out.println("Original: " + Arrays.toString(comRepetidos));
      System.out.println("Sem repetidos: " + semRepetidosLista);
    }
  }

  /**
   * 31. Crie um programa em Java que rotacione os elementos de um array para a
   * esquerda.
   */
  public static class ExercicioLista2_31 {
    public static void main(String[] args) {
      int[] array = { 1, 2, 3, 4, 5 };
      System.out.println("Original: " + Arrays.toString(array));
      if (array.length > 1) {
        int primeiro = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[array.length - 1] = primeiro;
      }
      System.out.println("Rotacionado: " + Arrays.toString(array));
    }
  }

  /**
   * 32. Crie um programa em Java que implemente uma busca binária em um array
   * ordenado.
   */
  public static class ExercicioLista2_32 {
    public static int buscaBinaria(int[] array, int chave) {
      int baixo = 0, alto = array.length - 1;
      while (baixo <= alto) {
        int meio = baixo + (alto - baixo) / 2;
        if (array[meio] == chave)
          return meio;
        if (array[meio] < chave)
          baixo = meio + 1;
        else
          alto = meio - 1;
      }
      return -1;
    }

    public static void main(String[] args) {
      int[] array = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
      int valor = 23;
      int indice = buscaBinaria(array, valor);
      System.out.println("Elemento " + valor + " encontrado no índice: " + indice);
    }
  }

  /**
   * 33. Crie um programa em Java que adicione um novo elemento ao final de um
   * array.
   */
  public static class ExercicioLista2_33 {
    public static void main(String[] args) {
      int[] original = { 10, 20, 30 };
      int novoElemento = 40;
      System.out.println("Antes: " + Arrays.toString(original));
      int[] novo = Arrays.copyOf(original, original.length + 1);
      novo[novo.length - 1] = novoElemento;
      System.out.println("Depois: " + Arrays.toString(novo));
    }
  }

  /**
   * 34. Crie um programa em Java que insira um elemento em uma posição específica
   * de um array. Aumentando o tamanho do array.
   */
  public static class ExercicioLista2_34 {
    public static void main(String[] args) {
      int[] original = { 10, 20, 40, 50 };
      int elemento = 30, pos = 2;
      System.out.println("Antes: " + Arrays.toString(original));
      List<Integer> lista = new ArrayList<>();
      for (int n : original)
        lista.add(n);
      lista.add(pos, elemento);
      System.out.println("Depois: " + lista);
    }
  }

  /**
   * 35. Crie um programa em Java que remova um elemento de uma posição específica
   * de um array. Diminuindo o tamanho do array.
   */
  public static class ExercicioLista2_35 {
    public static void main(String[] args) {
      int[] original = { 10, 20, 30, 40, 50 };
      int pos = 2;
      System.out.println("Antes: " + Arrays.toString(original));
      List<Integer> lista = new ArrayList<>();
      for (int n : original)
        lista.add(n);
      lista.remove(pos);
      System.out.println("Depois: " + lista);
    }
  }
}