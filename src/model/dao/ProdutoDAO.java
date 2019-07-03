/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author Victor
 */
public class ProdutoDAO {
    
    private Connection con = null;
    
    public ProdutoDAO(){
        con = ConnectionFactory.getConnection();
    }
    
    public boolean create(Produto p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO PRODUTO(NOME,PRECO,PESO,ALTURA,LARGURA,ID_CATEGORIA) VALUES(?,?,?,?,?,?)";
                                                                                                  //(1,2,3,4,5,6)                  
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, p.getNome());           //pega a descricao
            stmt.setFloat(2, p.getPreco());         //pega o preco
            stmt.setFloat(3, p.getPeso());     //pega o peso
            stmt.setFloat(4, p.getAltura());           //pega a altura
            stmt.setFloat(5, p.getLargura());          //pega a largura
            stmt.setInt(6, p.getCategoria().getIdcategoria());       //pega o id da categoria (orientacao a objeto)
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado.");
            return true;
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }
    
    public List<Produto> read(){
        
        String sql = "SELECT * FROM PRODUTO";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
                
            while(rs.next()){
                Produto p = new Produto();
                p.setNome(rs.getString("NOME"));
                
                produtos.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel listar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return produtos;
    }
    
    public void update(Produto p){
        
        String sql = "UPDATE PRODUTO SET (NOME) = ? WHERE IDPRODUTO = ?";
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getIdProduto());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);          
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete(Produto v){
            
        String cmdSQL = "DELETE FROM PRODUTO WHERE NOME = ?";
        
        PreparedStatement stmt = null;
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, v.getNome());
            stmt.executeUpdate();

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
    public Produto buscarProduto(int id){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet res = null;

            String cmdSQL = "SELECT * FROM PRODUTO WHERE IDPRODUTO = "+id;
                        
            Produto pro = new Produto();
                
        try {
                stmt = con.prepareStatement(cmdSQL);
                res = stmt.executeQuery();
                
                while(res.next()){
                    pro.setIdProduto(res.getInt("IDCLIENTE"));
                    pro.setNome(res.getString("NOME"));
                    pro.setPreco(res.getFloat("PRECO"));
                    pro.setAltura(res.getFloat("ALTURA"));
                    pro.setLargura(res.getFloat("LARGURA"));
                    pro.setPeso(res.getFloat("PESO"));
                    //pro.setCategoria(res.getCategoria("ID_CATEGORIA")); -- TÁ BUGANDO KKK
                    
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! \nERRO: "+ex);
        }finally{
                ConnectionFactory.closeConnection(con, stmt, res);
            }  
        
        return pro;
    }
    
}
