package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Giuseppe Adinolfi
 */

public class GetTest {

    /**
     * (Test di unità) Controlla che il metodo get,se viene passato un url che non inizia con lo "/", restituisce null
     */

    @Test
    public void test_TC_U_G_1_0() {
        Router router = Mockito.spy(new Router(new HashMap<>()));
        Mockito.when(router.addRoute(HttpMethod.GET,"something", Mockito.mock(WelcomeAction.class))).thenReturn(null);
        assertNull(router.get("something", Mockito.mock(WelcomeAction.class)));
    }

    /**
     * (Test di unità) Controlla che il metodo get, se viene passata una actionStrategy null, restituisce null
     */

    @Test
    public void test_TC_U_G_1_1() {
        Router router = Mockito.spy(new Router(new HashMap<>()));
        Mockito.when(router.addRoute(HttpMethod.GET,"/something", null)).thenReturn(null);
        assertNull(router.get("/something", null));
    }

    /**
     * (Test di unità) Controlla che il metodo get, se viene passata una stringa che inizia con lo "/" e una action not null, restituisce un router
     */

    @Test
    public void test_TC_U_G_1_2() {
        Router router = Mockito.spy(new Router(new HashMap<>()));
        Mockito.when(router.addRoute(HttpMethod.GET,"/something", Mockito.mock(WelcomeAction.class))).thenReturn(router);
        assertEquals(router.get("/something",Mockito.mock(WelcomeAction.class)),router);
    }

    /**
     * (Test di integrazione) Controlla che il metodo get,se viene passato un url che non inizia con lo "/", restituisce null
     */

    @Test
    public void test_TC_I_G_1_0() {
        Router router = new Router(new HashMap<>());
        Router result = router.get("something", Mockito.mock(WelcomeAction.class));
        assertNull(result);
    }

    /**
     * (Test di integrazione) Controlla che il metodo get, se viene passata una actionStrategy null, restituisce null
     */

    @Test
    public void test_TC_I_G_1_1() {
        Router router = new Router(new HashMap<>());
        Router result = router.get("/something", null);
        assertNull(result);
    }

    /**
     * (Test di integrazione) Controlla che il metodo get, se viene passata una stringa che inizia con lo "/" e una action not null, restituisce un router
     */

    @Test
    public void test_TC_I_G_1_2() {
        Router router = new Router(new HashMap<>());
        Router result= router.get("/something", Mockito.mock(WelcomeAction.class));
        assertNotNull(result);
    }
}
