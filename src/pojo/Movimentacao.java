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
@Table(name = "movimentacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimentacao.findAll", query = "SELECT m FROM Movimentacao m")
    , @NamedQuery(name = "Movimentacao.findByCodigoMovimento", query = "SELECT m FROM Movimentacao m WHERE m.codigoMovimento = :codigoMovimento")
    , @NamedQuery(name = "Movimentacao.findByDescricao", query = "SELECT m FROM Movimentacao m WHERE m.descricao = :descricao")
    , @NamedQuery(name = "Movimentacao.findByValor", query = "SELECT m FROM Movimentacao m WHERE m.valor = :valor")
    , @NamedQuery(name = "Movimentacao.findByPago", query = "SELECT m FROM Movimentacao m WHERE m.pago = :pago")})
public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoMovimento")
    private Integer codigoMovimento;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Column(name = "pago")
    private Boolean pago;
    @JoinColumn(name = "idMovimentacaoCategoria", referencedColumnName = "idMovimentacaoCategoria")
    @ManyToOne(optional = false)
    private MovimentacaoCategoria idMovimentacaoCategoria;
    @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaJuridica codigoCondominio;

    public Movimentacao() {
    }

    public Movimentacao(Integer codigoMovimento) {
        this.codigoMovimento = codigoMovimento;
    }

    public Movimentacao(Integer codigoMovimento, String descricao, double valor) {
        this.codigoMovimento = codigoMovimento;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getCodigoMovimento() {
        return codigoMovimento;
    }

    public void setCodigoMovimento(Integer codigoMovimento) {
        this.codigoMovimento = codigoMovimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public MovimentacaoCategoria getIdMovimentacaoCategoria() {
        return idMovimentacaoCategoria;
    }

    public void setIdMovimentacaoCategoria(MovimentacaoCategoria idMovimentacaoCategoria) {
        this.idMovimentacaoCategoria = idMovimentacaoCategoria;
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
        hash += (codigoMovimento != null ? codigoMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimentacao)) {
            return false;
        }
        Movimentacao other = (Movimentacao) object;
        if ((this.codigoMovimento == null && other.codigoMovimento != null) || (this.codigoMovimento != null && !this.codigoMovimento.equals(other.codigoMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Movimentacao[ codigoMovimento=" + codigoMovimento + " ]";
    }
    
}
