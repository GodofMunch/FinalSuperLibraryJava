import Hibernate.CustomerEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frmGUI extends JFrame implements ActionListener {

    private Container myPane;
    private JLabel email = new JLabel("Email : ");
    private JLabel password = new JLabel("Password : ");
    private JTextField emailEntry = new JTextField();
    private JPasswordField passwordEntry = new JPasswordField();
    private JPanel spacer = new JPanel();
    private JPanel spacer2 = new JPanel();
    private JPanel spacer3 = new JPanel();
    private JButton login = new JButton("Login");
    private JButton register = new JButton("Register");
    private Session session;
    private String passwordText;
    private Color background = new Color(122, 100, 233);

    public frmGUI(Session session) {
        this.session = session;

        this.setTitle("SuperLibrary");
        this.setVisible(true);
        myPane = getContentPane();
        this.setLayout(new FlowLayout());
        myPane.add(email);
        spacer3.setPreferredSize(new Dimension(22,20));
        spacer3.setBackground(background);
        myPane.add(spacer3);
        emailEntry.setPreferredSize(new Dimension(200,20));
        myPane.add(emailEntry);
        spacer2.setPreferredSize(new Dimension(120,20));
        spacer.setPreferredSize(new Dimension(120,20));
        myPane.add(spacer2);
        myPane.add(password);
        spacer2.setBackground(background);
        passwordEntry.setPreferredSize(new Dimension(200,20));
        myPane.add(passwordEntry);
        spacer.setBackground(background);
        myPane.add(spacer);
        myPane.add(login);
        myPane.add(register);
        myPane.setBackground(background);
        login.addActionListener(this);
        register.addActionListener(this);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int resX = screenSize.width;
        int resY = screenSize.height;
        setBounds(10,10,resX/3,200);
        setLocation(resX/3,resY/3);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == login){
            frmHome homeScreen;
            if(emailEntry.getText()!=null){
                try{
                    CustomerEntity loginCust = new CustomerEntity();
                    if(loginCust.getPasswordDB(emailEntry.getText(), session) != null)
                        passwordText = loginCust.getPasswordDB(emailEntry.getText(), session);
                    else
                        JOptionPane.showConfirmDialog(null,"No such user found on the system" ,
                                "No Such User", JOptionPane.DEFAULT_OPTION);

                    if(!passwordText.equals(String.valueOf(passwordEntry.getPassword()))){
                        JOptionPane.showConfirmDialog(null,"Sorry, Incorrect Password",
                                "Invalid Password", JOptionPane.DEFAULT_OPTION);
                    }else if(passwordText.equals(String.valueOf(passwordEntry.getPassword()))) {
                        loginCust = loginCust.login(session, emailEntry.getText(), passwordText);
                        homeScreen = new frmHome(session, loginCust);
                        setVisible(false);
                    }

                }catch(HibernateException hib){
                    System.out.println(hib.toString());
                }
            }
        }
        if(e.getSource() == register){
            frmRegister reg = new frmRegister(session);
            setVisible(false);
        }
    }
}
