 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author martcelius
 */
public class Aplikasi {
    
    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    private int nDosen = 0;
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    private int nMahasiswa = 0;
    Scanner s = new Scanner(System.in);
    
    
    public void addDosen(String nama, String noHandphone, String jenisKelamin, String idDosen){
        Dosen d=new Dosen(nama,noHandphone,jenisKelamin,idDosen);
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
        return "Tidak ada idDosen tersebut";
    }
    
    public void deleteDosen(int index){
        daftarDosen.remove(index);
    }
    
    public void deleteMahasiswa(int index){
        daftarMahasiswa.remove(index);
    }
    
    public void Login(){
        System.out.println("1. DOSEN");
        System.out.println("2. MAHASISWA");
    }
    
     public void menuDosen() {
        System.out.println("====DOSEN====");
        System.out.println("1. Tambah Dosen");
        System.out.println("2. Cari Dosen");
        System.out.println("3. Hapus Dosen");
        System.out.println("4. Menu KelompokTA");
    }
     
     public void menuShowDosen() {
        for (int i = 0; i < daftarDosen.size(); i++) {
            System.out.println((i + 1) + "." + daftarDosen.get(i).getNama());
        }
    }
     
      public void menuMahasiswa() {
        System.out.println("====MAHASISWA====");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Cari Mahasiswa");
        System.out.println("3. Hapus Mahasiswa");
        System.out.println("4. Buat Tugas Akhir ");
    }
      
    //  public void menuSubMenuMahasiswa() {
      //  System.out.println("1. Tambah Tugas Akhir");
      //  System.out.println("2. ");
      //  System.out.println("3. ");
      //  System.out.println("4. Kembali ke menu utama");
  //  }
      
       public void menuTugasAkhir() {
        System.out.println("====Tugas Akhir====");
        System.out.println("1. Buat Tugas Akhir");
        System.out.println("2. Lihat Tugas Akhir");
        System.out.println("3. Revisi Judul Tugas Akhir");
        System.out.println("4. Kembali ke menu utama");

    }
       
      public void menuKelompokTA() {
        System.out.println("====KELOMPOK TA====");
        System.out.println("1. Tambah Kelompok TA");
        System.out.println("2. Lihat Kelompok TA");
        System.out.println("3. Hapus Kelompok TA");
        System.out.println("4. Kembali ke menu utama");
    }
      
      void clear() {
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }
      
      
    
