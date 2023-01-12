package org.corallosmart.actions.actionStrategy;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RedirectTest {

    @Test
    public void test_TC_U_R_1_0() {
        WelcomeAction action = new WelcomeAction();
        String result = action.redirect(null);
        assertNull(result);
    }

    @Test
    public void test_TC_U_R_1_1() {
        WelcomeAction action = new WelcomeAction();
        String result = action.redirect("something");
        Assert.assertEquals("redirect:something", result);
    }
}
