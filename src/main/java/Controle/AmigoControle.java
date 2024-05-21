package controle;

import DAO.AmigosDAO;
import modelo.Amigos;

import java.sql.SQLException;
import java.util.List;

public class AmigoControle {
    private AmigosDAO amigoDAO;

    public AmigoControle(AmigosDAO amigoDAO) {
        this.amigoDAO = amigoDAO;
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
