package view;

import Controller.AmigoController;
import Models.Amigos;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AmigosView {
    private static AmigoController controller = new AmigoController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            exibirOpcoesPrincipais();
            int opcao = obterOpcao();

            try {
                switch (opcao) {
                    case 1:
                        exibirMenu("Amigos");
                        break;
                    case 2:
                        exibirMenu("Ferramentas");
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
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
        return scanner.nextInt();
    }

    private static void exibirMenu(String tipo) throws SQLException {
        while (true) {
            System.out.println("------ Menu " + tipo + " ------");
            System.out.println("1. Adicionar " + tipo.substring(0, tipo.length() - 1));
            System.out.println("2. Listar " + tipo);
            System.out.println("3. Atualizar " + tipo.substring(0, tipo.length() - 1));
            System.out.println("4. Deletar " + tipo.substring(0, tipo.length() - 1));
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = obterOpcao();

            switch (opcao) {
                case 1:
                    adicionarItem(tipo);
                    break;
                case 2:
                    listarItens(tipo);
                    break;
                case 3:
                    atualizarItem(tipo);
                    break;
                case 4:
                    deletarItem(tipo);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarItem(String tipo) throws SQLException {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        controller.adicionarItem(tipo, nome, telefone);
        System.out.println(tipo.substring(0, tipo.length() - 1) + " adicionado com sucesso!");
    }

    private static void listarItens(String tipo) throws SQLException {
        List<Amigos> itens = controller.listarItens(tipo);
        for (Amigos item : itens) {
            System.out.println(item.getId() + " - " + item.getNome() + " - " + item.getTelefone());
        }
    }

    private static void atualizarItem(String tipo) throws SQLException {
        System.out.print("ID do " + tipo.substring(0, tipo.length() - 1) + ": ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        controller.atualizarItem(tipo, id, nome, telefone);
        System.out.println(tipo.substring(0, tipo.length() - 1) + " atualizado com sucesso!");
    }

    private static void deletarItem(String tipo) throws SQLException {
        System.out.print("ID do " + tipo.substring(0, tipo.length() - 1) + ": ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        controller.deletarItem(tipo, id);
        System.out.println(tipo.substring(0, tipo.length() - 1) + " deletado com sucesso!");
    }
}
