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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marce
 */
@Entity
@Table(name = "chave")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chave.findAll", query = "SELECT c FROM Chave c")
    , @NamedQuery(name = "Chave.findByIdChave", query = "SELECT c FROM Chave c WHERE c.idChave = :idChave")
    , @NamedQuery(name = "Chave.findByTabela", query = "SELECT c FROM Chave c WHERE c.tabela = :tabela")
    , @NamedQuery(name = "Chave.findBySequencia", query = "SELECT c FROM Chave c WHERE c.sequencia = :sequencia")
    , @NamedQuery(name = "Chave.findByDisponivel", query = "SELECT c FROM Chave c WHERE c.disponivel = :disponivel")})
//public class Chave implements Serializable {
public class Chave implements EntidadeBase {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChave")
    private Integer idChave;
    @Basic(optional = false)
    @Column(name = "tabela")
    private String tabela;
    @Basic(optional = false)
    @Column(name = "sequencia")
    private int sequencia;
    @Basic(optional = false)
    @Column(name = "disponivel")
    private boolean disponivel;

    public Chave() {
    }

    public Chave(Integer idChave) {
        this.idChave = idChave;
    }

    public Chave(Integer idChave, String tabela, int sequencia, boolean disponivel) {
        this.idChave = idChave;
        this.tabela = tabela;
        this.sequencia = sequencia;
        this.disponivel = disponivel;
    }

    @Override
    public Integer getId() {
        return idChave;
    }

    public void setId(Integer idChave) {
        this.idChave = idChave;
    }

    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    public int getSequencia() {
        return sequencia;
    }

    public void setSequencia(int sequencia) {
        this.sequencia = sequencia;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChave != null ? idChave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chave)) {
            return false;
        }
        Chave other = (Chave) object;
        if ((this.idChave == null && other.idChave != null) || (this.idChave != null && !this.idChave.equals(other.idChave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.Chave[ idChave=" + idChave + " ]";
    }
    
}
