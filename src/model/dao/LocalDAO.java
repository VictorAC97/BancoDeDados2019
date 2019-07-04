
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
import model.bean.Local;


public class LocalDAO {

    
    public void inserirLocal(Local l){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "INSERT INTO LOCAL(CIDADE) VALUES(?)";
                
        try{
            stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
            stmt.setString(1, l.getCidade());         //pega por cidade
            
            //preparando a sql para executar/update,usamos o executeUpdate porque é um comando DML(Manipulacao de dados).
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Local cadastrado com sucesso!");
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel cadastrar! \nERRO: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }           
    }
    
    
    public void removerLocal(Local l){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
            String cmdSQL = "DELETE FROM LOCAL WHERE CIDADE = ?"; //mexer no parâmetro. deleta por cidade, bairro...?
            
            try{
                stmt = (PreparedStatement) con.prepareStatement(cmdSQL);
                stmt.setString(1, l.getCidade());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Local removido com sucesso!");

            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Erro ao excluir! \nERRO: "+ex);
            }
            
    }
    
    
    public List<Local> consultaLocal(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Local> locais = new ArrayList<>();
        
        try{
            
            stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM LOCAL");
            rs = stmt.executeQuery();

            while(rs.next()){
                Local local = new Local();
                local.setUf(rs.getString("UF"));
                local.setCep(rs.getString("CEP"));
                local.setCidade(rs.getString("CIDADE"));
                local.setBairro(rs.getString("BAIRRO"));
                local.setRua(rs.getString("RUA"));
                local.setNumero(rs.getInt("NUMERO"));
                local.setCompl(rs.getString("COMPL"));
                locais.add(local);
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
        return locais;
    }
}
