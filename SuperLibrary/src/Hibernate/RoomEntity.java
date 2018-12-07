package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROOM", schema = "SUPERLIBRARY", catalog = "")
public class RoomEntity {
    private long roomid;
    private long capacity;
    private String type;
    private String availability;
    private long hourlycost;
    private Long memberdiscount;

    @Id
    @Column(name = "ROOMID")
    public long getRoomid() {
        return roomid;
    }

    public void setRoomid(long roomid) {
        this.roomid = roomid;
    }

    @Basic
    @Column(name = "CAPACITY")
    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "AVAILABILITY")
    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Basic
    @Column(name = "HOURLYCOST")
    public long getHourlycost() {
        return hourlycost;
    }

    public void setHourlycost(long hourlycost) {
        this.hourlycost = hourlycost;
    }

    @Basic
    @Column(name = "MEMBERDISCOUNT")
    public Long getMemberdiscount() {
        return memberdiscount;
    }

    public void setMemberdiscount(Long memberdiscount) {
        this.memberdiscount = memberdiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomEntity that = (RoomEntity) o;
        return roomid == that.roomid &&
                capacity == that.capacity &&
                hourlycost == that.hourlycost &&
                Objects.equals(type, that.type) &&
                Objects.equals(availability, that.availability) &&
                Objects.equals(memberdiscount, that.memberdiscount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomid, capacity, type, availability, hourlycost, memberdiscount);
    }
}
