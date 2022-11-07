import java.util.Scanner;

public class main
{
    public static void main(String[] args) {
        System.out.println("请选择你要租赁的汽车类型");
        Scanner input = new Scanner(System.in);
        MotoVehicleFactory.RentCar(input.next());
    }
}
