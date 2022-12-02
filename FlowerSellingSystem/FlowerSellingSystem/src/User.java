import java.sql.SQLException;
import java.util.ArrayList;

public class User
{
    public String getLicense()
    {
        return license;
    }

    public void setLicense(String license)
    {
        this.license = license;
    }

    private String license;

    public User(String license)
    {
        this.license = license;
        if (license == "Customer")
        {
            customerService = new CustomerServiceImpl();
        }
        else if (license == "FlowerStore"){
            flowerstoreService = new FlowerStoreServiceImpl();
        }
    }

    public User()
    {

    }

    private CustomerServiceImpl customerService;

    private FlowerStoreServiceImpl flowerstoreService;

    public void FlowerSelling(String Name, int Cost, int Price, int Profit)
    {
        try
        {
            flowerstoreService.FlowerSelling(Name, Cost, Price, Profit);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void AddNewFlower(
            String Name,
            String FlowerType,
            int price,
            int nums,
            int cost,
            int profit
    )
    {
        flowerstoreService.AddNewFlower(Name, FlowerType, price, nums, cost, profit);
    }

    public ArrayList<Flower> ViewInventory()
    {

        try
        {
            return flowerstoreService.ViewInventory();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Orders> ViewOrders()
    {
        try
        {
            return flowerstoreService.ViewOrders();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public float Sale()
    {
        try
        {
            return flowerstoreService.Sales();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean AddFlower(String Name, int Nums)
    {
        try
        {
            return flowerstoreService.AddFlower(Name,Nums);
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public boolean OutFlower(String Name, int nums)
    {
        try
        {
            return flowerstoreService.OutFlower(Name,nums);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Login(String Account, String Password)
    {
        if (license.equals("Customer"))
        {
            try
            {
                return customerService.Login(Account, Password);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else if (license.equals("FlowerStore"))
        {
            try
            {
                return flowerstoreService.Login(Account, Password);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean BuyFlower(String flowername, int nums)
    {
        System.out.println("inm");
        try
        {
            return customerService.BuyFlower(flowername, nums);
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Orders> CheckOrder()
    {
        if (license == "Customer")
        {
            try
            {
                return customerService.CheckOrder();
            } catch (SQLException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        else if (license == "FlowerStore")
        {
            try
            {
                return flowerstoreService.ViewOrders();
            } catch (SQLException e)
            {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public ArrayList<Flower> ViewFlower()
    {
        try
        {
            return customerService.ViewFlower();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
