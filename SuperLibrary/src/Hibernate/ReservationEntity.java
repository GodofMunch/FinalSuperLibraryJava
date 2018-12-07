package Hibernate;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "RESERVATION", schema = "SUPERLIBRARY", catalog = "")
@IdClass(ReservationEntityPK.class)
public class ReservationEntity {
    private byte roomid;
    private long reservationid;
    private Time startofrental;
    private Time endofrental;
    private Long customerid;

    @Id
    @Column(name = "ROOMID")
    public byte getRoomid() {
        return roomid;
    }

    public void setRoomid(byte roomid) {
        this.roomid = roomid;
    }

    @Id
    @Column(name = "RESERVATIONID")
    public long getReservationid() {
        return reservationid;
    }

    public void setReservationid(long reservationid) {
        this.reservationid = reservationid;
    }

    @Basic
    @Column(name = "STARTOFRENTAL")
    public Time getStartofrental() {
        return startofrental;
    }

    public void setStartofrental(Time startofrental) {
        this.startofrental = startofrental;
    }

    @Basic
    @Column(name = "ENDOFRENTAL")
    public Time getEndofrental() {
        return endofrental;
    }

    public void setEndofrental(Time endofrental) {
        this.endofrental = endofrental;
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
        ReservationEntity that = (ReservationEntity) o;
        return roomid == that.roomid &&
                reservationid == that.reservationid &&
                Objects.equals(startofrental, that.startofrental) &&
                Objects.equals(endofrental, that.endofrental) &&
                Objects.equals(customerid, that.customerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomid, reservationid, startofrental, endofrental, customerid);
    }
}
