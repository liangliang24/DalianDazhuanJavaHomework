public class FlowerStore
{
    public FlowerStore()
    {
    }

    public FlowerStore(String acount, String password)
    {
        Acount = acount;
        Password = password;
    }

    private String Acount;
    private String Password;

    public String getAcount()
    {
        return Acount;
    }

    public void setAcount(String acount)
    {
        Acount = acount;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String password)
    {
        Password = password;
    }
}
