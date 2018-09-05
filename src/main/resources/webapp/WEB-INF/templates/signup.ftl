<html>
<head>
    <#include "general.ftl">
</head>
<body>
<h1>Sign Up</h1>
<#if message??>
    <p>${message}</p>
</#if>
<form action="/signup" method='POST'>
    <table>
        <tr>
            <td>Username:</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="Sign up" /></td>
        </tr>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    </table>
</form>
</body>
</html>