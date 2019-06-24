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
import model.bean.Tipo_Funcionario;

public class Tipo_FuncionarioDAO {

    public void inserirTipo_Funcionario(Tipo_Funcionario tp){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO TIPO_FUNCIONARIO(ID_TIPOFUNCIONARIO) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setInt(1, tp.getIdtipo_funcionario());         //pega o nome
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Tipo de Funcionario cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    public void removerTipo_Funcionario(Tipo_Funcionario tp){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM TIPO_FUNCIONARIO WHERE NOME = ?";
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setInt(1, tp.getIdtipo_funcionario());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Tipo de Funcionario removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    public List<Tipo_Funcionario> consultaTipo_Funcionario(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Tipo_Funcionario> tipos = new ArrayList<>();
        
        try {
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM TIPO_FUNCIONARIO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
               
                Tipo_Funcionario tipo = new Tipo_Funcionario();
                tipo.setIdtipo_funcionario(rs.getInt("IDTIPO_FUNCIONARIO"));
                tipo.setTipo(rs.getString("NOME"));

                tipos.add(tipo);
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
        return tipos;
    }
    

}
