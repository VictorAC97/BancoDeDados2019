/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.dao.ClienteDAO;

/**
 *
 * @author Victor
 */
public class TelaEditarCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaListarClientes
     */
    public TelaEditarCliente() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTClientes.getModel();
        jTClientes.setRowSorter(new TableRowSorter(modelo));
        
        preencherJTable();
    }
    
    public void preencherJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTClientes.getModel();
        modelo.setNumRows(0);   //Evita que a lista fique duplicada.
        ClienteDAO dao = new ClienteDAO();
        
        for(Cliente c: dao.listarCliente()){
            
            modelo.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getTelefone(),
                c.getUf(),
                c.getCep(),
                c.getCidade(),
                c.getBairro(),
                c.getRua(),
                c.getNumero(),
                c.getCompl()

            });
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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTelCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUfCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCepCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCidadeCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtBairroCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtRuaCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtComplCliente = new javax.swing.JTextField();
        btnLimparCampos = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTClientes = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Editar Cliente");

        jLabel2.setText("Nome:");

        jLabel1.setText("Telefone:");

        txtTelCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("UF:");

        jLabel4.setText("CEP:");

        jLabel5.setText("Cidade:");

        jLabel6.setText("Bairro:");

        jLabel7.setText("Rua:");

        jLabel8.setText("Numero:");

        jLabel9.setText("Complemento:");

        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairroCliente))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCidadeCliente))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 227, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRuaCliente))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtComplCliente)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(205, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(269, 269, 269))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtRuaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCidadeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtBairroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtTelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtComplCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCepCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(txtUfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(txtNumCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparCampos)
                    .addComponent(btnAtualizar))
                .addGap(27, 27, 27))
        );

        jTClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF/CNPJ", "NOME", "TELEFONE", "UF", "CEP", "CIDADE", "BAIRRO", "RUA", "NUMERO", "COMPL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTClientes.setName(""); // NOI18N
        jTClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTClientesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTClientesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        txtNomeCliente.setText("");
        txtTelCliente.setText("");
        txtCidadeCliente.setText("");
        txtBairroCliente.setText("");
        txtComplCliente.setText("");
        txtRuaCliente.setText("");
        txtNumCliente.setText("");
        txtCepCliente.setText("");
        txtUfCliente.setText("");
        
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void jTClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTClientesMouseClicked
    
            
    }//GEN-LAST:event_jTClientesMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if(jTClientes.getSelectedRow() != -1){

          if(txtNomeCliente.getText().equals("")||txtTelCliente.getText().equals("")||
             txtCidadeCliente.getText().equals("")||txtBairroCliente.getText().equals("")||txtComplCliente.getText().equals("")||
             txtRuaCliente.getText().equals("")||txtNumCliente.getText().equals("")||txtCepCliente.getText().equals("")||txtUfCliente.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null,"Preencha todos os campos","Aviso",JOptionPane.WARNING_MESSAGE);
              return;
          }
            
                   Cliente cl = new Cliente();       
                   ClienteDAO dao = new ClienteDAO();
                   
                   cl.setNome(txtNomeCliente.getText().toUpperCase());
                   cl.setTelefone(txtTelCliente.getText());
                   cl.setCidade(txtCidadeCliente.getText().toUpperCase());
                   cl.setBairro(txtBairroCliente.getText().toUpperCase());
                   cl.setCompl(txtComplCliente.getText().toUpperCase());
                   cl.setRua(txtRuaCliente.getText().toUpperCase());
                   cl.setNumero(Integer.parseInt(txtNumCliente.getText()));
                   cl.setCep(txtCepCliente.getText());
                   cl.setUf(txtUfCliente.getText().toUpperCase());
                   cl.setId(jTClientes.getValueAt(jTClientes.getSelectedRow(), 0).toString());
                   dao.editarCliente(cl);  //EDITA NO BANCO DE DADOS

            //LIMPAR OS CAMPOS DE CADASTRO CLIENTE
            txtNomeCliente.setText("");
            txtTelCliente.setText("");
            txtCidadeCliente.setText("");
            txtBairroCliente.setText("");
            txtComplCliente.setText("");
            txtRuaCliente.setText("");
            txtNumCliente.setText("");
            txtCepCliente.setText("");
            txtUfCliente.setText("");
 
             preencherJTable();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtTelClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelClienteActionPerformed

    private void jTClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTClientesMouseReleased
        if(jTClientes.getSelectedRow() != -1){
            txtNomeCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 1).toString());
            txtTelCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 2).toString());
            txtUfCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 3).toString());
            txtCepCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 4).toString());
            txtCidadeCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 5).toString());
            txtBairroCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 6).toString());
            txtRuaCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 7).toString());
            txtNumCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 8).toString());
            txtComplCliente.setText(jTClientes.getValueAt(jTClientes.getSelectedRow(), 9).toString());
        }
    }//GEN-LAST:event_jTClientesMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTClientes;
    private javax.swing.JTextField txtBairroCliente;
    private javax.swing.JTextField txtCepCliente;
    private javax.swing.JTextField txtCidadeCliente;
    private javax.swing.JTextField txtComplCliente;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNumCliente;
    private javax.swing.JTextField txtRuaCliente;
    private javax.swing.JTextField txtTelCliente;
    private javax.swing.JTextField txtUfCliente;
    // End of variables declaration//GEN-END:variables
}
