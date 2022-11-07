import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner Scan = new Scanner(System.in);

        User user = new User(Scan.next());

        user.Operate();
    }
}