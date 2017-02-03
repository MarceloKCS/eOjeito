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
public class AreaComumPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigoArea")
    private int codigoArea;
    @Basic(optional = false)
    @Column(name = "codigoCondominio")
    private int codigoCondominio;

    public AreaComumPK() {
    }

    public AreaComumPK(int codigoArea, int codigoCondominio) {
        this.codigoArea = codigoArea;
        this.codigoCondominio = codigoCondominio;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
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
        hash += (int) codigoArea;
        hash += (int) codigoCondominio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaComumPK)) {
            return false;
        }
        AreaComumPK other = (AreaComumPK) object;
        if (this.codigoArea != other.codigoArea) {
            return false;
        }
        if (this.codigoCondominio != other.codigoCondominio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.AreaComumPK[ codigoArea=" + codigoArea + ", codigoCondominio=" + codigoCondominio + " ]";
    }
    
}
