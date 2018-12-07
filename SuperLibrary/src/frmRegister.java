import Hibernate.AuthorEntity;
import Hibernate.CustomerEntity;
import Hibernate.GenreEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class frmRegister extends JFrame implements ActionListener {

    private Session session;

    private Container myPane = new Container();
    private Container myPane2 = new Container();
    private JLabel lblForename = new JLabel("Forename: ");
    private JLabel lblSurname = new JLabel("Surname: ");
    private JLabel lblStreet = new JLabel("Street :");
    private JLabel lblTown = new JLabel("Town: ");
    private JLabel lblCounty = new JLabel("County: ");
    private JLabel lblCountry = new JLabel("Country: ");
    private JLabel lblEmail = new JLabel("Email: ");
    private JLabel lblPassword = new JLabel("Password: ");
    private JLabel lblPostcode = new JLabel("Postcode: ");
    private JLabel lblFavAuthor = new JLabel("Favourite Author: ");
    private JLabel lblFavGenre =  new JLabel("Favourite Genre: ");
    private JTextField txtForename = new JTextField();
    private JTextField txtSurname =  new JTextField();
    private JTextField txtStreet = new JTextField();
    private JTextField txtTown = new JTextField();
    private JTextField txtCounty = new JTextField();
    private JTextField txtCountry = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JPasswordField pswdPassword = new JPasswordField();
    private JTextField txtPostcode = new JTextField();
    private JComboBox cboFavAuthor = new JComboBox();
    private JComboBox cboFavGenre = new JComboBox();
    private Dimension textFieldSize = new Dimension(145,20);
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JButton register = new JButton("Register");

    public frmRegister(Session session){
        this.session = session;
        add(myPane);
        add(myPane2);
        setTitle("Register");
        setVisible(true);
        setLayout(new GridLayout());

        setLocation(screenSize.width/3, screenSize.height/4);
        setSize(new Dimension(400,400));
        myPane.setLayout(new FlowLayout());
        myPane2.setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        myPane.add(lblForename);
        lblForename.setPreferredSize(textFieldSize);
        txtForename.setPreferredSize(textFieldSize);
        myPane2.add(txtForename);
        lblSurname.setPreferredSize(textFieldSize);
        myPane.add(lblSurname);
        txtSurname.setPreferredSize(textFieldSize);
        myPane2.add(txtSurname);
        myPane.add(lblStreet);
        lblStreet.setPreferredSize(textFieldSize);
        txtStreet.setPreferredSize(textFieldSize);
        myPane2.add(txtStreet);
        myPane.add(lblTown);
        lblTown.setPreferredSize(textFieldSize);
        txtTown.setPreferredSize(textFieldSize);
        myPane2.add(txtTown);
        myPane.add(lblCounty);
        lblCounty.setPreferredSize(textFieldSize);
        txtCounty.setPreferredSize(textFieldSize);
        myPane2.add(txtCounty);
        myPane.add(lblCountry);
        lblCountry.setPreferredSize(textFieldSize);
        txtCountry.setPreferredSize(textFieldSize);
        myPane2.add(txtCountry);
        myPane.add(lblEmail);
        lblEmail.setPreferredSize(textFieldSize);
        txtEmail.setPreferredSize(textFieldSize);
        myPane2.add(txtEmail);
        myPane.add(lblPassword);
        lblPassword.setPreferredSize(textFieldSize);
        pswdPassword.setPreferredSize(textFieldSize);
        myPane2.add(pswdPassword);
        myPane.add(lblPostcode);
        lblPostcode.setPreferredSize(textFieldSize);
        txtPostcode.setPreferredSize(textFieldSize);
        myPane2.add(txtPostcode);
        myPane.add(lblFavAuthor);
        lblFavAuthor.setPreferredSize(textFieldSize);
        AuthorEntity favAuthor = new AuthorEntity();
        List authors = favAuthor.getAuthorList(session);
        for(int i = 0; i < authors.size(); i ++)
            cboFavAuthor.addItem(authors.get(i));

        myPane2.add(cboFavAuthor);
        GenreEntity favGenre = new GenreEntity();
        List genres = favGenre.getGenreList(session);
        for(int i = 0; i < genres.size();i++)
            cboFavGenre.addItem(genres.get(i));
        myPane.add(lblFavGenre);
        lblFavGenre.setPreferredSize(textFieldSize);
        myPane2.add(cboFavGenre);
        myPane2.add(register);
        register.addActionListener(this);


    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == register) {
            CustomerEntity newCustomer = new CustomerEntity();
            Transaction myT = session.getTransaction();
            try {
                newCustomer.setForename(txtForename.getText());
                newCustomer.setSurname(txtSurname.getText());
                newCustomer.setStreet(txtStreet.getText());
                newCustomer.setTown(txtTown.getText());
                newCustomer.setCounty(txtCounty.getText());
                newCustomer.setCountry(txtCountry.getText());
                newCustomer.setMoneyowed(0L);
                newCustomer.setPostcode(txtPostcode.getText());
                newCustomer.setEmail(txtEmail.getText());
                newCustomer.setCustpassword(String.valueOf(pswdPassword.getPassword()));
                newCustomer.setFavauthor((long) cboFavAuthor.getSelectedIndex());
                newCustomer.setFavgenre((byte) cboFavGenre.getSelectedIndex());

                session.persist(newCustomer);
                myT.commit();
            } catch (Exception sql) {
                JOptionPane.showMessageDialog(myPane, "Please ensure that your password\nis between 8 and 50 characters\n" +
                        "long and has at least one Uppercase and \none Lowercase letter  ", "Ooops!",JOptionPane.INFORMATION_MESSAGE );
                frmRegister newRegister = new frmRegister(session);
                myT.rollback();
                }finally{
                frmGUI login = new frmGUI(session);
            }
            }
        }
    }
