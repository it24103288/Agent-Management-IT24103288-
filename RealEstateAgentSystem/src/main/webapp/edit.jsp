```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Agent</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f5ece0; margin: 0; padding: 20px; text-align: center; }
        h2 { color: #5a4032; }
        .edit-form { background-color: #e8d8c8; padding: 20px; border-radius: 10px; display: inline-block; }
        .form-group { margin: 10px; }
        input { padding: 10px; margin: 5px; border: none; border-radius: 5px; }
        button { padding: 10px 20px; background-color: #5a4032; color: white; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background-color: #3d2c22; }
    </style>
</head>
<body>
<h2>Edit Agent</h2>
<div class="edit-form">
    <form action="${pageContext.request.contextPath}/agents/edit" method="post">
        <input type="hidden" name="name" value="${agent.name}">
        <div class="form-group">
            <input type="text" name="contactInfo" value="${agent.contactInfo}" placeholder="Contact Info" required>
        </div>
        <div class="form-group">
            <input type="text" name="specialties" value="${agent.specialties}" placeholder="Specialties" required>
        </div>
        <div class="form-group">
            <input type="number" name="experienceYears" value="${agent.experienceYears}" placeholder="Experience (Years)" required>
        </div>
        <button type="submit">Update Agent</button>
    </form>
</div>
</body>
</html>
```