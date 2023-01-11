package org.corallosmart.ActionStrategy;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class viewTest {

    @Test
    public void test_TC_U_V_1_0() {
        WelcomeAction action=Mockito.mock(WelcomeAction.class);
        Mockito.when(action.view(null)).thenReturn(null);
        String result=action.view(null);
        assertNull(result);
    }

    @Test
    public void test_TC_U_V_1_1() {
        WelcomeAction action=Mockito.mock(WelcomeAction.class);
        Mockito.when(action.view("something")).thenReturn("/WEB-INF/views/something.jsp");
        String result=action.view("something");
        Assert.assertEquals("/WEB-INF/views/something.jsp", result);
    }
}
