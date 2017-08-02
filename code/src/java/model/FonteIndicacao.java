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
@Table(name = "FonteIndicacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fonteindicacao.findAll", query = "SELECT f FROM FonteIndicacao f"),
    @NamedQuery(name = "Fonteindicacao.findByIdFonteIndicacao", query = "SELECT f FROM FonteIndicacao f WHERE f.idFonteIndicacao = :idFonteIndicacao"),
    @NamedQuery(name = "Fonteindicacao.findByNome", query = "SELECT f FROM FonteIndicacao f WHERE f.nome = :nome")})
public class FonteIndicacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFonteIndicacao")
    private Integer idFonteIndicacao;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
  
    public FonteIndicacao() {
    }

    public FonteIndicacao(Integer idFonteIndicacao) {
        this.idFonteIndicacao = idFonteIndicacao;
    }

    public FonteIndicacao(Integer idFonteIndicacao, String nome) {
        this.idFonteIndicacao = idFonteIndicacao;
        this.nome = nome;
    }

    public Integer getIdFonteIndicacao() {
        return idFonteIndicacao;
    }

    public void setIdFonteIndicacao(Integer idFonteIndicacao) {
        this.idFonteIndicacao = idFonteIndicacao;
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
        hash += (idFonteIndicacao != null ? idFonteIndicacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FonteIndicacao)) {
            return false;
        }
        FonteIndicacao other = (FonteIndicacao) object;
        if ((this.idFonteIndicacao == null && other.idFonteIndicacao != null) || (this.idFonteIndicacao != null && !this.idFonteIndicacao.equals(other.idFonteIndicacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FonteIndicacao[ idFonteIndicacao=" + idFonteIndicacao + " ]";
    }
    
}
