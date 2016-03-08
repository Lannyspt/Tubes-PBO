/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author Martcel
 */
public class KelompokTA {
    private String topik;
    private Mahasiswa[] anggota;
    private String namaKelompok;
    
    public KelompokTA(/*String namaKelompok,*/String topik,int n){
        //this.namaKelompok=namaKelompok;
        this.topik=topik;
        Mahasiswa[] anggota=new Mahasiswa[n];
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getNamaKelompok() {
        return namaKelompok;
    }

    public void setNamaKelompok(String namaKelompok) {
        this.namaKelompok = namaKelompok;
    }
    
    public int jumAnggota=0;
    public void addAnggota(Mahasiswa m){
        anggota[jumAnggota]=m;
    }
    
    public Mahasiswa getAnggota(int n){
        return anggota[n];
}
}
