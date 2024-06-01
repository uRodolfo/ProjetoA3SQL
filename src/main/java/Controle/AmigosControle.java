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

    public List<Amigos> listarAmigos(int idUsuario) throws SQLException {
        return amigoDAO.listarAmigos(idUsuario);
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        amigoDAO.atualizarAmigo(amigo);
    }

    public void deletarAmigo(int id) throws SQLException {
        amigoDAO.deletarAmigo(id);
    }
}
