import java.sql.*;

public class SQLConnect
{
    static
    {
        try
        {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/FlowerSellingSystem";
        String name = "root";
        String password = "123456";

        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url,name,password);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close(Connection conn, Statement st, PreparedStatement ps, ResultSet rs)
    {
        try {
			if(rs != null)
				rs.close();
			if(st != null)
				st.close();
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
