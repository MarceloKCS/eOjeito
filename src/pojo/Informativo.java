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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "informativo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Informativo.findAll", query = "SELECT i FROM Informativo i")
    , @NamedQuery(name = "Informativo.findByCodigoInfomativo", query = "SELECT i FROM Informativo i WHERE i.codigoInfomativo = :codigoInfomativo")
    , @NamedQuery(name = "Informativo.findByAtivo", query = "SELECT i FROM Informativo i WHERE i.ativo = :ativo")
    , @NamedQuery(name = "Informativo.findByData", query = "SELECT i FROM Informativo i WHERE i.data = :data")
    , @NamedQuery(name = "Informativo.findByTitulo", query = "SELECT i FROM Informativo i WHERE i.titulo = :titulo")
    , @NamedQuery(name = "Informativo.findBySubTitulo", query = "SELECT i FROM Informativo i WHERE i.subTitulo = :subTitulo")
    , @NamedQuery(name = "Informativo.findByTexto", query = "SELECT i FROM Informativo i WHERE i.texto = :texto")
    , @NamedQuery(name = "Informativo.findByFonte", query = "SELECT i FROM Informativo i WHERE i.fonte = :fonte")
    , @NamedQuery(name = "Informativo.findByLembrete", query = "SELECT i FROM Informativo i WHERE i.lembrete = :lembrete")
    , @NamedQuery(name = "Informativo.findByMomento", query = "SELECT i FROM Informativo i WHERE i.momento = :momento")})
public class Informativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigoInfomativo")
    private Integer codigoInfomativo;
    @Basic(optional = false)
    @Column(name = "ativo")
    private boolean ativo;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "subTitulo")
    private String subTitulo;
    @Basic(optional = false)
    @Column(name = "texto")
    private String texto;
    @Column(name = "fonte")
    private String fonte;
    @Basic(optional = false)
    @Column(name = "lembrete")
    private boolean lembrete;
    @Column(name = "momento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date momento;
    @JoinColumn(name = "idInformativoCategoria", referencedColumnName = "idInformativoCategoria")
    @ManyToOne(optional = false)
    private InformativoCategoria idInformativoCategoria;
    @JoinColumn(name = "codigoCondominio", referencedColumnName = "codigoUsuario")
    @ManyToOne(optional = false)
    private PessoaJuridica codigoCondominio;

    public Informativo() {
    }

    public Informativo(Integer codigoInfomativo) {
        this.codigoInfomativo = codigoInfomativo;
    }

    public Informativo(Integer codigoInfomativo, boolean ativo, Date data, String titulo, String texto, boolean lembrete) {
        this.codigoInfomativo = codigoInfomativo;
        this.ativo = ativo;
        this.data = data;
        this.titulo = titulo;
        this.texto = texto;
        this.lembrete = lembrete;
    }

    public Integer getCodigoInfomativo() {
        return codigoInfomativo;
    }

    public void setCodigoInfomativo(Integer codigoInfomativo) {
        this.codigoInfomativo = codigoInfomativo;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public boolean getLembrete() {
        return lembrete;
    }

    public void setLembrete(boolean lembrete) {
        this.lembrete = lembrete;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public InformativoCategoria getIdInformativoCategoria() {
        return idInformativoCategoria;
    }

    public void setIdInformativoCategoria(InformativoCategoria idInformativoCategoria) {
        this.idInformativoCategoria = idInformativoCategoria;
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
        hash += (codigoInfomativo != null ? codigoInfomativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Informativo)) {
            return false;
        }
        Informativo other = (Informativo) object;
        if ((this.codigoInfomativo == null && other.codigoInfomativo != null) || (this.codigoInfomativo != null && !this.codigoInfomativo.equals(other.codigoInfomativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Informativo[ codigoInfomativo=" + codigoInfomativo + " ]";
    }
    
}
