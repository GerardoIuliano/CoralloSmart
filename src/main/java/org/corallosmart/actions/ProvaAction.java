package org.corallosmart.actions;

import org.corallosmart.actions.actionsUtils.ActionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ProvaAction implements ActionStrategy {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        try{
            return view("dashboardArpa");
        } catch (Exception e) {
            e.printStackTrace();
            return view("500");
        }
    }
}
