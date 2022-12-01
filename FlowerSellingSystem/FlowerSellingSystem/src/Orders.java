import java.sql.Date;

public class Orders
{
    public Orders()
    {
    }

    public Orders(String customerName, String customerPhonenumber, int customerConsumption, String flowerName, int FLowerNums, Date datetime)
    {
        CustomerName = customerName;
        CustomerPhonenumber = customerPhonenumber;
        CustomerConsumption = customerConsumption;
        FlowerName = flowerName;
        this.FLowerNums = FLowerNums;
        this.datetime = datetime;
    }

    private String CustomerName;

    private String CustomerPhonenumber;

    private int CustomerConsumption;

    private String FlowerName;

    private int FLowerNums;

    private int id;

    private Date datetime;

    public String getCustomerName()
    {
        return CustomerName;
    }

    public void setCustomerName(String customerName)
    {
        CustomerName = customerName;
    }

    public String getCustomerPhonenumber()
    {
        return CustomerPhonenumber;
    }

    public void setCustomerPhonenumber(String customerPhonenumber)
    {
        CustomerPhonenumber = customerPhonenumber;
    }

    public int getCustomerConsumption()
    {
        return CustomerConsumption;
    }

    public void setCustomerConsumption(int customerConsumption)
    {
        CustomerConsumption = customerConsumption;
    }

    public String getFlowerName()
    {
        return FlowerName;
    }

    public void setFlowerName(String flowerName)
    {
        FlowerName = flowerName;
    }

    public int getFLowerNums()
    {
        return FLowerNums;
    }

    public void setFLowerNums(int FLowerNums)
    {
        this.FLowerNums = FLowerNums;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getDatetime()
    {
        return datetime;
    }

    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
    }
}
