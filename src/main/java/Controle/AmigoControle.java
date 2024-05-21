package Controle;

import DAO.AmigosDAO;
import Modelo.Amigos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class AmigoControle {
    private AmigosDAO amigoDAO;

    public AmigoControle() {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/a3", "root", "root");
            amigoDAO = new AmigosDAO(conexao);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void adicionarAmigo(Amigos amigo) throws SQLException {
        amigoDAO.adicionarAmigo(amigo);
    }

    public List<Amigos> listarAmigos() throws SQLException {
        return amigoDAO.listarAmigos();
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        amigoDAO.atualizarAmigo(amigo);
    }

    public void deletarAmigo(int id) throws SQLException {
        amigoDAO.deletarAmigo(id);
    }
}
