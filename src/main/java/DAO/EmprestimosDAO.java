package DAO;

import Modelo.Emprestimos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmprestimosDAO {

    private static final Logger LOGGER = Logger.getLogger(EmprestimosDAO.class.getName());

    public static void criarEmprestimo(Connection conexao, Emprestimos emprestimo, int idUsuario) throws SQLException {
        String sql = "INSERT INTO Emprestimos (id_ferramenta, nome_ferramenta, data_emprestimo, data_devolucao_esperada, id_usuario, status_emprestimo) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, emprestimo.getIdFerramenta());
            pstmt.setString(2, emprestimo.getNomeFerramenta());
            pstmt.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            pstmt.setDate(4, new java.sql.Date(emprestimo.getDataDevolucaoEsperada().getTime()));
            pstmt.setInt(5, idUsuario);
            pstmt.setString(6, emprestimo.getStatusEmprestimo());
            pstmt.executeUpdate();
            LOGGER.log(Level.INFO, "Empréstimo criado com sucesso.");
        }
    }

    public static Emprestimos lerEmprestimoPorId(Connection conexao, int id) throws SQLException {
        String sql = "SELECT * FROM Emprestimos WHERE id_emprestimo = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Emprestimos(
                    rs.getInt("id_emprestimo"),
                    rs.getInt("id_ferramenta"),
                    rs.getString("nome_ferramenta"),
                    rs.getDate("data_emprestimo"),
                    rs.getDate("data_devolucao_esperada"),
                    rs.getInt("id_usuario"),
                    rs.getString("status_emprestimo")
                );
            }
            return null;
        }
    }

    public static void atualizarEmprestimo(Connection conexao, Emprestimos emprestimo) throws SQLException {
        String sql = "UPDATE Emprestimos SET id_ferramenta = ?, nome_ferramenta = ?, data_emprestimo = ?, data_devolucao_esperada = ?, id_usuario = ?, status_emprestimo = ? WHERE id_emprestimo = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, emprestimo.getIdFerramenta());
            pstmt.setString(2, emprestimo.getNomeFerramenta());
            pstmt.setDate(3, new java.sql.Date(emprestimo.getDataEmprestimo().getTime()));
            pstmt.setDate(4, new java.sql.Date(emprestimo.getDataDevolucaoEsperada().getTime()));
            pstmt.setInt(5, emprestimo.getIdUsuario());
            pstmt.setString(6, emprestimo.getStatusEmprestimo());
            pstmt.setInt(7, emprestimo.getIdEmprestimo());
            pstmt.executeUpdate();
            LOGGER.log(Level.INFO, "Empréstimo atualizado com sucesso.");
        }
    }

    public static void excluirEmprestimo(Connection conexao, int id) throws SQLException {
        String sql = "DELETE FROM Emprestimos WHERE id_emprestimo = ?";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            LOGGER.log(Level.INFO, "Empréstimo excluído com sucesso.");
        }
    }

    public static List<Emprestimos> listarEmprestimos(Connection conexao) throws SQLException {
        List<Emprestimos> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Emprestimos";
        try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Emprestimos emprestimo = new Emprestimos(
                    rs.getInt("id_emprestimo"),
                    rs.getInt("id_ferramenta"),
                    rs.getString("nome_ferramenta"),
                    rs.getDate("data_emprestimo"),
                    rs.getDate("data_devolucao_esperada"),
                    rs.getInt("id_usuario"),
                    rs.getString("status_emprestimo")
                );
                emprestimos.add(emprestimo);
            }
        }
        return emprestimos;
    }
    
    public static void atualizarStatusEmprestimos(Connection conexao) throws SQLException {
        String sqlSelect = "SELECT id_emprestimo, data_devolucao_esperada FROM Emprestimos";
        String sqlUpdate = "UPDATE Emprestimos SET status_emprestimo = ? WHERE id_emprestimo = ?";

        try (
            PreparedStatement pstSelect = conexao.prepareStatement(sqlSelect);
            ResultSet rs = pstSelect.executeQuery();
            PreparedStatement pstUpdate = conexao.prepareStatement(sqlUpdate)
        ) {
            Date dataAtual = new Date(System.currentTimeMillis());

            while (rs.next()) {
                int idEmprestimo = rs.getInt("id_emprestimo");
                Date dataDevolucao = rs.getDate("data_devolucao_esperada");
                String novoStatus = dataAtual.after(dataDevolucao) ? "Atrasado" : "Em dia";

                pstUpdate.setString(1, novoStatus);
                pstUpdate.setInt(2, idEmprestimo);
                pstUpdate.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar status dos empréstimos: {0}", e.getMessage());
            throw e;
        }
    }
}
