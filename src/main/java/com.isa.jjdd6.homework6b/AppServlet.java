package com.isa.jjdd6.homework6b;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.math.NumberUtils;

import com.isa.jjdd6.homework6b.freemarker.TemplateProvider;

@RequestScoped
@WebServlet("/")
public class AppServlet extends HttpServlet {

    @Inject
    Fibonacci fibonacci;

    @Inject
    TemplateProvider templateProvider;

    private List<Long> fibAll = new ArrayList<>();
    private Map<String, Object> model = new HashMap();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        Template template = templateProvider.getTemplate(getServletContext(), "main.ftlh");

        try {
            template.process(model, resp.getWriter());
        } catch (TemplateException e) {
            resp.getWriter().println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html;charset=UTF-8");

        String param = req.getParameter("fibonacci");

        int fibWord = NumberUtils.toInt(param, -1);

        if (fibWord >= 0 && fibWord <= 96) {
            fibAll = fibonacci.count(fibWord);
            model.put("fibAll", fibAll);
            model.put("last", fibAll.get(fibWord));
            model.put("requested", fibWord);
        } else {
            model.remove("last");
            model.remove("fibAll");
            model.remove("reqested");
        }
        doGet(req, resp);
    }
}
