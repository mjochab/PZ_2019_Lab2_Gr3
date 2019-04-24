/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "choroby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Choroby.findAll", query = "SELECT c FROM Choroby c"),
    @NamedQuery(name = "Choroby.findByChorobaId", query = "SELECT c FROM Choroby c WHERE c.chorobaId = :chorobaId"),
    @NamedQuery(name = "Choroby.findByNazwa", query = "SELECT c FROM Choroby c WHERE c.nazwa = :nazwa")})
public class Choroby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "choroba_id")
    private Integer chorobaId;
    @Basic(optional = false)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @Lob
    @Column(name = "opis")
    private String opis;
    @OneToMany(mappedBy = "chorobaId")
    private Collection<Wizyty> wizytyCollection;

    public Choroby() {
    }

    public Choroby(Integer chorobaId) {
        this.chorobaId = chorobaId;
    }

    public Choroby(Integer chorobaId, String nazwa, String opis) {
        this.chorobaId = chorobaId;
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public Integer getChorobaId() {
        return chorobaId;
    }

    public void setChorobaId(Integer chorobaId) {
        this.chorobaId = chorobaId;
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

    @XmlTransient
    public Collection<Wizyty> getWizytyCollection() {
        return wizytyCollection;
    }

    public void setWizytyCollection(Collection<Wizyty> wizytyCollection) {
        this.wizytyCollection = wizytyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chorobaId != null ? chorobaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Choroby)) {
            return false;
        }
        Choroby other = (Choroby) object;
        if ((this.chorobaId == null && other.chorobaId != null) || (this.chorobaId != null && !this.chorobaId.equals(other.chorobaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Choroby[ chorobaId=" + chorobaId + " ]";
    }
    
}
