/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author marce
 */
@Embeddable
public class BlocoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigoBloco")
    private int codigoBloco;
    @Basic(optional = false)
    @Column(name = "codigoCondominio")
    private int codigoCondominio;

    public BlocoPK() {
    }

    public BlocoPK(int codigoBloco, int codigoCondominio) {
        this.codigoBloco = codigoBloco;
        this.codigoCondominio = codigoCondominio;
    }

    public int getCodigoBloco() {
        return codigoBloco;
    }

    public void setCodigoBloco(int codigoBloco) {
        this.codigoBloco = codigoBloco;
    }

    public int getCodigoCondominio() {
        return codigoCondominio;
    }

    public void setCodigoCondominio(int codigoCondominio) {
        this.codigoCondominio = codigoCondominio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoBloco;
        hash += (int) codigoCondominio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BlocoPK)) {
            return false;
        }
        BlocoPK other = (BlocoPK) object;
        if (this.codigoBloco != other.codigoBloco) {
            return false;
        }
        if (this.codigoCondominio != other.codigoCondominio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.BlocoPK[ codigoBloco=" + codigoBloco + ", codigoCondominio=" + codigoCondominio + " ]";
    }
    
}
