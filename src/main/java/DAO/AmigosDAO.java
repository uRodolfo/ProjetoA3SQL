package DAO;

import Modelo.Amigos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmigosDAO {
    private Connection conexao;

    public AmigosDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarAmigo(String nomeAmigo, String telefoneAmigo) throws SQLException {
        String sql = "INSERT INTO amigos (nome_usuario, telefone_usuario) VALUES (?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nomeAmigo);
            stmt.setString(2, telefoneAmigo);
            stmt.executeUpdate();
        }
    }

    public List<Amigos> listarAmigos() throws SQLException {
        List<Amigos> amigos = new ArrayList<>();
        String sql = "SELECT * FROM amigos";
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Amigos amigo = new Amigos(
                    rs.getInt("id_amigo"),
                    rs.getString("nome_usuario"),
                    rs.getString("telefone_usuario")
                );
                amigos.add(amigo);
            }
        }
        return amigos;
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        String sql = "UPDATE amigos SET nome_usuario = ?, telefone_usuario = ? WHERE id_amigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getTelefone());
            stmt.setInt(3, amigo.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public void deletarAmigo(int idUsuario) throws SQLException {
        String sql = "DELETE FROM amigos WHERE id_amigo = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.executeUpdate();
        }
    }

    // Método para obter o ID do usuário com base no nome do usuário
    public int obterIdUsuario(String nomeUsuario) throws SQLException {
        String sql = "SELECT id_amigo FROM amigos WHERE nome_usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_amigo");
                }
            }
        }
        return -1; // Retorna -1 se o usuário não for encontrado
    }
    
    public String obterTelefoneUsuario(String nomeAmigo) throws SQLException {
    String telefoneUsuario = null;

    String sql = "SELECT telefone_usuario FROM amigos WHERE nome_usuario = ?";
    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
        pstmt.setString(1, nomeAmigo);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            telefoneUsuario = rs.getString("telefone_usuario");
        }
    }

    return telefoneUsuario;
}
}
