import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        FlowerStoreServiceImpl f = new FlowerStoreServiceImpl();
        try
        {
            f.Login();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}