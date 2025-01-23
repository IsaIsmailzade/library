package com.example.isa.library.servlets;

import com.example.isa.library.entity.Books;
import com.example.isa.library.service.BooksService;
import com.example.isa.library.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/bookPage")
public class BookPageServlet extends HttpServlet {

    private final BooksService booksService = BooksService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");

        if (bookId != null) {
            try {
                Long id = Long.parseLong(bookId);
                Optional<Books> bookOptional = booksService.findById(id);
                if (bookOptional.isPresent()) {
                    req.setAttribute("book", bookOptional.get());
                    req.getRequestDispatcher(JspHelper.getPath("bookPage")).forward(req, resp);
                } else {
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Book not found");
                }
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid book ID format");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book ID is missing");
        }
    }
}