    public void mainMenu () {
        System.out.println("====MENU UTAMA====");
        System.out.println("1. DOSEN");
        System.out.println("2. MAHASISWA");
        System.out.println("3. EXIT");
        int a = s.nextInt();
        switch (a) {
            case 1:
                menuDosen();
                System.out.print("Masukkan Pilihan :");
                int b = s.nextInt();
                switch (b) {
                    case 1:
                        System.out.println("Masukkan Data Dosen :");
                        System.out.print("Nama : ");
                        String nama = s.next();
                        System.out.print("No HP : ");
                        String noHandphone = s.next();
                        System.out.print("Jenis Kelamin : ");
                        String jenisKelamin = s.next();
                        System.out.print("ID Dosen  : ");
                        String idDosen=s.next();
                        addDosen(nama, noHandphone, jenisKelamin,idDosen);
                        break;
                    case 2:
                        System.out.println("Masukkan Data Dosen yang akan dicari");
                        System.out.print("ID Dosen : ");
                        String idDosenCari = s.next();
                        //menuShowDosen();
                        System.out.println("Nama Dosen : "+getDosen(idDosenCari));
                        break;
                    case 3:
                        System.out.println("Masukan urutan keberapa Dosen yang akan dihapus ");
                        System.out.println("Urutan ke- : ");
                        int index= s.nextInt();
                        deleteDosen(index);
                        System.out.println("Dosen tersebut telah di hapus");
                    case 4:
                        menuKelompokTA();
                        System.out.print("Masukkan Pilihan :");
                        int c=s.nextInt();
                        switch(c){
                            case 1:
                                System.out.println("Masukan indeks ke berapa dosen yang ingin membuat kelompok TA =");
                                int nomer=s.nextInt();
                                System.out.println("Masukan Topik kelompok TA = ");
                                String topik=s.next();
                                System.out.println("Masukan Nama kelompok = ");
                                String namaklmpk=s.next();
                                System.out.println("Masukan urutan kelompok = ");
                                int urutan = s.nextInt();
                                daftarDosen.get(nomer).createKelompokTA(topik,namaklmpk,urutan);
                                break;
                            case 2:
                                System.out.println("Cari nama Kelompok berdasarkan Topik TA = ");
                                String cariTopik=s.next();
                                System.out.println("Masukan indeks ke berapa dosen yang ingin melihat =");
                                int nomer2=s.nextInt();
                                System.out.println("Nama Kelompok adalah "+daftarDosen.get(nomer2).getKelompok(cariTopik));
                                break;
                            case 3:
                                System.out.println("Hapus kelompok berdasarkan urutan = ");
                                int hapusUrutan=s.nextInt();
                                System.out.println("Masukan indeks ke berapa dosen yang ingin menghapus =");
                                int nomer3=s.nextInt();
                                daftarDosen.get(nomer3).deleteKelompok(hapusUrutan);
                                break;
                        }
                        
                        
                }
            case 2:
                menuMahasiswa();
                System.out.print("Masukkan Pilihan :");
                int d = s.nextInt();
                switch(d){
                    case 1:
                        System.out.println("Masukkan Data Mahasiswa :");
                        System.out.print("Nama : ");
                        String nama = s.next();
                        System.out.print("No HP : ");
                        String noHandphone = s.next();
                        System.out.print("Jenis Kelamin : ");
                        String jenisKelamin = s.next();
                        System.out.print("ID Mahasiswa  : ");
                        String idMahasiswa=s.next();
                        addDosen(nama, noHandphone, jenisKelamin,idMahasiswa);
                        break;
                    case 2:
                        System.out.println("Masukkan Data Mahasiswa yang akan dicari");
                        System.out.print("ID Mahasiswa : ");
                        String idMahasiswaCari = s.next();
                        //menuShowDosen();
                        System.out.println("Nama Dosen : "+getMahasiswa(idMahasiswaCari));
                        break;
                    case 3:
                        System.out.println("Masukan urutan keberapa Mahasiswa yang akan dihapus ");
                        System.out.println("Urutan ke- : ");
                        int index= s.nextInt();
                        deleteMahasiswa(index);
                        System.out.println("Mahasiswa tersebut telah di hapus");
                        break;
                    case 4:
                        menuTugasAkhir();
                        System.out.print("Masukkan Pilihan :");
                        int e=s.nextInt();
                        switch(e){
                            case 1:
                                System.out.println("Masukan indeks ke berapa mahasiswa yang ingin membuat TugasAkhir =");
                                int nomer4=s.nextInt();
                                System.out.println("Masukan JudulTA = ");
                                String judul=s.next();
                                daftarMahasiswa.get(nomer4).createTA(judul);
                                break;
                            case 2:
                                System.out.println("Lihat judul TA ");
                                System.out.println("Masukan indeks ke berapa Mahasiswa yang ingin melihat =");
                                int nomer5=s.nextInt();
                                System.out.println("Judul TA adalah "+daftarMahasiswa.get(nomer5).getRevisiTA());
                                break;
                            case 3:
                                System.out.println("Revisi judul Tugas Akhir = ");
                                String revisiJudul=s.next();
                                System.out.println("Masukan indeks ke berapa Mahasiswa yang ingin merevisi =");
                                int nomer6=s.nextInt();
                                daftarMahasiswa.get(nomer6).revisiTA(revisiJudul);
                                break;
                        }
                }
                
        }
    }
}
                
 
    
    
   

   
    
