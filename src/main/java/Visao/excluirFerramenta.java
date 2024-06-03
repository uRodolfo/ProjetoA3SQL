/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField; 
import projetodb.projetoa3sql.Conexao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controle.AmigosControle;
import DAO.AmigosDAO;
import Modelo.Amigos;
import projetodb.projetoa3sql.Conexao;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import DAO.FerramentasDAO;
import Controle.FerramentasControle;
import projetodb.projetoa3sql.Conexao;
/**
 *
 * @author maria
 */
public class excluirFerramenta extends javax.swing.JFrame {

     private Connection conexao;

    public excluirFerramenta() {
        this.conexao = conexao;     
        initComponents();
        conectarBanco();
    }
private void conectarBanco() {
        try {
            conexao = Conexao.conectar();
            System.out.println("Conexão com o banco de dados estabelecida.");
            updateCombo(); // Atualiza a ComboBox após estabelecer a conexão
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boxExcluirFerramenta = new javax.swing.JComboBox<>();
        btnExcluir = new javax.swing.JButton();
        autualizarBD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Excluir Ferramenta");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Selecione uma ferramenta:");

        boxExcluirFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxExcluirFerramentaActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(boxExcluirFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(autualizarBD))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(btnExcluir)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(autualizarBD)
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxExcluirFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnExcluir)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String ferramentaSelecionada = (String) boxExcluirFerramenta.getSelectedItem();

        if (ferramentaSelecionada != null) {
            String sqlDelete = "DELETE FROM ferramentas WHERE nome_ferramenta = ?";

            try (PreparedStatement pstDelete = conexao.prepareStatement(sqlDelete)) {
                pstDelete.setString(1, ferramentaSelecionada);
                int affectedRows = pstDelete.executeUpdate();

                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(this, "Ferramenta excluída com sucesso.");
                    updateCombo();
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhuma ferramenta encontrada com esse nome.");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Esta Ferramenta pertence a um emprestimo, nao pode ser deletada ");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma ferramenta para excluir.");
        }
    
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void boxExcluirFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxExcluirFerramentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxExcluirFerramentaActionPerformed

    private void autualizarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autualizarBDActionPerformed
        updateCombo();          
    }//GEN-LAST:event_autualizarBDActionPerformed
     public void updateCombo() {
        System.out.println("Atualizando ComboBox");

        if (conexao == null) {
            JOptionPane.showMessageDialog(this, "Erro: Conexão ao banco de dados não estabelecida.");
            return;
        }

        String sqlNomes = "SELECT nome_ferramenta FROM ferramentas";

        try (PreparedStatement pstNomes = conexao.prepareStatement(sqlNomes);
             ResultSet rsNomes = pstNomes.executeQuery()) {

            boxExcluirFerramenta.removeAllItems(); // Limpar os itens existentes na combobox
            while (rsNomes.next()) {
                String nome = rsNomes.getString("nome_ferramenta");
                System.out.println("Adicionando nome: " + nome);
                boxExcluirFerramenta.addItem(nome);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar ComboBox: " + e.getMessage());
        }
    }
   
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
            java.util.logging.Logger.getLogger(excluirFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(excluirFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(excluirFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(excluirFerramenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new excluirFerramenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autualizarBD;
    private javax.swing.JComboBox<String> boxExcluirFerramenta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
