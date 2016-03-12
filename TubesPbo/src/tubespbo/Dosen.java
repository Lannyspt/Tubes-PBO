/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author lannyspt
 */
public class Dosen extends Orang {

    private KelompokTA[] topikTA;
    private String idDosen;
    private int status;

    public Dosen(String nama, String noHandphone, String jenisKelamin, String idDosen, int n) {
        super(nama, noHandphone, jenisKelamin);
        this.idDosen = idDosen;
        topikTA = new KelompokTA[n];
    }

    public Dosen(String nama, String noHandphone, String jenisKelamin, String idDosen) {
        super(nama, noHandphone, jenisKelamin);
        this.idDosen = idDosen;
    }

    public void setStatusDosen(int status) {
        this.status = status;
    }

    public int getStatusDosen() {
        return status;
    }

    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }
    public int nomerTopik = 0;

    public void createKelompokTA(String topik,String namaKelompok,int urutanKlmpk) {
        if (nomerTopik < topikTA.length) {
            topikTA[nomerTopik] = new KelompokTA(topik,namaKelompok,urutanKlmpk);
            nomerTopik++;
        }
    }

    @Override
    public String getJabatan() {
        return "Dosen";
    }

    public String getKelompokTA(int idx) {
        return topikTA[idx].getTopik();
    }

    public String getKelompok(String topik) {
        for (int i = 0; i < topikTA.length; i++) {
            if (topikTA[i] != null) {
                if (topikTA[i].getTopik() == topik) {
                    return topikTA[i].getNamaKelompok();
                }
            }
            //else{return "tidak ada";}
        }
        return "kelompok tersebut tidak ada";

    }

    public void deleteKelompok(int urutanKlmpk) {
        if ((urutanKlmpk < topikTA.length)) { //&& (urutanKlmpk < 0)){
            topikTA[urutanKlmpk] = null;
            System.out.println("kelompok ke " + (urutanKlmpk) + " telah dihapus");
        } else {
            System.out.println("kelompok tidak dapat dihapus");
        }
    }

    /* public void deleteKelompok(int urutanKlmpk){
       if (topikTA[urutanKlmpk]!= null){
           for (int i=urutanKlmpk ; i < topikTA.length && topikTA[urutanKlmpk+1] != null ; i++ ){
               topikTA[i]=topikTA[i+1];
               topikTA[i+1]=null;
               System.out.println("Telah di hapus");
           }
       }
   }*/
}