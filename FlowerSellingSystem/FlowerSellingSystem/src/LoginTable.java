import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.concurrent.Delayed;

public class LoginTable extends JFrame implements ActionListener
{

    private JPanel ChoicePanel;

    private JPanel AccountPanel;

    private JPanel PasswordPanel;


    private JComboBox<String> majorBox;

    private User u;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton LoginButton;

    public LoginTable()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,300,150);
        setLayout(new BorderLayout());
        init();


    }


    private void init()
    {
        ChoicePanel = new JPanel();
        ChoicePanel.setLayout(new FlowLayout());
        AccountPanel = new JPanel();
        AccountPanel.setLayout(new FlowLayout());
        PasswordPanel = new JPanel();
        PasswordPanel.setLayout(new FlowLayout());

        JLabel licenseLabel = new JLabel("身份:");
        majorBox = new JComboBox<String>();
        majorBox.addItem("请选择");
        majorBox.addItem("Customer");
        majorBox.addItem("FlowerStore");
        JLabel accountLabel = new JLabel("账号:");
        JLabel passwordLabel = new JLabel("密码：");
        accountField = new JTextField();
        accountField.setEditable(true);
        accountField.setColumns(20);
        passwordField = new JPasswordField();
        passwordField.setEditable(true);
        passwordField.setColumns(20);
        passwordField.setEchoChar('*');

        LoginButton = new JButton("登录");
        LoginButton.addActionListener(this);


        ChoicePanel.add(licenseLabel);
        ChoicePanel.add(majorBox);
        ChoicePanel.add(LoginButton);
        AccountPanel.add(accountLabel);
        AccountPanel.add(accountField);
        PasswordPanel.add(passwordLabel);
        PasswordPanel.add(passwordField);
        this.add(ChoicePanel,BorderLayout.SOUTH);
        this.add(AccountPanel,BorderLayout.NORTH);
        this.add(PasswordPanel,BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == LoginButton)
        {
            u = new User((String)(majorBox.getSelectedItem()));
            u.Login(accountField.getText(),passwordField.getText());
            this.setVisible(false);
        }
    }
}
