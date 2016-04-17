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

    private ArrayList<Dosen> daftarDosen;
    private ArrayList<Mahasiswa> daftarMahasiswa;
    Scanner s = new Scanner(System.in);

    public Aplikasi() {
        daftarDosen =new  ArrayList<>();
        daftarMahasiswa = new ArrayList<>();
    }
    
    

     public ArrayList<Dosen> getAll()
    {
        return daftarDosen;
    }
      public ArrayList<Mahasiswa> getAll2()
    {
        return daftarMahasiswa;
    }

    
      
      
    public void addDosen(String nama, String noHandphone, String jenisKelamin, String idDosen) {
        Dosen d = new Dosen(nama, noHandphone, jenisKelamin, idDosen);
        daftarDosen.add(d);
    }

    public void addMahasiswa(String nama, String noHandphone, String jenisKelamin, String idMahasiswa) {
        Mahasiswa m = new Mahasiswa(nama, noHandphone, jenisKelamin, idMahasiswa);
        daftarMahasiswa.add(m);
    }

    public Mahasiswa getMahasiswa(String idMahasiswa) {
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            if (daftarMahasiswa.get(i).getIdMahasiswa().equals(idMahasiswa)) {
                return daftarMahasiswa.get(i);
            }
        }
        return null;
    }

    public Dosen getDosen(String idDosen) {
        for (int i = 0; i < daftarDosen.size(); i++) {
            if (daftarDosen.get(i).getIdDosen().equals(idDosen)) {
                return daftarDosen.get(i);
            }
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

    public void MenuBuatKelompokTA(String id, String topik, String namaklmpk, int urutan) {
        int i;
        Dosen d1 = null;
        d1 = getDosen(id);
        d1.createKelompokTA(topik, namaklmpk, urutan);
    }

    public void MenuTambahAnggota(String pilihTopik, String id2,/*int tt,*/ String indeks) {
        Dosen d3 = null;
        d3 = getDosen(id2);
        KelompokTA dataKelompok = d3.getKelompok(pilihTopik);
        Mahasiswa mhs = getMahasiswa(indeks);

        // mhs.getTugasAkhir().setPembimbing(d3,tt-1);
        dataKelompok.addAnggota(mhs);
    }

    public void MenuHapusMahasiswa(String nomer3, String idMahasiswa2, String cariTopik2) {
        Dosen d5 = null;
        d5 = getDosen(nomer3);
        deleteMahasiswa(idMahasiswa2);
        for (int i = 0; i < d5.getKelompok(cariTopik2).getAnggota2().size(); i++) {
            if ((d5.getKelompok(cariTopik2).getAnggota2().get(i).getIdMahasiswa()).equals(idMahasiswa2)) {
                //d5 = daftarDosen.get(i);
                d5.getKelompok(cariTopik2).getAnggota2().remove(i);
            }
        }
    }

    public void displayDosen() {
        for (Dosen dosen : daftarDosen) {
            System.out.println("Nama Dosen     :  " + dosen.getNama());
            System.out.println("Nomer Handphone : " + dosen.getNoHandphone());
            System.out.println("Jenis Kelamin   : " + dosen.getJenisKelamin());
            System.out.println("ID Dosen        : " + dosen.getIdDosen());
        }
    }

    public void displayMahasiswa() {
        for (Mahasiswa mahasiswa : daftarMahasiswa) {
            System.out.println("Nama Mahasiswa  :  " + mahasiswa.getNama());
            System.out.println("Nomer Handphone : " + mahasiswa.getNoHandphone());
            System.out.println("Jenis Kelamin   : " + mahasiswa.getJenisKelamin());
            System.out.println("ID Mahasiswa    : " + mahasiswa.getIdMahasiswa());
        }
    }

    public void mainMenu() {
        System.out.println("====MENU UTAMA====");
        System.out.println("=====================");
        System.out.println("Menu Dosen");
        System.out.println("1.Tambah Dosen");
        System.out.println("2.Lihat Daftar Dosen");
        System.out.println("3.Hapus Dosen");
        System.out.println("=======================");
        System.out.println("======================");
        System.out.println("KELOMPOK TA");
        System.out.println("4.Buat Kelompok TA");
        System.out.println("5.Lihat Kelompok TA");
        System.out.println("6.Hapus Kelompok TA");
        System.out.println("7.Tambah Anggota");
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("Menu Mahasiswa");
        System.out.println("8.Tambah Mahasiswa");
        System.out.println("9.Lihat Daftar Mahasiswa");
        System.out.println("10.Hapus Mahasiswa");
        System.out.println("=============================");
        System.out.println("========================");
        System.out.println("Tugas Akhir");
        System.out.println("11.Buat Tugas Akhir");
        System.out.println("12.Lihat Tugas Akhir");
        System.out.println("13.Revisi Judul Tugas Akhir");
        System.out.println("==============================");
        System.out.println("14.EXIT");
        System.out.print("Pilihan : ");
        int b = s.nextInt();
        switch (b) {
            case 1:
                System.out.println("Masukkan Data Dosen :");
                System.out.print("Nama : ");
                String namaDosen = s.next();
                System.out.print("No HP : ");
                String noHandphone = s.next();
                System.out.print("Jenis Kelamin : ");
                String jenisKelamin = s.next();
                System.out.print("ID Dosen  : ");
                String idDosen = s.next();
                addDosen(namaDosen, noHandphone, jenisKelamin, idDosen);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p = s.next();
                mainMenu();
                break;
            case 2:
                displayDosen();
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p2 = s.next();
                mainMenu();
                break;
            case 3:
                System.out.println("Masukan id Dosen yang akan dihapus ");
                String index = s.next();
                deleteDosen(index);
                System.out.println("Dosen tersebut telah di hapus");
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p3 = s.next();
                mainMenu();
                break;
            case 4:
                System.out.println("Masukan IdDosen yang ingin membuat kelompok TA =");
                String id = s.next();
                System.out.println("Masukan Topik kelompok TA = ");
                String topik = s.next();
                System.out.println("Masukan Nama kelompok = ");
                String namaklmpk = s.next();
                System.out.println("Masukan urutan kelompok = ");
                int urutan = s.nextInt();
                MenuBuatKelompokTA(id, topik, namaklmpk, urutan);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p10 = s.next();
                mainMenu();
                break;
            case 5:
                System.out.println("Lihat Anggota  Kelompok berdasarkan Topik TA = ");
                String cariTopik = s.next();
                System.out.println("Masukan id dosen yang ingin melihat =");
                String nomer2 = s.next();
                Dosen d4 = null;
                d4 = getDosen(nomer2);

                try {
                    System.out.println("Nama Kelompok adalah " + d4.getKelompok(cariTopik).getTopik());
                    System.out.println("Nama Anggota: ");
                    for (int i = 0; i < d4.getKelompok(cariTopik).getAnggota2().size(); i++) {
                        System.out.println((i + 1) + " " + d4.getKelompok(cariTopik).getAnggota(i));
                    }
                } catch (Exception e) {
                    System.out.println("Object not Found");
                }
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p9 = s.next();
                mainMenu();
                break;
            case 6:
                System.out.println("Hapus kelompok berdasarkan urutan = ");
                int hapusUrutan = s.nextInt();
                System.out.println("Masukan Id Dosen yang ingin menghapus =");
                String nomer3 = s.next();
                getDosen(nomer3).deleteKelompok(hapusUrutan);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p8 = s.next();
                mainMenu();
                break;
            case 7:
                System.out.println("Tambah kan anggota ke salah satu Topik pilihan");
                System.out.println("Pilih topik : ");
                String pilihTopik = s.next();
                System.out.println("Masukan id  dosen yang akan menambahkan anggota = ");
                String id2 = s.next();
                //System.out.print("Dosen menjadi pembimbing 1 atau 2 :");
                //int tt = s.nextInt();
                System.out.println("Masukan Id mahasiswa yang ingin di tambahakan");
                String indeks = s.next();
                MenuTambahAnggota(pilihTopik, id2,/*tt,*/ indeks);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p7 = s.next();
                mainMenu();
                break;
            case 8:
                System.out.println("Masukkan Data Mahasiswa :");
                System.out.print("Nama : ");
                String namaMahasiswa = s.next();
                System.out.print("No HP : ");
                String noHandphoneMahasiswa = s.next();
                System.out.print("Jenis Kelamin : ");
                String jenisKelaminMahasiswa = s.next();
                System.out.print("ID Mahasiswa  : ");
                String idMahasiswa = s.next();
                addMahasiswa(namaMahasiswa, noHandphoneMahasiswa, jenisKelaminMahasiswa, idMahasiswa);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p4 = s.next();
                mainMenu();
                break;
            case 9:
                displayMahasiswa();
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p5 = s.next();
                mainMenu();
                break;
            case 10:
                System.out.println("Masukan Id Mahasiswa yang akan dihapus ");
                String idMahasiswa2 = s.next();
                System.out.println("Masukkan Topik TA = ");
                String cariTopik2 = s.next();
                System.out.println("Masukan id dosen pembimbing  =");
                String nomer5 = s.next();
                MenuHapusMahasiswa(nomer5, idMahasiswa2, cariTopik2);
                System.out.println("Mahasiswa tersebut telah di hapus");
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p6 = s.next();
                mainMenu();
                break;
            case 11:
                System.out.println("Masukan idMahasiswa mahasiswa yang ingin membuat TugasAkhir =");
                String nomer4 = s.next();
                System.out.println("Masukan JudulTA = ");
                String judul = s.next();
                getMahasiswa(nomer4).createTA(judul);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p12 = s.next();
                mainMenu();
                break;
            case 12:
                System.out.println("Masukan Id Mahasiswa yang ingin melihat judul TA=");
                String nomer9 = s.next();
                System.out.println("Lihat judul TA ");
                System.out.println("Judul TA adalah " + getMahasiswa(nomer9).getRevisiTA());
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String p11 = s.next();
                mainMenu();
                break;
            case 13:
                System.out.println("Revisi judul Tugas Akhir = ");
                String revisiJudul = s.next();
                System.out.println("Masukan idMahasiswa yang ingin merevisi Judul =");
                String nomer6 = s.next();
                getMahasiswa(nomer6).revisiTA(revisiJudul);
                System.out.println("Ingin kembali ke menu Dosen tekan Y");
                String pi = s.next();
                mainMenu();
                break;
            case 14:
                System.exit(0);
        }
    }
}
