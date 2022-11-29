public class DAOFactory
{
    
    public static DAOInterface getInstance(Class t)
    {
        if (t == Flower.class)
        {
            return new FlowerDAO();
        }
        else if (t == Customer.class)
        {
            return new CustomerDAO();
        }
        else if (t == FlowerStore.class)
        {
            return new FlowerStoreDAO();
        }
        else if (t == Orders.class)
        {
            return new OrdersDAO();
        }
        return null;
    }
}
