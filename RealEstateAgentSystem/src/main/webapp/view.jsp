```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Agent</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f5ece0; margin: 0; padding: 20px; text-align: center; }
        h2 { color: #5a4032; }
        .view-profile { background-color: #e8d8c8; padding: 20px; border-radius: 10px; display: inline-block; }
        .view-profile p { margin: 5px 0; }
    </style>
</head>
<body>
<h2>Agent Details</h2>
<div class="view-profile">
    <p><strong>Name:</strong> ${agent.name}</p>
    <p><strong>Contact Info:</strong> ${agent.contactInfo}</p>
    <p><strong>Specialties:</strong> ${agent.specialties}</p>
    <p><strong>Experience:</strong> ${agent.experienceYears} Years</p>
    <a href="${pageContext.request.contextPath}/agents">Back to Agents</a>
</div>
</body>
</html>
```