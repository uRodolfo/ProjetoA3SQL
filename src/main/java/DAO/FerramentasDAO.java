package DAO;

import Modelo.Ferramentas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FerramentasDAO {
    private Connection conexao;

    public FerramentasDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionarFerramenta(Ferramentas ferramenta) throws SQLException {
        String sql = "INSERT INTO ferramentas (id_ferramenta, nome_ferramenta, marca_ferramenta, preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, ferramenta.getId());
            stmt.setString(2, ferramenta.getNome());
            stmt.setString(3, ferramenta.getMarca());
            stmt.setDouble(4, ferramenta.getCusto());
            stmt.executeUpdate();
        }
    }

    public List<Ferramentas> listarFerramentas() throws SQLException {
        List<Ferramentas> ferramentas = new ArrayList<>();
        String sql = "SELECT * FROM ferramentas";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ferramentas ferramenta = new Ferramentas(
                    rs.getInt("id_ferramenta"),
                    rs.getString("nome_ferramenta"),
                    rs.getString("marca_ferramenta"),
                    rs.getDouble("preco")
                );
                ferramentas.add(ferramenta);
            }
        }
        return ferramentas;
    }

    public void atualizarFerramenta(Ferramentas ferramenta) throws SQLException {
        String sql = "UPDATE ferramentas SET nome_ferramenta = ?, marca_ferramenta = ?, preco = ? WHERE id_ferramenta = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, ferramenta.getNome());
            stmt.setString(2, ferramenta.getMarca());
            stmt.setDouble(3, ferramenta.getCusto());
            stmt.setInt(4, ferramenta.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarFerramenta(int id) throws SQLException {
        String sql = "DELETE FROM ferramentas WHERE id_ferramenta = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

