package org.corallosmart.managers.managersRilevamento;

import org.corallosmart.models.modelsRilevamento.Rilevamento;
import org.corallosmart.models.modelsVoucher.Voucher;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface RilevamentoManager {
    public List<Rilevamento> cercaRilevamento(int id) throws SQLException;

    void inserisciRilevamento(Date dataRicezione,String latitudine, String longitudine, Double DissolvedOxygen, Double OxidationReductionPotential, Double pHTurbidity,Double TotalDissolvedSolids, Double turbidity,String temperatura) throws SQLException;


    public List<Rilevamento> cercaRilevamentoData(Date data) throws SQLException;

    public List<Rilevamento> listaRilevamenti() throws SQLException;
}
