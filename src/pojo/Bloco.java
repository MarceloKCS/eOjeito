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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bloco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bloco.findAll", query = "SELECT b FROM Bloco b")
    , @NamedQuery(name = "Bloco.findByCodigoBloco", query = "SELECT b FROM Bloco b WHERE b.blocoPK.codigoBloco = :codigoBloco")
    , @NamedQuery(name = "Bloco.findByCodigoCondominio", query = "SELECT b FROM Bloco b WHERE b.blocoPK.codigoCondominio = :codigoCondominio")
    , @NamedQuery(name = "Bloco.findByNumero", query = "SELECT b FROM Bloco b WHERE b.numero = :numero")
    , @NamedQuery(name = "Bloco.findByNome", query = "SELECT b FROM Bloco b WHERE b.nome = :nome")
    , @NamedQuery(name = "Bloco.findByElevador", query = "SELECT b FROM Bloco b WHERE b.elevador = :elevador")
    , @NamedQuery(name = "Bloco.findByEscada", query = "SELECT b FROM Bloco b WHERE b.escada = :escada")
    , @NamedQuery(name = "Bloco.findByPavimento", query = "SELECT b FROM Bloco b WHERE b.pavimento = :pavimento")
    , @NamedQuery(name = "Bloco.findByApartamento", query = "SELECT b FROM Bloco b WHERE b.apartamento = :apartamento")
    , @NamedQuery(name = "Bloco.findByGaragem", query = "SELECT b FROM Bloco b WHERE b.garagem = :garagem")})
public class Bloco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BlocoPK blocoPK;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "elevador")
    private boolean elevador;
    @Basic(optional = false)
    @Column(name = "escada")
    private boolean escada;
    @Basic(optional = false)
    @Column(name = "pavimento")
    private int pavimento;
    @Basic(optional = false)
    @Column(name = "apartamento")
    private int apartamento;
    @Basic(optional = false)
    @Column(name = "garagem")
    private int garagem;
    @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PessoaJuridica pessoaJuridica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloco")
    private Collection<Apartamento> apartamentoCollection;

    public Bloco() {
    }

    public Bloco(BlocoPK blocoPK) {
        this.blocoPK = blocoPK;
    }

    public Bloco(BlocoPK blocoPK, int numero, String nome, boolean elevador, boolean escada, int pavimento, int apartamento, int garagem) {
        this.blocoPK = blocoPK;
        this.numero = numero;
        this.nome = nome;
        this.elevador = elevador;
        this.escada = escada;
        this.pavimento = pavimento;
        this.apartamento = apartamento;
        this.garagem = garagem;
    }

    public Bloco(int codigoBloco, int codigoCondominio) {
        this.blocoPK = new BlocoPK(codigoBloco, codigoCondominio);
    }

    public BlocoPK getBlocoPK() {
        return blocoPK;
    }

    public void setBlocoPK(BlocoPK blocoPK) {
        this.blocoPK = blocoPK;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getElevador() {
        return elevador;
    }

    public void setElevador(boolean elevador) {
        this.elevador = elevador;
    }

    public boolean getEscada() {
        return escada;
    }

    public void setEscada(boolean escada) {
        this.escada = escada;
    }

    public int getPavimento() {
        return pavimento;
    }

    public void setPavimento(int pavimento) {
        this.pavimento = pavimento;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }

    public int getGaragem() {
        return garagem;
    }

    public void setGaragem(int garagem) {
        this.garagem = garagem;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    @XmlTransient
    public Collection<Apartamento> getApartamentoCollection() {
        return apartamentoCollection;
    }

    public void setApartamentoCollection(Collection<Apartamento> apartamentoCollection) {
        this.apartamentoCollection = apartamentoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blocoPK != null ? blocoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bloco)) {
            return false;
        }
        Bloco other = (Bloco) object;
        if ((this.blocoPK == null && other.blocoPK != null) || (this.blocoPK != null && !this.blocoPK.equals(other.blocoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Bloco[ blocoPK=" + blocoPK + " ]";
    }
    
}
