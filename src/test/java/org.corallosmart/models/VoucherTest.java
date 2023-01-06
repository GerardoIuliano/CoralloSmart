package org.corallosmart.models;

import org.corallosmart.models.modelsVoucher.Voucher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoucherTest {

    private Voucher voucher;

    /**
     * Metodo che inizializza un annuncio
     *
     */
    @BeforeEach
    public void init() {
        voucher= new Voucher();
    }

    /**
     * Test per il metodo getId
     *
     */
    @Test
    public void getIdTest() {
        int id = voucher.getId();
        assertEquals(1, id, "Should return 1");
    }
}