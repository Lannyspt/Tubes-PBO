/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author lannyspt
 */
public class KelompokTA {

    static int length;
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
    public Mahasiswa getAnggota(int idx){
        return anggota[idx];
    }
    
    public Mahasiswa getAnggota(String idMahasiswa){
         Mahasiswa a = null;
    for (int i = 0; i <= anggota.length; i++){
        if (anggota[i].getIdMahasiswa().equals(idMahasiswa)){
            a = anggota[i];
        } else {
            a = null;
        }
    }
    return a;
   }
                
    public void removeAnggota(int idx){
       if ((anggota.length<=idx) && (idx<0)){
           anggota[idx]=null;
           System.out.println("anggota ke "+(idx+1)+" telah dihapus");
       } else {
           System.out.println("anggota tidak dapat dihapus");
       }
   }
}
}
