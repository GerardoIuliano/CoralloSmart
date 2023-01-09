package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class RouterTest {

    /**
     * Test -   Metodo GET, Url no Match, Action not null
     *
     */
    @Test
    public void testAddRouteWithNoRoutes() {
        Router router = new Router(new HashMap<>());
        Router result = router.addRoute(HttpMethod.GET, "kjgug2324", Mockito.mock(WelcomeAction.class));
        assertNull(result);
    }

}