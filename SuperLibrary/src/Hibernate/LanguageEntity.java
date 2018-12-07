package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LANGUAGE", schema = "SUPERLIBRARY", catalog = "")
public class LanguageEntity {
    private byte languageid;
    private String language;

    @Id
    @Column(name = "LANGUAGEID")
    public byte getLanguageid() {
        return languageid;
    }

    public void setLanguageid(byte languageid) {
        this.languageid = languageid;
    }

    @Basic
    @Column(name = "LANGUAGE")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageEntity that = (LanguageEntity) o;
        return languageid == that.languageid &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageid, language);
    }
}
