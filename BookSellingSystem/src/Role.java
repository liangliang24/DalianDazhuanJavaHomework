import java.util.Scanner;

public class Role
{
    private CustomerImpl Customer = new CustomerImpl();
    private AdminImpl Admin = new AdminImpl();

    protected String role;

    Role()
    {

    }

    void Inbook(int BookId, int nums)
    {
        if (role.equals("Admin"))
        {
            getAdmin().inBook(BookId,nums);
        }
        else {
            System.out.println("Admin Only");
        }
    }

    boolean Outbook(int BookId, int nums)
    {
        if (role.equals("Admin"))
        {
            return getAdmin().outBook(BookId,nums);
        }
        else {
            System.out.println("Admin Only");
            return false;
        }
    }

    void AddBook()
    {
        if (role.equals("Admin"))
        {
            getAdmin().newBook();
        }
        else {
            System.out.println("Admin Only");
        }
    }

    void CheckBook(int BookId)
    {
        if (role.equals("Admin"))
        {
            getAdmin().FindBook(BookId);
        }
        else {
            getCustomer().checkBook(BookId);
        }
    }

    int BuyBook(int BookId,int nums)
    {
        if (role.equals("Admin"))
        {
            System.out.println("Customer Only");
            return -1;
        }
        else
        {
            return getCustomer().BuyBook(BookId,nums);
        }
    }



    int BuyEx(int EXCode)
    {
        if (role.equals("Admin"))
        {
            System.out.println("Customer Only");
            return -1;
        }
        else
        {
            if (getCustomer().buyEX(EXCode)!=null)
            {
                return getCustomer().buyEX(EXCode).getPrice();
            }
            return 0;
        }
    }

    int CheckOut()
    {
        if (role.equals("Admin"))
        {
            System.out.println("Customer Only");
            return -1;
        }
        else
        {
            return getCustomer().checkout();
        }
    }

    public CustomerImpl getCustomer()
    {
        return Customer;
    }

    public void setCustomer(CustomerImpl customer)
    {
        Customer = customer;
    }

    public AdminImpl getAdmin()
    {
        return Admin;
    }

    public void setAdmin(AdminImpl admin)
    {
        Admin = admin;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
