import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDAO implements DAOInterface<Customer>
{
    public CustomerDAO()
    {
    }

    @Override
    public boolean addData(Customer t)
    {
        Connection Conn = SQLConnect.getConnection();
        Statement Stmt;
        try
        {
            Stmt = Conn.createStatement();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

        String sql = "insert into customer(name, phonenumber, password) values "+
                "("+
                "'"+t.getName()+"'"+","+
                "'"+t.getPhonenumber()+"'"+","+
                "'"+t.getPhonenumber()+"'"+
                ");";
        try
        {
            Stmt.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ResultSet getData() throws SQLException
    {
        Connection Conn = SQLConnect.getConnection();
        Statement Stmt;
        try
        {
            Stmt = Conn.createStatement();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }

        String sql = "select * from customer;";

        ResultSet Result = Stmt.executeQuery(sql);

        return Result;
    }

    @Override
    public boolean setData(Customer customer)
    {
        return false;
    }
}
