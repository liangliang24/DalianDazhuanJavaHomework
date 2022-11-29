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

        String sql = "insert into flower(name, flowertype, price, nums, cost,profit) values "+
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

        String sql = "select * from flower;";

        ResultSet Result = Stmt.executeQuery(sql);

        return Result;
    }

    @Override
    public boolean setData(Flower flower)
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

        String sql = "update flower set " +
                "flowertype = " + "'"+ flower.getFlowertype() + "'"+ "," +
                "price = " + flower.getPrice() + "," +
                "nums = " + flower.getNums() + "," +
                "cost = " + flower.getCost() + "," +
                "profit = " + flower.getProfit() + "," +
                "where" +
                "'" + flower.getName() + "'" + "= name;";
        int changeline = 0;
        try
        {
            changeline = Stmt.executeUpdate(sql);
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        if (changeline == 0)
        {
            System.out.println("更改失败，可能未找到合适数据");
            return false;
        }
        return true;
    }
}
