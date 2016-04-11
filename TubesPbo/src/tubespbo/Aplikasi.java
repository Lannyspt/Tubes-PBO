/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.*;

/**
 *
 * @author martcelius
 */
public class Aplikasi {

    private ArrayList<Dosen> daftarDosen = new ArrayList<>();
    //private int nDosen = 0;
    private ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
    //private int nMahasiswa = 0;
    Scanner s = new Scanner(System.in);
    String pil, pil1, pil2, pil3, pil4;
    Dosen d2;

    public void addDosen(String nama, String noHandphone, String jenisKelamin, String idDosen) {
        Dosen d = new Dosen(nama, noHandphone, jenisKelamin, idDosen);
        daftarDosen.add(d);
    }

    public void addMahasiswa(String nama, String noHandphone, String jenisKelamin, String idMahasiswa) {
        Mahasiswa m = new Mahasiswa(nama, noHandphone, jenisKelamin, idMahasiswa);
        daftarMahasiswa.add(m);
    }

    public Mahasiswa getMahasiswa(String idMahasiswa) {
        for (int i = 0; i <= daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i) != null) {
                if (daftarMahasiswa.get(i).getIdMahasiswa().equals(idMahasiswa)) {

                    return daftarMahasiswa.get(i);
                }
            }
            //else{return "tidak ada";}
        }
        return null;
    }

    public Dosen getDosen(String idDosen) {
        for (int i = 0; i < daftarDosen.size(); i++) {

            if (daftarDosen.get(i).getIdDosen().equals(idDosen)) {
                return daftarDosen.get(i);
            }

            //else{return "tidak ada";}
        }
        return null;
    }

    public void deleteDosen(String idDosen) {
        for (int i = 0; i < daftarDosen.size(); i++) {
            if (daftarDosen.get(i).getIdDosen().equals(idDosen)) {
                daftarDosen.remove(i);
    }
        }
    }

    public void deleteMahasiswa(String idMahasiswa) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getIdMahasiswa().equals(idMahasiswa)) {
                daftarMahasiswa.remove(i);
            }
        }
    }

    

    public void Login() {
        System.out.println("1. DOSEN");
        System.out.println("2. MAHASISWA");
    }

    public void displayDosen() {
        for (int i = 0; i < daftarDosen.size(); i++) {
            System.out.println(i + 1 + ".Nama Dosen :  " + daftarDosen.get(i).getNama());
            System.out.println("Nomer Handphone : " + daftarDosen.get(i).getNoHandphone());
            System.out.println("Jenis Kelamin   : " + daftarDosen.get(i).getJenisKelamin());
            System.out.println("ID Dosen        : " + daftarDosen.get(i).getIdDosen());
        }
    }
    
    public void displayMahasiswa() {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            System.out.println(i + 1 + ".Nama Dosen :  " + daftarMahasiswa.get(i).getNama());
            System.out.println("Nomer Handphone : " + daftarMahasiswa.get(i).getNoHandphone());
            System.out.println("Jenis Kelamin   : " + daftarMahasiswa.get(i).getJenisKelamin());
            System.out.println("ID Dosen        : " + daftarMahasiswa.get(i).getIdMahasiswa());
        }
    }

    public void menuTugasAkhir() {
        System.out.println("========================");
        System.out.println("Tugas Akhir");
        System.out.println("1. Buat Tugas Akhir");
        System.out.println("2. Lihat Tugas Akhir");
        System.out.println("3. Revisi Judul Tugas Akhir");
        System.out.println("4. Kembali ke menu utama");
        System.out.println("==============================");
        System.out.print("Pilihan ");
        int b = s.nextInt();
        switch (b) {
            case 1:
                System.out.println("Masukan idMahasiswa mahasiswa yang ingin membuat TugasAkhir =");
                String nomer4 = s.next();
                System.out.println("Masukan JudulTA = ");
                String judul = s.next();
                getMahasiswa(nomer4).createTA(judul);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p12 = s.next();
                menuTugasAkhir();
                break;
            case 2:
                System.out.println("Masukan Id Mahasiswa yang ingin melihat judul TA=");
                String nomer5 = s.next();
                System.out.println("Lihat judul TA ");
                System.out.println("Judul TA adalah " + getMahasiswa(nomer5).getRevisiTA());
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p11 = s.next();
                menuTugasAkhir();
                break;
            case 3:
                System.out.println("Revisi judul Tugas Akhir = ");
                String revisiJudul = s.next();
                System.out.println("Masukan idMahasiswa yang ingin merevisi Judul =");
                String nomer6 = s.next();
                getMahasiswa(nomer6).revisiTA(revisiJudul);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p10 = s.next();
                menuTugasAkhir();
                break;
            case 4:
                mainMenu();
                break;

        }
    }

    public void menuKelompokTA() {
        System.out.println("======================");
        System.out.println("KELOMPOK TA");
        System.out.println("1. Buat Kelompok TA");
        System.out.println("2. Lihat Kelompok TA");
        System.out.println("3. Hapus Kelompok TA");
        System.out.println("4. Tambah Anggota");
        System.out.println("5. Kembali ke menu Utama");
        System.out.println("===========================");
        System.out.println("Pilihan : ");
        int b = s.nextInt();
        switch (b) {
            case 1:
                System.out.println("Masukan IdDosen yang ingin membuat kelompok TA =");
                String id = s.next();
                System.out.println("Masukan Topik kelompok TA = ");
                String topik = s.next();
                System.out.println("Masukan Nama kelompok = ");
                String namaklmpk = s.next();
                System.out.println("Masukan urutan kelompok = ");
                int urutan = s.nextInt();
                int i;
                Dosen d1 = null;
                for (i = 0; i < daftarDosen.size(); i++) {
                    if (daftarDosen.get(i).getIdDosen().equals(id)) {
                        d1 = daftarDosen.get(i);
                    }
                }
                d1.createKelompokTA(topik, namaklmpk, urutan);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p10 = s.next();
                menuKelompokTA();
                break;
            case 2:
                System.out.println("Cari nama Kelompok berdasarkan Topik TA = ");
                String cariTopik = s.next();
                System.out.println("Masukan id dosen yang ingin melihat =");
                String nomer2 = s.next();
                Dosen d4 = null;
                for (i = 0; i < daftarDosen.size(); i++) {
                    if (daftarDosen.get(i).getIdDosen().equals(nomer2)) {
                        d4 = daftarDosen.get(i);
                    }
                }
                //try{

                System.out.println("Nama Kelompok adalah " + d4.getKelompok(cariTopik).getTopik());
                System.out.println("Nama Anggota: ");
                for (i = 0; i < d4.getKelompok(cariTopik).getAnggota2().size(); i++) {
                    System.out.println((i + 1) + " " + d4.getKelompok(cariTopik).getAnggota(i));
                }
                //} catch(Exception e){
                //  System.out.println("Object not Found");
                //} 
                //System.out.println(d4.getKelompok(cariTopik).getAnggota(i));
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p9 = s.next();
                menuKelompokTA();
                break;
            case 3:
                System.out.println("Hapus kelompok berdasarkan urutan = ");
                int hapusUrutan = s.nextInt();
                System.out.println("Masukan Id Dosen yang ingin menghapus =");
                String nomer3 = s.next();
                getDosen(nomer3).deleteKelompok(hapusUrutan);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p8 = s.next();
                menuKelompokTA();
                break;
            case 4:
                System.out.println("Tambah kan anggota ke salah satu Topik pilihan");
                System.out.println("Pilih topik : ");
                String pilihTopik = s.next();
                System.out.println("Masukan id  dosen yang akan menambahkan anggota = ");
                String id2 = s.next();
                System.out.println("Masukan Id mahasiswa yang ingin di tambahakan");
                String indeks = s.next();
                Dosen d3 = null;
                for (i = 0; i < daftarDosen.size(); i++) {
                    if (daftarDosen.get(i).getIdDosen().equals(id2)) {
                        d3 = daftarDosen.get(i);
                    }
                }
                KelompokTA dataKelompok = d3.getKelompok(pilihTopik);
                Mahasiswa mhs = getMahasiswa(indeks);
                System.out.print("Menjadi pembimbing 1 atau 2 :");
                int tt = s.nextInt();
                mhs.getTugasAkhir().setPembimbing(d3,tt-1);
                dataKelompok.addAnggota(mhs);

                //getDosen(nomer4).getKelompok(pilihTopik).addAnggota(daftarMahasiswa.get(indeks));
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p7 = s.next();
                menuKelompokTA();
                break;
            case 5:
                mainMenu();
                break;

        }
    }

    public void menuDosen() {
        System.out.println("=====================");
        System.out.println("Menu Dosen");
        System.out.println("1. Tambah Dosen");
        System.out.println("2. Lihat Daftar Dosen");
        System.out.println("3. Hapus Dosen");
        System.out.println("4. Kembali ke menu Utama");
        System.out.println("=======================");
        System.out.print("Pilihan : ");
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
                String idDosen = s.next();
                addDosen(nama, noHandphone, jenisKelamin, idDosen);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p = s.next();
                /*if (p=="Y" && p=="y"){
                    menuDosen();
                    break;
                }*/
                menuDosen();
                break;
            case 2:
                /*System.out.println("Masukkan Data Dosen yang akan dicari");
                        System.out.print("ID Dosen : ");
                        String idDosenCari = s.next();
                        //menuShowDosen();
                        System.out.println("Nama Dosen : "+getDosen(idDosenCari));*/
                displayDosen();
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p2 = s.next();
                menuDosen();
                break;
            case 3:
                System.out.println("Masukan id Dosen yang akan dihapus ");
                //System.out.println("Urutan ke- : ");
                String index = s.next();
                deleteDosen(index);
                System.out.println("Dosen tersebut telah di hapus");
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p3 = s.next();
                menuDosen();
                break;
            case 4:
                mainMenu();
                break;

        }
    }

    public void menuMahasiswa() {
        System.out.println("===========================");
        System.out.println("Menu Mahasiswa");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Lihat Daftar Mahasiswa");
        System.out.println("3. Hapus Mahasiswa");
        System.out.println("4. Kembali ke menu Utama");
        System.out.println("=============================");
        System.out.print("Pilihan : ");
        int b = s.nextInt();
        switch (b) {
            case 1:
                System.out.println("Masukkan Data Mahasiswa :");
                System.out.print("Nama : ");
                String nama = s.next();
                System.out.print("No HP : ");
                String noHandphone = s.next();
                System.out.print("Jenis Kelamin : ");
                String jenisKelamin = s.next();
                System.out.print("ID Mahasiswa  : ");
                String idMahasiswa = s.next();
                addMahasiswa(nama, noHandphone, jenisKelamin, idMahasiswa);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p4 = s.next();
                menuMahasiswa();
                break;
            case 2:
               // System.out.println("Masukkan Data Mahasiswa yang akan dicari");
                //System.out.print("ID Mahasiswa : ");
                //String idMahasiswaCari = s.next();
                //menuShowDosen();
                //System.out.println("Nama Mahasiswa : " + getMahasiswa(idMahasiswaCari).getNama());
                displayMahasiswa();
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p5 = s.next();
                menuMahasiswa();
                break;
            case 3:
                System.out.println("Masukan Id Mahasiswa yang akan dihapus ");
                //System.out.println("Urutan ke- : ");
                String idMahasiswa2 = s.next();
                System.out.println("Masukkan Topik TA = ");
                String cariTopik2 = s.next();
                System.out.println("Masukan id dosen pembimbing  =");
                String nomer3 = s.next();
                Dosen d5 = null;
                for (int i = 0; i < daftarDosen.size(); i++) {
                    if (daftarDosen.get(i).getIdDosen().equals(nomer3)) {
                        d5 = daftarDosen.get(i);
                    }
                }
                //try{

                //KelompokTA temp= d5.getKelompok(cariTopik2);
                deleteMahasiswa(idMahasiswa2);
                for (int i = 0; i < d5.getKelompok(cariTopik2).getAnggota2().size(); i++) {
                    if ((d5.getKelompok(cariTopik2).getAnggota2().get(i).getIdMahasiswa()).equals(idMahasiswa2)) {
                        //d5 = daftarDosen.get(i);
                        d5.getKelompok(cariTopik2).getAnggota2().remove(i);
                    }
                }
                
                System.out.println("Mahasiswa tersebut telah di hapus");
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p6 = s.next();
                menuMahasiswa();
                break;
            case 4:
                mainMenu();
                break;

        }
    }

    void clear() {
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
    }

    public void mainMenu() {
        {
            System.out.println("====MENU UTAMA====");
            System.out.println("1. DOSEN");
            System.out.println("2. MAHASISWA");
            System.out.println("3. EXIT");
            System.out.print("Pilihan : ");
            int a = s.nextInt();
            switch (a) {
                case 1:
                    System.out.println("1.Dosen ");
                    System.out.println("2.KelompokTA ");
                    System.out.println("Pilihan :");
                    int aa = s.nextInt();
                    switch (aa) {
                        case 1:
                            menuDosen();
                            break;
                        case 2:
                            menuKelompokTA();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1.Mahasiswa ");
                    System.out.println("2.Tugas Akhir ");
                    System.out.println("Pilihan :");
                    int aaa = s.nextInt();
                    switch (aaa) {
                        case 1:
                            menuMahasiswa();
                            break;
                        case 2:
                            menuTugasAkhir();
                            break;
                    }
            }

        }

    }
}
