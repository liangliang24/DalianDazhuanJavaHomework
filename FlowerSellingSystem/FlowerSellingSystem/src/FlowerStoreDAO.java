import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlowerStoreDAO implements DAOInterface<FlowerStore>
{
    public FlowerStoreDAO()
    {
    }

    @Override
    public boolean setData(FlowerStore flowerStore)
    {
        return false;
    }

    @Override
    public boolean addData(FlowerStore t)
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

        String sql = "insert into flowerstore(acount, password) values "+
                "("+
                "'"+t.getAcount()+"'"+","+
                "'"+t.getPassword()+"'"+","+
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

        String sql = "select * from flowerstore;";

        ResultSet Result = Stmt.executeQuery(sql);

        return Result;
    }
}
