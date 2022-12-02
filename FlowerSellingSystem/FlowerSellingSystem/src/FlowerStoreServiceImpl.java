import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlowerStoreServiceImpl implements FlowerStoreService
{


    public FlowerStoreServiceImpl()
    {
    }

    public FlowerStoreServiceImpl(String account, String password)
    {
        this.account = account;
        this.password = password;
    }

    private String account;

    private String password;
    @Override
    public void FlowerSelling(String Name, int Cost, int Price, int Profit) throws SQLException
    {
        DAOInterface<Flower> FlowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = FlowerDAO.getData();
        Flower flower = new Flower();
        flower.setName(Name);
        while(result.next())
        {
            if (flower.getName().equals(result.getString("name")))
            {
                flower.setFlowertype(result.getString("flowertype"));
                flower.setPrice(result.getInt("price"));
                flower.setNums(result.getInt("nums"));
                flower.setCost(result.getInt("cost"));
                flower.setProfit(result.getInt("profit"));
                break;
            }
        }

        System.out.println("输入成本、售价和利润");
        flower.setCost(Cost);
        flower.setPrice(Price);
        flower.setProfit(Profit);

        if (FlowerDAO.setData(flower))
        {
            System.out.println("修改成功");
        }
        else
        {
            System.out.println("修改失败");
        }
    }

    @Override
    public void AddNewFlower(String Name, String FlowerType, int price, int nums, int cost, int profit)
    {
        Flower flower;
        flower = new Flower(
                Name,
                FlowerType,
                price,
                nums,
                cost,
                profit);

        DAOInterface<Flower> FlowerDAO = DAOFactory.getInstance(Flower.class);
        if (FlowerDAO.addData(flower))
        {
            System.out.println("添加成功");
        }
        else{
            System.out.println("添加失败");
        }

    }

    @Override
    public ArrayList<Flower> ViewInventory() throws SQLException
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
    public ArrayList<Orders> ViewOrders() throws SQLException
    {
        ArrayList<Orders> orders = new ArrayList<Orders>();
        DAOInterface<Orders> OrdersDAO = DAOFactory.getInstance(Orders.class);
        ResultSet result = OrdersDAO.getData();
        while(result.next())
        {
            orders.add(new Orders(result.getString("customername"),
                                    result.getString("customerphonenumber"),
                                    result.getInt("customerconsumption"),
                                    result.getString("flowername"),
                                    result.getInt("flowernums"),
                                    result.getDate("time")));
        }

        return orders;
    }

    @Override
    public float Sales() throws SQLException
    {
        ArrayList<Orders> orders = ViewOrders();
        if (orders.isEmpty())
        {
            return -1;
        }
        Scanner Scan = new Scanner(System.in);

        System.out.println("输入你要查询的花");
        String name = Scan.next();

        int n = orders.size();

        float sum = 0;//一共卖出多少花
        float thissum = 0;//所查询的花卖出了多少

        for (int i = 0; i < n; i++)
        {
            if (orders.get(i).getFlowerName() == name)
            {
                thissum+=orders.get(i).getFLowerNums();
            }
            sum+=orders.get(i).getFLowerNums();
        }
        return thissum/sum;
    }

    @Override
    public boolean Login(String Account, String Password) throws SQLException
    {
        DAOInterface<FlowerStore> flowerstoreDAO = DAOFactory.getInstance(FlowerStore.class);
        ResultSet result = flowerstoreDAO.getData();
        FlowerStore FS = new FlowerStore(Account,Password);
        while(result.next())
        {
            if (FS.getAcount().equals(result.getString("acount")))
            {

                if (FS.getPassword().equals(result.getString("password")))
                {
                    System.out.println("登录成功");
                    return true;
                }
                else {
                    System.out.println("密码错误");
                    return false;
                }
            }
        }

        System.out.println("账号错误");
        return false;


    }

    @Override
    public boolean AddFlower(String Name, int nums) throws SQLException
    {
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = flowerDAO.getData();
        Flower flower = null;
        while(result.next())
        {
            if (Name.equals(result.getString("name")))
            {
                flower = new Flower(
                        Name,
                        result.getString("flowertype"),
                        result.getInt("price"),
                        result.getInt("nums"),
                        result.getInt("cost"),
                        result.getInt("profit")
                );
                break;
            }
        }
        if (flower == null)
        {
            System.out.println("未找到花");
            return false;
        }
        System.out.println("请输入你要增加的数量");
        flower.setNums(flower.getNums()+nums);
        flowerDAO.setData(flower);
        return true;
    }

    @Override
    public boolean OutFlower(String Name, int nums) throws SQLException
    {
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = flowerDAO.getData();
        Flower flower = null;
        while(result.next())
        {
            if (Name.equals(result.getString("name")))
            {
                flower = new Flower(
                        Name,
                        result.getString("flowertype"),
                        result.getInt("price"),
                        result.getInt("nums"),
                        result.getInt("cost"),
                        result.getInt("profit")
                );
                break;
            }
        }
        if (flower == null)
        {
            System.out.println("未找到花");
            return false;
        }
        System.out.println("请输入你要减少的数量");
        flower.setNums(((flower.getNums()- nums)>0?
            flower.getNums()- nums :0));
        flowerDAO.setData(flower);
        return true;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
