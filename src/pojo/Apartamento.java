/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "apartamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Apartamento.findAll", query = "SELECT a FROM Apartamento a")
    , @NamedQuery(name = "Apartamento.findByCodigoApartamento", query = "SELECT a FROM Apartamento a WHERE a.apartamentoPK.codigoApartamento = :codigoApartamento")
    , @NamedQuery(name = "Apartamento.findByCodigoBloco", query = "SELECT a FROM Apartamento a WHERE a.apartamentoPK.codigoBloco = :codigoBloco")
    , @NamedQuery(name = "Apartamento.findByCodigoCondominio", query = "SELECT a FROM Apartamento a WHERE a.apartamentoPK.codigoCondominio = :codigoCondominio")
    , @NamedQuery(name = "Apartamento.findByTipo", query = "SELECT a FROM Apartamento a WHERE a.tipo = :tipo")
    , @NamedQuery(name = "Apartamento.findByMetragem", query = "SELECT a FROM Apartamento a WHERE a.metragem = :metragem")
    , @NamedQuery(name = "Apartamento.findByLocalizacao", query = "SELECT a FROM Apartamento a WHERE a.localizacao = :localizacao")
    , @NamedQuery(name = "Apartamento.findByGaragem", query = "SELECT a FROM Apartamento a WHERE a.garagem = :garagem")
    , @NamedQuery(name = "Apartamento.findByInterfone", query = "SELECT a FROM Apartamento a WHERE a.interfone = :interfone")})
public class Apartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ApartamentoPK apartamentoPK;
    @Basic(optional = false)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "metragem")
    private double metragem;
    @Basic(optional = false)
    @Column(name = "localizacao")
    private int localizacao;
    @Basic(optional = false)
    @Column(name = "garagem")
    private int garagem;
    @Column(name = "interfone")
    private Integer interfone;
    @JoinTable(name = "morador", joinColumns = {
        @JoinColumn(name = "codigoApartamento", referencedColumnName = "codigoApartamento")
        , @JoinColumn(name = "codigoBloco", referencedColumnName = "codigoBloco")
        , @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoCondominio")}, inverseJoinColumns = {
        @JoinColumn(name = "codigoMorador", referencedColumnName = "codigoUsuario")})
    @ManyToMany
    private Collection<PessoaFisica> pessoaFisicaCollection;
    @JoinColumns({
        @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoCondominio", insertable = false, updatable = false)
        , @JoinColumn(name = "codigoBloco", referencedColumnName = "codigoBloco", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Bloco bloco;
    @JoinColumn(name = "codigoProprietario", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private Usuario codigoProprietario;

    public Apartamento() {
    }

    public Apartamento(ApartamentoPK apartamentoPK) {
        this.apartamentoPK = apartamentoPK;
    }

    public Apartamento(ApartamentoPK apartamentoPK, String tipo, double metragem, int localizacao, int garagem) {
        this.apartamentoPK = apartamentoPK;
        this.tipo = tipo;
        this.metragem = metragem;
        this.localizacao = localizacao;
        this.garagem = garagem;
    }

    public Apartamento(int codigoApartamento, int codigoBloco, int codigoCondominio) {
        this.apartamentoPK = new ApartamentoPK(codigoApartamento, codigoBloco, codigoCondominio);
    }

    public ApartamentoPK getApartamentoPK() {
        return apartamentoPK;
    }

    public void setApartamentoPK(ApartamentoPK apartamentoPK) {
        this.apartamentoPK = apartamentoPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMetragem() {
        return metragem;
    }

    public void setMetragem(double metragem) {
        this.metragem = metragem;
    }

    public int getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(int localizacao) {
        this.localizacao = localizacao;
    }

    public int getGaragem() {
        return garagem;
    }

    public void setGaragem(int garagem) {
        this.garagem = garagem;
    }

    public Integer getInterfone() {
        return interfone;
    }

    public void setInterfone(Integer interfone) {
        this.interfone = interfone;
    }

    @XmlTransient
    public Collection<PessoaFisica> getPessoaFisicaCollection() {
        return pessoaFisicaCollection;
    }

    public void setPessoaFisicaCollection(Collection<PessoaFisica> pessoaFisicaCollection) {
        this.pessoaFisicaCollection = pessoaFisicaCollection;
    }

    public Bloco getBloco() {
        return bloco;
    }

    public void setBloco(Bloco bloco) {
        this.bloco = bloco;
    }

    public Usuario getCodigoProprietario() {
        return codigoProprietario;
    }

    public void setCodigoProprietario(Usuario codigoProprietario) {
        this.codigoProprietario = codigoProprietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apartamentoPK != null ? apartamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Apartamento)) {
            return false;
        }
        Apartamento other = (Apartamento) object;
        if ((this.apartamentoPK == null && other.apartamentoPK != null) || (this.apartamentoPK != null && !this.apartamentoPK.equals(other.apartamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Apartamento[ apartamentoPK=" + apartamentoPK + " ]";
    }
    
}
