public class DAOFactory
{
    public DAOFactory()
    {
        
    }

    public static DAOInterface getInstance(String instance)
    {
        if (instance == "Flower")
        {
            return new FlowerDAO();
        }
        else if (instance == "Customer")
        {
            return new CustomerDAO();
        }
        else if (instance == "FlowerStore")
        {
            return new FlowerStoreDAO();
        }
        else if (instance == "Orders")
        {
            return new OrdersDAO();
        }
        return null;
    }
}
