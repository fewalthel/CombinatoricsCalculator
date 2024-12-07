package org.example.combinatoricscalculatorr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/urn_model")
public class UrnModelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int n = Integer.parseInt(request.getParameter("n"));
        int k = Integer.parseInt(request.getParameter("k"));
        int r = Integer.parseInt(request.getParameter("r"));
        int m = Integer.parseInt(request.getParameter("m"));

        if (m > n) {
            request.setAttribute("error", "Error: m must be ≤ n");
            getServletContext().getRequestDispatcher("/views/urn_model.jsp").forward(request, response);
        } else if (k > n) {
            request.setAttribute("error", "Error: k must be ≤ n");
            getServletContext().getRequestDispatcher("/views/urn_model.jsp").forward(request, response);
        } else if (r > m) {
            request.setAttribute("error", "Error: r must be ≤ m");
            getServletContext().getRequestDispatcher("/views/urn_model.jsp").forward(request, response);
        } else if (r > k) {
            request.setAttribute("error", "Error: r must be ≤ k");
            getServletContext().getRequestDispatcher("/views/urn_model.jsp").forward(request, response);
        } else {
            double result = MathFunctions.UrnModel(n, m, k, r);
            request.getSession().setAttribute("result", result);
            response.sendRedirect(getServletContext().getContextPath() + "/result");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/views/urn_model.jsp").forward(request, response);
    }
}