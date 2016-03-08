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
}
