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
@Table(name = "recepcjonisci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recepcjonisci.findAll", query = "SELECT r FROM Recepcjonisci r"),
    @NamedQuery(name = "Recepcjonisci.findByRecepcjonistaId", query = "SELECT r FROM Recepcjonisci r WHERE r.recepcjonistaId = :recepcjonistaId"),
    @NamedQuery(name = "Recepcjonisci.findByImie", query = "SELECT r FROM Recepcjonisci r WHERE r.imie = :imie"),
    @NamedQuery(name = "Recepcjonisci.findByNazwisko", query = "SELECT r FROM Recepcjonisci r WHERE r.nazwisko = :nazwisko"),
    @NamedQuery(name = "Recepcjonisci.findByEmail", query = "SELECT r FROM Recepcjonisci r WHERE r.email = :email"),
    @NamedQuery(name = "Recepcjonisci.findByNrTel", query = "SELECT r FROM Recepcjonisci r WHERE r.nrTel = :nrTel"),
    @NamedQuery(name = "Recepcjonisci.findByPesel", query = "SELECT r FROM Recepcjonisci r WHERE r.pesel = :pesel"),
    @NamedQuery(name = "Recepcjonisci.findByMiejscowosc", query = "SELECT r FROM Recepcjonisci r WHERE r.miejscowosc = :miejscowosc"),
    @NamedQuery(name = "Recepcjonisci.findByUlica", query = "SELECT r FROM Recepcjonisci r WHERE r.ulica = :ulica"),
    @NamedQuery(name = "Recepcjonisci.findByNrDomu", query = "SELECT r FROM Recepcjonisci r WHERE r.nrDomu = :nrDomu"),
    @NamedQuery(name = "Recepcjonisci.findByNrLokalu", query = "SELECT r FROM Recepcjonisci r WHERE r.nrLokalu = :nrLokalu"),
    @NamedQuery(name = "Recepcjonisci.findByKodPocztowy", query = "SELECT r FROM Recepcjonisci r WHERE r.kodPocztowy = :kodPocztowy"),
    @NamedQuery(name = "Recepcjonisci.findByPoczta", query = "SELECT r FROM Recepcjonisci r WHERE r.poczta = :poczta")})
public class Recepcjonisci implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recepcjonista_id")
    private Integer recepcjonistaId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recepcjonistaId")
    private Collection<Wizyty> wizytyCollection;

    public Recepcjonisci() {
    }

    public Recepcjonisci(Integer recepcjonistaId) {
        this.recepcjonistaId = recepcjonistaId;
    }

    public Recepcjonisci(Integer recepcjonistaId, String imie, String nazwisko, int nrTel, int pesel) {
        this.recepcjonistaId = recepcjonistaId;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTel = nrTel;
        this.pesel = pesel;
    }

    public Integer getRecepcjonistaId() {
        return recepcjonistaId;
    }

    public void setRecepcjonistaId(Integer recepcjonistaId) {
        this.recepcjonistaId = recepcjonistaId;
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
        hash += (recepcjonistaId != null ? recepcjonistaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recepcjonisci)) {
            return false;
        }
        Recepcjonisci other = (Recepcjonisci) object;
        if ((this.recepcjonistaId == null && other.recepcjonistaId != null) || (this.recepcjonistaId != null && !this.recepcjonistaId.equals(other.recepcjonistaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Recepcjonisci[ recepcjonistaId=" + recepcjonistaId + " ]";
    }
    
}
