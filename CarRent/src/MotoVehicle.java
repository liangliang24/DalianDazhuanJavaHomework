public abstract class MotoVehicle
{
    public MotoVehicle()
    {

    }

    public MotoVehicle(String VehicleID, String Brand, int PerRent)
    {
        this.VehicleID = VehicleID;
        this.Brand = Brand;
        this.PerRent = PerRent;
    }

    public String getVehicleID() {
        return VehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.VehicleID = vehicleID;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public int getPerRent() {
        return PerRent;
    }

    public void setPerRent(int PerRent) {
        this.PerRent = PerRent;
    }

    protected String VehicleID;
    protected String Brand;
    protected int PerRent;
    public abstract float CalRent(int day);
}
