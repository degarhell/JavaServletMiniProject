<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Servlet Project</title>
    <link href="./style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="super">
    <h1>Compound Interest Calculator</h1>
    <p id="error">${error}</p>
    <div id="main">
        <form method="post">
            <div id="form1">
                <div >
                    <p>Principle Amount:$ </p>
                    <input name="moneyAmount" type="number" value="${moneyAmount}">
                </div>
                <div >
                    <p>Intrest Rate:% </p>
                    <input name="interestRate" type="number" value="interestRate">
                </div>
                <div >
                    <p>Number of Years </p>
                    <input name="numberYears" type="number" value="numberYears">
                </div>
                <div >
                    <p>Times per Year(1 to 12): </p>
                    <input name="timesPerYear" type="number" value="timesPerYear">
                </div>
            </div>
            <div id="buttonDiv">
                <button type="submit">Calculate</button>
            </div>
        </form>
        <h3>Result: ${result} </h3>
    </div>
</div>
</body>
</html>