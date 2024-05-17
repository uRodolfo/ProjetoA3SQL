package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProjetoA3SQL {
    private static final String URL = "jdbc:mysql://localhost:3306/standard";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            conexao = getConnection();
            System.out.println("Conexão bem-sucedida ao banco de dados");
            Menu.exibirMenu(conexao);
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
        }
    }
}
