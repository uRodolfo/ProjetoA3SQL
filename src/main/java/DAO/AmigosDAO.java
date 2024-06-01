package DAO;

import Modelo.Amigos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AmigosDAO {
    private Connection conexao;

    public AmigosDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarAmigo(Amigos amigo, int idUsuario) throws SQLException {
        String sql = "INSERT INTO amigos (nome_usuario, telefone_usuario, id_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getTelefone());
            stmt.setInt(3, idUsuario);
            stmt.executeUpdate();
        }
    }

    public List<Amigos> listarAmigos(int idUsuario) throws SQLException {
        List<Amigos> amigos = new ArrayList<>();
        String sql = "SELECT * FROM amigos WHERE id_usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Amigos amigo = new Amigos(
                        rs.getInt("id_usuario"),
                        rs.getString("nome_usuario"),
                        rs.getString("telefone_usuario")
                    );
                    amigos.add(amigo);
                }
            }
        }
        return amigos;
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        String sql = "UPDATE amigos SET nome_usuario = ?, telefone_usuario = ? WHERE id_usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, amigo.getNome());
            stmt.setString(2, amigo.getTelefone());
            stmt.setInt(3, amigo.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarAmigo(int id) throws SQLException {
        String sql = "DELETE FROM amigos WHERE id_usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
