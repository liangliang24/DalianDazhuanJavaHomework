import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMgr
{
    private List<Book> books = new ArrayList<Book>();

    public List<Integer> getBuyingBookPrice()
    {
        return buyingBookPrice;
    }

    private List<Integer> buyingBookPrice = new ArrayList<Integer>();

    public EX getBuyingEX()
    {
        return buyingEX;
    }

    private EX buyingEX;
    private final EXFactory SpawnEX = new EXFactory();
    private static BookMgr instance = null;
    private BookMgr()
    {

    }

    public static BookMgr getInstance()
    {
        if (instance == null)
        {
            instance = new BookMgr();
        }
        else {
            System.out.println("Already have create instance");
        }
        return instance;
    }

    void inBook(int bookId,int num)
    {
        Book temp = getById(bookId);

        if (temp!=null)
        {
            temp.setStore(num);
        }
        else {
            System.out.println("In Failed");
        }
    }

    boolean outBook(int bookId,int num)
    {
        Book temp = getById(bookId);

        if (temp!=null && temp.getStore() >= num)
        {
            temp.setStore(-num);
            return true;
        }
        else
        {
            System.out.println("操作失败");
            return false;
        }
    }

    void newBook(Book book)
    {
        getBooks().add(book);
    }

    public List<Book> getAll() {
        return getBooks();
    }

    Book getById(int bookId)
    {
        if (!books.isEmpty())
        {
            Iterator<Book> it = getBooks().iterator();

            while(it.hasNext())
            {
                Book temp = it.next();
                if (bookId == temp.getId())
                {
                    return temp;
                }
            }
        }


        System.out.println("Founded Failed");
        return null;
    }

    int BuyBook(int bookId,int num)
    {
        Book temp = getById(bookId);
        if (temp!=null)
        {
            buyingBookPrice.add(temp.getPrice()*num);
            return temp.getPrice()*num;
        }
        return 0;
    }

    EX buyEX(int exCode)
    {
        if (buyingBookPrice.isEmpty())
        {
            System.out.println("买附赠品先");
        }
        else
        {
            buyingEX = SpawnEX.create(exCode);
        }

        return buyingEX;
    }

    List<String> getExNames()
    {
        return SpawnEX.getAllEX();
    }

    public List<Book> getBooks()
    {
        return books;
    }

    public void setBooks(List<Book> books)
    {
        this.books = books;
    }

    int checkout()
    {
        int bookPriceNums = 0;
        if (!buyingBookPrice.isEmpty())
        {
            Iterator<Integer> it = buyingBookPrice.iterator();

            while(it.hasNext())
            {
                bookPriceNums+=it.next();
            }
            if (buyingEX!=null)
            {
                bookPriceNums += buyingEX.getPrice();
            }

            buyingBookPrice.clear();
            buyingEX = null;
            return bookPriceNums;
        }

        return 0;

    }
}
