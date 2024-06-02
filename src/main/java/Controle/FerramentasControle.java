package Controle;

import DAO.FerramentasDAO;
import Modelo.Ferramentas;
import java.sql.SQLException;
import java.util.List;

public class FerramentasControle {
    private FerramentasDAO ferramentaDAO;

    public FerramentasControle(FerramentasDAO ferramentaDAO) {
        this.ferramentaDAO = ferramentaDAO;
    }

    public void adicionarFerramenta(Ferramentas ferramenta, int quantidade) throws SQLException {
        ferramentaDAO.adicionarFerramenta(ferramenta, quantidade);
    }

    public List<Ferramentas> listarFerramentas() throws SQLException {
        return ferramentaDAO.listarFerramentas();
    }

    public void atualizarFerramenta(Ferramentas ferramenta) throws SQLException {
        ferramentaDAO.atualizarFerramenta(ferramenta);
    }

    public void deletarFerramenta(int id) throws SQLException {
        ferramentaDAO.deletarFerramenta(id);
    }
}
