package model.dao;

import model.bean.Veiculo;

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
import model.bean.Veiculo;

public class VeiculoDAO {

    public void inserirVeiculo(Veiculo v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO VEICULO(PLACA) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, v.getPlaca());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerVeiculo(Veiculo v){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM VEICULO WHERE PLACA = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, v.getPlaca());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Veiculo removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Veiculo> consultaVeiculo(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Veiculo> veiculos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM VEICULO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                Veiculo categoria = new Veiculo();
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("PLACA"));
                veiculo.setAnofab(rs.getInt("ANOFAB"));
                veiculo.setId_marca(rs.getInt("ID_MARCA"));
                veiculo.setId_modelo(rs.getInt("ID_MODELO"));
                veiculo.setLocal_uf(rs.getString("LOCAL_UF"));
                veiculo.setLocal_cep(rs.getString("LOCAL_CEP"));

                veiculos.add(veiculo);
                
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
        return veiculos;
    }
                
    
}
