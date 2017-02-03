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
@Table(name = "ocorrenciacategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OcorrenciaCategoria.findAll", query = "SELECT o FROM OcorrenciaCategoria o")
    , @NamedQuery(name = "OcorrenciaCategoria.findByIdOcorrenciaCategoria", query = "SELECT o FROM OcorrenciaCategoria o WHERE o.idOcorrenciaCategoria = :idOcorrenciaCategoria")
    , @NamedQuery(name = "OcorrenciaCategoria.findByNome", query = "SELECT o FROM OcorrenciaCategoria o WHERE o.nome = :nome")})
public class OcorrenciaCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idOcorrenciaCategoria")
    private Integer idOcorrenciaCategoria;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOcorrenciaCategoria")
    private Collection<Ocorrencia> ocorrenciaCollection;

    public OcorrenciaCategoria() {
    }

    public OcorrenciaCategoria(Integer idOcorrenciaCategoria) {
        this.idOcorrenciaCategoria = idOcorrenciaCategoria;
    }

    public OcorrenciaCategoria(Integer idOcorrenciaCategoria, String nome) {
        this.idOcorrenciaCategoria = idOcorrenciaCategoria;
        this.nome = nome;
    }

    public Integer getIdOcorrenciaCategoria() {
        return idOcorrenciaCategoria;
    }

    public void setIdOcorrenciaCategoria(Integer idOcorrenciaCategoria) {
        this.idOcorrenciaCategoria = idOcorrenciaCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Ocorrencia> getOcorrenciaCollection() {
        return ocorrenciaCollection;
    }

    public void setOcorrenciaCollection(Collection<Ocorrencia> ocorrenciaCollection) {
        this.ocorrenciaCollection = ocorrenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOcorrenciaCategoria != null ? idOcorrenciaCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OcorrenciaCategoria)) {
            return false;
        }
        OcorrenciaCategoria other = (OcorrenciaCategoria) object;
        if ((this.idOcorrenciaCategoria == null && other.idOcorrenciaCategoria != null) || (this.idOcorrenciaCategoria != null && !this.idOcorrenciaCategoria.equals(other.idOcorrenciaCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.OcorrenciaCategoria[ idOcorrenciaCategoria=" + idOcorrenciaCategoria + " ]";
    }
    
}
