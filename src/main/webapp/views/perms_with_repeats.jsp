<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<head>
    <title>Permutations with repetitions</title>
    <link rel="stylesheet" href="styles/universal.css">
</head>
<body>

<div class="content">
    <img src="http://localhost:8080/CombinatoricsCalculatorr_war_exploded/images/perms_with_repeats.png"><br>

    <div class="error-message">
        <p>${error}</p>
    </div>

    <form action="${pageContext.request.contextPath}/perms_with_repeats" method="post">
        <div class="container-for-buttons">
            <button class="button" id="add-form">Добавить форму</button>
            <button class="button" id="delete-button">Удалить форму</button>
            <input class="button" type="submit" value="Посчитать">
        </div>
        <br><br>

        <div id="forms">
            <label for="n">Введите n:</label>
            <input type="number" id="n" name="n" min="1" required>
            <label for="k">Введите k:</label>
            <input type="number" id="k" name="k" min="0" required><br><br>

            <div class="form-container">
                <label for="input1">Введите n1:</label>
                <input type="number" id="input1" name="input1" min="0" required>
            </div>
        </div>

    </form>

    <div class="container-for-buttons">
        <a href="calculator">go back</a>
    </div>
</div>



<script src="script.js"></script>
</body>
</html>