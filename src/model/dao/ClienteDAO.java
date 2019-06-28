/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;



import java.sql.Connection;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
        
    }
    
    public void editarCliente(Cliente c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "UPDADE CLIENTE SET NOME = ?,TELEFONE = ?,UF = ?,CEP = ?,CIDADE = ?,BAIRRO = ?,RUA = ?,NUMERO = ?,COMPL = ? WHERE IDCLIENTE = ?";
                                                    // 1,           2,     3,      4,         5,         6,      7,         8,        9                 ,10                  
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, c.getNome());         //pega o nome
            stmt.setString(2, c.getTelefone());     //pega o telefone
            stmt.setString(3, c.getUf());           //pega a UF
            stmt.setString(4, c.getCep());          //pega o CEP
            stmt.setString(5, c.getCidade());       //pega a cidade
            stmt.setString(6, c.getBairro());       //pega o bairro
            stmt.setString(7, c.getRua());          //pega a rua
            stmt.setInt(8, c.getNumero());          //pega o numero
            stmt.setString(9, c.getCompl());       //pega o complemento
            stmt.setString(10, c.getId());           //pega o cpf/cnpj
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel atualizar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }   
     
    }
    
    public void removerCliente(Cliente c){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;

            String cmdSQL = "DELETE FROM CLIENTE WHERE IDCLIENTE = ?";
            
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, c.getId());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
        }
            
    }
    
    public Cliente buscarCliente(String id){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet res = null;

            String cmdSQL = "SELECT * FROM CLIENTE WHERE IDCLIENTE = "+id;
                        
            Cliente cli = new Cliente();
                
        try {
                stmt = con.prepareStatement(cmdSQL);
                res = stmt.executeQuery();
                
                while(res.next()){
                    cli.setId(res.getString("IDCLIENTE"));
                    cli.setNome(res.getString("NOME"));
                    cli.setTelefone(res.getString("TELEFONE"));
                    cli.setCidade(res.getString("CIDADE"));
                    cli.setBairro(res.getString("BAIRRO"));
                    cli.setRua(res.getString("RUA"));
                    cli.setNumero(res.getInt("NUMERO"));
                    cli.setCompl(res.getString("COMPL"));
                    cli.setCep(res.getString("CEP"));
                    cli.setUf(res.getString("UF"));
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar! \nERRO: "+ex);
        }finally{
                ConnectionFactory.closeConnection(con, stmt, res);
            }  
        
        return cli;
    }
    
    public List<Cliente> listarCliente(){
            
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = null;
                ResultSet res = null;
                
                List<Cliente> clientes = new ArrayList<>();
                
            try{

                
                String cmdSQL = "SELECT * FROM CLIENTE";
                
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                res = stmt.executeQuery();

                while(res.next()){
                        Cliente cli = new Cliente();
                        
                        cli.setId(res.getString("IDCLIENTE"));
                        cli.setNome(res.getString("NOME"));
                        cli.setTelefone(res.getString("TELEFONE"));
                        cli.setCidade(res.getString("CIDADE"));
                        cli.setBairro(res.getString("BAIRRO"));
                        cli.setRua(res.getString("RUA"));
                        cli.setNumero(res.getInt("NUMERO"));
                        cli.setCompl(res.getString("COMPL"));
                        cli.setCep(res.getString("CEP"));
                        cli.setUf(res.getString("UF"));
                        clientes.add(cli);
                }
       
          }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao listar! \nERRO: "+ex);
                return null; //retornar um cliente vazio
          }finally{
                ConnectionFactory.closeConnection(con, stmt, res);
            }             
        return clientes;
    }
              
}
