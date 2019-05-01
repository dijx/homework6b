package com.isa.jjdd6.homework6b;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.commons.lang3.math.NumberUtils;

@WebServlet("/aplikacja")
public class AplikacjaServlet extends HttpServlet {

    @Inject
    Fibonacci fibonacci;

    NumberUtils numberUtils = new NumberUtils();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String param = req.getParameter("fibonacci");

        int fibonacci = numberUtils.toInt(param, -1);

        resp.getWriter().println(param+"  "+fibonacci);

    }
}
