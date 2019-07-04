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
import model.bean.Pedido;
import model.dao.PedidoDAO;

/**
 *
 * @author Victor
 */
public class TelaEditarPedido extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaListarPedidos
     */
    public TelaEditarPedido() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTPedidos.getModel();
        jTPedidos.setRowSorter(new TableRowSorter(modelo));
        
        preencherJTable();
    }
    
    public void preencherJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTPedidos.getModel();
        
        PedidoDAO dao = new PedidoDAO();
        
        for(Pedido p: dao.consultaPedido()){
            
            modelo.addRow(new Object[]{
                p.getIdpedido(),
                p.getFrete(),
                p.getId_produto(),
                p.getId_cliente()
            });
        }
        
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtIdPedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtFrete = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        btnLimparCampos = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPedidos = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Editar Pedido");

        jLabel2.setText("ID:");

        jLabel1.setText("Frete:");

        txtFrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFreteActionPerformed(evt);
            }
        });

        jLabel3.setText("ProdutoID");

        jLabel4.setText("ClienteID:");

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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(472, Short.MAX_VALUE))
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
                    .addComponent(txtIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparCampos)
                    .addComponent(btnAtualizar))
                .addGap(27, 27, 27))
        );

        jTPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FRETE", "ClienteID", "ProdutoID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTPedidos.setName(""); // NOI18N
        jTPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTPedidosMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTPedidosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 46, Short.MAX_VALUE)
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
        txtFrete.setText("");
        txtIdPedido.setText("");
        txtIdCliente.setText("");
        txtIdProduto.setText("");
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void jTPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPedidosMouseClicked
    
            
    }//GEN-LAST:event_jTPedidosMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if(jTPedidos.getSelectedRow() != -1){

          if(txtFrete.getText().equals("")||txtIdPedido.getText().equals("")||
             txtIdCliente.getText().equals("")||txtIdProduto.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null,"Preencha todos os campos","Aviso",JOptionPane.WARNING_MESSAGE);
              return;
          }
            
                   Pedido pd = new Pedido();       
                   PedidoDAO dao = new PedidoDAO();
                   
                   pd.setFrete(Float.parseFloat(txtFrete.getText().toUpperCase()));
                   pd.setId_cliente(txtIdCliente.getText());
                   pd.setId_produto(Integer.parseInt(txtIdProduto.getText().toUpperCase()));
                   pd.setIdpedido(Integer.parseInt(jTPedidos.getValueAt(jTPedidos.getSelectedRow(), 0).toString()));
                   dao.update(pd);  //EDITA NO BANCO DE DADOS

            //LIMPAR OS CAMPOS DE CADASTRO CLIENTE
            txtFrete.setText("");
            txtIdCliente.setText("");
            txtIdProduto.setText("");
 
             preencherJTable();
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtFreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFreteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFreteActionPerformed

    private void jTPedidosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTPedidosMouseReleased
        if(jTPedidos.getSelectedRow() != -1){
            txtIdPedido.setText(jTPedidos.getValueAt(jTPedidos.getSelectedRow(), 1).toString());
            txtFrete.setText(jTPedidos.getValueAt(jTPedidos.getSelectedRow(), 2).toString());
            txtIdCliente.setText(jTPedidos.getValueAt(jTPedidos.getSelectedRow(), 3).toString());
            txtIdProduto.setText(jTPedidos.getValueAt(jTPedidos.getSelectedRow(), 4).toString());
        }
    }//GEN-LAST:event_jTPedidosMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTPedidos;
    private javax.swing.JTextField txtFrete;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdPedido;
    private javax.swing.JTextField txtIdProduto;
    // End of variables declaration//GEN-END:variables
}
