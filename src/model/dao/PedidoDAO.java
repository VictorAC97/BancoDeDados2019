package model.dao;

import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pedido;

public class PedidoDAO {

    public void inserirPedido(Pedido p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO PEDIDO(FRETE, ID_PRODUTO, ID_CLIENTE) VALUES(?,?,?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setFloat(1, p.getFrete());
            stmt.setInt(2, p.getId_produto());
            stmt.setString(3, p.getId_cliente());
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerPedido(Pedido p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM PEDIDO WHERE ID_PEDIDO = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setInt(1, p.getIdpedido()); //vai dar certo?? -- mudei de setString pra setInt
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Pedido removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Pedido> consultaPedido(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM PEDIDO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                
                Pedido pedido = new Pedido();
                pedido.setIdpedido(rs.getInt("IDPEDIDO"));
                pedido.setFrete(rs.getFloat("NOME"));
                pedido.setId_produto(rs.getInt("ID_PRODUTO"));
                pedido.setId_cliente(rs.getString("ID_CLIENTE"));

                pedidos.add(pedido);
            }
            

        }
        
        catch (SQLException ex){
            System.err.println("Erro ao recuperar os dados."+ex.getMessage());
        }
        catch (Exception ex){
            System.err.println("Erro geral."+ex.getMessage());
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
    }
    
    public void update(Pedido v){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
                
        
        try {
            stmt = con.prepareStatement("UPDATE PEDIDO SET FRETE = ?, ID_PRODUTO = ?, ID_CLIENTE = ? WHERE IDPEDIDO = ?");
           
            stmt.setFloat(1, v.getFrete());
            stmt.setInt(2, v.getId_produto());
            stmt.setString(3, v.getId_cliente());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);          
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    


}
