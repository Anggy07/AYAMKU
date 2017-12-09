/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayam.Model;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
/**
 *
 * @author anggy
 */
public class koneksi {
    public Connection conn;
    public Statement stm;
    
    public koneksi() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ayamku";
        String username ="root";
        String password = "";
        
        conn = DriverManager.getConnection(url, username, password);
        stm = conn.createStatement();
}
    public void execute (String sql) throws SQLException {
      stm.execute(sql);
    }
    public ResultSet getResult (String sql) throws SQLException {
        ResultSet rs = stm.executeQuery(sql);
        return rs;
    }

}

