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

    public void adicionarAmigo(Amigos amigo) throws SQLException {
        String sql = "INSERT INTO amigos (id, nome, telefone) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, amigo.getNome());
            stmt.setInt(2, amigo.getId());
            stmt.setString(3, amigo.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Amigos> listarAmigos() throws SQLException {
        List<Amigos> amigos = new ArrayList<>();
        String sql = "SELECT * FROM amigos";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Amigos amigo = new Amigos();
                amigo.setId(rs.getInt("id"));
                amigo.setNome(rs.getString("nome"));
                amigo.setTelefone(rs.getString("telefone"));
                amigos.add(amigo);
            }
        }
        return amigos;
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        String sql = "UPDATE amigos SET nome = ?, email = ?, telefone = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, amigo.getNome());

            stmt.setString(3, amigo.getTelefone());
            stmt.setInt(4, amigo.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarAmigo(int id) throws SQLException {
        String sql = "DELETE FROM amigos WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
