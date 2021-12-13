/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.AlunoController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Usuario;

/**
 *
 * @author vinic
 */
public class frmAluno extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private Usuario user = new Usuario();
    
    public frmAluno() {
        initComponents();
        modelarTabelaAluno();
        preencherTabelaAluno();
    }
    
    public frmAluno(Usuario usuario) {
        initComponents();
        modelarTabelaAluno();
        preencherTabelaAluno();
        user = usuario;
        if(usuario.getTipo_usuario().getLabel().equals("Aluno")){
            btnNovoAluno.setEnabled(false);
            btnEditarAluno.setEnabled(false);
            btnDeletarAluno.setEnabled(false);
            menuCadastrar.setEnabled(false);
        }
    }

    private void modelarTabelaAluno(){
        modelo.setColumnCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("NOME");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        modelo.addColumn("INSTRUTOR");
        tblAlunos.setModel(modelo);
    }
    
    private void preencherTabelaAluno(){
        modelo.setNumRows(0);
        for(Aluno a: new AlunoController().Listar()){
            modelo.addRow(new Object[]{
                a.getId(),
                a.getNome(),
                a.getCpf(),
                a.getRg(),
                a.getInstrutor().getNome() 
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovoAluno = new javax.swing.JButton();
        btnEditarAluno = new javax.swing.JButton();
        btnDeletarAluno = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAlunos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        treinosxAluno = new javax.swing.JMenuItem();
        historicoxAluno = new javax.swing.JMenuItem();
        menuCadastrar = new javax.swing.JMenu();
        menuCadastrarHistorico = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNovoAluno.setText("Novo");
        btnNovoAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAlunoActionPerformed(evt);
            }
        });

        btnEditarAluno.setText("Editar");

        btnDeletarAluno.setText("Deletar");
        btnDeletarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarAlunoActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        tblAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblAlunos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletarAluno)
                        .addGap(121, 121, 121))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoAluno)
                    .addComponent(btnEditarAluno)
                    .addComponent(btnDeletarAluno)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jMenu1.setText("Exibir");

        treinosxAluno.setText("Treinos");
        treinosxAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treinosxAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(treinosxAluno);

        historicoxAluno.setText("Historico do Aluno");
        historicoxAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historicoxAlunoActionPerformed(evt);
            }
        });
        jMenu1.add(historicoxAluno);

        jMenuBar1.add(jMenu1);

        menuCadastrar.setText("Cadastrar");

        menuCadastrarHistorico.setText("Historico");
        menuCadastrarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastrarHistoricoActionPerformed(evt);
            }
        });
        menuCadastrar.add(menuCadastrarHistorico);

        jMenuBar1.add(menuCadastrar);

        jMenu2.setText("Opções");

        jMenuItem3.setText("Sair");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAlunoActionPerformed
        new frmAlunoCadastro().setVisible(true);
    }//GEN-LAST:event_btnNovoAlunoActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void menuCadastrarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastrarHistoricoActionPerformed
        try{
            int linha = tblAlunos.getSelectedRow();
            int idAlunoSelecionado = (int) tblAlunos.getValueAt(linha, 0);
            new frmHistoricoCadastro(new AlunoController().Consultar(idAlunoSelecionado)).setVisible(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado!", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuCadastrarHistoricoActionPerformed

    private void historicoxAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historicoxAlunoActionPerformed
        try{
            int linha = tblAlunos.getSelectedRow();
            int idAlunoSelecionado = (int) tblAlunos.getValueAt(linha, 0);
            new frmHistoricoxAluno(new AlunoController().Consultar(idAlunoSelecionado)).setVisible(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado!", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_historicoxAlunoActionPerformed

    private void treinosxAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treinosxAlunoActionPerformed
        try{
            int linha = tblAlunos.getSelectedRow();
            int idAlunoSelecionado = (int) tblAlunos.getValueAt(linha, 0);
            new frmTreinoxAluno(new AlunoController().Consultar(idAlunoSelecionado)).setVisible(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado!", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_treinosxAlunoActionPerformed

    private void btnDeletarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarAlunoActionPerformed
        try{
            int linha = tblAlunos.getSelectedRow();
            int idAlunoSelecionado = (int) tblAlunos.getValueAt(linha, 0);
            new AlunoController().Remover(idAlunoSelecionado);
            preencherTabelaAluno();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum aluno selecionado!", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarAlunoActionPerformed

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
            java.util.logging.Logger.getLogger(frmAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletarAluno;
    private javax.swing.JButton btnEditarAluno;
    private javax.swing.JButton btnNovoAluno;
    private javax.swing.JMenuItem historicoxAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenu menuCadastrar;
    private javax.swing.JMenuItem menuCadastrarHistorico;
    private javax.swing.JTable tblAlunos;
    private javax.swing.JMenuItem treinosxAluno;
    // End of variables declaration//GEN-END:variables
}
