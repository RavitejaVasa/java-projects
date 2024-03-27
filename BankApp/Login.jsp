<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-bottom: 10px;
            font-weight: bold;
        }
        input[type="number"],
        input[type="text"],
        input[type="submit"],
        input[type="reset"] {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 5px;
            border: 1px solid #ccc;
            transition: border-color 0.3s ease;
        }
        input[type="submit"],
        input[type="reset"] {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease, color 0.3s ease;
        }
        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #0056b3;
        }
        input[type="number"]:focus,
        input[type="text"]:focus {
            border-color: #007bff;
        }
        a {
            text-align: center;
            display: block;
            color: #007bff;
            text-decoration: none;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Login Form</h2>
    <form action="./login" method="post">
        <label for="id">Enter User ID:</label>
        <input type="number" id="id" name="id" required placeholder="Enter valid id">
        <label for="name">Enter User Name:</label>
        <input type="text" id="name" name="name" required placeholder="Enter valid username">
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
    <div>
    <h4>If you dont't have a account in my Bank</h4>
    </div>
    <a href="./register.jsp">Click here to register</a>
</div>

</body>
</html>
