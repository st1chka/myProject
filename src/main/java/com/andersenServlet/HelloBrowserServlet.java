package com.andersenServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/first_servlet")
public class HelloBrowserServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(HelloBrowserServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().printf("<html><body>");
        for (int i = 0; i < 10; i++) {
            resp.getWriter().printf("<h1>" + i + "</h1>");
        }
        resp.getWriter().printf("</html></body>");
    }

    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() {
        logger.debug("Init");
    }
}
