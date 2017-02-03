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
@Table(name = "movimentacaocategoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovimentacaoCategoria.findAll", query = "SELECT m FROM MovimentacaoCategoria m")
    , @NamedQuery(name = "MovimentacaoCategoria.findByIdMovimentacaoCategoria", query = "SELECT m FROM MovimentacaoCategoria m WHERE m.idMovimentacaoCategoria = :idMovimentacaoCategoria")
    , @NamedQuery(name = "MovimentacaoCategoria.findByTipo", query = "SELECT m FROM MovimentacaoCategoria m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "MovimentacaoCategoria.findByNome", query = "SELECT m FROM MovimentacaoCategoria m WHERE m.nome = :nome")})
public class MovimentacaoCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMovimentacaoCategoria")
    private Integer idMovimentacaoCategoria;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMovimentacaoCategoria")
    private Collection<Movimentacao> movimentacaoCollection;

    public MovimentacaoCategoria() {
    }

    public MovimentacaoCategoria(Integer idMovimentacaoCategoria) {
        this.idMovimentacaoCategoria = idMovimentacaoCategoria;
    }

    public MovimentacaoCategoria(Integer idMovimentacaoCategoria, String tipo, String nome) {
        this.idMovimentacaoCategoria = idMovimentacaoCategoria;
        this.tipo = tipo;
        this.nome = nome;
    }

    public Integer getIdMovimentacaoCategoria() {
        return idMovimentacaoCategoria;
    }

    public void setIdMovimentacaoCategoria(Integer idMovimentacaoCategoria) {
        this.idMovimentacaoCategoria = idMovimentacaoCategoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimentacaoCategoria != null ? idMovimentacaoCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimentacaoCategoria)) {
            return false;
        }
        MovimentacaoCategoria other = (MovimentacaoCategoria) object;
        if ((this.idMovimentacaoCategoria == null && other.idMovimentacaoCategoria != null) || (this.idMovimentacaoCategoria != null && !this.idMovimentacaoCategoria.equals(other.idMovimentacaoCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.MovimentacaoCategoria[ idMovimentacaoCategoria=" + idMovimentacaoCategoria + " ]";
    }
    
}
