import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService
{


    public CustomerServiceImpl(String account, String password)
    {
        this.account = new String(account);
        this.password = new String(password);
    }

    public CustomerServiceImpl()
    {
        account = new String();
        password = new String();
    }

    public Customer getCustom() throws SQLException
    {
        DAOInterface<Customer> CusDAO = DAOFactory.getInstance(Customer.class);
        ResultSet result = CusDAO.getData();
        System.out.println(account);
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
    public ArrayList<Flower> ViewFlower() throws SQLException
    {
        DAOInterface<Flower> FlowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = FlowerDAO.getData();
        ArrayList<Flower> flower = new ArrayList<Flower>();
        Scanner Scan = new Scanner(System.in);
        while(result.next())
        {

            flower.add(new Flower(
                    result.getString("name"),
                    result.getString("flowertype"),
                    result.getInt("price"),
                    result.getInt("nums"),
                    result.getInt("cost"),
                    result.getInt("profit")));

        }

        return flower;


    }

    @Override
    public boolean BuyFlower(String flowername, int nums) throws SQLException
    {
        ArrayList<Flower> flowers = ViewFlower();
        int index = 0;
        int n = flowers.size();
        while(index < n)
        {
            if (flowername.equals(flowers.get(index).getName()))
            {
                break;
            }
            index++;
        }
        if (index == n)
        {
            System.out.println("找不到");
            return false;
        }

        if (flowers.get(index).getNums() < nums)
        {
            nums = flowers.get(index).getNums();
        }
        flowers.get(index).setNums(flowers.get(index).getNums()-nums);
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(Flower.class);
        DAOInterface<Orders> ordersDAO = DAOFactory.getInstance(Orders.class);
        flowerDAO.setData(flowers.get(index));
        System.out.println("access!");
        Customer temp = getCustom();
        Orders orders = null;
        if (temp!=null)
        {
            orders = new Orders(
                    temp.getName(),
                    temp.getPhonenumber(),
                    nums * flowers.get(index).getPrice(),
                    flowers.get(index).getName(),
                    nums,
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
    public ArrayList<Orders> CheckOrder() throws SQLException
    {
        DAOInterface<Orders> ordersDAO = DAOFactory.getInstance(Orders.class);
        ResultSet result = ordersDAO.getData();
        Customer custom = getCustom();
        ArrayList<Orders> orders = new ArrayList<Orders>();
        Scanner Scan = new Scanner(System.in);
        while(result.next())
        {
            if (custom.getPhonenumber().equals(result.getString("customerphonenumber")))
            {
                orders.add(
                        new Orders(
                                result.getString("customername"),
                                result.getString("customerphonenumber"),
                                result.getInt("customerconsumption"),
                                result.getString("flowername"),
                                result.getInt("flowernums"),
                                result.getDate("time")

                        )
                );
            }
        }
        return orders;
    }

    @Override
    public boolean Login(String Account, String Password) throws SQLException
    {


        DAOInterface<Customer> customerDAO = DAOFactory.getInstance(Customer.class);

        ResultSet result = customerDAO.getData();

        while(result.next())
        {
            if (Account.equals(result.getString("name")))
            {
                if (Password.equals(result.getString("password")))
                {
                    System.out.println("登录成功");
                    account = Account;
                    password = Password;
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
