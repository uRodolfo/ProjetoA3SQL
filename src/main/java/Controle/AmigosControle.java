package Controle;

import DAO.AmigosDAO;
import Modelo.Amigos;
import java.sql.SQLException;
import java.util.List;

public class AmigosControle {
    private AmigosDAO amigoDAO;

    public AmigosControle(AmigosDAO amigoDAO) {
        this.amigoDAO = amigoDAO;
    }

    public void adicionarAmigo(Amigos amigo, int idUsuario) throws SQLException {
        amigoDAO.adicionarAmigo(amigo, idUsuario);
    }

    // Correção aqui: o método deve retornar List<Integer>, não List<Amigos>
    public List<Integer> listarTodosIdsAmigos() throws SQLException {
        return amigoDAO.listarTodosIdsAmigos();
    }

    public List<Amigos> listarAmigos(int idUsuario) throws SQLException {
        return amigoDAO.listarAmigos(idUsuario);
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        amigoDAO.atualizarAmigo(amigo);
    }

    public void deletarAmigo(int id) throws SQLException {
        amigoDAO.deletarAmigo(id);
    }

    public void adicionarUsuario(int idUsuario, String nomeUsuario, String telefoneUsuario) throws SQLException {
        amigoDAO.adicionarUsuario(idUsuario, nomeUsuario, telefoneUsuario);
    }
}



