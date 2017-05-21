<%-- 
    Document   : confirmDelete
    Created on : 21-mag-2017, 9.14.18
    Author     : Andreea
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Deleting</title>
    </head>
    <body>
        <h1>Confermi di voler cancellare il tuo account?</h1>
        
        <form action="Profilo" method = "post">
                <div id ="deleteUser">
                    <button type="submit" name ="deleteAccount">Si</button>    
                </div>
        </form>
        
        <form action="Profilo" method = "post">
                <div id ="deleteUser">
                    <button type="submit" name ="noDeleteUser">No</button>    
                </div>
        </form>
    </body>
</html>
