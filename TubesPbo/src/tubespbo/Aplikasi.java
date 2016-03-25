/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.ArrayList;

/**
 *
 * @author martcelius
 */
public class Aplikasi {
    
    ArrayList<Dosen> daftarDosen = new ArrayList<>();
    ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    
    public void addDosen(String nama, String noHandphone, String jenisKelamin, String idDosen,int n){
        Dosen d=new Dosen(nama,noHandphone,jenisKelamin,idDosen,n);
        daftarDosen.add(d);
    }

    public void addMahasiswa(String nama,String noHandphone,String jenisKelamin,String idMahasiswa){
        Mahasiswa m=new Mahasiswa(nama,noHandphone,jenisKelamin,idMahasiswa);
        daftarMahasiswa.add(m);
    }
    
    public String getMahasiswa(String idMahasiswa){
        for (int i = 0; i <= daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i) != null) {
                if (daftarMahasiswa.get(i).getIdMahasiswa()==idMahasiswa) {
                   
                    return daftarMahasiswa.get(i).getNama();
                }
            }
            //else{return "tidak ada";}
        }
        return "Tidak ada idMahasiswa tersebut";
    }
    
    public String getDosen(String idDosen){
        for (int i = 0; i <= daftarDosen.size(); i++) {
            if (daftarDosen.get(i) != null) {
                if (daftarDosen.get(i).getIdDosen() == idDosen) {
                    return daftarDosen.get(i).getNama();
                }
            }
            //else{return "tidak ada";}
        }
        return "Tidak ada idMahasiswa tersebut";
    }
    
    public void deleteDosen(Dosen d){
        daftarDosen.remove(d);
    }
    
    public void deleteMahasiswa(Mahasiswa m){
        daftarMahasiswa.remove(m);
    }
    
}
    
    
   

   
    
