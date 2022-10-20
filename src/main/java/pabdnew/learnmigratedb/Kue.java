/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pabdnew.learnmigratedb;

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

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "kue")
@NamedQueries({
    @NamedQuery(name = "Kue.findAll", query = "SELECT k FROM Kue k"),
    @NamedQuery(name = "Kue.findByKodeKue", query = "SELECT k FROM Kue k WHERE k.kodeKue = :kodeKue"),
    @NamedQuery(name = "Kue.findByNamaKue", query = "SELECT k FROM Kue k WHERE k.namaKue = :namaKue"),
    @NamedQuery(name = "Kue.findByHarga", query = "SELECT k FROM Kue k WHERE k.harga = :harga")})
public class Kue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Kode_Kue")
    private String kodeKue;
    @Basic(optional = false)
    @Column(name = "Nama_Kue")
    private String namaKue;
    @Basic(optional = false)
    @Column(name = "Harga")
    private int harga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kodeKue")
    private Collection<Transaksi> transaksiCollection;

    public Kue() {
    }

    public Kue(String kodeKue) {
        this.kodeKue = kodeKue;
    }

    public Kue(String kodeKue, String namaKue, int harga) {
        this.kodeKue = kodeKue;
        this.namaKue = namaKue;
        this.harga = harga;
    }

    public String getKodeKue() {
        return kodeKue;
    }

    public void setKodeKue(String kodeKue) {
        this.kodeKue = kodeKue;
    }

    public String getNamaKue() {
        return namaKue;
    }

    public void setNamaKue(String namaKue) {
        this.namaKue = namaKue;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public Collection<Transaksi> getTransaksiCollection() {
        return transaksiCollection;
    }

    public void setTransaksiCollection(Collection<Transaksi> transaksiCollection) {
        this.transaksiCollection = transaksiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeKue != null ? kodeKue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kue)) {
            return false;
        }
        Kue other = (Kue) object;
        if ((this.kodeKue == null && other.kodeKue != null) || (this.kodeKue != null && !this.kodeKue.equals(other.kodeKue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pabdnew.learnmigratedb.Kue[ kodeKue=" + kodeKue + " ]";
    }
    
}
