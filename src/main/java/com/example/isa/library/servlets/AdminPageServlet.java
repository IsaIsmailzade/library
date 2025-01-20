package com.example.isa.library.servlets;

import com.example.isa.library.dto.CreateBookDto;
import com.example.isa.library.exception.ValidationException;
import com.example.isa.library.service.BooksService;
import com.example.isa.library.util.JspHelper;
import com.example.isa.library.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(UrlPath.ADMIN)
public class AdminPageServlet extends HttpServlet {

    BooksService booksService = BooksService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CreateBookDto createBookDto = CreateBookDto.builder()
                .title(req.getParameter("title"))
                .author(req.getParameter("author"))
                .description(req.getParameter("description"))
                .build();

        try {
            booksService.create(createBookDto);
            resp.sendRedirect("/adminPage");
        } catch (ValidationException e) {
            req.setAttribute("errors", e.getErrors());
            doGet(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("adminPage"))
                .forward(req, resp);
    }
}
