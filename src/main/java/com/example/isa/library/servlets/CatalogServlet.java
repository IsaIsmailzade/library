package com.example.isa.library.servlets;

import com.example.isa.library.dao.BooksDao;
import com.example.isa.library.service.BooksService;
import com.example.isa.library.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {

    BooksService booksService = BooksService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books", booksService.findAll());

        req.getRequestDispatcher(JspHelper.getPath("catalog"))
                .forward(req, resp);
    }
}
