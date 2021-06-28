<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <title>Tasks</title>
</head>
<body>
<h1>Tasks</h1>
<p><a href="/profile">Профиль</a></p>
<@spring.bind "taskForm"/>
<form action="/tasks/add" method="post">
    <#--    <input type='hidden' value='${_csrf.token}' name='${_csrf.parameterName}'/>-->
    <@spring.formTextarea "taskForm.title"/>
    <@spring.formTextarea "taskForm.description"/>
    <@spring.formTextarea "taskForm.reward"/>
    <input type="submit" value="Enter">
</form>
</body>
</html>