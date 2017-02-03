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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tabelacorreios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TabelaCorreios.findAll", query = "SELECT t FROM TabelaCorreios t")
    , @NamedQuery(name = "TabelaCorreios.findByIbge", query = "SELECT t FROM TabelaCorreios t WHERE t.tabelaCorreiosPK.ibge = :ibge")
    , @NamedQuery(name = "TabelaCorreios.findByCep", query = "SELECT t FROM TabelaCorreios t WHERE t.tabelaCorreiosPK.cep = :cep")
    , @NamedQuery(name = "TabelaCorreios.findByUf", query = "SELECT t FROM TabelaCorreios t WHERE t.uf = :uf")
    , @NamedQuery(name = "TabelaCorreios.findByCidade", query = "SELECT t FROM TabelaCorreios t WHERE t.cidade = :cidade")
    , @NamedQuery(name = "TabelaCorreios.findByBairro", query = "SELECT t FROM TabelaCorreios t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "TabelaCorreios.findByLogradouro", query = "SELECT t FROM TabelaCorreios t WHERE t.logradouro = :logradouro")})
public class TabelaCorreios implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TabelaCorreiosPK tabelaCorreiosPK;
    @Basic(optional = false)
    @Column(name = "uf")
    private String uf;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tabelaCorreios")
    private Collection<Endereco> enderecoCollection;

    public TabelaCorreios() {
    }

    public TabelaCorreios(TabelaCorreiosPK tabelaCorreiosPK) {
        this.tabelaCorreiosPK = tabelaCorreiosPK;
    }

    public TabelaCorreios(TabelaCorreiosPK tabelaCorreiosPK, String uf, String cidade, String bairro, String logradouro) {
        this.tabelaCorreiosPK = tabelaCorreiosPK;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
    }

    public TabelaCorreios(int ibge, int cep) {
        this.tabelaCorreiosPK = new TabelaCorreiosPK(ibge, cep);
    }

    public TabelaCorreiosPK getTabelaCorreiosPK() {
        return tabelaCorreiosPK;
    }

    public void setTabelaCorreiosPK(TabelaCorreiosPK tabelaCorreiosPK) {
        this.tabelaCorreiosPK = tabelaCorreiosPK;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tabelaCorreiosPK != null ? tabelaCorreiosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaCorreios)) {
            return false;
        }
        TabelaCorreios other = (TabelaCorreios) object;
        if ((this.tabelaCorreiosPK == null && other.tabelaCorreiosPK != null) || (this.tabelaCorreiosPK != null && !this.tabelaCorreiosPK.equals(other.tabelaCorreiosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TabelaCorreios[ tabelaCorreiosPK=" + tabelaCorreiosPK + " ]";
    }
    
}
