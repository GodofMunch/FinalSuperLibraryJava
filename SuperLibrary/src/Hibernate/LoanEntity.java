package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LOAN", schema = "SUPERLIBRARY", catalog = "")
public class LoanEntity {
    private Long orderid;
    private Long customerid;

    @Id
    @Column(name = "ORDERID")
    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    @Basic
    @Column(name = "CUSTOMERID")
    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanEntity that = (LoanEntity) o;
        return Objects.equals(orderid, that.orderid) &&
                Objects.equals(customerid, that.customerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, customerid);
    }
}
