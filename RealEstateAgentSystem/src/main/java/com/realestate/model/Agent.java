package com.realestate.model;


import java.util.LinkedList;

public class Agent {
    private String name;
    private String contactInfo;
    private String specialties;
    private int experienceYears;

    private static LinkedList<Agent> agentList = new LinkedList<>();

    public Agent() {}

    public Agent(String name, String contactInfo, String specialties, int experienceYears) {
        this.name = name;
        this.contactInfo = contactInfo;
        this.specialties = specialties;
        this.experienceYears = experienceYears;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public String getSpecialties() { return specialties; }
    public void setSpecialties(String specialties) { this.specialties = specialties; }
    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    public static LinkedList<Agent> getAgentList() { return agentList; }
    public static void setAgentList(LinkedList<Agent> list) { agentList = list; }

    @Override
    public String toString() {
        return name + "|" + contactInfo + "|" + specialties + "|" + experienceYears;
    }
}
