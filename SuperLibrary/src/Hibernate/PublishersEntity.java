package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PUBLISHERS", schema = "SUPERLIBRARY", catalog = "")
public class PublishersEntity {
    private long publisherid;
    private String name;
    private String address;

    @Id
    @Column(name = "PUBLISHERID")
    public long getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(long publisherid) {
        this.publisherid = publisherid;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishersEntity that = (PublishersEntity) o;
        return publisherid == that.publisherid &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publisherid, name, address);
    }
}
