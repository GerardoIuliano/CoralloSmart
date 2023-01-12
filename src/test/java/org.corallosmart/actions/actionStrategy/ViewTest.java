package org.corallosmart.actions.actionStrategy;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ViewTest {

    @Test
    public void test_TC_U_V_1_0() {
        WelcomeAction action = new WelcomeAction();
        String result = action.view(null);
        assertNull(result);
    }

    @Test
    public void test_TC_U_V_1_1() {
        WelcomeAction action = new WelcomeAction();
        String result=action.view("something");
        Assert.assertEquals("/WEB-INF/views/something.jsp", result);
    }
}
