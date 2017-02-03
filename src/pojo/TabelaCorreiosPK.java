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
public class TabelaCorreiosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ibge")
    private int ibge;
    @Basic(optional = false)
    @Column(name = "cep")
    private int cep;

    public TabelaCorreiosPK() {
    }

    public TabelaCorreiosPK(int ibge, int cep) {
        this.ibge = ibge;
        this.cep = cep;
    }

    public int getIbge() {
        return ibge;
    }

    public void setIbge(int ibge) {
        this.ibge = ibge;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) ibge;
        hash += (int) cep;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TabelaCorreiosPK)) {
            return false;
        }
        TabelaCorreiosPK other = (TabelaCorreiosPK) object;
        if (this.ibge != other.ibge) {
            return false;
        }
        if (this.cep != other.cep) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.TabelaCorreiosPK[ ibge=" + ibge + ", cep=" + cep + " ]";
    }
    
}
