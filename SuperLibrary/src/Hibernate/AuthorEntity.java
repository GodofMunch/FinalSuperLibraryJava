package Hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AUTHOR", schema = "SUPERLIBRARY", catalog = "")

@NamedQuery(name = "getAuthorList", query = "SELECT name FROM AuthorEntity ")
public class AuthorEntity {
    private long authorid;
    private String name;
    private String yearbegan;
    private String yearfinished;
    private byte[] picture;

    @Id
    @Column(name = "AUTHORID")
    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
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
    @Column(name = "YEARBEGAN")
    public String getYearbegan() {
        return yearbegan;
    }

    public void setYearbegan(String yearbegan) {
        this.yearbegan = yearbegan;
    }

    @Basic
    @Column(name = "YEARFINISHED")
    public String getYearfinished() {
        return yearfinished;
    }

    public void setYearfinished(String yearfinished) {
        this.yearfinished = yearfinished;
    }

    @Basic
    @Column(name = "PICTURE")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public List<AuthorEntity> getAuthorList(Session session){

        Query myQuery = session.createNamedQuery("getAuthorList");
        List<AuthorEntity> authors;
        authors = myQuery.list();

        return authors;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorEntity that = (AuthorEntity) o;
        return authorid == that.authorid &&
                Objects.equals(name, that.name) &&
                Objects.equals(yearbegan, that.yearbegan) &&
                Objects.equals(yearfinished, that.yearfinished) &&
                Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(authorid, name, yearbegan, yearfinished);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
