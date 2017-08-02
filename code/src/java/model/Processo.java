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
@Table(name = "processo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Processo.findAll", query = "SELECT p FROM Processo p"),
    @NamedQuery(name = "Processo.findByIdProcesso", query = "SELECT p FROM Processo p WHERE p.idProcesso = :idProcesso"),
    @NamedQuery(name = "Processo.findByNumeroProcesso", query = "SELECT p FROM Processo p WHERE p.numeroProcesso = :numeroProcesso"),
    @NamedQuery(name = "Processo.findByDataEntrada", query = "SELECT p FROM Processo p WHERE p.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Processo.findBySituacao", query = "SELECT p FROM Processo p WHERE p.situacao = :situacao")})
public class Processo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idProcesso")
    private Integer idProcesso;
    @Basic(optional = false)
    @Column(name = "numeroProcesso")
    private String numeroProcesso;
    @Basic(optional = false)
    @Column(name = "dataEntrada")
    private String dataEntrada;
    @Basic(optional = false)
    @Column(name = "situacao")
    private String situacao;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idComarca", referencedColumnName = "idComarca")
    @ManyToOne(optional = false)
    private Comarca idComarca;
    @JoinColumn(name = "idFuncionarioAdvogado", referencedColumnName = "idFuncionarioAdvogado")
    @ManyToOne(optional = false)
    private FuncionarioAdvogado idFuncionarioAdvogado;
    @JoinColumn(name = "idInstancia", referencedColumnName = "idInstancia")
    @ManyToOne(optional = false)
    private Instancia idInstancia;
    @JoinColumn(name = "idNatureza", referencedColumnName = "idNatureza")
    @ManyToOne(optional = false)
    private Natureza idNatureza;
    @JoinColumn(name = "idVara", referencedColumnName = "idVara")
    @ManyToOne(optional = false)
    private Vara idVara;
   

    public Processo() {
    }

    public Processo(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public Processo(Integer idProcesso, String numeroProcesso, String dataEntrada, String situacao) {
        this.idProcesso = idProcesso;
        this.numeroProcesso = numeroProcesso;
        this.dataEntrada = dataEntrada;
        this.situacao = situacao;
    }

    public Processo(int parseInt, Object object, Object object0, Object object1, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Comarca getIdComarca() {
        return idComarca;
    }

    public void setIdComarca(Comarca idComarca) {
        this.idComarca = idComarca;
    }

    public FuncionarioAdvogado getIdFuncionarioAdvogado() {
        return idFuncionarioAdvogado;
    }

    public void setIdFuncionarioAdvogado(FuncionarioAdvogado idFuncionarioAdvogado) {
        this.idFuncionarioAdvogado = idFuncionarioAdvogado;
    }

    public Instancia getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(Instancia idInstancia) {
        this.idInstancia = idInstancia;
    }

    public Natureza getIdNatureza() {
        return idNatureza;
    }

    public void setIdNatureza(Natureza idNatureza) {
        this.idNatureza = idNatureza;
    }

    public Vara getIdVara() {
        return idVara;
    }

    public void setIdVara(Vara idVara) {
        this.idVara = idVara;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesso != null ? idProcesso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Processo)) {
            return false;
        }
        Processo other = (Processo) object;
        if ((this.idProcesso == null && other.idProcesso != null) || (this.idProcesso != null && !this.idProcesso.equals(other.idProcesso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Processo[ idProcesso=" + idProcesso + " ]";
    }
    
}
