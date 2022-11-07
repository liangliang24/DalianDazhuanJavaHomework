public interface IAdmin
{
    void inBook(int BookId, int nums);

    boolean outBook(int BookId, int nums);

    void newBook();

    void FindBook(int BookId);

}
