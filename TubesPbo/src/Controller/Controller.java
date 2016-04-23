/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ViewTubes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tubespbo.Aplikasi;
import java.util.*;
import javax.swing.*;
import tubespbo.Dosen;
import tubespbo.KelompokTA;
import tubespbo.Mahasiswa;

/**
 *
 * @author Martcel
 */
public class Controller implements ActionListener {

    private Aplikasi model;
    private Add_member am;
    private Create_Kelompok_TA ck;
    private Create_tugas_akhir ct;
    private Delete_dosen dd;
    private Delete_kelompok_ta dk;
    private Delete_mahasiswa dm;
    private Insert_mahasiswa im;
    private Login2 ll;
    private login_dosen ld;
    private login_mahasiswa lm;
    private Menu_Dosen md;
    private Menu_Mahasiswa mmhs;
    private Revisi_tugas_akhir rta;
    private View_Tugas_akhir vta;
    private View_dosen vd;
    private View_kelompok_ta vkt;
    private View_mahasiswa vm;
    private insert_dosen id;

    public Controller(Aplikasi model) {
        this.model = model;
        this.model = model;
        ll = new Login2();
        ld = new login_dosen();
        lm = new login_mahasiswa();
        ll.addListener(this);
        ll.setVisible(true);
        md = new Menu_Dosen();
        am = new Add_member();
        ck = new Create_Kelompok_TA();
        ct = new Create_tugas_akhir();
        dd = new Delete_dosen();
        dk = new Delete_kelompok_ta();
        dm = new Delete_mahasiswa();
        im = new Insert_mahasiswa();
        mmhs = new Menu_Mahasiswa();
        rta = new Revisi_tugas_akhir();
        vta = new View_Tugas_akhir();
        vd = new View_dosen();
        vkt = new View_kelompok_ta();
        vm = new View_mahasiswa();
        id = new insert_dosen();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        //halaman login mahasiswa
        if (source.equals(ll.getMahasiswa())) {
            lm.addListener(this);
            lm.setVisible(true);
            ll.dispose();
        }
        //halaman login dosen
        if (source.equals(ll.getDosen())) {
            ld.addListener(this);
            ld.setVisible(true);
            ll.dispose();
        }
        //tekan tombol masuk di login dosen
        if (source.equals(ld.getMasuk())) {
            if ((ld.getNama().equals("Admin")) && (ld.getIdDosen().equals("123"))) {
                md.setVisible(true);
                md.addListener(this);
                ld.dispose();
            } else {
                JOptionPane.showMessageDialog(ld, "ERROR!!");
            }
        }
        //tekan kembali di halam login dosen
        if (source.equals(ld.getKembali())) {
            ll.setVisible(true);
            ll.addListener(this);
            ld.dispose();
        }
        //tekan kembali di halaman menu dosen
        if (source.equals(md.getKeluar())) {
            ll.setVisible(true);
            ll.addListener(this);
            md.dispose();
        }
        //tekan masuk di halam login mahasiswa
        if (source.equals(lm.getMasuk())) {
            if ((lm.getNama().equals("Mahasiswa")) && (lm.getIdMahasiswa().equals("1301140124"))) {
                mmhs.setVisible(true);
                mmhs.addListener(this);
                lm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!");
            }
        }
        //tekan kembali di halaman login mahasiswa
        if (source.equals(lm.getKembali())) {
            ll.setVisible(true);
            ll.addListener(this);
            lm.dispose();
        }
        //tekan kembali di halaman menu mahasiswa
        if (source.equals(mmhs.getKeluar())) {
            ll.setVisible(true);
            ll.addListener(this);
            mmhs.dispose();
        }
        //tekan menu tambah dosen di halaman menu dosen
        if (source.equals(md.getMasukData())) {
            id.setVisible(true);
            id.addListener(this);
            md.dispose();
        }
        //tekan tombol tambah di halaman insert dosen
        if (source.equals(id.getTambah())) {
            if ((!id.getIdDosen().equals("")) && (!id.getNamaDosen().equals("")) && (!id.getNoHpDosen().equals(""))) {
                String idDosen = id.getIdDosen();
                String namaDosen = id.getNamaDosen();
                String NoHp = id.getNoHpDosen();
                String jenis = null;
                if (id.getL().isSelected()) {
                    jenis = "L";
                } else {
                    jenis = "P";
                }
                model.addDosen(namaDosen, NoHp, jenis, idDosen);
                JOptionPane.showMessageDialog(null, "Data Dosen Telah DiTambah");

            }
            id.reset();
        }
        //tekan tombol lihat dosen di halaman menu dosen
        if (source.equals(md.getLihatDosen())) {
            vd.setVisible(true);
            vd.addListener(this);
            md.dispose();
            vd.tampildata2(model);

        }
        //tekan tombol keluar di halaman view dosen
        if (source.equals(vd.getKeluar())) {
            md.setVisible(true);
            md.addListener(this);
            vd.dispose();
        }
        //tekan tombol kembali di halaman insert dosen
        if (source.equals(id.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            id.dispose();
        }
        //tekan tombol masukkan data mahasiswa di halaman menu mahasiswa
        if (source.equals(mmhs.getMasukkanData())) {
            im.setVisible(true);
            im.addListener(this);
            mmhs.dispose();
        }
        //tekan tombol tambah di halam insert mahasiswa
        if (source.equals(im.getTambah())) {
            if (!im.getIdMahasiswa().equals("") && !im.getNamaMahasiswa().equals("") && !im.getNoHp().equals("")) {
                String namaMahasiswa = im.getNamaMahasiswa();
                String noHp = im.getNoHp();
                String jenis = null;
                if (id.getL().isSelected()) {
                    jenis = "L";
                } else {
                    jenis = "P";
                }
                String idMahasiswa = im.getIdMahasiswa();
                model.addMahasiswa(namaMahasiswa, noHp, jenis, idMahasiswa);
                JOptionPane.showMessageDialog(null, "Data Mahasiswa berhasil di Tambahkan");
                im.reset();

            }
        }
        //tekan menu lihat data mahasiswa di menu mahasiswa
        if (source.equals(mmhs.getLihatData())) {
            vm.setVisible(true);
            vm.addListener(this);
            mmhs.dispose();
            vm.tampildata(model);
        }
        //tekan tombol kembali di halaman lihat data mahasiswa
        if (source.equals(vm.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vm.setVisible(false);
        }
        //tekan tombol kembali di halaman insert mahasiswa
        if (source.equals(im.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            im.setVisible(false);
        }
        //tekan tombol buat tugas di halaman menu mahasiswa
        if (source.equals(mmhs.getBuatTugas())) {
            ct.setVisible(true);
            ct.addListener(this);
            mmhs.setVisible(false);

        }
        //tekan tombol tambah di halaman create tugas
        if (source.equals(ct.getTambah())) {
            if ((!ct.getIdMahasiswa().equals("")) && (!ct.getJudul().equals(""))) {
                String idMahasiswa = ct.getIdMahasiswa();
                String judul = ct.getJudul();
                Mahasiswa m = model.getMahasiswa(idMahasiswa);
                if (m != null) {
                    m.createTA(judul);
                    JOptionPane.showMessageDialog(null, "Judul TA Telah Terbuat");
                } 
            }
            ct.reset();
        }
        //tekan tombol kembali di halaman create tugas
        if (source.equals(ct.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            ct.setVisible(false);
        }
        //tekan tombol revisiTa di halaman menu mahasiswa
        if (source.equals(mmhs.getRevisiTA())) {
            rta.setVisible(true);
            rta.addListener(this);
            mmhs.setVisible(false);
        }
        //tekan tombol revisi di halaman revisi ta
        if (source.equals(rta.getRevisi())) {
            if ((!rta.getIdMahasiswa().equals("")) && (!rta.getJudul().equals(""))) {
                String idMahasiswa = rta.getIdMahasiswa();
                String judul = rta.getJudul();
                Mahasiswa m = model.getMahasiswa(idMahasiswa);
                if (m != null) {
                    m.revisiTA(judul);
                    JOptionPane.showMessageDialog(null, "Judul TA Telah Di Revisi");
                } 
            }
            rta.reset();
        }
        //tekan tombol kembali di halaman revisi ta
        if (source.equals(rta.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            ct.dispose();
        }
        //tekan tombol lihat tugas di menu mahasiswa
        if (source.equals(mmhs.getLihatTugas())) {
            vta.setVisible(true);
            vta.addListener(this);
            mmhs.dispose();
        }
        //tekan tombol cari di halaman lihat tugas akhir
        if (source.equals(vta.getCari())) {
            if (!vta.getIdMahasiswa().equals("")) {
                String idMahasiswa = vta.getIdMahasiswa();
                Mahasiswa m2 = model.getMahasiswa(idMahasiswa);
                if (m2 != null) {
                    vta.setJudul(m2.getRevisiTA());
                } 
            }
        }
        //tekan tombol kembali di halaman lihat tugas akhir
        if (source.equals(vta.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vta.dispose();
        }
        //tekan tombol tambah kelompok di halaman menu dosen
        if (source.equals(md.getTambahKelompok())) {
            ck.setVisible(true);
            ck.addListener(this);
            md.setVisible(false);
        }
        //tekan tombol tambah di halaman create kelompok
        if (source.equals(ck.getTambah())) {
            if ((!ck.getIdDosen().equals("")) && (!ck.getTopik().equals("")) && (!ck.getNamakelompok().equals(""))) {
                String idDosen = ck.getIdDosen();
                String topik = ck.getTopik();
                String namaKelompok = ck.getNamakelompok();
                int urutan = ck.getPosition();
                if (model.getDosen(idDosen) != null) {
                    model.MenuBuatKelompokTA(idDosen, topik, namaKelompok, urutan);
                    JOptionPane.showMessageDialog(ck, "Data Berhasil Di Tambah");
                    ck.reset();
                }
            }
        }
        //tekan tombol kembali di halaman create kelompok
        if (source.equals(ck.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            ck.setVisible(false);
        }
        //tekan tombol lihat kelompok di menu dosen
        if (source.equals(md.getLihatKelempok())) {
            vkt.setVisible(true);
            vkt.addListener(this);
            md.setVisible(false);
        }
        //tekan tombol cari di menu view kelompok TA
        if (source.equals(vkt.getCari())) {
            String id = vkt.getID();
            String topik = vkt.getTopik();
            Dosen d3 = model.getDosen(id);
            KelompokTA ka = d3.getKelompok(topik);
            vkt.tampildata3(ka);
        }
        //tekan tombol kembali di halaman view kelompok ta
        if (source.equals(vkt.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            vkt.setVisible(false);
        }
        //tekan tombol tambah anggota di menu dosen
        if (source.equals(md.getTambahAnggota())) {
            am.setVisible(true);
            am.addListener(this);
            md.setVisible(false);
        }
        //tekan tombol tambah di halaman add member
        if (source.equals(am.getTambahkan())) {
            if ((am.getTopik() != "") && (am.getID_dosen() != "") && (am.getID_mahasiswa() != "")) {
                String topik = am.getTopik();
                String idDosen = am.getID_dosen();
                String idMahasiswa = am.getID_mahasiswa();

                if ((model.getDosen(idDosen) != null) && (model.getDosen(idDosen).getKelompok(topik) != null) && (model.getMahasiswa(idMahasiswa) != null)) {
                    model.MenuTambahAnggota(topik, idDosen, idMahasiswa);
                    JOptionPane.showMessageDialog(null, "Mahasiswa Telah Di Masukkan");
                    am.reset();
                } 
            }
        }
        //tekam tombol kembali di halaman add member
        if (source.equals(am.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            am.setVisible(false);
        }
        //tekan menu hapus dosen di menu dosen
        if (source.equals(md.getHapusDosen())) {
            dd.setVisible(true);
            dd.addListener(this);
            md.setVisible(false);
        }
        //tekan tombol hapus di halaman delete dosen 
        if (source.equals(dd.getHapus())) {
            String idDosen = dd.getField_ID().getText();
            if (model.getDosen(idDosen) != null) {
                model.deleteDosen(idDosen);
                JOptionPane.showMessageDialog(null, "Dosen telah di hapus");
                dd.reset();
            } 
        }
        //tekan kembali di halaman delete dosen
        if (source.equals(dd.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            dd.setVisible(false);
        }
        //tekan tombol delete data di menu mahasiswa
        if (source.equals(mmhs.getDeleteData())) {
            dm.setVisible(true);
            dm.addListener(this);
            mmhs.setVisible(false);
        }
        //tekan tombol hapus di halaman delete mahasiswa
        if (source.equals(dm.getHapus())) {
            if ((dm.getField_ID().getText() != "") && (dm.getField_NIM().getText() != "") && (dm.getField_topik().getText() != "")) {
                String id = dm.getField_ID().getText();
                String nim = dm.getField_NIM().getText();
                String topik = dm.getField_topik().getText();
                if (model.getDosen(id) != null && model.getMahasiswa(nim) != null && model.getDosen(id).getKelompok(topik) != null) {
                    model.MenuHapusMahasiswa(nim, id, topik);
                    JOptionPane.showMessageDialog(null, "Data Telah Terhapus");
                } 
            }
        }
        //tekan tombol kembali di halaman delete mahasiswa
        if (source.equals(dm.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            dm.setVisible(false);
        }
        //tekan tombol hapus kelompok di menu dosen
        if (source.equals(md.getHapusKelompok())) {
            dk.setVisible(true);
            dk.addListener(this);
            md.dispose();
        }
        //tekan hapus di menu delete kelompok
        if (source.equals(dk.getHapus())) {
            if (dk.getID() != "") {
                String id = dk.getID();
                int urutan = ck.getPosition();
                if (model.getDosen(id) != null) {
                    model.getDosen(id).deleteKelompok(urutan);
                }

            }
        }
        //tekaan kembali di menu delete kelompok
        if (source.equals(dk.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            dk.dispose();
        }
    }
}
