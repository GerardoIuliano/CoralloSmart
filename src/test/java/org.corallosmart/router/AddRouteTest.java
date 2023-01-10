package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class AddRouteTest {

    /**
     * Test -   Metodo GET, Url valid, Action not null
     *
     */
    @Test
    public void testAddRouteOk() {
        Router router = new Router(new HashMap<>());
        Router result = router.addRoute(HttpMethod.GET, "/something", Mockito.mock(WelcomeAction.class));
        assertNotNull(result);

        System.out.println("size: " + result.getActionMap().size());
        result.printMap();
    }

    /**
     * Test -   Metodo null, Url valid, Action not null
     *
     */
    @Test
    public void testAddRouteWithWrongMethod() {
        Router router = new Router(new HashMap<>());
        Router result = router.addRoute(null, "/something", Mockito.mock(WelcomeAction.class));
        assertNull(result);
    }

    /**
     * Test -   Metodo GET, Url wrong, Action not null
     *
     */
    @Test
    public void testAddRouteWithWrongUrl() {
        Router router = new Router(new HashMap<>());
        Router result = router.addRoute(HttpMethod.GET, "something", Mockito.mock(WelcomeAction.class));
        assertNull(result);
    }

    /**
     * Test -   Metodo GET, Url valid, Action null
     *
     */
    @Test
    public void testAddRouteWithWrongAction() {
        Router router = new Router(new HashMap<>());
        Router result = router.addRoute(HttpMethod.GET, "/something", null);
        assertNull(result);
    }
}