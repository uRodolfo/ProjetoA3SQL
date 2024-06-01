package Modelo;

import java.sql.Date;

public class Emprestimos {
    private int idEmprestimo;
    private int idFerramenta;
    private String nomeFerramenta;
    private Date dataEmprestimo;
    private Date dataDevolucaoEsperada;
    private int idUsuario;
    private String statusEmprestimo;

    public Emprestimos(int idEmprestimo, int idFerramenta, String nomeFerramenta, Date dataEmprestimo, Date dataDevolucaoEsperada, int idUsuario, String statusEmprestimo) {
        this.idEmprestimo = idEmprestimo;
        this.idFerramenta = idFerramenta;
        this.nomeFerramenta = nomeFerramenta;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoEsperada = dataDevolucaoEsperada;
        this.idUsuario = idUsuario;
        this.statusEmprestimo = statusEmprestimo;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public int getIdFerramenta() {
        return idFerramenta;
    }

    public String getNomeFerramenta() {
        return nomeFerramenta;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucaoEsperada() {
        return dataDevolucaoEsperada;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public void setIdFerramenta(int idFerramenta) {
        this.idFerramenta = idFerramenta;
    }

    public void setNomeFerramenta(String nomeFerramenta) {
        this.nomeFerramenta = nomeFerramenta;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucaoEsperada(Date dataDevolucaoEsperada) {
        this.dataDevolucaoEsperada = dataDevolucaoEsperada;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setStatusEmprestimo(String statusEmprestimo) {
        this.statusEmprestimo = statusEmprestimo;
    }
}
