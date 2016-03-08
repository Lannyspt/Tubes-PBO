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
public class Mahasiswa extends Orang {
    private TugasAkhir tugasAkhir;
    private String idMahasiswa;

    public Mahasiswa(String nama,int tanggalLahir,double noHandphone,String jenisKelamin,String idMahasiswa){
      super(nama,tanggalLahir,noHandphone,jenisKelamin);
      this.idMahasiswa=idMahasiswa;
    }
    
    public String getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(String idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }
    public void createTA(String judul){
        TugasAkhir t=new TugasAkhir(judul);
    }
    
    public void statusMhs(String status){
        
    }
    public String getJabatan(){
        return "Mahasiswa";
    }
    public void revisiTA(Mahasiswa nama,TugasAkhir judul){
        
    }
    
    public TugasAkhir getTugasAkhir(){
        return tugasAkhir;
    }
    
    
}
