/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ayam;

/**
 *
 * @author acer
 */
public class Barang extends Entity {
    private String namaBarang;
    private int stok;
    private String satuan;
    private String jenis;

    public Barang(String id, String namaBarang, int stok, String satuan, String jenis) {
        super(id);
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.satuan = satuan;
        this.jenis = jenis;
    }

    // Getter dan Setter
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id='" + id + '\'' +
                ", namaBarang='" + namaBarang + '\'' +
                ", stok=" + stok +
                ", satuan='" + satuan + '\'' +
                ", jenis='" + jenis + '\'' +
                '}';
    }
}
