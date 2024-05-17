package projetodb.projetoa3sql;

import projetodb.projetoa3sql.Cadastro.Amigos;
import projetodb.projetoa3sql.Cadastro.Ferramentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    public static void inserirAmigo(Connection conexao, Amigos amigo) throws SQLException {
        String sql = "INSERT INTO Amigos (nome, telefone) VALUES (?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, amigo.getNome());
            pstmt.setString(2, amigo.getTelefone());
            pstmt.executeUpdate();
            System.out.println("Amigo inserido na tabela Amigos: " + amigo.getNome());
        }
    }

    public static void inserirFerramenta(Connection conexao, Ferramentas ferramenta) throws SQLException {
        String sql = "INSERT INTO Ferramentas (nome, marca, custoDeAquisicao) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setString(1, ferramenta.getNome());
            pstmt.setString(2, ferramenta.getMarca());
            pstmt.setDouble(3, ferramenta.getCustoDeAquisicao());
            pstmt.executeUpdate();
            System.out.println("Ferramenta inserida na tabela Ferramentas: " + ferramenta.getNome());
        }
    }
}
