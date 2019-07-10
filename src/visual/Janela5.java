/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Paciente;
import servicos.PacienteServicos;
import servicos.ServicosFactory;

/**
 *
 * @author Alunos
 */
public class Janela5 extends javax.swing.JInternalFrame {
DefaultTableModel dtm = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"matricula", "nome_paciente", "telefone"});
    /**
     * Creates new form Janela5
     */
    public Janela5() {
        initComponents();
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
        jtPaciente = new javax.swing.JTable();
        btnPreencher = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        jtPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "matricula", "Nome", "telefone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPaciente);

        btnPreencher.setText("Preencher");
        btnPreencher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreencherActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnPreencher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addGap(119, 119, 119))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPreencher)
                    .addComponent(btnLimpar))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void preencherTabela() {
        
    try {

            //Buscando objeto ProdutoServicos     
            PacienteServicos ps = ServicosFactory.getPacienteServicos();

            /* Criando um ArrayList<ProdutoVO> vazio
             para receber o ArrayList com os dados */
            ArrayList<Paciente> prod = new ArrayList<>();

            //Recebendo o ArrayList cheio em produtos
            prod = ps.buscarPaciente();

            for (int i = 0; i < prod.size(); i++) {
                dtm.addRow(new String[]{
                    String.valueOf(prod.get(i).getMatricula()),
                    String.valueOf(prod.get(i).getNome()),
                    String.valueOf(prod.get(i).getTelefone()),
                    
                });
            }//fecha for

            /* Adicionando o modelo de tabela 
             com os dados na tabela produto */
            jtPaciente.setModel(dtm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch
    }//fecha p
 private void limparTabela() {
        /* Para limpar a tabela temos que setar o número de
           linhas para zero no default table model */        
        dtm.setNumRows(0);
    }//fecha limparTabela
    private void btnPreencherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreencherActionPerformed
       limparTabela();
       preencherTabela();// TODO add your handling code here:
    }//GEN-LAST:event_btnPreencherActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPreencher;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPaciente;
    // End of variables declaration//GEN-END:variables
}