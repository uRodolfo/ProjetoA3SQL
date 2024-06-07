/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetodb.projetoa3sql.Conexao;

/**
 * Classe para exibir o relatório de histórico de empréstimos
 * Esta classe representa a interface gráfica para visualizar e atualizar o histórico de empréstimos
 */
public class relatorioHistoricoEmprestimo extends javax.swing.JFrame {

    /**
     * Cria uma nova instância da classe relatorioHistoricoEmprestimo
     * Inicializa os componentes da interface gráfica e atualiza os dados do banco
     */
    public relatorioHistoricoEmprestimo() {
        initComponents(); // Inicializa os componentes da interface gráfica
        atualizarBanco(); // Atualiza a tabela com os dados do banco
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableEmprestimosAtivos = new javax.swing.JTable();
        autualizarBD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico de Empréstimos");
        setResizable(false);

        tableEmprestimosAtivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Ferramenta", "Marca", "Custo de Aquisição", "Data de Empréstimo", "Data de Devolução Esperada", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableEmprestimosAtivos.setShowGrid(true);
        jScrollPane1.setViewportView(tableEmprestimosAtivos);

        autualizarBD.setText("Atualizar banco de dados");
        autualizarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autualizarBDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(578, 578, 578)
                .addComponent(autualizarBD)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(autualizarBD)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void atualizarBanco() {
       try {
            // 1. Estabelecer conexão com o banco de dados
            Connection conexao = Conexao.conectar();

            // 2. Escrever a consulta SQL para selecionar os empréstimos ativos com informações adicionais
            String sql = "SELECT e.id_emprestimo, a.nome_usuario, a.telefone_usuario, f.nome_ferramenta, f.marca_ferramenta, f.preco, e.data_emprestimo, e.data_devolucao_esperada, e.status_emprestimo FROM Emprestimos e JOIN amigos a ON e.id_amigo = a.id_amigo JOIN ferramentas f ON e.id_ferramenta = f.id_ferramenta";

            // 3. Executar a consulta SQL
            try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
                ResultSet rs = pstmt.executeQuery();

                // Limpar a tabela antes de adicionar novos dados
                DefaultTableModel model = (DefaultTableModel) tableEmprestimosAtivos.getModel();
                model.setRowCount(0);

                // Processar os resultados e preencher a tabela de empréstimos ativos
                while (rs.next()) {
                    int id = rs.getInt("id_emprestimo");
                    String nomeUsuario = rs.getString("nome_usuario");
                    String telefoneUsuario = rs.getString("telefone_usuario");
                    String nomeFerramenta = rs.getString("nome_ferramenta");
                    String marcaFerramenta = rs.getString("marca_ferramenta");
                    double preco = rs.getDouble("preco");
                    String dataEmprestimo = rs.getString("data_emprestimo");
                    String dataDevolucaoEsperada = rs.getString("data_devolucao_esperada");
                    String statusEmprestimo = rs.getString("status_emprestimo");

                    // Adiciona a linha de dados na tabela
                    Object[] rowData = {id, nomeUsuario, telefoneUsuario, nomeFerramenta, marcaFerramenta, preco, dataEmprestimo, dataDevolucaoEsperada, statusEmprestimo};
                    model.addRow(rowData);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao recuperar dados dos empréstimos ativos: " + e.getMessage()); // Exibe mensagem de erro
        }
    }
    private void autualizarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autualizarBDActionPerformed
 atualizarBanco();
    }//GEN-LAST:event_autualizarBDActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(relatorioHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relatorioHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relatorioHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relatorioHistoricoEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relatorioHistoricoEmprestimo().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autualizarBD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableEmprestimosAtivos;
    // End of variables declaration//GEN-END:variables
}
