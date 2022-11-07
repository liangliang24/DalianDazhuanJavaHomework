import java.util.Iterator;
import java.util.List;

public class BookMgr
{
    private List<Book> books;

    public List<Integer> getBuyingBookPrice()
    {
        return buyingBookPrice;
    }

    private List<Integer> buyingBookPrice;

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

    public BookMgr getInstance()
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

        if (temp!=null)
        {
            temp.setStore(-num);
            return true;
        }
        else
        {
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
        Iterator<Book> it = getBooks().iterator();

        while(it.hasNext())
        {
            Book temp = it.next();
            if (bookId == temp.getId())
            {
                return temp;
            }
        }

        System.out.println("Founded Failed");
        return null;
    }

    int BuyBook(int bookId,int num)
    {
        Book temp = getById(bookId);
        buyingBookPrice.add(temp.getPrice()*num);
        return temp.getPrice()*num;
    }

    EX buyEX(int exCode)
    {
        buyingEX = SpawnEX.create(exCode);
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
        Iterator<Integer> it = buyingBookPrice.iterator();

        while(it.hasNext())
        {
            bookPriceNums+=it.next();
        }
        bookPriceNums+= buyingEX.getPrice();
        buyingBookPrice.clear();
        buyingEX = null;
        return bookPriceNums;
    }
}
