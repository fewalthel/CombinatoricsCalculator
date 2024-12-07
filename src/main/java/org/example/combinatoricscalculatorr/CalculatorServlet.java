package org.example.combinatoricscalculatorr;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.math.BigInteger;

import static org.example.combinatoricscalculatorr.MathFunctions.*;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int n = Integer.parseInt(request.getParameter("n"));
        int k = Integer.parseInt(request.getParameter("k"));

        String operation = request.getParameter("operation");
        Boolean repeats = request.getParameter("repeats") != null;

        BigInteger result = BigInteger.valueOf(0);

        switch (operation) {
            case "permutations":
                if (repeats) {
                    request.setAttribute("error", "You need to go to the page for counting permutations with repetitions");
                    result = BigInteger.valueOf(400);
                } else {
                    result = Permutations(repeats, n, k);
                }
                break;
            case "combinations":
                if (!repeats && k > n) {
                    request.setAttribute("error", "Error: k must be ≤ n");
                    result = BigInteger.valueOf(400);
                } else if (repeats && n < 1) {
                    request.setAttribute("error", "Error: n must be ≥ 1");
                    result = BigInteger.valueOf(400);
                } else {
                    result = Combinations(repeats, n, k);
                }
                break;
            case "arrangements":
                if (!repeats && k > n) {
                    request.setAttribute("error", "Error: k must be ≤ n");
                    result = BigInteger.valueOf(400);
                } else if (repeats && n < 1) {
                    request.setAttribute("error", "Error: n must be ≥ 1");
                    result = BigInteger.valueOf(400);
                } else {
                    result = Arrangements(repeats, n, k);
                }
                break;
        }

        if (result.compareTo(BigInteger.valueOf(400)) == 0) {
            getServletContext().getRequestDispatcher("/views/calculator.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("result", result);
            response.sendRedirect(getServletContext().getContextPath() + "/result");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/calculator.jsp").forward(request, response);
    }
}