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
@Table(name = "vara")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vara.findAll", query = "SELECT v FROM Vara v"),
    @NamedQuery(name = "Vara.findByIdVara", query = "SELECT v FROM Vara v WHERE v.idVara = :idVara"),
    @NamedQuery(name = "Vara.findByNome", query = "SELECT v FROM Vara v WHERE v.nome = :nome")})
public class Vara implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVara")
    private Integer idVara;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    

    public Vara() {
    }

    public Vara(Integer idVara) {
        this.idVara = idVara;
    }

    public Vara(Integer idVara, String nome) {
        this.idVara = idVara;
        this.nome = nome;
    }

    public Integer getIdVara() {
        return idVara;
    }

    public void setIdVara(Integer idVara) {
        this.idVara = idVara;
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
        hash += (idVara != null ? idVara.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vara)) {
            return false;
        }
        Vara other = (Vara) object;
        if ((this.idVara == null && other.idVara != null) || (this.idVara != null && !this.idVara.equals(other.idVara))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Vara[ idVara=" + idVara + " ]";
    }
    
}
