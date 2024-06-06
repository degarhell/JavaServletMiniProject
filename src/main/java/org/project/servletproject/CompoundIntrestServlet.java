package org.project.servletproject;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "compound", value = "")
public class CompoundIntrestServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mA = request.getParameter("moneyAmount");
        String iR = request.getParameter("interestRate");
        String nY = request.getParameter("numberYears");
        String tPY = request.getParameter("timesPerYear");
        if ((mA == null) || (iR == null) || (nY == null) || (tPY == null)) {
            request.setAttribute("error", "One or more parameters are missing");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (Double.parseDouble(iR) < 0.0 || Double.parseDouble(iR) > 100.0 || Double.parseDouble(mA) <= 0.0 || Double.parseDouble(nY) <= 0.0 || Double.parseDouble(tPY) <= 0.0) {
            request.setAttribute("error", "One or more attributes are invalid");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            String result = compoundInterestCalculator(mA, iR, nY, tPY);
            request.setAttribute("result", result);
            request.setAttribute("moneyAmount", mA);
            request.setAttribute("interestRate", iR);
            request.setAttribute("numberYears", nY);
            request.setAttribute("timesPerYear", tPY);
        }

        doGet(request, response);
    }

    private String compoundInterestCalculator(String moneyAmount, String interestRate, String  numberYears, String timesPerYear) {
        double calculation = (Double.parseDouble(moneyAmount) * (Math.pow((1.0 + (Double.parseDouble(interestRate)/(100*Double.parseDouble(timesPerYear)))), (Double.parseDouble(timesPerYear)*Double.parseDouble(numberYears)))));
        String result = Double.toString(calculation);
        int n = result.indexOf('.');
        result = result.substring(0, n+3);
        return result;
    }

    public void destroy() {
    }
}