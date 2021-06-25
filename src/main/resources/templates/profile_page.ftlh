<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" , href="../css/style.css">
</head>
<body>
<h1>Profile</h1>
<h2>${user.username}</h2>
<h1>you have ${user.getBalance()} in your account</h1>
<div class="container my_tasks">
    <p><a href="/profile/tasks" title="My tasks">My tasks</a>.</p>
</div>
<a href="/mySubscription">MySubscriptionPage</a>
</body>
</html>