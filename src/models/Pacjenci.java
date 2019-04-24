/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pacjenci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacjenci.findAll", query = "SELECT p FROM Pacjenci p"),
    @NamedQuery(name = "Pacjenci.findByPacjentId", query = "SELECT p FROM Pacjenci p WHERE p.pacjentId = :pacjentId"),
    @NamedQuery(name = "Pacjenci.findByImie", query = "SELECT p FROM Pacjenci p WHERE p.imie = :imie"),
    @NamedQuery(name = "Pacjenci.findByNazwisko", query = "SELECT p FROM Pacjenci p WHERE p.nazwisko = :nazwisko"),
    @NamedQuery(name = "Pacjenci.findByEmail", query = "SELECT p FROM Pacjenci p WHERE p.email = :email"),
    @NamedQuery(name = "Pacjenci.findByNrTel", query = "SELECT p FROM Pacjenci p WHERE p.nrTel = :nrTel"),
    @NamedQuery(name = "Pacjenci.findByPesel", query = "SELECT p FROM Pacjenci p WHERE p.pesel = :pesel"),
    @NamedQuery(name = "Pacjenci.findByMiejscowosc", query = "SELECT p FROM Pacjenci p WHERE p.miejscowosc = :miejscowosc"),
    @NamedQuery(name = "Pacjenci.findByUlica", query = "SELECT p FROM Pacjenci p WHERE p.ulica = :ulica"),
    @NamedQuery(name = "Pacjenci.findByNrDomu", query = "SELECT p FROM Pacjenci p WHERE p.nrDomu = :nrDomu"),
    @NamedQuery(name = "Pacjenci.findByNrLokalu", query = "SELECT p FROM Pacjenci p WHERE p.nrLokalu = :nrLokalu"),
    @NamedQuery(name = "Pacjenci.findByKodPocztowy", query = "SELECT p FROM Pacjenci p WHERE p.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Pacjenci.findByPoczta", query = "SELECT p FROM Pacjenci p WHERE p.poczta = :poczta")})
public class Pacjenci implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pacjent_id")
    private Integer pacjentId;
    @Basic(optional = false)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @Column(name = "nazwisko")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "nr_tel")
    private int nrTel;
    @Basic(optional = false)
    @Column(name = "PESEL")
    private long pesel;
    @Basic(optional = false)
    @Column(name = "miejscowosc")
    private String miejscowosc;
    @Basic(optional = false)
    @Column(name = "ulica")
    private String ulica;
    @Basic(optional = false)
    @Column(name = "nr_domu")
    private int nrDomu;
    @Basic(optional = false)
    @Column(name = "nr_lokalu")
    private int nrLokalu;
    @Basic(optional = false)
    @Column(name = "kod_pocztowy")
    private String kodPocztowy;
    @Basic(optional = false)
    @Column(name = "poczta")
    private String poczta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacjentId")
    private Collection<Wizyty> wizytyCollection;

    public Pacjenci() {
    }

    public Pacjenci(Integer pacjentId) {
        this.pacjentId = pacjentId;
    }

    public Pacjenci(Integer pacjentId, String imie, String nazwisko, String email, int nrTel, long pesel, String miejscowosc, String ulica, int nrDomu, int nrLokalu, String kodPocztowy, String poczta) {
        this.pacjentId = pacjentId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.nrTel = nrTel;
        this.pesel = pesel;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        this.kodPocztowy = kodPocztowy;
        this.poczta = poczta;
    }

    public Integer getPacjentId() {
        return pacjentId;
    }

    public void setPacjentId(Integer pacjentId) {
        this.pacjentId = pacjentId;
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

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
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

    public int getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(int nrDomu) {
        this.nrDomu = nrDomu;
    }

    public int getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(int nrLokalu) {
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
        hash += (pacjentId != null ? pacjentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacjenci)) {
            return false;
        }
        Pacjenci other = (Pacjenci) object;
        if ((this.pacjentId == null && other.pacjentId != null) || (this.pacjentId != null && !this.pacjentId.equals(other.pacjentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Pacjenci[ pacjentId=" + pacjentId + " ]";
    }
    
}
