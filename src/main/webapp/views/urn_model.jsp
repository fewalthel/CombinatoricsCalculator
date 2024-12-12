<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Urn model</title>
    <link rel="stylesheet" href="styles/universal.css">
</head>
<body>

<div class="content">
    <img src="http://localhost:8080/CombinatoricsCalculatorr_war_exploded/images/urn_formula.png"><br><br><br>

    <div class="error-message">
        <p>${error}</p>
    </div>

    <form action="${pageContext.request.contextPath}/urn_model" method="post">
        <label for="n">Input n:</label>
        <input type="number" id="n" name="n" min="1" required><br>
        <label for="k">Input k:</label>
        <input type="number" id="k" name="k" min="0" required><br>
        <label for="r">Input r:</label>
        <input type="number" id="r" name="r" min="0" required><br>
        <label for="m">Input m:</label>
        <input type="number" id="m" name="m" min="0" required><br>
        <br>
        <input type="submit" class="button" value="Calculate">
    </form>
    <div class="container-for-buttons">
        <a href="calculator">go back</a>
    </div>
</body>
</html>