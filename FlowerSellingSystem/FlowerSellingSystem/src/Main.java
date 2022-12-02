import java.sql.SQLException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {

        FlowerStoreTable frame = new FlowerStoreTable(new User("FlowerStore"));
        frame.setVisible(true);
    }

}