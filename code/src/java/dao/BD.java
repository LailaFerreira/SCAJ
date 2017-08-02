package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {
 
    public static Connection getConexao() throws SQLException, ClassNotFoundException {
       Connection conexao = null;
       Class.forName("com.mysql.jdbc.Driver");
       conexao = DriverManager.getConnection("jdbc:mysql://localhost/scaj", "root", "");
       return conexao;
    }
    
    public static void fecharConexao(Connection conexao, Statement comando) throws SQLException{
        try{
            if(conexao != null){
                conexao.close();
            }
        }catch(SQLException ex){
            throw ex;
        }
}
}
    

