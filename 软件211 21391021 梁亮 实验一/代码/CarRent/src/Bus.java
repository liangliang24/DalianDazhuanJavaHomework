public class Bus extends MotoVehicle {
    public Bus(int SeatCount,String VehicleID, String Brand, int PerRent)
    {
        this.VehicleID = VehicleID;
        this.Brand = Brand;
        this.PerRent = PerRent;
        this.SeatCount = SeatCount;
    }

    protected int SeatCount;

    public Bus()
    {

    }

    @Override
    public float CalRent(int day)
    {
        if (day < 3)
        {
            return day*PerRent;
        }
        else if (day >= 3&&day < 7)
        {
            return day*PerRent*(float)0.9;
        }
        else if (day >= 7&&day < 30)
        {
            return day*PerRent*(float)0.8;
        }
        else if (day >= 30&&day < 150)
        {
            return day*PerRent*(float)0.7;
        }
        else
        {
            return day*PerRent*(float)0.6;
        }
    }
}
