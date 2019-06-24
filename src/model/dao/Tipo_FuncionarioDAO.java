package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import model.bean.Tipo_Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import model.bean.Categoria;

public class Tipo_FuncionarioDAO {

    public List<Tipo_Funcionario> consultaTipo_Funcionario(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Tipo_Funcionario> TipoFuncionarios = new ArrayList<>();
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM TIPO_FUNCIONARIO");
            rs = stmt.executeQuery();
            
            while(rs.next()){  
                Tipo_Funcionario tf = new Tipo_Funcionario();
                tf.setNome(rs.getString("TIPO"));
                TipoFuncionarios.add(tf);
            }
            

        } catch (SQLException ex) {
            
        }finally{
            ConnectionFactory.closeConnection(con, (com.mysql.jdbc.PreparedStatement) stmt, rs);
        }
        return TipoFuncionarios;
    }

}
