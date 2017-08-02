/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
 * @author asus note
 */
@Entity
@Table(name = "instancia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instancia.findAll", query = "SELECT i FROM Instancia i"),
    @NamedQuery(name = "Instancia.findByIdInstancia", query = "SELECT i FROM Instancia i WHERE i.idInstancia = :idInstancia"),
    @NamedQuery(name = "Instancia.findByNome", query = "SELECT i FROM Instancia i WHERE i.nome = :nome")})
public class Instancia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idInstancia")
    private Integer idInstancia;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
   

    public Instancia() {
    }

    public Instancia(Integer idInstancia) {
        this.idInstancia = idInstancia;
    }

    public Instancia(Integer idInstancia, String nome) {
        this.idInstancia = idInstancia;
        this.nome = nome;
    }

    public Integer getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(Integer idInstancia) {
        this.idInstancia = idInstancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstancia != null ? idInstancia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instancia)) {
            return false;
        }
        Instancia other = (Instancia) object;
        if ((this.idInstancia == null && other.idInstancia != null) || (this.idInstancia != null && !this.idInstancia.equals(other.idInstancia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Instancia[ idInstancia=" + idInstancia + " ]";
    }
    
}
