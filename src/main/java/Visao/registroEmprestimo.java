
package Visao;


import javax.swing.JTextField; 
import Controle.AmigosControle;
import DAO.AmigosDAO;
import projetodb.projetoa3sql.Conexao;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import Modelo.Emprestimos;
import DAO.EmprestimosDAO;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Registro de Empréstimo
 * Autor: Maria
 */
public class registroEmprestimo extends javax.swing.JFrame {
    private Connection conexao;
    private AmigosControle amigoControle;
    private JTextField JTFAmigo; // Declare JTFAmigo as a class-level variable
    private JTextField JTFFerramenta;
    
    public registroEmprestimo() {
        initComponents();
        JTFAmigo = new JTextField(); // Inicialize JTFAmigo aqui
        JTFFerramenta = new JTextField();
        try {
            // Obtendo a conexão com o banco de dados
            conexao = Conexao.conectar();
            
            // Inicializando o controle de amigos
            amigoControle = new AmigosControle(new AmigosDAO(conexao));
            
            // Definindo a localização relativa da janela
            this.setLocationRelativeTo(null); 

            // Atualiza a JComboBox ao iniciar a aplicação
            updateCombo();
            updateComboFerramentas();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // O restante do código da classe continua aqui...

    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonRegistrarEmprestimo = new javax.swing.JButton();
        itemAmigoRegistro = new javax.swing.JComboBox<>();
        itemFerramenta = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dataEmprestimo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        itemAmigoDevolucao = new javax.swing.JComboBox<>();
        itemFerramentaDevolucao = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        buttonRegistrarDevolucao = new javax.swing.JButton();
        dataDevolucao = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastrar = new javax.swing.JMenu();
        menuItemCadastrarAmigo = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuRFerramenta = new javax.swing.JMenuItem();
        menuREativos = new javax.swing.JMenuItem();
        menuRHistoricos = new javax.swing.JMenuItem();
        menuRDevedores = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Empréstimo de Ferramentas");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Empréstimo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel1.setText("Amigo:");

        jLabel2.setText("Ferramentas:");

        buttonRegistrarEmprestimo.setText("Registrar Empréstimo");
        buttonRegistrarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarEmprestimoActionPerformed(evt);
            }
        });

        itemAmigoRegistro.setMaximumRowCount(50);
        itemAmigoRegistro.setToolTipText("");
        itemAmigoRegistro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                itemAmigoRegistroItemStateChanged(evt);
            }
        });
        itemAmigoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAmigoRegistroActionPerformed(evt);
            }
        });

        itemFerramenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        itemFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFerramentaActionPerformed(evt);
            }
        });

        jLabel5.setText("Data de Empréstimo:");

        jLabel3.setText("Data de Empréstimo:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setText("Escreva da seguinte forma: YYYY - MM - DD");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Exemplo: 2024-06-02 (dia 2 de junho de 2024)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(buttonRegistrarEmprestimo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(itemAmigoRegistro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(itemFerramenta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 259, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(itemAmigoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(itemFerramenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(buttonRegistrarEmprestimo)
                .addGap(27, 27, 27))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registro de Devolução", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel4.setText("Amigo:");

        jLabel7.setText("Ferramenta:");

        itemAmigoDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAmigoDevolucaoActionPerformed(evt);
            }
        });

        itemFerramentaDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFerramentaDevolucaoActionPerformed(evt);
            }
        });

        jLabel6.setText("Data de Devolução:");

        buttonRegistrarDevolucao.setText("Registrar Devolução");
        buttonRegistrarDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarDevolucaoActionPerformed(evt);
            }
        });

        dataDevolucao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(40, 40, 40)
                        .addComponent(itemAmigoDevolucao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(itemFerramentaDevolucao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRegistrarDevolucao)
                .addGap(306, 306, 306))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(itemAmigoDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(itemFerramentaDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dataDevolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(buttonRegistrarDevolucao)
                .addGap(19, 19, 19))
        );

        menuCadastrar.setText("Cadastrar");

        menuItemCadastrarAmigo.setText("Amigos");
        menuItemCadastrarAmigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCadastrarAmigoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuItemCadastrarAmigo);

        jMenuItem2.setText("Ferramentas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCadastrar.add(jMenuItem2);

        jMenuBar1.add(menuCadastrar);

        jMenu2.setText("Gerenciar");

        jMenuItem1.setText("Gerenciar Amigos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("Gerenciar Ferramentas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Relatórios");

        menuRFerramenta.setText("Ferramentas e Custos");
        menuRFerramenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRFerramentaActionPerformed(evt);
            }
        });
        jMenu3.add(menuRFerramenta);

        menuREativos.setText("Empréstimos Ativos");
        menuREativos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuREativosActionPerformed(evt);
            }
        });
        jMenu3.add(menuREativos);

        menuRHistoricos.setText("Histórico de Empréstimos");
        menuRHistoricos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRHistoricosActionPerformed(evt);
            }
        });
        jMenu3.add(menuRHistoricos);

        menuRDevedores.setText("Devedores");
        menuRDevedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRDevedoresActionPerformed(evt);
            }
        });
        jMenu3.add(menuRDevedores);

        jMenuItem4.setText("Empréstimos por Amigo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistrarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarEmprestimoActionPerformed
     try {
    // Obter os dados do formulário
    String amigoSelecionado = (String) itemAmigoRegistro.getSelectedItem();
    String ferramentaSelecionada = (String) itemFerramenta.getSelectedItem();
    String dataEmprestimoStr = (String) dataEmprestimo.getText();

    // Verificar se todos os campos foram preenchidos
    if (amigoSelecionado.isEmpty() || ferramentaSelecionada.isEmpty() || dataEmprestimoStr.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.");
        return;
    }

    // Converter a data de empréstimo para o formato de data do SQL
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date parsedEmprestimoDate = format.parse(dataEmprestimoStr);
    java.sql.Date sqlDateEmprestimo = new java.sql.Date(parsedEmprestimoDate.getTime());

    // Calcular a data de devolução esperada (7 dias após a data de empréstimo)
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(parsedEmprestimoDate);
    calendar.add(Calendar.DAY_OF_YEAR, 7);
    java.sql.Date sqlDateDevolucao = new java.sql.Date(calendar.getTimeInMillis());

    // Criar um objeto de Empréstimo com os dados do formulário
    Emprestimos emprestimo = new Emprestimos(0, getFerramentaId(ferramentaSelecionada), ferramentaSelecionada, sqlDateEmprestimo, sqlDateDevolucao, getUsuarioId(amigoSelecionado), "Emprestado");

    // Chamar o método do DAO para registrar o empréstimo
    EmprestimosDAO.criarEmprestimo(conexao, emprestimo, getUsuarioId(amigoSelecionado));

    // Exibir uma mensagem de sucesso
    JOptionPane.showMessageDialog(this, "Empréstimo registrado com sucesso.");
} catch (ParseException e) {
    // Em caso de erro de parsing de data, exibir uma mensagem de erro
    JOptionPane.showMessageDialog(this, "Erro ao converter data: " + e.getMessage());
} catch (SQLException e) {
    // Em caso de erro de SQL, exibir uma mensagem de erro
    JOptionPane.showMessageDialog(this, "Erro ao registrar empréstimo: " + e.getMessage());
}
}

