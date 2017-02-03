/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "validacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Validacao.findAll", query = "SELECT v FROM Validacao v")
    , @NamedQuery(name = "Validacao.findByCodigoUsuario", query = "SELECT v FROM Validacao v WHERE v.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "Validacao.findByUsuario", query = "SELECT v FROM Validacao v WHERE v.usuario = :usuario")
    , @NamedQuery(name = "Validacao.findBySenha", query = "SELECT v FROM Validacao v WHERE v.senha = :senha")})
public class Validacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuario")
    private Collection<Login> loginCollection;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario1;

    public Validacao() {
    }

    public Validacao(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Validacao(Integer codigoUsuario, String usuario, String senha) {
        this.codigoUsuario = codigoUsuario;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @XmlTransient
    public Collection<Login> getLoginCollection() {
        return loginCollection;
    }

    public void setLoginCollection(Collection<Login> loginCollection) {
        this.loginCollection = loginCollection;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
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
        if (!(object instanceof Validacao)) {
            return false;
        }
        Validacao other = (Validacao) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Validacao[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
