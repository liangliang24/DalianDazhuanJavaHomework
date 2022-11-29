import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService
{


    public CustomerServiceImpl(Customer customer)
    {
        this.customer = customer;
    }

    public CustomerServiceImpl()
    {
    }
    
    private Customer customer;
    @Override
    public ArrayList<Flower> ViewFlower() throws SQLException
    {
        ArrayList<Flower> flowers = new ArrayList<Flower>();
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = flowerDAO.getData();
        while(result.next())
        {
            flowers.add(new Flower(
                    result.getString("name"),
                    result.getString("flowertype"),
                    result.getInt("price"),
                    result.getInt("nums"),
                    result.getInt("cost"),
                    result.getInt("profit")));
        }
        return flowers;
    }

    @Override
    public boolean BuyFlower() throws SQLException
    {
        ArrayList<Flower> flowers = ViewFlower();
        Scanner Scan = new Scanner(System.in);
        String name = Scan.next();
        int n = flowers.size();
        Flower BuyFlower = null;
        for (int i = 0;i < n;i++)
        {
            if(name.equals(flowers.get(i).getName()))
            {
                BuyFlower = flowers.get(i);
                break;
            }
        }
        if (BuyFlower == null)
        {
            System.out.println("未找到该鲜花");
            return false;
        }
        int counts = 0;
        System.out.println("请输入你要购买的数量");

        counts = Scan.nextInt();

        if (BuyFlower.getNums() < counts)
        {
            counts = BuyFlower.getNums();
        }
        BuyFlower.setNums(BuyFlower.getNums()-counts);
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(Flower.class);
        DAOInterface<Orders> ordersDAO = DAOFactory.getInstance(Orders.class);
        flowerDAO.setData(BuyFlower);
        Orders orders = new Orders(
                customer.getName(),
                customer.getPhonenumber(),
                counts*BuyFlower.getPrice(),
                BuyFlower.getName(),
                counts, new Date());
        ordersDAO.setData(orders);
        return true;
    }

    @Override
    public Orders CheckOrder() throws SQLException
    {
        DAOInterface<Orders> ordersDAO = DAOFactory.getInstance(Orders.class);
        ResultSet result = ordersDAO.getData();
        Orders orders = new Orders();
        Scanner Scan = new Scanner(System.in);
        System.out.println("输入你要查询的id");
        orders.setId(Scan.nextInt());
        while(result.next())
        {
            if (orders.getId() == result.getInt("id"))
            {
                orders.setCustomerName(result.getString("customername"));
                orders.setCustomerPhonenumber(result.getString("customerphonenumber"));
                orders.setCustomerConsumption(result.getInt("customerconsumption"));
                orders.setFlowerName(result.getString("flowername"));
                orders.setFLowerNums(result.getInt("flowernums"));
                orders.setDatetime(result.getDate("time"));
                break;
            }
        }
        return orders;
    }

    @Override
    public boolean Login() throws SQLException
    {
        System.out.println("输入账号密码");
        Scanner Scan = new Scanner(System.in);

        String name = Scan.next();

        String password = Scan.next();

        DAOInterface<Customer> customerDAO = DAOFactory.getInstance(Customer.class);

        ResultSet result = customerDAO.getData();

        while(result.next())
        {
            if (name.equals(result.getString("name")))
            {
                if (password.equals(result.getString("password")))
                {
                    System.out.println("登录成功");
                    return true;
                }
                else
                {
                    System.out.println("密码错误");
                    return false;
                }
            }
        }
        System.out.println("账号错误");
        return false;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}
