package dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class AbstractDAO {
    public static Connection connect() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        com.mysql.jdbc.Driver a;
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/resumeapp","root","a20022002");
        return con;
    }
}
