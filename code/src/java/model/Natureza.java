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
@Table(name = "natureza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Natureza.findAll", query = "SELECT n FROM Natureza n"),
    @NamedQuery(name = "Natureza.findByIdNatureza", query = "SELECT n FROM Natureza n WHERE n.idNatureza = :idNatureza"),
    @NamedQuery(name = "Natureza.findByNome", query = "SELECT n FROM Natureza n WHERE n.nome = :nome")})
public class Natureza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idNatureza")
    private Integer idNatureza;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    
    public Natureza() {
    }

    public Natureza(Integer idNatureza) {
        this.idNatureza = idNatureza;
    }

    public Natureza(Integer idNatureza, String nome) {
        this.idNatureza = idNatureza;
        this.nome = nome;
    }

    public Integer getIdNatureza() {
        return idNatureza;
    }

    public void setIdNatureza(Integer idNatureza) {
        this.idNatureza = idNatureza;
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
        hash += (idNatureza != null ? idNatureza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Natureza)) {
            return false;
        }
        Natureza other = (Natureza) object;
        if ((this.idNatureza == null && other.idNatureza != null) || (this.idNatureza != null && !this.idNatureza.equals(other.idNatureza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Natureza[ idNatureza=" + idNatureza + " ]";
    }
    
}
