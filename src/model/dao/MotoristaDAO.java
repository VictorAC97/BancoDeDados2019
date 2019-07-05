package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Motorista;

public class MotoristaDAO {

public void inserirMotorista(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO MOTORISTA (CNH,MULTAS,ID_FUNCIONARIO) VALUES(?,?,?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getCnh());         //pega o nome
            stmt.setInt(2, m.getMultas());         //pega o nome
            stmt.setInt(3, m.getId_funcionario());         //pega o nome
            //stmt.setString(4, m.getValidade());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Motorista cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }


public void editarMotorista(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "UPDATE MOTORISTA SET CNH = ?,MULTAS = ?,VALIDADE = ? WHERE ID_FUNCIONARIO = ?";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getCnh());
            stmt.setInt(2,m.getMultas());
            stmt.setDate(3, (Date) m.getValidade());
            stmt.setInt(4,m.getId_funcionario());
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel editar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }

public List<Motorista> listarMotorista(){
            
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = null;
                ResultSet res = null;
                
                List<Motorista> motoristas = new ArrayList<>();
                
            try{

                
                String cmdSQL = "SELECT * FROM MOTORISTA";
                
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                res = stmt.executeQuery();

                while(res.next()){
                        Motorista m = new Motorista();
                        
                        m.setId_funcionario(res.getInt("ID_FUNCIONARIO"));
                        m.setCnh(res.getString("CNH"));
                        m.setMultas(res.getInt("MULTAS"));
                        m.setValidade(res.getDate("VALIDADE"));
                        motoristas.add(m);
                }
       
          }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao listar! \nERRO: "+ex);
                return null; //retornar um cliente vazio
          }finally{
                ConnectionFactory.closeConnection(con, stmt, res);
            }             
        return motoristas;
    }

    public void removerMotorista(Motorista m){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM MOTORISTA WHERE CNH = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, m.getCnh());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Motorista removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Motorista> consultaMotorista(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Motorista> motoristas = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM MOTORISTA");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                Motorista motorista = new Motorista();
                motorista.setId_funcionario(rs.getInt("ID_FUNCIONARIO"));
                motorista.setCnh(rs.getString("CNH"));
                motorista.setMultas(rs.getInt("MULTAS"));
                motorista.setValidade(rs.getDate("VALIDADE"));
                motoristas.add(motorista);
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
        return motoristas;
    }
    
}
