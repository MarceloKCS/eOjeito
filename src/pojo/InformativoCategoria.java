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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "informativocategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InformativoCategoria.findAll", query = "SELECT i FROM InformativoCategoria i")
    , @NamedQuery(name = "InformativoCategoria.findByIdInformativoCategoria", query = "SELECT i FROM InformativoCategoria i WHERE i.idInformativoCategoria = :idInformativoCategoria")
    , @NamedQuery(name = "InformativoCategoria.findByNome", query = "SELECT i FROM InformativoCategoria i WHERE i.nome = :nome")})
public class InformativoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idInformativoCategoria")
    private Integer idInformativoCategoria;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInformativoCategoria")
    private Collection<Informativo> informativoCollection;

    public InformativoCategoria() {
    }

    public InformativoCategoria(Integer idInformativoCategoria) {
        this.idInformativoCategoria = idInformativoCategoria;
    }

    public InformativoCategoria(Integer idInformativoCategoria, String nome) {
        this.idInformativoCategoria = idInformativoCategoria;
        this.nome = nome;
    }

    public Integer getIdInformativoCategoria() {
        return idInformativoCategoria;
    }

    public void setIdInformativoCategoria(Integer idInformativoCategoria) {
        this.idInformativoCategoria = idInformativoCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Informativo> getInformativoCollection() {
        return informativoCollection;
    }

    public void setInformativoCollection(Collection<Informativo> informativoCollection) {
        this.informativoCollection = informativoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInformativoCategoria != null ? idInformativoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InformativoCategoria)) {
            return false;
        }
        InformativoCategoria other = (InformativoCategoria) object;
        if ((this.idInformativoCategoria == null && other.idInformativoCategoria != null) || (this.idInformativoCategoria != null && !this.idInformativoCategoria.equals(other.idInformativoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.InformativoCategoria[ idInformativoCategoria=" + idInformativoCategoria + " ]";
    }
    
}
