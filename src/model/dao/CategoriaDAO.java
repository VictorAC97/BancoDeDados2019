/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import model.bean.Categoria;
/**
 *
 * @author Victor
 */
public class CategoriaDAO {
    
    private Connection con = null;
    
    public CategoriaDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    //CREATE
    public boolean create(Categoria c){
        
        String sql = "INSERT INTO CATEGORIA VALUES (?,?)";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,c.getIdcategoria());
            stmt.setString(2, c.getNome());
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
    public List<Categoria> read(){
        
        String sql = "SELECT * FROM CATEGORIA";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Categoria> categorias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
                
            while(rs.next()){
                Categoria c = new Categoria();
                c.setIdcategoria(rs.getInt("IDCATEGORIA"));
                c.setNome(rs.getString("NOME"));
                categorias.add(c);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return categorias;
    }
    
    //UPDATE
    public void update(Categoria c){
        
        String sql = "UPDATE CATEGORIA SET NOME = ? WHERE IDCATEGORIA = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setInt(2, c.getIdcategoria());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Categoria atualizada com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar! \nERRO: "+ex);          
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    //DELETE
    public void delete(Categoria c){
            
        String cmdSQL = "DELETE FROM CATEGORIA WHERE IDCATEGORIA = ?";
        
        PreparedStatement stmt = null;
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setInt(1, c.getIdcategoria());
            stmt.executeUpdate();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
}
