package org.corallosmart.models.modelsEmail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Email {
    private int id;
    private String oggetto;
    private String corpo;
    private int idUtente2;
    private int idVoucher;
}
