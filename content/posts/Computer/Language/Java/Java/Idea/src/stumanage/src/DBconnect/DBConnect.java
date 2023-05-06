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
            System.out.println("���������ɹ���");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("��������ʧ�ܣ�aaaa");
        }
        try
        {
            dbConn=DriverManager.getConnection(dbURL,userName, userPwd);
            System.out.println("�������ݿ�ɹ���");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.print("SQL Server����ʧ��!aaaaaaaa");
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
                    System.out.println("�ر����ݿ⣡");
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
                    System.out.println("�ر����ݿ⣡");
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
                    System.out.println("�ر����ݿ⣡");
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
