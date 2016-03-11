/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author Martcel
 */
public class TubesPbo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dosen d1 = new Dosen("Nungki","12345678","Laki","123456",3);
        Dosen d2 = new Dosen("Gia","99999999","Perempuan","123451");
        
        d1.createKelompokTA("ICM","Kelompok super",0);
        d1.createKelompokTA("SIDE","Kelompok hebat",1);
        d1.createKelompokTA("TELE","Kelompok mantap",2);
        
        System.out.println(d1.getKelompokTA(2));
        d1.deleteKelompok(0);
        System.out.println(d1.getKelompok("ICM"));

        Mahasiswa m1 = new Mahasiswa("Martcelius","082240204491","LAki","1301140124");
        Mahasiswa m2 = new Mahasiswa("Aziz","082299000","LAki","1301140000");
        Mahasiswa m3 = new Mahasiswa("Saragih","0822449292","Laki","13011409000");
        
        m1.createTA("Expert Teknologi");
        m1.setStatusMhs("LULUS");
        System.out.println("Mahasiswa mempunyai TA dengan judul "+m1.getRevisiTA());
        System.out.println("Mahasiswa dalam status "+m1.getStatusMhs());
        m1.revisiTA("Teknologi Expert");
        System.out.println("Mahasiswa mempunyai TA dengan judul "+m1.getRevisiTA());
        
        KelompokTA t1 = new KelompokTA("ICM","Kelompok super",3);
        t1.addAnggota(m1);
        t1.addAnggota(m2);
        t1.addAnggota(m3);
        
        System.out.println("Anggota  dari "+t1.getTopik()+" adalah "+ t1.getAnggota(0));
        System.out.println("Anggota  dari "+t1.getTopik()+" adalah "+ t1.getAnggota(1));
        System.out.println("Anggota  dari "+t1.getTopik()+" adalah "+ t1.getAnggota(2));
        
        System.out.println("Anggota adalah "+t1.getKelompok("1301140124"));
        t1.removeAnggota(1);
        System.out.println("Anggota adalah "+t1.getKelompok("1301140000"));
        
        TugasAkhir a = new TugasAkhir("Teknologi Expert");
        
        a.setPembimbing(d1,0);
        System.out.println("Pembimbing dengan judulTA "+a.getJudulTA()+" adalah "+a.getPembimbing(1));
        System.out.println("Pembimbing adalah "+a.getPembimbing("Nungki"));
        
        
        
        
        
        
    }
    
}
