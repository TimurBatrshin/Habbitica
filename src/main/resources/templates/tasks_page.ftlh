<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <style>
        h1 {
            font-size: 150%;
        }
    </style>
</head>
<body>
<h1>Tasks</h1>
<#list tasks as task>
    <br>
    <h1>${task.title}</h1>
    <p>${task.description}</p>
    </br>
</#list>
</body>
</html>