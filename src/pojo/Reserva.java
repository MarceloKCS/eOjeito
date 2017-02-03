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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "reserva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r")
    , @NamedQuery(name = "Reserva.findByCodigoReserva", query = "SELECT r FROM Reserva r WHERE r.codigoReserva = :codigoReserva")
    , @NamedQuery(name = "Reserva.findByFinalidade", query = "SELECT r FROM Reserva r WHERE r.finalidade = :finalidade")
    , @NamedQuery(name = "Reserva.findByConvidado", query = "SELECT r FROM Reserva r WHERE r.convidado = :convidado")
    , @NamedQuery(name = "Reserva.findByDia", query = "SELECT r FROM Reserva r WHERE r.dia = :dia")
    , @NamedQuery(name = "Reserva.findByInicio", query = "SELECT r FROM Reserva r WHERE r.inicio = :inicio")
    , @NamedQuery(name = "Reserva.findByFim", query = "SELECT r FROM Reserva r WHERE r.fim = :fim")
    , @NamedQuery(name = "Reserva.findByValor", query = "SELECT r FROM Reserva r WHERE r.valor = :valor")
    , @NamedQuery(name = "Reserva.findByAvaliacao", query = "SELECT r FROM Reserva r WHERE r.avaliacao = :avaliacao")})
public class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoReserva")
    private Integer codigoReserva;
    @Basic(optional = false)
    @Column(name = "finalidade")
    private String finalidade;
    @Basic(optional = false)
    @Column(name = "convidado")
    private int convidado;
    @Basic(optional = false)
    @Column(name = "dia")
    @Temporal(TemporalType.DATE)
    private Date dia;
    @Basic(optional = false)
    @Column(name = "inicio")
    @Temporal(TemporalType.TIME)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "fim")
    @Temporal(TemporalType.TIME)
    private Date fim;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "avaliacao")
    private Double avaliacao;
    @ManyToMany(mappedBy = "reservaCollection")
    private Collection<PessoaFisica> pessoaFisicaCollection;
    @JoinColumns({
        @JoinColumn(name = "codigoArea", referencedColumnName = "codigoArea")
        , @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoCondominio")})
    @ManyToOne(optional = false)
    private AreaComum areaComum;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaFisica codigoUsuario;

    public Reserva() {
    }

    public Reserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Reserva(Integer codigoReserva, String finalidade, int convidado, Date dia, Date inicio, Date fim, double valor) {
        this.codigoReserva = codigoReserva;
        this.finalidade = finalidade;
        this.convidado = convidado;
        this.dia = dia;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
    }

    public Integer getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(Integer codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getFinalidade() {
        return finalidade;
    }

    public void setFinalidade(String finalidade) {
        this.finalidade = finalidade;
    }

    public int getConvidado() {
        return convidado;
    }

    public void setConvidado(int convidado) {
        this.convidado = convidado;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    @XmlTransient
    public Collection<PessoaFisica> getPessoaFisicaCollection() {
        return pessoaFisicaCollection;
    }

    public void setPessoaFisicaCollection(Collection<PessoaFisica> pessoaFisicaCollection) {
        this.pessoaFisicaCollection = pessoaFisicaCollection;
    }

    public AreaComum getAreaComum() {
        return areaComum;
    }

    public void setAreaComum(AreaComum areaComum) {
        this.areaComum = areaComum;
    }

    public PessoaFisica getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(PessoaFisica codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoReserva != null ? codigoReserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.codigoReserva == null && other.codigoReserva != null) || (this.codigoReserva != null && !this.codigoReserva.equals(other.codigoReserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Reserva[ codigoReserva=" + codigoReserva + " ]";
    }
    
}
