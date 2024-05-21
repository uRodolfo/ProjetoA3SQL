package projetodb.projetoa3sql;

import Controle.AmigoControle;
import Controle.FerramentaControle;
import DAO.AmigosDAO;
import dao.FerramentaDAO;
import Modelo.Amigos;
import Modelo.Ferramentas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static AmigoControle amigoController;
    private static FerramentaControle ferramentaController;
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenu(Connection conexao) throws SQLException {
        amigoController = new AmigoControle(new AmigosDAO(conexao));
        ferramentaController = new FerramentaControle(new FerramentaDAO(conexao));

        while (true) {
            exibirOpcoesPrincipais();
            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    exibirMenuAmigos();
                    break;
                case 2:
                    exibirMenuFerramentas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirOpcoesPrincipais() {
        System.out.println("------ Menu Principal ------");
        System.out.println("1. Opções de Amigos");
        System.out.println("2. Opções de Ferramentas");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao() {
        while (!scanner.hasNextInt()) {
            System.out.println("Opção inválida. Tente novamente.");
            scanner.nextLine(); // Limpar o buffer
        }
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        return opcao;
    }

    private static void exibirMenuAmigos() throws SQLException {
        while (true) {
            System.out.println("------ Menu Amigos ------");
            System.out.println("1. Adicionar Amigo");
            System.out.println("2. Listar Amigos");
            System.out.println("3. Atualizar Amigo");
            System.out.println("4. Deletar Amigo");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    adicionarAmigo();
                    break;
                case 2:
                    listarAmigos();
                    break;
                case 3:
                    atualizarAmigo();
                    break;
                case 4:
                    deletarAmigo();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenuFerramentas() throws SQLException {
        while (true) {
            System.out.println("------ Menu Ferramentas ------");
            System.out.println("1. Adicionar Ferramenta");
            System.out.println("2. Listar Ferramentas");
            System.out.println("3. Atualizar Ferramenta");
            System.out.println("4. Deletar Ferramenta");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    adicionarFerramenta();
                    break;
                case 2:
                    listarFerramentas();
                    break;
                case 3:
                    atualizarFerramenta();
                    break;
                case 4:
                    deletarFerramenta();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarAmigo() throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Amigos amigo = new Amigos(0, nome, telefone);
        amigoController.adicionarAmigo(amigo);
        System.out.println("Amigo adicionado com sucesso!");
    }

    private static void listarAmigos() throws SQLException {
        List<Amigos> amigos = amigoController.listarAmigos();
        for (Amigos amigo : amigos) {
            System.out.println(amigo.getId() + " - " + amigo.getNome() + " - " + amigo.getTelefone());
        }
    }

    private static void atualizarAmigo() throws SQLException {
        System.out.print("ID do Amigo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Amigos amigo = new Amigos(id, nome, telefone);
        amigoController.atualizarAmigo(amigo);
        System.out.println("Amigo atualizado com sucesso!");
    }

    private static void deletarAmigo() throws SQLException {
        System.out.print("ID do Amigo: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        amigoController.deletarAmigo(id);
        System.out.println("Amigo deletado com sucesso!");
    }

    private static void adicionarFerramenta() throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Custo: ");
        double custo = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        Ferramentas ferramenta = new Ferramentas(0, nome, marca, custo);
        ferramentaController.adicionarFerramenta(ferramenta);
        System.out.println("Ferramenta adicionada com sucesso!");
    }

    private static void listarFerramentas() throws SQLException {
        List<Ferramentas> ferramentas = ferramentaController.listarFerramentas();
        for (Ferramentas ferramenta : ferramentas) {
            System.out.println(ferramenta.getId() + " - " + ferramenta.getNome() + " - " + ferramenta.getMarca() + " - " + ferramenta.getCusto());
        }
    }

    private static void atualizarFerramenta() throws SQLException {
        System.out.print("ID da Ferramenta: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Custo: ");
        double custo = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer

        Ferramentas ferramenta = new Ferramentas(id, nome, marca, custo);
        ferramentaController.atualizarFerramenta(ferramenta);
        System.out.println("Ferramenta atualizada com sucesso!");
    }

    private static void deletarFerramenta() throws SQLException {
        System.out.print("ID da Ferramenta: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        ferramentaController.deletarFerramenta(id);
        System.out.println("Ferramenta deletada com sucesso!");
    }
}
