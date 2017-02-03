/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "areacomum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaComum.findAll", query = "SELECT a FROM AreaComum a")
    , @NamedQuery(name = "AreaComum.findByCodigoArea", query = "SELECT a FROM AreaComum a WHERE a.areaComumPK.codigoArea = :codigoArea")
    , @NamedQuery(name = "AreaComum.findByCodigoCondominio", query = "SELECT a FROM AreaComum a WHERE a.areaComumPK.codigoCondominio = :codigoCondominio")
    , @NamedQuery(name = "AreaComum.findByNome", query = "SELECT a FROM AreaComum a WHERE a.nome = :nome")
    , @NamedQuery(name = "AreaComum.findByAbertura", query = "SELECT a FROM AreaComum a WHERE a.abertura = :abertura")
    , @NamedQuery(name = "AreaComum.findByFechamento", query = "SELECT a FROM AreaComum a WHERE a.fechamento = :fechamento")
    , @NamedQuery(name = "AreaComum.findByDomingo", query = "SELECT a FROM AreaComum a WHERE a.domingo = :domingo")
    , @NamedQuery(name = "AreaComum.findBySegunda", query = "SELECT a FROM AreaComum a WHERE a.segunda = :segunda")
    , @NamedQuery(name = "AreaComum.findByTerca", query = "SELECT a FROM AreaComum a WHERE a.terca = :terca")
    , @NamedQuery(name = "AreaComum.findByQuarta", query = "SELECT a FROM AreaComum a WHERE a.quarta = :quarta")
    , @NamedQuery(name = "AreaComum.findByQuinta", query = "SELECT a FROM AreaComum a WHERE a.quinta = :quinta")
    , @NamedQuery(name = "AreaComum.findBySexta", query = "SELECT a FROM AreaComum a WHERE a.sexta = :sexta")
    , @NamedQuery(name = "AreaComum.findBySabado", query = "SELECT a FROM AreaComum a WHERE a.sabado = :sabado")
    , @NamedQuery(name = "AreaComum.findByCapacidade", query = "SELECT a FROM AreaComum a WHERE a.capacidade = :capacidade")
    , @NamedQuery(name = "AreaComum.findByReserva", query = "SELECT a FROM AreaComum a WHERE a.reserva = :reserva")
    , @NamedQuery(name = "AreaComum.findByReservaDuracao", query = "SELECT a FROM AreaComum a WHERE a.reservaDuracao = :reservaDuracao")
    , @NamedQuery(name = "AreaComum.findByReservaValor", query = "SELECT a FROM AreaComum a WHERE a.reservaValor = :reservaValor")})
public class AreaComum implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AreaComumPK areaComumPK;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "abertura")
    @Temporal(TemporalType.TIME)
    private Date abertura;
    @Basic(optional = false)
    @Column(name = "fechamento")
    @Temporal(TemporalType.TIME)
    private Date fechamento;
    @Column(name = "domingo")
    private Boolean domingo;
    @Column(name = "segunda")
    private Boolean segunda;
    @Column(name = "terca")
    private Boolean terca;
    @Column(name = "quarta")
    private Boolean quarta;
    @Column(name = "quinta")
    private Boolean quinta;
    @Column(name = "sexta")
    private Boolean sexta;
    @Column(name = "sabado")
    private Boolean sabado;
    @Basic(optional = false)
    @Column(name = "capacidade")
    private int capacidade;
    @Basic(optional = false)
    @Column(name = "reserva")
    private boolean reserva;
    @Column(name = "reservaDuracao")
    @Temporal(TemporalType.TIME)
    private Date reservaDuracao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "reservaValor")
    private Double reservaValor;
    @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PessoaJuridica pessoaJuridica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaComum")
    private Collection<Reserva> reservaCollection;

    public AreaComum() {
    }

    public AreaComum(AreaComumPK areaComumPK) {
        this.areaComumPK = areaComumPK;
    }

    public AreaComum(AreaComumPK areaComumPK, String nome, Date abertura, Date fechamento, int capacidade, boolean reserva) {
        this.areaComumPK = areaComumPK;
        this.nome = nome;
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.capacidade = capacidade;
        this.reserva = reserva;
    }

    public AreaComum(int codigoArea, int codigoCondominio) {
        this.areaComumPK = new AreaComumPK(codigoArea, codigoCondominio);
    }

    public AreaComumPK getAreaComumPK() {
        return areaComumPK;
    }

    public void setAreaComumPK(AreaComumPK areaComumPK) {
        this.areaComumPK = areaComumPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public Boolean getDomingo() {
        return domingo;
    }

    public void setDomingo(Boolean domingo) {
        this.domingo = domingo;
    }

    public Boolean getSegunda() {
        return segunda;
    }

    public void setSegunda(Boolean segunda) {
        this.segunda = segunda;
    }

    public Boolean getTerca() {
        return terca;
    }

    public void setTerca(Boolean terca) {
        this.terca = terca;
    }

    public Boolean getQuarta() {
        return quarta;
    }

    public void setQuarta(Boolean quarta) {
        this.quarta = quarta;
    }

    public Boolean getQuinta() {
        return quinta;
    }

    public void setQuinta(Boolean quinta) {
        this.quinta = quinta;
    }

    public Boolean getSexta() {
        return sexta;
    }

    public void setSexta(Boolean sexta) {
        this.sexta = sexta;
    }

    public Boolean getSabado() {
        return sabado;
    }

    public void setSabado(Boolean sabado) {
        this.sabado = sabado;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean getReserva() {
        return reserva;
    }

    public void setReserva(boolean reserva) {
        this.reserva = reserva;
    }

    public Date getReservaDuracao() {
        return reservaDuracao;
    }

    public void setReservaDuracao(Date reservaDuracao) {
        this.reservaDuracao = reservaDuracao;
    }

    public Double getReservaValor() {
        return reservaValor;
    }

    public void setReservaValor(Double reservaValor) {
        this.reservaValor = reservaValor;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaComumPK != null ? areaComumPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaComum)) {
            return false;
        }
        AreaComum other = (AreaComum) object;
        if ((this.areaComumPK == null && other.areaComumPK != null) || (this.areaComumPK != null && !this.areaComumPK.equals(other.areaComumPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.AreaComum[ areaComumPK=" + areaComumPK + " ]";
    }
    
}
