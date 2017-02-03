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
@Table(name = "tabelacnae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaCnae.findAll", query = "SELECT t FROM TabelaCnae t")
    , @NamedQuery(name = "TabelaCnae.findByCnae", query = "SELECT t FROM TabelaCnae t WHERE t.cnae = :cnae")
    , @NamedQuery(name = "TabelaCnae.findByDescricao", query = "SELECT t FROM TabelaCnae t WHERE t.descricao = :descricao")})
public class TabelaCnae implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cnae")
    private Integer cnae;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cnae")
    private Collection<PessoaJuridica> pessoaJuridicaCollection;

    public TabelaCnae() {
    }

    public TabelaCnae(Integer cnae) {
        this.cnae = cnae;
    }

    public Integer getCnae() {
        return cnae;
    }

    public void setCnae(Integer cnae) {
        this.cnae = cnae;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cnae != null ? cnae.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaCnae)) {
            return false;
        }
        TabelaCnae other = (TabelaCnae) object;
        if ((this.cnae == null && other.cnae != null) || (this.cnae != null && !this.cnae.equals(other.cnae))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TabelaCnae[ cnae=" + cnae + " ]";
    }
    
}
