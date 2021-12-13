/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.InstrutorController;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Instrutor;
import model.Usuario;

/**
 *
 * @author vinic
 */
public class frmInstrutor extends javax.swing.JFrame {

    private Usuario user = new Usuario();
    private DefaultTableModel modelo = new DefaultTableModel();
    
    public frmInstrutor() {
        initComponents();
        modelarTabelaInstrutor();
        preencherTabelaInstrutor();
    }
    
    public frmInstrutor(Usuario usuario) {
        initComponents();
        user = usuario;
        modelarTabelaInstrutor();
        preencherTabelaInstrutor();
        if(usuario.getTipo_usuario().getLabel().equals("Instrutor")){
            btnNovoInstrutor.setEnabled(false);
            btnEditarInstrutor.setEnabled(false);
            btnDeletarInstrutor.setEnabled(false);   
        }
    }
    
    private void modelarTabelaInstrutor(){
        modelo.setNumRows(0);
        modelo.setColumnCount(0);
        modelo.addColumn("ID");
        modelo.addColumn("NOME");
        modelo.addColumn("CPF");
        modelo.addColumn("RG");
        modelo.addColumn("CTPS");
        modelo.addColumn("CARGA HORÁRIA");
        modelo.addColumn("QTD. ALUNOS");
        tblInstrutores.setModel(modelo);
    }
    

    private void preencherTabelaInstrutor(){
        modelo.setNumRows(0);
        for(Instrutor i: new InstrutorController().Listar()){
            modelo.addRow(new Object[]{
                i.getId(),
                i.getNome(),
                i.getCpf(),
                i.getRg(),
                i.getCtps(),
                i.getCargaHoraria(),
                i.getAlunos().size()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNovoInstrutor = new javax.swing.JButton();
        btnEditarInstrutor = new javax.swing.JButton();
        btnDeletarInstrutor = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInstrutores = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        cadastrarAluno = new javax.swing.JMenuItem();
        cadastrarAtividade = new javax.swing.JMenuItem();
        cadastrarTreino = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        abrirFormularioAluno = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        opcaoSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnNovoInstrutor.setText("Novo");
        btnNovoInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoInstrutorActionPerformed(evt);
            }
        });

        btnEditarInstrutor.setText("Editar");

        btnDeletarInstrutor.setText("Deletar");
        btnDeletarInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarInstrutorActionPerformed(evt);
            }
        });

        jLabel1.setText("Buscar:");

        tblInstrutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblInstrutores);

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
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoInstrutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditarInstrutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeletarInstrutor))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoInstrutor)
                    .addComponent(btnEditarInstrutor)
                    .addComponent(btnDeletarInstrutor)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jMenu3.setText("Cadastrar");

        cadastrarAluno.setText("Aluno");
        cadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAlunoActionPerformed(evt);
            }
        });
        jMenu3.add(cadastrarAluno);

        cadastrarAtividade.setText("Atividade");
        cadastrarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAtividadeActionPerformed(evt);
            }
        });
        jMenu3.add(cadastrarAtividade);

        cadastrarTreino.setText("Treino");
        cadastrarTreino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarTreinoActionPerformed(evt);
            }
        });
        jMenu3.add(cadastrarTreino);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Exibir");

        jMenuItem1.setText("Alunos do Instrutor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Aluno");

        abrirFormularioAluno.setText("Abrir");
        abrirFormularioAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirFormularioAlunoActionPerformed(evt);
            }
        });
        jMenu4.add(abrirFormularioAluno);

        jMenuBar1.add(jMenu4);

        jMenu2.setText("Opções");

        opcaoSair.setText("Sair");
        opcaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcaoSairActionPerformed(evt);
            }
        });
        jMenu2.add(opcaoSair);

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

    private void cadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAlunoActionPerformed
        new frmAlunoCadastro().setVisible(true);
    }//GEN-LAST:event_cadastrarAlunoActionPerformed

    private void abrirFormularioAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirFormularioAlunoActionPerformed
        new frmAluno().setVisible(true);
    }//GEN-LAST:event_abrirFormularioAlunoActionPerformed

    private void cadastrarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAtividadeActionPerformed
        new frmAtividadeCadastro().setVisible(true);
    }//GEN-LAST:event_cadastrarAtividadeActionPerformed

    private void btnNovoInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoInstrutorActionPerformed
        new frmInstrutorCadastro().setVisible(true);
    }//GEN-LAST:event_btnNovoInstrutorActionPerformed

    private void opcaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_opcaoSairActionPerformed

    private void cadastrarTreinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarTreinoActionPerformed
        new frmTreinoCadastro().setVisible(true);
    }//GEN-LAST:event_cadastrarTreinoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try{
            int linha = tblInstrutores.getSelectedRow();
            int idInstrutor = (int) tblInstrutores.getValueAt(linha, 0);
            new frmAlunosxInstrutor(new InstrutorController().Consultar(idInstrutor)).setVisible(true);
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum instrutor selecionado", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnDeletarInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarInstrutorActionPerformed
        try{
            int linha = tblInstrutores.getSelectedRow();
            int idInstrutor = (int) tblInstrutores.getValueAt(linha, 0);
            new InstrutorController().Remover(idInstrutor);
            preencherTabelaInstrutor();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Nenhum instrutor selecionado", "Atenção!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletarInstrutorActionPerformed

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
            java.util.logging.Logger.getLogger(frmInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInstrutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirFormularioAluno;
    private javax.swing.JButton btnDeletarInstrutor;
    private javax.swing.JButton btnEditarInstrutor;
    private javax.swing.JButton btnNovoInstrutor;
    private javax.swing.JMenuItem cadastrarAluno;
    private javax.swing.JMenuItem cadastrarAtividade;
    private javax.swing.JMenuItem cadastrarTreino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem opcaoSair;
    private javax.swing.JTable tblInstrutores;
    // End of variables declaration//GEN-END:variables
}
