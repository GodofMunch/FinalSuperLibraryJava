package Hibernate;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ReservationEntityPK implements Serializable {
    private byte roomid;
    private long reservationid;

    @Column(name = "ROOMID")
    @Id
    public byte getRoomid() {
        return roomid;
    }

    public void setRoomid(byte roomid) {
        this.roomid = roomid;
    }

    @Column(name = "RESERVATIONID")
    @Id
    public long getReservationid() {
        return reservationid;
    }

    public void setReservationid(long reservationid) {
        this.reservationid = reservationid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntityPK that = (ReservationEntityPK) o;
        return roomid == that.roomid &&
                reservationid == that.reservationid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomid, reservationid);
    }
}
