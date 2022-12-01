import java.sql.SQLException;

public interface CustomerService
{
    public Flower ViewFlower() throws SQLException;

    public boolean BuyFlower() throws SQLException;

    public Orders CheckOrder() throws SQLException;

    public boolean Login(String Account, String Password) throws SQLException;

}
