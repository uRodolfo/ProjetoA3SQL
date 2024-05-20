package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import Models.Amigos;
import Models.Ferramentas;

public class Menu {
    public static void exibirMenu(Connection conexao) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Adicionar ferramenta");
            System.out.println("2. Adicionar amigo");
            System.out.println("3. Ver itens");
            System.out.println("0. Sair");
            System.out.print("Opcao: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } else {
                System.out.println("Opcao invalida! Por favor, escolha um numero.");
                scanner.next(); // Consome a entrada inválida
                continue;
            }

            switch (escolha) {
                case 1:
                    adicionarFerramenta(scanner, conexao);
                    break;
                case 2:
                    adicionarAmigo(scanner, conexao);
                    break;
                case 3:
                    try {
                        Conexao.verItens(conexao);
                    } catch (SQLException ex) {
                        System.out.println("Erro ao recuperar itens: " + ex.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida! Por favor, escolha novamente.");
            }
        } while (escolha != 0);

        scanner.close();
    }

    private static void adicionarFerramenta(Scanner scanner, Connection conexao) {
        Ferramentas ferramenta = obterDadosFerramenta(scanner);
        try {
            Conexao.inserirFerramenta(conexao, ferramenta);
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir a ferramenta: " + ex.getMessage());
        }
    }

    private static Ferramentas obterDadosFerramenta(Scanner scanner) {
        System.out.println("Digite o nome da ferramenta:");
        String nome = scanner.nextLine();
        System.out.println("Digite a marca da ferramenta:");
        String marca = scanner.nextLine();
        System.out.println("Digite o custo de aquisicao da ferramenta:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada invalida! Digite um numero para o custo de aquisicao:");
            scanner.next(); // Consome a entrada inválida
        }
        double custo = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer

        return new Ferramentas(nome, marca, custo);
    }

    private static void adicionarAmigo(Scanner scanner, Connection conexao) {
        System.out.println("Digite o ID do amigo:");
        int id = scanner.nextInt();
        System.out.println("Digite o nome do amigo:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do amigo:");
        String telefone = scanner.nextLine();

        Amigos amigo = new Amigos(id, nome, telefone);
        try {
            Conexao.inserirAmigo(conexao, amigo);
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir o amigo: " + ex.getMessage());
        }
    }
}
