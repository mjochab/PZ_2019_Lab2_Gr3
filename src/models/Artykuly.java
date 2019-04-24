/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "artykuly")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artykuly.findAll", query = "SELECT a FROM Artykuly a"),
    @NamedQuery(name = "Artykuly.findByArtykulId", query = "SELECT a FROM Artykuly a WHERE a.artykulId = :artykulId"),
    @NamedQuery(name = "Artykuly.findByTytul", query = "SELECT a FROM Artykuly a WHERE a.tytul = :tytul"),
    @NamedQuery(name = "Artykuly.findByData", query = "SELECT a FROM Artykuly a WHERE a.data = :data")})
public class Artykuly implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artykul_id")
    private Integer artykulId;
    @Basic(optional = false)
    @Column(name = "tytul")
    private String tytul;
    @Basic(optional = false)
    @Lob
    @Column(name = "tresc")
    private String tresc;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Artykuly() {
    }

    public Artykuly(Integer artykulId) {
        this.artykulId = artykulId;
    }

    public Artykuly(Integer artykulId, String tytul, String tresc, Date data) {
        this.artykulId = artykulId;
        this.tytul = tytul;
        this.tresc = tresc;
        this.data = data;
    }

    public Integer getArtykulId() {
        return artykulId;
    }

    public void setArtykulId(Integer artykulId) {
        this.artykulId = artykulId;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artykulId != null ? artykulId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artykuly)) {
            return false;
        }
        Artykuly other = (Artykuly) object;
        if ((this.artykulId == null && other.artykulId != null) || (this.artykulId != null && !this.artykulId.equals(other.artykulId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Artykuly[ artykulId=" + artykulId + " ]";
    }
    
}
