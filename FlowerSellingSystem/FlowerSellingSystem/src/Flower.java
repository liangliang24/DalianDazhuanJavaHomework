public class Flower
{
    public Flower()
    {
    }

    public Flower(String name, String flowertype, String price, String nums, String cost)
    {
        Name = name;
        Flowertype = flowertype;
        Price = price;
        this.nums = nums;
        this.cost = cost;
    }

    private String Name;
    private String Flowertype;
    private String Price;

    private String nums;

    private String cost;

    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getFlowertype()
    {
        return Flowertype;
    }

    public void setFlowertype(String flowertype)
    {
        this.Flowertype = flowertype;
    }

    public String getPrice()
    {
        return Price;
    }

    public void setPrice(String price)
    {
        this.Price = price;
    }

    public String getNums()
    {
        return nums;
    }

    public void setNums(String nums)
    {
        this.nums = nums;
    }

    public String getCost()
    {
        return cost;
    }

    public void setCost(String cost)
    {
        this.cost = cost;
    }
}
