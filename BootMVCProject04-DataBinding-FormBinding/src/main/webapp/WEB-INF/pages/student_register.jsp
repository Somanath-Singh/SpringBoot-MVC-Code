<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    <h1 style="color:red;text-align:center;">Student Registration Page</h1>
    
    
    <form page="regster" method="POST">
    <table align="center" bgcolor="cyan">
    
    <tr>
    <td>Student seriel no:</td>
    <td><input type="text" name="sno"></td>
    </tr>
    
    <tr>
    <td>Student name:</td>
    <td><input type="text" name="sname"></td>
    </tr>
    
    <tr>
    <td>Student address:</td>
    <td><input type="text" name="saddrs"></td>
    </tr>
    
    <tr>
    <td>Student avg:</td>
    <td><input type="text" name="avg"></td>
    </tr>
    
    <tr>
    <td colspan="2"><input type="submit" value="register"></td>
    </tr>
    
    </table>
    </form>