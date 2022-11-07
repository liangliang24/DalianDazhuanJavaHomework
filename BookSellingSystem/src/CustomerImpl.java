import java.util.List;

public class CustomerImpl implements ICustomer
{
    private BookMgr bm;

    @Override
    public void checkBook(int BookId)
    {
        BookMgr Manage = bm.getInstance();

        Book CheckTemp = Manage.getById(BookId);

        System.out.println("作者"+CheckTemp.getAuthor());

        System.out.println("Id"+CheckTemp.getId());

        System.out.println("书名"+CheckTemp.getName());

        System.out.println("库存数量"+CheckTemp.getStore());

        System.out.println("价格"+CheckTemp.getPrice());

        System.out.println("出版日期"+CheckTemp.getPub_date());
    }

    @Override
    public int BuyBook(int BookId,int nums)
    {
        BookMgr Manage = bm.getInstance();
        return Manage.BuyBook(BookId,nums);
    }

    @Override
    public List<String> getEX()
    {
        BookMgr Manage = bm.getInstance();
        return Manage.getExNames();
    }

    @Override
    public EX buyEX(int EXCode)
    {
        BookMgr Manage = bm.getInstance();
        return Manage.buyEX(EXCode);
    }

    @Override
    public int checkout()
    {
        BookMgr Manage = bm.getInstance();
        return Manage.checkout();
    }

}
