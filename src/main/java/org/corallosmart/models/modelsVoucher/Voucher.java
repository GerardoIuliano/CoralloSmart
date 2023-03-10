package org.corallosmart.models.modelsVoucher;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author team
 * Bean Voucher
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Voucher {
    private int id;
    private String descrizione;
    private double importo;
}
