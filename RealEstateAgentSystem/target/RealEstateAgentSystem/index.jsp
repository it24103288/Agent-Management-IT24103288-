```jsp
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Real Estate Agent Finder and Appointment System</title>
  <style>
    body { font-family: Arial, sans-serif; background-color: #f5ece0; margin: 0; padding: 20px; text-align: center; }
    h1 { color: #5a4032; }
    h2 { color: #5a4032; }
    .registration { background-color: #e8d8c8; padding: 20px; border-radius: 10px; display: inline-block; margin-bottom: 20px; }
    .form-group { margin: 10px; }
    label { margin-right: 10px; }
    input { padding: 10px; margin: 5px; border: none; border-radius: 5px; }
    button { padding: 10px 20px; background-color: #5a4032; color: white; border: none; border-radius: 5px; cursor: pointer; }
    button:hover { background-color: #3d2c22; }
    .profile { background-color: #e8d8c8; padding: 20px; border-radius: 10px; display: inline-block; margin-top: 20px; }
    .profile p { margin: 5px 0; }
    .actions button { margin: 0 5px; }
  </style>
</head>
<body>
<h1>Real Estate Agent Finder and Appointment System</h1>
<h2>Agent Registration</h2>
<div class="registration">
  <form action="${pageContext.request.contextPath}/agents" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" id="name" name="name" placeholder="Name" required>
    </div>
    <div class="form-group">
      <label for="contactInfo">Contact Info:</label>
      <input type="text" id="contactInfo" name="contactInfo" placeholder="Contact Info" required>
    </div>
    <div class="form-group">
      <label for="specialties">Specialties:</label>
      <input type="text" id="specialties" name="specialties" placeholder="Specialties" required>
    </div>
    <div class="form-group">
      <label for="experienceYears">Experience (Years):</label>
      <input type="number" id="experienceYears" name="experienceYears" placeholder="Experience (Years)" required>
    </div>
    <button type="submit">Register</button>
  </form>
</div>
<h2>Agent Profiles</h2>
<div class="profile">
  <%
    java.util.LinkedList<com.realestate.model.Agent> agents = com.realestate.model.Agent.getAgentList();
    for (com.realestate.model.Agent agent : agents) {
  %>
  <div style="margin-bottom: 20px;">
    <p><strong>Agent Name:</strong> <%= agent.getName() %></p>
    <p><strong>Contact Info:</strong> <%= agent.getContactInfo() %></p>
    <p><strong>Specialties:</strong> <%= agent.getSpecialties() %></p>
    <p><strong>Experience:</strong> <%= agent.getExperienceYears() %> Years</p>
    <div class="actions">
      <button onclick="window.location.href='${pageContext.request.contextPath}/agents/edit?name=<%= java.net.URLEncoder.encode(agent.getName(), "UTF-8") %>'">Update</button>
      <button onclick="if(confirm('Are you sure?')) window.location.href='${pageContext.request.contextPath}/agents/delete?name=<%= java.net.URLEncoder.encode(agent.getName(), "UTF-8") %>'">Delete</button>
    </div>
  </div>
  <% } %>
</div>
</body>
</html>
```