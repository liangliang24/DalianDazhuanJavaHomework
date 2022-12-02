import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class FlowerStoreTable  extends JFrame implements ActionListener
{
    User u;

    private static Vector<String> vFlowerNames = new Vector<String>();

    private static Vector<String> vOrderNames = new Vector<String>();

    static
    {
        vFlowerNames.add("花名");
        vFlowerNames.add("品种");
        vFlowerNames.add("价格");
        vFlowerNames.add("库存");
        vFlowerNames.add("成本");
        vFlowerNames.add("利润");
        vOrderNames.add("消费者姓名");
        vOrderNames.add("消费者电话");
        vOrderNames.add("消费总额");
        vOrderNames.add("花名");
        vOrderNames.add("数量");
        vOrderNames.add("时间");
    }

    private JButton FlowerSellingButton;

    private JTextField FlowerProfitInput;

    private JButton AddNewTypeFLowerButton;

    private JLabel Name;

    private JTextField NameInput;

    private JLabel Type;

    private JTextField TypeInput;

    private JLabel Price;

    private JTextField PriceInput;

    private JLabel Nums;

    private JTextField NumsInput;

    private JLabel Cost;

    private JTextField CostInput;

    private JLabel Profit;

    private JTextField ProfitInput;

    private JLabel Delta;

    private JTextField DeltaInput;

    private JButton AddFlower;

    private JButton OutFlower;
    private JButton ViewStore;
    private JButton ViewOrders;
    private JPanel panel;

    private Vector vFlowerdata = new Vector();

    private Vector vorderdata = new Vector();

    private JTable table;

    DefaultTableModel dt = new DefaultTableModel();

    public FlowerStoreTable(User u)
    {
        this.u = u;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,800);
        setLayout(new BorderLayout());
        init();
    }


    private void init()
    {
        panel = new JPanel();
        panel.setLayout(null);
        Name = new JLabel("花名:");
        Name.setBounds(10,10,30,30);
        NameInput = new JTextField();
        NameInput.setEditable(true);
        NameInput.setColumns(20);
        NameInput.setBounds(40,15,60,20);
        Type = new JLabel("品种:");
        Type.setBounds(100,10,30,30);
        panel.add(Type);
        TypeInput = new JTextField();
        TypeInput.setEditable(true);
        TypeInput.setColumns(20);
        TypeInput.setBounds(130,15,60,20);
        panel.add(TypeInput);
        Price = new JLabel("价格:");
        Price.setBounds(190,10,30,30);
        panel.add(Price);
        PriceInput = new JTextField();
        PriceInput.setEditable(true);
        PriceInput.setColumns(20);
        PriceInput.setBounds(220,15,30,20);
        panel.add(PriceInput);
        Nums = new JLabel("库存:");
        Nums.setBounds(250,10,30,30);
        panel.add(Nums);
        NumsInput = new JTextField();
        NumsInput.setEditable(true);
        NumsInput.setColumns(20);
        NumsInput.setBounds(280,15,30,20);
        panel.add(NumsInput);
        Cost = new JLabel("成本:");
        Cost.setBounds(310,10,30,30);
        panel.add(Cost);
        CostInput = new JTextField();
        CostInput.setEditable(true);
        CostInput.setColumns(20);
        CostInput.setBounds(340,15,30,20);
        panel.add(CostInput);
        Profit = new JLabel("利润");
        Profit.setBounds(370,10,30,30);
        panel.add(Profit);
        ProfitInput = new JTextField();
        ProfitInput.setEditable(true);
        ProfitInput.setColumns(20);
        ProfitInput.setBounds(400,15,30,20);
        panel.add(ProfitInput);
        Delta = new JLabel("增减:");
        Delta.setBounds(430,10,30,30);
        panel.add(Delta);
        DeltaInput = new JTextField();
        DeltaInput.setEditable(true);
        DeltaInput.setColumns(20);
        DeltaInput.setBounds(460,15,30,20);
        panel.add(DeltaInput);
        FlowerSellingButton = new JButton("销售鲜花");
        FlowerSellingButton.setBounds(10,50,150,30);
        FlowerSellingButton.addActionListener(this);
        AddNewTypeFLowerButton = new JButton("培育新品种");
        AddNewTypeFLowerButton.setBounds(200,50,150,30);
        AddNewTypeFLowerButton.addActionListener(this);
        AddFlower = new JButton("入库");
        AddFlower.setBounds(400,50,150,30);
        AddFlower.addActionListener(this);
        panel.add(AddFlower);
        OutFlower = new JButton("出库");
        OutFlower.setBounds(600,50,150,30);
        OutFlower.addActionListener(this);
        panel.add(OutFlower);
        ViewStore = new JButton("查看库存");
        ViewStore.setBounds(10,100,150,30);
        ViewStore.addActionListener(this);
        panel.add(ViewStore);
        ViewOrders = new JButton("查看订单");
        ViewOrders.setBounds(200,100,150,30);
        ViewOrders.addActionListener(this);
        DefaultTableCellRenderer dc = new DefaultTableCellRenderer();
        dc.setHorizontalAlignment(JLabel.CENTER);
        table = new JTable();
        table.setDefaultRenderer(Objects.class,dc);
//        dt = new DefaultTableModel(vFlowerdata,vFlowerNames);
        table.setModel(dt);
        table.setBounds(100,200,400,350);
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBounds(100,200,800,500);
        panel.add(tableScrollPane);
        panel.add(ViewOrders);
        panel.add(Name);
        panel.add(FlowerSellingButton);
        panel.add(AddNewTypeFLowerButton);
        panel.add(NameInput);
        this.add(panel);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == FlowerSellingButton)
        {
            u.FlowerSelling(
                    NameInput.getText(),
                    Integer.valueOf(CostInput.getText()),
                    Integer.valueOf(PriceInput.getText()),
                    Integer.valueOf(ProfitInput.getText()));
        }
        else if (e.getSource() == AddNewTypeFLowerButton)
        {
            u.AddNewFlower(
                    NameInput.getText(),
                    TypeInput.getText(),
                    Integer.valueOf(PriceInput.getText()),
                    Integer.valueOf(NumsInput.getText()),
                    Integer.valueOf(CostInput.getText()),
                    Integer.valueOf(ProfitInput.getText()));
        }
        else if (e.getSource() == AddFlower)
        {
            u.AddFlower(NameInput.getText(), Integer.valueOf(DeltaInput.getText()));
        }
        else if (e.getSource() == OutFlower)
        {
            u.OutFlower(NameInput.getText(), Integer.valueOf(DeltaInput.getText()));
        }
        else if (e.getSource() == ViewStore)
        {

            ArrayList<Flower> flowers = u.ViewInventory();
            if (flowers!=null&&!flowers.isEmpty())
            {
                vFlowerdata.clear();
                int n = flowers.size();
                for (int i = 0;i < n;i++)
                {
                    Vector v = new Vector();
                    v.add(flowers.get(i).getName());
                    v.add(flowers.get(i).getFlowertype());
                    v.add(flowers.get(i).getPrice());
                    v.add(flowers.get(i).getNums());
                    v.add(flowers.get(i).getCost());
                    v.add(flowers.get(i).getProfit());
                    vFlowerdata.add(v);
                }
                dt = new DefaultTableModel(vFlowerdata,vFlowerNames);

                table.setModel(dt);

            }
        }
        else if (e.getSource() == ViewOrders)
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
    }
}
