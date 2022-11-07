import java.util.Scanner;

public class User extends Role
{
    User(String Userrole)
    {
        setRole(Userrole);
    }

    void Login()
    {
        System.out.println("Login Success");
    }

    void Operate()
    {
        Scanner Scan = new Scanner(System.in);
        while(true)
        {
            System.out.println("1.增加图书");
            System.out.println("2.减少图书");
            System.out.println("3.添加新图书");
            System.out.println("4.查询图书");
            System.out.println("5.购买图书");
            System.out.println("6.购买附赠品");
            System.out.println("7.结算");
            System.out.println("8.退出");
            int choice = Scan.nextInt();
            if (choice == 1)
            {
                System.out.println("请输入增加的图书ID和数量");
                Inbook(Scan.nextInt(),Scan.nextInt());
            }
            else if (choice == 2)
            {
                System.out.println("请输入减少的图书ID和数量");
                Outbook(Scan.nextInt(),Scan.nextInt());
            }
            else if (choice == 3)
            {
                AddBook();
            }
            else if (choice == 4)
            {
                System.out.println("请输入需要查询的书本的ID");
                CheckBook(Scan.nextInt());
            }
            else if (choice == 5)
            {
                System.out.println("请输入购买书本的ID和数量");
                System.out.println("共花费"+BuyBook(Scan.nextInt(), Scan.nextInt()));
            }
            else if (choice == 6)
            {
                System.out.println("请输入购买的附赠品ID");

                BuyEx(Scan.nextInt());
            }
            else if (choice == 7)
            {
                System.out.println("总价值为"+CheckOut());
            }
            else
            {
                break;
            }
        }
    }
}
