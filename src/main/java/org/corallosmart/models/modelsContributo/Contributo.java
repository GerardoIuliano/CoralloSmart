package org.corallosmart.models.modelsContributo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 *@author tutti
 * Bean Contributo
 */
@Getter
@Setter
@NoArgsConstructor
public class Contributo {
    private int id;
    private Date data;
    private double importo;
    private int idUtente;
    private int idEmail;
    private int idVoucher2;

    public Contributo(Date data, double importo,int idUtente, int idEmail, int idVoucher2) {
        this.data = data;
        this.importo = importo;
        this.idUtente = idUtente;
        this.idEmail = idEmail;
        this.idVoucher2 = idVoucher2;

    }

    public Contributo(Date data, double importo,int idUtente, int idEmail) {
        this.data = data;
        this.importo = importo;
        this.idUtente = idUtente;
        this.idEmail = idEmail;
    }
}

