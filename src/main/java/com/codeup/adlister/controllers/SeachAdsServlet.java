package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="SearchAdsServlet", urlPatterns = "/search")
public class SeachAdsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String term = request.getParameter("term");
        request.setAttribute("ads", DaoFactory.getAdsDao().search(term));
        request.getRequestDispatcher("WEB-INF/ads/index.js");
    }
}
