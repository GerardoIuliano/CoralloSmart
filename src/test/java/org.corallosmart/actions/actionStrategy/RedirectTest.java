package org.corallosmart.actions.actionStrategy;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Giuseppe Adinolfi
 */

public class RedirectTest {

    /**
     * Controlla che passando null al metodo redirect, esso restituisce null
     */

    @Test
    public void test_TC_U_R_1_0() {
        WelcomeAction action = new WelcomeAction();
        String result = action.redirect(null);
        assertNull(result);
    }

    /**
     * Controlla che passando una stringa al metodo redirect, esso restituisce la stringa giusta
     */

    @Test
    public void test_TC_U_R_1_1() {
        WelcomeAction action = new WelcomeAction();
        String result = action.redirect("something");
        Assert.assertEquals("redirect:something", result);
    }
}
