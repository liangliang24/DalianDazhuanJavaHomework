public class Customer
{
    public Customer()
    {
    }

    public Customer(String name, String phonenumber, String password)
    {
        Name = name;
        Phonenumber = phonenumber;
        Password = password;
    }

    private String Name;
    private String Phonenumber;
    private String Password;

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getPhonenumber()
    {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.Phonenumber = phonenumber;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        this.Password = password;
    }
}
