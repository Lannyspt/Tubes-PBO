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
        if (e.getSource().equals(ll.getMahasiswa())) {
            lm.addListener(this);
            lm.setVisible(true);
            ll.setVisible(false);
        } else if (e.getSource().equals(ll.getDosen())) {
            ld.addListener(this);
            ld.setVisible(true);
            ll.setVisible(false);
        }
        if (e.getSource().equals(ld.getMasuk())) {
            if ((ld.getNama().equals("Admin")) && (ld.getIdDosen().equals("123"))) {
                md.setVisible(true);
                md.addListener(this);
                ld.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(ld, "ERROR!!");
            }
        } else if (e.getSource().equals(ld.getKembali())) {
            ll.setVisible(true);
            ll.addListener(this);
            ld.setVisible(false);
        }
        if (e.getSource().equals(md.getKeluar())) {
            ll.setVisible(true);
            ll.addListener(this);
            md.setVisible(false);
        }

        if (e.getSource().equals(lm.getMasuk())) {
            if ((lm.getNama().equals("Mahasiswa")) && (lm.getIdMahasiswa().equals("1301140124"))) {
                mmhs.setVisible(true);
                mmhs.addListener(this);
                lm.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "ERROR!!");
            }
        } else if (e.getSource().equals(lm.getKembali())) {
            ll.setVisible(true);
            ll.addListener(this);
            lm.setVisible(false);

        }
        if (e.getSource().equals(mmhs.getKeluar())) {
            ll.setVisible(true);
            ll.addListener(this);
            mmhs.setVisible(false);
        }

        if (e.getSource().equals(md.getMasukData())) {
            id.setVisible(true);
            id.addListener(this);
            md.setVisible(false);
        }
        if (e.getSource().equals(id.getTambah())) {
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
                JOptionPane.showMessageDialog(id, "Data Dosen Telah DiTambah");

            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
            }
            id.reset();
        }
        if (e.getSource().equals(md.getLihatDosen())) {
            vd.setVisible(true);
            vd.addListener(this);
            md.setVisible(false);
            vd.tampildata2(model);

        }
        if (e.getSource().equals(vd.getKeluar())) {
            md.setVisible(true);
            md.addListener(this);
            vd.setVisible(false);
        }
        if (e.getSource().equals(id.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            id.setVisible(false);
        }
        if (e.getSource().equals(mmhs.getMasukkanData())) {
            im.setVisible(true);
            im.addListener(this);
            mmhs.setVisible(false);
        }
        if (e.getSource().equals(im.getTambah())) {
            if ((!im.getIdMahasiswa().equals("")) && (!im.getNamaMahasiswa().equals("")) && (!im.getNoHp().equals(""))) {
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

            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
                
            }
            im.reset();

        }
        if (e.getSource().equals(mmhs.getLihatData())) {
            vm.setVisible(true);
            vm.addListener(this);
            mmhs.setVisible(false);
            vm.tampildata(model);
        }
        if (e.getSource().equals(vm.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vm.setVisible(false);
        }
        if (e.getSource().equals(vm.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vm.setVisible(false);
        }

        if (e.getSource().equals(im.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            im.setVisible(false);
        }
        if (e.getSource().equals(mmhs.getBuatTugas())) {
            ct.setVisible(true);
            ct.addListener(this);
            mmhs.setVisible(false);

        }
        if (e.getSource().equals(ct.getTambah())) {
            if ((!ct.getIdMahasiswa().equals("")) && (!ct.getJudul().equals(""))) {
                String idMahasiswa = ct.getIdMahasiswa();
                String judul = ct.getJudul();
                Mahasiswa m = model.getMahasiswa(idMahasiswa);
                if (m != null) {
                    m.createTA(judul);
                    JOptionPane.showMessageDialog(ct, "Judul TA Telah Terbuat");
                } else {
                    JOptionPane.showMessageDialog(null, "ID Tidak DItemukan");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Belum Di Input");
            }
            ct.reset();
        }
        if (e.getSource().equals(ct.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            ct.setVisible(false);
        }
        if (e.getSource().equals(mmhs.getRevisiTA())) {
            rta.setVisible(true);
            rta.addListener(this);
            mmhs.setVisible(false);
        }
        if (e.getSource().equals(rta.getRevisi())) {
            if ((!rta.getIdMahasiswa().equals("")) && (!rta.getJudul().equals(""))) {
                String idMahasiswa = rta.getIdMahasiswa();
                String judul = rta.getJudul();
                Mahasiswa m = model.getMahasiswa(idMahasiswa);
                if (m != null) {
                    m.revisiTA(judul);
                    JOptionPane.showMessageDialog(rta, "Judul TA Telah Di Revisi");
                } else {
                    JOptionPane.showMessageDialog(null, "ID Tidak DItemukan");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Belum Di Input");
            }
            rta.reset();
        }
        if (e.getSource().equals(rta.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            ct.setVisible(false);
        }
        if (e.getSource().equals(mmhs.getLihatTugas())) {
            vta.setVisible(true);
            vta.addListener(this);
            mmhs.setVisible(false);
        }
        if (e.getSource().equals(vta.getCari())) {
            if (!vta.getIdMahasiswa().equals("")) {
                String idMahasiswa = vta.getIdMahasiswa();
                Mahasiswa m2 = model.getMahasiswa(idMahasiswa);
                if (m2 != null) {
                    vta.setJudul(m2.getRevisiTA());
                } else {
                    JOptionPane.showMessageDialog(null, "ID Tidak DiTemukan");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Belum di Input");
            }
        }
        if (e.getSource().equals(vta.getKembali())) {
            mmhs.setVisible(true);
            mmhs.addListener(this);
            vta.setVisible(false);
        }

        if (e.getSource().equals(md.getTambahKelompok())) {
            ck.setVisible(true);
            ck.addListener(this);
            md.setVisible(false);
        }

        if (e.getSource().equals(ck.getTambah())) {
            if ((!ck.getIdDosen().equals("")) && (!ck.getTopik().equals("")) && (!ck.getNamakelompok().equals(""))) {
                String idDosen = ck.getIdDosen();
                String topik = ck.getTopik();
                String namaKelompok = ck.getNamakelompok();
                int urutan = ck.getUrutan2();
                if (model.getDosen(idDosen) != null) {
                    model.MenuBuatKelompokTA(idDosen, topik, namaKelompok, urutan);
                    JOptionPane.showMessageDialog(ck, "Data Berhasil Di Tambah");
                } else {
                    JOptionPane.showMessageDialog(ck, "ID Dosen Tidak Ada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data Kosong");
            }
            ck.reset();
        }
        
        if (e.getSource().equals(ck.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            ck.setVisible(false);
        }
        if (e.getSource().equals(md.getLihatKelempok())) {
            vkt.setVisible(true);
            vkt.addListener(this);
            md.setVisible(false);
        }

        if (e.getSource().equals(vkt.getCari())) {
            String id = vkt.getID();
            String topik = vkt.getTopik();
            Dosen d3 = model.getDosen(id);
            KelompokTA ka = d3.getKelompok(topik);
            vkt.tampildata3(ka);
        }
        
        if (e.getSource().equals(vkt.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            vkt.setVisible(false);
        }

        if (e.getSource().equals(md.getTambahAnggota())) {
            am.setVisible(true);
            am.addListener(this);
            md.setVisible(false);
        }

        if (e.getSource().equals(am.getTambahkan())) {
            String topik = am.getTopik();
            String idDosen = am.getID_dosen();
            String idMahasiswa = am.getID_mahasiswa();
            if ((topik != "") && (idDosen != "") && (idMahasiswa != "")) {
                if ((model.getDosen(idDosen) != null) && (model.getDosen(idDosen).getKelompok(topik) != null) && (model.getMahasiswa(idMahasiswa) != null)) {
                    model.MenuTambahAnggota(topik, idDosen, idMahasiswa);
                    JOptionPane.showMessageDialog(am, "Mahasiswa Telah Di Masukkan");
                } else {
                    JOptionPane.showMessageDialog(null, "Data inputan Tidak ada");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data kosong!!");
            }
            
        }
        if (e.getSource().equals(am.getKembali())) {
            md.setVisible(true);
            md.addListener(this);
            am.setVisible(false);
        }

    }
}
