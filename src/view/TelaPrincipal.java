/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 *
 * @author Victor
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
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

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/wallpaperCaminhao.jpg"));
        Image image = icon.getImage();
        jDesktopPaneTelaPrincipal = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuMenu = new javax.swing.JMenu();
        Pesquisar = new javax.swing.JMenuItem();
        Sair = new javax.swing.JMenuItem();
        MenuProdutos = new javax.swing.JMenu();
        CadastrarProduto = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenuCliente = new javax.swing.JMenu();
        CadastrarCliente = new javax.swing.JMenuItem();
        EditarCliente = new javax.swing.JMenuItem();
        ListarCliente = new javax.swing.JMenuItem();
        RemoverCliente = new javax.swing.JMenuItem();
        MenuFuncionario = new javax.swing.JMenu();
        CadastrarFuncionario = new javax.swing.JMenuItem();
        EditarFuncionario = new javax.swing.JMenuItem();
        ListarFuncionario = new javax.swing.JMenuItem();
        RemoverFuncionario = new javax.swing.JMenuItem();
        MenuCaminhao = new javax.swing.JMenu();
        CadastrarCaminhao = new javax.swing.JMenuItem();
        CadastrarMarca = new javax.swing.JMenuItem();
        CadastrarModelo = new javax.swing.JMenuItem();
        MenuPedido = new javax.swing.JMenu();
        NovoPedido = new javax.swing.JMenuItem();
        EditarPedido = new javax.swing.JMenuItem();
        ListarPedido = new javax.swing.JMenuItem();
        RemoverPedido = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("<VILG> PRINCIPAL");
        setPreferredSize(new java.awt.Dimension(540, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jDesktopPaneTelaPrincipal.setBackground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jDesktopPaneTelaPrincipalLayout = new javax.swing.GroupLayout(jDesktopPaneTelaPrincipal);
        jDesktopPaneTelaPrincipal.setLayout(jDesktopPaneTelaPrincipalLayout);
        jDesktopPaneTelaPrincipalLayout.setHorizontalGroup(
            jDesktopPaneTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jDesktopPaneTelaPrincipalLayout.setVerticalGroup(
            jDesktopPaneTelaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        MenuMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/application.png"))); // NOI18N
        MenuMenu.setText("Menu");

        Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/zoom.png"))); // NOI18N
        Pesquisar.setText("Pesquisar");
        MenuMenu.add(Pesquisar);

        Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/door_out.png"))); // NOI18N
        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        MenuMenu.add(Sair);

        jMenuBar1.add(MenuMenu);

        MenuProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basket.png"))); // NOI18N
        MenuProdutos.setText("Produtos");

        CadastrarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basket.png"))); // NOI18N
        CadastrarProduto.setText("Produtos");
        CadastrarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarProdutoActionPerformed(evt);
            }
        });
        MenuProdutos.add(CadastrarProduto);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/basket.png"))); // NOI18N
        jMenuItem5.setText("Categorias");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MenuProdutos.add(jMenuItem5);

        jMenuBar1.add(MenuProdutos);

        MenuCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        MenuCliente.setText("Cliente");

        CadastrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_add.png"))); // NOI18N
        CadastrarCliente.setText("Cadastrar");
        CadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarClienteActionPerformed(evt);
            }
        });
        MenuCliente.add(CadastrarCliente);

        EditarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_edit.png"))); // NOI18N
        EditarCliente.setText("Editar");
        EditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarClienteActionPerformed(evt);
            }
        });
        MenuCliente.add(EditarCliente);

        ListarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/table.png"))); // NOI18N
        ListarCliente.setText("Listar");
        ListarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarClienteActionPerformed(evt);
            }
        });
        MenuCliente.add(ListarCliente);

        RemoverCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user_delete.png"))); // NOI18N
        RemoverCliente.setText("Remover");
        RemoverCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverClienteActionPerformed(evt);
            }
        });
        MenuCliente.add(RemoverCliente);

        jMenuBar1.add(MenuCliente);

        MenuFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group.png"))); // NOI18N
        MenuFuncionario.setText("Funcionário");

        CadastrarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_add.png"))); // NOI18N
        CadastrarFuncionario.setText("Cadastrar");
        CadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarFuncionarioActionPerformed(evt);
            }
        });
        MenuFuncionario.add(CadastrarFuncionario);

        EditarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_edit.png"))); // NOI18N
        EditarFuncionario.setText("Editar");
        MenuFuncionario.add(EditarFuncionario);

        ListarFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/table.png"))); // NOI18N
        ListarFuncionario.setText("Listar");
        ListarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarFuncionarioActionPerformed(evt);
            }
        });
        MenuFuncionario.add(ListarFuncionario);

        RemoverFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_delete.png"))); // NOI18N
        RemoverFuncionario.setText("Remover");
        RemoverFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverFuncionarioActionPerformed(evt);
            }
        });
        MenuFuncionario.add(RemoverFuncionario);

        jMenuBar1.add(MenuFuncionario);

        MenuCaminhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car.png"))); // NOI18N
        MenuCaminhao.setText("Caminhão");

        CadastrarCaminhao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car.png"))); // NOI18N
        CadastrarCaminhao.setText("Caminhão");
        CadastrarCaminhao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarCaminhaoActionPerformed(evt);
            }
        });
        MenuCaminhao.add(CadastrarCaminhao);

        CadastrarMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car.png"))); // NOI18N
        CadastrarMarca.setText("Marca");
        CadastrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarMarcaActionPerformed(evt);
            }
        });
        MenuCaminhao.add(CadastrarMarca);

        CadastrarModelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car.png"))); // NOI18N
        CadastrarModelo.setText("Modelo");
        CadastrarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarModeloActionPerformed(evt);
            }
        });
        MenuCaminhao.add(CadastrarModelo);

        jMenuBar1.add(MenuCaminhao);

        MenuPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart.png"))); // NOI18N
        MenuPedido.setText("Pedido");

        NovoPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_add.png"))); // NOI18N
        NovoPedido.setText("Novo");
        NovoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoPedidoActionPerformed(evt);
            }
        });
        MenuPedido.add(NovoPedido);

        EditarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_edit.png"))); // NOI18N
        EditarPedido.setText("Editar");
        MenuPedido.add(EditarPedido);

        ListarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/table.png"))); // NOI18N
        ListarPedido.setText("Listar");
        ListarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarPedidoActionPerformed(evt);
            }
        });
        MenuPedido.add(ListarPedido);

        RemoverPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cart_delete.png"))); // NOI18N
        RemoverPedido.setText("Remover");
        MenuPedido.add(RemoverPedido);

        jMenuBar1.add(MenuPedido);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneTelaPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPaneTelaPrincipal)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarFuncionarioActionPerformed
        TelaCadastroFuncionario telaCadFunc = new TelaCadastroFuncionario();
        jDesktopPaneTelaPrincipal.add(telaCadFunc);
        telaCadFunc.setVisible(true);
        
    }//GEN-LAST:event_CadastrarFuncionarioActionPerformed

    private void RemoverFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverFuncionarioActionPerformed
        TelaRemoverFuncionario telaRevFunc = new TelaRemoverFuncionario();
        jDesktopPaneTelaPrincipal.add(telaRevFunc);
        telaRevFunc.setVisible(true);
    }//GEN-LAST:event_RemoverFuncionarioActionPerformed

    private void NovoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NovoPedidoActionPerformed

    private void RemoverClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverClienteActionPerformed
        TelaRemoverCliente telaRevUser = new TelaRemoverCliente();
        jDesktopPaneTelaPrincipal.add(telaRevUser);
        telaRevUser.setVisible(true);
        
        
    }//GEN-LAST:event_RemoverClienteActionPerformed

    private void CadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarClienteActionPerformed
        
        TelaCadastroCliente telaCadUser = new TelaCadastroCliente();
        jDesktopPaneTelaPrincipal.add(telaCadUser);
        telaCadUser.setVisible(true);
        
        
    }//GEN-LAST:event_CadastrarClienteActionPerformed

    private void EditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarClienteActionPerformed
        TelaEditarCliente telaEditCli = new TelaEditarCliente();
        jDesktopPaneTelaPrincipal.add(telaEditCli);
        telaEditCli.setVisible(true);
    }//GEN-LAST:event_EditarClienteActionPerformed

    private void ListarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListarPedidoActionPerformed

    private void ListarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListarFuncionarioActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void ListarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarClienteActionPerformed
        TelaListarClientes telaLisCli = new TelaListarClientes();
        jDesktopPaneTelaPrincipal.add(telaLisCli);
        telaLisCli.setVisible(true);
    }//GEN-LAST:event_ListarClienteActionPerformed

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        System.exit(1);
    }//GEN-LAST:event_SairActionPerformed

    private void CadastrarCaminhaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarCaminhaoActionPerformed
        TelaCadastroCaminhao telaCadCam = new TelaCadastroCaminhao();
        jDesktopPaneTelaPrincipal.add(telaCadCam);
        telaCadCam.setVisible(true);
    }//GEN-LAST:event_CadastrarCaminhaoActionPerformed

    private void CadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarMarcaActionPerformed
        TelaCadastroMarca telaCadMar = new TelaCadastroMarca();
        jDesktopPaneTelaPrincipal.add(telaCadMar);
        telaCadMar.setVisible(true);
    }//GEN-LAST:event_CadastrarMarcaActionPerformed

    private void CadastrarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarModeloActionPerformed
        TelaCadastroModelo telaCadMod = new TelaCadastroModelo();
        jDesktopPaneTelaPrincipal.add(telaCadMod);
        telaCadMod.setVisible(true);
    }//GEN-LAST:event_CadastrarModeloActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        TelaCategoria telaCat = new TelaCategoria();
        jDesktopPaneTelaPrincipal.add(telaCat);
        telaCat.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void CadastrarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarProdutoActionPerformed
        TelaCadastroProduto telaCadProd = new TelaCadastroProduto();
        jDesktopPaneTelaPrincipal.add(telaCadProd);
        telaCadProd.setVisible(true);
    }//GEN-LAST:event_CadastrarProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastrarCaminhao;
    private javax.swing.JMenuItem CadastrarCliente;
    private javax.swing.JMenuItem CadastrarFuncionario;
    private javax.swing.JMenuItem CadastrarMarca;
    private javax.swing.JMenuItem CadastrarModelo;
    private javax.swing.JMenuItem CadastrarProduto;
    private javax.swing.JMenuItem EditarCliente;
    private javax.swing.JMenuItem EditarFuncionario;
    private javax.swing.JMenuItem EditarPedido;
    private javax.swing.JMenuItem ListarCliente;
    private javax.swing.JMenuItem ListarFuncionario;
    private javax.swing.JMenuItem ListarPedido;
    private javax.swing.JMenu MenuCaminhao;
    private javax.swing.JMenu MenuCliente;
    private javax.swing.JMenu MenuFuncionario;
    private javax.swing.JMenu MenuMenu;
    private javax.swing.JMenu MenuPedido;
    private javax.swing.JMenu MenuProdutos;
    private javax.swing.JMenuItem NovoPedido;
    private javax.swing.JMenuItem Pesquisar;
    private javax.swing.JMenuItem RemoverCliente;
    private javax.swing.JMenuItem RemoverFuncionario;
    private javax.swing.JMenuItem RemoverPedido;
    private javax.swing.JMenuItem Sair;
    private javax.swing.JDesktopPane jDesktopPaneTelaPrincipal;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
