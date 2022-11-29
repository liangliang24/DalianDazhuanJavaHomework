public class Flower
{
    public Flower()
    {
    }

    public Flower(String name, String flowertype, int price, int nums, int cost, int profit)
    {
        Name = name;
        Flowertype = flowertype;
        Price = price;
        this.nums = nums;
        this.cost = cost;
        this.profit = profit;
    }

    private String Name;
    private String Flowertype;
    private int Price;

    private int nums;

    private int cost;

    private int profit;

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

    public int getPrice()
    {
        return Price;
    }

    public void setPrice(int price)
    {
        this.Price = price;
    }

    public int getNums()
    {
        return nums;
    }

    public void setNums(int nums)
    {
        this.nums = nums;
    }

    public int getCost()
    {
        return cost;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }

    public int getProfit()
    {
        return profit;
    }

    public void setProfit(int profit)
    {
        this.profit = profit;
    }
}
