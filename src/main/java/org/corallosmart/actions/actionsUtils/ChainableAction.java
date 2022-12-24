package org.corallosmart.actions.actionsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class ChainableAction implements ActionStrategy{
    private ActionStrategy next;

    public void setNext(ActionStrategy next){
        this.next = next;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return Objects.nonNull(next) ? next.execute(request, response) : view("500");
    }
}
