package org.corallosmart.models.modelsContributo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contributo {
    private int id;
    private Date data;
    private double importo;
}
