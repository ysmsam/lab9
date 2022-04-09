<%-- 
    Document   : forgot
    Created on : 2022-4-8, 21:48:41
    Author     : Sheng Ming Yan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
    </head>
    <body>
        <form action="forgot" method="post">
            Email Address: <input type="text" name="email" value="${email}"><br>
            
            <input type="submit" value="Submit">
            
            <div class="alert alert-danger" role="alert">
                ${alert}
            </div>
            
        </form>
    </body>
</html>
