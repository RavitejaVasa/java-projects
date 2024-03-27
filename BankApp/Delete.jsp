<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Delete User</title>
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
        background-color: #dc3545;
        color: #fff;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #c82333;
    }
</style>
</head>
<body>

<form action="./delete" method="post">
    <label for="id">Enter user id:</label><br/>
    <input type="number" id="id" name="id" required><br/>
    <input type="submit" value="Submit"/> 
</form>

</body>
</html>
