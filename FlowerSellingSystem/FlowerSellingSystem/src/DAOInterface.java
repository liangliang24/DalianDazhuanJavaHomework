import java.sql.ResultSet;

public interface DAOInterface<T>
{
    public boolean addData(T t);

    public boolean getData(T t, ResultSet Result);
}
