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
    
    public Dosen(String nama,int tanggalLahir,double noHandphone,String jenisKelamin,String idDosen,int n){
       super(nama,tanggalLahir,noHandphone,jenisKelamin);
       this.idDosen=idDosen;
       KelompokTA[] topikTA=new KelompokTA[n];
    }
    
    public void setStatusDosen(int status){
        this.status=status;
    }
    public int getStatusDosem(){
        return status;
    }

    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }
    public int nomerTopik=0;
    public void createKelompokTA(String topik,int urutanKlmpk,String namaKelompok){
        if (nomerTopik < topikTA.length){
        topikTA[nomerTopik]=new KelompokTA(topik,urutanKlmpk,namaKelompok);
        nomerTopik++;
        }
    }
    
   public String getJabatan(){
       return "Dosen";
   }
   
   
   public KelompokTA getKelompokTA (int idx){
       return topikTA[idx];
   }
   
   public String getKelompok(String topik){
    for (int i = 0; i <= topikTA.length; i++){
        if (topikTA[i].getTopik() == topik){
            return  topikTA[i].getNamaKelompok();
        }
    }
    return "Tidak ada topik tersebut";
    
   }
   
   /*public void deleteKelompok(int urutanKlmpk){
       if ((topikTA.length <= urutanKlmpk) && (urutanKlmpk < 0)){
           topikTA[urutanKlmpk]=null;
           System.out.println("kelompok ke "+(urutanKlmpk+1)+" telah dihapus");
       } else {
           System.out.println("kelompok tidak dapat dihapus");
       }
   }*/
   
   public void deleteKelompok(int urutanKlmpk){
       if (topikTA[urutanKlmpk]!= null){
           for (int i=urutanKlmpk ; i < topikTA.length && topikTA[urutanKlmpk+1] != null ; i++ ){
               topikTA[i]=topikTA[i+1];
               topikTA[i+1]=null;
           }
       }
   }
   
   
}

