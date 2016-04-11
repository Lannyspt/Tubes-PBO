/*
 * To change this license header, choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.ArrayList;

/**
 *
 * @author lannyspt
 */
public class KelompokTA {

    //static int length;
    private String topik;
    private ArrayList<Mahasiswa> anggota = new ArrayList<>();
    private String namaKelompok;
    private int urutan;

    public KelompokTA(/*String namaKelompok,*/String topik, String namaKelompok,int urutan) {
        //this.namaKelompok=namaKelompok;
        this.topik = topik;
        this.namaKelompok = namaKelompok;
        this.urutan=urutan;
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
        anggota.add(m);

    }

    public String getAnggota(int idx) {
        return anggota.get(idx).getNama();
    }

    /* public String getAnggota(String idMahasiswa) {
        for (int i = 0; i <= anggota.length; i++) {
            if (anggota[i].getIdMahasiswa() == idMahasiswa) {
                return anggota[i].getNama();
            }
        }
        return "tidak ada Nim tersebut";
    }*/
    public String getAnggota(String idMahasiswa) {
        for (int i = 0; i < anggota.size(); i++) {

            if (anggota.get(i).getIdMahasiswa().equals(idMahasiswa)) {
                return anggota.get(i).getNama();
            }
            //else{return "tidak ada";}
        }
        return "Tidak ada idMahasiswa tersebut";
    }

    public ArrayList<Mahasiswa> getAnggota2() {
        return anggota;
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
    public void removeAnggota(String idMahasiswa) {
        for(int i=0;i<anggota.size();i++){
            if(anggota.get(i).getIdMahasiswa()==idMahasiswa){
                anggota.remove(i);
            }
        }
          
          
}
}
