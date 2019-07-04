/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            String cmdSQL = "INSERT INTO FUNCIONARIO(IDFUNCIONARIO,NOME,SEXO,TELEFONE,DATAENT,HORAS,ID_TIPO_FUNCIONARIO) VALUES(?,?,?,?,?,?,?)";
                                                                                                                             //(1,2,3,4,5,6,7)                  
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setInt(1, f.getIdfuncionario()); //pega a matricula
            stmt.setString(2, f.getNome());             //pega o nome
            stmt.setString(3, f.getSexo());             //pega o sexo
            stmt.setString(4, f.getTelefone());         //pega o telefone
            stmt.setString(5, f.getDataent());      //pega a data de entrada
            stmt.setInt(6, f.getHoras());               //pega as horas trabalhadas
            stmt.setInt(7, f.getId_tipo_funcionario()); //pega o tipo de funcionario
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Funcionário cadastrado, bem vindo! "+f.getNome());
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }

public void editarFuncionario(Funcionario f){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "UPDATE FUNCIONARIO SET NOME = ?,SEXO = ?,TELEFONE = ?, HORAS = ? WHERE IDFUNCIONARIO = ?";
             
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, f.getNome());         //pega o nome
            stmt.setString(2, f.getSexo());     //pega o telefone
            stmt.setString(3, f.getTelefone());           //pega a UF
            stmt.setInt(4, f.getHoras());          //pega o CEP
            stmt.setInt(5, f.getIdfuncionario());           //pega o cpf/cnpj
                        
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }    
    
    public void removerFuncionario(Funcionario f){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            String cmdSQL = "DELETE FROM FUNCIONARIO WHERE IDFUNCIONARIO = ?";
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setInt(1, f.getIdfuncionario());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Funcionário removido com sucesso!");
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
    public List<Funcionario> listarFuncionario(){
            
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = null;
                ResultSet res = null;
                
                List<Funcionario> funcionarios = new ArrayList<>();
                
            try{
                
                String cmdSQL = "SELECT * FROM FUNCIONARIO";
                
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                res = stmt.executeQuery();

                while(res.next()){
                        Funcionario f = new Funcionario();
                        
                        f.setIdfuncionario(Integer.parseInt(res.getString("IDFUNCIONARIO")));
                        f.setNome(res.getString("NOME"));
                        f.setSexo(res.getString("SEXO"));
                        f.setHoras(res.getInt("HORAS"));
                        f.setDataent(res.getString("DATAENT"));
                        f.setTelefone(res.getString("TELEFONE"));
                        f.setId_tipo_funcionario(res.getInt("ID_TIPO_FUNCIONARIO"));
                        
                        funcionarios.add(f);
                }
       
          }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao listar! \nERRO: "+ex);
                return null; //retornar um cliente vazio
          }finally{
                ConnectionFactory.closeConnection(con, stmt, res);
            }             
        return funcionarios;
    }
     

}
