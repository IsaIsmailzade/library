package com.example.isa.library.servlets;

import com.example.isa.library.dto.AdminDto;
import com.example.isa.library.dto.UserDto;
import com.example.isa.library.service.AdminService;
import com.example.isa.library.util.JspHelper;
import com.example.isa.library.util.UrlPath;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet(UrlPath.ADMIN_LOGIN)
public class AdminLoginServlet extends HttpServlet {

    AdminService adminService = AdminService.getINSTANCE();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        adminService.login(req.getParameter("email"), req.getParameter("password"))
                .ifPresentOrElse(
                        admin -> onLoginSuccess(admin, req, resp),
                        () -> onLoginFail(req, resp)
                );
    }

    @SneakyThrows
    private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/login?error&email=" + req.getParameter("email"));
    }

    @SneakyThrows
    private void onLoginSuccess(AdminDto admin, HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().setAttribute("admin", admin);
        resp.sendRedirect("/admin");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspHelper.getPath("adminLogin"))
                .forward(req, resp);
    }
}
