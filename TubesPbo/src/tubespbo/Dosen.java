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
    
    public Dosen(String nama,int tanggalLahir,double noHandphone,String jenisKelamin,String idDosen,int n){
       super(nama,tanggalLahir,noHandphone,jenisKelamin);
       this.idDosen=idDosen;
       KelompokTA[] topikTA=new KelompokTA[n];
    }
    
    public void statusDosen(int status){
        
    }

    public String getIdDosen() {
        return idDosen;
    }

    public void setIdDosen(String idDosen) {
        this.idDosen = idDosen;
    }
     public int nomerTopik=0;
    public void createKelompokTA(String topik,int n){
        if (nomerTopik < topikTA.length){
        topikTA[nomerTopik]=new KelompokTA(topik,n);
        nomerTopik++;
        }
    }
    
   public String getJabatan(){
       return "Dosen";
   }
   
   
   public Dosen getKelompokTA (int idx){
       return topikTA[idx];
   }
   
   public Dosen getKelompok(String topik){
    Dosen a = null;
    for (int i = 0; i <= KelompokTA.length; i++){
        if (KelompokTA[i].getTopik().equals(topik)){
            a = KelompokTA[i];
        } else {
            a = null;
        }
    }
    return a;
   }
   
   public void deleteKelompok(int idx){
       if ((KelompokTA.length<=idx) && (idx<0)){
           KelompokTA[idx]=null;
           System.out.println("kelompok ke "+(idx+1)+" telah dihapus");
       } else {
           System.out.println("kelompok tidak dapat dihapus");
       }
   }
   
   
}

