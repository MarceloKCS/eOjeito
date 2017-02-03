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
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "funcionariocargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioCargo.findAll", query = "SELECT f FROM FuncionarioCargo f")
    , @NamedQuery(name = "FuncionarioCargo.findByIdFuncionarioCargo", query = "SELECT f FROM FuncionarioCargo f WHERE f.idFuncionarioCargo = :idFuncionarioCargo")
    , @NamedQuery(name = "FuncionarioCargo.findByNome", query = "SELECT f FROM FuncionarioCargo f WHERE f.nome = :nome")
    , @NamedQuery(name = "FuncionarioCargo.findByRemuneracao", query = "SELECT f FROM FuncionarioCargo f WHERE f.remuneracao = :remuneracao")
    , @NamedQuery(name = "FuncionarioCargo.findByFormacao", query = "SELECT f FROM FuncionarioCargo f WHERE f.formacao = :formacao")
    , @NamedQuery(name = "FuncionarioCargo.findByDescricao", query = "SELECT f FROM FuncionarioCargo f WHERE f.descricao = :descricao")})
public class FuncionarioCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFuncionarioCargo")
    private Integer idFuncionarioCargo;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "remuneracao")
    private double remuneracao;
    @Basic(optional = false)
    @Column(name = "formacao")
    private String formacao;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionarioCargo")
    private Collection<Funcionario> funcionarioCollection;

    public FuncionarioCargo() {
    }

    public FuncionarioCargo(Integer idFuncionarioCargo) {
        this.idFuncionarioCargo = idFuncionarioCargo;
    }

    public FuncionarioCargo(Integer idFuncionarioCargo, String nome, double remuneracao, String formacao) {
        this.idFuncionarioCargo = idFuncionarioCargo;
        this.nome = nome;
        this.remuneracao = remuneracao;
        this.formacao = formacao;
    }

    public Integer getIdFuncionarioCargo() {
        return idFuncionarioCargo;
    }

    public void setIdFuncionarioCargo(Integer idFuncionarioCargo) {
        this.idFuncionarioCargo = idFuncionarioCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionarioCargo != null ? idFuncionarioCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioCargo)) {
            return false;
        }
        FuncionarioCargo other = (FuncionarioCargo) object;
        if ((this.idFuncionarioCargo == null && other.idFuncionarioCargo != null) || (this.idFuncionarioCargo != null && !this.idFuncionarioCargo.equals(other.idFuncionarioCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.FuncionarioCargo[ idFuncionarioCargo=" + idFuncionarioCargo + " ]";
    }
    
}
