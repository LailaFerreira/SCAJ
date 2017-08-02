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
@Table(name = "comarca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comarca.findAll", query = "SELECT c FROM Comarca c"),
    @NamedQuery(name = "Comarca.findByIdComarca", query = "SELECT c FROM Comarca c WHERE c.idComarca = :idComarca"),
    @NamedQuery(name = "Comarca.findByNome", query = "SELECT c FROM Comarca c WHERE c.nome = :nome"),
    @NamedQuery(name = "Comarca.findByUf", query = "SELECT c FROM Comarca c WHERE c.uf = :uf")})

public class Comarca implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idComarca")
    private Integer idComarca;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "uf")
    private String uf;
   
    public Comarca() {
    }

    public Comarca(Integer idComarca) {
        this.idComarca = idComarca;
    }

    public Comarca(Integer idComarca, String nome, String uf) {
        this.idComarca = idComarca;
        this.nome = nome;
        this.uf = uf;
    }

    public Integer getIdComarca() {
        return idComarca;
    }

    public void setIdComarca(Integer idComarca) {
        this.idComarca = idComarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComarca != null ? idComarca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comarca)) {
            return false;
        }
        Comarca other = (Comarca) object;
        if ((this.idComarca == null && other.idComarca != null) || (this.idComarca != null && !this.idComarca.equals(other.idComarca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Comarca[ idComarca=" + idComarca + " ]";
    }
    
}
