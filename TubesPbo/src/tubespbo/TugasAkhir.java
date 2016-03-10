/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author USER
 */
public class TugasAkhir {
    private Dosen[] pembimbing;
    private String judulTA;
    
    public TugasAkhir(String judulTA){
        this.judulTA=judulTA;
        Dosen[] pembimbing=new Dosen[2];
    }
    
    public void setPembimbing(Dosen d,int i){
     if (i==1){
         pembimbing[0]=d;
         
     }else {
         pembimbing[1]=d;
     }   
    }
    
    public Dosen getDosen(int n){
        return pembimbing[n];
    }
}
