package com.isa.jjdd6.homework6b;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aplikacja")
public class AplikacjaServlet extends HttpServlet {

    @Inject
    Fibonacci fibonacci;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


    }
}
