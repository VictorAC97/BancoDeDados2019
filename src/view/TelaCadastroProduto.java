/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Categoria;
import model.bean.Produto;
import model.dao.CategoriaDAO;
import model.dao.ProdutoDAO;

/**
 *
 * @author Victor
 */
public class TelaCadastroProduto extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCadastroProduto
     */
    public TelaCadastroProduto() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        jTProdutos.setRowSorter(new TableRowSorter(modelo));
        
        
          CategoriaDAO dao = new CategoriaDAO();
          
          dao.read().forEach((c) -> {
              cbCategoria.addItem(c);
        });
          
          preencherJTable();
    }

        public void preencherJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO dao = new ProdutoDAO();
        
        for(Produto p: dao.read()){
            
            modelo.addRow(new Object[]{
                p.getIdProduto(),
                p.getNome(),
                p.getCategoria(),
                p.getPreco(),
                p.getPeso(),
                p.getAltura(),
                p.getLargura()
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtProdutoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPesoProduto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAlturaProduto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtLarguraProduto = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtPrecoProduto = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtIdProduto = new javax.swing.JTextField();

        setClosable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Produtos"));

        jLabel1.setText("Nome:");

        jLabel2.setText("Preço(R$):");

        jLabel3.setText("Peso(Kg):");

        jLabel4.setText("Altura:");

        jLabel5.setText("Largura:");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });

        jLabel6.setText("Categoria:");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CATEGORIA", "PREÇO", "PESO", "ALTURA", "LARGURA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTProdutosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);

        jLabel7.setText("ID:");

        txtIdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(6, 6, 6)
                                .addComponent(txtPesoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(3, 3, 3)
                                .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLarguraProduto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAlturaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(56, 56, 56)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnListar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtProdutoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(txtPesoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlturaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLarguraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar)
                    .addComponent(btnEditar)
                    .addComponent(btnRemover)
                    .addComponent(btnListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtIdProduto.setText("");
        txtProdutoNome.setText("");
        txtPrecoProduto.setText("");
        txtPesoProduto.setText("");
        txtAlturaProduto.setText("");
        txtLarguraProduto.setText("");
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
       
        
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();
        
        Categoria c = (Categoria) cbCategoria.getSelectedItem();    //obtendo o item selecionado na combobox
        c.getIdcategoria();
        
        p.setIdProduto(Integer.parseInt(txtIdProduto.getText()));
        p.setNome(txtProdutoNome.getText());
        p.setAltura(Float.parseFloat(txtAlturaProduto.getText()));
        p.setLargura(Float.parseFloat(txtLarguraProduto.getText()));
        p.setPeso(Float.parseFloat(txtPesoProduto.getText()));
        p.setPreco(Float.parseFloat(txtPrecoProduto.getText()));
        p.setCategoria(c);
        
        dao.create(p);
        preencherJTable();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    if(jTProdutos.getSelectedRow() != -1){
        Produto p = new Produto();
        Categoria c = (Categoria) cbCategoria.getSelectedItem();    //obtendo o item selecionado na combobox
        ProdutoDAO dao = new ProdutoDAO();

                p.setIdProduto(Integer.parseInt(txtIdProduto.getText()));
                p.setNome(txtProdutoNome.getText());
                p.setCategoria(c);
                p.setPreco(Float.parseFloat(txtPrecoProduto.getText()));
                p.setPeso(Float.parseFloat(txtPesoProduto.getText()));
                p.setAltura(Float.parseFloat(txtAlturaProduto.getText()));
                p.setLargura(Float.parseFloat(txtLarguraProduto.getText()));
                dao.update(p);
                preencherJTable();
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
    if(jTProdutos.getSelectedRow() != -1){
                Produto p = new Produto();
                Categoria c = (Categoria) cbCategoria.getSelectedItem();    //obtendo o item selecionado na combobox
                ProdutoDAO dao = new ProdutoDAO();

                p.setIdProduto((int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));
                p.setNome((String) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1));
                p.setCategoria(c);
                p.setPreco((float) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3));
                p.setPeso((float) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4));
                p.setAltura((float) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 5));
                p.setLargura((float) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 6));
                
                //ID NA INTERFACE TA FICANDO 0 MAS NO BANCO ESTA OK, ARRUMAR AQUI!
                dao.delete(p);
                preencherJTable();
            }else
            {
                JOptionPane.showMessageDialog(null, "Selecione um item para excluir.");
                return;
    }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        preencherJTable();
    }//GEN-LAST:event_btnListarActionPerformed

    private void jTProdutosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseReleased
        if(jTProdutos.getSelectedRow() != -1){
                txtIdProduto.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0).toString());
                txtProdutoNome.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 1).toString());
                txtPrecoProduto.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
                txtPesoProduto.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());
                txtAlturaProduto.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 5).toString());
                txtLarguraProduto.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 6).toString());
        }        // TODO add your handling code here:      
    
    }//GEN-LAST:event_jTProdutosMouseReleased

    private void txtIdProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProdutoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<Object> cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField txtAlturaProduto;
    private javax.swing.JTextField txtIdProduto;
    private javax.swing.JTextField txtLarguraProduto;
    private javax.swing.JTextField txtPesoProduto;
    private javax.swing.JTextField txtPrecoProduto;
    private javax.swing.JTextField txtProdutoNome;
    // End of variables declaration//GEN-END:variables
}
