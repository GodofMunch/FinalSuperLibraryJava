package Hibernate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMERFEES", schema = "SUPERLIBRARY", catalog = "")
public class CustomerfeesEntity {
    private long customerid;
    private Time dateincurred;
    private Time datepaid;
    private long feeno;

    @Basic
    @Column(name = "CUSTOMERID")
    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "DATEINCURRED")
    public Time getDateincurred() {
        return dateincurred;
    }

    public void setDateincurred(Time dateincurred) {
        this.dateincurred = dateincurred;
    }

    @Basic
    @Column(name = "DATEPAID")
    public Time getDatepaid() {
        return datepaid;
    }

    public void setDatepaid(Time datepaid) {
        this.datepaid = datepaid;
    }

    @Id
    @Column(name = "FEENO")
    public long getFeeno() {
        return feeno;
    }

    public void setFeeno(long feeno) {
        this.feeno = feeno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerfeesEntity that = (CustomerfeesEntity) o;
        return customerid == that.customerid &&
                feeno == that.feeno &&
                Objects.equals(dateincurred, that.dateincurred) &&
                Objects.equals(datepaid, that.datepaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerid, dateincurred, datepaid, feeno);
    }
}
