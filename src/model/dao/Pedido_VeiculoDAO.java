package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pedido_Veiculo;

public class Pedido_VeiculoDAO {
    
    public void inserirPedido_Veiculo(Pedido_Veiculo p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO PEDIDO_VEICULO(ID_PLACA) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, p.getPlaca());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Pedido de Veiculo cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerPedido_Veiculo(Pedido_Veiculo p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM PEDIDO_VEICULO WHERE ID_PLACA = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, p.getPlaca());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Pedido de Veiculo removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Pedido_Veiculo> consultaPedido_Veiculo(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido_Veiculo> pedido_veiculos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM PEDIDO_VEICULO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                
                Pedido_Veiculo pedido_veiculo = new Pedido_Veiculo();
                pedido_veiculo.setId_pedido(rs.getInt("ID_PEDIDO"));
                pedido_veiculo.setPlaca(rs.getString("PLACA"));

                pedido_veiculos.add(pedido_veiculo);
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
        return pedido_veiculos;
    }   
    
                
    
}
