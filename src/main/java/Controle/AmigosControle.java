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

    public void adicionarAmigo(String nomeAmigo, String telefoneAmigo) throws SQLException {
        amigoDAO.adicionarAmigo(nomeAmigo, telefoneAmigo);
    }

    public List<Amigos> listarAmigos() throws SQLException {
        return amigoDAO.listarAmigos();
    }

    public void atualizarAmigo(Amigos amigo) throws SQLException {
        amigoDAO.atualizarAmigo(amigo);
    }

    public void deletarAmigo(int idUsuario) throws SQLException {
        amigoDAO.deletarAmigo(idUsuario);
    }

    public int obterIdUsuario(String nomeUsuario) throws SQLException {
        return amigoDAO.obterIdUsuario(nomeUsuario);
    }
}
