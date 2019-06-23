/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import connection.ConnectionFactory;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;

/**
 *
 * @author Victor
 */
public class ClienteDAO {
    
    public void inserirCliente(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO CLIENTE(IDCLIENTE,NOME,TELEFONE,UF,CEP,CIDADE,BAIRRO,RUA,NUMERO,COMPL) VALUES(?,?,?,?,?,?,?,?,?,?)";
                                                                                                                    //(1,2,3,4,5,6,7,8,9,10)                  
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, c.getId());           //pega o cpf/cnpj
            stmt.setString(2, c.getNome());         //pega o nome
            stmt.setString(3, c.getTelefone());     //pega o telefone
            stmt.setString(4, c.getUf());           //pega a UF
            stmt.setString(5, c.getCep());          //pega o CEP
            stmt.setString(6, c.getCidade());       //pega a cidade
            stmt.setString(7, c.getBairro());       //pega o bairro
            stmt.setString(8, c.getRua());          //pega a rua
            stmt.setInt(9, c.getNumero());          //pega o numero
            stmt.setString(10, c.getCompl());       //pega o complemento
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado, bem vindo! "+c.getNome());
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao cadastrado! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
    
        
    }
         
}
