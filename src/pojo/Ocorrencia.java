/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "ocorrencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocorrencia.findAll", query = "SELECT o FROM Ocorrencia o")
    , @NamedQuery(name = "Ocorrencia.findByCodigoOcorrencia", query = "SELECT o FROM Ocorrencia o WHERE o.codigoOcorrencia = :codigoOcorrencia")
    , @NamedQuery(name = "Ocorrencia.findByDescricao", query = "SELECT o FROM Ocorrencia o WHERE o.descricao = :descricao")
    , @NamedQuery(name = "Ocorrencia.findByResolvido", query = "SELECT o FROM Ocorrencia o WHERE o.resolvido = :resolvido")})
public class Ocorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoOcorrencia")
    private Integer codigoOcorrencia;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "resolvido")
    private Boolean resolvido;
    @JoinColumn(name = "idOcorrenciaCategoria", referencedColumnName = "idOcorrenciaCategoria")
    @ManyToOne(optional = false)
    private OcorrenciaCategoria idOcorrenciaCategoria;
    @JoinColumn(name = "codigoUsuario", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaFisica codigoUsuario;
    @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaJuridica codigoCondominio;

    public Ocorrencia() {
    }

    public Ocorrencia(Integer codigoOcorrencia) {
        this.codigoOcorrencia = codigoOcorrencia;
    }

    public Ocorrencia(Integer codigoOcorrencia, String descricao) {
        this.codigoOcorrencia = codigoOcorrencia;
        this.descricao = descricao;
    }

    public Integer getCodigoOcorrencia() {
        return codigoOcorrencia;
    }

    public void setCodigoOcorrencia(Integer codigoOcorrencia) {
        this.codigoOcorrencia = codigoOcorrencia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getResolvido() {
        return resolvido;
    }

    public void setResolvido(Boolean resolvido) {
        this.resolvido = resolvido;
    }

    public OcorrenciaCategoria getIdOcorrenciaCategoria() {
        return idOcorrenciaCategoria;
    }

    public void setIdOcorrenciaCategoria(OcorrenciaCategoria idOcorrenciaCategoria) {
        this.idOcorrenciaCategoria = idOcorrenciaCategoria;
    }

    public PessoaFisica getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(PessoaFisica codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public PessoaJuridica getCodigoCondominio() {
        return codigoCondominio;
    }

    public void setCodigoCondominio(PessoaJuridica codigoCondominio) {
        this.codigoCondominio = codigoCondominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoOcorrencia != null ? codigoOcorrencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencia)) {
            return false;
        }
        Ocorrencia other = (Ocorrencia) object;
        if ((this.codigoOcorrencia == null && other.codigoOcorrencia != null) || (this.codigoOcorrencia != null && !this.codigoOcorrencia.equals(other.codigoOcorrencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Ocorrencia[ codigoOcorrencia=" + codigoOcorrencia + " ]";
    }
    
}
