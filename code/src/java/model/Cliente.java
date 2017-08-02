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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByCarteiraNit", query = "SELECT c FROM Cliente c WHERE c.carteiraNit = :carteiraNit"),
    @NamedQuery(name = "Cliente.findByProfissao", query = "SELECT c FROM Cliente c WHERE c.profissao = :profissao"),
    @NamedQuery(name = "Cliente.findByEstadoCivil", query = "SELECT c FROM Cliente c WHERE c.estadoCivil = :estadoCivil")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "carteiraNit")
    private String carteiraNit;
    @Basic(optional = false)
    @Column(name = "profissao")
    private String profissao;
    @Basic(optional = false)
    @Column(name = "estadoCivil")
    private String estadoCivil;
    @JoinColumn(name = "idFonteIndicacao", referencedColumnName = "idFonteIndicacao")
    @ManyToOne(optional = false)
    private FonteIndicacao idFonteIndicacao;
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne(optional = false)
    private Pessoa idPessoa;
    
    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String carteiraNit, String profissao, String estadoCivil) {
        this.idCliente = idCliente;
        this.carteiraNit = carteiraNit;
        this.profissao = profissao;
        this.estadoCivil = estadoCivil;
    }

    public Cliente(int idCliente, String carteiraNit, String profissao, String estadoCivil, FonteIndicacao fonteIndicacao, Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getCarteiraNit() {
        return carteiraNit;
    }

    public void setCarteiraNit(String carteiraNit) {
        this.carteiraNit = carteiraNit;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public FonteIndicacao getIdFonteIndicacao() {
        return idFonteIndicacao;
    }

    public void setIdFonteIndicacao(FonteIndicacao idFonteIndicacao) {
        this.idFonteIndicacao = idFonteIndicacao;
    }

    public Pessoa getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Pessoa idPessoa) {
        this.idPessoa = idPessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
