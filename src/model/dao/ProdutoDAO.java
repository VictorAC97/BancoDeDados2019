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
            stmt.setString(1, p.getNome());           //pega o cpf/cnpj
            stmt.setFloat(2, p.getPreco());         //pega o nome
            stmt.setFloat(3, p.getPeso());     //pega o telefone
            stmt.setFloat(4, p.getAltura());           //pega a UF
            stmt.setFloat(5, p.getLargura());          //pega o CEP
            stmt.setInt(6, p.getId_categoria());       //pega a cidade
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Produto cadastrado.");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }
}
