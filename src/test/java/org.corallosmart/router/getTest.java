package org.corallosmart.router;

import org.corallosmart.actions.actionsUtils.WelcomeAction;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

public class getTest {

    @Test
    public void test_TC_U_G_1_0() {
        Router router = new Router(new HashMap<>());
        Router result = router.get("something", Mockito.mock(WelcomeAction.class));
        assertNull(result);
    }

    @Test
    public void test_TC_U_G_1_1() {
        Router router = new Router(new HashMap<>());
        Router result = router.get("/something", null);
        assertNull(result);
    }

    @Test
    public void test_TC_U_G_1_2() {
        Router router = new Router(new HashMap<>());
        Router result= router.get("/something", Mockito.mock(WelcomeAction.class));
        assertNotNull(result);

        result.printMap();
    }
}
