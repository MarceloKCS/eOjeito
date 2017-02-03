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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario")
    , @NamedQuery(name = "Usuario.findByCodigoUsuario", query = "SELECT u FROM Usuario u WHERE u.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "Usuario.findByInativo", query = "SELECT u FROM Usuario u WHERE u.inativo = :inativo")
    , @NamedQuery(name = "Usuario.findByCadastro", query = "SELECT u FROM Usuario u WHERE u.cadastro = :cadastro")
    , @NamedQuery(name = "Usuario.findByCondominio", query = "SELECT u FROM Usuario u WHERE u.condominio = :condominio")
    , @NamedQuery(name = "Usuario.findByFornecedor", query = "SELECT u FROM Usuario u WHERE u.fornecedor = :fornecedor")
    , @NamedQuery(name = "Usuario.findByTerceirizado", query = "SELECT u FROM Usuario u WHERE u.terceirizado = :terceirizado")
    , @NamedQuery(name = "Usuario.findByPrestadorServico", query = "SELECT u FROM Usuario u WHERE u.prestadorServico = :prestadorServico")
    , @NamedQuery(name = "Usuario.findByProprietario", query = "SELECT u FROM Usuario u WHERE u.proprietario = :proprietario")
    , @NamedQuery(name = "Usuario.findByInquilino", query = "SELECT u FROM Usuario u WHERE u.inquilino = :inquilino")
    , @NamedQuery(name = "Usuario.findByFuncionario", query = "SELECT u FROM Usuario u WHERE u.funcionario = :funcionario")
    , @NamedQuery(name = "Usuario.findByMorador", query = "SELECT u FROM Usuario u WHERE u.morador = :morador")
    , @NamedQuery(name = "Usuario.findByVisitante", query = "SELECT u FROM Usuario u WHERE u.visitante = :visitante")
    , @NamedQuery(name = "Usuario.findByResponsavel", query = "SELECT u FROM Usuario u WHERE u.responsavel = :responsavel")
    , @NamedQuery(name = "Usuario.findByDependente", query = "SELECT u FROM Usuario u WHERE u.dependente = :dependente")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private int idUsuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    @Column(name = "inativo")
    private Boolean inativo;
    @Basic(optional = false)
    @Column(name = "cadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cadastro;
    @Column(name = "condominio")
    private Boolean condominio;
    @Column(name = "fornecedor")
    private Boolean fornecedor;
    @Column(name = "terceirizado")
    private Boolean terceirizado;
    @Column(name = "prestadorServico")
    private Boolean prestadorServico;
    @Column(name = "proprietario")
    private Boolean proprietario;
    @Column(name = "inquilino")
    private Boolean inquilino;
    @Column(name = "funcionario")
    private Boolean funcionario;
    @Column(name = "morador")
    private Boolean morador;
    @Column(name = "visitante")
    private Boolean visitante;
    @Column(name = "responsavel")
    private Boolean responsavel;
    @Column(name = "dependente")
    private Boolean dependente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private PessoaFisica pessoaFisica;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario1")
    private Validacao validacao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Contato contato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuario")
    private Collection<Veiculo> veiculoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoProprietario")
    private Collection<Apartamento> apartamentoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Endereco endereco;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario")
    private PessoaJuridica pessoaJuridica;

    public Usuario() {
    }

    public Usuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Usuario(Integer codigoUsuario, int idUsuario, Date cadastro) {
        this.codigoUsuario = codigoUsuario;
        this.idUsuario = idUsuario;
        this.cadastro = cadastro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Boolean getCondominio() {
        return condominio;
    }

    public void setCondominio(Boolean condominio) {
        this.condominio = condominio;
    }

    public Boolean getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Boolean fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Boolean getTerceirizado() {
        return terceirizado;
    }

    public void setTerceirizado(Boolean terceirizado) {
        this.terceirizado = terceirizado;
    }

    public Boolean getPrestadorServico() {
        return prestadorServico;
    }

    public void setPrestadorServico(Boolean prestadorServico) {
        this.prestadorServico = prestadorServico;
    }

    public Boolean getProprietario() {
        return proprietario;
    }

    public void setProprietario(Boolean proprietario) {
        this.proprietario = proprietario;
    }

    public Boolean getInquilino() {
        return inquilino;
    }

    public void setInquilino(Boolean inquilino) {
        this.inquilino = inquilino;
    }

    public Boolean getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }

    public Boolean getMorador() {
        return morador;
    }

    public void setMorador(Boolean morador) {
        this.morador = morador;
    }

    public Boolean getVisitante() {
        return visitante;
    }

    public void setVisitante(Boolean visitante) {
        this.visitante = visitante;
    }

    public Boolean getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Boolean responsavel) {
        this.responsavel = responsavel;
    }

    public Boolean getDependente() {
        return dependente;
    }

    public void setDependente(Boolean dependente) {
        this.dependente = dependente;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Validacao getValidacao() {
        return validacao;
    }

    public void setValidacao(Validacao validacao) {
        this.validacao = validacao;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    @XmlTransient
    public Collection<Veiculo> getVeiculoCollection() {
        return veiculoCollection;
    }

    public void setVeiculoCollection(Collection<Veiculo> veiculoCollection) {
        this.veiculoCollection = veiculoCollection;
    }

    @XmlTransient
    public Collection<Apartamento> getApartamentoCollection() {
        return apartamentoCollection;
    }

    public void setApartamentoCollection(Collection<Apartamento> apartamentoCollection) {
        this.apartamentoCollection = apartamentoCollection;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Usuario[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
