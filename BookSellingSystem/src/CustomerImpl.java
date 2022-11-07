import java.util.Iterator;
import java.util.List;

public class CustomerImpl implements ICustomer
{
    private BookMgr bm = BookMgr.getInstance();

    @Override
    public void checkBook(int BookId)
    {
        

        Book CheckTemp = bm.getById(BookId);

        if (CheckTemp!=null)
        {
            System.out.println("作者"+CheckTemp.getAuthor());

            System.out.println("Id"+CheckTemp.getId());

            System.out.println("书名"+CheckTemp.getName());

            System.out.println("库存数量"+CheckTemp.getStore());

            System.out.println("价格"+CheckTemp.getPrice());

            System.out.println("出版日期"+CheckTemp.getPub_date());
        }

    }

    @Override
    public int BuyBook(int BookId,int nums)
    {
        
        return bm.BuyBook(BookId,nums);
    }

    @Override
    public List<String> getEX()
    {
        
        return bm.getExNames();
    }

    @Override
    public EX buyEX(int EXCode)
    {
        List<String> AllEx= bm.getExNames();
        Iterator<String> it = AllEx.iterator();
        int index = 1;
        while(it.hasNext())
        {
            System.out.println(index+"."+it.next());
        }
        return bm.buyEX(EXCode);
    }

    @Override
    public int checkout()
    {
        
        return bm.checkout();
    }

}
