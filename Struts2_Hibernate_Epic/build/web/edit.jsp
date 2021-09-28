<%-- 
    Document   : Edit.jsp
    Created on : Sep 26, 2021, 10:01:19 PM
    Author     : Sasitha Munasinghe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Page</title>
    </head>
    <body>
        <h1>Edit Page</h1>
        <hr>

        <div class="container">
            <s:if test="sm !=null">
                <font color="green">
                <s:property value="sm"/>
                </font>
            </s:if>

            <s:if test="em !=null">
                <font color="red">
                <s:property value="em"/>
                </font>
            </s:if>

            
           
           
           <form action="update" method="POST">
                
              <div class="form-group">
               <select name="member.id">
                   <option value="${member.id}">${member.id}</option>
               </select>
               </div>
               <div class="form-group">
                    <label >Name :</label>
                    <input type="text" class="form-control"  name="member.name" value="${member.name}" required>
                </div>

                <div class="form-group">
                    <label >Email :</label>
                    <input type="email" class="form-control"  name="member.email" value="${member.email}" required>
                </div>

                <button type="submit" class="btn btn-primary">Update</button>
           
        </form>

            
                <br>
            <a href="list"> <button class="btn btn-success">View List</button></a>  
            <a href="cancel"> <button class="btn btn-danger">Cancel</button></a>
        </div>

    </body>
</html>
