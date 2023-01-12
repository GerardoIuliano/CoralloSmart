package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.ActionStrategy;
import org.corallosmart.actions.actionsUtils.NotFoundAction;
import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

public class HandleRouteTest
{
    @Test
    public void test_TC_U_HR_1_0()
    {
        Router router = new Router(new HashMap<>());
        router.get("/something", Mockito.mock(WelcomeAction.class));

        ActionStrategy actionStrategy = (ActionStrategy) router.handleRoute(null, "/something");
        boolean isOk = actionStrategy.getClass().equals(NotFoundAction.class);
        System.out.println(actionStrategy.getClass().toString());
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_U_HR_1_1()
    {
        Router router = new Router(new HashMap<>());
        router.get("/something", Mockito.mock(WelcomeAction.class));

        ActionStrategy actionStrategy = (ActionStrategy) router.handleRoute(HttpMethod.GET, "something");
        boolean isOk = actionStrategy.getClass().equals(NotFoundAction.class);
        System.out.println(actionStrategy.getClass().toString());
        Assert.assertTrue(isOk);
    }

    @Test
    public void test_TC_U_HR_1_2()
    {
        Router router = new Router(new HashMap<>());
        router.get("/something", Mockito.mock(WelcomeAction.class));

        ActionStrategy actionStrategy = (ActionStrategy) router.handleRoute(HttpMethod.GET, "/something");
        boolean isOk = actionStrategy.getClass().equals(Mockito.mock(WelcomeAction.class).getClass());
        System.out.println(actionStrategy.getClass().toString());
        Assert.assertTrue(isOk);
    }
}
