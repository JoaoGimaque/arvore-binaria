package aplication;

import java.util.Scanner;

public class TesteArvore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArvoreBinaria arv = new ArvoreBinaria();

        int opcao;
        long x;

        System.out.print("\n Programa Arvore binaria de long");
        do {
            System.out.println("\n\n");
			System.out.println("+--------------------------------------------+");
			System.out.println("|             Menu de Opcoes                 |");
			System.out.println("+--------------------------------------------+");
			System.out.println("| 1 - Inserir                                |");
			System.out.println("| 2 - Excluir                                |");
			System.out.println("| 3 - Mostrar nos folhas                     |");
			System.out.println("| 4 - Mostrar os descendentes de um nó       |");
			System.out.println("| 5 - Mostrar o no pai e nos filhos de um nó |");
			System.out.println("| 0 - Sair                                   |");
			System.out.println("+-------------------------------------------+");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("\n Informe o valor (long) -> ");
                    x = scanner.nextLong();
                    arv.inserir(x);
                    break;

                case 2:
                    System.out.print("\n Informe o valor (long) -> ");
                    x = scanner.nextLong();
                    if (!arv.remover(x))
                        System.out.print("\n Valor nao encontrado!");
                    
                    break;

                case 3:
                    System.out.println("Folhas: ");
                    arv.imprimirFolha();
                    break;

                case 4:
                    System.out.print("\n Informe o valor (long) -> ");
                    x = scanner.nextLong();
                    arv.descendentes(x);
                    break;

                case 5:
                    System.out.print("\n Informe o valor (long) -> ");
                    x = scanner.nextLong();
                    arv.noPaieFilho(x);
                    break;

                case 6:

                    break;

            } // fim switch
        } while (opcao != 0);

        scanner.close();
    }
}
