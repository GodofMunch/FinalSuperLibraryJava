package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NOTIFICATION", schema = "SUPERLIBRARY", catalog = "")
public class NotificationEntity {
    private long notificationid;
    private long customerid;
    private String notiftext;
    private String notifsent;

    @Id
    @Column(name = "NOTIFICATIONID")
    public long getNotificationid() {
        return notificationid;
    }

    public void setNotificationid(long notificationid) {
        this.notificationid = notificationid;
    }

    @Basic
    @Column(name = "CUSTOMERID")
    public long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(long customerid) {
        this.customerid = customerid;
    }

    @Basic
    @Column(name = "NOTIFTEXT")
    public String getNotiftext() {
        return notiftext;
    }

    public void setNotiftext(String notiftext) {
        this.notiftext = notiftext;
    }

    @Basic
    @Column(name = "NOTIFSENT")
    public String getNotifsent() {
        return notifsent;
    }

    public void setNotifsent(String notifsent) {
        this.notifsent = notifsent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationEntity that = (NotificationEntity) o;
        return notificationid == that.notificationid &&
                customerid == that.customerid &&
                Objects.equals(notiftext, that.notiftext) &&
                Objects.equals(notifsent, that.notifsent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationid, customerid, notiftext, notifsent);
    }
}
