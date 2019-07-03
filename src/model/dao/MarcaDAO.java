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
import model.bean.Marca;

public class MarcaDAO {

    private Connection con = null;
    
    public MarcaDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Marca m){
        
        String sql = "INSERT INTO MARCA (NOME) VALUES (?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome());
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
    public List<Marca> read(){
        
        String sql = "SELECT * FROM MARCA";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Marca> marcas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
                
            while(rs.next()){
                Marca m = new Marca();
                m.setNome(rs.getString("NOME"));
                marcas.add(m);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return marcas;
    }
    
    //UPDATE
    public void update(Marca m){
        
        String sql = "UPDATE MARCA SET (NOME) = ? WHERE IDMARCA = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, m.getNome());
            stmt.setInt(2, m.getIdmarca());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);          
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    //DELETE
    public void delete(Marca m){
            
        String cmdSQL = "DELETE FROM MARCA WHERE NOME = ?";
        
        PreparedStatement stmt = null;
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getNome());
            stmt.executeUpdate();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
    /*****/
    public void inserirMarca(Marca m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO MARCA(NOME) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getNome());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Marca cadastrada com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerMarca(Marca m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM MARCA WHERE NOME = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, m.getNome());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Marca removida com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Marca> consultaMarca(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Marca> marcas = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MARCA");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
               
                Marca marca = new Marca();
                marca.setIdmarca(rs.getInt("IDMARCA"));
                marca.setNome(rs.getString("NOME"));

                marcas.add(marca);
                
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
        return marcas;
    }
    

}