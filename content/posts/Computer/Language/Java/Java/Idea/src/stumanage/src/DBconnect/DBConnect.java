package DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect
{

    public static Connection Connecte()
    {
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=SSMS";
        String userName="admin";
        String userPwd="123456";
        Connection dbConn=null;
        try
        {
            Class.forName(driverName);
            System.out.println("加载驱动成功！");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("加载驱动失败！aaaa");
        }
        try
        {
            dbConn=DriverManager.getConnection(dbURL,userName, userPwd);
            System.out.println("连接数据库成功！");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("SQL Server连接失败!aaaaaaaa");
        }
        return dbConn;
    }

    public static void closeObject(Object obj)
    {
        if(obj != null)
        {
            if(obj instanceof ResultSet)
            {
                try
                {
                    ((ResultSet) obj).close();
                    System.out.println("关闭数据库！");
                }
                catch(SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if(obj instanceof PreparedStatement)
            {
                try
                {
                    ((PreparedStatement) obj).close();
                    System.out.println("关闭数据库！");
                }
                catch(SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if(obj instanceof Connection)
            {
                try
                {
                    ((Connection) obj).close();
                    System.out.println("关闭数据库！");
                }
                catch(SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
