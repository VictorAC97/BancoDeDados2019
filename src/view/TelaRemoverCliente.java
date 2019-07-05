/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.dao.ClienteDAO;

/**
 *
 * @author Victor
 */
public class TelaRemoverCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaRemoverCliente
     */
    public TelaRemoverCliente() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnRemover = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Remover Cliente"));

        jLabel1.setText("CPF:");

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(btnRemover)
                .addContainerGap())
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        ClienteDAO dao = new ClienteDAO();

        //faz um busca e retorna a caixa abaixo com as infos
        //c.setId(txtIdCliente.getText());
        
        Cliente alvo = new Cliente();
        alvo = dao.buscarCliente(txtIdCliente.getText());                            
        
        if(alvo.getId() != null)
        {
            
            JOptionPane.showMessageDialog(null, "CLIENTE:"+
                                                    "\nCPF/CNPJ: "+alvo.getId()+
                                                    "\nNome: "+alvo.getNome()+
                                                    "\nTELEFONE: "+alvo.getTelefone()+
                                                    "\nCIDADE: "+alvo.getCidade()+
                                                    "\nBAIRRO: "+alvo.getBairro()+
                                                    "\nCOMPL: "+alvo.getCompl()+
                                                    "\nRUA: "+alvo.getRua()+
                                                    "\nNUMERO: "+alvo.getNumero()+
                                                    "\nCEP: "+alvo.getCep()+
                                                    "\nUF: "+alvo.getUf()
            );
            
            int returnValue = JOptionPane.showConfirmDialog(null, "Deseja realmente remover?", "Confirmar Remoção", JOptionPane.YES_NO_OPTION);
                if(returnValue == 0)
                {
                    dao.removerCliente(alvo);
                    txtIdCliente.setText("");
                }
                if(returnValue == 1)
                {
                    JOptionPane.showMessageDialog(null, "Operação abortada.");
                } 
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cliente não existe.");
        }
        dispose();  //fecha a jInternalFrame
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIdCliente;
    // End of variables declaration//GEN-END:variables
}
