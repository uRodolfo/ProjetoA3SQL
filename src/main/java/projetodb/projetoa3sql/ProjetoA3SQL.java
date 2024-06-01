package projetodb.projetoa3sql;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import sistemaEmprestimoGUI.registroEmprestimo;
import projetodb.projetoa3sql.Conexao;

public class ProjetoA3SQL {
    private static Connection conexao = null;

    public static void main(String[] args) {
        try {
            conexao = Conexao.conectar();
            System.out.println("Conexão bem-sucedida ao banco de dados");

            // Criar e exibir o JFrame
            registroEmprestimo objetotela = new registroEmprestimo();

            // Adicionar um listener para fechar a conexão quando o JFrame for fechado
            objetotela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            objetotela.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    if (conexao != null) {
                        try {
                            conexao.close();
                            System.out.println("Conexão fechada");
                        } catch (SQLException ex) {
                            System.out.println("Erro ao fechar a conexão: " + ex.getMessage());
                        }
                    }
                }
            });

            objetotela.setVisible(true);

        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }
}
