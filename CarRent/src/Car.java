public class Car extends MotoVehicle
{
    Car()
    {

    }
    Car(String Type,String VehicleID, String Brand, int PerRent)
    {
        this.VehicleID = VehicleID;
        this.Brand = Brand;
        this.PerRent = PerRent;
        this.Type = Type;
    }
    protected String Type;
    @Override
    public float CalRent(int days)
    {
        if (days > 7 && days <= 30)
        {
            return days*PerRent*(float)0.9;
        }
        else if (days > 30&&days<=150)
        {
            return days*PerRent*(float)0.8;
        }
        else if (days>150)
        {
            return days*PerRent*(float)0.7;
        }
        else
        {
            return days*PerRent;
        }
    }
}
