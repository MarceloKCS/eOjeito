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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "pessoafisica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p")
    , @NamedQuery(name = "PessoaFisica.findByCodigoUsuario", query = "SELECT p FROM PessoaFisica p WHERE p.codigoUsuario = :codigoUsuario")
    , @NamedQuery(name = "PessoaFisica.findByNome", query = "SELECT p FROM PessoaFisica p WHERE p.nome = :nome")
    , @NamedQuery(name = "PessoaFisica.findByApelido", query = "SELECT p FROM PessoaFisica p WHERE p.apelido = :apelido")
    , @NamedQuery(name = "PessoaFisica.findByCpf", query = "SELECT p FROM PessoaFisica p WHERE p.cpf = :cpf")
    , @NamedQuery(name = "PessoaFisica.findByRg", query = "SELECT p FROM PessoaFisica p WHERE p.rg = :rg")
    , @NamedQuery(name = "PessoaFisica.findByEstadoCivil", query = "SELECT p FROM PessoaFisica p WHERE p.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "PessoaFisica.findByFormacao", query = "SELECT p FROM PessoaFisica p WHERE p.formacao = :formacao")
    , @NamedQuery(name = "PessoaFisica.findByNascimento", query = "SELECT p FROM PessoaFisica p WHERE p.nascimento = :nascimento")})
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoUsuario")
    private Integer codigoUsuario;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "apelido")
    private String apelido;
    @Basic(optional = false)
    @Column(name = "cpf")
    private int cpf;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @Column(name = "formacao")
    private String formacao;
    @Basic(optional = false)
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @JoinTable(name = "reservaconvidado", joinColumns = {
        @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario")}, inverseJoinColumns = {
        @JoinColumn(name = "codigoReserva", referencedColumnName = "codigoReserva")})
    @ManyToMany
    private Collection<Reserva> reservaCollection;
    @ManyToMany(mappedBy = "pessoaFisicaCollection")
    private Collection<Apartamento> apartamentoCollection;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Usuario usuario;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
    private Funcionario funcionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuario")
    private Collection<Reserva> reservaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaFisica")
    private Collection<Visita> visitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaFisica1")
    private Collection<Visita> visitaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoResponsavel")
    private Collection<PessoaJuridica> pessoaJuridicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoUsuario")
    private Collection<Ocorrencia> ocorrenciaCollection;

    public PessoaFisica() {
    }

    public PessoaFisica(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public PessoaFisica(Integer codigoUsuario, String nome, int cpf, String rg, String estadoCivil, Date nascimento) {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.estadoCivil = estadoCivil;
        this.nascimento = nascimento;
    }

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    @XmlTransient
    public Collection<Apartamento> getApartamentoCollection() {
        return apartamentoCollection;
    }

    public void setApartamentoCollection(Collection<Apartamento> apartamentoCollection) {
        this.apartamentoCollection = apartamentoCollection;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection1() {
        return reservaCollection1;
    }

    public void setReservaCollection1(Collection<Reserva> reservaCollection1) {
        this.reservaCollection1 = reservaCollection1;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(Collection<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    @XmlTransient
    public Collection<Visita> getVisitaCollection1() {
        return visitaCollection1;
    }

    public void setVisitaCollection1(Collection<Visita> visitaCollection1) {
        this.visitaCollection1 = visitaCollection1;
    }

    @XmlTransient
    public Collection<PessoaJuridica> getPessoaJuridicaCollection() {
        return pessoaJuridicaCollection;
    }

    public void setPessoaJuridicaCollection(Collection<PessoaJuridica> pessoaJuridicaCollection) {
        this.pessoaJuridicaCollection = pessoaJuridicaCollection;
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
        if (!(object instanceof PessoaFisica)) {
            return false;
        }
        PessoaFisica other = (PessoaFisica) object;
        if ((this.codigoUsuario == null && other.codigoUsuario != null) || (this.codigoUsuario != null && !this.codigoUsuario.equals(other.codigoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.PessoaFisica[ codigoUsuario=" + codigoUsuario + " ]";
    }
    
}
