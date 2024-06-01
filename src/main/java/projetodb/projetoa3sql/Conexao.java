package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/standard"; // Substitua "seuBancoDeDados" pelo nome do seu banco de dados
    private static final String USUARIO = "root"; // Substitua "seuUsuario" pelo seu usuário do MySQL
    private static final String SENHA = "root"; // Substitua "suaSenha" pela sua senha do MySQL

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
