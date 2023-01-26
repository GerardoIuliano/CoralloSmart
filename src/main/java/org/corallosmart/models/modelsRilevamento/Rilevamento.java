package org.corallosmart.models.modelsRilevamento;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 *@author team
 * Bean Rilevamento
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rilevamento {
    private int id;
    private Date dataRicezione;
    private String latitudine;
    private String longitudine;
    private double DissolvedOxygen;
    private int OxidationReductionPotential;
    private int pHTurbidity;
    private int TotalDissolvedSolids;
    private int turbidity;
    private String temperatura;
}
