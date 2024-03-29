/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Cliente;
import model.bean.Funcionario;
import model.bean.Motorista;
import model.dao.ClienteDAO;
import model.dao.FuncionarioDAO;
import model.dao.MotoristaDAO;

/**
 *
 * @author Victor
 */
public class TelaMotoristas extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaListarClientes
     */
    public TelaMotoristas() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTMotorista.getModel();
        jTMotorista.setRowSorter(new TableRowSorter(modelo));
        
        preencherJTMotorista();
        preencherJTable();
    }
    
    public void preencherJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTFuncionarios.getModel();
        modelo.setNumRows(0);
        FuncionarioDAO dao = new FuncionarioDAO();
        
        for(Funcionario f: dao.listarFuncionario()){
            
            modelo.addRow(new Object[]{
                f.getIdfuncionario(),
                f.getNome(),
                f.getSexo(),
                f.getTelefone(),
                f.getHoras(),
                f.getId_tipo_funcionario(),
                f.getDataent()
            });
        }
    }
    public void preencherJTMotorista(){
        DefaultTableModel modelo = (DefaultTableModel) jTMotorista.getModel();
        modelo.setNumRows(0);
        MotoristaDAO dao = new MotoristaDAO();
        
        for(Motorista m: dao.listarMotorista()){
            
            modelo.addRow(new Object[]{
                m.getId_funcionario(),
                m.getCnh(),
                m.getMultas(),
                m.getValidade()
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTFuncionarios = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTMotorista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCnh = new javax.swing.JTextField();
        txtMultas = new javax.swing.JTextField();
        txtValidade = new javax.swing.JTextField();
        btnDeletar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Motoristas");

        jTFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRICULA", "NOME", "SEXO", "TELEFONE", "HORAS", "DATAENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTFuncionarios.setName(""); // NOI18N
        jTFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTFuncionariosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTFuncionarios);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jLabel5.setText("Matricula:");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jTMotorista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MATRICULA", "CNH", "MULTAS", "VALIDADE"
            }
        ));
        jTMotorista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTMotoristaMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTMotorista);

        jLabel1.setText("CNH:");

        jLabel2.setText("Multas:");

        jLabel3.setText("Validade:");

        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCnh))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMatricula))
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMultas))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValidade)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLimpar))
                        .addGap(10, 10, 10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMultas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeletar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnAtualizar)
                            .addComponent(btnAdicionar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)))
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

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        Motorista m = new Motorista();
        MotoristaDAO dao = new MotoristaDAO();
        
        Date d = new Date();
        //d =  txtValidade.getText();
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");

        
        m.setId_funcionario(Integer.parseInt(txtMatricula.getText()));
        m.setCnh(txtCnh.getText());
        m.setMultas(Integer.parseInt(txtMultas.getText()));
        //m.setValidade(sdt.format(d));
        
        dao.inserirMotorista(m);
        preencherJTMotorista();
            
            txtMatricula.setText("");
            txtCnh.setText("");
            txtMultas.setText("");
            txtValidade.setText("");
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        preencherJTMotorista();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(jTFuncionarios.getSelectedRow() != -1){

            Motorista m = new Motorista();
            MotoristaDAO dao = new MotoristaDAO();

            m.setId_funcionario(Integer.parseInt(txtMatricula.getText()));
            m.setCnh(txtCnh.getText().toUpperCase());
            m.setMultas(Integer.parseInt(txtMultas.getText()));
            String s = txtValidade.getText();
            

            dao.editarMotorista(m);  //EDITA NO BANCO DE DADOS

            //LIMPAR OS CAMPOS DE CADASTRO CLIENTE
            txtMatricula.setText("");
            txtCnh.setText("");
            txtMultas.setText("");
            txtValidade.setText("");

            preencherJTMotorista();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jTFuncionariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFuncionariosMouseReleased
        if(jTFuncionarios.getSelectedRow() != -1){
            txtMatricula.setText(jTFuncionarios.getValueAt(jTFuncionarios.getSelectedRow(), 0).toString());
        }
    }//GEN-LAST:event_jTFuncionariosMouseReleased

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        if(jTMotorista.getSelectedRow() != -1){
            Motorista m = new Motorista();
            MotoristaDAO dao = new MotoristaDAO();

            m.setId_funcionario(Integer.parseInt(txtMatricula.getText()));
            m.setCnh(txtCnh.getText().toUpperCase());
            m.setMultas(Integer.parseInt(txtMultas.getText()));
            String s = txtValidade.getText();
            dao.removerMotorista(m);
            preencherJTMotorista();
            
            txtMatricula.setText("");
            txtCnh.setText("");
            txtMultas.setText("");
            txtValidade.setText("");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
            txtMatricula.setText("");
            txtCnh.setText("");
            txtMultas.setText("");
            txtValidade.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void jTMotoristaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTMotoristaMouseReleased
        if(jTMotorista.getSelectedRow() != -1){
            txtMatricula.setText(jTMotorista.getValueAt(jTMotorista.getSelectedRow(), 0).toString());
            txtCnh.setText((String) jTMotorista.getValueAt(jTMotorista.getSelectedRow(), 1).toString());
            txtMultas.setText(jTMotorista.getValueAt(jTMotorista.getSelectedRow(),2).toString());
            txtValidade.setText(jTMotorista.getValueAt(jTMotorista.getSelectedRow(),3).toString());
        }
    }//GEN-LAST:event_jTMotoristaMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTFuncionarios;
    private javax.swing.JTable jTMotorista;
    private javax.swing.JTextField txtCnh;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtMultas;
    private javax.swing.JTextField txtValidade;
    // End of variables declaration//GEN-END:variables
}
