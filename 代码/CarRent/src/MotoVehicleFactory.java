import java.util.Scanner;

public class MotoVehicleFactory
{
    public static MotoVehicle RentCar(String s)
    {
        if (s.equals("Car"))
        {
            Car temp = new Car();
            System.out.println("请选择你要租赁的汽车类型:\n1.宝马     2.别克\n");
            Scanner input = new Scanner(System.in);

            if (input.nextInt() == 1)
            {
                temp.Brand = "宝马";
                System.out.println("选择汽车型号:\n1.550i     2.X6\n");
                input = new Scanner(System.in);
                if (input.nextInt() == 1)
                {
                    temp.Type = "550i";
                    temp.VehicleID = "京CNY3284";
                    temp.PerRent = 600;
                }
                else if (input.nextInt() == 2)
                {
                    temp.Type = "X6";temp.VehicleID = "京NY28588";temp.PerRent = 800;
                }
            }
            else if (input.nextInt() == 2)
            {

                temp.Brand = "别克";
                System.out.println("选择汽车型号:\n1.550i     2.X6\n");
                input = new Scanner(System.in);
                if (input.nextInt() == 1)
                {
                    temp.Type = "林荫大道";temp.VehicleID = "京NT37465";temp.PerRent = 300;
                }
                else if (input.nextInt() == 2)
                {
                    temp.Type = "GL8";temp.VehicleID = "京NT96968";temp.PerRent = 600;
                }
            }
            System.out.println("请输入租赁天数:");
            int t= input.nextInt();
            System.out.println("分配给您的汽车牌号是:"+temp.getVehicleID());
            System.out.println("您需要支付的租赁费用是:"+temp.CalRent(t));
            return temp;
        }
        else if (s.equals("Bus"))
        {
            System.out.println("请选择你要租赁的汽车类型:\n1.金杯     2.金龙\n");
            Scanner input = new Scanner(System.in);
            Bus temp = new Bus();
            if (input.nextInt() == 1)
            {
                temp.Brand = "金杯";
            }
            else if (input.nextInt() == 2)
            {

                temp.Brand = "金龙";
            }
            System.out.println("请输入客车座位数:");
            input = new Scanner(System.in);
            temp.SeatCount = input.nextInt();
            if (temp.SeatCount<=16)
            {
                temp.PerRent = 800;
                if (temp.Brand.equals("金杯"))
                {
                    temp.VehicleID = "京6566754";
                }
                else
                {
                    temp.VehicleID = "京9696996";
                }
            }
            else
            {
                temp.PerRent = 1500;
                if (temp.Brand.equals("金杯"))
                {
                    temp.VehicleID = "京8696997";
                }
                else
                {
                    temp.VehicleID = "京8696998";
                }
            }
            System.out.println("请输入租赁天数:");
            int t= input.nextInt();
            System.out.println("分配给您的汽车牌号是:"+temp.getVehicleID());
            System.out.println("您需要支付的租赁费用是:"+temp.CalRent(t));
            return new Bus();
        }
        return null;
    }
}

