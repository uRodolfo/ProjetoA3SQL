package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void conectar() {
        Connection conexao = null;
        try {
            System.out.println("deu certo..?");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String nomeBanco = System.getProperty("standard"); 
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeBanco, "root", "root");
            System.out.println("Conexão bem-sucedida ao banco de dados: " + nomeBanco);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver JDBC não encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        } finally {
            // Bloco finally para garantir que a conexão seja fechada, caso tenha sido aberta
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
            }
        }
    }
}
