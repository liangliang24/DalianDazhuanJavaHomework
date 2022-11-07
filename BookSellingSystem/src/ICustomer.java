import java.util.List;

public interface ICustomer
{
    void checkBook(int BookId);

    int BuyBook(int BookId,int nums);

    List<String> getEX();

    EX buyEX(int EXCode);

    int checkout();
}
