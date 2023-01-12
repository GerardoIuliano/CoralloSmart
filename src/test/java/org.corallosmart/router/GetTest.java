package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class GetTest {

    @Test
    public void test_TC_U_G_1_0() {
        Router router = Mockito.spy(new Router(new HashMap<>()));
        Mockito.when(router.addRoute(HttpMethod.GET,"something", Mockito.mock(WelcomeAction.class))).thenReturn(null);
        assertNull(router.get("something", Mockito.mock(WelcomeAction.class)));
    }

    @Test
    public void test_TC_U_G_1_1() {
        Router router = Mockito.spy(new Router(new HashMap<>()));
        Mockito.when(router.addRoute(HttpMethod.GET,"/something", null)).thenReturn(null);
        assertNull(router.get("/something", null));
    }

    @Test
    public void test_TC_U_G_1_2() {
        Router router = Mockito.spy(new Router(new HashMap<>()));
        Mockito.when(router.addRoute(HttpMethod.GET,"/something", Mockito.mock(WelcomeAction.class))).thenReturn(router);
        assertEquals(router.get("/something",Mockito.mock(WelcomeAction.class)),router);
    }


}
