package org.corallosmart.actions.actionsUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author theboys
 */
public interface ActionStrategy {

    static final String VIEW_PATH = "/WEB-INF/views/";

    /**
     * Exec a request action
     * @param request the request
     * @param response the response
     * @return can return a URL or a view name
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException;


    default String view(String viewName) {
        return VIEW_PATH.concat(viewName).concat(".jsp");
    }

    default DataSource getSource(HttpServletRequest req) {
        return (DataSource) req.getServletContext().getAttribute("db");
    }

    default String redirect(String url) {
        return "redirect:".concat(url);
    }

}