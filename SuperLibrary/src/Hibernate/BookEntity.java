package Hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.*;
import javax.swing.*;
import java.util.*;

@Entity
@Table(name = "BOOK", schema = "SUPERLIBRARY", catalog = "")

@NamedQuery(name = "getBooks", query = "Select picture from BookEntity  where isbn =: isbn")
@NamedQuery(name = "getBookList", query = "select isbn from BookEntity")
@NamedQuery(name = "getTitleList", query = "select title from BookEntity ")
public class BookEntity {
    private long isbn;
    private String title;
    private long authorid;
    private long publisherid;
    private long yearpublished;
    private byte genreid;
    private byte languageid;
    private Long noinstock;
    private Long timesrented;
    private byte[] picture;

    @Id
    @Column(name = "ISBN")
    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "AUTHORID")
    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    @Basic
    @Column(name = "PUBLISHERID")
    public long getPublisherid() {
        return publisherid;
    }

    public void setPublisherid(long publisherid) {
        this.publisherid = publisherid;
    }

    @Basic
    @Column(name = "YEARPUBLISHED")
    public long getYearpublished() {
        return yearpublished;
    }

    public void setYearpublished(long yearpublished) {
        this.yearpublished = yearpublished;
    }

    @Basic
    @Column(name = "GENREID")
    public byte getGenreid() {
        return genreid;
    }

    public void setGenreid(byte genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "LANGUAGEID")
    public byte getLanguageid() {
        return languageid;
    }

    public void setLanguageid(byte languageid) {
        this.languageid = languageid;
    }

    @Basic
    @Column(name = "NOINSTOCK")
    public Long getNoinstock() {
        return noinstock;
    }

    public void setNoinstock(Long noinstock) {
        this.noinstock = noinstock;
    }

    @Basic
    @Column(name = "TIMESRENTED")
    public Long getTimesrented() {
        return timesrented;
    }

    public void setTimesrented(Long timesrented) {
        this.timesrented = timesrented;
    }

    @Basic
    @Column(name = "PICTURE")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public static BookEntity getBook(Session session, long isbn){
        BookEntity book = session.load(BookEntity.class, isbn);
        return book;
    }

    public ImageIcon displayImage(){
        byte[] imageToBeRendered = this.getPicture();
        return new ImageIcon(imageToBeRendered);
    }

    public static List<Long> getIsbnList(Session session){

        Query bookListQuery = session.createNamedQuery("getBookList");
        List<Long> isbnList = bookListQuery.list();

        return isbnList;
    }

    public static List<String> getTitleList(Session session){
        Query bookListQuery = session.createNamedQuery("getTitleList");
        List<String> titleList = bookListQuery.list();

        return titleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return isbn == that.isbn &&
                authorid == that.authorid &&
                publisherid == that.publisherid &&
                yearpublished == that.yearpublished &&
                genreid == that.genreid &&
                languageid == that.languageid &&
                Objects.equals(title, that.title) &&
                Objects.equals(noinstock, that.noinstock) &&
                Objects.equals(timesrented, that.timesrented) &&
                Arrays.equals(picture, that.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(isbn, title, authorid, publisherid, yearpublished, genreid, languageid, noinstock, timesrented);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }
}
