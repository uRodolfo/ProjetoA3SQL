package projetodb.projetoa3sql;

import Models.Amigos;
import Models.Ferramentas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public static void verItens(Connection conexao) throws SQLException {
        String sqlAmigos = "SELECT * FROM Amigos";
        String sqlFerramentas = "SELECT * FROM Ferramentas";

        try (PreparedStatement pstmtAmigos = conexao.prepareStatement(sqlAmigos);
             PreparedStatement pstmtFerramentas = conexao.prepareStatement(sqlFerramentas)) {

            System.out.println("Amigos:");
            try (ResultSet rs = pstmtAmigos.executeQuery()) {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String telefone = rs.getString("telefone");
                    System.out.println("Nome: " + nome + ", Telefone: " + telefone);
                }
            }

            System.out.println("\nFerramentas:");
            try (ResultSet rs = pstmtFerramentas.executeQuery()) {
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String marca = rs.getString("marca");
                    double custoDeAquisicao = rs.getDouble("custoDeAquisicao");
                    System.out.println("Nome: " + nome + ", Marca: " + marca + ", Custo de Aquisição: " + custoDeAquisicao);
                }
            }
        }
    }
}
