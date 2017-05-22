package com.zhang.jiwei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhang.jiwei.entity.Customer;
import com.zhang.jiwei.helper.DatabaseHelper;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class customer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql = "select * from ceshi3";
        List<Customer> customerList = DatabaseHelper.queryEntityList(Customer.class, sql);
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
