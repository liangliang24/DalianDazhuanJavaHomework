import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerService
{
    public ArrayList<Flower> ViewFlower() throws SQLException;

    public boolean BuyFlower() throws SQLException;

    public Orders CheckOrder() throws SQLException;

    public boolean Login() throws SQLException;

}
