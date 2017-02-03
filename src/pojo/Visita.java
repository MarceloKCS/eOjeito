/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "visita")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v")
    , @NamedQuery(name = "Visita.findByCodigoMorador", query = "SELECT v FROM Visita v WHERE v.visitaPK.codigoMorador = :codigoMorador")
    , @NamedQuery(name = "Visita.findByCodigoVisitante", query = "SELECT v FROM Visita v WHERE v.visitaPK.codigoVisitante = :codigoVisitante")
    , @NamedQuery(name = "Visita.findByEntrada", query = "SELECT v FROM Visita v WHERE v.entrada = :entrada")
    , @NamedQuery(name = "Visita.findBySaida", query = "SELECT v FROM Visita v WHERE v.saida = :saida")
    , @NamedQuery(name = "Visita.findByVeiculo", query = "SELECT v FROM Visita v WHERE v.veiculo = :veiculo")
    , @NamedQuery(name = "Visita.findByRececbido", query = "SELECT v FROM Visita v WHERE v.rececbido = :rececbido")})
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VisitaPK visitaPK;
    @Basic(optional = false)
    @Column(name = "entrada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date entrada;
    @Basic(optional = false)
    @Column(name = "saida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date saida;
    @Column(name = "veiculo")
    private Boolean veiculo;
    @Basic(optional = false)
    @Column(name = "rececbido")
    private boolean rececbido;
    @JoinColumn(name = "codigoMorador", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PessoaFisica pessoaFisica;
    @JoinColumn(name = "codigoVisitante", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PessoaFisica pessoaFisica1;

    public Visita() {
    }

    public Visita(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
    }

    public Visita(VisitaPK visitaPK, Date entrada, Date saida, boolean rececbido) {
        this.visitaPK = visitaPK;
        this.entrada = entrada;
        this.saida = saida;
        this.rececbido = rececbido;
    }

    public Visita(int codigoMorador, int codigoVisitante) {
        this.visitaPK = new VisitaPK(codigoMorador, codigoVisitante);
    }

    public VisitaPK getVisitaPK() {
        return visitaPK;
    }

    public void setVisitaPK(VisitaPK visitaPK) {
        this.visitaPK = visitaPK;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

    public Boolean getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Boolean veiculo) {
        this.veiculo = veiculo;
    }

    public boolean getRececbido() {
        return rececbido;
    }

    public void setRececbido(boolean rececbido) {
        this.rececbido = rececbido;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaFisica getPessoaFisica1() {
        return pessoaFisica1;
    }

    public void setPessoaFisica1(PessoaFisica pessoaFisica1) {
        this.pessoaFisica1 = pessoaFisica1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (visitaPK != null ? visitaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visita)) {
            return false;
        }
        Visita other = (Visita) object;
        if ((this.visitaPK == null && other.visitaPK != null) || (this.visitaPK != null && !this.visitaPK.equals(other.visitaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Visita[ visitaPK=" + visitaPK + " ]";
    }
    
}
