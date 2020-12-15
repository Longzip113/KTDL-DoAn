package com.longnguyen.controller;

import com.longnguyen.service.RunService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/web-home", "/run"})
public class HomeControler extends HttpServlet {
    RunService runService = new RunService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numPerson = req.getParameter("NumberOfPeople");
        String domain = req.getParameter("domain");
        String restingPlace = req.getParameter("restingPlace");
        String vehicle = req.getParameter("vehicle");
        String day = req.getParameter("day");
        String kq = "";

        System.out.println(numPerson + domain + day + restingPlace + vehicle);

        runService.saveFileArff(numPerson,domain,restingPlace,vehicle,day);
        try {
            kq = runService.runAlgorithm();
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("ketqua", runService.converterData(kq,numPerson,domain,restingPlace,vehicle,day));

        System.out.println(runService.converterData(kq,numPerson,domain,restingPlace,vehicle,day));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/home.jsp");
        requestDispatcher.forward(req, resp);
    }
}
