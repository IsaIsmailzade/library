package com.example.isa.library.servlets;

import com.example.isa.library.service.BookService;
import com.example.isa.library.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.isa.library.util.UrlPath.CATALOG;

@WebServlet(CATALOG)
public class CatalogServlet extends HttpServlet {

    BookService bookService = BookService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", bookService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("catalog"))
                .forward(req, resp);
    }
}
