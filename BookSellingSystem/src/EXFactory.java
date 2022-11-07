import java.util.ArrayList;
import java.util.List;

public class EXFactory
{
    List<String> EXList = new ArrayList<String>();
    public EXFactory()
    {
        EXList.add("CD");
        EXList.add("Bag");
        EXList.add("Pen");
    }

    public EX create(int id)
    {
        if (getAllEX().get(id) == "CD")
        {
            return new CD();
        }
        else if (getAllEX().get(id) == "Bag")
        {
            return new Bag();
        }
        else
        {
            return new Pen();
        }
    }

    List<String> getAllEX()
    {
        return EXList;
    }
}
