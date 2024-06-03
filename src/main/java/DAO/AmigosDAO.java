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

    public void adicionarAmigo(Amigos amigo, int idUsuario) throws SQLException {
        String sql = "INSERT INTO amigos (id_usuario, nome_usuario, telefone_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setString(2, amigo.getNome());
            stmt.setString(3, amigo.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Integer> listarTodosIdsAmigos() throws SQLException {
        List<Integer> ids = new ArrayList<>();
        String sql = "SELECT id_usuario FROM amigos";
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ids.add(rs.getInt("id_usuario"));
            }
        }
        return ids;
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
            stmt.setInt(3, amigo.getIdUsuario());
            stmt.executeUpdate();
        }
    }

    public void deletarAmigo(int id, String nomeUsuario) throws SQLException {
        String sql = "DELETE FROM amigos WHERE id_usuario = ? AND nome_usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, nomeUsuario);
            stmt.executeUpdate();
        }
    }

    public void adicionarUsuario(int idUsuario, String nomeUsuario, String telefoneUsuario) throws SQLException {
        String sql = "INSERT INTO amigos (id_usuario, nome_usuario, telefone_usuario) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setString(2, nomeUsuario);
            stmt.setString(3, telefoneUsuario);
            stmt.executeUpdate();
        }
    }

    // Método para obter o ID do usuário com base no nome do usuário
    public int obterIdUsuario(String nomeUsuario) throws SQLException {
        String sql = "SELECT id_usuario FROM amigos WHERE nome_usuario = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_usuario");
                }
            }
        }
        return -1; // Retorna -1 se o usuário não for encontrado
    }
}
