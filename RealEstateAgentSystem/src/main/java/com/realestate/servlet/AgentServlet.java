package com.realestate.servlet;


import com.realestate.dao.AgentDAO;
import com.realestate.model.Agent;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/agents/*")
public class AgentServlet extends HttpServlet {
    private AgentDAO agentDAO;

    @Override
    public void init() throws ServletException {
        System.out.println("Initializing AgentServlet...");
        agentDAO = new AgentDAO();
        try {
            System.out.println("Loading agents...");
            Agent.getAgentList().addAll(agentDAO.loadAgents());
            System.out.println("Agents loaded successfully.");
        } catch (IOException e) {
            System.err.println("Failed to load agents: " + e.getMessage());
            throw new ServletException("Failed to load agents", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            request.setAttribute("agents", Agent.getAgentList());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (pathInfo.equals("/edit")) {
            String name = request.getParameter("name");
            Agent agent = agentDAO.readAgent(name);
            request.setAttribute("agent", agent);
            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } else if (pathInfo.equals("/view")) {
            String name = request.getParameter("name");
            Agent agent = agentDAO.readAgent(name);
            request.setAttribute("agent", agent);
            request.getRequestDispatcher("/view.jsp").forward(request, response);
        } else if (pathInfo.equals("/delete")) {
            String name = request.getParameter("name");
            agentDAO.deleteAgent(name);
            response.sendRedirect(request.getContextPath() + "/agents");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Received POST request to: " + request.getPathInfo());
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || pathInfo.equals("/")) {
            System.out.println("Processing new agent registration...");
            String name = request.getParameter("name");
            String contactInfo = request.getParameter("contactInfo");
            String specialties = request.getParameter("specialties");
            String experienceYearsStr = request.getParameter("experienceYears");
            int experienceYears = Integer.parseInt(experienceYearsStr);

            System.out.println("Creating new Agent object...");
            Agent agent = new Agent(name, contactInfo, specialties, experienceYears);
            System.out.println("Calling agentDAO.createAgent...");
            agentDAO.createAgent(agent);
            System.out.println("Agent created successfully.");
        } else if (pathInfo.equals("/edit")) {
            String name = request.getParameter("name");
            String contactInfo = request.getParameter("contactInfo");
            String specialties = request.getParameter("specialties");
            String experienceYearsStr = request.getParameter("experienceYears");
            int experienceYears = Integer.parseInt(experienceYearsStr);

            Agent updatedAgent = new Agent(name, contactInfo, specialties, experienceYears);
            agentDAO.updateAgent(updatedAgent);
        }
        System.out.println("Redirecting to: " + request.getContextPath() + "/agents");
        response.sendRedirect(request.getContextPath() + "/agents");
    }
}
