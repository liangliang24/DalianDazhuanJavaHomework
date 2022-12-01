import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService
{


    public CustomerServiceImpl(String account, String password)
    {
        this.account = account;

        this.password = password;
    }

    public CustomerServiceImpl()
    {
    }

    public Customer getCustom() throws SQLException
    {
        DAOInterface<Customer> CusDAO = DAOFactory.getInstance(Customer.class);
        ResultSet result = CusDAO.getData();
        while(result.next())
        {
            if (account.equals(result.getString("name")))
            {
                if(password.equals(result.getString("password")))
                {
                    return new Customer(account,result.getString("phonenumber"),password);
                }
            }
        }
        System.out.println("账号错误");
        return null;

    }
    private String account;
    private String password;
    @Override
    public Flower ViewFlower() throws SQLException
    {
        DAOInterface<Flower> FlowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = FlowerDAO.getData();
        Flower flower = null;
        Scanner Scan = new Scanner(System.in);
        System.out.println("输入要查询的花的名字");
        String name = Scan.next();
        while(result.next())
        {
            if (name.equals(result.getString("name")))
            {
                flower = new Flower(
                        name,
                        result.getString("flowertype"),
                        result.getInt("price"),
                        result.getInt("nums"),
                        result.getInt("cost"),
                        result.getInt("profit"));
            }
        }
        if (flower != null)
        {
            return flower;
        }
        else {
            return null;
        }

    }

    @Override
    public boolean BuyFlower() throws SQLException
    {
        Flower flowers = ViewFlower();
        Scanner Scan = new Scanner(System.in);
        System.out.println("请输入你要购买的数量");

        int counts = Scan.nextInt();

        if (flowers.getNums() < counts)
        {
            counts = flowers.getNums();
        }
        flowers.setNums(flowers.getNums()-counts);
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(Flower.class);
        DAOInterface<Orders> ordersDAO = DAOFactory.getInstance(Orders.class);
        flowerDAO.setData(flowers);
        System.out.println("access!");
        Customer temp = getCustom();
        Orders orders = null;
        if (temp!=null)
        {
            orders = new Orders(
                    temp.getName(),
                    temp.getPhonenumber(),
                    counts * flowers.getPrice(),
                    flowers.getName(),
                    counts,
                    new Date(System.currentTimeMillis()));
        }
        else {
            return false;
        }
        ordersDAO.addData(orders);
        System.out.println("access!");
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

        account = Scan.next();

        password = Scan.next();

        DAOInterface<Customer> customerDAO = DAOFactory.getInstance(Customer.class);

        ResultSet result = customerDAO.getData();

        while(result.next())
        {
            if (account.equals(result.getString("name")))
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
}
