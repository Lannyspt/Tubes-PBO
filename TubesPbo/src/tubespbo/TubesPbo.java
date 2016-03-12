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
        
        d1.createKelompokTA("ICM","Kelompok super",1);
        d1.createKelompokTA("SIDE","Kelompok hebat",2);
        d1.createKelompokTA("TELE","Kelompok mantap",3);
     
        
        Mahasiswa m1 = new Mahasiswa("Martcelius","082240204491","Laki-Laki","1301140124");
        Mahasiswa m2 = new Mahasiswa("Aziz","082299000","Laki-Laki","1301140000");
        Mahasiswa m3 = new Mahasiswa("Saragih","0822449292","Laki-Laki","13011409000");
        
       System.out.println("Terdapat beberapa kelompok TA dengan rincian sebagai berikut :");
        // System.out.println(d1.getKelompokTA(2));
       System.out.println(d1.getKelompok("ICM")+ " dengan topik pada KK "+d1.getKelompokTA(0));
       System.out.println(d1.getKelompok("SIDE")+ " dengan topik pada KK "+d1.getKelompokTA(1));
       System.out.println(d1.getKelompok("TELE")+ " dengan topik pada KK "+d1.getKelompokTA(2));
       d1.deleteKelompok(1);
        System.out.println(" ");
        System.out.println(" ");
       
       KelompokTA t1 = new KelompokTA("ICM","Kelompok super",3);
        t1.addAnggota(m1);
        t1.addAnggota(m2);
        t1.addAnggota(m3);
        
         m1.createTA("Expert Teknologi");
        m1.setStatusMhs("LULUS");
        m2.setStatusMhs("LULUS");
        m3.setStatusMhs("BELUM LULUS");
        
        System.out.println("Kelompok TA dengan topik "+d1.getKelompokTA(0)+" Adalah "+d1.getKelompok("ICM"));
        System.out.println("judul TA : "+m1.getRevisiTA());
        System.out.println("Anggota dari "+d1.getKelompok("ICM")+" Adalah :");
        System.out.println("1. "+t1.getAnggota(0)+ " Dengan NIM "+m1.getIdMahasiswa());
        System.out.println("2. "+t1.getAnggota(1)+ " Dengan NIM "+m2.getIdMahasiswa());
        System.out.println("3. "+t1.getAnggota(2)+ " Dengan NIM "+m3.getIdMahasiswa());
        m1.revisiTA("Teknologi Expert");
        System.out.println("judul TA : "+m1.getRevisiTA());
        
        System.out.println(" ");
        System.out.println("Status Kelulusan Mahasiswa : ");
        System.out.println("1. "+t1.getAnggota(0)+ " Dengan NIM "+m1.getIdMahasiswa()+" dinyatakan "+m1.getStatusMhs());
        System.out.println("2. "+t1.getAnggota(1)+ " Dengan NIM "+m2.getIdMahasiswa()+" dinyatakan "+m2.getStatusMhs());
        System.out.println("3. "+t1.getAnggota(2)+ " Dengan NIM "+m3.getIdMahasiswa()+" dinyatakan "+m3.getStatusMhs());
        
        System.out.println(" ");
        
        System.out.println("contoh lain tampilan anggota");
        System.out.println("Anggota "+d1.getKelompok("ICM")+" adalah "+t1.getKelompok("1301140124"));
        t1.removeAnggota(1);
        System.out.println("Anggota "+d1.getKelompok("ICM")+" adalah "+t1.getKelompok("1301140000"));
        System.out.println(" ");
        
       // m1.createTA("Expert Teknologi");
       // m1.setStatusMhs("LULUS")
       // System.out.println("Mahasiswa mempunyai TA dengan judul : "+m1.getRevisiTA());
       // System.out.println("Status Mahasiswa adalah "+m1.getStatusMhs());
       // m1.revisiTA("Teknologi Expert");
       // System.out.println("Mahasiswa mempunyai TA dengan judul : "+m1.getRevisiTA());
        
        
        TugasAkhir a = new TugasAkhir("Teknologi Expert");
        
        a.setPembimbing(d1,0);
        System.out.println("Pembimbing dengan judulTA "+a.getJudulTA()+" adalah "+a.getPembimbing(1));
        System.out.println("Pembimbing adalah "+a.getPembimbing("Nungki"));
        
        
        
        
        
        
    }
    
}
