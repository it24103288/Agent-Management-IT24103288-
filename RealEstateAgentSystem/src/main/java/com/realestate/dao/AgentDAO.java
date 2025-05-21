package com.realestate.dao;

import com.realestate.model.Agent;
import java.io.*;
import java.util.LinkedList;

public class AgentDAO {
    private String getFilePath() {
        return "C:\\Users\\HP\\Desktop\\RealEstateAgentSystem\\src\\main\\resources\\Agentdetails.txt";
    }

    public void saveAgents(LinkedList<Agent> agents) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath()))) {
            for (Agent agent : agents) {
                writer.write(agent.toString());
                writer.newLine();
            }
        }
    }

    public LinkedList<Agent> loadAgents() throws IOException {
        LinkedList<Agent> agents = new LinkedList<>();
        File file = new File(getFilePath());
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 4) {
                        Agent agent = new Agent(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                        agents.add(agent);
                    }
                }
            }
        }
        return agents;
    }

    public void createAgent(Agent agent) throws IOException {
        LinkedList<Agent> agents = loadAgents();
        agents.add(agent);
        saveAgents(agents);
        Agent.getAgentList().add(agent);
    }

    public Agent readAgent(String name) throws IOException {
        LinkedList<Agent> agents = loadAgents();
        for (Agent agent : agents) {
            if (agent.getName().equals(name)) {
                return agent;
            }
        }
        return null;
    }

    public void updateAgent(Agent updatedAgent) throws IOException {
        LinkedList<Agent> agents = loadAgents();
        for (int i = 0; i < agents.size(); i++) {
            if (agents.get(i).getName().equals(updatedAgent.getName())) {
                agents.set(i, updatedAgent);
                break;
            }
        }
        saveAgents(agents);
        Agent.getAgentList().clear();
        Agent.getAgentList().addAll(agents);
    }

    public void deleteAgent(String name) throws IOException {
        LinkedList<Agent> agents = loadAgents();
        agents.removeIf(agent -> agent.getName().equals(name));
        saveAgents(agents);
        Agent.getAgentList().clear();
        Agent.getAgentList().addAll(agents);
    }
}
