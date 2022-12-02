import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class CustomerTable  extends JFrame implements ActionListener
{
    private static Vector<String> vFlowerNames = new Vector<String>();

    private static Vector<String> vOrderNames = new Vector<String>();

    static
    {
        vFlowerNames.add("花名");
        vFlowerNames.add("品种");
        vFlowerNames.add("价格");
        vFlowerNames.add("库存");
        vOrderNames.add("消费者姓名");
        vOrderNames.add("消费者电话");
        vOrderNames.add("消费总额");
        vOrderNames.add("花名");
        vOrderNames.add("数量");
        vOrderNames.add("时间");
    }
    private User u;

    private JButton CheckFlowers;

    private JButton CheckOrders;



    private JTable CheckResult;



    private JTable table;

    Vector vFlowerdata = new Vector();

    Vector vorderdata = new Vector();

    DefaultTableModel dt = new DefaultTableModel();
    private JPanel Panel;

    private JButton BuyFlower;

    private JTextField FlowerNameToBuy;
    private JTextField FlowerNumsToBuy;
    public CustomerTable(User u)
    {
        this.u = u;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLayout(new BorderLayout());
        init();

    }

    private void init()
    {
        Panel = new JPanel();

        CheckFlowers = new JButton("查询鲜花");
        CheckFlowers.addActionListener(this);
        CheckFlowers.setBounds(100,20,150,30);
        CheckOrders = new JButton("查询订单");
        CheckOrders.addActionListener(this);
        CheckOrders.setBounds(100,50,150,30);
        Panel.add(CheckFlowers);
        Panel.add(CheckOrders);

        JLabel flowername = new JLabel("鲜花名字:");
        JLabel flowernums = new JLabel("鲜花数量:");
        FlowerNameToBuy = new JTextField();
        FlowerNameToBuy.setColumns(20);
        FlowerNameToBuy.setEditable(true);
        FlowerNumsToBuy = new JTextField();
        FlowerNumsToBuy.setColumns(20);
        FlowerNumsToBuy.setEditable(true);


        DefaultTableCellRenderer dc = new DefaultTableCellRenderer();
        dc.setHorizontalAlignment(JLabel.CENTER);
        table = new JTable();
        table.setDefaultRenderer(Objects.class,dc);
//        dt = new DefaultTableModel(vFlowerdata,vFlowerNames);
        table.setModel(dt);
        table.setBounds(100,100,400,350);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(100,100,400,350);
        Panel.add(tableScrollPane);
        BuyFlower = new JButton("购买鲜花");
        BuyFlower.addActionListener(this);
        Panel.add(flowername);
        Panel.add(FlowerNameToBuy);
        Panel.add(flowernums);
        Panel.add(FlowerNumsToBuy);
        Panel.add(BuyFlower);
        this.add(Panel);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == CheckFlowers)
        {
            vFlowerdata.clear();

            ArrayList<Flower> flower = u.ViewFlower();    
            if (!flower.isEmpty())
            {
                int n = flower.size();
                for (int i = 0; i < n; i++)
                {
                    Vector v = new Vector();
                    v.add(flower.get(i).getName());
                    v.add(flower.get(i).getFlowertype());
                    v.add(flower.get(i).getPrice());
                    v.add(flower.get(i).getNums());
                    vFlowerdata.add(v);
                }
                dt = new DefaultTableModel(vFlowerdata,vFlowerNames);
                table.setModel(dt);
            }
        }
        else if (e.getSource() == CheckOrders)
        {
            vorderdata.clear();
            ArrayList<Orders> orders = u.CheckOrder();
            if (orders!=null&&(!orders.isEmpty()))
            {
                int n = orders.size();
                for (int i = 0; i < n; i++)
                {
                    Vector v = new Vector();
                    v.add(orders.get(i).getCustomerName());
                    v.add(orders.get(i).getCustomerPhonenumber());
                    v.add(orders.get(i).getCustomerConsumption());
                    v.add(orders.get(i).getFlowerName());
                    v.add(orders.get(i).getFLowerNums());
                    v.add(String.valueOf(orders.get(i).getDatetime()));
                    vorderdata.add(v);
                }
                dt = new DefaultTableModel(vorderdata,vOrderNames);
                table.setModel(dt);
            }

        }
        else if (e.getSource() == BuyFlower)
        {
            if (!FlowerNameToBuy.getText().isEmpty()&&!FlowerNumsToBuy.getText().isEmpty())
            {
                u.BuyFlower(FlowerNameToBuy.getText(), Integer.valueOf(FlowerNumsToBuy.getText()));
            }

        }
    }
}
