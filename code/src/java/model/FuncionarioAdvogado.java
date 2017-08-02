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
@Table(name = "FuncionarioAdvogado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionarioadvogado.findAll", query = "SELECT f FROM FuncionarioAdvogado f"),
    @NamedQuery(name = "Funcionarioadvogado.findByIdFuncionarioAdvogado", query = "SELECT f FROM FuncionarioAdvogado f WHERE f.idFuncionarioAdvogado = :idFuncionarioAdvogado"),
    @NamedQuery(name = "Funcionarioadvogado.findByCarteiraOAB", query = "SELECT f FROM FuncionarioAdvogado f WHERE f.carteiraOAB = :carteiraOAB")})
public class FuncionarioAdvogado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idFuncionarioAdvogado")
    private Integer idFuncionarioAdvogado;
    @Basic(optional = false)
    @Column(name = "carteiraOAB")
    private String carteiraOAB;
  
    @JoinColumn(name = "idCargo", referencedColumnName = "idCargo")
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    private Cargo idCargo;
    @JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Pessoa idPessoa;

    public FuncionarioAdvogado() {
    }

    public FuncionarioAdvogado(Integer idFuncionarioAdvogado) {
        this.idFuncionarioAdvogado = idFuncionarioAdvogado;
    }

    public FuncionarioAdvogado(Integer idFuncionarioAdvogado, String carteiraOAB) {
        this.idFuncionarioAdvogado = idFuncionarioAdvogado;
        this.carteiraOAB = carteiraOAB;
    }

    public FuncionarioAdvogado(int idFuncionarioAdvogado, String carteiraOAB, Cargo cargo, Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdFuncionarioAdvogado() {
        return idFuncionarioAdvogado;
    }

    public void setIdFuncionarioAdvogado(Integer idFuncionarioAdvogado) {
        this.idFuncionarioAdvogado = idFuncionarioAdvogado;
    }

    public String getCarteiraOAB() {
        return carteiraOAB;
    }

    public void setCarteiraOAB(String carteiraOAB) {
        this.carteiraOAB = carteiraOAB;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
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
        hash += (idFuncionarioAdvogado != null ? idFuncionarioAdvogado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioAdvogado)) {
            return false;
        }
        FuncionarioAdvogado other = (FuncionarioAdvogado) object;
        if ((this.idFuncionarioAdvogado == null && other.idFuncionarioAdvogado != null) || (this.idFuncionarioAdvogado != null && !this.idFuncionarioAdvogado.equals(other.idFuncionarioAdvogado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FuncionarioAdvogado[ idFuncionarioAdvogado=" + idFuncionarioAdvogado + " ]";
    }

}
