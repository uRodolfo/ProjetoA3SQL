package Controle;

import DAO.EmprestimosDAO;
import Modelo.Emprestimos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmprestimosControle {
    private EmprestimosDAO emprestimoDAO;

    public EmprestimosControle(EmprestimosDAO emprestimoDAO) {
        this.emprestimoDAO = emprestimoDAO;
    }

   public void criarEmprestimo(Connection conexao, Emprestimos emprestimo, String idUsuarioStr) throws SQLException {
    int idUsuario = Integer.parseInt(idUsuarioStr); // Convertendo a String para int
    emprestimoDAO.criarEmprestimo(conexao, emprestimo, idUsuario); // Passando o int idUsuario
}


    public Emprestimos lerEmprestimoPorId(Connection conexao, int id) throws SQLException {
        return emprestimoDAO.lerEmprestimoPorId(conexao, id);
    }

    public void atualizarEmprestimo(Connection conexao, Emprestimos emprestimo) throws SQLException {
        emprestimoDAO.atualizarEmprestimo(conexao, emprestimo);
    }

    public void excluirEmprestimo(Connection conexao, int id) throws SQLException {
        emprestimoDAO.excluirEmprestimo(conexao, id);
    }

    public List<Emprestimos> listarEmprestimos(Connection conexao) throws SQLException {
        return emprestimoDAO.listarEmprestimos(conexao);
    }
}
