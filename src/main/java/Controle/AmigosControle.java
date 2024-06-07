package Controle;

import DAO.AmigosDAO;
import Modelo.Amigos;
import java.sql.SQLException;
import java.util.List;

public class AmigosControle {
    private AmigosDAO amigoDAO;

    // Construtor da classe que recebe um objeto AmigosDAO como parâmetro
    public AmigosControle(AmigosDAO amigoDAO) {
        this.amigoDAO = amigoDAO;
    }

    // Método para adicionar um novo amigo ao banco de dados
    public void adicionarAmigo(String nomeAmigo, String telefoneAmigo) throws SQLException {
        amigoDAO.adicionarAmigo(nomeAmigo, telefoneAmigo);
    }

    // Método para listar todos os amigos cadastrados no banco de dados
    public List<Amigos> listarAmigos() throws SQLException {
        return amigoDAO.listarAmigos();
    }

    // Método para atualizar os dados de um amigo no banco de dados
    public void atualizarAmigo(Amigos amigo) throws SQLException {
        amigoDAO.atualizarAmigo(amigo);
    }

    // Método para deletar um amigo do banco de dados com base no ID do usuário
    public void deletarAmigo(int idUsuario) throws SQLException {
        amigoDAO.deletarAmigo(idUsuario);
    }

    // Método para obter o ID de um usuário com base no seu nome
    public int obterIdUsuario(String nomeUsuario) throws SQLException {
        return amigoDAO.obterIdUsuario(nomeUsuario);
    }
}
