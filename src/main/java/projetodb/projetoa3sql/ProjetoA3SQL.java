package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ProjetoA3SQL {
    private static final String URL = "jdbc:mysql://localhost:3306/standard";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void main(String[] args) {
        Connection conexao = null;
        Scanner scanner = new Scanner(System.in);
        try {
            conexao = getConnection();
            System.out.println("Conexão bem-sucedida ao banco de dados");
            
            int escolha;
            do {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Adicionar ferramenta");
                System.out.println("2. Adicionar amigo");
                System.out.println("0. Sair");
                System.out.print("Opção: ");
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        Menu.adicionarFerramenta(scanner, conexao);
                        break;
                    case 2:
                        Menu.adicionarAmigo(scanner, conexao);
                        break;
                    case 0:
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha novamente.");
                }
            } while (escolha != 0);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
                }
            }
            scanner.close();
        }
    }
}
