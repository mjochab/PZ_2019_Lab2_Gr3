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
@Table(name = "lekarze")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lekarze.findAll", query = "SELECT l FROM Lekarze l"),
    @NamedQuery(name = "Lekarze.findByLekarzId", query = "SELECT l FROM Lekarze l WHERE l.lekarzId = :lekarzId"),
    @NamedQuery(name = "Lekarze.findByImie", query = "SELECT l FROM Lekarze l WHERE l.imie = :imie"),
    @NamedQuery(name = "Lekarze.findByNazwisko", query = "SELECT l FROM Lekarze l WHERE l.nazwisko = :nazwisko"),
    @NamedQuery(name = "Lekarze.findByEmail", query = "SELECT l FROM Lekarze l WHERE l.email = :email"),
    @NamedQuery(name = "Lekarze.findByNrTel", query = "SELECT l FROM Lekarze l WHERE l.nrTel = :nrTel"),
    @NamedQuery(name = "Lekarze.findByPesel", query = "SELECT l FROM Lekarze l WHERE l.pesel = :pesel"),
    @NamedQuery(name = "Lekarze.findByMiejscowosc", query = "SELECT l FROM Lekarze l WHERE l.miejscowosc = :miejscowosc"),
    @NamedQuery(name = "Lekarze.findByUlica", query = "SELECT l FROM Lekarze l WHERE l.ulica = :ulica"),
    @NamedQuery(name = "Lekarze.findByNrDomu", query = "SELECT l FROM Lekarze l WHERE l.nrDomu = :nrDomu"),
    @NamedQuery(name = "Lekarze.findByNrLokalu", query = "SELECT l FROM Lekarze l WHERE l.nrLokalu = :nrLokalu"),
    @NamedQuery(name = "Lekarze.findByKodPocztowy", query = "SELECT l FROM Lekarze l WHERE l.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Lekarze.findByPoczta", query = "SELECT l FROM Lekarze l WHERE l.poczta = :poczta")})
public class Lekarze implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lekarz_id")
    private Integer lekarzId;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nr_tel")
    private int nrTel;
    @Basic(optional = false)
    @Column(name = "PESEL")
    private int pesel;
    @Column(name = "miejscowosc")
    private String miejscowosc;
    @Column(name = "ulica")
    private String ulica;
    @Column(name = "nr_domu")
    private Integer nrDomu;
    @Column(name = "nr_lokalu")
    private Integer nrLokalu;
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
    @Column(name = "poczta")
    private String poczta;
    @JoinColumn(name = "lekarz_id", referencedColumnName = "lekarz_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Wizyty wizyty;

    public Lekarze() {
    }

    public Lekarze(Integer lekarzId) {
        this.lekarzId = lekarzId;
    }

    public Lekarze(Integer lekarzId, String imie, String nazwisko, int nrTel, int pesel) {
        this.lekarzId = lekarzId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTel = nrTel;
        this.pesel = pesel;
    }

    public Integer getLekarzId() {
        return lekarzId;
    }

    public void setLekarzId(Integer lekarzId) {
        this.lekarzId = lekarzId;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrTel() {
        return nrTel;
    }

    public void setNrTel(int nrTel) {
        this.nrTel = nrTel;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public Integer getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(Integer nrDomu) {
        this.nrDomu = nrDomu;
    }

    public Integer getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(Integer nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getPoczta() {
        return poczta;
    }

    public void setPoczta(String poczta) {
        this.poczta = poczta;
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
        hash += (lekarzId != null ? lekarzId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lekarze)) {
            return false;
        }
        Lekarze other = (Lekarze) object;
        if ((this.lekarzId == null && other.lekarzId != null) || (this.lekarzId != null && !this.lekarzId.equals(other.lekarzId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Lekarze[ lekarzId=" + lekarzId + " ]";
    }
    
}
