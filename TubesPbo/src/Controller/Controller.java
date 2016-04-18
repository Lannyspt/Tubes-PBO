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
    private Menu_Dosen md;
    private Menu_Mahasiswa mmhs;
    private Revisi_tugas_akhir rta;
    private View_Tugas_akhir vta;
    private View_dosen vd;
    private View_kelompok_ta vkt;
    private View_mahasiswa vm;
    private insert_dosen id;
    private login_dosen ld;
    private login_mahasiswa lm;

    public Controller(Aplikasi model) {
        this.model = model;
        ll = new Login2();
        ld = new login_dosen();
        lm = new login_mahasiswa();
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
        ll.addListener(this);
        ll.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(ll.getMahasiswa())) {
            lm.addListener(this);
            lm.setVisible(true);
            ll.setVisible(false);
        }
        if (source.equals(ll.getDosen())) {
            ld.addListener(this);
            ld.setVisible(true);
            ll.setVisible(false);
        }
        if (source.equals(ld.getMasuk())) {
            if ((ld.getNama().equals("Admin")) && (ld.getIdDosen().equals("123"))) {
                md.setVisible(true);
                md.addListener(this);
                ld.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(ld, "ERROR!!");
            }
        }
        if (source.equals(ld.getKembali())) {
            ll.setVisible(true);
            ll.addListener(this);
            ld.setVisible(false);
        }
        if (source.equals(md.getKeluar())) {
            ll.setVisible(true);
            ll.addListener(this);
            md.setVisible(false);
        }

        if (source.equals(lm.getMasuk())) {
            if ((lm.getNama().equals("Mahasiswa")) && (lm.getIdMahasiswa().equals("1301140124"))) {
                mmhs.setVisible(true);
                mmhs.addListener(this);
                lm.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!");
            }
        }
        if (source.equals(lm.getKembali())) {
            ll.setVisible(true);
            ll.addListener(this);
            lm.setVisible(false);

        }
        if (source.equals(mmhs.getKeluar())) {
            ll.setVisible(true);
            ll.addListener(this);
            mmhs.setVisible(false);
        }

        if (source.equals(md.getMasukData())) {
            id.setVisible(true);
            id.addListener(this);
            md.setVisible(false);
        }
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

            } else {
                JOptionPane.showMessageDialog(id, "Data Kosong");
            }
            id.reset();
        }
        if (source.equals(md.getLihatDosen())) {
            vd.setVisible(true);
            vd.addListener(this);
            md.setVisible(false);
            vd.tampildata2(model);

        }
        if (source.equals(vd.getKeluar())) {
            md.setVisible(true);
            md.addListener(this);
            vd.setVisible(false);
        }
        if (source.equals(id.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            id.setVisible(false);
        }
        if (source.equals(mmhs.getMasukkanData())) {
            im.setVisible(true);
            im.addListener(this);
            mmhs.setVisible(false);
        }
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

            } else {
                JOptionPane.showMessageDialog(im, "Data Kosong");
            }
        }
        if (source.equals(mmhs.getLihatData())) {
            vm.setVisible(true);
            vm.addListener(this);
            mmhs.setVisible(false);
            vm.tampildata(model);
        }
        if (source.equals(vm.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vm.setVisible(false);
        }
        if (source.equals(vm.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vm.setVisible(false);
        }

        if (source.equals(im.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            im.setVisible(false);
        }
        if (source.equals(mmhs.getBuatTugas())) {
            ct.setVisible(true);
            ct.addListener(this);
            mmhs.setVisible(false);

        }
        if (source.equals(ct.getTambah())) {
            if ((!ct.getIdMahasiswa().equals("")) && (!ct.getJudul().equals(""))) {
                String idMahasiswa = ct.getIdMahasiswa();
                String judul = ct.getJudul();
                Mahasiswa m = model.getMahasiswa(idMahasiswa);
                if (m != null) {
                    m.createTA(judul);
                    JOptionPane.showMessageDialog(null, "Judul TA Telah Terbuat");
                } else {
                    JOptionPane.showMessageDialog(null, "ID Tidak DItemukan");
                }
            } else {
                JOptionPane.showMessageDialog(ct, "Data Belum Di Input");
            }
            ct.reset();
        }
        if (source.equals(ct.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            ct.setVisible(false);
        }
        if (source.equals(mmhs.getRevisiTA())) {
            rta.setVisible(true);
            rta.addListener(this);
            mmhs.setVisible(false);
        }
        if (source.equals(rta.getRevisi())) {
            if ((!rta.getIdMahasiswa().equals("")) && (!rta.getJudul().equals(""))) {
                String idMahasiswa = rta.getIdMahasiswa();
                String judul = rta.getJudul();
                Mahasiswa m = model.getMahasiswa(idMahasiswa);
                if (m != null) {
                    m.revisiTA(judul);
                    JOptionPane.showMessageDialog(null, "Judul TA Telah Di Revisi");
                } else {
                    JOptionPane.showMessageDialog(null, "ID Tidak DItemukan");
                }
            } else {
                JOptionPane.showMessageDialog(rta, "Data Belum Di Input");
            }
            rta.reset();
        }
        if (source.equals(rta.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            ct.setVisible(false);
        }
        if (source.equals(mmhs.getLihatTugas())) {
            vta.setVisible(true);
            vta.addListener(this);
            mmhs.setVisible(false);
        }
        if (source.equals(vta.getCari())) {
            if (!vta.getIdMahasiswa().equals("")) {
                String idMahasiswa = vta.getIdMahasiswa();
                Mahasiswa m2 = model.getMahasiswa(idMahasiswa);
                if (m2 != null) {
                    vta.setJudul(m2.getRevisiTA());
                } else {
                    JOptionPane.showMessageDialog(null, "ID Tidak DiTemukan");
                }
            } else {
                JOptionPane.showMessageDialog(vta, "Data Belum di Input");
            }
        }
        if (source.equals(vta.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vta.setVisible(false);
        }

        if (source.equals(md.getTambahKelompok())) {
            ck.setVisible(true);
            ck.addListener(this);
            md.setVisible(false);
        }

        if (source.equals(ck.getTambah())) {
            if ((!ck.getIdDosen().equals("")) && (!ck.getTopik().equals("")) && (!ck.getNamakelompok().equals(""))) {
                String idDosen = ck.getIdDosen();
                String topik = ck.getTopik();
                String namaKelompok = ck.getNamakelompok();
                int urutan = ck.getPosition();

                model.MenuBuatKelompokTA(idDosen, topik, namaKelompok, urutan);
                JOptionPane.showMessageDialog(ck, "Data Berhasil Di Tambah");
                ck.reset();
            } else {

                JOptionPane.showMessageDialog(null, "Inputkan data", "Error!!", 0);

            }

        }

        if (source.equals(ck.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            ck.setVisible(false);
        }
        if (source.equals(md.getLihatKelempok())) {
            vkt.setVisible(true);
            vkt.addListener(this);
            md.setVisible(false);
        }

        if (source.equals(vkt.getCari())) {
            String id = vkt.getID();
            String topik = vkt.getTopik();
            Dosen d3 = model.getDosen(id);
            KelompokTA ka = d3.getKelompok(topik);
            vkt.tampildata3(ka);
        }

        if (source.equals(vkt.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            vkt.setVisible(false);
        }

        if (source.equals(md.getTambahAnggota())) {
            am.setVisible(true);
            am.addListener(this);
            md.setVisible(false);
        }

        if (source.equals(am.getTambahkan())) {
            if ((am.getTopik() != "") && (am.getID_dosen() != "") && (am.getID_mahasiswa() != "")) {
                String topik = am.getTopik();
                String idDosen = am.getID_dosen();
                String idMahasiswa = am.getID_mahasiswa();

                if ((model.getDosen(idDosen) != null) && (model.getDosen(idDosen).getKelompok(topik) != null) && (model.getMahasiswa(idMahasiswa) != null)) {
                    model.MenuTambahAnggota(topik, idDosen, idMahasiswa);
                    JOptionPane.showMessageDialog(null, "Mahasiswa Telah Di Masukkan");
                    am.reset();
                } else {
                    JOptionPane.showMessageDialog(am, "Data inputan Tidak ada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data kosong!!");
            }
        }
        if (source.equals(am.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            am.setVisible(false);
        }

        if (source.equals(md.getHapusDosen())) {
            dd.setVisible(true);
            dd.addListener(this);
            md.setVisible(false);
        }
        if (source.equals(dd.getHapus())) {
            String idDosen = dd.getField_ID().getText();
            if (model.getDosen(idDosen) != null) {
                model.deleteDosen(idDosen);
                JOptionPane.showMessageDialog(null, "Dosen telah di hapus");
                dd.reset();
            } else {
                JOptionPane.showMessageDialog(null, "ID Dosen Tidak ada");

            }
        }
        if (source.equals(dd.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            dd.setVisible(false);
        }
        if (source.equals(mmhs.getDeleteData())) {
            dm.setVisible(true);
            dm.addListener(this);
            mmhs.setVisible(false);
        }
        if (source.equals(dm.getHapus())) {
            if ((dm.getField_ID().getText() != "") && (dm.getField_NIM().getText() != "") && (dm.getField_topik().getText() != "")) {
                String id = dm.getField_ID().getText();
                String nim = dm.getField_NIM().getText();
                String topik = dm.getField_topik().getText();
                if (model.getDosen(id) != null && model.getMahasiswa(nim) != null && model.getDosen(id).getKelompok(topik) != null) {
                    model.MenuHapusMahasiswa(nim, id, topik);
                    JOptionPane.showMessageDialog(null, "Data Telah Terhapus");
                } else {
                    JOptionPane.showMessageDialog(null, "Data inputan salah");
                }
            }
        }
        if(source.equals(dm.getKembali())){
            mmhs.setVisible(true);
            mmhs.addListener(this);
            dm.setVisible(false);
        }
    }
}
