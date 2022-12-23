package org.corallosmart.models.modelsDispositivo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dispositivo {
    private int id;
    private String latitudine;
    private String longitudine;
    private String qualita;
    private Date dataImmersione;
    private int DOSensor;
    private int ORPSensor;
    private int pHSensor;
    private int TurbiditySensor;
    private int TDSSensor;
    private int TempSensor;
}
