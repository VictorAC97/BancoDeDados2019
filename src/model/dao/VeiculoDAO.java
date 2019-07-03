package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Veiculo;

public class VeiculoDAO {

    private Connection con = null;
    
    public VeiculoDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Veiculo v){
        
        String sql = "INSERT INTO VEICULO (PLACA) VALUES (?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getPlaca());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public List<Veiculo> read(){
        
        String sql = "SELECT * FROM VEICULO";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Veiculo> veiculos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
                
            while(rs.next()){
                Veiculo v = new Veiculo();
                v.setPlaca(rs.getString("PLACA"));
                veiculos.add(v);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return veiculos;
    }
    
    public void update(Veiculo v){
        
        String sql = "UPDATE VEICULO SET (PLACA) = ? WHERE ID_MODELO = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getPlaca());
            stmt.setInt(2, v.getModelo().getIdmodelo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);          
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(Veiculo v){
            
        String cmdSQL = "DELETE FROM VEICULO WHERE PLACA = ?";
        
        PreparedStatement stmt = null;
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, v.getPlaca());
            stmt.executeUpdate();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
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
        
        try { //lol
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM VEICULO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                
                Veiculo veiculo = new Veiculo();
                veiculo.setPlaca(rs.getString("PLACA"));
                veiculo.setAnofab(rs.getInt("ANOFAB"));
          //      veiculo.setId_marca(rs.getInt("ID_MARCA"));
            //    veiculo.setId_modelo(rs.getInt("ID_MODELO"));
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
