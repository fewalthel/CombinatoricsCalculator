package org.example.combinatoricscalculatorr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;


@WebServlet("/perms_with_repeats")
public class PermsWithRepeatsServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int n = Integer.parseInt(request.getParameter("n"));
        int k = Integer.parseInt(request.getParameter("k"));
        int sum = 0;

        ArrayList<Integer> perms = new ArrayList<>();

        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();

            System.out.print("Параметр '" + paramName + "': ");
            if (paramValues != null && paramValues.length > 0) {
                if (paramValues.length == 1) {
                    System.out.println(paramValues[0]);
                    int current = Integer.parseInt(paramValues[0]);
                    if (current != n && current != k) {
                        perms.add(current);
                    }
                    sum += current;
                }
            }
        }

        sum -= (n + k);
        BigInteger result;

        if (k != parameterMap.size() - 2) {
            request.setAttribute("error", "Error: amount of n1, n2, ..., nk you selected must = k");
            getServletContext().getRequestDispatcher("/views/perms_with_repeats.jsp").forward(request, response);
        } else if (sum != n) {
            request.setAttribute("error", "Error: sum of all elements must = n");
            getServletContext().getRequestDispatcher("/views/perms_with_repeats.jsp").forward(request, response);
        } else {
            result = MathFunctions.Permutations(n, perms);
            request.getSession().setAttribute("result", result);
            response.sendRedirect(getServletContext().getContextPath() + "/result");
        }
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        getServletContext().getRequestDispatcher("/views/perms_with_repeats.jsp").forward(request, response);
    }

}