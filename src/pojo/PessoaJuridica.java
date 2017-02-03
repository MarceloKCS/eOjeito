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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "pessoajuridica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaJuridica.findAll", query = "SELECT p FROM PessoaJuridica p")
    , @NamedQuery(name = "PessoaJuridica.findByCodigoUsuario", query = "SELECT p FROM PessoaJuridica p WHERE p.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "PessoaJuridica.findByRazaoSocial", query = "SELECT p FROM PessoaJuridica p WHERE p.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "PessoaJuridica.findByNomeFantasia", query = "SELECT p FROM PessoaJuridica p WHERE p.nomeFantasia = :nomeFantasia")
    , @NamedQuery(name = "PessoaJuridica.findByCnpj", query = "SELECT p FROM PessoaJuridica p WHERE p.cnpj = :cnpj")
    , @NamedQuery(name = "PessoaJuridica.findByInscEstadual", query = "SELECT p FROM PessoaJuridica p WHERE p.inscEstadual = :inscEstadual")
    , @NamedQuery(name = "PessoaJuridica.findByInscMunicipal", query = "SELECT p FROM PessoaJuridica p WHERE p.inscMunicipal = :inscMunicipal")
    , @NamedQuery(name = "PessoaJuridica.findByAbertura", query = "SELECT p FROM PessoaJuridica p WHERE p.abertura = :abertura")})
public class PessoaJuridica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    @Basic(optional = false)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private int cnpj;
    @Basic(optional = false)
    @Column(name = "inscEstadual")
    private String inscEstadual;
    @Column(name = "inscMunicipal")
    private String inscMunicipal;
    @Column(name = "abertura")
    @Temporal(TemporalType.DATE)
    private Date abertura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaJuridica")
    private Collection<Bloco> blocoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCondominio")
    private Collection<Informativo> informativoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaJuridica")
    private Collection<AreaComum> areaComumCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEmpresa")
    private Collection<Funcionario> funcionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCondominio")
    private Collection<Movimentacao> movimentacaoCollection;
    @JoinColumn(name = "codigoResponsavel", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaFisica codigoResponsavel;
    @JoinColumn(name = "cfopEntrada", referencedColumnName = "cfop")
    @ManyToOne(optional = false)
    private TabelaCfop cfopEntrada;
    @JoinColumn(name = "cfopSaida", referencedColumnName = "cfop")
    @ManyToOne(optional = false)
    private TabelaCfop cfopSaida;
    @JoinColumn(name = "cnae", referencedColumnName = "cnae")
    @ManyToOne(optional = false)
    private TabelaCnae cnae;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCondominio")
    private Collection<Ocorrencia> ocorrenciaCollection;

    public PessoaJuridica() {
    }

    public PessoaJuridica(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public PessoaJuridica(Integer codigoUsuario, String razaoSocial, int cnpj, String inscEstadual) {
        this.codigoUsuario = codigoUsuario;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getInscMunicipal() {
        return inscMunicipal;
    }

    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    @XmlTransient
    public Collection<Bloco> getBlocoCollection() {
        return blocoCollection;
    }

    public void setBlocoCollection(Collection<Bloco> blocoCollection) {
        this.blocoCollection = blocoCollection;
    }

    @XmlTransient
    public Collection<Informativo> getInformativoCollection() {
        return informativoCollection;
    }

    public void setInformativoCollection(Collection<Informativo> informativoCollection) {
        this.informativoCollection = informativoCollection;
    }

    @XmlTransient
    public Collection<AreaComum> getAreaComumCollection() {
        return areaComumCollection;
    }

    public void setAreaComumCollection(Collection<AreaComum> areaComumCollection) {
        this.areaComumCollection = areaComumCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @XmlTransient
    public Collection<Movimentacao> getMovimentacaoCollection() {
        return movimentacaoCollection;
    }

    public void setMovimentacaoCollection(Collection<Movimentacao> movimentacaoCollection) {
        this.movimentacaoCollection = movimentacaoCollection;
    }

    public PessoaFisica getCodigoResponsavel() {
        return codigoResponsavel;
    }

    public void setCodigoResponsavel(PessoaFisica codigoResponsavel) {
        this.codigoResponsavel = codigoResponsavel;
    }

    public TabelaCfop getCfopEntrada() {
        return cfopEntrada;
    }

    public void setCfopEntrada(TabelaCfop cfopEntrada) {
        this.cfopEntrada = cfopEntrada;
    }

    public TabelaCfop getCfopSaida() {
        return cfopSaida;
    }

    public void setCfopSaida(TabelaCfop cfopSaida) {
        this.cfopSaida = cfopSaida;
    }

    public TabelaCnae getCnae() {
        return cnae;
    }

    public void setCnae(TabelaCnae cnae) {
        this.cnae = cnae;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<Ocorrencia> getOcorrenciaCollection() {
        return ocorrenciaCollection;
    }

    public void setOcorrenciaCollection(Collection<Ocorrencia> ocorrenciaCollection) {
        this.ocorrenciaCollection = ocorrenciaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoUsuario != null ? codigoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PessoaJuridica)) {
            return false;
        }
        PessoaJuridica other = (PessoaJuridica) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.PessoaJuridica[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
