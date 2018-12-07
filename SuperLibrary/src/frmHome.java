import Hibernate.BookEntity;
import Hibernate.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static Hibernate.BookEntity.*;

public class frmHome extends JFrame implements ActionListener {

    private Container myPane = new Container();
    private JLabel welcome =new JLabel();
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JComboBox cboWishBook = new JComboBox();
    private List<Long> bookListIsbn;
    private List<String> bookListTitle;
    private CustomerEntity activeCust;
    private Session session;
    private JButton deleteAccount = new JButton("Delete Account");
    private ImageIcon icon;
    private JLabel imageHolder = new JLabel(icon);
    private BookEntity newBook;


    public frmHome(Session session, CustomerEntity activeCust){
        this.activeCust = activeCust;
        this.session = session;

        setLocation(screenSize.width/3, screenSize.height/6);
        setSize(400,800);
        setContentPane(myPane);
        myPane.setLayout(new FlowLayout());
        welcome.setText("Welcome " + activeCust.getForename() + "Please select your favourite book");
        bookListIsbn = getIsbnList(session);
        bookListTitle = getTitleList(session);
        int bookFinder = 0;
        long bookIsbn = 0;
        String bookName;
        for(int i = 0; i < bookListTitle.size(); i ++) {
            bookIsbn = bookListIsbn.get(i);
            bookName = bookListTitle.get(i);
            cboWishBook.addItem(bookName);
            if(bookName.equals("Harry Potter and the Philosoper's Stone")){
                bookFinder = i;
            }
        }

        myPane.add(welcome);
        myPane.add(cboWishBook);
        cboWishBook.setSelectedIndex(bookFinder);
        cboWishBook.addActionListener(this);

        newBook = session.load(BookEntity.class, 9781781102459L);
        icon = newBook.displayImage();
        JLabel imageHolder = new JLabel(icon);
        imageHolder.setPreferredSize(new Dimension(300,400));

        myPane.add(imageHolder);
        deleteAccount.addActionListener(this);
        myPane.add(deleteAccount);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
        BookEntity newBook;
        Transaction t = session.getTransaction();
        if(e.getSource() == cboWishBook) {
            for (int i = 0; i < cboWishBook.getItemCount(); i++){
                activeCust.setWishbook(bookListIsbn.get(i));
                //System.out.println(cboWishBook.getSelectedItem().toString());
            if (cboWishBook.getSelectedItem().toString().equals(bookListTitle.get(i))){
                activeCust.setWishbook(bookListIsbn.get(i));
                //newBook = session.load(BookEntity.class, bookListIsbn.get(i));
                //newBook.displayImage();
               /* if (newBook.getPicture() != null) {
                   /* System.out.println(4);
                    System.out.println("Trying to draw");
                    icon = newBook.displayImage();
                } else
                    icon = new ImageIcon();*/

            }
            }

        }
        t.commit();
        if(e.getSource() == deleteAccount){
            try {
                System.out.println("Trying to delete account");
                activeCust.deleteAccount(session);
            }catch(Exception per){
                JOptionPane.showMessageDialog(null, "Cannot Delete account at this time!");
            }
        }


    }
}
