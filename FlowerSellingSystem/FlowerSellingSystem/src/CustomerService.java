import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerService
{
    public ArrayList<Flower> ViewFlower() throws SQLException;

    public boolean BuyFlower(String flowername, int nums) throws SQLException;

    public ArrayList<Orders> CheckOrder() throws SQLException;

    public boolean Login(String Account, String Password) throws SQLException;

}
