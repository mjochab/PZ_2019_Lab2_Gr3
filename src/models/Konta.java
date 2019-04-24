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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author damia
 */
@Entity
@Table(name = "konta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konta.findAll", query = "SELECT k FROM Konta k"),
    @NamedQuery(name = "Konta.findByKontoId", query = "SELECT k FROM Konta k WHERE k.kontoId = :kontoId"),
    @NamedQuery(name = "Konta.findByLogin", query = "SELECT k FROM Konta k WHERE k.login = :login"),
    @NamedQuery(name = "Konta.findByHaslo", query = "SELECT k FROM Konta k WHERE k.haslo = :haslo"),
    @NamedQuery(name = "Konta.findByRodzajKonta", query = "SELECT k FROM Konta k WHERE k.rodzajKonta = :rodzajKonta")})
public class Konta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "konto_id")
    private Integer kontoId;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Column(name = "haslo")
    private String haslo;
    @Basic(optional = false)
    @Column(name = "rodzaj_konta")
    private String rodzajKonta;

    public Konta() {
    }

    public Konta(Integer kontoId) {
        this.kontoId = kontoId;
    }

    public Konta(Integer kontoId, String login, String haslo, String rodzajKonta) {
        this.kontoId = kontoId;
        this.login = login;
        this.haslo = haslo;
        this.rodzajKonta = rodzajKonta;
    }

    public Integer getKontoId() {
        return kontoId;
    }

    public void setKontoId(Integer kontoId) {
        this.kontoId = kontoId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getRodzajKonta() {
        return rodzajKonta;
    }

    public void setRodzajKonta(String rodzajKonta) {
        this.rodzajKonta = rodzajKonta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kontoId != null ? kontoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konta)) {
            return false;
        }
        Konta other = (Konta) object;
        if ((this.kontoId == null && other.kontoId != null) || (this.kontoId != null && !this.kontoId.equals(other.kontoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Konta[ kontoId=" + kontoId + " ]";
    }
    
}
