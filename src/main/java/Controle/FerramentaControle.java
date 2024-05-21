package Controle;

import dao.FerramentaDAO;
import Modelo.Ferramentas;
import java.sql.SQLException;
import java.util.List;

public class FerramentaControle {
    private FerramentaDAO ferramentaDAO;

    public FerramentaControle(FerramentaDAO ferramentaDAO) {
        this.ferramentaDAO = ferramentaDAO;
    }

    public void adicionarFerramenta(Ferramentas ferramenta) throws SQLException {
        ferramentaDAO.adicionarFerramenta(ferramenta);
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
