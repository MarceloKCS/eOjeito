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
public class VisitaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigoMorador")
    private int codigoMorador;
    @Basic(optional = false)
    @Column(name = "codigoVisitante")
    private int codigoVisitante;

    public VisitaPK() {
    }

    public VisitaPK(int codigoMorador, int codigoVisitante) {
        this.codigoMorador = codigoMorador;
        this.codigoVisitante = codigoVisitante;
    }

    public int getCodigoMorador() {
        return codigoMorador;
    }

    public void setCodigoMorador(int codigoMorador) {
        this.codigoMorador = codigoMorador;
    }

    public int getCodigoVisitante() {
        return codigoVisitante;
    }

    public void setCodigoVisitante(int codigoVisitante) {
        this.codigoVisitante = codigoVisitante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoMorador;
        hash += (int) codigoVisitante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VisitaPK)) {
            return false;
        }
        VisitaPK other = (VisitaPK) object;
        if (this.codigoMorador != other.codigoMorador) {
            return false;
        }
        if (this.codigoVisitante != other.codigoVisitante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pojo.VisitaPK[ codigoMorador=" + codigoMorador + ", codigoVisitante=" + codigoVisitante + " ]";
    }
    
}
