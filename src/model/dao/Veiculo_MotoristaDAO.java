package model.dao;

import model.bean.Veiculo_Motorista;

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
import model.bean.Veiculo_Motorista;

public class Veiculo_MotoristaDAO {

    public void inserirVeiculo_Motorista(Veiculo_Motorista vm){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO VEICULO_MOTORISTA(ID_PLACA) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, vm.getId_placa());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Veiculo do Motorista cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerVeiculo_Motorista(Veiculo_Motorista vm){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM VEICULO_MOTORISTA WHERE ID_PLACA = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, vm.getId_placa());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Veiculo do Motorista removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Veiculo_Motorista> consultaVeiculo_Motorista(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Veiculo_Motorista> vmotoristas = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM VEICULO_MOTORISTA");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
   
                Veiculo_Motorista vmotorista = new Veiculo_Motorista();
                vmotorista.setId_motorista(rs.getInt("ID_MOTORISTA"));
                vmotorista.setId_placa(rs.getString("ID_PLACA"));
                vmotoristas.add(vmotorista);
   
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
        return vmotoristas;
    }
    
    

}
