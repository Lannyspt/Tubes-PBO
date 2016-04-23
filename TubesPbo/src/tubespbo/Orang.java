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
public abstract class Orang {
    private String nama;
    private String noHandphone;
    private String jenisKelamin;
    
    public Orang(String nama,String noHandphone,String jenisKelamin){
        this.nama=nama;
        this.noHandphone=noHandphone;
        this.jenisKelamin=jenisKelamin;
}
    public void setNama(String nama){
        this.nama=nama;
    }
    public String getNama(){
        return nama;
    }
    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
   public abstract String getJabatan();
}
