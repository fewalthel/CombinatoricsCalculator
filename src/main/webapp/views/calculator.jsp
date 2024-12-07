<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Combinatorics Calculator</title>
    <link rel="stylesheet" href="styles/universal.css">
</head>
<body>
<div class="content">
    <h1>Simple combinatorics calculator</h1><br>
    <div class="error-message">
        <p>${error}</p>
    </div>
    <br>
    <div class="container-for-buttons">
        <a href="urn_model">Urn model</a><br>
        <a href="perms_with_repeats">Permutations with repeatitions</a><br>
    </div>
    <br><br>

    <form action="${pageContext.request.contextPath}/calculator" method="post">
        <div class="container-for-inputs">
            <select name="operation" id="operation" required>
                <option value="arrangements">Arrangements</option>
                <option value="permutations">Permutations</option>
                <option value="combinations">Combinations</option>
            </select>

            <div>
                <input type="checkbox" id="repeats" name="repeats" value="true">
                <label for="repeats">With repeatitions</label>
            </div>
        </div>
        <br><br>

        <label for="n">Input n:</label>
        <input type="number" id="n" name="n" min="0" required><br>
        <label for="k">Input k:</label>
        <input type="number" id="k" name="k" min="0" required><br><br>

        <input type="submit" class="button" value="Calculate"><br>
    </form>
</div>


</body>
</html>