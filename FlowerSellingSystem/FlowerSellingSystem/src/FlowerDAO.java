import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlowerDAO implements DAOInterface<Flower>
{

    public FlowerDAO()
    {
    }

    @Override
    public boolean addData(Flower t)
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

        String sql = "insert into flower(name, flowertype, price, nums, cost) values "+
                "("+
                "'"+t.getName()+"'"+","+
                "'"+t.getFlowertype()+"'"+","+
                t.getPrice()+","+
                t.getNums()+","+
                t.getCost()+","+
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
    public boolean getData(Flower t, ResultSet Result)
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
