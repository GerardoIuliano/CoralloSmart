package org.corallosmart.ActionStrategy;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class redirectTest {

    @Test
    public void test_TC_U_R_1_0() {
        WelcomeAction action=Mockito.mock(WelcomeAction.class);
        Mockito.when(action.redirect(null)).thenReturn(null);
        String result=action.redirect(null);
        assertNull(result);
    }

    @Test
    public void test_TC_U_R_1_1() {
        WelcomeAction action=Mockito.mock(WelcomeAction.class);
        Mockito.when(action.redirect("something")).thenReturn("redirect:something");
        String result=action.redirect("something");
        Assert.assertEquals("redirect:something", result);
    }
}
