/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.bean.Funcionario;
/**
 *
 * @author Victor
 */
public class FuncionarioDAO {
    
    public void inserirFuncionario(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO FUNCIONARIO(NOME,SEXO,TELEFONE,DATAENT,HORAS,ID_TIPO_FUNCIONARIO) VALUES(?,?,?,?,?,?)";
                                                                                                               //(1,2,3,4,5,6)                  
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, f.getNome());             //pega o nome
            stmt.setString(2, f.getSexo());             //pega o sexo
            stmt.setString(3, f.getTelefone());         //pega o telefone
            stmt.setDate(4, (Date)f.getDataent());      //pega a data de entrada
            stmt.setInt(5, f.getHoras());               //pega as horas trabalhadas
            stmt.setInt(6, f.getId_tipo_funcionario()); //pega o tipo de funcionario
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado, bem vindo! "+f.getNome());
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }
    
    
    public void removerFuncionario(Funcionario f){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            String cmdSQL = "DELETE FROM FUNCIONARIO WHERE NOME = ?";
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, f.getNome());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
     

}
