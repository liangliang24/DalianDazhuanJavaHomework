import java.util.Scanner;

public class AdminImpl implements IAdmin
{
    BookMgr bm = BookMgr.getInstance();

    @Override
    public void inBook(int BookId, int nums)
    {
        
        bm.inBook(BookId,nums);
    }

    @Override
    public boolean outBook(int BookId, int nums)
    {
        
        return bm.outBook(BookId,nums);
    }

    @Override
    public void newBook()
    {
        Scanner scan = new Scanner(System.in);
        Book CreatedBook = new Book();
        System.out.println("输入书本ID");
        CreatedBook.setId(scan.nextInt());
        System.out.println("输入书本名字");
        CreatedBook.setName(scan.next());
        System.out.println("输入作者名");
        CreatedBook.setAuthor(scan.next());
        System.out.println("输入出版日期");
        CreatedBook.setPub_date(scan.next());
        System.out.println("输入库存数量");
        CreatedBook.setStore(scan.nextInt());
        System.out.println("输入价格");
        CreatedBook.setPrice(scan.nextInt());
        
        bm.newBook(CreatedBook);
    }

    @Override
    public void FindBook(int BookId)
    {
        

        Book CheckTemp = bm.getById(BookId);

        System.out.println("作者"+CheckTemp.getAuthor());

        System.out.println("Id"+CheckTemp.getId());

        System.out.println("书名"+CheckTemp.getName());

        System.out.println("库存数量"+CheckTemp.getStore());

        System.out.println("价格"+CheckTemp.getPrice());

        System.out.println("出版日期"+CheckTemp.getPub_date());
    }
}
