import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersDAO implements DAOInterface<Orders>
{
    public OrdersDAO()
    {
    }

    @Override
    public boolean addData(Orders t)
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

        String sql = "insert into orders(customername, customerphonenumber, customerconsumption, flowername, flowernums, id) values "+
                "("+
                "'"+t.getCustomerName()+"'"+","+
                "'"+t.getCustomerPhonenumber()+"'"+","+
                t.getCustomerConsumption()+","+
                "'"+t.getFlowerName()+"'"+","+
                t.getFLowerNums()+","+
                t.getId()+","+
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
    public boolean getData(Orders orders, ResultSet Result)
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

        String sql = "select * from customer;";
        try
        {
            Result = Stmt.executeQuery(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
