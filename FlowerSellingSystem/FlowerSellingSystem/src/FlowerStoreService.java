import java.sql.SQLException;
import java.util.ArrayList;

public interface FlowerStoreService
{
    public void FlowerSelling(String Name, int Cost, int Price, int Profit) throws SQLException;//改变销售鲜花的值

    public void AddNewFlower(String Name, String FlowerType, int price, int nums, int cost, int profit);//添加新的花

    public ArrayList<Flower> ViewInventory() throws SQLException;//查看库存

    public ArrayList<Orders> ViewOrders() throws SQLException;//查看订单

    public float Sales() throws SQLException;//查看销售情况

    public boolean Login(String Account, String Password) throws SQLException;//登录

    public boolean AddFlower(String Name, int nums) throws SQLException;//入库

    public boolean OutFlower(String Name, int nums) throws SQLException;//出库
}
