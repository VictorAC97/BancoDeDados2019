
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
import model.bean.Modelo;

public class ModeloDAO {

    private Connection con = null;
    
    public ModeloDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Modelo m){
        
        String sql = "INSERT INTO MODELO (NOME,IDMODELO) VALUES (?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getIdmodelo());
            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //READ
    public List<Modelo> read(){
        
        String sql = "SELECT * FROM MODELO";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Modelo> modelos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
                
            while(rs.next()){
                Modelo m = new Modelo();
                m.setNome(rs.getString("NOME"));
                modelos.add(m);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return modelos;
    }
    
    //UPDATE
    public void update(Modelo m){
        
        String sql = "UPDATE MODELO SET NOME = ? WHERE IDMODELO = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getIdmodelo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modelo cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);          
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    //DELETE
    public void delete(Modelo m){
            
        String cmdSQL = "DELETE FROM MODELO WHERE NOME = ?";
        
        PreparedStatement stmt = null;
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getNome());
            stmt.executeUpdate();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
    
    
    public void inserirModelo(Modelo m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO MODELO(NOME) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getNome());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Modelo cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerModelo(Modelo m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM MODELO WHERE NOME = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, m.getNome());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Modelo removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Modelo> consultaModelo(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Modelo> modelos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MODELO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                Modelo modelo = new Modelo();
                modelo.setIdmodelo(rs.getInt("IDMODELO"));
                modelo.setNome(rs.getString("NOME"));

                modelos.add(modelo);
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
        return modelos;
    }
    

}
