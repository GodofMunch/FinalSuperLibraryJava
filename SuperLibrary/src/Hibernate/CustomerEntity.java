package Hibernate;

import org.hibernate.*;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER", schema = "SUPERLIBRARY", catalog = "")

@NamedQuery(name = "getPassword", query = "select custpassword from CustomerEntity where email = :email")
@NamedQuery(name = "getCustomerByEmail", query = "Select id from CustomerEntity where email = :email")
@NamedQuery(name = "deleteAccount", query = "Delete from CustomerEntity where customerid = :id")

@NamedStoredProcedureQuery(name = "getUserId", procedureName = "GET_USER_ID", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, type = CustomerEntity.class, name = "email"),
        @StoredProcedureParameter(mode = ParameterMode.IN, type = CustomerEntity.class, name = "password"),
        @StoredProcedureParameter(mode = ParameterMode.OUT, type = CustomerEntity.class, name = "customerid")
}
)

public class CustomerEntity {
    private long customerid;
    private String forename;
    private String surname;
    private String street;
    private String town;
    private String county;
    private String country;
    private String postcode;
    private String email;
    private Long moneyowed;
    private String custpassword;
    private Long favauthor;
    private Byte favgenre;
    private Long wishbook;
    private byte[] avatar;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_SEQ")
    @SequenceGenerator(name = "CUSTOMER_SEQ", sequenceName = "CUSTOMER_SEQ", allocationSize = 1)
    @Column(name = "CUSTOMERID")
    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "FORENAME")
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Basic
    @Column(name = "SURNAME")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "STREET")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "TOWN")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Basic
    @Column(name = "COUNTY")
    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    @Basic
    @Column(name = "COUNTRY")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "POSTCODE")
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "MONEYOWED")
    public Long getMoneyowed() {
        return moneyowed;
    }

    public void setMoneyowed(Long moneyowed) {
        this.moneyowed = moneyowed;
    }

    @Basic
    @Column(name = "CUSTPASSWORD")
    public String getCustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword;
    }

    @Basic
    @Column(name = "FAVAUTHOR")
    public Long getFavauthor() {
        return favauthor;
    }

    public void setFavauthor(Long favauthor) {
        this.favauthor = favauthor;
    }

    @Basic
    @Column(name = "FAVGENRE")
    public Byte getFavgenre() {
        return favgenre;
    }

    public void setFavgenre(Byte favgenre) {
        this.favgenre = favgenre;
    }

    @Basic
    @Column(name = "WISHBOOK")
    public Long getWishbook() {
        return wishbook;
    }

    public void setWishbook(Long wishbook) {
        this.wishbook = wishbook;
    }

    @Basic
    @Column(name = "AVATAR")
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getPasswordDB(String email, Session session) {

        Query myQuery = session.createNamedQuery("getPassword");
        myQuery.setParameter("email", email);
        List myResults = myQuery.list();
        if (myResults.size() == 1)
            return myQuery.getSingleResult().toString();
        else
            return null;
    }

    public void deleteAccount(Session s){
        s.createNamedQuery("deleteAccount");
        Transaction t = s.getTransaction();
        s.remove(this);
        t.commit();
    }

    public CustomerEntity login(Session session,String email, String password){


       /* int i = 0;
        StoredProcedureQuery mySP = session.createStoredProcedureCall("getUserId", email, password);
        System.out.println(mySP.getSingleResult());
        //return mySP.getOutputParameterValue(i);*/

        Query myQuery = session.createNamedQuery("getCustomerByEmail");
        myQuery.setParameter("email", email);
        List myResults = myQuery.list();
        if(myResults.size() == 1)
            return session.get(CustomerEntity.class, (long) myQuery.getSingleResult());

        else
            return new CustomerEntity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return customerid == that.customerid &&
                Objects.equals(forename, that.forename) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(street, that.street) &&
                Objects.equals(town, that.town) &&
                Objects.equals(county, that.county) &&
                Objects.equals(country, that.country) &&
                Objects.equals(postcode, that.postcode) &&
                Objects.equals(email, that.email) &&
                Objects.equals(moneyowed, that.moneyowed) &&
                Objects.equals(custpassword, that.custpassword) &&
                Objects.equals(favauthor, that.favauthor) &&
                Objects.equals(favgenre, that.favgenre) &&
                Objects.equals(wishbook, that.wishbook) &&
                Arrays.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(customerid, forename, surname, street, town, county, country, postcode, email, moneyowed, custpassword, favauthor, favgenre, wishbook);
        result = 31 * result + Arrays.hashCode(avatar);
        return result;
    }
}
