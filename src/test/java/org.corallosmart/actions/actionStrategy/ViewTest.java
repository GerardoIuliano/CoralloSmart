package org.corallosmart.actions.actionStrategy;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Giuseppe Adinolfi
 */

public class ViewTest {

    /**
     * Controlla che passando null al metodo view, esso restituisce null
     */

    @Test
    public void test_TC_U_V_1_0() {
        WelcomeAction action = new WelcomeAction();
        String result = action.view(null);
        assertNull(result);
    }

    /**
     * Controlla che passando una stringa al metodo view, esso restituisce la stringa giusta
     */

    @Test
    public void test_TC_U_V_1_1() {
        WelcomeAction action = new WelcomeAction();
        String result=action.view("something");
        Assert.assertEquals("/WEB-INF/views/something.jsp", result);
    }
}
