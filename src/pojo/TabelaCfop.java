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
@Table(name = "tabelacfop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaCfop.findAll", query = "SELECT t FROM TabelaCfop t")
    , @NamedQuery(name = "TabelaCfop.findByCfop", query = "SELECT t FROM TabelaCfop t WHERE t.cfop = :cfop")
    , @NamedQuery(name = "TabelaCfop.findByDescricao", query = "SELECT t FROM TabelaCfop t WHERE t.descricao = :descricao")})
public class TabelaCfop implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cfop")
    private Integer cfop;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cfopEntrada")
    private Collection<PessoaJuridica> pessoaJuridicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cfopSaida")
    private Collection<PessoaJuridica> pessoaJuridicaCollection1;

    public TabelaCfop() {
    }

    public TabelaCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public TabelaCfop(Integer cfop, String descricao) {
        this.cfop = cfop;
        this.descricao = descricao;
    }

    public Integer getCfop() {
        return cfop;
    }

    public void setCfop(Integer cfop) {
        this.cfop = cfop;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<PessoaJuridica> getPessoaJuridicaCollection() {
        return pessoaJuridicaCollection;
    }

    public void setPessoaJuridicaCollection(Collection<PessoaJuridica> pessoaJuridicaCollection) {
        this.pessoaJuridicaCollection = pessoaJuridicaCollection;
    }

    @XmlTransient
    public Collection<PessoaJuridica> getPessoaJuridicaCollection1() {
        return pessoaJuridicaCollection1;
    }

    public void setPessoaJuridicaCollection1(Collection<PessoaJuridica> pessoaJuridicaCollection1) {
        this.pessoaJuridicaCollection1 = pessoaJuridicaCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cfop != null ? cfop.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaCfop)) {
            return false;
        }
        TabelaCfop other = (TabelaCfop) object;
        if ((this.cfop == null && other.cfop != null) || (this.cfop != null && !this.cfop.equals(other.cfop))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TabelaCfop[ cfop=" + cfop + " ]";
    }
    
}
