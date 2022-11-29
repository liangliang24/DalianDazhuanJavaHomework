import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlowerStoreServiceImpl implements FlowerStoreService
{
    public FlowerStoreServiceImpl()
    {
    }

    private FlowerStore flowerStore;

    public FlowerStoreServiceImpl(FlowerStore flowerStore)
    {
        this.flowerStore = flowerStore;
    }

    @Override
    public void FlowerSelling() throws SQLException
    {
        Flower flower = ViewInventory();
        DAOInterface<Flower> FlowerDAO = DAOFactory.getInstance(Flower.class);
        ResultSet result = FlowerDAO.getData();
        Scanner Scan = new Scanner(System.in);

        System.out.println("输入成本、售价和利润");
        flower.setCost(Scan.nextInt());
        flower.setPrice(Scan.nextInt());
        flower.setProfit(Scan.nextInt());

        if (FlowerDAO.setData(flower))
        {
            System.out.println("修改成功");
        }
        else {
            System.out.println("修改失败");
        }
    }

    @Override
    public void AddNewFlower()
    {
        Flower flower;
        Customer customer = new Customer();
        Scanner Scan = new Scanner(System.in);
        System.out.println("输入要添加的花的名字、品种、价格、库存、成本、利润");
        flower = new Flower(
                Scan.next(),
                Scan.next(),
                Scan.nextInt(),
                Scan.nextInt(),
                Scan.nextInt(),
                Scan.nextInt());

        DAOInterface<Flower> FlowerDAO = DAOFactory.getInstance(Flower.class);
        if (FlowerDAO.setData(flower))
        {
            System.out.println("添加成功");
        }
        else{
            System.out.println("添加失败");
        }

    }

    @Override
    public Flower ViewInventory() throws SQLException
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
                flower.setFlowertype(result.getString("flowertype"));
                flower.setPrice(result.getInt("price"));
                flower.setNums(result.getInt("nums"));
                flower.setCost(result.getInt("cost"));
                flower.setProfit(result.getInt("profit"));
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
    public boolean Login() throws SQLException
    {
        DAOInterface<FlowerStore> flowerstoreDAO = DAOFactory.getInstance(FlowerStore.class);
        ResultSet result = flowerstoreDAO.getData();
        System.out.println("输入账号和密码");
        Scanner Scan = new Scanner(System.in);
//        System.out.println(acount);
//        System.out.println(password);
        FlowerStore FS = new FlowerStore(Scan.nextLine(),Scan.nextLine());
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
    public boolean AddFlower() throws SQLException
    {
        String name;
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(FlowerStore.class);
        ResultSet result = flowerDAO.getData();
        System.out.println("输入你要入库的花的名字");
        Scanner Scan = new Scanner(System.in);
        name = Scan.next();
        Flower flower = null;
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
        flower.setNums(flower.getNums()+Scan.nextInt());
        flowerDAO.setData(flower);
        return true;
    }

    @Override
    public boolean DeleteData() throws SQLException
    {
        String name;
        DAOInterface<Flower> flowerDAO = DAOFactory.getInstance(FlowerStore.class);
        ResultSet result = flowerDAO.getData();
        System.out.println("输入你要入库的花的名字");
        Scanner Scan = new Scanner(System.in);
        name = Scan.next();
        Flower flower = null;
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
        flower.setNums(((flower.getNums()-Scan.nextInt())>0?
            flower.getNums()-Scan.nextInt():0));
        flowerDAO.setData(flower);
        return true;
    }

    public FlowerStore getFlowerStore()
    {
        return flowerStore;
    }

    public void setFlowerStore(FlowerStore flowerStore)
    {
        this.flowerStore = flowerStore;
    }
}
