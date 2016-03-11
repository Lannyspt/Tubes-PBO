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

    public TugasAkhir(String judulTA) {
        this.judulTA = judulTA;
        pembimbing = new Dosen[2];
    }

    public void setJudulTA(String judulTA) {
        this.judulTA = judulTA;
    }

    public String getJudulTA() {
        return judulTA;
    }

    public void setPembimbing(Dosen d, int i) {
        if (i == 0) {
            pembimbing[i] = d;

        } else if (i == 1) {
            pembimbing[i] = d;
        } else {
            System.out.println("Tidak ada tempat untuk pembimbing");
        }
    }

    public String getPembimbing(int n) {
        if (pembimbing[n] != null) {
            return pembimbing[n].getNama();
        }
        return "Tidak ada pembimbing";
    }

    public String getPembimbing(String nama) {
        for (int i = 0; i <= 1; i++) {
            if (pembimbing[i].getNama() == nama) {
                return pembimbing[i].getIdDosen();
            }

        }
        return "Nama Pembimbing tidak ada";

    }
}
