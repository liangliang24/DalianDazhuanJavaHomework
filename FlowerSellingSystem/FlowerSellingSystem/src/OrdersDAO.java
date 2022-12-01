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
    public boolean setData(Orders orders)
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

        String sql = "update orders set" +
                "customername = " + "'"+orders.getCustomerName()+"'" +"," +
                "customerphonenumber = " + "'"+orders.getCustomerPhonenumber()+"'" + ","+
                "customerconsumption = "  + orders.getCustomerConsumption() + "," +
                "flowername = " + "'" + orders.getFlowerName() + "'" + "," +
                "flowernums = " + orders.getFLowerNums() + "," +
                "id = " + orders.getId() + "," +
                "time = " + orders.getDatetime();
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

        String sql = "insert into orders(customername, customerphonenumber, customerconsumption, flowername, flowernums, id, time) values "+
                "("+
                "'"+t.getCustomerName()+"'"+","+
                "'"+t.getCustomerPhonenumber()+"'"+","+
                t.getCustomerConsumption()+","+
                "'"+t.getFlowerName()+"'"+","+
                t.getFLowerNums()+","+
                t.getId()+","+
                "'"+t.getDatetime()+"'"+");";
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

        String sql = "select * from orders;";

        ResultSet Result = Stmt.executeQuery(sql);

        return Result;
    }
}
