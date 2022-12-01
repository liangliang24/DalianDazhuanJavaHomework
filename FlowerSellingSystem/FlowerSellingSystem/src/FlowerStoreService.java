import java.sql.SQLException;
import java.util.ArrayList;

public interface FlowerStoreService
{
    public void FlowerSelling() throws SQLException;//改变销售鲜花的值

    public void AddNewFlower();//添加新的花

    public ArrayList<Flower> ViewInventory() throws SQLException;//查看库存

    public ArrayList<Orders> ViewOrders() throws SQLException;//查看订单

    public float Sales() throws SQLException;//查看销售情况

    public boolean Login() throws SQLException;//登录

    public boolean AddFlower() throws SQLException;//入库

    public boolean OutFlower() throws SQLException;//出库
}
