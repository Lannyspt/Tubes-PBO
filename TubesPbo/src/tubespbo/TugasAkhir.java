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
public class TugasAkhir {
    private Dosen[] pembimbing;
    private String judulTA;
    
    public TugasAkhir(String judulTA){
        this.judulTA=judulTA;
        Dosen[] pembimbing=new Dosen[2];
    }
    public void setJudulTA(String judulTA){
        this.judulTA=judulTA;
    }
    public String getJudulTA(){
        return judulTA;
    }
    public void setPembimbing(Dosen d,int i){
     if (i==0){
         pembimbing[0]=d;
         
     }else {
         pembimbing[1]=d;
     }   
    }
    public Dosen getPembimbing(int n){
        return pembimbing[n];
    }
    public Dosen getPembimbing(String nama){
        for (int i=0;i<=1;i++){
            if (nama==pembimbing[i]){
                return pembimbing[i];
            }
            else{return "Nama Pembimbing tidak ada"};
        }
    }
}
