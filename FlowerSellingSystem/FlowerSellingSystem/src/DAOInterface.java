import java.sql.ResultSet;
import java.sql.SQLException;

public interface DAOInterface<T>
{
    public boolean addData(T t);

    public ResultSet getData() throws SQLException;

    public boolean setData(T t);
}