// Método auxiliar para obter o ID da ferramenta pelo nome
private int getFerramentaId(String nomeFerramenta) throws SQLException {
    String sql = "SELECT id_ferramenta FROM Ferramentas WHERE nome_ferramenta = ?";
    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
        pstmt.setString(1, nomeFerramenta);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_ferramenta");
        } else {
            throw new SQLException("Ferramenta não encontrada.");
        }
    }
}

// Método auxiliar para obter o ID do usuário pelo nome
private int getUsuarioId(String nomeUsuario) throws SQLException {
    String sql = "SELECT id_usuario FROM Usuarios WHERE nome_usuario = ?";
    try (PreparedStatement pstmt = conexao.prepareStatement(sql)) {
        pstmt.setString(1, nomeUsuario);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_usuario");
        } else {
            throw new SQLException("Usuário não encontrado.");
        }
    }

    }//GEN-LAST:event_buttonRegistrarEmprestimoActionPerformed

    private void itemAmigoRegistroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_itemAmigoRegistroItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_itemAmigoRegistroItemStateChanged
private void updateCombo() {
          System.out.println("Atualizando ComboBox");
    String sql = "SELECT nome_usuario FROM amigos"; // Seleciona os nomes dos amigos
    try (PreparedStatement pst = conexao.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {

        itemAmigoRegistro.removeAllItems(); // Limpar os itens existentes na combobox
        while (rs.next()) {
            String nome = rs.getString("nome_usuario");
            System.out.println("Adicionando nome: " + nome);
            itemAmigoRegistro.addItem(nome); 
            itemAmigoDevolucao.addItem(nome);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erro ao carregar amigos: " + e.getMessage());
    }
}

  private void updateComboFerramentas() {
        System.out.println("Atualizando ComboBox de Ferramentas");
        String sql = "SELECT nome_ferramenta FROM ferramentas"; // Seleciona os nomes das ferramentas
        try (PreparedStatement pst = conexao.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            itemFerramenta.removeAllItems(); // Limpar os itens existentes na combobox
            while (rs.next()) {
                String nome = rs.getString("nome_ferramenta");
                System.out.println("Adicionando nome: " + nome);
                itemFerramenta.addItem(nome); 
                itemFerramentaDevolucao.addItem(nome);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar ferramentas: " + e.getMessage());
        }
    }
  
    private void menuItemCadastrarAmigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCadastrarAmigoActionPerformed
        // TODO add your handling code here:
        new cadastrarAmigo().setVisible(true);
    }//GEN-LAST:event_menuItemCadastrarAmigoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        new cadastrarFerramentas().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void itemAmigoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAmigoRegistroActionPerformed
       String nomeSelecionado = (String) itemAmigoRegistro.getSelectedItem();
    JTFAmigo.setText(nomeSelecionado);


    }//GEN-LAST:event_itemAmigoRegistroActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new gerenciarAmigo().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new gerenciarFerramentas().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuREativosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuREativosActionPerformed
        // TODO add your handling code here:
        new relatorioEmprestimoAtivo().setVisible(true);
    }//GEN-LAST:event_menuREativosActionPerformed

    private void menuRDevedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRDevedoresActionPerformed
        // TODO add your handling code here:
        new relatorioDevedores().setVisible(true);
    }//GEN-LAST:event_menuRDevedoresActionPerformed

    private void menuRFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRFerramentaActionPerformed
        // TODO add your handling code here:
        new relatorioFerramenta().setVisible(true);
    }//GEN-LAST:event_menuRFerramentaActionPerformed

    private void menuRHistoricosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRHistoricosActionPerformed
        // TODO add your handling code here:
        new relatorioHistoricoEmprestimo().setVisible(true);
    }//GEN-LAST:event_menuRHistoricosActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new emprestimoPorAmigo().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void buttonRegistrarDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarDevolucaoActionPerformed
        // TODO add your handling code heree:
        JOptionPane.showMessageDialog(null, "Devolução registrada com sucesso.");
    }//GEN-LAST:event_buttonRegistrarDevolucaoActionPerformed

    private void itemAmigoDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAmigoDevolucaoActionPerformed
       String nomeSelecionado = (String) itemAmigoDevolucao.getSelectedItem();
    JTFAmigo.setText(nomeSelecionado);


    }//GEN-LAST:event_itemAmigoDevolucaoActionPerformed

    private void itemFerramentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFerramentaActionPerformed
       String nomeSelecionado = (String) itemFerramenta.getSelectedItem();
        JTFFerramenta.setText(nomeSelecionado);
    }//GEN-LAST:event_itemFerramentaActionPerformed

    private void itemFerramentaDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFerramentaDevolucaoActionPerformed
       String nomeSelecionado = (String) itemFerramentaDevolucao.getSelectedItem();
        JTFFerramenta.setText(nomeSelecionado);
    }//GEN-LAST:event_itemFerramentaDevolucaoActionPerformed

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
            java.util.logging.Logger.getLogger(registroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroEmprestimo().setVisible(true);
            }
            
        }
        );   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistrarDevolucao;
    private javax.swing.JButton buttonRegistrarEmprestimo;
    private javax.swing.JFormattedTextField dataDevolucao;
    private javax.swing.JTextField dataEmprestimo;
    private javax.swing.JComboBox<String> itemAmigoDevolucao;
    private javax.swing.JComboBox<String> itemAmigoRegistro;
    private javax.swing.JComboBox<String> itemFerramenta;
    private javax.swing.JComboBox<String> itemFerramentaDevolucao;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem menuItemCadastrarAmigo;
    private javax.swing.JMenuItem menuRDevedores;
    private javax.swing.JMenuItem menuREativos;
    private javax.swing.JMenuItem menuRFerramenta;
    private javax.swing.JMenuItem menuRHistoricos;
    // End of variables declaration//GEN-END:variables

     // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

