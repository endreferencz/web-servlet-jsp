package com.epam.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mail")
public class MailServiceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String to = (String) req.getAttribute("to");
        String subject = (String) req.getAttribute("subject");
        String text = (String) req.getAttribute("text");

        MailService ms = new MailService();
        ms.sendMail(to, new EmailMessage(subject, text));

        req.getRequestDispatcher("/admin/index").forward(req, resp);
    }
}
