/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "wizyty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wizyty.findAll", query = "SELECT w FROM Wizyty w"),
    @NamedQuery(name = "Wizyty.findByWizytaId", query = "SELECT w FROM Wizyty w WHERE w.wizytaId = :wizytaId"),
    @NamedQuery(name = "Wizyty.findByLekarzId", query = "SELECT w FROM Wizyty w WHERE w.lekarzId = :lekarzId"),
    @NamedQuery(name = "Wizyty.findByReceptaId", query = "SELECT w FROM Wizyty w WHERE w.receptaId = :receptaId"),
    @NamedQuery(name = "Wizyty.findByLekId", query = "SELECT w FROM Wizyty w WHERE w.lekId = :lekId"),
    @NamedQuery(name = "Wizyty.findByData", query = "SELECT w FROM Wizyty w WHERE w.data = :data")})
public class Wizyty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wizyta_id")
    private Integer wizytaId;
    @Basic(optional = false)
    @Column(name = "lekarz_id")
    private int lekarzId;
    @Basic(optional = false)
    @Column(name = "recepta_id")
    private int receptaId;
    @Column(name = "lek_id")
    private Integer lekId;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "wizyty")
    private Lekarze lekarze;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "wizyty")
    private Leki leki;
    @JoinColumn(name = "pacjent_id", referencedColumnName = "pacjent_id")
    @ManyToOne(optional = false)
    private Pacjenci pacjentId;
    @JoinColumn(name = "recepcjonista_id", referencedColumnName = "recepcjonista_id")
    @ManyToOne(optional = false)
    private Recepcjonisci recepcjonistaId;
    @JoinColumn(name = "choroba_id", referencedColumnName = "choroba_id")
    @ManyToOne
    private Choroby chorobaId;

    public Wizyty() {
    }

    public Wizyty(Integer wizytaId) {
        this.wizytaId = wizytaId;
    }

    public Wizyty(Integer wizytaId, int lekarzId, int receptaId, Date data) {
        this.wizytaId = wizytaId;
        this.lekarzId = lekarzId;
        this.receptaId = receptaId;
        this.data = data;
    }

    public Integer getWizytaId() {
        return wizytaId;
    }

    public void setWizytaId(Integer wizytaId) {
        this.wizytaId = wizytaId;
    }

    public int getLekarzId() {
        return lekarzId;
    }

    public void setLekarzId(int lekarzId) {
        this.lekarzId = lekarzId;
    }

    public int getReceptaId() {
        return receptaId;
    }

    public void setReceptaId(int receptaId) {
        this.receptaId = receptaId;
    }

    public Integer getLekId() {
        return lekId;
    }

    public void setLekId(Integer lekId) {
        this.lekId = lekId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Lekarze getLekarze() {
        return lekarze;
    }

    public void setLekarze(Lekarze lekarze) {
        this.lekarze = lekarze;
    }

    public Leki getLeki() {
        return leki;
    }

    public void setLeki(Leki leki) {
        this.leki = leki;
    }

    public Pacjenci getPacjentId() {
        return pacjentId;
    }

    public void setPacjentId(Pacjenci pacjentId) {
        this.pacjentId = pacjentId;
    }

    public Recepcjonisci getRecepcjonistaId() {
        return recepcjonistaId;
    }

    public void setRecepcjonistaId(Recepcjonisci recepcjonistaId) {
        this.recepcjonistaId = recepcjonistaId;
    }

    public Choroby getChorobaId() {
        return chorobaId;
    }

    public void setChorobaId(Choroby chorobaId) {
        this.chorobaId = chorobaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wizytaId != null ? wizytaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wizyty)) {
            return false;
        }
        Wizyty other = (Wizyty) object;
        if ((this.wizytaId == null && other.wizytaId != null) || (this.wizytaId != null && !this.wizytaId.equals(other.wizytaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Wizyty[ wizytaId=" + wizytaId + " ]";
    }
    
}
