package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
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
            String cmdSQL = "INSERT INTO MOTORISTA(CNH) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, m.getCnh());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Motorista cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
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
