package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import projetodb.projetoa3sql.Cadastro.Amigos;
import projetodb.projetoa3sql.Cadastro.Ferramentas;

public class Menu {
    public static void exibirMenu(Connection conexao) {
        Scanner scanner = new Scanner(System.in);
        int escolha = -1;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar ferramenta");
            System.out.println("2. Adicionar amigo");
            System.out.println("3. Ver itens");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
            } else {
                System.out.println("Opção inválida! Por favor, escolha um número.");
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
                    System.out.println("Opção inválida! Por favor, escolha novamente.");
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
        System.out.println("Digite o custo de aquisição da ferramenta:");
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada inválida! Digite um número para o custo de aquisição:");
            scanner.next(); // Consome a entrada inválida
        }
        double custo = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer

        return new Ferramentas(nome, marca, custo);
    }

    private static void adicionarAmigo(Scanner scanner, Connection conexao) {
        System.out.println("Digite o nome do amigo:");
        String nome = scanner.nextLine();
        System.out.println("Digite o telefone do amigo:");
        String telefone = scanner.nextLine();

        Amigos amigo = new Amigos(nome, telefone);
        try {
            Conexao.inserirAmigo(conexao, amigo);
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir o amigo: " + ex.getMessage());
        }
    }
}
