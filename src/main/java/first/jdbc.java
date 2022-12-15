package first;
import org.apache.log4j.BasicConfigurator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class jdbc{
    private static final Logger logger = Logger.getLogger(jdbc.class.getName());
    Connection con;
    public void test(){
        try{
            BasicConfigurator.configure();
            Properties props = new Properties();
            InputStream ins = new FileInputStream("lib/employee.properties");
            props.load(ins);
            Class.forName(props.getProperty("jdbc.driver"));
            con= DriverManager.getConnection(
                    props.getProperty("jdbc.url"),props.getProperty("jdbc.usrnm"),props.getProperty("jdbc.pass"));
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");
            while(rs.next())
                logger.info(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
    public void delete() throws SQLException {
       logger.info("exe delete");
        Statement stmt=con.createStatement();
        stmt.executeUpdate("delete from employee where id=9");
    }
    public ResultSet select() throws SQLException {
        logger.info("exe select");
        Statement stmt=con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employee");
//        stmt.close();
        return rs;
    }
//    public void insert(Connection con,int id) throws SQLException {
//        System.out.println("exe insertion");
//        Statement stmt=con.createStatement();
//        stmt.executeQuery("insert into employee values("+id+",'"deku",2)");
//    }

}
