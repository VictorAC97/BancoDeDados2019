/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author Victor
 */
public class ProdutoDAO {
    public void inserirProduto(Produto p){
        
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
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }
}
