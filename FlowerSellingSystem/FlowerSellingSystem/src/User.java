import java.sql.SQLException;
import java.util.ArrayList;

public class User
{
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

    public void FlowerSelling()
    {
        try
        {
            flowerstoreService.FlowerSelling();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void AddNewFlower()
    {
        flowerstoreService.AddNewFlower();
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

    public boolean AddFlower()
    {
        try
        {
            return flowerstoreService.AddFlower();
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public boolean OutFlower()
    {
        try
        {
            return flowerstoreService.OutFlower();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Login()
    {
        if (license.equals("Customer"))
        {
            try
            {
                return customerService.Login();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else if (license.equals("FlowerStore"))
        {
            try
            {
                return flowerstoreService.Login();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean BuyFlower()
    {
        try
        {
            return customerService.BuyFlower();
        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public Orders CheckOrder()
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

    public Flower ViewFlower()
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
