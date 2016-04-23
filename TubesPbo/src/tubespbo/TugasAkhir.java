/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.util.ArrayList;

/**
 *
 * @author Martcel
 */
public class TugasAkhir {

    private ArrayList<Dosen> pembimbing=new ArrayList<>();
    private String judulTA;
    private String status;
    

    public TugasAkhir(String judulTA) {
        this.judulTA = judulTA;
        status = "Belum Lulus";
    }

    public void setJudulTA(String judulTA) {
        this.judulTA = judulTA;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    

    public String getJudulTA() {
        return judulTA;
    }

    public void setPembimbing(Dosen d, int i) {
        if (i == 0) {
            pembimbing.add(d);

        } else if (i == 1) {
            pembimbing.add(d);
        } else {
            System.out.println("Tidak ada tempat untuk pembimbing");
        }
    }

    public Dosen getPembimbing(int n) {
        if (pembimbing.get(n) != null) {
            return pembimbing.get(n);
        }
        return null;
    }

    public Dosen getPembimbing(String nama) {
        for (int i = 0; i <= 1; i++) {
            if (pembimbing.get(i).getNama() == nama) {
                return pembimbing.get(i);
            }

        }
        return null;

    }
}
