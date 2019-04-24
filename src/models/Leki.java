/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "leki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leki.findAll", query = "SELECT l FROM Leki l"),
    @NamedQuery(name = "Leki.findByLekId", query = "SELECT l FROM Leki l WHERE l.lekId = :lekId"),
    @NamedQuery(name = "Leki.findByNazwa", query = "SELECT l FROM Leki l WHERE l.nazwa = :nazwa"),
    @NamedQuery(name = "Leki.findByDawkowanie", query = "SELECT l FROM Leki l WHERE l.dawkowanie = :dawkowanie")})
public class Leki implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lek_id")
    private Integer lekId;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @Lob
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @Column(name = "dawkowanie")
    private String dawkowanie;
    @JoinColumn(name = "lek_id", referencedColumnName = "lek_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Wizyty wizyty;

    public Leki() {
    }

    public Leki(Integer lekId) {
        this.lekId = lekId;
    }

    public Leki(Integer lekId, String nazwa, String opis, String dawkowanie) {
        this.lekId = lekId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.dawkowanie = dawkowanie;
    }

    public Integer getLekId() {
        return lekId;
    }

    public void setLekId(Integer lekId) {
        this.lekId = lekId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getDawkowanie() {
        return dawkowanie;
    }

    public void setDawkowanie(String dawkowanie) {
        this.dawkowanie = dawkowanie;
    }

    public Wizyty getWizyty() {
        return wizyty;
    }

    public void setWizyty(Wizyty wizyty) {
        this.wizyty = wizyty;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lekId != null ? lekId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leki)) {
            return false;
        }
        Leki other = (Leki) object;
        if ((this.lekId == null && other.lekId != null) || (this.lekId != null && !this.lekId.equals(other.lekId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Leki[ lekId=" + lekId + " ]";
    }
    
}
