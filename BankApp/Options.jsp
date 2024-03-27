<%@page import="service.BankService,java.util.*, model.Customer "%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Details</title>
    <h2>WELCOME TO MY BANK</h2>
    <style>
    	
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        a {
            display: block;
            width: fit-content;
            margin: 20px auto;
            text-align: center;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<%
BankService bs = new BankService();
ArrayList<Customer> ct = bs.getallcustomer();
%>

<table>
    <tr>
        <th>Account Number</th>
        <th>Customer Name</th>
        <th>Customer Balance</th>
    </tr>
    <% 
    for(Customer s:ct)
    {
    %>
    <tr>
        <td><%=s.getAcno()%></td>
        <td><%=s.getUname()%></td>
        <td><%=s.getBalance()%></td>
    </tr>
    <%
    }
    %>
</table>
<a href ="./deposit.jsp">Deposit</a>
<a href ="./withdraw.jsp">Withdraw</a>
<a href ="./Delete.jsp">Delete</a>

</body>
</html>
