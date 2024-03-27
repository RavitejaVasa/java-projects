<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Register User</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }
    form {
        max-width: 400px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    input[type="text"],
    input[type="number"],
    input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #007bff;
        color: #fff;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<form action="./register" method="post">
    <label for="uname">Enter user name:</label><br/>
    <input type="text" id="uname" name="uname" required><br/>
    <label for="accno">Enter user account no:</label><br/>
    <input type="number" id="accno" name="accno" required><br/>
    <label for="bal">Enter user balance:</label><br/>
    <input type="number" id="bal" name="bal" required><br/>
    <input type="submit" value="Submit"/> 
</form>

</body>
</html>
