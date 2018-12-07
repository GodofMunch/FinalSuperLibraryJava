package Hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "GENRE", schema = "SUPERLIBRARY", catalog = "")
@NamedQuery(name = "getGenreNames", query = "Select genre from GenreEntity")
public class GenreEntity {
    private byte genreid;
    private String genre;

    @Id
    @Column(name = "GENREID")
    public byte getGenreid() {
        return genreid;
    }

    public void setGenreid(byte genreid) {
        this.genreid = genreid;
    }

    @Basic
    @Column(name = "GENRE")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<GenreEntity> getGenreList(Session session){

        Query myQuery = session.createNamedQuery("getGenreNames");
        List<GenreEntity> genres;
        genres = myQuery.list();

        return genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreEntity that = (GenreEntity) o;
        return genreid == that.genreid &&
                Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreid, genre);
    }
}
