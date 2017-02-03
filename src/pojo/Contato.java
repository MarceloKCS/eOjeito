/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "contato")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contato.findAll", query = "SELECT c FROM Contato c")
    , @NamedQuery(name = "Contato.findByCodigoUsuario", query = "SELECT c FROM Contato c WHERE c.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "Contato.findByTelefone", query = "SELECT c FROM Contato c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Contato.findByCelular1", query = "SELECT c FROM Contato c WHERE c.celular1 = :celular1")
    , @NamedQuery(name = "Contato.findByCelular2", query = "SELECT c FROM Contato c WHERE c.celular2 = :celular2")
    , @NamedQuery(name = "Contato.findByEmail", query = "SELECT c FROM Contato c WHERE c.email = :email")
    , @NamedQuery(name = "Contato.findByWebsite", query = "SELECT c FROM Contato c WHERE c.website = :website")})
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "celular1")
    private String celular1;
    @Column(name = "celular2")
    private String celular2;
    @Column(name = "email")
    private String email;
    @Column(name = "website")
    private String website;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;

    public Contato() {
    }

    public Contato(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Contato(Integer codigoUsuario, String celular1) {
        this.codigoUsuario = codigoUsuario;
        this.celular1 = celular1;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contato)) {
            return false;
        }
        Contato other = (Contato) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Contato[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
