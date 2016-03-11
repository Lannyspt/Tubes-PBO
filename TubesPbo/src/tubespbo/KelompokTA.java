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

    public KelompokTA(/*String namaKelompok,*/String topik, String namaKelompok, int n) {
        //this.namaKelompok=namaKelompok;
        this.topik = topik;
        this.namaKelompok = namaKelompok;
        anggota = new Mahasiswa[n];
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

    public int jumAnggota = 0;

    public void addAnggota(Mahasiswa m) {
        if (jumAnggota < anggota.length) {
            anggota[jumAnggota] = m;
            jumAnggota++;
        }
    }

    public String getAnggota(int idx) {
        return anggota[idx].getNama();
    }

   /* public String getAnggota(String idMahasiswa) {
        for (int i = 0; i <= anggota.length; i++) {
            if (anggota[i].getIdMahasiswa() == idMahasiswa) {
                return anggota[i].getNama();
            }
        }
        return "tidak ada Nim tersebut";
    }*/
    public String getKelompok(String idMahasiswa) {
        for (int i = 0; i < anggota.length; i++) {
            if (anggota[i] != null) {
                if (anggota[i].getIdMahasiswa() == idMahasiswa) {
                    return anggota[i].getNama();
                }
            }
            //else{return "tidak ada";}
        }
        return "Tidak ada idMahasiswa tersebut";
    }

    /* public void removeAnggota(int idx){
       if ((anggota.length<=idx) && (idx<0)){
           anggota[idx]=null;
           System.out.println("anggota ke "+(idx+1)+" telah dihapus");
       } else {
           System.out.println("anggota tidak dapat dihapus");
       }
   }*/
    /*public void removeAnggota(int idx) {
        if (anggota[idx] != null) {
            for (int i = idx; i < anggota.length && anggota[idx + 1] != null; i++) {
                anggota[i] = anggota[i + 1];
                anggota[i + 1] = null;
            }
        }

    }*/
    public void removeAnggota(int idx) {
        if (anggota[idx] != null){
            if (anggota[idx+1] == null){
                anggota[idx]=null;
            }
            else{
                for(int j=idx; j<anggota.length && anggota[idx+1] != null ; j++){
                    anggota[j]=anggota[j+idx];
                    anggota[j+idx]=null;
                }
        }
    }

}
}
