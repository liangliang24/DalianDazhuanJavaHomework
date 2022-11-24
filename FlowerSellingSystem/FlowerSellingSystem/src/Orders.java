public class Orders
{
    private String CustomerName;

    private String CustomerPhonenumber;

    private int CustomerConsumption;

    private String FlowerName;

    private String FLowerNums;

    private int id;

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

    public String getFLowerNums()
    {
        return FLowerNums;
    }

    public void setFLowerNums(String FLowerNums)
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
}
