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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByCodigoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.codigoFuncionario = :codigoFuncionario")
    , @NamedQuery(name = "Funcionario.findByAdimissao", query = "SELECT f FROM Funcionario f WHERE f.adimissao = :adimissao")
    , @NamedQuery(name = "Funcionario.findByDemissao", query = "SELECT f FROM Funcionario f WHERE f.demissao = :demissao")
    , @NamedQuery(name = "Funcionario.findByDependente", query = "SELECT f FROM Funcionario f WHERE f.dependente = :dependente")
    , @NamedQuery(name = "Funcionario.findByBolsa", query = "SELECT f FROM Funcionario f WHERE f.bolsa = :bolsa")
    , @NamedQuery(name = "Funcionario.findByValeTransporte", query = "SELECT f FROM Funcionario f WHERE f.valeTransporte = :valeTransporte")
    , @NamedQuery(name = "Funcionario.findByValeCombustivel", query = "SELECT f FROM Funcionario f WHERE f.valeCombustivel = :valeCombustivel")
    , @NamedQuery(name = "Funcionario.findByValeAlimentacao", query = "SELECT f FROM Funcionario f WHERE f.valeAlimentacao = :valeAlimentacao")
    , @NamedQuery(name = "Funcionario.findByValeRefeicao", query = "SELECT f FROM Funcionario f WHERE f.valeRefeicao = :valeRefeicao")
    , @NamedQuery(name = "Funcionario.findByValeFarmacia", query = "SELECT f FROM Funcionario f WHERE f.valeFarmacia = :valeFarmacia")
    , @NamedQuery(name = "Funcionario.findByPlanoSaude", query = "SELECT f FROM Funcionario f WHERE f.planoSaude = :planoSaude")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoFuncionario")
    private Integer codigoFuncionario;
    @Basic(optional = false)
    @Column(name = "adimissao")
    @Temporal(TemporalType.DATE)
    private Date adimissao;
    @Column(name = "demissao")
    @Temporal(TemporalType.DATE)
    private Date demissao;
    @Column(name = "dependente")
    private Integer dependente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bolsa")
    private Double bolsa;
    @Column(name = "valeTransporte")
    private Boolean valeTransporte;
    @Column(name = "valeCombustivel")
    private Boolean valeCombustivel;
    @Column(name = "valeAlimentacao")
    private Boolean valeAlimentacao;
    @Column(name = "valeRefeicao")
    private Boolean valeRefeicao;
    @Column(name = "valeFarmacia")
    private Boolean valeFarmacia;
    @Column(name = "planoSaude")
    private Boolean planoSaude;
    @JoinColumn(name = "idFuncionarioCargo", referencedColumnName = "idFuncionarioCargo")
    @ManyToOne(optional = false)
    private FuncionarioCargo idFuncionarioCargo;
    @JoinColumn(name = "codigoFuncionario", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private PessoaFisica pessoaFisica;
    @JoinColumn(name = "codigoEmpresa", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaJuridica codigoEmpresa;

    public Funcionario() {
    }

    public Funcionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Funcionario(Integer codigoFuncionario, Date adimissao) {
        this.codigoFuncionario = codigoFuncionario;
        this.adimissao = adimissao;
    }

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Date getAdimissao() {
        return adimissao;
    }

    public void setAdimissao(Date adimissao) {
        this.adimissao = adimissao;
    }

    public Date getDemissao() {
        return demissao;
    }

    public void setDemissao(Date demissao) {
        this.demissao = demissao;
    }

    public Integer getDependente() {
        return dependente;
    }

    public void setDependente(Integer dependente) {
        this.dependente = dependente;
    }

    public Double getBolsa() {
        return bolsa;
    }

    public void setBolsa(Double bolsa) {
        this.bolsa = bolsa;
    }

    public Boolean getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(Boolean valeTransporte) {
        this.valeTransporte = valeTransporte;
    }

    public Boolean getValeCombustivel() {
        return valeCombustivel;
    }

    public void setValeCombustivel(Boolean valeCombustivel) {
        this.valeCombustivel = valeCombustivel;
    }

    public Boolean getValeAlimentacao() {
        return valeAlimentacao;
    }

    public void setValeAlimentacao(Boolean valeAlimentacao) {
        this.valeAlimentacao = valeAlimentacao;
    }

    public Boolean getValeRefeicao() {
        return valeRefeicao;
    }

    public void setValeRefeicao(Boolean valeRefeicao) {
        this.valeRefeicao = valeRefeicao;
    }

    public Boolean getValeFarmacia() {
        return valeFarmacia;
    }

    public void setValeFarmacia(Boolean valeFarmacia) {
        this.valeFarmacia = valeFarmacia;
    }

    public Boolean getPlanoSaude() {
        return planoSaude;
    }

    public void setPlanoSaude(Boolean planoSaude) {
        this.planoSaude = planoSaude;
    }

    public FuncionarioCargo getIdFuncionarioCargo() {
        return idFuncionarioCargo;
    }

    public void setIdFuncionarioCargo(FuncionarioCargo idFuncionarioCargo) {
        this.idFuncionarioCargo = idFuncionarioCargo;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(PessoaJuridica codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoFuncionario != null ? codigoFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.codigoFuncionario == null && other.codigoFuncionario != null) || (this.codigoFuncionario != null && !this.codigoFuncionario.equals(other.codigoFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Funcionario[ codigoFuncionario=" + codigoFuncionario + " ]";
    }
    
}
