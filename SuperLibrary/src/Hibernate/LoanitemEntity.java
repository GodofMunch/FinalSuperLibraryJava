package Hibernate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "LOANITEM", schema = "SUPERLIBRARY", catalog = "")
public class LoanitemEntity {
    private int orderid;
    private long isbn;
    private Time loandate;
    private Time returndate;

    @Id
    @Column(name = "ORDERID")
    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "ISBN")
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "LOANDATE")
    public Time getLoandate() {
        return loandate;
    }

    public void setLoandate(Time loandate) {
        this.loandate = loandate;
    }

    @Basic
    @Column(name = "RETURNDATE")
    public Time getReturndate() {
        return returndate;
    }

    public void setReturndate(Time returndate) {
        this.returndate = returndate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanitemEntity that = (LoanitemEntity) o;
        return orderid == that.orderid &&
                isbn == that.isbn &&
                Objects.equals(loandate, that.loandate) &&
                Objects.equals(returndate, that.returndate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, isbn, loandate, returndate);
    }
}
